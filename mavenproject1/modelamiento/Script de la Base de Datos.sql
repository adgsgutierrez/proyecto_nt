-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema trimage
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema trimage
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `trimage` DEFAULT CHARACTER SET utf8 ;
USE `trimage` ;

-- -----------------------------------------------------
-- Table `trimage`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trimage`.`usuario` (
  `usuario_id` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario_correo` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `usuario_clave` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `usuario_avatar` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `usuario_nombre` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`usuario_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;


-- -----------------------------------------------------
-- Table `trimage`.`imagen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trimage`.`imagen` (
  `imagen_id` INT(11) NOT NULL,
  `imagen_nombre` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `imagen_descripcion` VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `imagen_fecha` DATE NULL DEFAULT NULL,
  `imagen_estado` ENUM('V', 'S') CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `imagen_costo` INT(11) NULL DEFAULT NULL,
  `imagen_min` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `imagen_full` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `usuario_usuario_id` INT(11) NOT NULL,
  PRIMARY KEY (`imagen_id`),
  INDEX `fk_imagen_usuario1_idx` (`usuario_usuario_id` ASC),
  CONSTRAINT `fk_imagen_usuario1`
    FOREIGN KEY (`usuario_usuario_id`)
    REFERENCES `trimage`.`usuario` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;


-- -----------------------------------------------------
-- Table `trimage`.`tarjeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trimage`.`tarjeta` (
  `tarjeta_numero` INT(11) NOT NULL,
  `tarjeta_cvc` INT(11) NULL DEFAULT NULL,
  `tarjeta_fecha` DATE NULL DEFAULT NULL,
  `usuario_usuario_id` INT(11) NOT NULL,
  PRIMARY KEY (`tarjeta_numero`),
  INDEX `fk_tarjeta_usuario1_idx` (`usuario_usuario_id` ASC),
  CONSTRAINT `fk_tarjeta_usuario1`
    FOREIGN KEY (`usuario_usuario_id`)
    REFERENCES `trimage`.`usuario` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;


-- -----------------------------------------------------
-- Table `trimage`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trimage`.`compra` (
  `compra_id` INT(11) NOT NULL,
  `compra_fecha` DATETIME NULL DEFAULT NULL,
  `compra_estado` ENUM('S', 'E', 'D', 'F') CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'Estados\nS : Solicitado\nE : Enviado\nD : Descargado\nF : Finalizado',
  `imagen_imagen_id` INT(11) NOT NULL,
  `tarjeta_tarjeta_numero` INT(11) NOT NULL,
  `compra_calificacion` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`compra_id`),
  INDEX `fk_compra_imagen_idx` (`imagen_imagen_id` ASC),
  INDEX `fk_compra_tarjeta1_idx` (`tarjeta_tarjeta_numero` ASC),
  CONSTRAINT `fk_compra_imagen`
    FOREIGN KEY (`imagen_imagen_id`)
    REFERENCES `trimage`.`imagen` (`imagen_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_tarjeta1`
    FOREIGN KEY (`tarjeta_tarjeta_numero`)
    REFERENCES `trimage`.`tarjeta` (`tarjeta_numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;


-- -----------------------------------------------------
-- Table `trimage`.`contacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trimage`.`contacto` (
  `usuario_contacto` INT(11) NOT NULL,
  `usuario_propietario` INT(11) NOT NULL,
  PRIMARY KEY (`usuario_contacto`, `usuario_propietario`),
  INDEX `fk_contacto_usuario2_idx` (`usuario_propietario` ASC),
  CONSTRAINT `fk_contacto_usuario1`
    FOREIGN KEY (`usuario_contacto`)
    REFERENCES `trimage`.`usuario` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contacto_usuario2`
    FOREIGN KEY (`usuario_propietario`)
    REFERENCES `trimage`.`usuario` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;


-- -----------------------------------------------------
-- Table `trimage`.`like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trimage`.`like` (
  `imagen_imagen_id` INT(11) NOT NULL,
  `usuario_usuario_id` INT(11) NOT NULL,
  PRIMARY KEY (`imagen_imagen_id`, `usuario_usuario_id`),
  INDEX `fk_like_usuario1_idx` (`usuario_usuario_id` ASC),
  CONSTRAINT `fk_like_imagen1`
    FOREIGN KEY (`imagen_imagen_id`)
    REFERENCES `trimage`.`imagen` (`imagen_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_like_usuario1`
    FOREIGN KEY (`usuario_usuario_id`)
    REFERENCES `trimage`.`usuario` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;


-- -----------------------------------------------------
-- Table `trimage`.`notificación`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trimage`.`notificación` (
  `notificacion_id` INT(11) NOT NULL,
  `notificacion_descripción` VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `notificación_estado` ENUM('V', 'R') CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `compra_compra_id` INT(11) NOT NULL,
  PRIMARY KEY (`notificacion_id`),
  INDEX `fk_notificación_compra1_idx` (`compra_compra_id` ASC),
  CONSTRAINT `fk_notificación_compra1`
    FOREIGN KEY (`compra_compra_id`)
    REFERENCES `trimage`.`compra` (`compra_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
