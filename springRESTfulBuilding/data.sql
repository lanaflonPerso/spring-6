LOCK TABLES `adresse` WRITE;
/*!40000 ALTER TABLE `adresse` DISABLE KEYS */;
INSERT INTO `adresse` VALUES (1,112,'France','43.607505, 3.883095','rue comédie','Paris'),(2,45,'France','18.443534, 4.654765','rue luxemburng','lyon');
/*!40000 ALTER TABLE `adresse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `agence_voyage`
--

LOCK TABLES `agence_voyage` WRITE;
/*!40000 ALTER TABLE `agence_voyage` DISABLE KEYS */;
INSERT INTO `agence_voyage` VALUES (3,'karim','lundi au soleil','dahdouh',7.5),(4,'takeyourbreath','take you breath','thekr43',5.4);
/*!40000 ALTER TABLE `agence_voyage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `chambre`
--

LOCK TABLES `chambre` WRITE;
/*!40000 ALTER TABLE `chambre` DISABLE KEYS */;
INSERT INTO `chambre` VALUES (1,'yes',75,66.99,'lit simple',1),(2,'yes',37,90.5,'lit double',1),(3,'no',20,84,'lit double',1),(4,'no',54,40.99,'lit simple',2),(5,'yes',54,40,'lit simple',2),(6,'ye',20,84,'lit double',2);
/*!40000 ALTER TABLE `chambre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (7,'400999582383472','Theirno','Barry'),(10,'5088734328394382','Barry','Theirno'),(11,'4293348','dahdouh','karim'),(12,'3491840093','dahdouh','karim'),(13,'3819284839124','dahdouh','karim'),(14,'3819284839124','hhhhhhhhhhhh','ooooooooooooooo'),(15,'42383492','bbb','aaa'),(16,'650999545352','Zainoul','Theirno'),(17,'5868958948555','test_nom','test_prenom'),(18,'887756738495','Matinize','Sebastiane'),(19,'5868958948555','test_nom','test_nom'),(20,'88679000037827','Boutonnet','Audry'),(21,'456660089564','todorov','audrey'),(22,'42383492','kkkkk','kkljlk'),(23,'655547990842','Martinize','Jean-Luc');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (87);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hotel`
--

 

INSERT INTO `hotel` VALUES (1,'Hotel A',5,90,1),(2,'Hotel B',4,80,2);


INSERT INTO `reservation` VALUES (39,'2020-03-05','2020-03-09',3,1,10),(40,'2020-03-05','2020-03-09',3,1,NULL),(41,'2020-03-05','2020-03-09',3,1,NULL),(42,'2020-03-05','2020-03-09',NULL,1,NULL),(43,'2020-03-05','2020-03-09',NULL,1,NULL),(44,'2020-03-05','2020-03-09',3,1,NULL),(45,'2020-03-05','2020-03-09',3,1,15),(46,'2020-03-05','2020-03-09',3,1,15),(47,'2020-03-05','2020-03-09',3,1,15),(48,'2020-03-05','2020-03-09',3,1,15),(49,'2020-03-05','2020-03-09',3,1,15),(50,'2020-03-05','2020-03-09',3,1,15),(51,'2020-03-05','2020-03-09',3,1,15),(52,'2020-03-05','2020-03-09',3,1,15),(53,'2020-03-05','2020-03-09',3,1,15),(54,'2020-03-05','2020-03-09',3,1,15),(55,'2020-03-05','2020-03-09',3,1,15),(56,'2020-03-05','2020-03-09',3,1,15),(57,'2020-03-05','2020-03-09',3,1,NULL),(62,'2020-03-05','2020-03-09',3,1,NULL),(63,'2020-03-05','2020-03-09',3,1,NULL),(64,'2020-03-05','2020-03-09',3,1,17),(65,'2020-03-05','2020-03-09',3,1,17),(66,'2020-03-05','2020-03-09',3,1,17),(67,'2020-03-05','2020-03-09',3,1,18),(68,'2020-03-05','2020-03-09',3,1,19),(69,'2020-03-05','2020-03-09',3,1,20),(70,'2020-03-05','2020-03-09',3,1,20),(71,'2020-03-05','2020-03-09',3,1,20),(72,'2020-03-05','2020-03-09',3,1,20),(73,'2020-03-05','2020-03-09',3,1,7),(74,'2020-03-05','2020-03-09',3,1,18),(75,'2020-03-05','2020-03-09',3,1,18),(76,'2020-03-05','2020-03-09',3,1,18),(77,'2020-03-05','2020-03-09',3,1,18),(78,'2020-03-05','2020-03-09',3,1,19),(79,'2020-03-05','2020-03-09',3,1,20),(80,'2020-03-05','2020-03-09',3,1,19),(81,'2020-03-05','2020-03-09',3,1,19),(82,'2020-03-05','2020-03-09',3,1,19),(83,'2020-03-05','2020-03-09',3,1,21),(84,'2020-03-05','2020-03-09',3,1,22),(85,'2020-03-05','2020-03-09',3,1,23),(86,'2020-03-05','2020-03-09',3,1,18);

