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
  `userIDLog` int(11) NOT NULL,
  `usernameLog` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `isDev` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_info`
--

INSERT INTO `login_info` (`userIDLog`, `usernameLog`, `password`, `isDev`) VALUES
(3, 'hi', 'hi', 0),
(4, 'beep', 'shabalabadingdong', 0),
(5, 'bep', 'shabalabadingdong', 0),
(6, 'bepe', 'shabalabadingdong', 1),
(7, 'hello', 'meep', 0),
(8, 'huh', 'ugh', 1),
(9, 'added', 'fromadifferentcomputer', 0);

-- --------------------------------------------------------

--
-- Table structure for table `matches`
--

CREATE TABLE `matches` (
  `MatchID` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p1Name` varchar(30) NOT NULL,
  `p2` int(11) NOT NULL,
  `P2Name` varchar(30) NOT NULL,
  `p3` int(11) NOT NULL,
  `p3Name` varchar(30) NOT NULL,
  `p4` int(11) NOT NULL,
  `p4Name` varchar(30) NOT NULL,
  `p5` int(11) NOT NULL,
  `p5Name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `matchmaker_info`
--

CREATE TABLE `matchmaker_info` (
  `userIDMatch` int(11) NOT NULL,
  `usernameMatch` varchar(30) NOT NULL,
  `rating` float NOT NULL,
  `is_online` tinyint(1) NOT NULL DEFAULT '0',
  `queued` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login_info`
--
ALTER TABLE `login_info`
  ADD PRIMARY KEY (`userIDLog`);

--
-- Indexes for table `matches`
--
ALTER TABLE `matches`
  ADD PRIMARY KEY (`MatchID`),
  ADD KEY `p1ID` (`p1`),
  ADD KEY `p2ID` (`p2`),
  ADD KEY `p3ID` (`p3`),
  ADD KEY `p4ID` (`p4`),
  ADD KEY `p5ID` (`p5`);

--
-- Indexes for table `matchmaker_info`
--
ALTER TABLE `matchmaker_info`
  ADD PRIMARY KEY (`userIDMatch`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login_info`
--
ALTER TABLE `login_info`
  MODIFY `userIDLog` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `matches`
--
ALTER TABLE `matches`
  MODIFY `MatchID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `matches`
--
ALTER TABLE `matches`
  ADD CONSTRAINT `p1ID` FOREIGN KEY (`p1`) REFERENCES `matchmaker_info` (`userIDMatch`),
  ADD CONSTRAINT `p2ID` FOREIGN KEY (`p2`) REFERENCES `matchmaker_info` (`userIDMatch`),
  ADD CONSTRAINT `p3ID` FOREIGN KEY (`p3`) REFERENCES `matchmaker_info` (`userIDMatch`),
  ADD CONSTRAINT `p4ID` FOREIGN KEY (`p4`) REFERENCES `matchmaker_info` (`userIDMatch`),
  ADD CONSTRAINT `p5ID` FOREIGN KEY (`p5`) REFERENCES `matchmaker_info` (`userIDMatch`);

--
-- Constraints for table `matchmaker_info`
--
ALTER TABLE `matchmaker_info`
  ADD CONSTRAINT `id` FOREIGN KEY (`userIDMatch`) REFERENCES `login_info` (`userIDLog`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
