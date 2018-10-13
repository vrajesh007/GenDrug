-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2018 at 04:43 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gendrug`
--

-- --------------------------------------------------------

--
-- Table structure for table `areadetails`
--

CREATE TABLE `areadetails` (
  `Area_id` int(6) NOT NULL,
  `Area_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `branddetails`
--

CREATE TABLE `branddetails` (
  `Brand_id` int(6) NOT NULL,
  `Brand_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `categorydetails`
--

CREATE TABLE `categorydetails` (
  `Categ_id` int(6) NOT NULL,
  `Categ_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `deliverymandetails`
--

CREATE TABLE `deliverymandetails` (
  `Deliveryman_id` int(6) NOT NULL,
  `Deliveryman_name` text NOT NULL,
  `Deliveryman_address` varchar(160) NOT NULL,
  `Deliveryman_phnum` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `Feedback_id` int(6) NOT NULL,
  `Feedback` varchar(160) NOT NULL,
  `Feedback_date` date NOT NULL,
  `Feedback_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicinedetails`
--

CREATE TABLE `medicinedetails` (
  `P_id` int(6) NOT NULL,
  `P_name` varchar(10) NOT NULL,
  `P_details` varchar(160) NOT NULL,
  `P_price` int(10) NOT NULL,
  `P_stock` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE `orderdetails` (
  `Order_id` int(6) NOT NULL,
  `Order_quantity` int(10) NOT NULL,
  `Order_amount` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `prescriptiondetails`
--

CREATE TABLE `prescriptiondetails` (
  `Pres_id` int(6) NOT NULL,
  `Pres_name` varchar(10) NOT NULL,
  `Pres_details` varchar(160) NOT NULL,
  `Pres_price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `shippingstatus`
--

CREATE TABLE `shippingstatus` (
  `Shipping_id` int(6) NOT NULL,
  `Shipping_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplierdetails`
--

CREATE TABLE `supplierdetails` (
  `Supp_id` int(6) NOT NULL,
  `Supp_name` text NOT NULL,
  `Supp_add` varchar(160) NOT NULL,
  `Supp_phnum` varchar(20) NOT NULL,
  `Supp_stock` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `symptomdetails`
--

CREATE TABLE `symptomdetails` (
  `Symp_id` int(6) NOT NULL,
  `Symp_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userregistration`
--

CREATE TABLE `userregistration` (
  `U_id` int(6) NOT NULL,
  `U_name` text NOT NULL,
  `Gender` text NOT NULL,
  `Phonenum` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Conpassword` varchar(30) NOT NULL,
  `Address` varchar(160) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `areadetails`
--
ALTER TABLE `areadetails`
  ADD PRIMARY KEY (`Area_id`);

--
-- Indexes for table `branddetails`
--
ALTER TABLE `branddetails`
  ADD PRIMARY KEY (`Brand_id`);

--
-- Indexes for table `categorydetails`
--
ALTER TABLE `categorydetails`
  ADD PRIMARY KEY (`Categ_id`);

--
-- Indexes for table `deliverymandetails`
--
ALTER TABLE `deliverymandetails`
  ADD PRIMARY KEY (`Deliveryman_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`Feedback_id`);

--
-- Indexes for table `medicinedetails`
--
ALTER TABLE `medicinedetails`
  ADD PRIMARY KEY (`P_id`);

--
-- Indexes for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`Order_id`);

--
-- Indexes for table `prescriptiondetails`
--
ALTER TABLE `prescriptiondetails`
  ADD PRIMARY KEY (`Pres_id`);

--
-- Indexes for table `shippingstatus`
--
ALTER TABLE `shippingstatus`
  ADD PRIMARY KEY (`Shipping_id`);

--
-- Indexes for table `supplierdetails`
--
ALTER TABLE `supplierdetails`
  ADD PRIMARY KEY (`Supp_id`);

--
-- Indexes for table `symptomdetails`
--
ALTER TABLE `symptomdetails`
  ADD PRIMARY KEY (`Symp_id`);

--
-- Indexes for table `userregistration`
--
ALTER TABLE `userregistration`
  ADD PRIMARY KEY (`U_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `areadetails`
--
ALTER TABLE `areadetails`
  MODIFY `Area_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `branddetails`
--
ALTER TABLE `branddetails`
  MODIFY `Brand_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `categorydetails`
--
ALTER TABLE `categorydetails`
  MODIFY `Categ_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `deliverymandetails`
--
ALTER TABLE `deliverymandetails`
  MODIFY `Deliveryman_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `Feedback_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `medicinedetails`
--
ALTER TABLE `medicinedetails`
  MODIFY `P_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orderdetails`
--
ALTER TABLE `orderdetails`
  MODIFY `Order_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `prescriptiondetails`
--
ALTER TABLE `prescriptiondetails`
  MODIFY `Pres_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `shippingstatus`
--
ALTER TABLE `shippingstatus`
  MODIFY `Shipping_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `supplierdetails`
--
ALTER TABLE `supplierdetails`
  MODIFY `Supp_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `symptomdetails`
--
ALTER TABLE `symptomdetails`
  MODIFY `Symp_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `userregistration`
--
ALTER TABLE `userregistration`
  MODIFY `U_id` int(6) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
