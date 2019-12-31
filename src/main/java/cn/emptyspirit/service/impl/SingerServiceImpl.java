package cn.emptyspirit.service.impl;

import cn.emptyspirit.entity.Singer;
import cn.emptyspirit.exception.ParamException;
import cn.emptyspirit.mapper.SingerMapper;
import cn.emptyspirit.service.SingerService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/29 15:07
 * @Version 1.0
 */
@Service
public class SingerServiceImpl implements SingerService {
    private final SingerMapper singerMapper;

    @Autowired
    public SingerServiceImpl(SingerMapper singerMapper){
        this.singerMapper = singerMapper;
    }

    /**
     * 查询所有的歌手
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Singer> getSingersById() throws Exception {
        return singerMapper.selectList(Wrappers.<Singer>lambdaQuery());
    }

    /**
     * 根据受欢迎度查询歌手
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Singer> getSingersByLike() throws Exception {
        return singerMapper.getSingsByLike();
    }

    /**
     * 根据歌手的id来查询歌手
     *
     * @return
     * @throws Exception
     */
    @Override
    public Singer getSingerByName(String singerId) throws Exception {
        return singerMapper.selectById(singerId);
    }

    /**
     * 根据姓名模糊查询歌手
     *
     * @param singername
     * @return
     * @throws Exception
    @Override
    public List<Singer> getSingersLikeName(String singername) throws Exception {
        if (singername == null){
            throw new ParamException();
        }
        Wrapper<Singer> wrapper = Wrappers.<Singer>lambdaQuery().like(Singer::getSingerName, singername);
        return singerMapper.selectList(wrapper);
    }
    */
}
