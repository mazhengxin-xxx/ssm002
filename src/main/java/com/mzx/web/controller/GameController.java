package com.mzx.web.controller;

import com.github.pagehelper.PageInfo;
import com.mzx.pojo.Game;
import com.mzx.pojo.Team;
import com.mzx.service.GameService;
import com.mzx.vo.GameVO;
import com.mzx.vo.QueryGameVO;
import com.mzx.vo.ResultVO;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/game")
//@Api(tags="比赛记录接口")


public class GameController {
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        //提交更新，精确到秒
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @Resource
    private GameService gameService;

//    @ApiOperation(value = "条件查询比赛记录",notes = "根据条件查找比赛记录")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultVO<GameVO> gameList(Integer pageNum, Integer pageSize, QueryGameVO vo){
        if (pageNum==null || pageNum<=0){
            pageNum=1;
        }if (pageSize==null || pageSize<=0){
            pageSize=5;
        }
        PageInfo<GameVO> info=gameService.queryByPage(pageNum,pageSize,vo);
        return new ResultVO<GameVO>(info);
    }


//    @ApiOperation(value = "删除比赛记录",notes = "根据id删除比赛记录")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @DeleteMapping("/{id}")
    public ResultVO deleteById(@PathVariable("id")Integer id){
        boolean flag=gameService.deleteById(id);
        if (flag){
            return new ResultVO();
        }else {
            return new ResultVO(500,"删除失败");
        }
    }

//    @ApiOperation(value = "添加比赛记录",notes = "添加比赛记录")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultVO addGame(Game game){
        boolean flag=gameService.addGame(game);
        if (flag){
            return new ResultVO();
        }else{
            return new ResultVO(500,"添加失败");
        }
    }


//    @ApiOperation(value = "id查询比赛记录",notes = "根据id查询比赛记录")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResultVO selectById(@PathVariable("id")Integer id){
        Game game=gameService.selectById(id);
        return new ResultVO(game);
    }

//    @ApiOperation(value = "修改比赛记录",notes = "根据id修改比赛记录")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @RequestMapping(value = "/{gameId}",method = RequestMethod.PUT)
    public ResultVO updateGame(Game game){
        boolean flag=gameService.updateGame(game);
        if (flag){
            return new ResultVO();
        }else{
           return new ResultVO(500,"更新失败");
        }
    }

}
