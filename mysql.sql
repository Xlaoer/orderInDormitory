/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.26 : Database - orderindormitory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`orderindormitory` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `orderindormitory`;

/*Table structure for table `admin` */

CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`password`,`telephone`) values (1,'admin','admin','191340417');
insert  into `admin`(`id`,`name`,`password`,`telephone`) values (2,'刘阿姨','admin','191340417');

/*Table structure for table `dormitory` */

CREATE TABLE `dormitory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;

/*Data for the table `dormitory` */

insert  into `dormitory`(`id`,`name`) values (1,'新苑3号417');
insert  into `dormitory`(`id`,`name`) values (2,'新苑3号805');
insert  into `dormitory`(`id`,`name`) values (3,'新苑3号804');
insert  into `dormitory`(`id`,`name`) values (4,'新苑3号517');
insert  into `dormitory`(`id`,`name`) values (5,'新苑3号617');
insert  into `dormitory`(`id`,`name`) values (6,'新苑3号717');
insert  into `dormitory`(`id`,`name`) values (38,'新苑1号808');
insert  into `dormitory`(`id`,`name`) values (39,'新苑3号8055');
insert  into `dormitory`(`id`,`name`) values (40,'新苑3号80555');

/*Table structure for table `order` */

CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int DEFAULT NULL,
  `dormitory_id` int DEFAULT NULL,
  `item` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `status` int DEFAULT NULL COMMENT '0代表未完成 1代表已完成 2代表删除',
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `order` */

insert  into `order`(`id`,`student_id`,`dormitory_id`,`item`,`status`,`create_time`) values (1,5,2,'可口可乐',2,NULL);
insert  into `order`(`id`,`student_id`,`dormitory_id`,`item`,`status`,`create_time`) values (2,5,2,'可口可乐',0,'2022-05-19 00:00:00');
insert  into `order`(`id`,`student_id`,`dormitory_id`,`item`,`status`,`create_time`) values (3,5,2,'百事可乐',1,'2022-05-19 00:00:00');
insert  into `order`(`id`,`student_id`,`dormitory_id`,`item`,`status`,`create_time`) values (4,6,2,'薯片一份',0,'2022-05-19 00:00:00');
insert  into `order`(`id`,`student_id`,`dormitory_id`,`item`,`status`,`create_time`) values (5,70,40,'薯片两份',2,'2022-05-19 00:00:00');
insert  into `order`(`id`,`student_id`,`dormitory_id`,`item`,`status`,`create_time`) values (6,70,40,'百事可乐2分',0,'2022-05-19 00:00:00');

/*Table structure for table `student` */

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `dormitory_id` int DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int DEFAULT NULL COMMENT '0代表注册未验证 1代表已验证',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb3;

/*Data for the table `student` */

insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (1,'张三','123','男','1231241',1,'2022-04-08 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (2,'李四','123','男','1231241',1,'2022-04-09 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (3,'王五','123','男','1231241',1,'2022-04-14 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (4,'赵六','123','男','1231241',1,'2022-04-14 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (5,'马陈超','123','男','1231241',2,'2022-04-14 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (6,'刘一磊','123','女','1231241',2,'2022-04-14 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (7,'熊林峰','123','男','1231241',2,'2022-04-14 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (8,'廖茂阳','123','男','1231241',2,'2022-04-14 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (9,'陈飞龙','123','女','1231241',3,'2022-04-14 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (10,'郭健','123','男','1231241',3,'2022-04-14 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (11,'段圣元','123','男','1231241',3,'2022-04-14 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (12,'杨星','123','男','1231241',3,'2022-04-14 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (67,'mcc','123','男','1231241',3,'2022-04-14 00:00:00',1);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (68,'test','123','男','123123',5,'2022-05-19 00:00:00',2);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (69,'马陈超2','123','男','123123',39,'2022-05-19 00:00:00',0);
insert  into `student`(`id`,`name`,`password`,`gender`,`telephone`,`dormitory_id`,`create_date`,`status`) values (70,'马陈超22','123','男','123123',40,'2022-05-19 00:00:00',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
