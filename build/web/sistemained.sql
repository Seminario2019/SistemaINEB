-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-10-2019 a las 22:23:51
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemained`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad`
--

CREATE TABLE `actividad` (
  `ID_ACTIVIDAD` tinyint(2) NOT NULL,
  `ID_TIPO_ACTIVIDAD` tinyint(2) NOT NULL,
  `CODIGO_ASIGNATURA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `actividad`
--

INSERT INTO `actividad` (`ID_ACTIVIDAD`, `ID_TIPO_ACTIVIDAD`, `CODIGO_ASIGNATURA`) VALUES
(1, 1, 1),
(2, 2, 3),
(3, 2, 4),
(4, 2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `CODIGO_ALUMNO` varchar(6) COLLATE latin1_general_ci NOT NULL,
  `CORRELATIVO` int(11) NOT NULL,
  `PRIMER_NOMBRE` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `SEGUNDO_NOMBRE` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `PRIMER_APELLIDO` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `SEGUNDO_APELLIDO` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `FECHA_NACIMIENTO` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`CODIGO_ALUMNO`, `CORRELATIVO`, `PRIMER_NOMBRE`, `SEGUNDO_NOMBRE`, `PRIMER_APELLIDO`, `SEGUNDO_APELLIDO`, `FECHA_NACIMIENTO`) VALUES
('1346', 3, 'JOSE', 'CARLOS', 'HERNANDEZ', 'PEREZ', '2002-08-01'),
('234', 1, 'CARLOS', 'ESTRADA', 'MENDEZ', 'BARAONA', '2001-10-06'),
('25', 4, 'JOSE', '', 'ROBLES', '', '2000-03-12'),
('34624', 2, 'BORIS', 'ALEXANDER', 'HERNANDEZ', 'COLINDRES', '2002-08-17');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE `asignatura` (
  `CODIGO_ASIGNATURA` int(11) NOT NULL,
  `CODIGO_GRADO` tinyint(2) NOT NULL,
  `NOMBRE_CURSO` varchar(45) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`CODIGO_ASIGNATURA`, `CODIGO_GRADO`, `NOMBRE_CURSO`) VALUES
(1, 2, 'MATEMATICAS'),
(2, 3, 'MATEMATICAS'),
(3, 2, 'Carro'),
(4, 3, 'CONTA AVANZADA'),
(5, 1, 'VENTAS BANANOS'),
(6, 3, 'ARTES PLASTICAS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE `carrera` (
  `COD_CARRERA` int(11) NOT NULL,
  `NOMBRE` varchar(45) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grado`
--

CREATE TABLE `grado` (
  `CODIGO_GRADO` tinyint(2) NOT NULL,
  `NOMBRE` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `SECCION` varchar(2) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `grado`
--

INSERT INTO `grado` (`CODIGO_GRADO`, `NOMBRE`, `SECCION`) VALUES
(1, 'PRIMERO BÁSICO', 'B'),
(2, 'SEGUNDO BÁSICO', 'A'),
(3, 'TERCERO BÁSICO', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornada`
--

CREATE TABLE `jornada` (
  `ID_JORNADA` tinyint(1) NOT NULL,
  `DESCRIPCION` varchar(45) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `jornada`
--

INSERT INTO `jornada` (`ID_JORNADA`, `DESCRIPCION`) VALUES
(1, 'NOCTURNA'),
(2, 'MATUTINA'),
(3, 'VESPERTINA'),
(4, 'MIXTA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `ID_MATRICULA` int(11) NOT NULL,
  `PAGO_CODIGO_PAGO` int(11) NOT NULL,
  `JORNADA_ID_JORNADA` tinyint(1) NOT NULL,
  `ALUMNO_CORRELATIVO` int(11) NOT NULL,
  `GRADO_CODIGO_GRADO` tinyint(2) NOT NULL,
  `FECHA_MATRICULA` date NOT NULL,
  `VALOR` decimal(2,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`ID_MATRICULA`, `PAGO_CODIGO_PAGO`, `JORNADA_ID_JORNADA`, `ALUMNO_CORRELATIVO`, `GRADO_CODIGO_GRADO`, `FECHA_MATRICULA`, `VALOR`) VALUES
(1, 1, 3, 2, 3, '2019-10-11', '13'),
(2, 2, 4, 4, 2, '2019-10-01', '99'),
(3, 1, 3, 2, 2, '2019-10-11', '12'),
(4, 2, 3, 2, 2, '2019-10-11', '74'),
(5, 1, 3, 1, 2, '2019-10-11', '13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `CODIGO_PAGO` int(11) NOT NULL,
  `TIPO_PAGO` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `FECHA_PAGO` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`CODIGO_PAGO`, `TIPO_PAGO`, `FECHA_PAGO`) VALUES
(1, 'MENSUALIDAD', '2019-10-11 00:00:00'),
(2, 'EXAMEN FINAL', '2019-10-08 00:00:00'),
(3, 'ANUAL', '2019-10-09 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `privilegio`
--

CREATE TABLE `privilegio` (
  `ID_PRIVILEGIO` tinyint(2) NOT NULL,
  `USUARIO_ID_USUARIO` int(11) NOT NULL,
  `DESCRIPCION` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `FECHA_CREACION` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `USUARIO_CREACION` varchar(45) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_nota`
--

CREATE TABLE `registro_nota` (
  `ID_NOTA` tinyint(2) NOT NULL,
  `USUARIO_ID_USUARIO` int(11) NOT NULL,
  `ACTIVIDAD_ID_ACTIVIDAD` tinyint(2) NOT NULL,
  `NOTA` tinyint(3) NOT NULL,
  `PERIODO` varchar(5) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `registro_nota`
--

INSERT INTO `registro_nota` (`ID_NOTA`, `USUARIO_ID_USUARIO`, `ACTIVIDAD_ID_ACTIVIDAD`, `NOTA`, `PERIODO`) VALUES
(1, 4, 3, 85, 'tarde'),
(2, 2, 3, 45, '2do.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_actividad`
--

CREATE TABLE `tipo_actividad` (
  `ID_TIPO_ACTIVIDAD` tinyint(2) NOT NULL,
  `NOMBRE` varchar(45) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `tipo_actividad`
--

INSERT INTO `tipo_actividad` (`ID_TIPO_ACTIVIDAD`, `NOMBRE`) VALUES
(1, 'CLABSURA'),
(2, 'TAREAS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `ID_TIPO_USUARIO` tinyint(1) NOT NULL,
  `ROL` varchar(45) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_USUARIO` tinyint(3) NOT NULL,
  `CODIGO_GRADO` tinyint(2) DEFAULT NULL,
  `TIPO_USUARIO_ID_TIPO_USUARIO` int(11) DEFAULT NULL,
  `PRIMER_NOMBRE` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `SEGUNDO_NOMBRE` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `PRIMER_APELLIDO` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `SEGUNDO_APELLIDO` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `TELEFONO` varchar(8) COLLATE latin1_general_ci NOT NULL,
  `DIRECCION` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `USUARIO` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `PASSWORD` varchar(45) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_USUARIO`, `CODIGO_GRADO`, `TIPO_USUARIO_ID_TIPO_USUARIO`, `PRIMER_NOMBRE`, `SEGUNDO_NOMBRE`, `PRIMER_APELLIDO`, `SEGUNDO_APELLIDO`, `TELEFONO`, `DIRECCION`, `FECHA_NACIMIENTO`, `USUARIO`, `PASSWORD`) VALUES
(1, 0, 0, 'BORIS1DGASDGASDG', 'ALEXANDER1', 'HERNANDEZ1SDGASDGASD', 'COLINDRES1', '263461', 'GUATEMALAdag', '2019-10-31', 'boris', '81dc9bdb52d04dc20036dbd8313ed055'),
(2, NULL, NULL, 'SERGIO', 'ANTONIO', 'CASTAÑEDA', 'ESTRADA', '1346134', 'guate', NULL, 'sergio', 'f0c413d1d4719bcb155e58dc3fd137a0'),
(3, NULL, NULL, 'HENRY', 'BRAN', 'PEREZ', 'GAITAN', '1234', 'ud', NULL, 'henry', '81dc9bdb52d04dc20036dbd8313ed055'),
(4, NULL, NULL, 'CARLOS', 'ESTUARDO', 'HERNESTO', 'CANU', '', '', NULL, 'dfg', 'b2f5ff47436671b6e533d8dc3614845d');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`ID_ACTIVIDAD`),
  ADD KEY `ACTIVIDAD_TIPO_ACTIVIDAD_FK` (`ID_TIPO_ACTIVIDAD`),
  ADD KEY `ACTIVIDAD_ASIGNATURA_FK` (`CODIGO_ASIGNATURA`);

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`CODIGO_ALUMNO`,`CORRELATIVO`);

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`CODIGO_ASIGNATURA`),
  ADD KEY `ASIGNATURA_GRADO_FK` (`CODIGO_GRADO`);

--
-- Indices de la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD PRIMARY KEY (`COD_CARRERA`);

--
-- Indices de la tabla `grado`
--
ALTER TABLE `grado`
  ADD PRIMARY KEY (`CODIGO_GRADO`);

--
-- Indices de la tabla `jornada`
--
ALTER TABLE `jornada`
  ADD PRIMARY KEY (`ID_JORNADA`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`ID_MATRICULA`),
  ADD KEY `MATRICULA_PAGO_FK` (`PAGO_CODIGO_PAGO`),
  ADD KEY `MATRICULA_JORNADA_FK` (`JORNADA_ID_JORNADA`),
  ADD KEY `MATRICULA_ALUMNO_FK` (`ALUMNO_CORRELATIVO`),
  ADD KEY `MATRICULA_GRADO_FK` (`GRADO_CODIGO_GRADO`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`CODIGO_PAGO`);

--
-- Indices de la tabla `privilegio`
--
ALTER TABLE `privilegio`
  ADD PRIMARY KEY (`ID_PRIVILEGIO`),
  ADD KEY `PRIVILEGIO_USUARIO_FK` (`USUARIO_ID_USUARIO`);

--
-- Indices de la tabla `registro_nota`
--
ALTER TABLE `registro_nota`
  ADD PRIMARY KEY (`ID_NOTA`),
  ADD KEY `REGISTRO_NOTA_USUARIO_FK` (`USUARIO_ID_USUARIO`),
  ADD KEY `REGISTRO_NOTA_ACTIVIDAD_FK` (`ACTIVIDAD_ID_ACTIVIDAD`);

--
-- Indices de la tabla `tipo_actividad`
--
ALTER TABLE `tipo_actividad`
  ADD PRIMARY KEY (`ID_TIPO_ACTIVIDAD`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`ID_TIPO_USUARIO`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_USUARIO`),
  ADD KEY `USUARIO_GRADO_FK` (`CODIGO_GRADO`),
  ADD KEY `USUARIO_TIPO_USUARIO_FK` (`TIPO_USUARIO_ID_TIPO_USUARIO`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD CONSTRAINT `FK_ACTIVIDAD_ASIGNATURA` FOREIGN KEY (`CODIGO_ASIGNATURA`) REFERENCES `asignatura` (`CODIGO_ASIGNATURA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ACTIVIDAD_TIPO_ACTIVIDAD1` FOREIGN KEY (`ID_TIPO_ACTIVIDAD`) REFERENCES `tipo_actividad` (`ID_TIPO_ACTIVIDAD`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD CONSTRAINT `fk_ASIGNATURA_GRADO1` FOREIGN KEY (`CODIGO_GRADO`) REFERENCES `grado` (`CODIGO_GRADO`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
