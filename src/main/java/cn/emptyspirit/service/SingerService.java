package cn.emptyspirit.service;

import cn.emptyspirit.entity.Singer;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/29 15:05
 * @Version 1.0
 */
public interface SingerService {
    /**
     * 查询所有的歌手
     * @return
     * @throws Exception
     */
    List<Singer> getSingers() throws Exception;

    /**
     * 根据歌手的名称来查询歌手
     * @param singerName
     * @return
     * @throws Exception
     */
    Singer getSingerByName(String singerName) throws Exception;
}
