package com.mzx.web.controller;

import com.github.pagehelper.PageInfo;
import com.mzx.pojo.Team;
import com.mzx.service.TeamService;
import com.mzx.vo.QueryVO;
import com.mzx.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//929日  11.30
/*
控制器 list方法的编写 一些个注解@RequestParam
先排除  pagenum  pagesize 的情况
再查找     pageinfo
在返回东西里时间     @JsonFormat(格式时区)

 */
@RestController
@RequestMapping("/team")
public class TeamController {

    @Resource
    private TeamService teamService;

//    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder){
//        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
//    }

    @RequestMapping("/list")
    public ResultVO<Team> teamList(Integer pageNum,Integer pageSize,QueryVO vo){
        if (pageNum==null || pageNum<=0){
            pageNum=1;
        }if (pageSize==null || pageSize<=0){
            pageSize=4;
        }
        PageInfo<Team> info = teamService.queryByPage(pageNum, pageSize, vo);
        return new ResultVO<>(info);

    }

    @DeleteMapping("/{id}")
    public ResultVO<Team> deleteById(@PathVariable("id")Integer id){//id成了Id
        boolean flag=teamService.deleteById(id);
        if (flag){
            return new ResultVO();
        }else{
            return new ResultVO<>(500,"删除失败内部异常");
        }
    }

    @RequestMapping("/{teamId}")
    public ResultVO<Team> queryById(@PathVariable("teamId")Integer teamId){
        Team team=teamService.selectById(teamId);
        return new ResultVO<Team>(team);
    }

    @PutMapping("/{teamId}")
    public ResultVO updateTeam(Team team){
        boolean flag=teamService.updateTeam(team);
        if (flag){
            return new ResultVO();
        }else{
            return new ResultVO(500,"更新失败");
        }
    }


    @PostMapping("/")
    public ResultVO addTeam(Team team){
        boolean flag=teamService.addTeam(team);
        if (flag){
            return new ResultVO();
        }else {
            return new ResultVO(500,"添加失败");
        }
    }


    @RequestMapping("/getIdAndChineseName")
    public ResultVO getIdAndChineseName(){
        List<Team> list=teamService.getIdAndChineseName();
        return new ResultVO(list);
    }




}
