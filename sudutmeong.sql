-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2020 at 07:26 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sudutmeong`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employeeID` int(11) NOT NULL,
  `roleID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `DOB` date NOT NULL,
  `salary` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employeeID`, `roleID`, `name`, `username`, `DOB`, `salary`, `status`, `password`) VALUES
(1, 1, 'Felix Raharjo', 'felix_r', '2000-11-25', 2500000, 'Active', 'sdKv10'),
(2, 1, 'Alim Yanto', 'lim_YT', '1999-08-25', 2500000, 'Active', 'sFkx12'),
(3, 1, 'Brandon Lim', 'brdnLim', '1998-01-23', 2500000, 'Active', 'sEkq11'),
(4, 4, 'Eugene Frederick', 'eug_fred', '1997-03-13', 7000000, 'Active', 'fkLs11'),
(5, 4, 'Joe', 'Joe_', '1997-05-23', 7000000, 'Active', 'qsLKP'),
(6, 2, 'Kristianto Felix', 'kri_lix', '1998-04-12', 6500000, 'Active', 'zxcV12'),
(7, 2, 'Peter Lie', 'ptr_lie', '1996-06-11', 6500000, 'Active', 'fghJ12'),
(8, 2, 'Vano Putra', 'van_p', '1998-07-30', 6500000, 'Active', 'lkjS90'),
(9, 3, 'Putra Karantino', 'put_kar', '2000-09-12', 5000000, 'Active', 'oiqS12'),
(10, 3, 'Felix Corona', 'fel_ro', '1999-06-01', 5000000, 'Active', 'qweR12'),
(11, 5, 'Raissa Vanessa', 'rais_sa', '2001-02-14', 4500000, 'Active', 'cvjI90'),
(12, 5, 'Velissa Alexandra', 'vel_xan', '2001-03-14', 4500000, 'Active', 'okiU12'),
(13, 5, 'Marco Leonardo', 'marco_leo', '2000-04-17', 4500000, 'Active', 'njhU12'),
(14, 5, 'Nathanael Putra', 'nael_ra', '2002-03-16', 4500000, 'Active', 'lokI12'),
(15, 5, 'Kezia Karantina', 'kz_ina', '2000-01-13', 4500000, 'Active', 'qzxU12'),
(16, 5, 'Kenneth Mulia', 'ke_mul', '2001-02-10', 4500000, 'Active', 'njiY12'),
(17, 5, 'Leonardo Felix', 'leo_lix', '1999-05-21', 4500000, 'Active', 'iknO12'),
(18, 5, 'Sheren Lestari', 'ren_tari', '2001-04-01', 4500000, 'Active', 'fhjI18'),
(19, 5, 'Darren Alexander', 'dar_xen', '2000-05-19', 4500000, 'Active', 'qitW12'),
(20, 5, 'Covid Covey', 'cov_ey', '2000-01-31', 4500000, 'Active', 'bnuI12'),
(21, 1, 'Default HumanResourceManager', '1', '2020-05-01', 1000000, 'Active', ''),
(22, 2, 'Default StorageManager', '2', '2020-05-01', 1000000, 'Active', ''),
(23, 3, 'Default PromoManager', '3', '2020-05-01', 1000000, 'Active', ''),
(24, 4, 'Default MasterManager', '4', '2020-05-01', 1000000, 'Active', ''),
(25, 5, 'Default Cashier', '5', '2020-05-01', 1000000, 'Active', '');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productID`, `name`, `description`, `price`, `stock`) VALUES
(1, 'Whiskas Dry 1KG', 'Makanan kering dengan vitamin yang lengkap untuk memenuhi gizi yang dibutuhkan bagi kucing anda', 60000, 10),
(2, 'Whiskas WET 1KG', 'Makanan basah dengan vitamin yang lengkap untuk memenuhi gizi yang dibutuhkan bagi kucing anda', 65000, 10),
(3, 'Me-O Cat Nutrition Dry 7KG', 'Me-o Ocean Fish, Makanan kucing yang dapat memenuhi nutrisi yang diperlukan bagi kucing anda', 380000, 7),
(4, 'Virbac Vitamin 50ml', 'Suplemen nutrisi yang bisa dikonsumsi untuk anjing dan kucing agar bulu tetap indah, lembut, dan tidak rontok', 130000, 8),
(5, 'Mainan Bulu Biru', 'Mainan bulu kemoceng warna biru untuk menemani kucing anda bermain', 13000, 20),
(6, 'Mainan Bulu Merah', 'Mainan bulu kemoceng warna merah untuk menemani kucing anda bermain', 13000, 20),
(7, 'Mainan Bulu Hijau', 'Mainan bulu kemoceng warna hijau untuk menemani kucing anda bermain', 13000, 20),
(8, 'Laser Point Merah', 'Mainan laser aman untuk mata, untuk menemani kucing anda bermain tangkap laser warna merah', 20000, 10),
(9, 'Laser Point Biru', 'Mainan laser aman untuk mata, untuk menemani kucing anda bermain tangkap laser warna biru', 20000, 10),
(10, 'Laser Point Hijau', 'Mainan laser aman untuk mata, untuk menemani kucing anda bermain tangkap laser warna hijau', 20000, 10);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `name` varchar(255) NOT NULL,
  `roleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`name`, `roleID`) VALUES
('Human Resource', 1),
('Storage Manager', 2),
('Promo Manager', 3),
('Master Manager', 4),
('Cashier', 5);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transactionID` int(11) NOT NULL,
  `purchase_datetime` date NOT NULL,
  `voucherID` int(11) NOT NULL,
  `employeeID` int(11) NOT NULL,
  `paymentType` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `transactionitem`
--

CREATE TABLE `transactionitem` (
  `transactionID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `voucher`
--

CREATE TABLE `voucher` (
  `voucherID` int(11) NOT NULL,
  `discount` float NOT NULL,
  `validDate` date NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `voucher`
--

INSERT INTO `voucher` (`voucherID`, `discount`, `validDate`, `status`) VALUES
(1, 25, '2021-07-01', 'NotUsed'),
(2, 15, '2021-03-05', 'NotUsed'),
(3, 10, '2021-01-25', 'NotUsed'),
(4, 10, '2021-05-24', 'NotUsed'),
(5, 10, '2021-06-23', 'NotUsed'),
(6, 25, '2021-03-22', 'NotUsed'),
(7, 30, '2021-04-25', 'NotUsed'),
(8, 5, '2021-07-11', 'NotUsed'),
(9, 25, '2021-08-21', 'NotUsed'),
(10, 30, '2021-02-03', 'NotUsed'),
(11, 10, '2021-04-20', 'Used'),
(12, 10, '2021-03-23', 'NotUsed');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employeeID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`roleID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transactionID`);

--
-- Indexes for table `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`voucherID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
