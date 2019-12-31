package cn.emptyspirit.service;

import cn.emptyspirit.entity.SongList;

import javax.print.attribute.IntegerSyntax;
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

    /**
     * 根据id查询歌单
     * @param songlistid
     * @return
     * @throws Exception
     */
    SongList getSongListById(Integer songlistid) throws Exception;
}
