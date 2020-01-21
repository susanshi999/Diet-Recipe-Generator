-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Recipes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Recipes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Recipes` DEFAULT CHARACTER SET utf8 ;
USE `Recipes` ;

-- -----------------------------------------------------
-- Table `Recipes`.`Recipes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Recipes`.`Recipes` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Calories` INT NOT NULL,
  `Name` VARCHAR(100) NOT NULL,
  `image_url` VARCHAR(255) NULL,
  `Procedure` TEXT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Recipes`.`Ingredients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Recipes`.`Ingredients` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Recipes`.`Recipes_Ingredients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Recipes`.`Recipes_Ingredients` (
  `Recipes_ID` INT NOT NULL,
  `Ingredients_ID` INT NOT NULL,
  `Amount` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Recipes_ID`, `Ingredients_ID`),
  INDEX `fk_Recipes_has_Ingredients_Ingredients1_idx` (`Ingredients_ID` ASC) VISIBLE,
  INDEX `fk_Recipes_has_Ingredients_Recipes_idx` (`Recipes_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Recipes_has_Ingredients_Recipes`
    FOREIGN KEY (`Recipes_ID`)
    REFERENCES `Recipes`.`Recipes` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Recipes_has_Ingredients_Ingredients1`
    FOREIGN KEY (`Ingredients_ID`)
    REFERENCES `Recipes`.`Ingredients` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Recipes`.`Type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Recipes`.`Type` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Recipes`.`Recipes_has_Type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Recipes`.`Recipes_has_Type` (
  `Recipes_ID` INT NOT NULL,
  `Type_ID` INT NOT NULL,
  PRIMARY KEY (`Recipes_ID`, `Type_ID`),
  INDEX `fk_Recipes_has_Type_Type1_idx` (`Type_ID` ASC) VISIBLE,
  INDEX `fk_Recipes_has_Type_Recipes1_idx` (`Recipes_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Recipes_has_Type_Recipes1`
    FOREIGN KEY (`Recipes_ID`)
    REFERENCES `Recipes`.`Recipes` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Recipes_has_Type_Type1`
    FOREIGN KEY (`Type_ID`)
    REFERENCES `Recipes`.`Type` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
