-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: sportup-spring
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `biomedical_data`
--

DROP TABLE IF EXISTS `biomedical_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `biomedical_data` (
  `id_biomedical_data` int(11) NOT NULL AUTO_INCREMENT,
  `blood_pressure` int(11) DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `fat_free_mass` float DEFAULT NULL,
  `fat_mass` float DEFAULT NULL,
  `hearthbeat` int(11) DEFAULT NULL,
  `height` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  PRIMARY KEY (`id_biomedical_data`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biomedical_data`
--

LOCK TABLES `biomedical_data` WRITE;
/*!40000 ALTER TABLE `biomedical_data` DISABLE KEYS */;
INSERT INTO `biomedical_data` VALUES (1,56,0,65,66,65,65,65);
/*!40000 ALTER TABLE `biomedical_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `daily`
--

DROP TABLE IF EXISTS `daily`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `daily` (
  `id_day` int(11) NOT NULL AUTO_INCREMENT,
  `breakfast` varchar(255) DEFAULT NULL,
  `day` varchar(255) DEFAULT NULL,
  `dinner` varchar(255) DEFAULT NULL,
  `lunch` varchar(255) DEFAULT NULL,
  `snack` varchar(255) DEFAULT NULL,
  `snack_afternoon` varchar(255) DEFAULT NULL,
  `id_diet` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_day`),
  KEY `FK5msco98b9p9ub9fxrmtse122m` (`id_diet`),
  CONSTRAINT `FK5msco98b9p9ub9fxrmtse122m` FOREIGN KEY (`id_diet`) REFERENCES `diet` (`id_diet`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily`
--

LOCK TABLES `daily` WRITE;
/*!40000 ALTER TABLE `daily` DISABLE KEYS */;
INSERT INTO `daily` VALUES (1,'ffd','dfrd','dfd','dfd','dfd','dfd',1);
/*!40000 ALTER TABLE `daily` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diet`
--

DROP TABLE IF EXISTS `diet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `diet` (
  `id_diet` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_diet`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diet`
--

LOCK TABLES `diet` WRITE;
/*!40000 ALTER TABLE `diet` DISABLE KEYS */;
INSERT INTO `diet` VALUES (1);
/*!40000 ALTER TABLE `diet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performance`
--

DROP TABLE IF EXISTS `performance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `performance` (
  `id_performance` int(11) NOT NULL AUTO_INCREMENT,
  `max_addominali` int(11) DEFAULT NULL,
  `max_corsa_min` int(11) DEFAULT NULL,
  `max_flessioni` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_performance`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performance`
--

LOCK TABLES `performance` WRITE;
/*!40000 ALTER TABLE `performance` DISABLE KEYS */;
INSERT INTO `performance` VALUES (1,44,443,3);
/*!40000 ALTER TABLE `performance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `player` (
  `id_player` int(11) NOT NULL,
  `id_biomedical_data` int(11) DEFAULT NULL,
  `id_diet` int(11) DEFAULT NULL,
  `id_performance` int(11) DEFAULT NULL,
  `id_training` int(11) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `ruolo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_player`),
  UNIQUE KEY `UK_6dqygs3ahi6bdfr6973p5fmqs` (`id_biomedical_data`),
  UNIQUE KEY `UK_s9g1w2pa7vk77l37o28076amr` (`id_diet`),
  UNIQUE KEY `UK_reim05jv9i5fv7menunkya7ni` (`id_performance`),
  KEY `FK5x8cf448dqeq0qmwuhycg85aa` (`id_training`),
  CONSTRAINT `FK5x8cf448dqeq0qmwuhycg85aa` FOREIGN KEY (`id_training`) REFERENCES `training` (`id_training`),
  CONSTRAINT `FK8ueyfgqoem7p9l6uncm01w1cj` FOREIGN KEY (`id_player`) REFERENCES `user` (`id_user`) ON DELETE CASCADE,
  CONSTRAINT `FKaboj8rvfeekk0mv31r1hx6c6k` FOREIGN KEY (`id_diet`) REFERENCES `diet` (`id_diet`),
  CONSTRAINT `FKkime3y1t8q14xh2vf3g5skmvm` FOREIGN KEY (`id_biomedical_data`) REFERENCES `biomedical_data` (`id_biomedical_data`),
  CONSTRAINT `FKon88sf3yvdfu5gf1j1w7y8rnh` FOREIGN KEY (`id_performance`) REFERENCES `performance` (`id_performance`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (3,1,1,1,1,'ff','ffdf');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_team`
--

DROP TABLE IF EXISTS `player_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `player_team` (
  `player_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  PRIMARY KEY (`player_id`,`team_id`),
  KEY `FK9axcbkwl4aiy4b9stqe31q2k` (`team_id`),
  CONSTRAINT `FK9axcbkwl4aiy4b9stqe31q2k` FOREIGN KEY (`team_id`) REFERENCES `team` (`id_team`) ON DELETE CASCADE,
  CONSTRAINT `FKi5rpfhkcbhcotndp7k623f4y0` FOREIGN KEY (`player_id`) REFERENCES `player` (`id_player`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_team`
--

LOCK TABLES `player_team` WRITE;
/*!40000 ALTER TABLE `player_team` DISABLE KEYS */;
INSERT INTO `player_team` VALUES (3,1);
/*!40000 ALTER TABLE `player_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `team` (
  `id_team` int(11) NOT NULL AUTO_INCREMENT,
  `info` varchar(255) NOT NULL,
  PRIMARY KEY (`id_team`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'rfdfd');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training`
--

DROP TABLE IF EXISTS `training`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `training` (
  `id_training` int(11) NOT NULL AUTO_INCREMENT,
  `info` varchar(255) NOT NULL,
  PRIMARY KEY (`id_training`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,'fdfd');
/*!40000 ALTER TABLE `training` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_card`
--

DROP TABLE IF EXISTS `training_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `training_card` (
  `id_training_card` int(11) NOT NULL AUTO_INCREMENT,
  `deleted` int(11) DEFAULT NULL,
  `friday` varchar(255) DEFAULT NULL,
  `monday` varchar(255) NOT NULL,
  `saturday` varchar(255) DEFAULT NULL,
  `sunday` varchar(255) DEFAULT NULL,
  `thursday` varchar(255) DEFAULT NULL,
  `tuesday` varchar(255) NOT NULL,
  `wednesday` varchar(255) DEFAULT NULL,
  `id_training` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_training_card`),
  KEY `FKsw6y9m7oydhfr4saqqb81q1lw` (`id_training`),
  CONSTRAINT `FKsw6y9m7oydhfr4saqqb81q1lw` FOREIGN KEY (`id_training`) REFERENCES `training` (`id_training`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_card`
--

LOCK TABLES `training_card` WRITE;
/*!40000 ALTER TABLE `training_card` DISABLE KEYS */;
INSERT INTO `training_card` VALUES (1,0,'ftf','ftf','ffd','dfrd','dfd','dfrd','fdfd',1);
/*!40000 ALTER TABLE `training_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','admin'),(2,'trainer','trainer','trainer'),(3,'player','player','player');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-22 11:54:04
