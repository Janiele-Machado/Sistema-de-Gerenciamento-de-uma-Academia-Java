-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: academia_db
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `adm`
--

DROP TABLE IF EXISTS `adm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adm` (
  `id` int NOT NULL AUTO_INCREMENT,
  `salario` decimal(10,2) DEFAULT NULL,
  `telefone_comercial` varchar(20) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `setor` varchar(20) DEFAULT NULL,
  `fk_usu_adm` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usu_adm` (`fk_usu_adm`),
  CONSTRAINT `fk_usu_adm` FOREIGN KEY (`fk_usu_adm`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adm`
--

LOCK TABLES `adm` WRITE;
/*!40000 ALTER TABLE `adm` DISABLE KEYS */;
INSERT INTO `adm` VALUES (1,4500.00,'(48) 99999-8888','Administrador geral da unidade','geral',3);
/*!40000 ALTER TABLE `adm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(20) DEFAULT 'ativo',
  `matricula` varchar(20) DEFAULT NULL,
  `objetivo` text,
  `fk_usu_aluno` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula` (`matricula`),
  KEY `fk_usu_aluno` (`fk_usu_aluno`),
  CONSTRAINT `fk_usu_aluno` FOREIGN KEY (`fk_usu_aluno`) REFERENCES `usuario` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'ativo','MAT2023001','Perder peso e ganhar resistência',1),(2,'ativo','MAT2023011','Ganhar Musculos',4),(3,'ativo','Mat2028888','PerderPeso',5);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assinatura`
--

DROP TABLE IF EXISTS `assinatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assinatura` (
  `id` int NOT NULL AUTO_INCREMENT,
  `aluno_id` int DEFAULT NULL,
  `personal_id` int DEFAULT NULL,
  `nome_plano` varchar(100) DEFAULT NULL,
  `duracao_meses` int DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `ativa` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `aluno_id` (`aluno_id`),
  KEY `personal_id` (`personal_id`),
  CONSTRAINT `aluno_id` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `personal_id` FOREIGN KEY (`personal_id`) REFERENCES `personal` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assinatura`
--

LOCK TABLES `assinatura` WRITE;
/*!40000 ALTER TABLE `assinatura` DISABLE KEYS */;
INSERT INTO `assinatura` VALUES (1,1,2,'Plano Trimestral',3,450.00,'2025-04-19','2025-07-18','sim');
/*!40000 ALTER TABLE `assinatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financa`
--

DROP TABLE IF EXISTS `financa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `financa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario_id` int DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `data_pagamento` date DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `financa_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financa`
--

LOCK TABLES `financa` WRITE;
/*!40000 ALTER TABLE `financa` DISABLE KEYS */;
INSERT INTO `financa` VALUES (1,1,450.00,'2025-04-19','mensalidade'),(2,2,200.00,'2025-04-19','bônus'),(3,3,4500.00,'2025-04-19','salario');
/*!40000 ALTER TABLE `financa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `salario` decimal(10,2) DEFAULT NULL,
  `bonus_por_aluno` decimal(10,2) DEFAULT NULL,
  `especialidade` varchar(100) DEFAULT NULL,
  `fk_usu_personal` int DEFAULT NULL,
  `quant_alunos` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usu_personal` (`fk_usu_personal`),
  CONSTRAINT `fk_usu_personal` FOREIGN KEY (`fk_usu_personal`) REFERENCES `usuario` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` VALUES (2,3500.00,0.00,'Musculação',2,0),(3,1500.00,0.00,'Zumba',6,0);
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Ana Silva','123.456.789-00','ana@email.com','1990-05-15','senha123','aluno'),(2,'Bruno Costa','321.654.987-00','bruno@email.com','1985-08-10','seguro456','personal'),(3,'Carlos Dias','111.222.333-44','carlos@email.com','1975-01-20','adm123','adm'),(4,'Manuela Hija','299.000.900-88','manu@gmail.com','2000-09-07','mani111','aluno'),(5,'Maria Gomes','120.890.890-89','mary@gmail.com','2005-09-23','kika233','aluno'),(6,'Carlos Gal','144.999.000.00','Cal@gmail.com','2000-08-08','cal122','personal');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-28 11:01:04
