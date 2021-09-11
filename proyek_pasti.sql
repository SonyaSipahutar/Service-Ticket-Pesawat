-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 07 Mar 2021 pada 17.27
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proyek_pasti`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `user_email` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`user_email`, `created_at`, `update_at`, `user_name`, `user_password`) VALUES
('alex.hutapea14@gmail.com', '2021-03-07 23:13:39', '2021-03-07 23:13:39', 'Sander', 'alex1212'),
('Joshua@gmail.com', '2021-03-07 23:13:39', '2021-03-07 23:13:39', 'Joshua', '123456');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tiket`
--

CREATE TABLE `tiket` (
  `no_ktp` varchar(255) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `keberangkatan` varchar(255) DEFAULT NULL,
  `kelas` varchar(255) DEFAULT NULL,
  `nama_lengkap` varchar(255) DEFAULT NULL,
  `no_telp` varchar(255) DEFAULT NULL,
  `tanggal` datetime DEFAULT NULL,
  `tujuan` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tiket`
--

INSERT INTO `tiket` (`no_ktp`, `alamat`, `keberangkatan`, `kelas`, `nama_lengkap`, `no_telp`, `tanggal`, `tujuan`) VALUES
('1234', 'Tarutung', 'Silangit', 'Ekonomi', 'Alex Hutapea', '082375760314', '2021-03-07 23:23:31', 'Jakarta'),
('1221', 'Medan', 'Medan', 'Ekonomi', 'Artasya Natalia', '0823998340', '2021-03-07 23:23:31', 'Bali');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`user_email`);

--
-- Indexes for table `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`no_ktp`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
