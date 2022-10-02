package com.mzx.service;

import com.github.pagehelper.PageInfo;
import com.mzx.pojo.Game;
import com.mzx.vo.GameVO;
import com.mzx.vo.QueryGameVO;

public interface GameService {

    PageInfo<GameVO> queryByPage(Integer pageNum, Integer pageSize, QueryGameVO vo);

    boolean deleteById(Integer id);

    boolean addGame(Game game);

    Game selectById(Integer id);

    boolean updateGame(Game game);
}
