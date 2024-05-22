-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2024 at 03:06 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mediateca`
--

-- --------------------------------------------------------

--
-- Table structure for table `cdaudio`
--

CREATE TABLE `cdaudio` (
  `idCdAudio` int(11) NOT NULL,
  `idDocumento` int(11) DEFAULT NULL,
  `artista` varchar(255) DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `numCanciones` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cdaudio`
--

INSERT INTO `cdaudio` (`idCdAudio`, `idDocumento`, `artista`, `genero`, `duracion`, `numCanciones`) VALUES
(1, 1, 'Los Mediocres ', 'Crimen', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `documentos`
--

CREATE TABLE `documentos` (
  `idDocumento` int(11) NOT NULL,
  `idTipoDocumento` int(11) DEFAULT NULL,
  `titulo` varchar(255) NOT NULL,
  `autor` varchar(255) DEFAULT NULL,
  `añoPublicacion` year(4) DEFAULT NULL,
  `ubicacionFisica` varchar(100) DEFAULT NULL,
  `cantidadDisponible` int(11) NOT NULL,
  `estado` varchar(155) NOT NULL,
  `fechaAdquisicion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `documentos`
--

INSERT INTO `documentos` (`idDocumento`, `idTipoDocumento`, `titulo`, `autor`, `añoPublicacion`, `ubicacionFisica`, `cantidadDisponible`, `estado`, `fechaAdquisicion`) VALUES
(1, 4, 'Los Fabulosos Toyota', 'Los Mediocres Cadillac', '1991', 'Mexico', 122, 'Disponible', '2024-05-22'),
(2, 3, 'With me', 'M&M', '2010', 'USA', 1, 'Reservado', '2024-05-21');

-- --------------------------------------------------------

--
-- Table structure for table `dvd`
--

CREATE TABLE `dvd` (
  `idDVD` int(11) NOT NULL,
  `idDocumento` int(11) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `libro`
--

CREATE TABLE `libro` (
  `idLibro` int(11) NOT NULL,
  `idDocumento` int(11) DEFAULT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `editorial` varchar(255) DEFAULT NULL,
  `numPaginas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `materias`
--

CREATE TABLE `materias` (
  `idMateria` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `materiasdocumentos`
--

CREATE TABLE `materiasdocumentos` (
  `idMateriaDocumento` int(11) NOT NULL,
  `idDocumento` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `prestamos`
--

CREATE TABLE `prestamos` (
  `idPrestamo` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `idDocumento` int(11) DEFAULT NULL,
  `fechaPrestamo` date DEFAULT NULL,
  `fechaDevolucion` date DEFAULT NULL,
  `estado` varchar(255) NOT NULL,
  `mora` decimal(10,2) DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `prestamos`
--

INSERT INTO `prestamos` (`idPrestamo`, `idUsuario`, `idDocumento`, `fechaPrestamo`, `fechaDevolucion`, `estado`, `mora`) VALUES
(1, 1, 1, '2024-05-21', '2024-05-28', 'Prestado', 5.33);

-- --------------------------------------------------------

--
-- Table structure for table `revista`
--

CREATE TABLE `revista` (
  `idRevista` int(11) NOT NULL,
  `idDocumento` int(11) DEFAULT NULL,
  `issn` varchar(20) DEFAULT NULL,
  `editorial` varchar(255) DEFAULT NULL,
  `periodicidad` varchar(20) DEFAULT NULL,
  `fechaPublicacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tesis`
--

CREATE TABLE `tesis` (
  `idTesis` int(11) NOT NULL,
  `idDocumento` int(11) DEFAULT NULL,
  `directorTesis` varchar(255) DEFAULT NULL,
  `gradoObtenido` varchar(50) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `idTipoDocumento` int(11) NOT NULL,
  `nombreTipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tipodocumento`
--

INSERT INTO `tipodocumento` (`idTipoDocumento`, `nombreTipo`) VALUES
(1, 'Revista'),
(2, 'Tesis'),
(3, 'Libro'),
(4, 'CD');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `tipoUsuario` varchar(150) DEFAULT NULL,
  `contrasena` varchar(100) DEFAULT NULL,
  `cantidadMora` int(11) NOT NULL,
  `tiempoMora` int(11) NOT NULL,
  `codigoUsuario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `nombre`, `apellido`, `tipoUsuario`, `contrasena`, `cantidadMora`, `tiempoMora`, `codigoUsuario`) VALUES
(1, 'Jimmy', 'Space', 'Administrador', 'Pepe', 0, 0, ''),
(2, 'Johnny', 'Lol', 'Docente', 'OhYe', 0, 2, 'AM2002as'),
(15, 'Pepe1', 'Lol', 'Alumno', 'OhYe', 0, 2, 'AM2002as'),
(16, 'Pepe1', 'Lol', 'Docente', 'OhYe', 0, 2, 'AM2002as'),
(17, 'Pepe1', 'Lol', 'Docente', 'OhYe', 0, 2, 'AM2002as');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cdaudio`
--
ALTER TABLE `cdaudio`
  ADD PRIMARY KEY (`idCdAudio`),
  ADD KEY `ID_Documento` (`idDocumento`);

--
-- Indexes for table `documentos`
--
ALTER TABLE `documentos`
  ADD PRIMARY KEY (`idDocumento`),
  ADD KEY `ID_Tipo_Documento` (`idTipoDocumento`);

--
-- Indexes for table `dvd`
--
ALTER TABLE `dvd`
  ADD PRIMARY KEY (`idDVD`),
  ADD KEY `ID_Documento` (`idDocumento`);

--
-- Indexes for table `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`idLibro`),
  ADD KEY `ID_Documento` (`idDocumento`);

--
-- Indexes for table `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`idMateria`);

--
-- Indexes for table `materiasdocumentos`
--
ALTER TABLE `materiasdocumentos`
  ADD PRIMARY KEY (`idMateriaDocumento`),
  ADD KEY `documento_fk` (`idDocumento`),
  ADD KEY `materia_fk` (`idMateria`);

--
-- Indexes for table `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`idPrestamo`),
  ADD KEY `ID_Usuario` (`idUsuario`),
  ADD KEY `ID_Documento` (`idDocumento`);

--
-- Indexes for table `revista`
--
ALTER TABLE `revista`
  ADD PRIMARY KEY (`idRevista`),
  ADD KEY `ID_Documento` (`idDocumento`);

--
-- Indexes for table `tesis`
--
ALTER TABLE `tesis`
  ADD PRIMARY KEY (`idTesis`),
  ADD KEY `ID_Documento` (`idDocumento`);

--
-- Indexes for table `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`idTipoDocumento`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cdaudio`
--
ALTER TABLE `cdaudio`
  MODIFY `idCdAudio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `documentos`
--
ALTER TABLE `documentos`
  MODIFY `idDocumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `dvd`
--
ALTER TABLE `dvd`
  MODIFY `idDVD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `libro`
--
ALTER TABLE `libro`
  MODIFY `idLibro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `materias`
--
ALTER TABLE `materias`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `materiasdocumentos`
--
ALTER TABLE `materiasdocumentos`
  MODIFY `idMateriaDocumento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `idPrestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `revista`
--
ALTER TABLE `revista`
  MODIFY `idRevista` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tesis`
--
ALTER TABLE `tesis`
  MODIFY `idTesis` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `idTipoDocumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cdaudio`
--
ALTER TABLE `cdaudio`
  ADD CONSTRAINT `cdaudio_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`);

--
-- Constraints for table `documentos`
--
ALTER TABLE `documentos`
  ADD CONSTRAINT `documentos_ibfk_1` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipodocumento` (`idTipoDocumento`);

--
-- Constraints for table `dvd`
--
ALTER TABLE `dvd`
  ADD CONSTRAINT `dvd_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`);

--
-- Constraints for table `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`);

--
-- Constraints for table `materiasdocumentos`
--
ALTER TABLE `materiasdocumentos`
  ADD CONSTRAINT `documento_fk` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `materia_fk` FOREIGN KEY (`idMateria`) REFERENCES `materias` (`idMateria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`),
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`);

--
-- Constraints for table `revista`
--
ALTER TABLE `revista`
  ADD CONSTRAINT `revista_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`);

--
-- Constraints for table `tesis`
--
ALTER TABLE `tesis`
  ADD CONSTRAINT `tesis_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
