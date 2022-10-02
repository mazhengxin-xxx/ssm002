package com.mzx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mzx.mapper.GameMapper;
import com.mzx.mapper.TeamMapper;
import com.mzx.pojo.Game;
import com.mzx.pojo.GameExample;
import com.mzx.service.GameService;
import com.mzx.vo.GameVO;
import com.mzx.vo.QueryGameVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Resource
    private GameMapper gameMapper;
//    @Resource
//    private TeamMapper teamMapper;
//   @Override
//    public PageInfo<Game> queryByPage(Integer pageNum, Integer pageSize, QueryGameVO vo) {
//       GameExample example=new GameExample();
//       GameExample.Criteria criteria = example.createCriteria();
//       if (vo!=null){
//           if (vo.getChineseName()!=null&& !"".equals(vo.getChineseName().trim())){
//              int i= teamMapper.getIdByName(vo.getChineseName());
//                criteria.andHomeTeamIdEqualTo(i);
//                criteria.andVisitingTeamIdEqualTo(i);
//           }
//           if (vo.getBeginDate()!=null){
//               criteria.andGameDateGreaterThan(vo.getBeginDate());
//           }
//           if (vo.getEndDate()!=null){
//               criteria.andGameDateLessThan(vo.getEndDate());
//           }
//           if (0<vo.getTypeId()&&vo.getTypeId()<6){
//               criteria.andTypeIdEqualTo(vo.getTypeId());
//           }
//       }
//        PageHelper.startPage(pageNum,pageSize);
//        List<Game> list = gameMapper.selectByExample(example);
//        PageInfo<Game> info=new PageInfo<>(list);
//        return info;
//    }

    @Override
    public PageInfo<GameVO> queryByPage(Integer pageNum, Integer pageSize, QueryGameVO vo) {

        PageHelper.startPage(pageNum,pageSize);
        List<GameVO> list = gameMapper.selectByPage(vo);
        PageInfo<GameVO> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public boolean deleteById(Integer id) {
        Game game = gameMapper.selectByPrimaryKey(id);
        game.setIsDel(1);
        int i = gameMapper.updateByPrimaryKey(game);
        if (i==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean addGame(Game game) {
        game.setIsDel(0);
        int insert = gameMapper.insert(game);
        if (insert==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Game selectById(Integer id) {
        Game game = gameMapper.selectByPrimaryKey(id);
        return game;
    }

    @Override
    public boolean updateGame(Game game) {
        game.setIsDel(0);
        int i = gameMapper.updateByPrimaryKey(game);
        if (i==1){
            return true;
        }else{
            return false;
        }
    }


}
