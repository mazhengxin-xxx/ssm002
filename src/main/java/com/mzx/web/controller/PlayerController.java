package com.mzx.web.controller;

import com.github.pagehelper.PageInfo;
import com.mzx.pojo.Player;
import com.mzx.pojo.Team;
import com.mzx.service.PlayerService;
import com.mzx.vo.PlayerVO;
import com.mzx.vo.QueryPlayerVO;
import com.mzx.vo.ResultVO;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/player")
//@Api(tags = "球员接口")
public class PlayerController {
    @Resource
    private PlayerService playerService;


//    @ApiOperation(value = "条件查询球员",notes = "根据条件查找球员")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @RequestMapping(value = "/list",method = RequestMethod.GET)
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
//    @ApiOperation(value = "添加球员",notes = "添加球员")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
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
//    @ApiOperation(value = "删除球员",notes = "根据id删除球员")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
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
//    @ApiOperation(value = "id查询球员",notes = "根据id查找球员")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResultVO<Player> queryById(@PathVariable("id")Integer teamId){
        Player player=playerService.selectById(teamId);
        return new ResultVO<>(player);
    }

    //修改
//    @ApiOperation(value = "修改球员",notes = "根据id修改球员")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
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
