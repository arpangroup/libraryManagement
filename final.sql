-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema librarynewprojectcosc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema librarynewprojectcosc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `librarynewprojectcosc` DEFAULT CHARACTER SET latin1 ;
USE `librarynewprojectcosc` ;

-- -----------------------------------------------------
-- Table `librarynewprojectcosc`.`book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarynewprojectcosc`.`book` ;

CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`book` (
  `bookId` VARCHAR(8) NOT NULL,
  `bookName` VARCHAR(45) NOT NULL,
  `isbn` VARCHAR(12) NOT NULL,
  `bookAuthor` VARCHAR(45) NOT NULL,
  `bookPublisher` VARCHAR(45) NOT NULL,
  `bookNumber` INT(11) NOT NULL,
  `Language_languageId` INT(11) NOT NULL,
  PRIMARY KEY (`bookId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `librarynewprojectcosc`.`bookcopy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarynewprojectcosc`.`bookcopy` ;

CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`bookcopy` (
  `bookcopyId` INT(11) NOT NULL AUTO_INCREMENT,
  `bookcopyName` VARCHAR(45) NOT NULL,
  `bookcopyStatus` TINYINT(1) NULL DEFAULT NULL,
  `Book_bookId` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`bookcopyId`),
  INDEX `fk_BookCopy_Book1_idx` (`Book_bookId` ASC),
  CONSTRAINT `fk_BookCopy_Book1`
    FOREIGN KEY (`Book_bookId`)
    REFERENCES `librarynewprojectcosc`.`book` (`bookId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `librarynewprojectcosc`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarynewprojectcosc`.`employee` ;

CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`employee` (
  `empId` INT(11) NOT NULL,
  `empName` VARCHAR(45) NOT NULL,
  `empContactNo` VARCHAR(11) NOT NULL,
  `empAddress` VARCHAR(45) NOT NULL,
  `empUsername` VARCHAR(45) NOT NULL,
  `empPassword` VARCHAR(45) NOT NULL,
  `empAccess` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`empId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `librarynewprojectcosc`.`member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarynewprojectcosc`.`member` ;

CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`member` (
  `memberId` INT(11) NOT NULL,
  `memberName` VARCHAR(45) NOT NULL,
  `memberContactNo` INT(11) NULL DEFAULT NULL,
  `memberAddress` VARCHAR(45) NOT NULL,
  `memberStatus` TINYINT(1) NOT NULL,
  PRIMARY KEY (`memberId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `librarynewprojectcosc`.`borrow`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarynewprojectcosc`.`borrow` ;

CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`borrow` (
  `borrowId` INT(11) NOT NULL AUTO_INCREMENT,
  `borrowDate` DATETIME NOT NULL,
  `borrowExpDate` DATETIME NOT NULL,
  `Member_memberId` INT(11) NOT NULL,
  `Employee_empId` INT(11) NOT NULL,
  `bookcopy_bookcopyId` INT(11) NOT NULL,
  PRIMARY KEY (`borrowId`),
  INDEX `fk_Borrow_Member1_idx` (`Member_memberId` ASC),
  INDEX `fk_Borrow_Employee1_idx` (`Employee_empId` ASC),
  INDEX `fk_borrow_bookcopy1_idx` (`bookcopy_bookcopyId` ASC),
  CONSTRAINT `fk_Borrow_Employee1`
    FOREIGN KEY (`Employee_empId`)
    REFERENCES `librarynewprojectcosc`.`employee` (`empId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Borrow_Member1`
    FOREIGN KEY (`Member_memberId`)
    REFERENCES `librarynewprojectcosc`.`member` (`memberId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_borrow_bookcopy1`
    FOREIGN KEY (`bookcopy_bookcopyId`)
    REFERENCES `librarynewprojectcosc`.`bookcopy` (`bookcopyId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `librarynewprojectcosc`.`returnbook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarynewprojectcosc`.`returnbook` ;

CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`returnbook` (
  `returnBookId` INT(11) NOT NULL AUTO_INCREMENT,
  `returnBookDatel` DATETIME NOT NULL,
  `Member_memberId` INT(11) NOT NULL,
  `Employee_empId` INT(11) NOT NULL,
  `bookcopy_bookcopyId` INT(11) NOT NULL,
  PRIMARY KEY (`returnBookId`),
  INDEX `fk_ReturnBook_Member1_idx` (`Member_memberId` ASC),
  INDEX `fk_ReturnBook_Employee1_idx` (`Employee_empId` ASC),
  INDEX `fk_returnbook_bookcopy1_idx` (`bookcopy_bookcopyId` ASC),
  CONSTRAINT `fk_ReturnBook_Employee1`
    FOREIGN KEY (`Employee_empId`)
    REFERENCES `librarynewprojectcosc`.`employee` (`empId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ReturnBook_Member1`
    FOREIGN KEY (`Member_memberId`)
    REFERENCES `librarynewprojectcosc`.`member` (`memberId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_returnbook_bookcopy1`
    FOREIGN KEY (`bookcopy_bookcopyId`)
    REFERENCES `librarynewprojectcosc`.`bookcopy` (`bookcopyId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `librarynewprojectcosc`.`fine`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarynewprojectcosc`.`fine` ;

CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`fine` (
  `fineId` INT(11) NOT NULL AUTO_INCREMENT,
  `overdueDays` INT(11) NOT NULL,
  `overdueFine` DOUBLE NOT NULL,
  `Member_memberId` INT(11) NOT NULL,
  `employee_empId` INT(11) NOT NULL,
  `returnbook_returnBookId` INT(11) NOT NULL,
  PRIMARY KEY (`fineId`),
  INDEX `fk_Fine_Member1_idx` (`Member_memberId` ASC),
  INDEX `fk_fine_employee1_idx` (`employee_empId` ASC),
  INDEX `fk_fine_returnbook1_idx` (`returnbook_returnBookId` ASC),
  CONSTRAINT `fk_Fine_Member1`
    FOREIGN KEY (`Member_memberId`)
    REFERENCES `librarynewprojectcosc`.`member` (`memberId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fine_employee1`
    FOREIGN KEY (`employee_empId`)
    REFERENCES `librarynewprojectcosc`.`employee` (`empId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fine_returnbook1`
    FOREIGN KEY (`returnbook_returnBookId`)
    REFERENCES `librarynewprojectcosc`.`returnbook` (`returnBookId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `librarynewprojectcosc`.`guaranter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarynewprojectcosc`.`guaranter` ;

CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`guaranter` (
  `guaranterId` INT(11) NOT NULL,
  `guaranterName` VARCHAR(45) NOT NULL,
  `guaranterContactNo` INT(11) NULL DEFAULT NULL,
  `guaranterEmail` VARCHAR(20) NULL DEFAULT NULL,
  `guaranterAddress` VARCHAR(45) NOT NULL,
  `member_memberId` INT(11) NOT NULL,
  PRIMARY KEY (`guaranterId`),
  INDEX `fk_guaranter_member1_idx` (`member_memberId` ASC),
  CONSTRAINT `fk_guaranter_member1`
    FOREIGN KEY (`member_memberId`)
    REFERENCES `librarynewprojectcosc`.`member` (`memberId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `librarynewprojectcosc`.`employee`
-- -----------------------------------------------------
START TRANSACTION;
USE `librarynewprojectcosc`;
INSERT INTO `librarynewprojectcosc`.`employee` (`empId`, `empName`, `empContactNo`, `empAddress`, `empUsername`, `empPassword`, `empAccess`) VALUES (111, 'wishwa', '123', 'Mora', 'admin', 'admin', 'admin');
INSERT INTO `librarynewprojectcosc`.`employee` (`empId`, `empName`, `empContactNo`, `empAddress`, `empUsername`, `empPassword`, `empAccess`) VALUES (222, 'prabodha', '456', 'Panadura', 'q', 'q', 'user');

COMMIT;

