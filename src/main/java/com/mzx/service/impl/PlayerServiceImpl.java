package com.mzx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mzx.mapper.PlayerMapper;
import com.mzx.pojo.Player;
import com.mzx.service.PlayerService;
import com.mzx.vo.PlayerVO;
import com.mzx.vo.QueryPlayerVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Resource
    private PlayerMapper playerMapper;

    @Override
    public PageInfo<PlayerVO> selectByPage(Integer pageNum, Integer pageSize, QueryPlayerVO vo) {


        PageHelper.startPage(pageNum,pageSize);
        List<PlayerVO> list = playerMapper.selectByPage(vo);
        PageInfo<PlayerVO> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public boolean addPlay(Player player) {
        player.setIsDel(0);
        int insert = playerMapper.insert(player);
        if (insert==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        Player player = playerMapper.selectByPrimaryKey(id);
        player.setIsDel(1);
        int i = playerMapper.updateByPrimaryKey(player);
        if (i==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Player selectById(Integer teamId) {
        Player player = playerMapper.selectByPrimaryKey(teamId);
        return player;
    }

    @Override
    public boolean updateById(Player player) {
        player.setIsDel(0);
        int i = playerMapper.updateByPrimaryKey(player);
        if (i==1){
            return  true;
        }else {
            return false;
        }
    }
}
