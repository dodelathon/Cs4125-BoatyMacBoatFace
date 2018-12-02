-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2018 at 02:52 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `userdetails`
--

-- --------------------------------------------------------

--
-- Table structure for table `login_info`
--

CREATE TABLE `login_info` (
  `userIDLog` int(11) NOT NULL AUTO_INCREMENT,
  `usernameLog` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `isDev` tinyint(1) NOT NULL DEFAULT '0',
   PRIMARY KEY (`userIDLog`)
) ENGINE=InnoDB AUTO_INCREMENT=10  DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_info`
--

CREATE TABLE `matchmaker_info` (
  `userIDMatch` int(11) NOT NULL,
  `usernameMatch` varchar(30) NOT NULL,
  `rating` float NOT NULL,
  `is_online` tinyint(1) NOT NULL DEFAULT '0',
  `queued` tinyint(1) NOT NULL DEFAULT '0', 
   PRIMARY KEY (`userIDMatch`),
   CONSTRAINT `id` FOREIGN KEY (`userIDMatch`) REFERENCES `login_info` (`userIDLog`) ON DELETE CASCADE on update restrict
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `matches`
--

CREATE TABLE `matches` (
  `MatchID` int(11) NOT NULL AUTO_INCREMENT,
  `p1` int(11) NOT NULL,
  `p1Name` varchar(30) NOT NULL,
  `p2` int(11) NOT NULL,
  `P2Name` varchar(30) NOT NULL,
  `p3` int(11) NOT NULL,
  `p3Name` varchar(30) NOT NULL,
  `p4` int(11) NOT NULL,
  `p4Name` varchar(30) NOT NULL,
  `p5` int(11) NOT NULL,
  `p5Name` varchar(30) NOT NULL, 
  PRIMARY KEY (`MatchID`),
  CONSTRAINT `p1ID` FOREIGN KEY (`p1`) REFERENCES `matchmaker_info` (`userIDMatch`),
  CONSTRAINT `p2ID` FOREIGN KEY (`p2`) REFERENCES `matchmaker_info` (`userIDMatch`),
  CONSTRAINT `p3ID` FOREIGN KEY (`p3`) REFERENCES `matchmaker_info` (`userIDMatch`),
  CONSTRAINT `p4ID` FOREIGN KEY (`p4`) REFERENCES `matchmaker_info` (`userIDMatch`),
  CONSTRAINT `p5ID` FOREIGN KEY (`p5`) REFERENCES `matchmaker_info` (`userIDMatch`)

) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
INSERT INTO `login_info` (`userIDLog`, `usernameLog`, `password`, `isDev`) VALUES
(3, 'hi', 'hi', 0),
(4, 'beep', 'shabalabadingdong', 0),
(5, 'bep', 'shabalabadingdong', 0),
(6, 'bepe', 'shabalabadingdong', 1),
(7, 'hello', 'meep', 0),
(8, 'huh', 'ugh', 1),
(9, 'added', 'fromadifferentcomputer', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


