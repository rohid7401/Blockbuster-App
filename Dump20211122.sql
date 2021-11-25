-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: blockbuster
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` int NOT NULL,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Action'),(2,'Sci-fi'),(3,'Drama'),(4,'Fantasy'),(5,'Comedy'),(6,'Adventure'),(7,'Romance'),(8,'Suspense'),(9,'Thriller'),(10,'Musical');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cedula` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(50) DEFAULT 'N/A',
  `telefono` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Andrea','Baldioceda','Liberia','84123456'),(2,'Adrian','Parajeles','Cañas','87654321'),(3,'Alberto','Sandi','Guapiles','42680135'),(4,'Jocxan','Sandi','Siquirres','98765432'),(5,'Paul','Bogantes','Barranca','24941234'),(6,'Fabiola','Quesada','Guacimo','24949876'),(7,'Brayan','Bonilla','San Juan','56892317'),(8,'Cristian','Perez','N/A','42687139'),(9,'Kenneth','Mendoza','Tacares','78561234'),(10,'Rohi','Prendas','Guanacaste','91378624');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `codigo` int NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `fecha_lanzamiento` date DEFAULT NULL,
  `categoria` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,'Godzilla vs. Kong','2021-03-31','Sci-fi'),(2,'Venom','2018-10-05','Action'),(3,'Soul ','2020-10-11','Family'),(4,'Spider-Man: Far from Home','2019-05-02','Action'),(5,'Joker','2019-10-04','Drama '),(6,'Avengers: Endgame','2019-04-26','Action'),(7,'The Chronicles of Narnia','2010-12-10','Fantasy'),(8,'Nanny McPhee Returns','2010-04-02','Comedy '),(9,'How to Train Your Dragon','2010-03-21','Adventure '),(10,'Toy Story 3','2010-05-18','Comedy');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamo` (
  `cedula` int NOT NULL,
  `codigo` int NOT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `fecha_prestamo` date DEFAULT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  PRIMARY KEY (`cedula`,`codigo`),
  KEY `codigo_fk` (`codigo`),
  CONSTRAINT `cedula_fk` FOREIGN KEY (`cedula`) REFERENCES `cliente` (`cedula`),
  CONSTRAINT `codigo_fk` FOREIGN KEY (`codigo`) REFERENCES `pelicula` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` VALUES (1,1,'activo','2021-09-30','2021-10-03'),(1,2,'inactivo','2021-08-18','2021-08-21'),(1,3,'activo','2021-09-30','2021-10-03'),(2,4,'inactivo','2021-07-30','2021-08-02'),(3,5,'activo','2021-10-01','2021-10-04'),(4,6,'inactivo','2021-09-27','2021-09-30'),(5,7,'inactivo','2021-09-25','2021-09-28'),(6,8,'activo','2021-09-30','2021-10-03'),(7,9,'inactivo','2021-09-21','2021-09-24'),(7,10,'activo','2021-01-30','2021-02-02');
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'blockbuster'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-22 21:19:27

drop user if exists 'blockbusterappuser@localhost';
create user if not exists 'blockbusterappuser@localhost' identified by 'blockbusterapppass';

grant select, insert, update, delete, execute on blockbuster.* to 'blockbusterappuser@localhost';

SET autocommit = OFF;