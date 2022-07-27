-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 26, 2022 lúc 08:36 PM
-- Phiên bản máy phục vụ: 10.4.6-MariaDB
-- Phiên bản PHP: 7.1.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `appgs`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lesson`
--

CREATE TABLE `lesson` (
  `lesson_detail_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `tutor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `lesson`
--

INSERT INTO `lesson` (`lesson_detail_id`, `student_id`, `tutor_id`) VALUES
(1, 1, 4),
(1, 6, 3),
(2, 1, 1),
(2, 6, 1),
(2, 6, 6),
(3, 6, 3),
(3, 6, 5),
(4, 6, 4),
(5, 6, 2),
(6, 10, 7),
(6, 11, 7),
(6, 16, 7),
(7, 16, 7),
(8, 16, 7),
(9, 11, 7),
(11, 9, 4),
(11, 11, 4),
(13, 11, 3),
(13, 16, 3),
(21, 15, 14),
(23, 15, 14);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lesson_detail`
--

CREATE TABLE `lesson_detail` (
  `lesson_detail_id` int(11) NOT NULL,
  `number` int(1) NOT NULL,
  `method` int(1) NOT NULL,
  `hour` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fee` int(11) NOT NULL,
  `create_at` datetime DEFAULT NULL,
  `post_id` int(11) NOT NULL,
  `grade` int(11) NOT NULL,
  `subject` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `lesson_detail`
--

INSERT INTO `lesson_detail` (`lesson_detail_id`, `number`, `method`, `hour`, `address`, `fee`, `create_at`, `post_id`, `grade`, `subject`) VALUES
(1, 1, 0, '1.5', 'Hải Châu', 30000, NULL, 1, 7, 'Toán'),
(2, 2, 1, '1.5', 'Hải Châu 2', 80000, NULL, 5, 11, 'Tin Học '),
(3, 2, 1, '1.5', 'Hải Châu', 10000, NULL, 5, 7, 'Hóa'),
(4, 2, 2, '1.5', 'Cẩm Lệ', 35000, NULL, 5, 7, 'Tiếng Anh'),
(5, 2, 0, '1.5', 'Ngũ Hành Sơn', 40000, NULL, 7, 8, 'Văn'),
(6, 5, 1, '1.5 giờ', 'Cẩm Lệ', 500000, '2022-07-25 22:11:48', 51, 1, 'Toán'),
(7, 4, 1, '2 giờ', 'Quận Thanh Khê', 500000, '2022-07-26 00:13:21', 52, 5, 'Văn'),
(8, 3, 1, '1 giờ', 'Quận Hải Châu', 500000, '2022-07-25 22:06:53', 53, 4, 'Toán'),
(9, 4, 1, '2 giờ', 'Quận Hải Châu', 500000, '2022-01-16 16:53:34', 54, 3, 'Hóa'),
(10, 2, 1, '1 giờ', 'Quận Ngũ Hành Sơn', 500000, NULL, 55, 8, 'Văn'),
(11, 2, 1, '1.5 giờ', 'Quận Thanh Khê', 500000, '2022-01-16 18:27:45', 56, 4, 'Hóa'),
(12, 3, 1, '1.5 giờ', 'Quận Sơn Trà', 500000, NULL, 57, 1, 'Địa'),
(13, 4, 1, '1.5 giờ', 'Quận Thanh Khê', 500000, '2022-07-25 22:07:20', 58, 11, 'Sử'),
(14, 2, 1, '1.5 giờ', 'Quận Sơn Trà', 500000, NULL, 59, 3, 'Toán'),
(21, 4, 1, '2 giờ', 'Quận Liên Chiểu', 500000, '2022-01-18 10:24:47', 66, 9, 'Sử'),
(22, 2, 1, '1 giờ', 'Quận Liên Chiểu', 500000, NULL, 67, 9, 'Hóa'),
(23, 1, 1, '1.5 giờ', 'Quận Liên Chiểu', 500000, '2022-01-18 10:28:20', 68, 8, 'Sử'),
(24, 4, 1, '2 giờ', 'Quận Cẩm Lệ', 500000, NULL, 69, 12, 'Toán');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `listsubjects`
--

CREATE TABLE `listsubjects` (
  `id_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `name_subjects` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `class` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `listsubjects`
--

INSERT INTO `listsubjects` (`id_user`, `name_subjects`, `class`) VALUES
('32', 'Hóa', 12),
('32', 'Toán', 11),
('32', 'Lý', 10),
('33', 'Tiếng Anh', 10),
('33', 'Toán', 9),
('33', 'Sinh', 11),
('35', 'Tiếng Anh', 12),
('35', 'Toán', 12),
('35', 'Lý', 11);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mess`
--

CREATE TABLE `mess` (
  `Id` int(11) NOT NULL,
  `tutor_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mess_detail`
--

CREATE TABLE `mess_detail` (
  `mes_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `date_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `post`
--

CREATE TABLE `post` (
  `post_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `post`
--

INSERT INTO `post` (`post_id`, `user_id`, `create_at`) VALUES
(1, 32, '2022-01-13 15:49:19'),
(4, 32, '2022-01-13 16:48:39'),
(5, 32, '2022-01-13 20:46:07'),
(6, 36, '2022-01-13 20:46:36'),
(7, 3, '2022-01-13 20:46:45'),
(9, 1, '2022-01-15 16:30:22'),
(12, 1, '2022-01-15 16:33:51'),
(13, 1, '2022-01-15 16:41:07'),
(14, 1, '2022-01-15 16:43:42'),
(15, 1, '2022-01-15 16:45:28'),
(16, 1, '2022-01-15 16:45:41'),
(17, 1, '2022-01-15 16:45:43'),
(18, 1, '2022-01-15 16:45:44'),
(19, 1, '2022-01-15 16:45:44'),
(20, 1, '2022-01-15 16:48:59'),
(21, 1, '2022-01-15 16:49:06'),
(22, 1, '2022-01-15 16:49:06'),
(23, 1, '2022-01-15 16:49:07'),
(24, 1, '2022-01-15 16:49:07'),
(25, 1, '2022-01-15 16:49:07'),
(26, 1, '2022-01-15 16:49:08'),
(27, 1, '2022-01-15 16:49:08'),
(28, 1, '2022-01-15 16:49:08'),
(29, 1, '2022-01-15 16:49:09'),
(30, 1, '2022-01-15 16:51:44'),
(31, 1, '2022-01-15 16:51:46'),
(32, 1, '2022-01-15 16:51:48'),
(33, 1, '2022-01-15 16:51:48'),
(34, 1, '2022-01-15 16:51:49'),
(35, 1, '2022-01-15 16:51:49'),
(36, 1, '2022-01-15 16:51:50'),
(37, 1, '2022-01-15 16:52:13'),
(38, 1, '2022-01-15 16:52:16'),
(39, 1, '2022-01-15 16:52:18'),
(40, 1, '2022-01-15 16:52:22'),
(41, 1, '2022-01-15 16:53:00'),
(42, 1, '2022-01-15 16:53:10'),
(43, 1, '2022-01-15 16:53:11'),
(44, 1, '2022-01-15 16:53:11'),
(45, 1, '2022-01-15 16:55:08'),
(46, 2, '2022-01-15 19:53:22'),
(47, 2, '2022-01-15 19:53:37'),
(48, 28, '2022-01-16 09:00:56'),
(49, 28, '2022-01-16 09:01:59'),
(50, 1, '2022-01-16 09:03:22'),
(51, 28, '2022-01-16 09:05:12'),
(52, 28, '2022-01-16 09:49:13'),
(53, 28, '2022-01-16 10:41:46'),
(54, 28, '2022-01-16 11:16:01'),
(55, 2, '2022-01-16 11:38:09'),
(56, 15, '2022-01-16 11:40:54'),
(57, 2, '2022-01-16 13:41:35'),
(58, 16, '2022-01-16 13:49:27'),
(59, 30, '2022-01-16 16:48:21'),
(66, 39, '2022-01-18 10:22:43'),
(67, 40, '2022-01-18 10:25:22'),
(68, 39, '2022-01-18 10:27:52'),
(69, 42, '2022-07-26 00:11:35');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `level` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`student_id`, `user_id`, `level`) VALUES
(1, 1, '4'),
(6, 3, '8'),
(8, 2, '7'),
(9, 3, '6'),
(10, 17, '1'),
(11, 30, '5'),
(12, 34, '1'),
(13, 36, '6'),
(14, 38, '1'),
(15, 40, '6'),
(16, 41, '12');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tutor`
--

CREATE TABLE `tutor` (
  `tutor_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `method` int(1) NOT NULL,
  `grade` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `level` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tutor`
--

INSERT INTO `tutor` (`tutor_id`, `user_id`, `method`, `grade`, `level`) VALUES
(1, 2, 0, '7,8,9', 'Cao Đẳng'),
(2, 4, 0, '10', 'Đại Học'),
(3, 16, 1, '6', 'Đại Học'),
(4, 15, 1, '12', 'Cao Đẳng'),
(5, 6, 2, '4', 'Đại Học'),
(6, 27, 0, '12', '12/12'),
(7, 28, 0, '12', 'Cao đẳng'),
(8, 29, 0, '11', 'Cao đẳng'),
(9, 31, 0, '10', 'Đại học'),
(10, 32, 0, '8', 'Đại học'),
(11, 33, 0, '9', 'Đại học'),
(12, 35, 0, '12', 'Đại học'),
(13, 37, 0, '9', 'Đại học'),
(14, 39, 0, '10', 'Đại học'),
(15, 42, 0, '7', 'Đại học'),
(16, 43, 0, '12', 'Đại học'),
(17, 33, 0, '11', 'Đại học');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `gender` int(1) NOT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `dob` date DEFAULT NULL,
  `perr` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `email`, `pass`, `name`, `image`, `address`, `gender`, `phone`, `dob`, `perr`) VALUES
(1, 'tan@gmail.com\r\n', '123', 'Võ Quang Tấn', '', 'Quảng Nam', 1, '123457690', '2001-01-01', 0),
(2, 'aa@gmail.com', '1234', 'Trần Quân', '', 'Huế', 0, '0901929199', '2001-01-02', 0),
(3, 'thinh@gmail.com', '123', 'Phan Thiện', '', 'Quảng Nam', 0, '123457690', '2001-01-01', 0),
(4, 'aaa@gmail.com', '123', 'Trần Quân', '', 'Quảng Trị', 1, '0909191948', '2001-01-01', 1),
(6, 'Tranquan@gmail.com', '123', 'Tiến', '', 'Quảng Trị', 1, '0901929194', '2001-01-01', 1),
(15, 'Thinh1@gmail.com', '123', 'Thịnh', '', 'Huế', 1, '0901929191', '2001-01-01', 1),
(16, 'Tien@gmail.com', '123', 'Tiến', '', 'KomTum', 1, '0901929192', '2001-01-01', 1),
(17, 'bb@gmail.com', '123123', 'Trần Văn A', '1', 'Huế', 0, '0901929194', '2001-01-01', 0),
(24, 'avac@gmail.com', '123', 'aaaa', '1', 'Hue', 0, '0909090909', '2001-01-01', 1),
(27, 'ab@gmail.com', '123', 'aaaa', '1', 'Hue', 0, '0909909092', '2001-01-01', 1),
(28, 'aq@gmail.com', '123', 'Thiện Phan', '1', 'Huế', 0, '09091090191', '2001-01-01', 1),
(29, 'name@gmail.com', '123', 'name', '1', 'Huế', 0, '0901929491', '2001-04-05', 1),
(30, 'noname@gmail.com', '123', 'no name', '1', 'Hải Châu', 1, '0909293923', '2004-01-02', 0),
(31, 'anhquan@gmail.com', '123', 'quân', '1', 'Hải Châu', 0, '0901919193', '2003-01-02', 1),
(32, 'ac@gmail.com', '123', 'tran quan', '1', 'Huế', 0, '09123332312', '2004-02-04', 1),
(33, 'ten123@gmail.com', '123', 'ten123', '1', 'hue', 0, '342343', '2022-01-13', 1),
(34, 'dd@gmail.com', '123', 'tran quam', '1', 'huế', 0, '090123332', '2001-01-16', 0),
(35, 'tq@gmail.com', '123', 'tranquan', '1', 'Quảng Trị', 0, '0901129194', '2001-01-11', 1),
(36, 'mn@gmail.com', '123', 'Bạn A', '1', 'Huế', 1, '090129341', '2002-01-17', 0),
(37, 'ar@gmail.com', '123', 'trần quân', '1', 'Quảng Trị', 0, '0901929491', '2001-09-28', 1),
(38, 'vv@gmail.com', '123', 'thiện dơ', '1', 'Huế', 0, '090194821', '2004-01-17', 0),
(39, 'anhquan1@gmail.com', '123', 'Trần Anh Quân', '1', 'Quảng Trị', 0, '0901959492', '2001-01-11', 1),
(40, 'thien1@gmail.com', '123', 'Phan Thiện', '1', 'Đà Nẵng', 0, '0902949194', '2003-01-17', 0),
(41, 'hung@gmail.com', '1234567890', 'Phan Can Hung', '1', 'DH Nong Lam', 0, '0869251532', '2022-07-14', 0),
(42, 'hung123@gmail.com', '000000', 'HAHA', '1', '234567890', 1, '000000000', '0000-00-00', 0),
(43, 'hung0501@gmail.com', '1234567890', 'Phan Van Hung', '1', 'DH NL HCM', 0, '1234567890', '2022-07-10', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `lesson`
--
ALTER TABLE `lesson`
  ADD PRIMARY KEY (`lesson_detail_id`,`student_id`,`tutor_id`),
  ADD KEY `tutar_id` (`tutor_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Chỉ mục cho bảng `lesson_detail`
