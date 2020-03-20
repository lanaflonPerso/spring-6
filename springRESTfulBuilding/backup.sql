DROP TABLE IF EXISTS `adresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adresse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `pays` varchar(255) DEFAULT NULL,
  `positiongps` varchar(255) DEFAULT NULL,
  `rue` varchar(255) DEFAULT NULL,
  `vile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adresse`
--

LOCK TABLES `adresse` WRITE;
/*!40000 ALTER TABLE `adresse` DISABLE KEYS */;
INSERT INTO `adresse` VALUES (1,112,'France','43.607505, 3.883095','rue comédie','Paris'),(2,45,'France','18.443534, 4.654765','rue luxemburng','lyon');
/*!40000 ALTER TABLE `adresse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agence_voyage`
--

DROP TABLE IF EXISTS `agence_voyage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agence_voyage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tarif` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agence_voyage`
--

LOCK TABLES `agence_voyage` WRITE;
/*!40000 ALTER TABLE `agence_voyage` DISABLE KEYS */;
INSERT INTO `agence_voyage` VALUES (3,'karim','lundi au soleil','dahdouh',7.5),(4,'takeyourbreath','take you breath','thekr43',5.4);
/*!40000 ALTER TABLE `agence_voyage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chambre`
--

DROP TABLE IF EXISTS `chambre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chambre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `disponible` varchar(255) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `prix` double NOT NULL,
  `type_lit` varchar(255) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaky3rlylfxbs2hgwjcwgjkghc` (`hotel_id`),
  CONSTRAINT `FKaky3rlylfxbs2hgwjcwgjkghc` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chambre`
--

LOCK TABLES `chambre` WRITE;
/*!40000 ALTER TABLE `chambre` DISABLE KEYS */;
INSERT INTO `chambre` VALUES (1,'yes',75,66.99,'lit simple',1),(2,'yes',37,90.5,'lit double',1),(3,'no',20,84,'lit double',1),(4,'no',54,40.99,'lit simple',2),(5,'yes',54,40,'lit simple',2),(6,'ye',20,84,'lit double',2);
/*!40000 ALTER TABLE `chambre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carte_credit` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (7,'400999582383472','Theirno','Barry'),(10,'5088734328394382','Barry','Theirno'),(11,'4293348','dahdouh','karim'),(12,'3491840093','dahdouh','karim'),(13,'3819284839124','dahdouh','karim'),(14,'3819284839124','hhhhhhhhhhhh','ooooooooooooooo'),(15,'42383492','bbb','aaa'),(16,'650999545352','Zainoul','Theirno'),(17,'5868958948555','test_nom','test_prenom'),(18,'887756738495','Matinize','Sebastiane'),(19,'5868958948555','test_nom','test_nom'),(20,'88679000037827','Boutonnet','Audry'),(21,'456660089564','todorov','audrey'),(22,'42383492','kkkkk','kkljlk'),(23,'655547990842','Martinize','Jean-Luc');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (58,'Samwise Gamgee','gardener'),(59,'Barry Zainoul','Senior Data scientist'),(60,'karim dahdouh','developper fullstack'),(61,'Rida Dahdouh','Consultant');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `greeting`
--

DROP TABLE IF EXISTS `greeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `greeting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `greeting`
--

LOCK TABLES `greeting` WRITE;
/*!40000 ALTER TABLE `greeting` DISABLE KEYS */;
/*!40000 ALTER TABLE `greeting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (87);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `nombre_etoiles` int(11) NOT NULL,
  `nombre_lits` int(11) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd8k0mtc92j1xc4wg75pbx6fsq` (`address_id`),
  CONSTRAINT `FKd8k0mtc92j1xc4wg75pbx6fsq` FOREIGN KEY (`address_id`) REFERENCES `adresse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'Hotel A',5,90,1),(2,'Hotel B',4,80,2);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `date_arrivee` varchar(255) DEFAULT NULL,
  `date_depart` varchar(255) DEFAULT NULL,
  `agence_voyage_id` int(11) DEFAULT NULL,
  `chambre_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK40tsk8gdltyr9sba88lutcjox` (`agence_voyage_id`),
  KEY `FKdqj45imhck9x1xd2b8l3oi05t` (`chambre_id`),
  KEY `FKoewar6f18rkn4iptr6da4oysv` (`client_id`),
  CONSTRAINT `FK40tsk8gdltyr9sba88lutcjox` FOREIGN KEY (`agence_voyage_id`) REFERENCES `agence_voyage` (`id`),
  CONSTRAINT `FKdqj45imhck9x1xd2b8l3oi05t` FOREIGN KEY (`chambre_id`) REFERENCES `chambre` (`id`),
  CONSTRAINT `FKoewar6f18rkn4iptr6da4oysv` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (39,'2020-03-05','2020-03-09',3,1,10),(40,'2020-03-05','2020-03-09',3,1,NULL),(41,'2020-03-05','2020-03-09',3,1,NULL),(42,'2020-03-05','2020-03-09',NULL,1,NULL),(43,'2020-03-05','2020-03-09',NULL,1,NULL),(44,'2020-03-05','2020-03-09',3,1,NULL),(45,'2020-03-05','2020-03-09',3,1,15),(46,'2020-03-05','2020-03-09',3,1,15),(47,'2020-03-05','2020-03-09',3,1,15),(48,'2020-03-05','2020-03-09',3,1,15),(49,'2020-03-05','2020-03-09',3,1,15),(50,'2020-03-05','2020-03-09',3,1,15),(51,'2020-03-05','2020-03-09',3,1,15),(52,'2020-03-05','2020-03-09',3,1,15),(53,'2020-03-05','2020-03-09',3,1,15),(54,'2020-03-05','2020-03-09',3,1,15),(55,'2020-03-05','2020-03-09',3,1,15),(56,'2020-03-05','2020-03-09',3,1,15),(57,'2020-03-05','2020-03-09',3,1,NULL),(62,'2020-03-05','2020-03-09',3,1,NULL),(63,'2020-03-05','2020-03-09',3,1,NULL),(64,'2020-03-05','2020-03-09',3,1,17),(65,'2020-03-05','2020-03-09',3,1,17),(66,'2020-03-05','2020-03-09',3,1,17),(67,'2020-03-05','2020-03-09',3,1,18),(68,'2020-03-05','2020-03-09',3,1,19),(69,'2020-03-05','2020-03-09',3,1,20),(70,'2020-03-05','2020-03-09',3,1,20),(71,'2020-03-05','2020-03-09',3,1,20),(72,'2020-03-05','2020-03-09',3,1,20),(73,'2020-03-05','2020-03-09',3,1,7),(74,'2020-03-05','2020-03-09',3,1,18),(75,'2020-03-05','2020-03-09',3,1,18),(76,'2020-03-05','2020-03-09',3,1,18),(77,'2020-03-05','2020-03-09',3,1,18),(78,'2020-03-05','2020-03-09',3,1,19),(79,'2020-03-05','2020-03-09',3,1,20),(80,'2020-03-05','2020-03-09',3,1,19),(81,'2020-03-05','2020-03-09',3,1,19),(82,'2020-03-05','2020-03-09',3,1,19),(83,'2020-03-05','2020-03-09',3,1,21),(84,'2020-03-05','2020-03-09',3,1,22),(85,'2020-03-05','2020-03-09',3,1,23),(86,'2020-03-05','2020-03-09',3,1,18);
