/*
Navicat MySQL Data Transfer

Source Server         : bbMusic
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : db_music

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-12-27 10:47:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `song_id` int(11) NOT NULL COMMENT '歌曲id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `content` varchar(1000) CHARACTER SET utf8 DEFAULT '' COMMENT '评论内容',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_singer
-- ----------------------------
DROP TABLE IF EXISTS `t_singer`;
CREATE TABLE `t_singer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `singer_name` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '歌手名称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像路径',
  `gender` int(11) NOT NULL DEFAULT 0 COMMENT '性别（0为男，1为女）',
  `age` int(11) DEFAULT NULL,
  `introduction` varchar(5000) CHARACTER SET utf8 DEFAULT NULL COMMENT '歌手介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_song
-- ----------------------------
DROP TABLE IF EXISTS `t_song`;
CREATE TABLE `t_song` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `song_name` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '歌曲名称',
  `play_time` bigint(20) NOT NULL COMMENT '时长',
  `song_word` varchar(5000) CHARACTER SET utf8 DEFAULT NULL COMMENT '歌词',
  `song_photo` varchar(255) DEFAULT NULL COMMENT '歌曲图片路径',
  `song_type` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '歌曲类型',
  `play_number` int(11) DEFAULT NULL COMMENT '播放量',
  `like_number` int(11) DEFAULT NULL COMMENT '收藏量',
  `singer_id` int(11) NOT NULL COMMENT '歌曲id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_songlist
-- ----------------------------
DROP TABLE IF EXISTS `t_songlist`;
CREATE TABLE `t_songlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `songlist_name` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '歌单名称',
  `introduction` varchar(5000) CHARACTER SET utf8 DEFAULT NULL COMMENT '歌单介绍',
  `like_numbers` int(11) DEFAULT 0 COMMENT '歌单收藏量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_songlist_song
-- ----------------------------
DROP TABLE IF EXISTS `t_songlist_song`;
CREATE TABLE `t_songlist_song` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `songlist_id` int(11) NOT NULL COMMENT '歌单id',
  `song_id` int(11) NOT NULL COMMENT '歌曲id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `avatar` varchar(255) DEFAULT '' COMMENT '头像路径',
  `user_status` int(11) NOT NULL DEFAULT 0 COMMENT '是否被封禁（0未被封禁 1被封禁）',
  `user_type` int(11) NOT NULL DEFAULT 0 COMMENT '是否为管理员（0为普通用户 1为管理员）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_user_singer
-- ----------------------------
DROP TABLE IF EXISTS `t_user_singer`;
CREATE TABLE `t_user_singer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `singer_id` int(11) NOT NULL COMMENT '歌手id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_user_song
-- ----------------------------
DROP TABLE IF EXISTS `t_user_song`;
CREATE TABLE `t_user_song` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `song_id` int(11) NOT NULL COMMENT '歌曲id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_user_songlist
-- ----------------------------
DROP TABLE IF EXISTS `t_user_songlist`;
CREATE TABLE `t_user_songlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `songlist_id` int(11) NOT NULL COMMENT '歌单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
