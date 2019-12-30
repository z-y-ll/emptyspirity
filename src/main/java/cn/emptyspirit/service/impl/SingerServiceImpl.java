package cn.emptyspirit.service.impl;

import cn.emptyspirit.entity.Singer;
import cn.emptyspirit.mapper.SingerMapper;
import cn.emptyspirit.service.SingerService;
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
    @Cacheable(cacheNames = {"singers"})
    public List<Singer> getSingers() throws Exception {
        return singerMapper.selectList(Wrappers.emptyWrapper());
    }

    /**
     * 根据歌手的名称来查询歌手
     *
     * @return
     * @throws Exception
     */
    @Override
    public Singer getSingerByName(String singerName) throws Exception {
        return singerMapper.selectOne(Wrappers.<Singer>lambdaQuery().eq(Singer::getSingerName, singerName));
    }
}
