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
     * 查询所有的歌手(默认顺序)
     * @return
     * @throws Exception
     */
    List<Singer> getSingersById() throws Exception;

    /**
     * 根据受欢迎度查询歌手
     * @return
     * @throws Exception
     */
    List<Singer> getSingersByLike() throws Exception;
    /**
     * 根据歌手的id来查询歌手
     * @param singerId
     * @return
     * @throws Exception
     */
    Singer getSingerByName(String singerId) throws Exception;

    /**
     * 根据姓名模糊查询歌手
     * @param singername
     * @return
     * @throws Exception
    List<Singer> getSingersLikeName(String singername) throws Exception;
    */
}
