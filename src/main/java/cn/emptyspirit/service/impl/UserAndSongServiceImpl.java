package cn.emptyspirit.service.impl;

import cn.emptyspirit.entity.Song;
import cn.emptyspirit.entity.User;
import cn.emptyspirit.entity.UserAndSong;
import cn.emptyspirit.entity.expand.SongExpand;
import cn.emptyspirit.exception.ParamException;
import cn.emptyspirit.mapper.SongMapper;
import cn.emptyspirit.mapper.UserAndSongMapper;
import cn.emptyspirit.mapper.UserMapper;
import cn.emptyspirit.service.UserAndSongService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserAndSongServiceImpl implements UserAndSongService {

    private UserMapper userMapper;
    private SongMapper songMapper;
    private UserAndSongMapper userAndSongMapper;

    @Autowired
    public UserAndSongServiceImpl(UserMapper userMapper, SongMapper songMapper, UserAndSongMapper userAndSongMapper) {
        this.userMapper = userMapper;
        this.songMapper = songMapper;
        this.userAndSongMapper = userAndSongMapper;
    }

    /**
     * 用户收藏歌曲
     * @param songId 歌曲id
     * @param userId 用户id
     * @return
     * @throws Exception
     */
    @Override
    public Integer addFavoriteSong(Integer songId, Integer userId) throws Exception {
        if (songId == null || userId == null) {
            throw new ParamException();
        }

        // 判断用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户信息异常");
        }

        // 判断歌曲是否存在
        Song song = songMapper.selectById(songId);
        if (song == null) {
            throw new ParamException("歌曲信息异常");
        }

        // 判断用户是否已经收藏过此歌曲
        UserAndSong userAndSong = userAndSongMapper.selectBySongIdAndUserId(songId, userId);
        // 若用户收藏过歌曲，择进行取消收藏操作
        if (userAndSong != null) {
            // 更新歌曲的收藏量
            song.setLikeNumber(song.getLikeNumber() - 1);
            songMapper.updateById(song);
            // 删除并返回结果
            userAndSongMapper.deleteById(userAndSong.getId());
            return 2;
        }

        // 更新歌曲的收藏量
        song.setLikeNumber(song.getLikeNumber() + 1);
        songMapper.updateById(song);

        // 封装一条用户收藏歌曲的记录，并插入到数据库
        userAndSong = new UserAndSong();
        userAndSong.setUserId(userId);
        userAndSong.setSongId(songId);
        return userAndSongMapper.insert(userAndSong);
    }


    /**
     * 用户取消一首歌的收藏，即删除这条收藏记录
     * @param userAndSongId 收藏歌曲的桥表中，这条收藏记录
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public Integer deleteFavoriteSongById(Integer userAndSongId, Integer userId) throws Exception {
        if (userAndSongId == null || userId == null) {
            throw new ParamException();
        }

        // 判断用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户信息异常");
        }

        // 查询这条收藏记录
        UserAndSong userAndSong = userAndSongMapper.selectById(userAndSongId);
        // 判断这条收藏记录是否存在，或者这条收藏是否属于此用户
        if (userAndSong == null || userAndSong.getUserId() != userId) {
            throw new ParamException("收藏信息异常");
        }


        // 更新歌曲的收藏量
        Song song = songMapper.selectById(userAndSong.getSongId());
        song.setLikeNumber(song.getLikeNumber() - 1);
        songMapper.updateById(song);

        // 删除并返回结果
        return userAndSongMapper.deleteById(userAndSongId);
    }


    /**
     * 根据歌曲id，取消用户对这首歌的收藏
     * @param songId 歌曲id
     * @param userId 用户id
     * @return
     * @throws Exception
     */
    @Override
    public Integer deleteFavoriteBySongId(Integer songId, Integer userId) throws Exception {
        if (songId == null || userId == null) {
            throw new ParamException();
        }

        // 判断歌曲是否存在
        Song song = songMapper.selectById(songId);
        if (song == null) {
            throw new ParamException("歌曲信息异常");
        }

        // 判断用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户信息异常");
        }

        // 判断收藏记录是否存在
        UserAndSong userAndSong = userAndSongMapper.selectBySongIdAndUserId(songId, userId);
        if (userAndSong == null) {
            throw new ParamException("收藏信息异常");
        }

        // 更新歌曲的收藏量
        song.setLikeNumber(song.getLikeNumber() - 1);
        songMapper.updateById(song);

        // 删除收藏记录,并返回结果
        return userAndSongMapper.deleteById(userAndSong.getId());
    }


    /**
     * 查询用户收藏的所有歌曲
     * @param userId 用户的名字
     * @return
     */
    @Override
    public List<SongExpand> selectFavoriteSongsByUserId(Integer userId) throws Exception {
        if (userId == null) {
            throw new ParamException();
        }

        // 查询用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户信息异常");
        }

        // 查询用户收藏的歌曲
        return userAndSongMapper.selectFavoriteSongsByUserId(userId);
    }


    /**
     * 分页查询用户收藏的歌曲
     * @param pageNum 页号
     * @param pageSize 页面大小
     * @param userId 用户id
     * @return
     */
    @Override
    public PageInfo<SongExpand> getOnePageFavoriteSongs(Integer pageNum, Integer pageSize, Integer userId) throws Exception {
        if (pageNum == null || pageSize == null || userId == null) {
            throw new ParamException();
        }

        // 查询用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户信息异常");
        }

        // 分页
        PageHelper.startPage(pageNum, pageSize);
        List<SongExpand> songExpands = userAndSongMapper.selectFavoriteSongsByUserId(userId);
        return new PageInfo<>(songExpands);
    }
}
