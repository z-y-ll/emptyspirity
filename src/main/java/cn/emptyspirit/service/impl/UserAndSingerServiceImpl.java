package cn.emptyspirit.service.impl;

import cn.emptyspirit.entity.Singer;
import cn.emptyspirit.entity.User;
import cn.emptyspirit.entity.UserAndSinger;
import cn.emptyspirit.exception.ParamException;
import cn.emptyspirit.mapper.SingerMapper;
import cn.emptyspirit.mapper.UserAndSingerMapper;
import cn.emptyspirit.mapper.UserMapper;
import cn.emptyspirit.service.UserAndSingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserAndSingerServiceImpl implements UserAndSingerService {

    private UserAndSingerMapper userAndSingerMapper;
    private SingerMapper singerMapper;
    private UserMapper userMapper;

    @Autowired
    public UserAndSingerServiceImpl(UserAndSingerMapper userAndSingerMapper, SingerMapper singerMapper, UserMapper userMapper) {
        this.userAndSingerMapper = userAndSingerMapper;
        this.singerMapper = singerMapper;
        this.userMapper = userMapper;
    }


    /**
     * 用户关注歌手
     * @param singerId 歌手id
     * @param userId 用户id
     * @return
     */
    @Override
    public Integer addFollowSinger(Integer singerId, Integer userId) throws Exception {
        if (singerId == null || userId == null) {
            throw new ParamException();
        }

        // 判断歌手是否存在
        Singer singer = singerMapper.selectById(singerId);
        if (singer == null) {
            throw new ParamException("歌手信息异常");
        }

        // 判断用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户信息异常");
        }

        // 判断用户是否已经关注过此歌手，若已经关注，则不可重复关注
        UserAndSinger userAndSinger =
                userAndSingerMapper.selectBySingerIdAndUserId(singerId, userId);
        if (userAndSinger != null) {
            throw new ParamException("请勿重复关注歌手");
        }

        // 封装一条记录，并插入数据库
        userAndSinger = new UserAndSinger();
        userAndSinger.setSingerId(singerId);
        userAndSinger.setUserId(userId);
        return userAndSingerMapper.insert(userAndSinger);
    }


    /**
     * 用户通过歌手id，取消关注某歌手
     * @param singerId
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public Integer deleteFollowSingerBySingerId(Integer singerId, Integer userId) throws Exception {
        if (singerId == null || userId == null) {
            throw new ParamException();
        }

        // 判断歌手是否存在
        Singer singer = singerMapper.selectById(singerId);
        if (singer == null) {
            throw new ParamException("歌手信息异常");
        }

        // 判断用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户信息异常");
        }

        // 判断用户是否关注此歌手
        UserAndSinger userAndSinger =
                userAndSingerMapper.selectBySingerIdAndUserId(singerId, userId);
        if (userAndSinger == null) {
            throw new ParamException("您未关注此歌手");
        }

        // 删除关注记录
        return userAndSingerMapper.deleteById(userAndSinger.getId());
    }


    /**
     * 获取用户关注的所有歌手
     * @param userId 用户id
     * @return
     * @throws Exception
     */
    @Override
    public List<Singer> selectFollowSingersByUserId(Integer userId) throws Exception {
        if (userId == null) {
            throw new ParamException();
        }

        // 判断用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户信息异常");
        }

        // 查询用户关注的所有歌手
        return userAndSingerMapper.selectFollowSingersByUserId(userId);
    }
}
