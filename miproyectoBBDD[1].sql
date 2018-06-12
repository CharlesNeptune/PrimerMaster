-- phpMyAdmin SQL Dump
-- version 4.2.7
-- http://www.phpmyadmin.net
--
-- Host: localhost:3307
-- Generation Time: Jul 12, 2015 at 03:55 PM
-- Server version: 5.5.41-log
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `miproyecto`
--

-- --------------------------------------------------------

--
-- Table structure for table `amigos`
--

CREATE TABLE IF NOT EXISTS `amigos` (
  `id_publicador` int(20) NOT NULL,
  `id_seguidor` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `amigos`
--

INSERT INTO `amigos` (`id_publicador`, `id_seguidor`) VALUES
(1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `consolasadm`
--

CREATE TABLE IF NOT EXISTS `consolasadm` (
`id_consola` int(10) NOT NULL,
  `plataforma` varchar(30) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `consolasadm`
--

INSERT INTO `consolasadm` (`id_consola`, `plataforma`) VALUES
(1, 'Playstation4'),
(3, 'XboxOne'),
(4, 'PlayStation3'),
(6, 'Playstation2');

-- --------------------------------------------------------

--
-- Table structure for table `conspub`
--

CREATE TABLE IF NOT EXISTS `conspub` (
  `id_publicacion` int(11) NOT NULL,
  `id_consola` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `deseos`
--

CREATE TABLE IF NOT EXISTS `deseos` (
`id_deseo` int(90) NOT NULL,
  `fk_id_juego` int(50) NOT NULL,
  `fk_id_usuario` int(20) NOT NULL,
  `precio_deseo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `noticias`
--

CREATE TABLE IF NOT EXISTS `noticias` (
`id_publicacion` int(90) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `texto` text NOT NULL,
  `consola` varchar(30) NOT NULL,
  `fecha` varchar(40) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `noticias`
--

INSERT INTO `noticias` (`id_publicacion`, `titulo`, `texto`, `consola`, `fecha`) VALUES
(4, 'Alucina nuevo Final Fantasy', 'algo', '4', '27/06/2015 05:02:04'),
(5, 'Nuevo Gears of Wars', 'Nuevo lanzamiento de la Alfa del Juego de Xbox One', 'XboxOne', '28/06/2015 11:36:27');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
`id` int(20) NOT NULL,
  `nick` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `password` varchar(30) NOT NULL,
  `movil` int(9) DEFAULT NULL,
  `avatar` blob
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nick`, `nombre`, `apellidos`, `correo`, `password`, `movil`, `avatar`) VALUES
(1, 'ccharles91', 'Carlos', 'Sanchez', 'csanchez@cice.es', '51480579R', 647408257, ''),
(2, 'javikase', 'Javi', 'Pereiras', 'javikase@sale.com', '123', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `usuariosadm`
--

CREATE TABLE IF NOT EXISTS `usuariosadm` (
`id_usuarioadm` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `usuariosadm`
--

INSERT INTO `usuariosadm` (`id_usuarioadm`, `nombre`, `apellidos`, `correo`, `password`) VALUES
(1, 'carlos', 'sanchez', 'csanchez@cice.es', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `videojuegos`
--

CREATE TABLE IF NOT EXISTS `videojuegos` (
`id_juego` int(20) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `precio` double NOT NULL,
  `plataforma` varchar(40) NOT NULL,
  `vendedor` varchar(50) NOT NULL,
  `uso` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `videojuegos`
--

INSERT INTO `videojuegos` (`id_juego`, `nombre`, `precio`, `plataforma`, `vendedor`, `uso`) VALUES
(1, 'Crash Bandicoot', 50, 'PlayStation1', 'ccharles91', '2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consolasadm`
--
ALTER TABLE `consolasadm`
 ADD PRIMARY KEY (`id_consola`);

--
-- Indexes for table `deseos`
--
ALTER TABLE `deseos`
 ADD PRIMARY KEY (`id_deseo`);

--
-- Indexes for table `noticias`
--
ALTER TABLE `noticias`
 ADD PRIMARY KEY (`id_publicacion`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `nick` (`nick`);

--
-- Indexes for table `usuariosadm`
--
ALTER TABLE `usuariosadm`
 ADD PRIMARY KEY (`id_usuarioadm`);

--
-- Indexes for table `videojuegos`
--
ALTER TABLE `videojuegos`
 ADD PRIMARY KEY (`id_juego`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consolasadm`
--
ALTER TABLE `consolasadm`
MODIFY `id_consola` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `deseos`
--
ALTER TABLE `deseos`
MODIFY `id_deseo` int(90) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `noticias`
--
ALTER TABLE `noticias`
MODIFY `id_publicacion` int(90) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
MODIFY `id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `usuariosadm`
--
ALTER TABLE `usuariosadm`
MODIFY `id_usuarioadm` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `videojuegos`
--
ALTER TABLE `videojuegos`
MODIFY `id_juego` int(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
