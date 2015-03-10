-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 10 Mars 2015 à 08:47
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `abonnement_relation`
--

INSERT INTO `abonnement_relation` (`id`, `id_utilisateur`, `id_source`) VALUES
(5, 1, 9),
(6, 1, 6);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `alerte_relation`
--

INSERT INTO `alerte_relation` (`id`, `id_utilisateur`, `id_source`, `priorite`, `date`, `sujet`, `type`, `statut`, `description`) VALUES
(1, 1, 1, 15, '2015-03-07 02:20:28', 'sujet', 'type', 'statut', 'description'),
(9, 1, 1, 0, '2015-03-09 05:29:28', '', '', '', ''),
(10, 1, 1, 15, '2015-03-09 05:29:55', 'sujet', 'type', 'statut', 'description'),
(11, 1, 1, 7, '2015-03-09 05:44:58', 'Source Supprimé: qdf', 'suppr', 'réussi', 'qdfqsdf'),
(12, 1, 1, 0, '2015-02-03 00:00:00', '', '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `blacklistage_systeme`
--

CREATE TABLE IF NOT EXISTS `blacklistage_systeme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_source` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_source_2` (`id_source`),
  KEY `id_source` (`id_source`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `blacklistage_systeme`
--

INSERT INTO `blacklistage_systeme` (`id`, `id_source`) VALUES
(3, 3),
(4, 6);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `blacklistage_utilisateur_relation`
--

INSERT INTO `blacklistage_utilisateur_relation` (`id`, `id_utilisateur`, `id_source`) VALUES
(1, 1, 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `demande_modif_relation`
--

INSERT INTO `demande_modif_relation` (`id`, `id_utilisateur`, `id_source`, `date`, `type`, `statut`, `description`) VALUES
(1, 1, 1, '2015-03-07 02:26:29', 'type', 'en attente', 'description'),
(2, 1, 3, '2015-03-09 21:26:14', 'qsdf', 'terminé', 'qfd'),
(5, 1, 1, '2015-03-10 04:47:51', 'qdf', 'en attente', 'qdfqsdf');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `source`
--

INSERT INTO `source` (`id`, `url_fournisseur`, `titre`, `niveau`, `zone`, `projection`, `periodicite`, `description`) VALUES
(1, 'http', 'AucuneSource', 'haut', 'France', 'vertical', 10, 'test'),
(3, 'http:///www.cool.com', 'qdf', 'qqdf', 'qf', 'qdf', 23, 'qdfqsdf'),
(6, 'http:///www.cool.com', 'qdf', 'qqdf', 'qf', 'qdf', 23, 'qdfqsdf'),
(9, 'http:///www.cool.com', 'qdf', 'qfd', 'qf', 'qdf', 23, 'qdfqsdf');

--
-- Déclencheurs `source`
--
DROP TRIGGER IF EXISTS `maj_fk`;
DELIMITER //
CREATE TRIGGER `maj_fk` BEFORE DELETE ON `source`
 FOR EACH ROW BEGIN
DELETE FROM abonnement_relation WHERE abonnement_relation.id_source=OLD.id;
DELETE FROM alerte_relation WHERE alerte_relation.id_source=OLD.id;
DELETE FROM blacklistage_systeme WHERE blacklistage_systeme.id_source=OLD.id;
DELETE FROM blacklistage_utilisateur_relation WHERE blacklistage_utilisateur_relation.id_source=OLD.id;
DELETE FROM demande_modif_relation WHERE demande_modif_relation.id_source=OLD.id;
DELETE FROM theme_relation WHERE theme_relation.id_source=OLD.id;
DELETE FROM version WHERE version.id_source=OLD.id;
END
//
DELIMITER ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=60 ;

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
(11, 99999, 'aaa', 'Polytech', '2015-03-05 04:52:57'),
(12, 99, 'Hello', 'sample', '2015-03-06 05:55:56'),
(13, 99, 'Hello', 'sample', '2015-03-06 06:26:01'),
(14, 99, 'Hello', 'sample', '2015-03-06 06:32:00'),
(15, 99, 'Hello', 'sample', '2015-03-06 06:33:30'),
(16, 99, 'Hello', 'sample', '2015-03-06 06:41:35'),
(20, 99, 'Hello', 'sample', '2015-03-06 06:48:05'),
(21, 99, 'Hello', 'sample', '2015-03-06 06:48:47'),
(22, 99, 'Hello', 'sample', '2015-03-06 06:48:48'),
(23, 99, 'Hello', 'sample', '2015-03-06 06:48:48'),
(24, 99, 'Hello', 'sample', '2015-03-06 06:48:48'),
(25, 99, 'Hello', 'sample', '2015-03-06 06:48:49'),
(26, 99, 'Hello', 'sample', '2015-03-06 06:49:15'),
(27, 99, 'Hello', 'sample', '2015-03-06 06:51:00'),
(48, 32559, 'Hello', 'sample', '2015-03-06 07:49:50'),
(49, 32559, 'Hello', 'sample', '2015-03-06 07:51:04'),
(50, 32559, 'Hello', 'sample', '2015-03-06 07:51:06'),
(52, 32559, 'Hello', 'sample', '2015-03-06 07:52:53'),
(59, 99, 'Hello', 'sample', '2015-03-07 02:04:06');

-- --------------------------------------------------------

--
-- Structure de la table `theme`
--

CREATE TABLE IF NOT EXISTS `theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `theme`
--

INSERT INTO `theme` (`id`, `theme`) VALUES
(1, 'themeParDéfaut'),
(2, 'testTheme11111'),
(4, 'dfdf');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `theme_relation`
--

INSERT INTO `theme_relation` (`id`, `id_source`, `id_theme`) VALUES
(3, 3, 2),
(4, 6, 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `email`, `role`, `alert_frequence`) VALUES
(1, 'inconnu', 'louiszhang@hotmail.fr', 'admin', 99997),
(2, 'dsqqfd', 'qdfqdf', 'qdfqsd', 999);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `version`
--

INSERT INTO `version` (`id`, `id_source`, `url_serveur`, `version`, `date_creation_fournisseur`) VALUES
(1, 1, 'url_serveur', 'version', '2015-03-07 01:49:25'),
(2, 3, 'okok', '1.0', '2015-03-10 06:51:49'),
(3, 3, 'dsqsf', '2.0', '2015-03-10 06:51:49'),
(4, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', 'v3.0', '2015-03-10 07:33:03'),
(5, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', 'v3.0', '2015-03-10 07:33:21'),
(6, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', 'v3.0', '2015-03-10 07:33:55'),
(7, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', 'v3.0', '2015-03-10 07:34:24'),
(8, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', '5.0', '2015-03-10 07:51:30'),
(9, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', '5.0', '2015-03-10 07:54:00'),
(10, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', '5.0', '2015-03-10 07:58:21'),
(11, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', '5.0', '2015-03-10 07:58:34'),
(12, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', '5.0', '2015-03-10 07:59:38'),
(13, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', '5.0', '2015-03-10 08:00:34'),
(14, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', '5.0', '2015-03-10 08:02:50'),
(15, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', '5.0', '2015-03-10 08:04:14'),
(16, 9, 'http://intranet.ifips.u-psud.fr/ii/assets/files/Stages_PeiPetET/Convention%20de%20stages%20Et%20version%20ligne1415diffuse.pdf', '5.0', '2015-03-10 08:15:45');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `abonnement_relation`
--
ALTER TABLE `abonnement_relation`
  ADD CONSTRAINT `abonnement_relation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `abonnement_relation_ibfk_2` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `alerte_relation`
--
ALTER TABLE `alerte_relation`
  ADD CONSTRAINT `alerte_relation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `alerte_relation_ibfk_2` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `blacklistage_systeme`
--
ALTER TABLE `blacklistage_systeme`
  ADD CONSTRAINT `blacklistage_systeme_ibfk_1` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `blacklistage_utilisateur_relation`
--
ALTER TABLE `blacklistage_utilisateur_relation`
  ADD CONSTRAINT `blacklistage_utilisateur_relation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `blacklistage_utilisateur_relation_ibfk_2` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `demande_modif_relation`
--
ALTER TABLE `demande_modif_relation`
  ADD CONSTRAINT `demande_modif_relation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `demande_modif_relation_ibfk_2` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `theme_relation`
--
ALTER TABLE `theme_relation`
  ADD CONSTRAINT `theme_relation_ibfk_1` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `theme_relation_ibfk_2` FOREIGN KEY (`id_theme`) REFERENCES `theme` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `version`
--
ALTER TABLE `version`
  ADD CONSTRAINT `version_ibfk_1` FOREIGN KEY (`id_source`) REFERENCES `source` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
