-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 07, 2024 lúc 11:39 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `printify`
--
CREATE DATABASE IF NOT EXISTS `printify` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `printify`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `name`, `created_at`) VALUES
(29, 'Men\'s Clothing', '2024-06-04 09:39:27'),
(30, 'Women\'s Clothing', '2024-06-04 09:39:43'),
(31, 'Kid\'s Clothing', '2024-06-04 09:39:53'),
(32, 'Food - Health - Beauty', '2024-06-04 09:40:13'),
(33, 'Accessories', '2024-06-04 09:40:39'),
(34, 'Home & Living', '2024-06-04 09:41:14'),
(35, 'Summer Picks', '2024-06-04 09:41:29'),
(36, 'Bestsellers', '2024-06-04 09:41:46'),
(37, 'New Arrivals', '2024-06-04 09:42:07'),
(38, 'Eco-friendly', '2024-06-04 09:42:16'),
(39, 'AOP Clothing', '2024-06-04 09:42:31'),
(40, 'Assembled in the USA', '2024-06-04 09:42:53'),
(41, 'Neck Labels', '2024-06-04 09:43:06'),
(42, 'TikTok Ready', '2024-06-04 09:44:09');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
