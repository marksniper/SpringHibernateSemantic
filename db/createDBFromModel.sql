-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DATABASE
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DATABASE
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DATABASE` ;
USE `DATABASE` ;

-- -----------------------------------------------------
-- Table `DATABASE`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DATABASE`.`USER` (
  `idUSER` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `dateRegistration` DATETIME NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` BLOB NOT NULL,
  `token` BLOB NULL,
  `isActive` TINYINT NOT NULL,
  PRIMARY KEY (`idUSER`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DATABASE`.`CUSTOMER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DATABASE`.`CUSTOMER` (
  `idCUSTOMER` INT NOT NULL,
  `USER_idUSER` INT NOT NULL,
  `address` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `zipcode` VARCHAR(10) NULL,
  PRIMARY KEY (`idCUSTOMER`),
  INDEX `fk_CUSTOMER_USER_idx` (`USER_idUSER` ASC) VISIBLE,
  CONSTRAINT `fk_CUSTOMER_USER`
    FOREIGN KEY (`USER_idUSER`)
    REFERENCES `DATABASE`.`USER` (`idUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DATABASE`.`EMPLOYEE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DATABASE`.`EMPLOYEE` (
  `idEMPLOYEE` INT NOT NULL,
  `salary` VARCHAR(45) NULL,
  `USER_idUSER` INT NOT NULL,
  PRIMARY KEY (`idEMPLOYEE`),
  INDEX `fk_EMPLOYEE_USER1_idx` (`USER_idUSER` ASC) VISIBLE,
  CONSTRAINT `fk_EMPLOYEE_USER1`
    FOREIGN KEY (`USER_idUSER`)
    REFERENCES `DATABASE`.`USER` (`idUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DATABASE`.`PRODUCT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DATABASE`.`PRODUCT` (
  `idproduct` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `quantity` INT NULL,
  `price` FLOAT NULL,
  `dateInsert` DATETIME NULL,
  `ispresent` TINYINT NOT NULL,
  PRIMARY KEY (`idproduct`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DATABASE`.`BUY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DATABASE`.`BUY` (
  `CUSTOMER_idCUSTOMER` INT NOT NULL,
  `PRODUCT_idproduct` INT NOT NULL,
  `purchaseDate` VARCHAR(45) NULL,
  PRIMARY KEY (`CUSTOMER_idCUSTOMER`, `PRODUCT_idproduct`),
  INDEX `fk_product_has_CUSTOMER_CUSTOMER1_idx` (`CUSTOMER_idCUSTOMER` ASC) VISIBLE,
  INDEX `fk_BUY_PRODUCT1_idx` (`PRODUCT_idproduct` ASC) VISIBLE,
  CONSTRAINT `fk_product_has_CUSTOMER_CUSTOMER1`
    FOREIGN KEY (`CUSTOMER_idCUSTOMER`)
    REFERENCES `DATABASE`.`CUSTOMER` (`idCUSTOMER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BUY_PRODUCT1`
    FOREIGN KEY (`PRODUCT_idproduct`)
    REFERENCES `DATABASE`.`PRODUCT` (`idproduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `DATABASE` ;

-- -----------------------------------------------------
--  routine1
-- -----------------------------------------------------

DELIMITER $$
USE `DATABASE`$$
$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
