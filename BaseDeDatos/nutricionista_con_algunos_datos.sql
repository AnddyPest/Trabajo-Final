-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-11-2024 a las 22:14:56
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
(1, 'Tostadas', 'desayuno', 75, 'Rebanadas de pan tostado', 1),
(2, 'Cereal', 'desayuno', 110, 'Copos de cereal con leche', 1),
(3, 'Huevos revueltos', 'desayuno', 150, 'Huevos revueltos con mantequilla', 1),
(4, 'Yogur con frutas', 'desayuno', 120, 'Yogur natural con frutas frescas', 1),
(5, 'Sandwich de jamón y queso', 'merienda', 300, 'Pan con jamón y queso', 1),
(6, 'Batido de frutas', 'merienda', 200, 'Licuado de frutas variadas', 1),
(7, 'Galletas integrales', 'snack', 50, 'Galletas crujientes de trigo', 1),
(8, 'Barrita de granola', 'snack', 95, 'Barrita energética de granola', 1),
(9, 'Ensalada César', 'almuerzo', 180, 'Ensalada clásica con pollo y aderezo', 1),
(10, 'Sopa de vegetales', 'almuerzo', 80, 'Sopa nutritiva de vegetales', 1),
(11, 'Pollo asado', 'almuerzo', 250, 'Pollo asado al horno', 1),
(12, 'Pasta con salsa', 'almuerzo', 350, 'Pasta con salsa de tomate', 1),
(13, 'Pizza margarita', 'cena', 280, 'Pizza con tomate y mozzarella', 1),
(14, 'Hamburguesa', 'cena', 500, 'Hamburguesa con queso', 1),
(15, 'Tacos', 'cena', 250, 'Tacos de carne con vegetales', 1),
(16, 'Quesadillas', 'cena', 300, 'Tortillas de maíz con queso', 1),
(17, 'Ensalada de frutas', 'snack', 70, 'Mezcla de frutas frescas', 1),
(18, 'Frutos secos', 'snack', 200, 'Mezcla de nueces y almendras', 1),
(19, 'Panqueques', 'desayuno', 220, 'Panqueques con miel', 1),
(20, 'Té con leche', 'desayuno', 40, 'Infusión con leche', 1),
(21, 'Croissant', 'desayuno', 406, 'Hojaldre francés con mantequilla', 1),
(22, 'Bagel', 'desayuno', 250, 'Pan en forma de rosquilla', 1),
(23, 'Avena con frutas', 'desayuno', 150, 'Avena cocida con frutas', 1),
(24, 'Batido verde', 'desayuno', 100, 'Batido de vegetales y frutas', 1),
(25, 'Ensalada de pollo', 'merienda', 220, 'Ensalada de pollo con aderezo ligero', 1),
(26, 'Wrap de pavo', 'merienda', 300, 'Tortilla rellena de pavo y vegetales', 1),
(27, 'Manzana con mantequilla de maní', 'snack', 120, 'Rodajas de manzana con mantequilla de maní', 1),
(28, 'Palomitas de maíz', 'snack', 100, 'Palomitas de maíz naturales', 1),
(29, 'Quiche de espinacas', 'almuerzo', 250, 'Tarta salada de espinacas y queso', 1),
(30, 'Ratatouille', 'almuerzo', 150, 'Estofado de vegetales', 1),
(31, 'Lasaña', 'almuerzo', 350, 'Pasta al horno con carne y queso', 1),
(32, 'Sushi', 'almuerzo', 200, 'Arroz con pescado y vegetales', 1),
(33, 'Ravioles', 'cena', 300, 'Pasta rellena con salsa', 1),
(34, 'Pollo a la parrilla', 'cena', 220, 'Pollo cocido a la parrilla', 1),
(35, 'Estofado de ternera', 'cena', 280, 'Ternera cocida con vegetales', 1),
(36, 'Salteado de vegetales', 'cena', 120, 'Mezcla de vegetales salteados', 1),
(37, 'Barrita de proteína', 'snack', 180, 'Barrita nutritiva rica en proteínas', 1),
(38, 'Chips de kale', 'snack', 50, 'Hojas de kale deshidratadas', 1),
(39, 'Tostadas con aguacate', 'desayuno', 160, 'Pan tostado con aguacate', 1),
(40, 'Café con leche', 'desayuno', 30, 'Bebida de café con leche', 1);

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
(2, 3),
(2, 4),
(3, 4),
(3, 5),
(4, 6),
(4, 7),
(5, 1),
(5, 13),
(5, 14),
(6, 7),
(7, 32),
(8, 15),
(9, 16),
(9, 17),
(9, 19),
(10, 18),
(11, 19),
(12, 20),
(12, 21),
(13, 22),
(13, 23),
(14, 1),
(14, 14),
(14, 24),
(15, 18),
(15, 24),
(16, 14),
(16, 25),
(17, 7),
(18, 26),
(18, 27),
(19, 3),
(19, 4),
(19, 28),
(19, 29),
(20, 3),
(20, 30),
(21, 5),
(21, 33),
(22, 1),
(22, 35),
(23, 7),
(23, 36),
(24, 7),
(24, 18),
(25, 17),
(25, 19);

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

