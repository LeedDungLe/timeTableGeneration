-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 30, 2021 lúc 12:18 PM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `project`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giaovien`
--

CREATE TABLE `giaovien` (
  `id` int(11) NOT NULL,
  `ten` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `giaovien`
--

INSERT INTO `giaovien` (`id`, `ten`) VALUES
(1, 'gv1'),
(2, 'gv2'),
(3, 'gv3'),
(4, 'gv4'),
(5, 'gv5'),
(6, 'gv6'),
(7, 'gv7'),
(8, 'gv8'),
(9, 'gv9'),
(10, 'gv10'),
(11, 'gv11'),
(12, 'gv12'),
(13, 'gv13'),
(14, 'gv14'),
(15, 'gv15'),
(16, 'gv16'),
(17, 'gv17'),
(18, 'gv18'),
(19, 'gv19'),
(20, 'gv20'),
(21, 'gv21'),
(22, 'gv22'),
(23, 'gv23'),
(24, 'gv24'),
(25, 'gv25'),
(26, 'gv26'),
(27, 'gv27'),
(28, 'gv28'),
(29, 'gv29'),
(30, 'gv30'),
(31, 'gv31');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monhoc`
--

CREATE TABLE `monhoc` (
  `id` int(11) NOT NULL,
  `ten` varchar(40) NOT NULL,
  `soLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `monhoc`
--

INSERT INTO `monhoc` (`id`, `ten`, `soLuong`) VALUES
(1, 'Toán', 4),
(2, 'Văn', 3),
(3, 'Anh', 3),
(4, 'Sinh Học', 2),
(5, 'Lịch Sử', 2),
(6, 'Địa Lý', 2),
(7, 'Vật Lý', 2),
(8, 'Hoá Học', 2),
(9, 'Công Nghệ', 1),
(10, 'Tin Học', 1),
(11, 'GDCD', 1),
(12, 'Thể dục', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phutrach`
--

CREATE TABLE `phutrach` (
  `monhoc_id` int(11) NOT NULL,
  `giaovien_id` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phutrach`
--

INSERT INTO `phutrach` (`monhoc_id`, `giaovien_id`, `id`) VALUES
(1, 1, 1),
(7, 1, 2),
(1, 2, 3),
(8, 2, 4),
(1, 3, 5),
(7, 4, 6),
(8, 5, 7),
(2, 6, 8),
(5, 6, 9),
(3, 7, 10),
(3, 8, 11),
(4, 9, 12),
(8, 9, 13),
(5, 10, 14),
(6, 11, 15),
(7, 12, 16),
(2, 13, 17),
(2, 14, 18),
(1, 15, 19),
(9, 16, 20),
(10, 17, 21),
(11, 18, 22),
(12, 19, 23),
(12, 20, 24),
(1, 21, 25),
(2, 22, 26),
(3, 23, 27),
(4, 24, 28),
(5, 25, 29),
(6, 2, 30),
(1, 21, 31),
(2, 22, 32),
(3, 23, 33),
(4, 24, 34),
(5, 25, 35),
(6, 2, 36),
(7, 27, 37),
(8, 28, 38),
(9, 29, 39),
(10, 30, 40),
(11, 31, 41),
(12, 21, 42),
(1, 21, 44),
(2, 22, 45),
(3, 23, 46),
(4, 24, 47),
(5, 25, 48),
(6, 2, 49),
(7, 27, 50),
(8, 28, 51),
(9, 29, 52),
(10, 30, 53),
(11, 31, 54),
(12, 21, 55),
(3, 22, 56),
(1, 24, 57),
(2, 26, 58);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `phutrach`
--
ALTER TABLE `phutrach`
  ADD PRIMARY KEY (`id`),
  ADD KEY `monhoc_id` (`monhoc_id`),
  ADD KEY `giaovien_id` (`giaovien_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `phutrach`
--
ALTER TABLE `phutrach`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `phutrach`
--
ALTER TABLE `phutrach`
  ADD CONSTRAINT `phutrach_ibfk_1` FOREIGN KEY (`giaovien_id`) REFERENCES `giaovien` (`id`),
  ADD CONSTRAINT `phutrach_ibfk_2` FOREIGN KEY (`monhoc_id`) REFERENCES `monhoc` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