--
ALTER TABLE `lesson_detail`
  ADD PRIMARY KEY (`lesson_detail_id`),
  ADD KEY `post_id` (`post_id`);

--
-- Chỉ mục cho bảng `mess`
--
ALTER TABLE `mess`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `mess_detail`
--
ALTER TABLE `mess_detail`
  ADD PRIMARY KEY (`mes_id`);

--
-- Chỉ mục cho bảng `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`post_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `tutor`
--
ALTER TABLE `tutor`
  ADD PRIMARY KEY (`tutor_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `lesson_detail`
--
ALTER TABLE `lesson_detail`
  MODIFY `lesson_detail_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT cho bảng `mess`
--
ALTER TABLE `mess`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `post`
--
ALTER TABLE `post`
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT cho bảng `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `tutor`
--
ALTER TABLE `tutor`
  MODIFY `tutor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `lesson`
--
ALTER TABLE `lesson`
  ADD CONSTRAINT `lesson_ibfk_1` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`tutor_id`),
  ADD CONSTRAINT `lesson_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `lesson_ibfk_3` FOREIGN KEY (`lesson_detail_id`) REFERENCES `lesson_detail` (`lesson_detail_id`);

--
-- Các ràng buộc cho bảng `lesson_detail`
--
ALTER TABLE `lesson_detail`
  ADD CONSTRAINT `lesson_detail_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`);

--
-- Các ràng buộc cho bảng `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `post_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `tutor`
--
ALTER TABLE `tutor`
  ADD CONSTRAINT `tutor_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
