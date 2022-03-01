   -- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: botpoc
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bot_condition_table`
--

DROP TABLE IF EXISTS `bot_condition_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bot_condition_table` (
  `id` char(36) NOT NULL,
  `condition` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `time_frame` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bot_condition_table`
--

LOCK TABLES `bot_condition_table` WRITE;
/*!40000 ALTER TABLE `bot_condition_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `bot_condition_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bot_content_table`
--

DROP TABLE IF EXISTS `bot_content_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bot_content_table` (
  `id` int NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bot_content_table`
--

LOCK TABLES `bot_content_table` WRITE;
/*!40000 ALTER TABLE `bot_content_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `bot_content_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bot_info_table`
--

DROP TABLE IF EXISTS `bot_info_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bot_info_table` (
  `id` int NOT NULL,
  `bot_type` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `tenant_id` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bot_info_table`
--

LOCK TABLES `bot_info_table` WRITE;
/*!40000 ALTER TABLE `bot_info_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `bot_info_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bot_info_table_methods`
--

DROP TABLE IF EXISTS `bot_info_table_methods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bot_info_table_methods` (
  `bot_info_id` int NOT NULL,
  `methods_id` int NOT NULL,
  UNIQUE KEY `UK_gy230q4076yruahctnf15mwoj` (`methods_id`),
  KEY `FKfpwed3egdtjtkjk4yna6h273u` (`bot_info_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bot_info_table_methods`
--

LOCK TABLES `bot_info_table_methods` WRITE;
/*!40000 ALTER TABLE `bot_info_table_methods` DISABLE KEYS */;
/*!40000 ALTER TABLE `bot_info_table_methods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bot_receiver_class`
--

DROP TABLE IF EXISTS `bot_receiver_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bot_receiver_class` (
  `id` int NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bot_receiver_class`
--

LOCK TABLES `bot_receiver_class` WRITE;
/*!40000 ALTER TABLE `bot_receiver_class` DISABLE KEYS */;
/*!40000 ALTER TABLE `bot_receiver_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bot_schedule_table`
--

DROP TABLE IF EXISTS `bot_schedule_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bot_schedule_table` (
  `id` int NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `day` bigint DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `trigger` varchar(255) DEFAULT NULL,
  `trigger_type` varchar(255) DEFAULT NULL,
  `week` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bot_schedule_table`
--

LOCK TABLES `bot_schedule_table` WRITE;
/*!40000 ALTER TABLE `bot_schedule_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `bot_schedule_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-15 12:44:52
