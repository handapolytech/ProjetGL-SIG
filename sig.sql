-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 09, 2015 at 12:05 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sig`
--
CREATE DATABASE IF NOT EXISTS `sig` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sig`;
-- --------------------------------------------------------

--
-- Table structure for table `abonnement_relation`
--

CREATE TABLE IF NOT EXISTS `abonnement_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_utilisateur` int(11) NOT NULL,
  `id_source` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_utilisateur` (`id_utilisateur`),
  KEY `id_source` (`id_source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `alerte_relation`
--

CREATE TABLE IF NOT EXISTS `alerte_relation` (
  `id_utilisateur` int(11) NOT NULL,
  `id_source` int(11) NOT NULL,
  `priorite` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sujet` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `statut` varchar(255) NOT NULL,
  `description` text NOT NULL,
  KEY `id_utilisateur` (`id_utilisateur`),
  KEY `id_source` (`id_source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `blacklistage_systeme`
--

CREATE TABLE IF NOT EXISTS `blacklistage_systeme` (
  `id_blacklistage_systeme` int(11) NOT NULL AUTO_INCREMENT,
  `id_source` int(11) NOT NULL,
  PRIMARY KEY (`id_blacklistage_systeme`),
  KEY `id_source` (`id_source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `blacklistage_utilisateur_relation`
--

CREATE TABLE IF NOT EXISTS `blacklistage_utilisateur_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_utilisateur` int(11) NOT NULL,
  `id_source` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_utilisateur` (`id_utilisateur`),
  KEY `id_source` (`id_source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `demande_modif_relation`
--

CREATE TABLE IF NOT EXISTS `demande_modif_relation` (
  `id_utilisateur` int(11) NOT NULL,
  `id_source` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` varchar(255) NOT NULL,
  `statut` varchar(255) NOT NULL,
  `description` text NOT NULL,
  KEY `id_utilisateur` (`id_utilisateur`),
  KEY `id_source` (`id_source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `source`
--

CREATE TABLE IF NOT EXISTS `source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url_fournisseur` varchar(255) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `niveau` varchar(255) NOT NULL,
  `zone` varchar(255) NOT NULL,
  `projection` varchar(255) NOT NULL,
  `periodicite` int(11) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `theme`
--

CREATE TABLE IF NOT EXISTS `theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `theme_relation`
--

CREATE TABLE IF NOT EXISTS `theme_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_source` int(11) NOT NULL,
  `id_theme` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_theme` (`id_theme`),
  KEY `id_source` (`id_source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `alert_frequence` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `version`
--

CREATE TABLE IF NOT EXISTS `version` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_source` int(11) NOT NULL,
  `url_serveur` varchar(255) NOT NULL,
  `version` varchar(255) NOT NULL,
  `date_creation_fournisseur` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_source` (`id_source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `abonnement_relation`
--
ALTER TABLE `abonnement_relation`
  ADD CONSTRAINT `abonnement_relation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `abonnement_relation_ibfk_2` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

--
-- Constraints for table `alerte_relation`
--
ALTER TABLE `alerte_relation`
  ADD CONSTRAINT `alerte_relation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `alerte_relation_ibfk_2` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

--
-- Constraints for table `blacklistage_systeme`
--
ALTER TABLE `blacklistage_systeme`
  ADD CONSTRAINT `blacklistage_systeme_ibfk_1` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

--
-- Constraints for table `blacklistage_utilisateur_relation`
--
ALTER TABLE `blacklistage_utilisateur_relation`
  ADD CONSTRAINT `blacklistage_utilisateur_relation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `blacklistage_utilisateur_relation_ibfk_2` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

--
-- Constraints for table `demande_modif_relation`
--
ALTER TABLE `demande_modif_relation`
  ADD CONSTRAINT `demande_modif_relation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `demande_modif_relation_ibfk_2` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

--
-- Constraints for table `theme_relation`
--
ALTER TABLE `theme_relation`
  ADD CONSTRAINT `theme_relation_ibfk_1` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`),
  ADD CONSTRAINT `theme_relation_ibfk_2` FOREIGN KEY (`id_theme`) REFERENCES `theme` (`id`);

--
-- Constraints for table `version`
--
ALTER TABLE `version`
  ADD CONSTRAINT `version_ibfk_1` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
