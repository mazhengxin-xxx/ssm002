package com.mzx.web.controller;

import com.github.pagehelper.PageInfo;
import com.mzx.pojo.Player;
import com.mzx.service.PlayerService;
import com.mzx.vo.PlayerVO;
import com.mzx.vo.QueryPlayerVO;
import com.mzx.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Resource
    private PlayerService playerService;

    @RequestMapping("/list")
    public ResultVO<PlayerVO> PlayerList(Integer pageNum, Integer pageSize, QueryPlayerVO vo){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        if (pageSize==null||pageSize<=0){
            pageSize=5;
        }
        PageInfo<PlayerVO> info=playerService.selectByPage(pageNum,pageSize,vo);
        return new ResultVO<PlayerVO>(info);
    }

    //添加
    @PostMapping("/")
    public ResultVO addPlayer(Player player){
        boolean flag=playerService.addPlay(player);
        if (flag){
            return new ResultVO();
        }else{
            return new ResultVO(500,"添加失败");
        }
    }

    //删除
    @DeleteMapping("/{playerId}")
    public ResultVO deleteById(@PathVariable("playerId")Integer id){
        boolean flag = playerService.deleteById(id);
        if (flag){
            return  new ResultVO();
        }else{
            return new ResultVO(500,"删除失败");
        }
    }

    //查询某id
    @RequestMapping("/{id}")
    public ResultVO<Player> queryById(@PathVariable("id")Integer teamId){
        Player player=playerService.selectById(teamId);
        return new ResultVO<>(player);
    }

    //修改
    @PutMapping("/{playerId}")
    public ResultVO updateById(Player player){
            boolean flag=playerService.updateById(player);
            if (flag){
                return new ResultVO();
            }else {
                return new ResultVO(500,"修改失败");
            }
    }
}
