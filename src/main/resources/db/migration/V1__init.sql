-- MySQL dump 10.13  Distrib 5.7.28, for osx10.15 (x86_64)
--
-- Host: travle-with.c0tznjexiicb.ap-northeast-2.rds.amazonaws.com    Database: travel_with
-- ------------------------------------------------------
-- Server version	5.7.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED='';

--
-- Current Database: `travel_with`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `travel_with` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `travel_with`;

--
-- Table structure for table `companion`
--

DROP TABLE IF EXISTS `companion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `companion` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `schedule_id` int(10) unsigned DEFAULT NULL COMMENT '일정',
  `member_id` int(10) unsigned DEFAULT NULL COMMENT '회원',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성날짜',
  `updated_at` datetime DEFAULT NULL COMMENT '수정날짜',
  PRIMARY KEY (`id`),
  KEY `FK_companion_schedule_id_schedule_id` (`schedule_id`),
  KEY `FK_companion_member_id_member_id` (`member_id`),
  CONSTRAINT `FK_companion_member_id_member_id` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `FK_companion_schedule_id_schedule_id` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='여행 동반자';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companion`
--

LOCK TABLES `companion` WRITE;
/*!40000 ALTER TABLE `companion` DISABLE KEYS */;
/*!40000 ALTER TABLE `companion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `member_id` int(10) unsigned DEFAULT NULL COMMENT '쿠폰 소유자',
  `coupon_uuid` binary(16) NOT NULL COMMENT '쿠폰 고유번호',
  `use` bit(1) NOT NULL DEFAULT b'0' COMMENT '쿠폰 사용여부',
  `retire` bit(1) NOT NULL DEFAULT b'0' COMMENT '쿠폰 회수여부',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성날짜',
  `updated_at` datetime DEFAULT NULL COMMENT '수정날짜',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_coupon_uuid` (`coupon_uuid`),
  KEY `FK_coupon_member_id_member_id` (`member_id`),
  CONSTRAINT `FK_coupon_member_id_member_id` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='쿠폰';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `member_id` varchar(50) NOT NULL COMMENT '회원 아이디',
  `member_pw` varchar(200) NOT NULL COMMENT '회원 비밀번호',
  `name` varchar(50) NOT NULL COMMENT '회원 이름',
  `nickname` varchar(50) NOT NULL COMMENT '회원 별명',
  `sns_type` smallint(6) DEFAULT NULL COMMENT 'sns 계정연동 타입',
  `black` bit(1) DEFAULT NULL COMMENT '블랙리스트 여부',
  `member_type` smallint(6) DEFAULT NULL COMMENT '회원 타입',
  `dormant` bit(1) DEFAULT b'0' COMMENT '휴면 여부',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성날짜',
  `updated_at` datetime DEFAULT NULL COMMENT '수정날짜',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_member_id` (`member_id`),
  UNIQUE KEY `UC_nickname` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='회원';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_activity`
--

DROP TABLE IF EXISTS `member_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_activity` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `member_id` int(10) unsigned DEFAULT NULL COMMENT '회원',
  `like` int(11) DEFAULT NULL COMMENT '좋아요 (보류)',
  `hate` int(11) DEFAULT NULL COMMENT '싫어요 (보류)',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성날짜',
  `updated_at` datetime DEFAULT NULL COMMENT '수정날짜',
  PRIMARY KEY (`id`),
  KEY `FK_member_activity_member_id_member_id` (`member_id`),
  CONSTRAINT `FK_member_activity_member_id_member_id` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='회원 활동';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_activity`
--

LOCK TABLES `member_activity` WRITE;
/*!40000 ALTER TABLE `member_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `travel_id` int(10) unsigned NOT NULL COMMENT '여행',
  `name` varchar(70) NOT NULL COMMENT '일정명',
  `schedule_explain` varchar(200) DEFAULT NULL COMMENT '일정설명',
  `place_name` varchar(100) NOT NULL COMMENT '장소명',
  `place_explain` varchar(200) DEFAULT NULL COMMENT '장소설명',
  `lon` float DEFAULT NULL COMMENT '장소 경도',
  `lat` float DEFAULT NULL COMMENT '장소 위도',
  `start_date` datetime DEFAULT NULL COMMENT '일정시작날짜',
  `end_date` datetime DEFAULT NULL COMMENT '일정종료날짜',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성날짜',
  `updated_at` datetime DEFAULT NULL COMMENT '수정날짜',
  PRIMARY KEY (`id`),
  KEY `FK_schedule_travel_id_travel_id` (`travel_id`),
  CONSTRAINT `FK_schedule_travel_id_travel_id` FOREIGN KEY (`travel_id`) REFERENCES `travel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='일정';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel`
--

DROP TABLE IF EXISTS `travel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `travel` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(70) NOT NULL COMMENT '여행명',
  `travel_explain` varchar(200) DEFAULT NULL COMMENT '여행설명',
  `start_date` datetime NOT NULL COMMENT '여행시작날짜',
  `end_date` datetime DEFAULT NULL COMMENT '여행종료날짜',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성날짜',
  `updated_at` datetime DEFAULT NULL COMMENT '수정날짜',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='여행';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel`
--

LOCK TABLES `travel` WRITE;
/*!40000 ALTER TABLE `travel` DISABLE KEYS */;
INSERT INTO `travel` VALUES (1,'첫번째여행','첫번째여행입니다.','2019-11-05 00:09:07','2019-11-05 00:09:11','2019-11-04 15:09:14',NULL);
/*!40000 ALTER TABLE `travel` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-06 19:08:51
