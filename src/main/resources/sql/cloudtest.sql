/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.1.49-community : Database - cloudtest
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cloudtest` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `cloudtest`;

/*Table structure for table `app_token` */

DROP TABLE IF EXISTS `app_token`;

CREATE TABLE `app_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `app_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `build_time` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `token` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `app_token` */

/*Table structure for table `app_user_infos` */

DROP TABLE IF EXISTS `app_user_infos`;

CREATE TABLE `app_user_infos` (
  `app_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `bind_ip` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `request_count` bigint(20) DEFAULT NULL,
  `secret` tinyblob,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `app_user_infos` */

/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `begin_time` datetime DEFAULT NULL,
  `client_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `method` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `param_data` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `return_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `log` */

insert  into `log`(`id`,`begin_time`,`client_url`,`method`,`param_data`,`return_time`) values (1,'2019-08-05 09:39:29','/','GET','{}','2019-08-05 09:39:29'),(2,'2019-08-05 09:39:38','/student/','GET','{}','2019-08-05 09:39:38'),(3,'2019-08-05 09:40:03','/student/','GET','{}','2019-08-05 09:40:03'),(4,'2019-08-05 16:46:01','/','GET','{}','2019-08-05 16:46:01'),(5,'2019-08-05 16:47:46','/employee','POST','{\"employeeName\":[\"张三\"],\"age\":[\"10\"]}','2019-08-05 16:47:46'),(6,'2019-08-05 16:47:46','/error','POST','{\"employeeName\":[\"张三\"],\"age\":[\"10\"]}','2019-08-05 16:47:46'),(7,'2019-08-05 16:48:12','/employee','POST','{\"employeeName\":[\"张三\"],\"age\":[\"10\"]}','2019-08-05 16:48:12'),(8,'2019-08-05 16:48:13','/error','POST','{\"employeeName\":[\"张三\"],\"age\":[\"10\"]}','2019-08-05 16:48:13'),(9,'2019-08-05 16:50:42','/','GET','{}','2019-08-05 16:50:42'),(10,'2019-08-05 16:50:44','/employee','POST','{\"employeeName\":[\"张三\"],\"age\":[\"10\"],\"id\":[\"1\"]}','2019-08-05 16:50:44'),(11,'2019-08-05 16:50:44','/error','POST','{\"employeeName\":[\"张三\"],\"age\":[\"10\"],\"id\":[\"1\"]}','2019-08-05 16:50:44'),(12,'2019-08-05 16:51:16','/employee','POST','{\"employeeName\":[\"张三\"],\"age\":[\"10\"]}','2019-08-05 16:51:16'),(13,'2019-08-05 16:51:16','/error','POST','{\"employeeName\":[\"张三\"],\"age\":[\"10\"]}','2019-08-05 16:51:16'),(14,'2019-08-05 16:51:44','/employee','POST','{\"employeeName\":[\"Hello\"],\"age\":[\"10\"]}','2019-08-05 16:51:44'),(15,'2019-08-05 16:51:44','/error','POST','{\"employeeName\":[\"Hello\"],\"age\":[\"10\"]}','2019-08-05 16:51:45'),(16,'2019-08-05 16:57:46','/employee','POST','{\"employeeName\":[\"Hello\"],\"age\":[\"10\"]}','2019-08-05 16:57:46'),(17,'2019-08-05 16:57:48','/','GET','{}','2019-08-05 16:57:48'),(18,'2019-08-05 16:57:50','/employee','POST','{\"employeeName\":[\"Hello\"],\"age\":[\"10\"]}','2019-08-05 16:57:50'),(19,'2019-08-05 16:58:11','/employee','POST','{\"employeeName\":[\"李四\"],\"age\":[\"10\"]}','2019-08-05 16:58:11'),(20,'2019-08-05 16:58:57','/employee','POST','{\"employeeName\":[\"李四\"],\"age\":[\"10\"]}','2019-08-05 16:58:58'),(21,'2019-08-05 16:58:59','/','GET','{}','2019-08-05 16:58:59'),(22,'2019-08-05 17:00:27','/employee','POST','{\"employeeName\":[\"李四1\"],\"age\":[\"10\"]}','2019-08-05 17:00:35'),(23,'2019-08-05 17:18:58','/','GET','{}','2019-08-05 17:18:58'),(24,'2019-08-05 17:21:10','/employee','POST','{\"employeeName\":[\"李四1\"],\"age\":[\"10\"]}','2019-08-05 17:21:25'),(25,'2019-08-05 17:26:44','/employee','POST','{\"employeeName\":[\"李四1\"],\"age\":[\"10\"]}','2019-08-05 17:26:55'),(26,'2019-08-05 17:28:26','/employee','POST','{\"employeeName\":[\"李四1\"],\"age\":[\"10\"]}','2019-08-05 17:28:33'),(27,'2019-08-05 17:29:06','/employee','POST','{\"employeeName\":[\"李四12\"],\"age\":[\"10\"]}','2019-08-05 17:29:08'),(28,'2019-08-05 17:32:35','/employee','POST','{\"employeeName\":[\"李四12\"],\"age\":[\"10\"]}','2019-08-05 17:32:35'),(29,'2019-08-05 17:43:07','/','GET','{}','2019-08-05 17:43:07'),(30,'2019-08-05 17:43:11','/student/','GET','{}','2019-08-05 17:43:11'),(31,'2019-08-05 17:43:17','/employee','GET','{}','2019-08-05 17:43:17'),(32,'2019-08-05 17:51:29','/','GET','{}','2019-08-05 17:51:29'),(33,'2019-08-05 17:51:32','/student/','GET','{}','2019-08-05 17:51:32'),(34,'2019-08-05 17:51:34','/employee','GET','{}','2019-08-05 17:51:34'),(35,'2019-08-05 17:58:49','/','GET','{}','2019-08-05 17:58:49'),(36,'2019-08-05 17:58:52','/employee','GET','{}','2019-08-05 17:58:52'),(37,'2019-08-05 17:58:54','/student/','GET','{}','2019-08-05 17:58:54'),(38,'2019-08-06 09:27:18','/','GET','{}','2019-08-06 09:27:18'),(39,'2019-08-06 09:27:21','/employee','GET','{}','2019-08-06 09:27:22'),(40,'2019-08-06 09:27:28','/','GET','{}','2019-08-06 09:27:28'),(41,'2019-08-06 09:27:29','/student/','GET','{}','2019-08-06 09:27:30'),(42,'2019-08-06 09:27:49','/','GET','{}','2019-08-06 09:27:49'),(43,'2019-08-06 09:42:52','/','GET','{}','2019-08-06 09:42:52'),(44,'2019-08-06 09:42:55','/employee','GET','{}','2019-08-06 09:42:55'),(45,'2019-08-06 09:42:58','/student/','GET','{}','2019-08-06 09:42:58'),(46,'2019-08-06 10:30:15','/','GET','{}','2019-08-06 10:30:15'),(47,'2019-08-06 10:31:29','/employee','GET','{}','2019-08-06 10:31:29'),(48,'2019-08-06 10:31:56','/student/','GET','{}','2019-08-06 10:31:56'),(49,'2019-08-06 10:32:21','/employee','POST','{\"employeeName\":[\"李四122\"],\"age\":[\"10\"]}','2019-08-06 10:32:21'),(50,'2019-08-06 10:51:04','/','GET','{}','2019-08-06 10:51:04'),(51,'2019-08-06 10:51:24','/','GET','{}','2019-08-06 10:51:24'),(52,'2019-08-06 10:51:36','/employee','POST','{\"employeeName\":[\"李四122\"],\"age\":[\"10\"]}','2019-08-06 10:51:36'),(53,'2019-08-07 10:15:29','/student/','GET','{}','2019-08-07 10:15:30'),(54,'2019-08-07 10:16:01','/dept/','GET','{}','2019-08-07 10:16:01'),(55,'2019-08-07 10:16:37','/dept/','POST','{\"deptName\":[\"开发部门\"]}','2019-08-07 10:16:37'),(56,'2019-08-07 10:16:59','/dept/','POST','{\"deptName\":[\"测试部门\"]}','2019-08-07 10:16:59'),(57,'2019-08-07 10:17:19','/dept/','POST','{\"deptName\":[\"开发部门一\"],\"parentDept\":[\"1\"]}','2019-08-07 10:17:19'),(58,'2019-08-07 10:17:40','/dept/','POST','{\"deptName\":[\"开发部门二\"],\"parentDept\":[\"1\"]}','2019-08-07 10:17:40'),(59,'2019-08-07 10:25:33','/employee','POST','{\"employeeName\":[\"李四122\"],\"age\":[\"10\"]}','2019-08-07 10:25:33'),(60,'2019-08-07 10:25:33','/error','GET','{}','2019-08-07 10:25:33'),(61,'2019-08-07 10:26:05','/employee','POST','{\"employeeName\":[\"李四122\"],\"age\":[\"10\"],\"deptId\":[\"1\"]}','2019-08-07 10:26:05'),(62,'2019-08-07 10:28:10','/employee','POST','{\"employeeName\":[\"王五\"],\"age\":[\"10\"],\"deptId\":[\"1\"]}','2019-08-07 10:28:10'),(63,'2019-08-07 11:27:50','/','GET','{}','2019-08-07 11:27:50'),(64,'2019-08-07 11:28:06','/employee/empInfo','GET','{\"id\":[\"13\"]}','2019-08-07 11:28:06'),(65,'2019-08-07 11:28:06','/error','GET','{\"id\":[\"13\"]}','2019-08-07 11:28:06'),(66,'2019-08-07 11:28:15','/error','GET','{}','2019-08-07 11:28:15'),(67,'2019-08-07 11:28:41','/employee/empInfo','GET','{\"id\":[\"13\"]}','2019-08-07 11:28:41'),(68,'2019-08-07 11:28:41','/error','GET','{\"id\":[\"13\"]}','2019-08-07 11:28:41'),(69,'2019-08-07 11:29:03','/employee/empInfo','GET','{\"id\":[\"13\"]}','2019-08-07 11:29:03'),(70,'2019-08-07 11:29:03','/error','GET','{\"id\":[\"13\"]}','2019-08-07 11:29:03'),(71,'2019-08-07 11:31:44','/','GET','{}','2019-08-07 11:31:44'),(72,'2019-08-07 11:31:47','/employee/empInfo','GET','{\"id\":[\"13\"]}','2019-08-07 11:31:47'),(73,'2019-08-07 11:31:47','/error','GET','{\"id\":[\"13\"]}','2019-08-07 11:31:47'),(74,'2019-08-07 11:31:56','/employee/empInfo','GET','{\"id\":[\"13\"]}','2019-08-07 11:32:01'),(75,'2019-08-07 11:32:01','/error','GET','{\"id\":[\"13\"]}','2019-08-07 11:32:01'),(76,'2019-08-07 11:35:53','/','GET','{}','2019-08-07 11:35:53'),(77,'2019-08-07 11:35:55','/employee/empInfo','GET','{\"id\":[\"13\"]}','2019-08-07 11:35:55'),(78,'2019-08-07 11:35:56','/error','GET','{\"id\":[\"13\"]}','2019-08-07 11:35:56'),(79,'2019-08-07 11:43:01','/','GET','{}','2019-08-07 11:43:01'),(80,'2019-08-07 11:43:02','/employee/empInfo','GET','{\"id\":[\"13\"]}','2019-08-07 11:43:02'),(81,'2019-08-07 11:43:02','/error','GET','{\"id\":[\"13\"]}','2019-08-07 11:43:02'),(82,'2019-08-07 11:43:38','/employee/empInfo','GET','{\"id\":[\"13\"]}','2019-08-07 11:43:38'),(83,'2019-08-07 11:43:38','/error','GET','{\"id\":[\"13\"]}','2019-08-07 11:43:39'),(84,'2019-08-07 11:46:00','/','GET','{}','2019-08-07 11:46:00'),(85,'2019-08-07 11:46:01','/employee/empInfo','GET','{\"id\":[\"13\"]}','2019-08-07 11:46:01'),(86,'2019-08-07 11:47:14','/','GET','{}','2019-08-07 11:47:14'),(87,'2019-08-07 11:47:16','/employee/empInfo','GET','{\"id\":[\"13\"]}','2019-08-07 11:47:16'),(88,'2019-08-07 13:37:58','/','GET','{}','2019-08-07 13:37:58'),(89,'2019-08-07 13:38:00','/employee/empInfo','GET','{\"id\":[\"13\"]}','2019-08-07 13:38:00'),(90,'2019-08-07 14:15:49','/','GET','{}','2019-08-07 14:15:49'),(91,'2019-08-07 14:16:41','/employee','POST','{\"employeeName\":[\"Candy\"],\"age\":[\"10\"],\"deptId\":[\"3\"]}','2019-08-07 14:16:41'),(92,'2019-08-07 14:16:42','/error','POST','{\"employeeName\":[\"Candy\"],\"age\":[\"10\"],\"deptId\":[\"3\"]}','2019-08-07 14:16:42'),(93,'2019-08-07 14:17:01','/employee','POST','{\"employeeName\":[\"Candy\"],\"age\":[\"18\"],\"deptId\":[\"5\"]}','2019-08-07 14:17:01'),(94,'2019-08-07 14:17:01','/error','POST','{\"employeeName\":[\"Candy\"],\"age\":[\"18\"],\"deptId\":[\"5\"]}','2019-08-07 14:17:01'),(95,'2019-08-07 14:17:09','/employee','POST','{\"employeeName\":[\"Candy\"],\"age\":[\"18\"],\"deptId\":[\"3\"]}','2019-08-07 14:17:09'),(96,'2019-08-07 14:27:53','/','GET','{}','2019-08-07 14:27:53'),(97,'2019-08-07 14:28:02','/employee','POST','{\"employeeName\":[\"Candyde\"],\"age\":[\"18\"],\"deptId\":[\"6\"]}','2019-08-07 14:28:02'),(98,'2019-08-07 14:28:02','/error','POST','{\"employeeName\":[\"Candyde\"],\"age\":[\"18\"],\"deptId\":[\"6\"]}','2019-08-07 14:28:02'),(99,'2019-08-07 14:30:10','/','GET','{}','2019-08-07 14:30:10'),(100,'2019-08-07 14:30:14','/employee','POST','{\"employeeName\":[\"Candyde\"],\"age\":[\"18\"],\"deptId\":[\"6\"]}','2019-08-07 14:30:14'),(101,'2019-08-07 14:30:14','/error','POST','{\"employeeName\":[\"Candyde\"],\"age\":[\"18\"],\"deptId\":[\"6\"]}','2019-08-07 14:30:14'),(102,'2019-08-07 14:50:13','/','GET','{}','2019-08-07 14:50:13'),(103,'2019-08-07 14:50:18','/employee/empInfo','GET','{\"id\":[\"13\"]}','2019-08-07 14:50:18'),(104,'2019-08-07 14:54:34','/','GET','{}','2019-08-07 14:54:34'),(105,'2019-08-07 14:54:51','/dept/employee','GET','{}','2019-08-07 14:54:51'),(106,'2019-08-07 15:10:26','/','GET','{}','2019-08-07 15:10:26'),(107,'2019-08-07 15:10:28','/dept/employee','GET','{}','2019-08-07 15:10:28'),(108,'2019-08-07 15:12:44','/','GET','{}','2019-08-07 15:12:44'),(109,'2019-08-07 15:12:50','/dept/employee','GET','{}','2019-08-07 15:12:50'),(110,'2019-08-07 15:30:40','/','GET','{}','2019-08-07 15:30:40'),(111,'2019-08-07 15:30:47','/dept/employee','GET','{}','2019-08-07 15:30:47'),(112,'2019-08-07 15:31:07','/dept/employee','GET','{}','2019-08-07 15:31:07'),(113,'2019-08-07 15:31:58','/','GET','{}','2019-08-07 15:31:58'),(114,'2019-08-07 15:32:01','/dept/employee','GET','{}','2019-08-07 15:32:54'),(115,'2019-08-07 15:33:03','/dept/employee','GET','{}','2019-08-07 15:34:08'),(116,'2019-08-07 15:34:59','/dept/employee','GET','{}','2019-08-07 15:35:15'),(117,'2019-08-07 15:35:15','/','GET','{}','2019-08-07 15:35:15'),(118,'2019-08-07 15:35:21','/dept/employee','GET','{}','2019-08-07 15:35:21'),(119,'2019-08-07 15:35:54','/dept/employee','GET','{}','2019-08-07 15:35:54'),(120,'2019-08-07 15:51:00','/','GET','{}','2019-08-07 15:51:00'),(121,'2019-08-07 15:51:02','/dept/employee','GET','{}','2019-08-07 15:51:02'),(122,'2019-08-07 16:42:16','/','GET','{}','2019-08-07 16:42:16'),(123,'2019-08-07 16:42:21','/dept/employee','GET','{}','2019-08-07 16:42:21'),(124,'2019-08-07 17:23:19','/','GET','{}','2019-08-07 17:23:19'),(125,'2019-08-07 17:23:25','/dept/employee','GET','{}','2019-08-07 17:23:25'),(126,'2019-08-07 17:23:25','/error','GET','{}','2019-08-07 17:23:25'),(127,'2019-08-07 17:24:06','/','GET','{}','2019-08-07 17:24:06'),(128,'2019-08-07 17:24:10','/dept/employee','GET','{}','2019-08-07 17:25:22'),(129,'2019-08-07 17:25:22','/error','GET','{}','2019-08-07 17:25:22'),(130,'2019-08-07 17:28:51','/','GET','{}','2019-08-07 17:28:51'),(131,'2019-08-07 17:28:56','/dept/employee','GET','{}','2019-08-07 17:29:00'),(132,'2019-08-07 17:29:01','/error','GET','{}','2019-08-07 17:29:01'),(133,'2019-08-07 17:29:36','/dept/employee','GET','{}','2019-08-07 17:30:13'),(134,'2019-08-07 17:30:13','/error','GET','{}','2019-08-07 17:30:13'),(135,'2019-08-07 17:31:15','/','GET','{}','2019-08-07 17:31:15'),(136,'2019-08-07 17:31:17','/dept/employee','GET','{}','2019-08-07 17:31:56'),(137,'2019-08-07 17:31:56','/error','GET','{}','2019-08-07 17:31:56'),(138,'2019-08-07 17:33:32','/','GET','{}','2019-08-07 17:33:32'),(139,'2019-08-07 17:33:33','/dept/employee','GET','{}','2019-08-07 17:34:15'),(140,'2019-08-07 17:34:15','/error','GET','{}','2019-08-07 17:34:15'),(141,'2019-08-07 17:34:46','/dept/employee','GET','{}','2019-08-07 17:35:18'),(142,'2019-08-07 17:35:18','/error','GET','{}','2019-08-07 17:35:18'),(143,'2019-08-07 17:35:46','/dept/employee','GET','{}','2019-08-07 17:37:01'),(144,'2019-08-07 17:37:01','/error','GET','{}','2019-08-07 17:37:01'),(145,'2019-08-07 17:41:21','/','GET','{}','2019-08-07 17:41:22'),(146,'2019-08-07 17:41:23','/dept/employee','GET','{}','2019-08-07 17:41:34'),(147,'2019-08-07 17:41:34','/error','GET','{}','2019-08-07 17:41:34'),(148,'2019-08-07 17:41:47','/dept/employee','GET','{}','2019-08-07 17:42:16'),(149,'2019-08-07 17:42:16','/error','GET','{}','2019-08-07 17:42:16'),(150,'2019-08-07 17:42:56','/','GET','{}','2019-08-07 17:42:56'),(151,'2019-08-07 17:42:59','/dept/employee','GET','{}','2019-08-07 17:44:48'),(152,'2019-08-07 17:53:11','/','GET','{}','2019-08-07 17:53:11'),(153,'2019-08-07 17:53:12','/dept/employee','GET','{}','2019-08-07 17:53:12'),(154,'2019-08-07 17:53:58','/dept/employee','GET','{}','2019-08-07 17:53:58'),(155,'2019-08-07 17:54:04','/dept/employee','GET','{}','2019-08-07 17:54:04'),(156,'2019-08-07 17:54:55','/dept/employee','GET','{}','2019-08-07 17:54:55'),(157,'2019-08-07 17:55:16','/dept/employee','GET','{}','2019-08-07 17:55:16'),(158,'2019-08-07 17:56:08','/','GET','{}','2019-08-07 17:56:08'),(159,'2019-08-07 17:56:11','/dept/employee','GET','{}','2019-08-07 17:56:11'),(160,'2019-08-07 17:56:54','/dept/employee','GET','{}','2019-08-07 17:57:30'),(161,'2019-08-07 17:59:50','/dept/employee','GET','{}','2019-08-07 18:05:57'),(162,'2019-08-07 18:06:07','/','GET','{}','2019-08-07 18:06:07'),(163,'2019-08-07 18:06:12','/dept/employee','GET','{}','2019-08-07 18:08:15'),(164,'2019-08-07 18:13:41','/','GET','{}','2019-08-07 18:13:41'),(165,'2019-08-07 18:13:43','/dept/employee','GET','{}','2019-08-07 18:15:03'),(166,'2019-08-07 18:15:22','/','GET','{}','2019-08-07 18:15:22'),(167,'2019-08-07 18:15:23','/dept/employee','GET','{}','2019-08-07 18:16:42'),(168,'2019-08-07 18:24:06','/','GET','{}','2019-08-07 18:24:06'),(169,'2019-08-07 18:24:07','/dept/employee','GET','{}','2019-08-07 18:24:07'),(170,'2019-08-07 18:25:09','/dept/employee','GET','{}','2019-08-07 18:26:56'),(171,'2019-08-07 18:27:15','/','GET','{}','2019-08-07 18:27:15'),(172,'2019-08-07 18:27:17','/dept/employee','GET','{}','2019-08-07 18:27:33'),(173,'2019-08-07 18:28:49','/dept/employee','GET','{}','2019-08-07 18:30:13'),(174,'2019-08-07 18:33:20','/','GET','{}','2019-08-07 18:33:20'),(175,'2019-08-07 18:33:21','/dept/employee','GET','{}','2019-08-07 18:35:30'),(176,'2019-08-07 18:36:23','/dept/employee','GET','{}','2019-08-07 18:36:23'),(177,'2019-08-07 18:36:24','/dept/employee','GET','{}','2019-08-07 18:36:24');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `permission` */

