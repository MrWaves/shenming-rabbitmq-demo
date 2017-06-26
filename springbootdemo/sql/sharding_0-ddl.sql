-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.17-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

-- 导出 sharding_0 的数据库结构
CREATE DATABASE IF NOT EXISTS `sharding_0` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sharding_0`;

-- 导出  表 sharding_0.t_student_0 结构
CREATE TABLE IF NOT EXISTS `t_student_0` (
  `id` bigint(20) NOT NULL,
  `student_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_0.t_student_1 结构
CREATE TABLE IF NOT EXISTS `t_student_1` (
  `id` bigint(20) NOT NULL,
  `student_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_0.t_user_0 结构
CREATE TABLE IF NOT EXISTS `t_user_0` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_0.t_user_1 结构
CREATE TABLE IF NOT EXISTS `t_user_1` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_0.t_user_2 结构
CREATE TABLE IF NOT EXISTS `t_user_2` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

