package com.mzx.web.controller;

import com.github.pagehelper.PageInfo;
import com.mzx.pojo.Team;
import com.mzx.service.TeamService;
import com.mzx.vo.QueryVO;
import com.mzx.vo.ResultVO;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/team")
//@Api(tags = "球队接口")
public class TeamController {

    @Resource
    private TeamService teamService;

//    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder){
//        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
//    }
//    @ApiOperation(value = "条件查询球队",notes = "根据条件查找球队")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultVO<Team> teamList(Integer pageNum,Integer pageSize,QueryVO vo){
        if (pageNum==null || pageNum<=0){
            pageNum=1;
        }if (pageSize==null || pageSize<=0){
            pageSize=4;
        }
        PageInfo<Team> info = teamService.queryByPage(pageNum, pageSize, vo);
        return new ResultVO<>(info);

    }


//    @ApiOperation(value = "删除球队",notes = "按照id删除球队")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @DeleteMapping("/{id}")
    public ResultVO<Team> deleteById(@PathVariable("id")Integer id){//id成了Id
        boolean flag=teamService.deleteById(id);
        if (flag){
            return new ResultVO();
        }else{
            return new ResultVO<>(500,"删除失败内部异常");
        }
    }


//    @ApiOperation(value = "id查询球队",notes = "根据id查找球队")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @RequestMapping(value = "/{teamId}",method = RequestMethod.GET)
    public ResultVO<Team> queryById(@PathVariable("teamId")Integer teamId){
        Team team=teamService.selectById(teamId);
        return new ResultVO<Team>(team);
    }



//    @ApiOperation(value = "修改球队",notes = "根据id修改球队")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @PutMapping("/{teamId}")
    public ResultVO updateTeam(@PathVariable("teamId")Integer teamId,Team team){// 没加注解teamId收到了
        //System.out.println(team.getTeamId());
        //team.setTeamId(teamId);
        boolean flag=teamService.updateTeam(team);
        if (flag){
            return new ResultVO();
        }else{
            return new ResultVO(500,"更新失败");
        }
    }

//    @ApiOperation(value = "添加球队",notes = "添加球队")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @PostMapping("/")
    public ResultVO addTeam(Team team){
        boolean flag=teamService.addTeam(team);
        if (flag){
            return new ResultVO();
        }else {
            return new ResultVO(500,"添加失败");
        }
    }

//    @ApiOperation(value = "查询球队id和中文名",notes = "查找球队id和中文名")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class),
//            @ApiResponse(code=500,message = "权限不足",response = Team.class)
//    })
    @RequestMapping(value = "/getIdAndChineseName",method = RequestMethod.GET)
    public ResultVO getIdAndChineseName(){
        List<Team> list=teamService.getIdAndChineseName();
        return new ResultVO(list);
    }


//    @ApiOperation(value = "文件上传",notes = "文件上传")
//    @ApiResponses({
//            @ApiResponse(code=200,message = "返回成功",response = Team.class),
//            @ApiResponse(code=400,message = "参数没填对",response = Team.class)
//    })
    //上传logo，post请求   uploadUrl:"/team/"+teamId, //接受请求地址
    @PostMapping("/{teamId}")
    public ResultVO<Team> uploadImg(@RequestParam("logo") MultipartFile file, HttpServletRequest request,@PathVariable("teamId")Integer teamId) throws IOException {
        //System.out.println(file.getOriginalFilename());
        String name= UUID.randomUUID().toString().replace("-","")+file.getOriginalFilename();
        //System.out.println(name);
        String path= request.getServletContext().getRealPath("img/uploadFile");
        //System.out.println(path);
        File file1=new File(path,name);
        file.transferTo(file1);
        //将文件写入本地   再把路径保存到数据库
        boolean flag=teamService.addTeamLogo(name,teamId);
        if (flag){
            return new ResultVO<>();
        }else{
            return new ResultVO<>(500,"上传失败");
        }
    }


}
