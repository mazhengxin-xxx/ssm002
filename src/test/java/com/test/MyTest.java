package com.test;

import com.github.pagehelper.PageInfo;
import com.mzx.pojo.Team;
import com.mzx.service.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//不扫mybatis包  都写全名
@ContextConfiguration(locations = {"classpath:applicationContext_dao.xml","classpath:applicationContext_service.xml"})
public class MyTest {
//      管理员列表
//    @Resource
//    AdminsService adminsService;
//    @Test
//    public void test(){
//        List<Admins> list= (List<Admins>) adminsService.getAll();
//        list.forEach(admins -> System.out.println(admins));
//    }
    @Resource
    TeamService teamService;
    @Test
    public void test(){
        PageInfo<Team> teamPageInfo = teamService.queryByPage(1, 2, null);
        System.out.println(teamPageInfo);
    }
}
