package cn.emptyspirit.service;

import cn.emptyspirit.entity.SongList;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/29 19:21
 * @Version 1.0
 */
public interface SongListService {
    /**
     * 获取所有的歌单
     * @return
     * @throws Exception
     */
    List<SongList> getSongLists() throws Exception;
}
