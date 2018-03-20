-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2017-04-16 14:25:29
-- 服务器版本： 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sports`
--

-- --------------------------------------------------------

--
-- 表的结构 `academy`
--

CREATE TABLE `academy` (
  `academy` varchar(20) NOT NULL,
  `academyID` int(2) UNSIGNED NOT NULL,
  `score` int(3) UNSIGNED NOT NULL DEFAULT '0',
  `servertime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `academy`
--

INSERT INTO `academy` (`academy`, `academyID`, `score`, `servertime`) VALUES
('轻工', 1, 0, '0000-00-00 00:00:00'),
('材料', 2, 0, '0000-00-00 00:00:00'),
('环境', 3, 0, '0000-00-00 00:00:00'),
('食品', 4, 0, '0000-00-00 00:00:00'),
('机电', 5, 0, '0000-00-00 00:00:00'),
('电信', 6, 0, '0000-00-00 00:00:00'),
('经管', 7, 0, '0000-00-00 00:00:00'),
('化工', 8, 0, '0000-00-00 00:00:00'),
('设艺', 9, 0, '0000-00-00 00:00:00'),
('文理', 10, 0, '0000-00-00 00:00:00'),
('职教', 11, 0, '0000-00-00 00:00:00'),
('镐京', 12, 0, '0000-00-00 00:00:00');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
