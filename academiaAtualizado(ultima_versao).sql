CREATE DATABASE  IF NOT EXISTS `academia_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `academia_db`;
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adm`
--

LOCK TABLES `adm` WRITE;
/*!40000 ALTER TABLE `adm` DISABLE KEYS */;
INSERT INTO `adm` VALUES (1,1500.00,'(48) 99999-8888','Administrador geral da unidade','geral',3),(4,1500.00,'(61) 998674563','Eu administro tudo','Geral',9),(6,1500.00,'(62) 998765438','Eu administro o setor comercial','Comercial',13);
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
  CONSTRAINT `fk_usu_aluno` FOREIGN KEY (`fk_usu_aluno`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'ativo','MAT2023001','Perder peso e ganhar resistência',1),(2,'ativo','MAT2023011','Ganhar Musculos',4),(3,'ativo','Mat2028888','PerderPeso',5),(4,'ativo','MAT97763622','Ficar mais saudavel',7),(5,'ativo','MAT48866098','Ficar Musculosa',8),(7,'ativo','MAT63348762','Sair do sedentarismo',17),(8,'ativo','MAT28468856','Ficar musculoso',18),(9,'ativo','MAT69823345','Ficar magra',19),(10,'ativo','MAT80923523','Ganhar peso',23),(11,'ativo','MAT97161127','sair do sedentarismo',24),(12,'ativo','MAT15975328','Ganhar massa muscular',43),(13,'ativo','MAT85214796','Perder peso',44),(14,'ativo','MAT36925814','Melhorar condicionamento físico',47),(15,'ativo','MAT74185296','Aumento de força',48),(16,'ativo','MAT96325874','Definição muscular',49),(17,'ativo','MAT03698521','Saúde e bem-estar',50),(18,'ativo','MAT47852369','Melhora da postura',51),(19,'ativo','MAT25896314','Aumento da flexibilidade',52),(20,'ativo','MAT69321478','Preparo físico geral',53),(21,'ativo','MAT01478529','Redução de medidas',54),(22,'ativo','MAT76088916','Condicionamento fisico',55);
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assinatura`
--

LOCK TABLES `assinatura` WRITE;
/*!40000 ALTER TABLE `assinatura` DISABLE KEYS */;
INSERT INTO `assinatura` VALUES (1,1,2,'Plano Premium',3,100.00,'2025-04-19','2025-07-18','nao'),(2,3,NULL,'Plano Comum',1,100.00,'2025-04-30','2025-05-30','sim'),(5,2,NULL,'Plano Comum',1,120.00,'2025-05-01','2025-06-01','sim'),(6,3,3,'Plano Premium',3,100.00,'2025-05-01','2025-08-01','sim'),(8,4,2,'Plano Premium',3,100.00,'2025-05-01','2025-08-01','sim'),(9,5,3,'Plano Premium Plus',12,90.00,'2025-05-01','2026-05-01','sim'),(10,5,NULL,'Plano Comum',1,120.00,'2025-05-08','2025-06-08','sim'),(11,7,7,'Plano Premium Plus',12,90.00,'2025-05-08','2026-05-08','sim'),(12,9,8,'Plano Premium',3,100.00,'2025-05-08','2025-08-08','sim'),(14,16,15,'Plano Premium Plus',12,90.00,'2025-05-08','2026-05-08','sim'),(15,21,16,'Plano Premium Plus',12,90.00,'2025-05-08','2026-05-08','sim'),(16,12,NULL,'Plano Comum',1,120.00,'2025-05-08','2025-06-08','sim'),(17,17,12,'Plano Premium Plus',12,90.00,'2025-05-08','2026-05-08','sim'),(18,20,NULL,'Plano Comum',1,120.00,'2025-05-09','2025-06-09','sim'),(19,18,8,'Plano Premium Plus',12,90.00,'2025-05-09','2026-05-09','sim'),(21,14,7,'Plano Premium',3,100.00,'2025-05-09','2025-08-09','sim'),(22,15,NULL,'Plano Comum',1,120.00,'2025-05-09','2025-06-09','sim'),(23,22,16,'Plano Premium',3,100.00,'2025-05-09','2025-08-09','sim');
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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financa`
--

