-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 15-Abr-2015 às 00:23
-- Versão do servidor: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `escola`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(25) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9qv6yhjqm8iafto8qk452gx8h` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `member`
--

INSERT INTO `member` (`id`, `email`, `name`, `phone_number`) VALUES
(0, 'john.smith@mailinator.com', 'John Smith', '2125551212');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_aluno`
--

CREATE TABLE IF NOT EXISTS `tb_aluno` (
  `DATA_ANIVERSARIO` date NOT NULL,
  `MATRICULA` bigint(20) NOT NULL,
  `ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_bb5i9txqriuho8qfrojvhq7wl` (`MATRICULA`),
  KEY `FK_6rfemk1ppmaoxx9ph1pqdb1e2` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_aluno`
--

INSERT INTO `tb_aluno` (`DATA_ANIVERSARIO`, `MATRICULA`, `ID`) VALUES
('2015-04-01', 54321, 1),
('1990-01-10', 222222, 2),
('1980-12-24', 333333, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_pessoa`
--

CREATE TABLE IF NOT EXISTS `tb_pessoa` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CPF` char(14) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_29q61rpxcuh0xf0p4xe8r3ae` (`CPF`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `tb_pessoa`
--

INSERT INTO `tb_pessoa` (`ID`, `CPF`, `nome`) VALUES
(1, '11111111111', 'Paulo Jose'),
(2, '22222222222', 'Maria Jose'),
(3, '33333333333', 'Joao Jose');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_professor`
--

CREATE TABLE IF NOT EXISTS `tb_professor` (
  `SALARIO` decimal(19,2) NOT NULL,
  `ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_bvnnxbfl8oni0xih7dp0urel6` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_professor`
--

INSERT INTO `tb_professor` (`SALARIO`, `ID`) VALUES
('5000.00', 1),
('6000.00', 2),
('7000.00', 3);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tb_aluno`
--
ALTER TABLE `tb_aluno`
  ADD CONSTRAINT `FK_6rfemk1ppmaoxx9ph1pqdb1e2` FOREIGN KEY (`ID`) REFERENCES `tb_pessoa` (`ID`);

--
-- Limitadores para a tabela `tb_professor`
--
ALTER TABLE `tb_professor`
  ADD CONSTRAINT `FK_bvnnxbfl8oni0xih7dp0urel6` FOREIGN KEY (`ID`) REFERENCES `tb_pessoa` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
