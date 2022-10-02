package com.mzx.mapper;

import com.mzx.pojo.Game;
import com.mzx.pojo.GameExample;
import java.util.List;

import com.mzx.vo.GameVO;
import com.mzx.vo.QueryGameVO;
import org.apache.ibatis.annotations.Param;

public interface GameMapper {
    int countByExample(GameExample example);

    int deleteByExample(GameExample example);

    int deleteByPrimaryKey(Integer gameId);

    int insert(Game record);

    int insertSelective(Game record);

    List<Game> selectByExample(GameExample example);

    Game selectByPrimaryKey(Integer gameId);

    int updateByExampleSelective(@Param("record") Game record, @Param("example") GameExample example);

    int updateByExample(@Param("record") Game record, @Param("example") GameExample example);

    int updateByPrimaryKeySelective(Game record);

    int updateByPrimaryKey(Game record);

    List<GameVO> selectByPage(QueryGameVO vo);
}
