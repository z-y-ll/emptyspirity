package cn.emptyspirit.service;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/27 23:15
 * @Version 1.0
 */

public interface SongService {
    /**
     * 根据类型类查找歌曲
     * @param songtype
     * @return
     */
    List getSongByType(String  songtype) throws Exception;
}
