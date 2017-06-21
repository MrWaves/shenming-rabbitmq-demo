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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='登录用户信息';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
INSERT INTO `t_admin_user` (`user_name`, `pass_word`, `is_deleted`, `update_time`, `create_time`) VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 0, '2017-06-15 15:59:00', '2017-06-15 15:59:00');
INSERT INTO `t_admin_user` (`user_name`, `pass_word`, `is_deleted`, `update_time`, `create_time`) VALUES ('lsm', '32c0e8a1f06cda80353f0001347a2e2f', 0, '2017-06-21 14:36:09', '2017-06-21 14:36:09');
INSERT INTO `t_admin_user` (`user_name`, `pass_word`, `is_deleted`, `update_time`, `create_time`) VALUES ('lsmtest', '43a149a87fdb070d164411c7876e7324', 0, '2017-06-21 14:36:09', '2017-06-21 14:36:09');
