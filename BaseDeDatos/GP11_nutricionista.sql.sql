-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-10-2024 a las 21:35:20
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
(2, 'Ensalada Rusa', 'Cena', 120, 'Una simple ensalada con papa, zanahoria y mayonesa', 1),
(3, 'Bife con ensalada de tomate y zanahoria', 'Cena', 350, 'Bife de lomo a la plancha con ensalada de tomate y zanahoria.', 1),
(4, 'Ensalada Waldorf', 'Cena', 300, 'Ensalada de tomate, apio, almendras, manzana verde con un toque de crema de leche.', 1),
(5, 'Tostadas con mermelada light y cafe con leche descremada', 'Desayuno', 150, '2 tostadas de pan lactal integral con una cucharada de te de mermelada light a eleccion. Cafe tostado (NO TORRADO) con leche light deslactosada.', 1),
(6, 'Yoghurt con frutas citricas', 'Merienda', 120, '1 Mandarina, Naranja o Pomelo mediano con 150g de yoghurt sin azucar.', 1),
(7, 'Barritas de cereal Naturales', 'Snack', 80, '1 Barrita de cereal NaturSweet', 1),
(9, 'Ensalada rusa', 'Almuerzo', 230, 'PAPA zanahoria y nose que mas', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alimento_keyword_handler`
--

CREATE TABLE `alimento_keyword_handler` (
  `idAlimento` int(11) NOT NULL,
  `idKeyword` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alimento_keyword_handler`
--

INSERT INTO `alimento_keyword_handler` (`idAlimento`, `idKeyword`) VALUES
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
(4, 17),
(5, 18),
(5, 19),
(5, 20),
(5, 21),
(6, 18),
(6, 19),
(6, 22),
(6, 23),
(6, 24),
(7, 4),
(7, 17);

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
  `idMenuDiario` int(11) NOT NULL
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
(19, 'Deslactosado'),
(11, 'Hojas Verdes'),
(10, 'Huevo'),
(18, 'Leche'),
(23, 'Mandarina'),
(16, 'Manzana'),
(21, 'Mermelada'),
(22, 'Naranja'),
(4, 'Nuez'),
(20, 'Pan'),
(9, 'Pescado'),
(1, 'Pollo'),
(24, 'Pomelo'),
(12, 'Tomate'),
(13, 'Zanahoria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menudiario`
--

CREATE TABLE `menudiario` (
  `idMenuDiario` int(11) NOT NULL,
  `nombreMenu` varchar(100) NOT NULL,
  `dia` int(11) NOT NULL,
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
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nombre`, `dni`, `edad`, `telefono`, `pesoActual`, `pesoBuscado`, `estado`) VALUES
(1, 'maximo', 44, 21, '446503175', 75, 78, 1),
(2, 'ramon', 461132111, 0, '244232', 0, 0, 1),
(3, 'tomas', 45, 23, '4465033', 72, 71, 1),
(4, 'maximoasdsd', 4667, 11, '546503175', 65, 78, 1),
(5, 'Emilio Di pierro', 123123, 32, '2664332211', 73, 78, 1);

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
  MODIFY `idAlimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `keywords`
--
ALTER TABLE `keywords`
  MODIFY `idKeyword` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  MODIFY `idMenuDiario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
