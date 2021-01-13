-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 13, 2021 at 03:52 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tree`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `Promo` varchar(30) NOT NULL,
  `Role` varchar(40) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_users` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nom`, `Email`, `age`, `Promo`, `Role`, `password`) VALUES
(1, 'Mohammed', 'Ahmed@gmail.com', 26, '1 er annee', 'Staf', 'azerty'),
(13, 'Mohammed betaoui', 'mohammed@gmail.com', 24, '2 eme annee', 'Apprenant', 'azerty'),
(14, 'Amine lahnone', 'aminelahnone@gmail.com', 26, '2 eme annee', 'Apprenant', 'azerty'),
(15, 'sara hamel', 'sarahamel@gmail.com', 28, '2 eme annee', 'Apprenant', 'azerty'),
(16, 'zakaria kamili', 'zakariakamili97@gmail.com', 23, '2 eme annee', 'Apprenant', 'azerty'),
(17, 'Ismail mnifel', 'ismail@gmail.com', 28, '1 er annee', 'Apprenant', 'azerty'),
(18, 'AhmedBoutayeb', 'Boutayab@gmail.com', 26, '2 eme annee', 'Apprenant', 'azerty'),
(19, 'Mohammed', 'Betaoui@gmail.com', 25, '2 eme annee', 'Apprenant', 'azerty'),
(20, 'Mohammed choukri', 'choukri@gmail.com', 25, '2 eme annee', 'Apprenant', 'azerty');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
