package cn.emptyspirit.service;

import cn.emptyspirit.mapper.SongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zyll
 * @Date: 2019/12/27 23:15
 * @Version 1.0
 */
@Service
public class SongService {
    private SongMapper songMapper;

    @Autowired
    public SongService(SongMapper songMapper){
        this.songMapper = songMapper;
    }

    /**
     * 根据类型来查找所有符合的歌曲
     * @param songtype
     * @return
     */
    public List getSongByType(String songtype){
        Map<String, String> columnMap = new HashMap<>();
        columnMap.put("song_type", songtype);
        return songMapper.selectByMap((Map)columnMap);
    }
}
