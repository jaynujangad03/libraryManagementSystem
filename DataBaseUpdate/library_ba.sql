-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2024 at 10:52 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_ba`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_details`
--

CREATE TABLE `book_details` (
  `ISBN` int(20) NOT NULL,
  `TITTLE` varchar(150) NOT NULL,
  `GENRE` varchar(100) NOT NULL,
  `EDITION` int(50) NOT NULL,
  `QUANTITY` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book_details`
--

INSERT INTO `book_details` (`ISBN`, `TITTLE`, `GENRE`, `EDITION`, `QUANTITY`) VALUES
(110, 'ONE PIECE', 'ANIME', 1, 10),
(1002, 'TEST ', 'TEST ', 2, 10),
(1003, 'HOME', 'HORROR', 1, 9),
(1004, 'MUTANT', 'ACTION', 1, 10),
(1005, 'HOME', 'HORROR', 2, 9),
(1006, 'THE BOOK WISE ', 'PHYCOLOGICAL ', 1, 9),
(1007, 'THE THREE', 'HORROR', 1, 10),
(1009, 'WABALO', 'TECHNOLOGY', 1, 7);

-- --------------------------------------------------------

--
-- Table structure for table `issued_bookdet`
--

CREATE TABLE `issued_bookdet` (
  `ISSUED_ID` int(255) NOT NULL,
  `ID` int(255) NOT NULL,
  `ISBN` int(255) NOT NULL,
  `ISSUED` date NOT NULL,
  `DUE` date NOT NULL,
  `STATUS` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `issued_bookdet`
--

INSERT INTO `issued_bookdet` (`ISSUED_ID`, `ID`, `ISBN`, `ISSUED`, `DUE`, `STATUS`) VALUES
(16, 41, 1006, '2024-05-12', '2024-05-13', 'PENDING'),
(17, 42, 1005, '2024-05-12', '2024-05-13', 'PENDING'),
(18, 41, 1003, '2024-05-12', '2024-05-13', 'PENDING'),
(19, 42, 1004, '2024-05-13', '2024-05-14', 'PENDING'),
(20, 42, 1006, '2024-05-14', '2024-05-15', 'RETURNED');

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE `student_details` (
  `ID` int(10) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `LASTNAME` varchar(100) NOT NULL,
  `COURSE` varchar(100) NOT NULL,
  `YEAR` varchar(20) NOT NULL,
  `CONTACT` varchar(50) NOT NULL,
  `IMAGE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`ID`, `NAME`, `LASTNAME`, `COURSE`, `YEAR`, `CONTACT`, `IMAGE`) VALUES
(41, 'STEPHANE', 'VILLAVER', 'BSBA', '1ST', '09166764802', 'src/images/download (2).jpg'),
(42, 'JANGAD', 'JANGAD', 'BSIT', '1ST', '09166764892', 'src/images/download (1).jpg'),
(43, 'ELMER', 'ELMER', 'BSIT', '1ST', '09166764892', 'src/images/download.jpg'),
(44, 'KING', 'OMPAD', 'BSBA', '2ND', '09166764802', 'src/images/mat.png');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `password` varchar(150) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `email`, `contact`, `password`, `status`) VALUES
(18, 'jaynu', 'jaynujangad03@gmail.com', '09166764802', 'HepwX3KiPVcQdYKZuI/pnhKqUs7XDZ6//rlHp+rxQB0=', 'Active'),
(22, 'vince', 'vinceomaque@gmail.com', '09166764802', 'HepwX3KiPVcQdYKZuI/pnhKqUs7XDZ6//rlHp+rxQB0=', 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_details`
--
ALTER TABLE `book_details`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indexes for table `issued_bookdet`
--
ALTER TABLE `issued_bookdet`
  ADD PRIMARY KEY (`ISSUED_ID`),
  ADD KEY `ID` (`ID`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indexes for table `student_details`
--
ALTER TABLE `student_details`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `issued_bookdet`
--
ALTER TABLE `issued_bookdet`
  MODIFY `ISSUED_ID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `student_details`
--
ALTER TABLE `student_details`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `issued_bookdet`
--
ALTER TABLE `issued_bookdet`
  ADD CONSTRAINT `issued_bookdet_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `student_details` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `issued_bookdet_ibfk_2` FOREIGN KEY (`ISBN`) REFERENCES `book_details` (`ISBN`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
