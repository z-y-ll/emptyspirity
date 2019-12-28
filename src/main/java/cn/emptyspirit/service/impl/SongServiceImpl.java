package cn.emptyspirit.service.impl;

import cn.emptyspirit.mapper.SongMapper;
import cn.emptyspirit.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zyll
 * @Date: 2019/12/28 0:00
 * @Version 1.0
 */
@Service
public class SongServiceImpl implements SongService {
    private SongMapper songMapper;

    @Autowired
    public SongServiceImpl(SongMapper songMapper) {
        this.songMapper = songMapper;

    }
    /**
     * 根据类型来查找所有符合的歌曲
     * @param songtype
     * @return
     */
    @Override
    @SuppressWarnings("unchecked") // 解决强转警告
    public List getSongByType(String songtype){
        Map<String, String> columnMap = new HashMap<>();
        columnMap.put("song_type", songtype);
        return songMapper.selectByMap((Map)columnMap);
    }
}

