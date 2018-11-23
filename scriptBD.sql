-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.7-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for examenMP
DROP DATABASE IF EXISTS `examenMP`;
CREATE DATABASE IF NOT EXISTS `examenMP` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `examenMP`;

DROP TABLE IF EXISTS `productor`;
CREATE TABLE `productor` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cedula` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `distrito` varchar(255) NOT NULL,
  `canton` varchar(255) NOT NULL, 
  `provincia` varchar(255) NOT NULL,
  `empresa` varchar(255) NOT NULL,
 PRIMARY KEY (`id`,`cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `finca`;
CREATE TABLE `finca` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `prod_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_finca_prodid_idx` (`prod_id`),
  CONSTRAINT `fk_finca_prodid` FOREIGN KEY (`prod_id`) REFERENCES `productor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cafe` (
	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(255) NULL DEFAULT NULL,
	`finca_id` INT(11) UNSIGNED NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `fk_cafe_fincaid_idx` (`finca_id`),
	CONSTRAINT `fk_cafe_fincaid` FOREIGN KEY (`finca_id`) REFERENCES `finca` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=9
;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;