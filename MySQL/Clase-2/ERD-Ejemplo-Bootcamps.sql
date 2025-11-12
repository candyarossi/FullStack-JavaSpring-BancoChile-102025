-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ChileOct2025
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ChileOct2025
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ChileOct2025` DEFAULT CHARACTER SET utf8 ;
USE `ChileOct2025` ;

-- -----------------------------------------------------
-- Table `ChileOct2025`.`Autores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ChileOct2025`.`Autores` (
  `id_autor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id_autor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ChileOct2025`.`Idiomas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ChileOct2025`.`Idiomas` (
  `id_idioma` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `Autores_id_autor` INT NOT NULL,
  PRIMARY KEY (`id_idioma`, `Autores_id_autor`),
  INDEX `fk_Idiomas_Autores1_idx` (`Autores_id_autor` ASC) VISIBLE,
  CONSTRAINT `fk_Idiomas_Autores1`
    FOREIGN KEY (`Autores_id_autor`)
    REFERENCES `ChileOct2025`.`Autores` (`id_autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ChileOct2025`.`Regiones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ChileOct2025`.`Regiones` (
  `id_region` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `Autores_id_autor` INT NOT NULL,
  PRIMARY KEY (`id_region`, `Autores_id_autor`),
  INDEX `fk_Regiones_Autores_idx` (`Autores_id_autor` ASC) VISIBLE,
  CONSTRAINT `fk_Regiones_Autores`
    FOREIGN KEY (`Autores_id_autor`)
    REFERENCES `ChileOct2025`.`Autores` (`id_autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ChileOct2025`.`Formatos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ChileOct2025`.`Formatos` (
  `id_formato` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_formato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ChileOct2025`.`Cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ChileOct2025`.`Cursos` (
  `id_curso` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NOT NULL,
  `Formatos_id_formato` INT NOT NULL,
  `Autores_id_autor` INT NOT NULL,
  PRIMARY KEY (`id_curso`, `Formatos_id_formato`, `Autores_id_autor`),
  INDEX `fk_Cursos_Formatos1_idx` (`Formatos_id_formato` ASC) VISIBLE,
  INDEX `fk_Cursos_Autores1_idx` (`Autores_id_autor` ASC) VISIBLE,
  CONSTRAINT `fk_Cursos_Formatos1`
    FOREIGN KEY (`Formatos_id_formato`)
    REFERENCES `ChileOct2025`.`Formatos` (`id_formato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cursos_Autores1`
    FOREIGN KEY (`Autores_id_autor`)
    REFERENCES `ChileOct2025`.`Autores` (`id_autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

ALTER TABLE `ChileOct2025`.`Cursos`
ADD UNIQUE INDEX `uq_id_curso` (`id_curso`);

-- -----------------------------------------------------
-- Table `ChileOct2025`.`Temas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ChileOct2025`.`Temas` (
  `id_tema` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id_tema`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ChileOct2025`.`Cursos_Temas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ChileOct2025`.`Cursos_Temas` (
  `Cursos_id_curso` INT NOT NULL,
  `Temas_id_tema` INT NOT NULL,
  PRIMARY KEY (`Cursos_id_curso`, `Temas_id_tema`),
  INDEX `fk_Cursos_has_Temas_Temas1_idx` (`Temas_id_tema` ASC) VISIBLE,
  INDEX `fk_Cursos_has_Temas_Cursos1_idx` (`Cursos_id_curso` ASC) VISIBLE,
  CONSTRAINT `fk_Cursos_has_Temas_Cursos1`
    FOREIGN KEY (`Cursos_id_curso`)
    REFERENCES `ChileOct2025`.`Cursos` (`id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cursos_has_Temas_Temas1`
    FOREIGN KEY (`Temas_id_tema`)
    REFERENCES `ChileOct2025`.`Temas` (`id_tema`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
