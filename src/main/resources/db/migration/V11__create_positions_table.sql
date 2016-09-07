CREATE TABLE `positions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` varchar(45) DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `altitude` float DEFAULT NULL,
  `currenttime` datetime DEFAULT NULL,
  `run_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_position_idx` (`run_id`),
  CONSTRAINT `fk_position` FOREIGN KEY (`run_id`) REFERENCES `runs` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
