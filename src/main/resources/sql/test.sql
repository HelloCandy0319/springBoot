/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.1.49-community : Database - test1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test1` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `test1`;

/*Table structure for table `activeemployee` */

DROP TABLE IF EXISTS `activeemployee`;

CREATE TABLE `activeemployee` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `activeemployee` */

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `article` */

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `books` */

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `DTYPE` varchar(31) COLLATE utf8_bin NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `retired` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `employee` */

/*Table structure for table `hibernate_sequences` */

DROP TABLE IF EXISTS `hibernate_sequences`;

CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `sequence_next_hi_value` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `hibernate_sequences` */

/*Table structure for table `library` */

DROP TABLE IF EXISTS `library`;

CREATE TABLE `library` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2kamxh7sx0td8ap1x3swt452h` (`student_id`),
  CONSTRAINT `FK2kamxh7sx0td8ap1x3swt452h` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `library` */

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg1e1kjf5phah57wd8q033fqms` (`article_id`),
  CONSTRAINT `FKg1e1kjf5phah57wd8q033fqms` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `person` */

/*Table structure for table `phone` */

DROP TABLE IF EXISTS `phone`;

CREATE TABLE `phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `phone` */

insert  into `phone`(`id`,`name`) values (1,'小米8'),(2,'小米9'),(3,'小米8'),(4,'小米9');

/*Table structure for table `phone_users` */

DROP TABLE IF EXISTS `phone_users`;

CREATE TABLE `phone_users` (
  `Phone_id` bigint(20) NOT NULL,
  `users_id` bigint(20) NOT NULL,
  KEY `FKsvd4b8oxk3hfr6kqnm1rvj8hm` (`users_id`),
  KEY `FKgojd56v4fggcln1kxppwlxf8y` (`Phone_id`),
  CONSTRAINT `FKgojd56v4fggcln1kxppwlxf8y` FOREIGN KEY (`Phone_id`) REFERENCES `phone` (`id`),
  CONSTRAINT `FKsvd4b8oxk3hfr6kqnm1rvj8hm` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `phone_users` */

/*Table structure for table `retiredemployee` */

DROP TABLE IF EXISTS `retiredemployee`;

CREATE TABLE `retiredemployee` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `retired` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `retiredemployee` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `student` */

/*Table structure for table `student_books` */

DROP TABLE IF EXISTS `student_books`;

CREATE TABLE `student_books` (
  `Student_id` bigint(20) NOT NULL,
  `books_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_p08lqjfkljl187y4u5xo3a1go` (`books_id`),
  KEY `FK3frhbxlo6xmie3exqf3y1d0wh` (`Student_id`),
  CONSTRAINT `FK3frhbxlo6xmie3exqf3y1d0wh` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FKcjwk6jykbb7k098269uevpfh5` FOREIGN KEY (`books_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `student_books` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`name`) values (1,'张三'),(2,'李四'),(3,'张三'),(4,'李四');

/*Table structure for table `user_phones` */

DROP TABLE IF EXISTS `user_phones`;

CREATE TABLE `user_phones` (
  `User_id` bigint(20) NOT NULL,
  `phones_id` bigint(20) NOT NULL,
  KEY `FK8a99k1bvo4hgvib6t1ui8riob` (`phones_id`),
  KEY `FK7cf4cc4dlmjvpucfxaqrj9lwl` (`User_id`),
  CONSTRAINT `FK7cf4cc4dlmjvpucfxaqrj9lwl` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK8a99k1bvo4hgvib6t1ui8riob` FOREIGN KEY (`phones_id`) REFERENCES `phone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user_phones` */

insert  into `user_phones`(`User_id`,`phones_id`) values (1,1),(1,2),(2,1),(2,2),(3,3),(3,4),(4,3),(4,4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
