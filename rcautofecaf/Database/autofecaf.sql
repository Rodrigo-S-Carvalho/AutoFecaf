-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema autofecaf
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema autofecaf
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `autofecaf` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `autofecaf` ;

-- -----------------------------------------------------
-- Table `autofecaf`.`veiculos_cadastrados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `autofecaf`.`veiculos_cadastrados` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `categoria_veiculo` VARCHAR(15) NOT NULL,
  `marca_veiculo` VARCHAR(30) NOT NULL,
  `modelo_veiculo` VARCHAR(60) NOT NULL,
  `ano_fabric_veiculo` YEAR NOT NULL,
  `cor_veiculo` VARCHAR(30) NOT NULL,
  `motor_veiculo` VARCHAR(100) NOT NULL,
  `num_chassi_veiculo` VARCHAR(20) NOT NULL,
  `placa_veiculo` VARCHAR(10) NULL DEFAULT NULL,
  `condicao_veiculo` VARCHAR(10) NOT NULL,
  `descricao_veiculo` VARCHAR(3000) NULL DEFAULT NULL,
  `preco_veiculo` DECIMAL(15,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
