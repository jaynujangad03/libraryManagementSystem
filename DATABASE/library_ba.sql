-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2024 at 12:15 PM
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
(1004, 'MUTANT', 'ACTION', 1, 11),
(1005, 'HOME', 'HORROR', 2, 9),
(1006, 'THE BOOK WISE ', 'PHYCOLOGICAL ', 1, 9),
(1007, 'THE THREE', 'HORROR', 1, 10),
(1009, 'WABALO', 'TECHNOLOGY', 1, 6);

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
(19, 42, 1004, '2024-05-13', '2024-05-14', 'RETURNED'),
(20, 42, 1006, '2024-05-14', '2024-05-15', 'RETURNED'),
(21, 41, 1009, '2024-06-08', '2024-06-07', 'RETURNED'),
(22, 41, 1009, '2024-06-08', '2024-06-07', 'PENDING'),
(23, 42, 1009, '2024-06-08', '2024-06-07', 'RETURNED');

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
  `user_id` int(225) NOT NULL,
  `username` varchar(225) NOT NULL,
  `email` varchar(225) NOT NULL,
  `contact` varchar(225) NOT NULL,
  `password` varchar(225) NOT NULL,
  `status` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `email`, `contact`, `password`, `status`) VALUES
(18, 'jaynu', 'jaynujangad03@gmail.com', '09166764802', 'HepwX3KiPVcQdYKZuI/pnhKqUs7XDZ6//rlHp+rxQB0=', 'Active'),
(22, 'vince', 'vinceomaque@gmail.com', '09166764802', 'HepwX3KiPVcQdYKZuI/pnhKqUs7XDZ6//rlHp+rxQB0=', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `violation_tbl`
--

CREATE TABLE `violation_tbl` (
  `VIOLATION_ID` int(100) NOT NULL,
  `ISSUED_ID` varchar(100) NOT NULL,
  `ISBN` varchar(100) NOT NULL,
  `STUDENT_ID` int(100) NOT NULL,
  `ISSUED_DATE` date NOT NULL,
  `DUE_DATE` date NOT NULL,
  `STATUS` varchar(100) NOT NULL,
  `VIOLATION_DATE` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `violation_tbl`
--

INSERT INTO `violation_tbl` (`VIOLATION_ID`, `ISSUED_ID`, `ISBN`, `STUDENT_ID`, `ISSUED_DATE`, `DUE_DATE`, `STATUS`, `VIOLATION_DATE`) VALUES
(1, '16', '1006', 41, '2024-05-12', '2024-05-13', 'PENDING', '2024-06-08 10:12:10'),
(2, '17', '1005', 42, '2024-05-12', '2024-05-13', 'PENDING', '2024-06-08 10:12:10'),
(3, '18', '1003', 41, '2024-05-12', '2024-05-13', 'PENDING', '2024-06-08 10:12:10'),
(4, '19', '1004', 42, '2024-05-13', '2024-05-14', 'RETURNED', '2024-06-08 10:12:10'),
(5, '20', '1006', 42, '2024-05-14', '2024-05-15', 'RETURNED', '2024-06-08 10:12:10'),
(6, '21', '1009', 41, '2024-06-08', '2024-06-07', 'RETURNED', '2024-06-08 10:12:10'),
(7, '22', '1009', 41, '2024-06-08', '2024-06-07', 'PENDING', '2024-06-08 10:12:10'),
(8, '23', '1009', 42, '2024-06-08', '2024-06-07', 'PENDING', '2024-06-08 10:12:10');

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
-- Indexes for table `violation_tbl`
--
ALTER TABLE `violation_tbl`
  ADD PRIMARY KEY (`VIOLATION_ID`),
  ADD KEY `STUDENT_ID` (`STUDENT_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `issued_bookdet`
--
ALTER TABLE `issued_bookdet`
  MODIFY `ISSUED_ID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `student_details`
--
ALTER TABLE `student_details`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(225) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `violation_tbl`
--
ALTER TABLE `violation_tbl`
  MODIFY `VIOLATION_ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `issued_bookdet`
--
ALTER TABLE `issued_bookdet`
  ADD CONSTRAINT `issued_bookdet_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `student_details` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `issued_bookdet_ibfk_2` FOREIGN KEY (`ISBN`) REFERENCES `book_details` (`ISBN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `violation_tbl`
--
ALTER TABLE `violation_tbl`
  ADD CONSTRAINT `violation_tbl_ibfk_1` FOREIGN KEY (`STUDENT_ID`) REFERENCES `student_details` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
