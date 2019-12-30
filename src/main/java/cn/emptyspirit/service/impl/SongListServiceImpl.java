package cn.emptyspirit.service.impl;

import cn.emptyspirit.entity.SongList;
import cn.emptyspirit.mapper.SongListMapper;
import cn.emptyspirit.service.SongListService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/29 19:21
 * @Version 1.0
 */
@Service
public class SongListServiceImpl implements SongListService {
    private final SongListMapper songListMapper;

    @Autowired
    public SongListServiceImpl(SongListMapper songListMapper) {
        this.songListMapper = songListMapper;
    }


    /**
     * 获取所有的歌单,根据喜好降序排序
     *
     * @return
     * @throws Exception
     */
    @Override
    @Cacheable(cacheNames = "songlists")
    public List<SongList> getSongLists() throws Exception {
        return songListMapper.selectList(Wrappers.<SongList>lambdaQuery().orderByDesc(SongList::getLikeNumbers));
    }
}
