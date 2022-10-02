package com.mzx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mzx.mapper.TeamMapper;
import com.mzx.pojo.Team;
import com.mzx.pojo.TeamExample;
import com.mzx.service.TeamService;
import com.mzx.vo.QueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Resource
    private TeamMapper teamMapper;

    //929上午十点五十九  看陈的gitee
    //传参是queryvo 返回pageinfo泛型team

    //返回的是泛型是team类型
    @Override
    public PageInfo<Team> queryByPage(Integer pageNum, Integer pageSize, QueryVO vo) {
        TeamExample example = new TeamExample();
        //criteria 给example 加上条件   example有了修饰
        TeamExample.Criteria criteria = example.createCriteria();

        if(vo!=null){
            if (vo.getTeamName()!=null && !"".equals(vo.getTeamName().trim())){

                criteria.andTeamNameLike("%"+vo.getTeamName()+"%");
            }
            if (vo.getChineseName()!=null && !"".equals(vo.getChineseName().trim())){
                criteria.andChineseNameLike("%"+vo.getChineseName()+"%");
            }
            if (vo.getCoach()!=null && !"".equals(vo.getCoach().trim())){
                criteria.andCoachLike("%"+vo.getCoach()+"%");
            }
            if (vo.getBeginDate()!=null){
                criteria.andCreateTimeGreaterThan(vo.getBeginDate());
            }
            if (vo.getEndDate()!=null){
                criteria.andCreateTimeLessThan(vo.getEndDate());
            }
            if (vo.getArea()!=null &&vo.getArea()!=-1){
                criteria.andAreaEqualTo(vo.getArea());
            }
        }

        PageHelper.startPage(pageNum,pageSize);
        List<Team> list = teamMapper.selectByExample(example);
        PageInfo<Team> info =new PageInfo<Team>(list);

        return info;
    }

    @Override
    public boolean deleteById(Integer id) {
        boolean flag=true;
        Team team = teamMapper.selectByPrimaryKey(id);
        team.setIsDel(1);
        int i = teamMapper.updateByPrimaryKeySelective(team);
        if (i==1){
            flag=true;
        }else{
            flag=false;
        }
        return flag;
    }

    @Override
    public boolean addTeam(Team team) {
        boolean flag=true;
        team.setIsDel(0);
        int insert = teamMapper.insert(team);
        if (insert==1){
            flag=true;
        }else{
            flag=false;
        }
        return flag;
    }

    @Override
    public Team selectById(Integer teamId) {
        Team team = teamMapper.selectByPrimaryKey(teamId);
        return team;
    }

    @Override
    public boolean updateTeam(Team team) {
        team.setIsDel(0);//防止没有
        int i = teamMapper.updateByPrimaryKey(team);
        if (i==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Team> getIdAndChineseName() {
        List<Team> list = teamMapper.getIdAndChineseName();
        return list;
    }

}
