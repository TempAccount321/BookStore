-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2017 at 04:40 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cdcol`
--

-- --------------------------------------------------------

--
-- Table structure for table `booksinfo`
--

CREATE TABLE IF NOT EXISTS `booksinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) DEFAULT NULL,
  `bookname` text COLLATE latin1_general_ci,
  `authorname` text COLLATE latin1_general_ci,
  `subject` text COLLATE latin1_general_ci,
  `price` text COLLATE latin1_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=22 ;

--
-- Dumping data for table `booksinfo`
--

INSERT INTO `booksinfo` (`id`, `bookid`, `bookname`, `authorname`, `subject`, `price`) VALUES
(1, 1, 'Utopia', 'Sir Thomas Moor', 'History', '$5'),
(2, 2, 'Origin of species', 'charles Darwin', 'Biology', '$10'),
(3, 3, 'David Copperfield', 'Charles Dickens', 'History', '$10'),
(4, 4, 'Gulliver''s Travels', 'Jonathan Swift', 'Travels', '$20'),
(5, 5, 'Time Machine', 'H.G. Wells', 'Story', '$15'),
(6, 6, 'Le Contract Social', 'Jean Jacques Rousseaut', 'Social', '$10'),
(7, 7, 'Times', 'John Smith', 'Story', '$10'),
(8, 8, 'Anand Math', 'Kalidas', 'Travels', '$25'),
(9, 9, 'Auto Machine', 'Steve Wells', 'Science', '$15'),
(10, 10, 'War and peace', 'Leo Tolstoy', 'History', '$20'),
(11, 11, 'Adventures of Tom Saweyer', 'Mark waugh', 'Story', '$10'),
(12, 12, 'ThunderStorm', 'Alan Bon', 'Story', '$15'),
(13, 13, 'DownTown', 'Robert tim', 'History', '$25'),
(14, 14, 'UpHill', 'Tim cook', 'Geography', '$15'),
(15, 16, 'UpHill', 'Tim cook', 'Geography', '$15'),
(16, 17, 'tempBook', 'tempAuth', 'Literature', '$10'),
(17, 18, 'horror', 'tonny break', 'History', '$20'),
(18, 19, 'brock', 'sank', 'Arts', '$5'),
(19, 21, 'tata', 'mona lo', 'Arts', '$5'),
(20, 23, 'jojo', 'moro', 'Arts', '$5'),
(21, 24, 'nm', 'mn', 'Arts', '$5');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
