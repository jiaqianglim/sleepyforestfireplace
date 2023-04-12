-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema miniproject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema miniproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `miniproject` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `miniproject` ;

-- -----------------------------------------------------
-- Table `miniproject`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`category` (
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`country` (
  `name` VARCHAR(45) NOT NULL,
  `ISO` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `ISO` (`ISO` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`country_city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`country_city` (
  `name` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `city_country_idx` (`country` ASC) VISIBLE,
  CONSTRAINT `city_country`
    FOREIGN KEY (`country`)
    REFERENCES `miniproject`.`country` (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`managing_organisation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`managing_organisation` (
  `name` VARCHAR(45) NOT NULL,
  `organisation_email` VARCHAR(45) NULL DEFAULT NULL,
  `contact_person` VARCHAR(45) NULL DEFAULT NULL,
  `contact_email` VARCHAR(45) NULL DEFAULT NULL,
  `contact_number` VARCHAR(45) NULL DEFAULT NULL,
  `office_address` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`event_campaign`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`event_campaign` (
  `name` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `organisation` VARCHAR(45) NOT NULL,
  `date_start` DATE NOT NULL,
  `date_end` DATE NOT NULL,
  `description` LONGTEXT NOT NULL,
  `manager` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `contact` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`name`),
  INDEX `managing_organisation_idx` (`organisation` ASC) VISIBLE,
  INDEX `campaign_category_idx` (`category` ASC) VISIBLE,
  CONSTRAINT `campaign_category`
    FOREIGN KEY (`category`)
    REFERENCES `miniproject`.`category` (`name`),
  CONSTRAINT `managing_organisation`
    FOREIGN KEY (`organisation`)
    REFERENCES `miniproject`.`managing_organisation` (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`group` (
  `name` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `manager` VARCHAR(45) NULL DEFAULT NULL,
  `contact_email` VARCHAR(45) NULL DEFAULT NULL,
  `contact_number` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `imageurl` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`name`),
  INDEX `group_category_idx` (`category` ASC) VISIBLE,
  CONSTRAINT `group_category`
    FOREIGN KEY (`category`)
    REFERENCES `miniproject`.`category` (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`local_area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`local_area` (
  `name` VARCHAR(45) NOT NULL,
  `country_iso` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `coordinates_lat` VARCHAR(45) NOT NULL,
  `coordinates_long` VARCHAR(45) NOT NULL,
  `managing_organisation` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `managing_organisation_name` (`managing_organisation` ASC) VISIBLE,
  INDEX `area_country_idx` (`country_iso` ASC) VISIBLE,
  INDEX `county_city_idx` (`city` ASC) VISIBLE,
  CONSTRAINT `area_country`
    FOREIGN KEY (`country_iso`)
    REFERENCES `miniproject`.`country` (`name`),
  CONSTRAINT `county_city`
    FOREIGN KEY (`city`)
    REFERENCES `miniproject`.`country_city` (`name`),
  CONSTRAINT `managing_organisation_name`
    FOREIGN KEY (`name`)
    REFERENCES `miniproject`.`managing_organisation` (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`local_area_venues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`local_area_venues` (
  `name` VARCHAR(45) NOT NULL,
  `local_area` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `venue_manager` VARCHAR(45) NULL DEFAULT NULL,
  `venue_contact_email` VARCHAR(45) NULL DEFAULT NULL,
  `venue_contact_number` VARCHAR(45) NULL DEFAULT NULL,
  `commercial_organisation_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`name`),
  CONSTRAINT `local_area`
    FOREIGN KEY (`name`)
    REFERENCES `miniproject`.`local_area` (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`event` (
  `name` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `campaign` VARCHAR(45) NOT NULL,
  `date_start` DATE NOT NULL,
  `date_end` DATE NOT NULL,
  `event_organisation` VARCHAR(45) NULL DEFAULT NULL,
  `event_manager` VARCHAR(45) NULL DEFAULT NULL,
  `event_email` VARCHAR(45) NULL DEFAULT NULL,
  `event_contact_number` VARCHAR(45) NULL DEFAULT NULL,
  `event_description` LONGTEXT NULL DEFAULT NULL,
  `event_details` LONGTEXT NULL DEFAULT NULL,
  `local_area_venue` VARCHAR(45) NULL DEFAULT NULL,
  `group_colab` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`name`),
  INDEX `local_area_venue_idx` (`name` ASC, `local_area_venue` ASC) VISIBLE,
  INDEX `event_venue_idx` (`local_area_venue` ASC) VISIBLE,
  INDEX `event_campaign_idx` (`campaign` ASC) VISIBLE,
  INDEX `event_managing_organisation_idx` (`event_organisation` ASC) VISIBLE,
  INDEX `event_category_idx` (`category` ASC) VISIBLE,
  CONSTRAINT `event_campaign`
    FOREIGN KEY (`campaign`)
    REFERENCES `miniproject`.`event_campaign` (`name`),
  CONSTRAINT `event_category`
    FOREIGN KEY (`category`)
    REFERENCES `miniproject`.`category` (`name`),
  CONSTRAINT `event_group_colab`
    FOREIGN KEY (`name`)
    REFERENCES `miniproject`.`group` (`name`),
  CONSTRAINT `event_managing_organisation`
    FOREIGN KEY (`event_organisation`)
    REFERENCES `miniproject`.`managing_organisation` (`name`),
  CONSTRAINT `event_venue`
    FOREIGN KEY (`local_area_venue`)
    REFERENCES `miniproject`.`local_area_venues` (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`topic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`topic` (
  `name` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `description` LONGTEXT NULL DEFAULT NULL,
  `geo_interest` VARCHAR(45) NULL DEFAULT NULL,
  `image_url` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`name`),
  INDEX `topic_country_idx` (`geo_interest` ASC) VISIBLE,
  INDEX `topic_category_idx` (`category` ASC) VISIBLE,
  CONSTRAINT `topic_category`
    FOREIGN KEY (`category`)
    REFERENCES `miniproject`.`category` (`name`),
  CONSTRAINT `topic_country`
    FOREIGN KEY (`geo_interest`)
    REFERENCES `miniproject`.`country` (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`topic_sub`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`topic_sub` (
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `topic_main` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `topic_category_idx` (`category` ASC) VISIBLE,
  CONSTRAINT `topic_main`
    FOREIGN KEY (`name`)
    REFERENCES `miniproject`.`topic` (`name`),
  CONSTRAINT `topic_sub_category`
    FOREIGN KEY (`category`)
    REFERENCES `miniproject`.`category` (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
