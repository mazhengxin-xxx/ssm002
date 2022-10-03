package com.mzx.web.controller;

import com.github.pagehelper.PageInfo;
import com.mzx.pojo.Game;
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
public class GameController {
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        //提交更新，精确到秒
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @Resource
    private GameService gameService;
    @RequestMapping("/list")
    public ResultVO<GameVO> gameList(Integer pageNum, Integer pageSize, QueryGameVO vo){
        if (pageNum==null || pageNum<=0){
            pageNum=1;
        }if (pageSize==null || pageSize<=0){
            pageSize=5;
        }
        PageInfo<GameVO> info=gameService.queryByPage(pageNum,pageSize,vo);
        return new ResultVO<GameVO>(info);
    }

    @DeleteMapping("/{id}")
    public ResultVO deleteById(@PathVariable("id")Integer id){
        boolean flag=gameService.deleteById(id);
        if (flag){
            return new ResultVO();
        }else {
            return new ResultVO(500,"删除失败");
        }
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultVO addGame(Game game){
        boolean flag=gameService.addGame(game);
        if (flag){
            return new ResultVO();
        }else{
            return new ResultVO(500,"添加失败");
        }
    }

    @RequestMapping("/{id}")
    public ResultVO selectById(@PathVariable("id")Integer id){
        Game game=gameService.selectById(id);
        return new ResultVO(game);
    }

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
