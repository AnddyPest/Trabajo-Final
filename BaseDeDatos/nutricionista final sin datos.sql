-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-11-2024 a las 20:12:24
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nutricionista`
--
CREATE DATABASE IF NOT EXISTS `nutricionista` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `nutricionista`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alimento`
--

CREATE TABLE `alimento` (
  `idAlimento` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipoComida` varchar(100) NOT NULL,
  `caloriasPor100g` int(11) NOT NULL,
  `detalle` varchar(200) NOT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alimento_keyword_handler`
--

CREATE TABLE `alimento_keyword_handler` (
  `idAlimento` int(11) NOT NULL,
  `idKeyword` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `idDieta` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `idPaciente` int(11) DEFAULT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFinal` date DEFAULT NULL,
  `pesoInicial` double NOT NULL,
  `pesoFinal` double DEFAULT NULL,
  `totalCalorias` int(11) NOT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta_menudiario_handler`
--

CREATE TABLE `dieta_menudiario_handler` (
  `idDieta` int(11) NOT NULL,
  `idMenuDiario` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `keywords`
--

CREATE TABLE `keywords` (
  `idKeyword` int(11) NOT NULL,
  `keyword` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menudiario`
--

CREATE TABLE `menudiario` (
  `idMenuDiario` int(11) NOT NULL,
  `nombreMenu` varchar(100) NOT NULL,
  `caloriasDelMenu` int(11) NOT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menudiario_alimento_handler`
--

CREATE TABLE `menudiario_alimento_handler` (
  `idAlimento` int(11) NOT NULL,
  `idMenuDiario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `dni` int(11) DEFAULT NULL,
  `edad` int(11) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `pesoActual` double NOT NULL,
  `pesoBuscado` double NOT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alimento`
--
ALTER TABLE `alimento`
  ADD PRIMARY KEY (`idAlimento`);

--
-- Indices de la tabla `alimento_keyword_handler`
--
ALTER TABLE `alimento_keyword_handler`
  ADD PRIMARY KEY (`idAlimento`,`idKeyword`),
  ADD KEY `alimento_keyword_ibfk_2` (`idKeyword`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`idDieta`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `dieta_menudiario_handler`
--
ALTER TABLE `dieta_menudiario_handler`
  ADD PRIMARY KEY (`idDieta`,`idMenuDiario`),
  ADD KEY `idMenuDiario` (`idMenuDiario`);

--
-- Indices de la tabla `keywords`
--
ALTER TABLE `keywords`
  ADD PRIMARY KEY (`idKeyword`),
  ADD UNIQUE KEY `keyword` (`keyword`);

--
-- Indices de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  ADD PRIMARY KEY (`idMenuDiario`);

--
-- Indices de la tabla `menudiario_alimento_handler`
--
ALTER TABLE `menudiario_alimento_handler`
  ADD PRIMARY KEY (`idAlimento`,`idMenuDiario`),
  ADD KEY `idMenuDiario` (`idMenuDiario`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alimento`
--
ALTER TABLE `alimento`
  MODIFY `idAlimento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `keywords`
--
ALTER TABLE `keywords`
  MODIFY `idKeyword` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  MODIFY `idMenuDiario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alimento_keyword_handler`
--
ALTER TABLE `alimento_keyword_handler`
  ADD CONSTRAINT `alimento_keyword_handler_ibfk_1` FOREIGN KEY (`idAlimento`) REFERENCES `alimento` (`idAlimento`),
  ADD CONSTRAINT `alimento_keyword_handler_ibfk_2` FOREIGN KEY (`idKeyword`) REFERENCES `keywords` (`idKeyword`);

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`);

--
-- Filtros para la tabla `dieta_menudiario_handler`
--
ALTER TABLE `dieta_menudiario_handler`
  ADD CONSTRAINT `dieta_menudiario_handler_ibfk_1` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`idDieta`),
  ADD CONSTRAINT `dieta_menudiario_handler_ibfk_2` FOREIGN KEY (`idMenuDiario`) REFERENCES `menudiario` (`idMenuDiario`);

--
-- Filtros para la tabla `menudiario_alimento_handler`
--
ALTER TABLE `menudiario_alimento_handler`
  ADD CONSTRAINT `menudiario_alimento_handler_ibfk_1` FOREIGN KEY (`idAlimento`) REFERENCES `alimento` (`idAlimento`),
  ADD CONSTRAINT `menudiario_alimento_handler_ibfk_2` FOREIGN KEY (`idMenuDiario`) REFERENCES `menudiario` (`idMenuDiario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
