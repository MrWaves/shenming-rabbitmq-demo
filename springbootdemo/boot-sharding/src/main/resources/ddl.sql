-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.17-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 sharding_0 的数据库结构
CREATE DATABASE IF NOT EXISTS `sharding_0` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sharding_0`;

-- 导出  表 sharding_0.t_student_0 结构
CREATE TABLE IF NOT EXISTS `t_student_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_0.t_student_1 结构
CREATE TABLE IF NOT EXISTS `t_student_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_0.t_user_0 结构
CREATE TABLE IF NOT EXISTS `t_user_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81531163281195009 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_0.t_user_1 结构
CREATE TABLE IF NOT EXISTS `t_user_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81531163180531713 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_0.t_user_2 结构
CREATE TABLE IF NOT EXISTS `t_user_2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81531163331526657 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。

-- 导出 sharding_1 的数据库结构
CREATE DATABASE IF NOT EXISTS `sharding_1` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sharding_1`;

-- 导出  表 sharding_1.t_student_0 结构
CREATE TABLE IF NOT EXISTS `t_student_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_1.t_student_1 结构
CREATE TABLE IF NOT EXISTS `t_student_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_1.t_user_0 结构
CREATE TABLE IF NOT EXISTS `t_user_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81531163419607041 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_1.t_user_1 结构
CREATE TABLE IF NOT EXISTS `t_user_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5698798768454567686 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_1.t_user_2 结构
CREATE TABLE IF NOT EXISTS `t_user_2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81531163230863361 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
