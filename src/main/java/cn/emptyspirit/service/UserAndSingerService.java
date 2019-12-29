package cn.emptyspirit.service;

import cn.emptyspirit.entity.Singer;
import cn.emptyspirit.globel.R;

import java.util.List;

public interface UserAndSingerService {

    /**
     * 用户关注歌手
     * @param singerId 歌手id
     * @param userId 用户id
     * @return
     */
    Integer addFollowSinger(Integer singerId, Integer userId) throws Exception;


    /**
     * 用户通过歌手id，取消关注某歌手
     * @param singerId
     * @param userId
     * @return
     * @throws Exception
     */
    Integer deleteFollowSingerBySingerId(Integer singerId, Integer userId) throws Exception;


    /**
     * 获取用户关注是所有歌手
     * @param userId 用户id
     * @return
     * @throws Exception
     */
    List<Singer> selectFollowSingersByUserId(Integer userId) throws Exception;
}
