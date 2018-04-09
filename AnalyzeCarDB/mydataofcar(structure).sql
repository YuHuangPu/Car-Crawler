-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- 主機: 127.0.0.1
-- 產生時間： 2018-04-09 19:13:54
-- 伺服器版本: 10.1.21-MariaDB
-- PHP 版本： 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `mydataofcar`
--
CREATE DATABASE IF NOT EXISTS `mydataofcar` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `mydataofcar`;

-- --------------------------------------------------------

--
-- 資料表結構 `allcar`
--

DROP TABLE IF EXISTS `allcar`;
CREATE TABLE `allcar` (
  `年分` varchar(100) DEFAULT NULL,
  `品牌` varchar(255) DEFAULT NULL,
  `款式` varchar(255) DEFAULT NULL,
  `價錢` varchar(10) DEFAULT NULL,
  `動力型式` varchar(255) DEFAULT NULL,
  `引擎型式` varchar(255) DEFAULT NULL,
  `排氣量` varchar(255) DEFAULT NULL,
  `最大馬力` varchar(255) DEFAULT NULL,
  `最大扭力` varchar(255) DEFAULT NULL,
  `馬達出力` varchar(255) DEFAULT NULL,
  `壓縮比` varchar(255) DEFAULT NULL,
  `系統總合輸出` varchar(255) DEFAULT NULL,
  `驅動型式` varchar(255) DEFAULT NULL,
  `變速系統` varchar(255) DEFAULT NULL,
  `前輪懸吊` varchar(255) DEFAULT NULL,
  `後輪懸吊` varchar(255) DEFAULT NULL,
  `煞車型式` varchar(255) DEFAULT NULL,
  `輪胎尺碼` varchar(255) DEFAULT NULL,
  `車身型式` varchar(255) DEFAULT NULL,
  `車門數` varchar(255) DEFAULT NULL,
  `座位數` varchar(255) DEFAULT NULL,
  `車長` varchar(255) DEFAULT NULL,
  `車寬` varchar(255) DEFAULT NULL,
  `車高` varchar(255) DEFAULT NULL,
  `車重` varchar(255) DEFAULT NULL,
  `軸距` varchar(255) DEFAULT NULL,
  `標準行李箱容量` varchar(255) DEFAULT NULL,
  `後座傾倒行李箱容量` varchar(255) DEFAULT NULL,
  `油箱容量` varchar(255) DEFAULT NULL,
  `市區油耗` varchar(255) DEFAULT NULL,
  `高速油耗` varchar(255) DEFAULT NULL,
  `平均油耗` varchar(255) DEFAULT NULL,
  `牌照稅` varchar(255) DEFAULT NULL,
  `燃料費` varchar(255) DEFAULT NULL,
  `外觀` varchar(255) DEFAULT NULL,
  `內裝` varchar(255) DEFAULT NULL,
  `影音` varchar(255) DEFAULT NULL,
  `便利` varchar(255) DEFAULT NULL,
  `安全` varchar(255) DEFAULT NULL,
  `圖片` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 資料表結構 `carequipment`
--

DROP TABLE IF EXISTS `carequipment`;
CREATE TABLE `carequipment` (
  `NAME` varchar(255) DEFAULT NULL,
  `equip` varchar(50) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 資料表結構 `carfile`
--

DROP TABLE IF EXISTS `carfile`;
CREATE TABLE `carfile` (
  `name` varchar(255) NOT NULL DEFAULT '',
  `pic0` mediumblob,
  `pic1` mediumblob,
  `pic2` mediumblob,
  `pic3` mediumblob,
  `pic4` mediumblob,
  `pic5` mediumblob,
  `pic6` mediumblob,
  `pic7` mediumblob,
  `pic8` mediumblob,
  `pic9` mediumblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 資料表結構 `cargrade`
--

DROP TABLE IF EXISTS `cargrade`;
CREATE TABLE `cargrade` (
  `name` varchar(255) NOT NULL DEFAULT '',
  `EASY` double(20,16) DEFAULT '-1.0000000000000000',
  `SAFETY` double(20,16) DEFAULT '-1.0000000000000000',
  `COZY` double(20,16) DEFAULT '-1.0000000000000000',
  `CONTROLLED` double(20,16) DEFAULT '-1.0000000000000000',
  `MONEY` double(20,16) DEFAULT '-1.0000000000000000'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 資料表結構 `carlike`
--

DROP TABLE IF EXISTS `carlike`;
CREATE TABLE `carlike` (
  `id` varchar(50) DEFAULT NULL,
  `car` varchar(500) DEFAULT NULL,
  `up` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 資料表結構 `carname`
--

DROP TABLE IF EXISTS `carname`;
CREATE TABLE `carname` (
  `NAME` varchar(255) NOT NULL DEFAULT '',
  `lst_update` varchar(20) DEFAULT NULL,
  `is_Convenience` char(1) DEFAULT 'N',
  `is_Safety` char(1) DEFAULT 'N',
  `is_Cozy` char(1) DEFAULT 'N',
  `is_Controlled` char(1) DEFAULT 'N',
  `is_Money` char(1) DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 資料表結構 `log`
--

DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` varchar(50) DEFAULT NULL,
  `Value` varchar(500) NOT NULL,
  `Action` varchar(50) NOT NULL,
  `upd` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 已匯出資料表的索引
--

--
-- 資料表索引 `carfile`
--
ALTER TABLE `carfile`
  ADD PRIMARY KEY (`name`);

--
-- 資料表索引 `cargrade`
--
ALTER TABLE `cargrade`
  ADD PRIMARY KEY (`name`);

--
-- 資料表索引 `carname`
--
ALTER TABLE `carname`
  ADD PRIMARY KEY (`NAME`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
