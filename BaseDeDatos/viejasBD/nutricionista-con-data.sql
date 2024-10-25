-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-10-2024 a las 22:47:42
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

--
-- Volcado de datos para la tabla `alimento`
--

INSERT INTO `alimento` (`idAlimento`, `nombre`, `tipoComida`, `caloriasPor100g`, `detalle`, `estado`) VALUES
(1, 'Arroz con Pollo', 'Almuerzo', 400, 'Pollo con Arroz blanco', 1),
(2, 'Arroz con Atun', 'Almuerzo', 350, 'Arroz blanco con Atun', 1),
(3, 'Bife con ensalada de tomate y zanahoria', 'Cena', 350, 'Bife de lomo a la plancha con ensalada de tomate y zanahoria.', 1),
(4, 'Ensalada Waldorf', 'Cena', 300, 'Ensalada de tomate, apio, almendras, manzana verde con un toque de crema de leche.', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alimento_keyword`
--

CREATE TABLE `alimento_keyword` (
  `idAlimento` int(11) NOT NULL,
  `idKeyword` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alimento_keyword`
--

INSERT INTO `alimento_keyword` (`idAlimento`, `idKeyword`) VALUES
(1, 1),
(1, 3),
(2, 3),
(2, 9),
(3, 7),
(3, 12),
(3, 13),
(4, 12),
(4, 14),
(4, 15),
(4, 16),
(4, 17);

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
-- Estructura de tabla para la tabla `keywords`
--

CREATE TABLE `keywords` (
  `idKeyword` int(11) NOT NULL,
  `keyword` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `keywords`
--

INSERT INTO `keywords` (`idKeyword`, `keyword`) VALUES
(17, 'Almendras'),
(15, 'Apio'),
(3, 'Arroz'),
(7, 'Carne'),
(5, 'Cebolla'),
(6, 'Celiaco'),
(8, 'Cerdo'),
(14, 'Crema'),
(11, 'Hojas Verdes'),
(10, 'Huevo'),
(16, 'Manzana'),
(4, 'Nuez'),
(9, 'Pescado'),
(1, 'Pollo'),
(12, 'Tomate'),
(13, 'Zanahoria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menudiario`
--

CREATE TABLE `menudiario` (
  `idMenuDiario` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  `caloriasDelMenu` int(11) NOT NULL,
  `idDieta` int(11) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `idRenglonDelMenu` int(11) DEFAULT NULL
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
  `telefono` int(11) NOT NULL,
  `pesoActual` double NOT NULL,
  `pesoBuscado` double NOT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `renglondelmenu`
--

CREATE TABLE `renglondelmenu` (
  `idRenglonDelMenu` int(11) NOT NULL,
  `idAlimento` int(11) NOT NULL,
  `cantidadGramos` double NOT NULL,
  `subTotalCalorias` int(11) NOT NULL
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
-- Indices de la tabla `alimento_keyword`
--
ALTER TABLE `alimento_keyword`
  ADD PRIMARY KEY (`idAlimento`,`idKeyword`),
  ADD KEY `idKeyword` (`idKeyword`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`idDieta`),
  ADD KEY `idPaciente` (`idPaciente`);

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
  ADD PRIMARY KEY (`idMenuDiario`),
  ADD KEY `idDieta` (`idDieta`),
  ADD KEY `idRenglonDelMenu` (`idRenglonDelMenu`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`);

--
-- Indices de la tabla `renglondelmenu`
--
ALTER TABLE `renglondelmenu`
  ADD PRIMARY KEY (`idRenglonDelMenu`),
  ADD KEY `idAlimento` (`idAlimento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alimento`
--
ALTER TABLE `alimento`
  MODIFY `idAlimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `keywords`
--
ALTER TABLE `keywords`
  MODIFY `idKeyword` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

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
-- AUTO_INCREMENT de la tabla `renglondelmenu`
--
ALTER TABLE `renglondelmenu`
  MODIFY `idRenglonDelMenu` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alimento_keyword`
--
ALTER TABLE `alimento_keyword`
  ADD CONSTRAINT `alimento_keyword_ibfk_1` FOREIGN KEY (`idAlimento`) REFERENCES `alimento` (`idAlimento`) ON DELETE CASCADE,
  ADD CONSTRAINT `alimento_keyword_ibfk_2` FOREIGN KEY (`idKeyword`) REFERENCES `keywords` (`idkeyword`) ON DELETE CASCADE;

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE;

--
-- Filtros para la tabla `menudiario`
--
ALTER TABLE `menudiario`
  ADD CONSTRAINT `menudiario_ibfk_1` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`idDieta`) ON DELETE CASCADE,
  ADD CONSTRAINT `menudiario_ibfk_2` FOREIGN KEY (`idRenglonDelMenu`) REFERENCES `renglondelmenu` (`idRenglonDelMenu`) ON DELETE CASCADE;

--
-- Filtros para la tabla `renglondelmenu`
--
ALTER TABLE `renglondelmenu`
  ADD CONSTRAINT `renglondelmenu_ibfk_1` FOREIGN KEY (`idAlimento`) REFERENCES `alimento` (`idAlimento`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;