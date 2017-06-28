-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.17-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;

-- 导出  表 test.t_admin_user 结构
CREATE TABLE IF NOT EXISTS `t_admin_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `pass_word` varchar(50) NOT NULL,
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录用户信息';

-- 数据导出被取消选择。
-- 导出  表 test.t_person 结构
CREATE TABLE IF NOT EXISTS `t_person` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='person';

INSERT INTO `t_admin_user` (`user_name`, `pass_word`, `is_deleted`, `update_time`, `create_time`) VALUES ('lsm', '32c0e8a1f06cda80353f0001347a2e2f', 0, now(), now());
INSERT INTO `t_admin_user` (`user_name`, `pass_word`, `is_deleted`, `update_time`, `create_time`) VALUES ('lsmtest', '43a149a87fdb070d164411c7876e7324', 0, now(), now());

