package com.mzx.service;

import com.github.pagehelper.PageInfo;
import com.mzx.pojo.Team;
import com.mzx.vo.QueryVO;

import java.util.List;

public interface TeamService {
    public PageInfo<Team> queryByPage(Integer pageNum, Integer pageSize, QueryVO queryVo);

    boolean deleteById(Integer id);

    boolean addTeam(Team team);

    Team selectById(Integer teamId);

    boolean updateTeam(Team team);

    List<Team> getIdAndChineseName();


    boolean addTeamLogo(String name, Integer teamId);
}
