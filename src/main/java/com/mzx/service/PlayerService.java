package com.mzx.service;

import com.github.pagehelper.PageInfo;
import com.mzx.pojo.Player;
import com.mzx.vo.PlayerVO;
import com.mzx.vo.QueryPlayerVO;

public interface PlayerService {
    PageInfo<PlayerVO> selectByPage(Integer pageNum, Integer pageSize, QueryPlayerVO vo);

    boolean addPlay(Player player);

    boolean deleteById(Integer id);

    Player selectById(Integer teamId);

    boolean updateById(Player player);
}
