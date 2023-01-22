-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-01-2023 a las 12:36:00
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dagss_gestionmedica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id` bigint(20) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `TIPO_USUARIO` varchar(20) DEFAULT NULL,
  `ultimoAcceso` datetime DEFAULT NULL,
  `nombre_de_usuario` varchar(255) DEFAULT NULL,
  `contrasenha` varchar(255) DEFAULT NULL,
  `rol` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centros_medicos`
--

CREATE TABLE `centros_medicos` (
  `nombre` char(36) NOT NULL,
  `domicilio` varchar(255) NOT NULL,
  `localidad` varchar(255) NOT NULL,
  `codigo_postal` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `centros_medicos`
--

INSERT INTO `centros_medicos` (`nombre`, `domicilio`, `localidad`, `codigo_postal`, `telefono`, `email`, `estado`) VALUES
('Hospital Virxe da Xunqueira', 'Avenida Fernando Blanco 230', 'Cee', '15220', '555555555', 'xunqueira.hospital@sergas.xunta.gal', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `paciente_citado` varchar(255) NOT NULL,
  `medico` varchar(255) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `duracion` time NOT NULL,
  `estado` varchar(255) NOT NULL COMMENT ' (PLANIFICADA, ANULADA, COMPLETADA, AUSENTE)"'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `farmacia`
--

CREATE TABLE `farmacia` (
  `id` bigint(20) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `TIPO_USUARIO` varchar(20) DEFAULT NULL,
  `ultimoAcceso` datetime DEFAULT NULL,
  `nombre_de_usuario` varchar(255) DEFAULT NULL,
  `contrasenha` varchar(255) DEFAULT NULL,
  `rol` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `farmacias`
--

CREATE TABLE `farmacias` (
  `nombre_establecimiento` varchar(255) NOT NULL,
  `nombre_farmaceutico` varchar(255) NOT NULL,
  `apellidos_farmaceutico` varchar(255) NOT NULL,
  `dni_nif` varchar(10) NOT NULL,
  `colegiado_farmaceutico` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `localidad` varchar(255) NOT NULL,
  `codigo_postal` varchar(10) NOT NULL,
  `provincia` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos`
--

CREATE TABLE `medicamentos` (
  `nombre_comercial` varchar(255) NOT NULL,
  `principio_activo` varchar(255) NOT NULL,
  `fabricante` varchar(255) NOT NULL,
  `familia` varchar(255) NOT NULL,
  `numero_dosis` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `id` bigint(20) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `TIPO_USUARIO` varchar(20) DEFAULT NULL,
  `ultimoAcceso` datetime DEFAULT NULL,
  `nombre_de_usuario` varchar(255) DEFAULT NULL,
  `contrasenha` varchar(255) DEFAULT NULL,
  `rol` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicos`
--

CREATE TABLE `medicos` (
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `num_colegiado` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `centro_de_salud` char(36) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `nombre_de_usuario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medicos`
--

INSERT INTO `medicos` (`nombre`, `apellidos`, `dni`, `num_colegiado`, `telefono`, `email`, `centro_de_salud`, `estado`, `nombre_de_usuario`) VALUES
('Susana', 'García Piñeiro', '15548976Y', '123456789', '555444333', 'susana.gp@gmail.com', 'Hospital Virxe da Xunqueira', 1, 'susanagp');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `id` bigint(20) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `TIPO_USUARIO` varchar(20) DEFAULT NULL,
  `ultimoAcceso` datetime DEFAULT NULL,
  `nombre_de_usuario` varchar(255) DEFAULT NULL,
  `contrasenha` varchar(255) DEFAULT NULL,
  `rol` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `tarjeta_sanitaria` varchar(255) NOT NULL,
  `seguridad_social` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `localidad` varchar(255) NOT NULL,
  `codigo_postal` varchar(10) NOT NULL,
  `provincia` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `centro_salud` varchar(255) NOT NULL,
  `medico` varchar(255) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nombre_de_usuario` varchar(255) NOT NULL,
  `contrasenha` varchar(255) NOT NULL,
  `rol` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`nombre_de_usuario`, `contrasenha`, `rol`) VALUES
('susanagp', 'susanagp', 'medico'),
('test', 'test', 'administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_gen`
--

CREATE TABLE `usuario_gen` (
  `GEN_NAME` varchar(255) NOT NULL,
  `GEN_VAL` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario_gen`
--

INSERT INTO `usuario_gen` (`GEN_NAME`, `GEN_VAL`) VALUES
('Usuario', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `centros_medicos`
--
ALTER TABLE `centros_medicos`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `farmacia`
--
ALTER TABLE `farmacia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `farmacias`
--
ALTER TABLE `farmacias`
  ADD PRIMARY KEY (`dni_nif`),
  ADD UNIQUE KEY `nombre_establecimiento` (`nombre_establecimiento`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`num_colegiado`),
  ADD UNIQUE KEY `nombre_de_usuario` (`nombre_de_usuario`),
  ADD KEY `medicos_ibfk_2` (`centro_de_salud`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`dni`),
  ADD UNIQUE KEY `tarjeta_sanitaria` (`tarjeta_sanitaria`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`nombre_de_usuario`);

--
-- Indices de la tabla `usuario_gen`
--
ALTER TABLE `usuario_gen`
  ADD PRIMARY KEY (`GEN_NAME`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
