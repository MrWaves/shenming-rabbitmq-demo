use `test2`;
CREATE TABLE `t_employee` (
	`id` BIGINT(11) NOT NULL AUTO_INCREMENT,
	`phoneNum` BIGINT(11) NOT NULL,
	`name` VARCHAR(200) NULL,
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
)COMMENT='employee';

use `test`;
CREATE TABLE `t_person` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)COMMENT='person';
CREATE TABLE `t_admin_user` (
	`id` BIGINT(11) NOT NULL AUTO_INCREMENT,
	`user_name` VARCHAR(50) NOT NULL,
	`pass_word` VARCHAR(50) NOT NULL,
	`is_deleted` TINYINT(2) NOT NULL DEFAULT '0',
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB
;
INSERT INTO `t_admin_user` (`user_name`, `pass_word`, `is_deleted`, `update_time`, `create_time`) VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 0, '2017-06-15 15:59:00', '2017-06-15 15:59:00');

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=81469209669795841 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_0.t_user_1 结构
CREATE TABLE IF NOT EXISTS `t_user_1` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`user_id` bigint(11) NOT NULL,
	`name` varchar(255) NOT NULL,
	`age` int(11) NOT NULL,
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81469209569132545 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sharding_0.t_user_2 结构
CREATE TABLE IF NOT EXISTS `t_user_2` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`user_id` bigint(11) NOT NULL,
	`name` varchar(255) NOT NULL,
	`age` int(11) NOT NULL,
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81469209707544577 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

use `mysql`;
INSERT INTO `user` (`Host`, `User`, `Select_priv`, `Insert_priv`, `Update_priv`, `Delete_priv`, `Create_priv`, `Drop_priv`, `Reload_priv`, `Shutdown_priv`, `Process_priv`, `File_priv`, `Grant_priv`, `References_priv`, `Index_priv`, `Alter_priv`, `Show_db_priv`, `Super_priv`, `Create_tmp_table_priv`, `Lock_tables_priv`, `Execute_priv`, `Repl_slave_priv`, `Repl_client_priv`, `Create_view_priv`, `Show_view_priv`, `Create_routine_priv`, `Alter_routine_priv`, `Create_user_priv`, `Event_priv`, `Trigger_priv`, `Create_tablespace_priv`, `ssl_type`, `ssl_cipher`, `x509_issuer`, `x509_subject`, `max_questions`, `max_updates`, `max_connections`, `max_user_connections`, `plugin`, `authentication_string`, `password_expired`, `password_last_changed`, `password_lifetime`, `account_locked`) VALUES ('localhost', 'lishenming', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', '', '', '', '', 0, 0, 0, 0, 'mysql_native_password', '*9995E9856989FD0157CC626B0453016E86856773', 'N', '2017-06-13 23:12:12', NULL, 'N');
