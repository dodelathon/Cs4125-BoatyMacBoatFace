-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2018 at 09:16 AM
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
(9, 'added', 'fromadifferentcomputer', 0),
(10, 'deep', 'd6077a19f538d5331ba96f19a590cf0ee5f39ac2d742fbf3a871af5f254040bc0fe39b1e0599c0a73cafdd6696e47869a7f4de1e5c6d02ba13e77ff951962eef', 1),
(11, 'heeeyyy', 'd6077a19f538d5331ba96f19a590cf0ee5f39ac2d742fbf3a871af5f254040bc0fe39b1e0599c0a73cafdd6696e47869a7f4de1e5c6d02ba13e77ff951962eef', 0),
(12, 'hoiiiii', 'b66f6bfd7cc3b09c7f424f0e594bfb6c3add836fe16abfa45f752b7938b3360b472d86d7b30a89a7ea46fda89134ddc1bc4f07984bf23a7ddf19d32365f4814a', 0),
(13, 'gggg', 'b86637c289ef32ad894285d5c366fa82eab50481055c836d912b1798bd3bbe60698d380a6aea8f9bb1252f9626aaec2407e552fc7d5f1e1ee7228c5e41926a28', 0),
(14, 'hoiiiiiiiii', '8974fb954d6dd416d3ef2de609cbe575fb762a87253b85aea6bc56a2ba01afef8dea86c268b09e4c678080575d21030756d0d1649f8c341a8ef0f001a2a1eb4e', 0),
(15, 'kkk', 'c11033e2755bc3472afb298cb3e85cd53472e459e49ce9dc0f63948d7ff6bcfd9febc260ad8bfbe6d64a280e0db033244b00b5d0eb820a96e34be861d956bebf', 0),
(16, 'rgaerg', 'cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e', 0),
(17, 'qergqerg', 'cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e', 0),
(18, 'qerhfwyrn', 'cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e', 0),
(19, 'jnthmgns', 'cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e', 0),
(20, 'arymgasg', 'cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e', 0),
(21, 'rygmfngba', 'cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e', 0),
(22, 'jmhf sgd', 'cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e', 0),
(23, 'fg sn s', 'cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e', 0),
(24, 'jmh bssfgn', 'cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e', 0),
(25, 'dgjmh sns', 'cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e', 0),
(26, 'dghsd', 'cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e', 0),
(27, 'dfxns d', 'cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e', 0);

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

--
-- Dumping data for table `matches`
--

INSERT INTO `matches` (`MatchID`, `p1`, `p1Name`, `p2`, `P2Name`, `p3`, `p3Name`, `p4`, `p4Name`, `p5`, `p5Name`) VALUES
(465, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(466, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(467, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(468, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(469, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(470, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(471, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(472, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(473, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(474, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(475, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(476, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(477, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(478, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(479, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(480, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(481, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(482, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(483, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(484, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(485, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(486, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(487, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(488, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(489, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(490, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(491, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(492, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(493, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(494, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(495, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(496, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(497, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(498, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(499, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(500, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(501, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(502, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(503, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(504, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(505, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(506, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(507, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(508, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(509, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(510, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(511, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(512, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(513, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(514, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(515, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(516, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(517, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(518, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(519, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(520, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(521, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(522, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(523, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(524, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(525, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(526, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(527, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(528, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(529, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(530, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(531, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(532, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(533, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(534, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(535, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(536, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(537, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(538, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(539, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(540, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(541, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(542, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(543, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(544, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(545, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(546, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(547, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(548, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(549, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(550, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(551, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(552, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(553, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(554, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(555, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(556, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(557, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(558, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(559, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(560, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(561, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(562, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(563, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(564, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(565, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(566, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(567, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(568, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(569, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(570, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(571, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(572, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(573, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(574, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(575, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(576, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(577, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(578, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(579, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(580, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(581, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(582, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(583, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(584, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(585, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(586, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(587, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(588, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(589, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(590, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(591, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(592, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(593, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(594, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(595, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(596, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(597, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(598, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(599, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(600, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(601, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(602, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(603, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(604, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(605, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(606, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(607, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(608, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(609, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(610, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(611, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(612, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(613, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(614, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(615, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s'),
(616, 23, 'fg sn s', 24, 'jmh bssfgn', 25, 'dgjmh sns', 26, 'dghsd', 15, 'kkk'),
(617, 15, 'kkk', 16, 'rgaerg', 17, 'qergqerg', 18, 'qerhfwyrn', 19, 'jnthmgns'),
(618, 19, 'jnthmgns', 20, 'arymgasg', 21, 'rygmfngba', 22, 'jmhf sgd', 23, 'fg sn s');

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
-- Dumping data for table `matchmaker_info`
--

INSERT INTO `matchmaker_info` (`userIDMatch`, `usernameMatch`, `rating`, `is_online`, `queued`) VALUES
(15, 'kkk', 99, 1, 0),
(16, 'rgaerg', 0, 1, 1),
(17, 'qergqerg', 0, 1, 1),
(18, 'qerhfwyrn', 0, 1, 1),
(19, 'jnthmgns', 0, 1, 0),
(20, 'arymgasg', 0, 1, 1),
(21, 'rygmfngba', 0, 1, 1),
(22, 'jmhf sgd', 0, 1, 1),
(23, 'fg sn s', 0, 1, 0),
(24, 'jmh bssfgn', 0, 1, 1),
(25, 'dgjmh sns', 0, 1, 1),
(26, 'dghsd', 0, 1, 1),
(27, 'dfxns d', 0, 1, 1);

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
  MODIFY `userIDLog` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `matches`
--
ALTER TABLE `matches`
  MODIFY `MatchID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=619;

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
