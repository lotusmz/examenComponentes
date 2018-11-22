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

-- Dumping structure for table examenMP.productor
DROP TABLE IF EXISTS `tproductor`;
CREATE TABLE IF NOT EXISTS `tproductor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `empresa` varchar(50) NOT NULL,
  `direccion` varchar(500) NOT NULL,
  `distrito` varchar(50) NOT NULL,
  `canton` varchar(50) NOT NULL,
  `provincia` varchar(50) NOT NULL,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping structure for table examenMP.finca
DROP TABLE IF EXISTS `tfinca`;
CREATE TABLE IF NOT EXISTS `tfinca` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NOT NULL,
	`prod_id` INT NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_finca_prod` FOREIGN KEY (`prod_id`) REFERENCES `productor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping structure for table examenMP.tcafe
DROP TABLE IF EXISTS `tcafe`;
CREATE TABLE IF NOT EXISTS `tcafe` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NOT NULL,
	`finca_id` INT NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_cafe_finca` FOREIGN KEY (`finca_id`) REFERENCES `finca` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