insert  into `permission`(`id`,`description`,`url`) values (1,'测试1','/callerDemo1/user/hi'),(3,'测试3','/callerDemo/user/hi2'),(4,'测试2','/callerDemo1/user/hi1');

/*Table structure for table `persistent_logins` */

DROP TABLE IF EXISTS `persistent_logins`;

CREATE TABLE `persistent_logins` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `series` varchar(64) COLLATE utf8_bin NOT NULL,
  `token` varchar(64) COLLATE utf8_bin NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `persistent_logins` */

insert  into `persistent_logins`(`username`,`series`,`token`,`last_used`) values ('admin','1osRzMQyddOc4nezKDb+hg==','GJNFhZOyzgQeJtDbEXWsog==','2019-05-16 17:29:50'),('admin','KaTra48xxbPD1/dOWtTsew==','I/51TX/hY7UxyNQBs7uwCA==','2019-05-28 17:38:01'),('admin','kTBOA5nje9hXRYn+M7kDAw==','zHXQooIkOv/c2ogY/kUv8w==','2019-05-16 17:30:16'),('admin','tTo/HJd40wXA3SprcxAevg==','AMbpjiEWupvM3Pr3ylRJWw==','2019-05-28 17:38:13');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `role` */

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `role_permission` */

insert  into `role_permission`(`id`,`permission_id`,`role_id`) values (2,1,1),(4,3,1),(5,4,2);

/*Table structure for table `role_user` */

DROP TABLE IF EXISTS `role_user`;

CREATE TABLE `role_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `role_user` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`age`,`password`,`username`) values (1,13,'123456','admin');

/*Table structure for table `user1` */

DROP TABLE IF EXISTS `user1`;

CREATE TABLE `user1` (
  `id` int(50) NOT NULL DEFAULT '0',
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  `age` int(11) DEFAULT NULL,
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user1` */

insert  into `user1`(`id`,`password`,`username`,`age`) values (1,'$2a$10$DkPKTrN164B7vzR7pRWSW.IomQGnxY/w5ln6oQUK2SjpWHv2ifOqC','admin',21),(7,'$2a$10$oeW0clqOBWmjGsMG590DouBkkHCyyjmCQWatyDAF9Sebbq7ynzcbG','hello',22),(5,'$2a$10$ZVBHj87hmCYa0hx6DuS8R.M3mb1HOKll1TZZ3T3tO6B1OP6WtykT2','user',23);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
