package com.mzx.mapper;

import com.mzx.pojo.Player;
import com.mzx.pojo.PlayerExample;
import java.util.List;

import com.mzx.vo.PlayerVO;
import com.mzx.vo.QueryPlayerVO;
import org.apache.ibatis.annotations.Param;

public interface PlayerMapper {
    int countByExample(PlayerExample example);

    int deleteByExample(PlayerExample example);

    int deleteByPrimaryKey(Integer playerId);

    int insert(Player record);

    int insertSelective(Player record);

    List<Player> selectByExample(PlayerExample example);

    Player selectByPrimaryKey(Integer playerId);

    int updateByExampleSelective(@Param("record") Player record, @Param("example") PlayerExample example);

    int updateByExample(@Param("record") Player record, @Param("example") PlayerExample example);

    int updateByPrimaryKeySelective(Player record);

    int updateByPrimaryKey(Player record);

    List<PlayerVO> selectByPage(QueryPlayerVO vo);
}
