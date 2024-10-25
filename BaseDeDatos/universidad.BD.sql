-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-10-2024 a las 02:04:04
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
(4, 'Ensalada Waldorf', 'Cena', 300, 'Ensalada de tomate, apio, almendras, manzana verde con un toque de crema de leche.', 1),
(5, 'Tostadas con mermelada light y cafe con leche descremada', 'Desayuno', 150, '2 tostadas de pan lactal integral con una cucharada de te de mermelada light a eleccion. Cafe tostado (NO TORRADO) con leche light deslactosada.', 1),
(6, 'Yoghurt con frutas citricas', 'Merienda', 120, '1 Mandarina, Naranja o Pomelo mediano con 150g de yoghurt sin azucar.', 1),
(7, 'Barritas de cereal Naturales', 'Snack', 80, '1 Barrita de cereal NaturSweet', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alimento`
--
ALTER TABLE `alimento`
  ADD PRIMARY KEY (`idAlimento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alimento`
--
ALTER TABLE `alimento`
  MODIFY `idAlimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
