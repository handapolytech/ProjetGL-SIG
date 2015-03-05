-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 05 Mars 2015 à 16:54
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `sig`
--

-- --------------------------------------------------------

--
-- Structure de la table `abonnement_relation`
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
-- Structure de la table `alerte_relation`
--

CREATE TABLE IF NOT EXISTS `alerte_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_utilisateur` int(11) NOT NULL,
  `id_source` int(11) NOT NULL,
  `priorite` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sujet` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `statut` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_utilisateur` (`id_utilisateur`),
  KEY `id_source` (`id_source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `blacklistage_systeme`
--

CREATE TABLE IF NOT EXISTS `blacklistage_systeme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_source` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_source` (`id_source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `blacklistage_utilisateur_relation`
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
-- Structure de la table `demande_modif_relation`
--

CREATE TABLE IF NOT EXISTS `demande_modif_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_utilisateur` int(11) NOT NULL,
  `id_source` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` varchar(255) NOT NULL,
  `statut` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_utilisateur` (`id_utilisateur`),
  KEY `id_source` (`id_source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `source`
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
-- Structure de la table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL,
  `string` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `test`
--

INSERT INTO `test` (`id`, `num`, `string`, `text`, `date`) VALUES
(1, 1212, 'aaaaa', 'bbbbbbbbbbbbb', '2015-02-18 23:46:34'),
(3, 9999, 'helm', 'opps', '2015-02-18 23:46:34'),
(4, 1, 'aaa', 'Polytech', '2015-03-05 04:52:57'),
(5, 999, 'ohla', 'www', '2015-02-18 23:46:34'),
(7, 99999, 'aaa', 'Polytech', '2015-02-19 01:09:09'),
(8, 99999, 'aaa', 'Polytech', '2015-02-19 01:09:59'),
(9, 99999, 'aaa', 'Polytech', '2015-02-19 01:10:56'),
(10, 99999, 'aaa', 'Polytech', '2015-02-19 01:13:02'),
(11, 99999, 'aaa', 'Polytech', '2015-03-05 04:52:57');

-- --------------------------------------------------------

--
-- Structure de la table `theme`
--

CREATE TABLE IF NOT EXISTS `theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `theme_relation`
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
-- Structure de la table `utilisateur`
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
-- Structure de la table `version`
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
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `abonnement_relation`
--
ALTER TABLE `abonnement_relation`
  ADD CONSTRAINT `abonnement_relation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `abonnement_relation_ibfk_2` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

--
-- Contraintes pour la table `alerte_relation`
--
ALTER TABLE `alerte_relation`
  ADD CONSTRAINT `alerte_relation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `alerte_relation_ibfk_2` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

--
-- Contraintes pour la table `blacklistage_systeme`
--
ALTER TABLE `blacklistage_systeme`
  ADD CONSTRAINT `blacklistage_systeme_ibfk_1` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

--
-- Contraintes pour la table `blacklistage_utilisateur_relation`
--
ALTER TABLE `blacklistage_utilisateur_relation`
  ADD CONSTRAINT `blacklistage_utilisateur_relation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `blacklistage_utilisateur_relation_ibfk_2` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

--
-- Contraintes pour la table `demande_modif_relation`
--
ALTER TABLE `demande_modif_relation`
  ADD CONSTRAINT `demande_modif_relation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `demande_modif_relation_ibfk_2` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

--
-- Contraintes pour la table `theme_relation`
--
ALTER TABLE `theme_relation`
  ADD CONSTRAINT `theme_relation_ibfk_1` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`),
  ADD CONSTRAINT `theme_relation_ibfk_2` FOREIGN KEY (`id_theme`) REFERENCES `theme` (`id`);

--
-- Contraintes pour la table `version`
--
ALTER TABLE `version`
  ADD CONSTRAINT `version_ibfk_1` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