LOCK TABLES `financa` WRITE;
/*!40000 ALTER TABLE `financa` DISABLE KEYS */;
INSERT INTO `financa` VALUES (1,1,100.00,'2025-04-19','mensalidade'),(2,2,100.00,'2025-04-19','bônus'),(3,3,1300.00,'2025-04-19','salario'),(4,7,75.00,'2025-05-02','Mensalidade'),(5,9,1500.00,'2025-05-02','Salario'),(6,6,100.00,'2025-05-08','bonus'),(8,9,1200.00,'2025-05-08','Salario'),(9,9,300.00,'2025-05-08','Salario'),(10,6,100.00,'2025-05-08','bonus'),(11,2,100.00,'2025-05-08','bonus'),(12,17,90.00,'2025-05-08','Mensalidade'),(13,19,100.00,'2025-05-08','Mensalidade'),(14,49,100.00,'2025-05-08','Mensalidade'),(15,39,50.00,'2025-05-08','bonus'),(16,54,1000.00,'2025-05-08','Mensalidade'),(17,50,1000.00,'2025-05-08','Mensalidade'),(18,36,50.00,'2025-05-08','bonus'),(19,40,50.00,'2025-05-08','bonus'),(20,39,50.00,'2025-05-08','bonus'),(21,9,100.00,'2025-05-08','Salario'),(22,50,1000.00,'2025-05-09','Mensalidade'),(23,53,1200.00,'2025-05-09','Mensalidade'),(24,53,1200.00,'2025-05-09','Mensalidade'),(25,47,100.00,'2025-05-09','Mensalidade'),(26,22,100.00,'2025-05-09','bonus'),(27,21,100.00,'2025-05-09','bonus'),(28,43,1000.00,'2025-05-09','Mensalidade'),(29,9,50.00,'2025-05-09','Salario'),(30,48,1200.00,'2025-05-09','Mensalidade'),(31,51,1200.00,'2025-05-09','Mensalidade'),(32,53,1300.00,'2025-05-09','Mensalidade'),(33,7,1200.00,'2025-05-09','Mensalidade'),(34,1,1200.00,'2025-05-09','Mensalidade'),(35,43,1200.00,'2025-05-09','Mensalidade'),(36,55,1200.00,'2025-05-09','Mensalidade'),(37,40,100.00,'2025-05-09','bonus'),(38,51,1200.00,'2025-05-09','Mensalidade'),(39,48,1200.00,'2025-05-09','Mensalidade');
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
  CONSTRAINT `fk_usu_personal` FOREIGN KEY (`fk_usu_personal`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` VALUES (2,1200.00,100.00,'Musculação',2,2),(3,1200.00,100.00,'Zumba',6,2),(7,1200.00,100.00,'Treinamento para Terceira Idade',21,2),(8,1200.00,100.00,'Treinamento para Corrida e Maratona',22,2),(12,1200.00,50.00,'Pilates',36,1),(15,1200.00,50.00,'Lutas',39,1),(16,1200.00,100.00,'Corrida',40,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Ana Silva Gomes','123.456.789-00','ana@gmail.com','1990-05-15','senha123','aluno'),(2,'Bruno Costa','321.654.987-00','bruno@email.com','1985-08-10','seguro456','personal'),(3,'Carlos Dias','111.222.333-44','carlos@email.com','1975-01-20','adm123','adm'),(4,'Manuela Hija','299.000.900-88','manu@gmail.com','2000-09-07','mani111','aluno'),(5,'Maria Gomes','120.890.890-89','mary@gmail.com','2005-09-23','kika233','aluno'),(6,'Carlos Gal','144.999.000.00','Cal@gmail.com','2000-08-08','cal122','personal'),(7,'Kaio Borges','234.456.789-12','kkaio@gamil.com','2003-03-12','caiu123','aluno'),(8,'Jaciara Lima','123.456.987-09','jaci@gmail.com','2001-09-23','jaci09','aluno'),(9,'Pietro Gomes','234.908.231-09','adm1@gmail.com','1988-03-31','adm1','adm'),(13,'Maia Linn','123.432.479-09','Linn@gmail.com','2002-02-12','linn09','adm'),(17,'Cleide Guimaras','209.093.321-09','clei@hotmain.com','2000-03-09','clei90','aluno'),(18,'Calos Lima','309.098.879-09','calos@gmail.com','2009-09-09','lima34','aluno'),(19,'Kallita Borges','890.874.099.00','aluno1@gmail.com','2000-09-07','aluno1','aluno'),(21,'Mia Carmo','209.098.567-09','mia@gmail.com','1998-03-23','mia456','personal'),(22,'Luana Borges','324.098.789-63','lulu@hotmain.com','2003-03-09','per1','personal'),(23,'Samuel Mendonça','093.345.213-03','samuu@gmail.com','2004-05-06','samu32','aluno'),(24,'Nathalia Mattes','234.657.439-34','nat@gmail.com','2004-12-30','nat666','aluno'),(36,'Juliana Alves Costa','789.654.321-00','juliana.c@vidasaudavel.org','1994-02-28','juju89','personal'),(39,'Marcelo Fernandes Lima','654.987.321-33','marcelo.l@treinador.net','1980-12-22','camil21','personal'),(40,'Camila Costa Pereira','987.321.654-44','camila.p@fitnesslife.org','1993-08-01','senha098','personal'),(43,'Ana Beatriz Souza','012.345.678-90','ana.b@estudante.com','2005-03-10','linda2','aluno'),(44,'Bruno Mendes Costa','987.654.321-01','bruno.m@alunoonline.br','2003-11-22','deert56','aluno'),(47,'Carla Rodrigues Alves','111.222.999-44','carla.r@estudar.net','2006-07-05','kgmkltn','aluno'),(48,'Daniel Pereira Lima','555.666.777-88','daniel.p@mailaluno.org','2004-01-15','kiogjt4oign','aluno'),(49,'Emilly Souza Gomes','222.333.444-55','emilly.s@alunomail.com','2007-09-30','12344gg','aluno'),(50,'Felipe Oliveira Rocha','666.777.888-99','felipe.o@estudando.br','2002-05-28','fefe43','aluno'),(51,'Giovanna Alves Costa','333.444.555-66','giovanna.a@alunotop.net','2006-12-01','jnjkanve2','aluno'),(52,'Henrique Lima Pereira','777.888.999-00','henrique.l@estudativo.org','2004-08-12','mkrmnbl','aluno'),(53,'Isabela Rocha Souza','444.555.666-77','isabela.r@alunofocado.com','2007-02-20','0933gg','aluno'),(54,'João Vitor Fernandes','888.999.000-11','joao.f@meualuno.br','2003-06-08','hk65322','aluno'),(55,'Lia Shan','082.239.832-98','shan@gmail.com','2000-02-09','kuki21','aluno');
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

-- Dump completed on 2025-05-09 11:57:53