--
-- Volcado de datos para la tabla `keywords`
--

INSERT INTO `keywords` (`idKeyword`, `keyword`) VALUES
(17, 'aderezo'),
(31, 'aguacate'),
(27, 'almendras'),
(36, 'avena'),
(24, 'carne'),
(2, 'cereal'),
(7, 'frutas'),
(15, 'granola'),
(28, 'harina'),
(33, 'hojaldre'),
(4, 'huevos'),
(13, 'jamón'),
(3, 'leche'),
(16, 'lechuga'),
(5, 'mantequilla'),
(29, 'miel'),
(23, 'mozzarella'),
(26, 'nueces'),
(1, 'pan'),
(20, 'pasta'),
(19, 'pollo'),
(14, 'queso'),
(35, 'rosquilla'),
(21, 'salsa de tomate'),
(30, 'té'),
(22, 'tomate'),
(25, 'tortilla de maíz'),
(32, 'trigo'),
(18, 'vegetales'),
(6, 'yogur');

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
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nombre`, `dni`, `edad`, `telefono`, `pesoActual`, `pesoBuscado`, `estado`) VALUES
(1, 'Ana Perez', 30123456, 28, '5551234', 68.5, 60, 1),
(2, 'Carlos Gonzalez', 32123457, 34, '5552345', 85, 78, 1),
(3, 'María Lopez', 31123458, 45, '5553456', 70, 65, 1),
(4, 'Juan Martinez', 30123459, 50, '5554567', 90.5, 80, 1),
(5, 'Luisa Fernandez', 33123450, 22, '5555678', 60, 55, 1),
(6, 'Miguel Sanchez', 34123451, 30, '5556789', 95, 85, 1),
(7, 'Elena Diaz', 30123452, 40, '5557890', 75, 68, 1),
(8, 'Roberto Torres', 32123453, 29, '5558901', 82, 77, 1),
(9, 'Laura Ramirez', 31123454, 33, '5559012', 62, 58, 1),
(10, 'David Silva', 30123455, 27, '5550123', 88, 80, 1),
(11, 'Patricia Ruiz', 33123456, 38, '5551234', 67, 62, 1),
(12, 'Alejandro Ortiz', 34123457, 43, '5552345', 85.5, 78, 1),
(13, 'Sofia Morales', 30123458, 26, '5553456', 59, 55, 1),
(14, 'Diego Ramirez', 32123459, 35, '5554567', 92, 85, 1),
(15, 'Lucia Gomez', 31123450, 24, '5555678', 66, 60, 1),
(16, 'Javier Herrera', 30123451, 48, '5556789', 77, 70, 1),
(17, 'Mariana Rojas', 33123452, 36, '5557890', 68, 63, 1),
(18, 'Fernando Castro', 34123453, 32, '5558901', 88, 82, 1),
(19, 'Isabel Molina', 30123454, 28, '5559012', 65, 60, 1),
(20, 'Andrés Jimenez', 32123455, 29, '5550123', 90, 85, 1),
(21, 'Mario Flores', 34123456, 55, '5552233', 92, 85, 1),
(22, 'Clara Morales', 35123457, 31, '5553344', 60.5, 55, 1),
(23, 'Luis Torres', 36123458, 47, '5554455', 89, 82, 1),
(24, 'Cristina Mendez', 37123459, 53, '5555566', 73, 68, 1),
(25, 'Ricardo Alvarez', 38123450, 38, '5556677', 95.5, 90, 1),
(26, 'Elisa Vega', 39123451, 29, '5557788', 65, 60, 1),
(27, 'Hector Delgado', 40123452, 45, '5558899', 85, 78, 1),
(28, 'Nuria Castro', 41123453, 26, '5559900', 58, 53, 1),
(29, 'Martin Ortiz', 42123454, 32, '5550011', 90, 82, 1),
(30, 'Diana Soto', 43123455, 41, '5551122', 72, 65, 1),
(31, 'Jose Navarro', 44123456, 37, '5552233', 86.5, 80, 1),
(32, 'Marta Ruiz', 45123457, 30, '5553344', 61, 55, 1),
(33, 'Felipe Hernandez', 46123458, 39, '5554455', 87, 78, 1),
(34, 'Isabel Suarez', 47123459, 52, '5555566', 70, 65, 1),
(35, 'Adrian Gutierrez', 48123450, 28, '5556677', 80, 73, 1),
(36, 'Olga Molina', 49123451, 35, '5557788', 69, 62, 1),
(37, 'Pablo Figueroa', 50123452, 49, '5558899', 93, 85, 1),
(38, 'Carla Romero', 51123453, 27, '5559900', 58.5, 54, 1),
(39, 'Fernando Rojas', 52123454, 36, '5550011', 89, 82, 1),
(40, 'Nora Sanchez', 53123455, 44, '5551122', 75, 68, 1);

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
  MODIFY `idAlimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `keywords`
--
ALTER TABLE `keywords`
  MODIFY `idKeyword` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  MODIFY `idMenuDiario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

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
