package cn.emptyspirit.service.impl;

import cn.emptyspirit.entity.SongList;
import cn.emptyspirit.entity.User;
import cn.emptyspirit.entity.UserAndSongList;
import cn.emptyspirit.entity.expand.SongListExpand;
import cn.emptyspirit.exception.ParamException;
import cn.emptyspirit.mapper.SongListMapper;
import cn.emptyspirit.mapper.UserAndSongListMapper;
import cn.emptyspirit.mapper.UserMapper;
import cn.emptyspirit.service.UserAndSongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserAndSongListServiceImpl implements UserAndSongListService {

    private SongListMapper songListMapper;
    private UserMapper userMapper;
    private UserAndSongListMapper userAndSongListMapper;

    @Autowired
    public UserAndSongListServiceImpl(SongListMapper songListMapper, UserMapper userMapper, UserAndSongListMapper userAndSongListMapper) {
        this.songListMapper = songListMapper;
        this.userMapper = userMapper;
        this.userAndSongListMapper = userAndSongListMapper;
    }


    /**
     * 根据歌单id收藏歌单
     * @param songListId
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public Integer addFavoriteSongList(Integer songListId, Integer userId) throws Exception {
        if (songListId == null || userId == null) {
            throw new ParamException();
        }

        // 判断歌单是否存在
        SongList songList = songListMapper.selectById(songListId);
        if (songList == null) {
            throw new ParamException("歌单信息异常");
        }

        // 判断用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户信息异常");
        }

        // 判断用户是否已经收藏此歌单
        UserAndSongList userAndSongList =
                userAndSongListMapper.selectBySongListIdAndUserId(songListId, userId);
        // 若用户已经收藏此歌单，则提示此操作为取消收藏
        if (userAndSongList != null) {
            // 更新歌单的收藏量
            songList.setLikeNumbers(songList.getLikeNumbers() - 1);
            songListMapper.updateById(songList);
            // 删除这条关注记录
            userAndSongListMapper.deleteById(userAndSongList.getId());
            return 1;   // 表示取消收藏
        }

        // 更新歌单的收藏量
        songList.setLikeNumbers(songList.getLikeNumbers() + 1);
        songListMapper.updateById(songList);

        // 封装收藏记录，并插入数据库
        userAndSongList = new UserAndSongList();
        userAndSongList.setSonglistId(songListId);
        userAndSongList.setUserId(userId);
        userAndSongListMapper.insert(userAndSongList);
        return 2;   // 收藏成功
    }


    /**
     * 用户取消关注歌单，根据歌单id
     * @param songListId 歌单id
     * @param userId
     * @return
     */
    @Override
    public Integer deleteFavoriteSongList(Integer songListId, Integer userId) throws Exception {
        if (songListId == null || userId == null) {
            throw new ParamException();
        }

        // 判断歌单是否存在
        SongList songList = songListMapper.selectById(songListId);
        if (songList == null) {
            throw new ParamException("歌单信息异常");
        }

        // 判断用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户信息异常");
        }

        // 判断用户是否收藏此歌单
        UserAndSongList userAndSongList =
                userAndSongListMapper.selectBySongListIdAndUserId(songListId, userId);
        if (userAndSongList == null) {
            throw new ParamException("您未收藏此歌单");
        }

        // 更新歌单的收藏量
        songList.setLikeNumbers(songList.getLikeNumbers() - 1);
        songListMapper.updateById(songList);

        // 删除这条关注记录
        return userAndSongListMapper.deleteById(userAndSongList.getId());
    }


    /**
     * 查询用户关注的所有歌单
     * @param userId
     * @return
     */
    @Override
    public List<SongListExpand> selectFavoriteSongListByUserId(Integer userId) throws Exception {
        if (userId == null) {
            throw new ParamException();
        }

        // 判断用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户信息异常");
        }

        // 查询用户收藏的歌单
        return userAndSongListMapper.selectFavoriteSongListByUserId(userId);
    }
}
