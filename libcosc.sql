-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema 
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema librarynewprojectcosc
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `librarynewprojectcosc` ;

-- -----------------------------------------------------
-- Schema librarynewprojectcosc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `librarynewprojectcosc` DEFAULT CHARACTER SET latin1 ;
USE `librarynewprojectcosc` ;

-- -----------------------------------------------------
-- Table `librarynewprojectcosc`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`book` (
  `bookId` VARCHAR(8) NOT NULL,
  `bookName` VARCHAR(45) NOT NULL,
  `isbn` VARCHAR(12) NOT NULL,
  `bookAuthor` VARCHAR(45) NOT NULL,
  `bookPublisher` VARCHAR(45) NOT NULL,
  `bookNumber` INT NOT NULL,
  `bookAddDate` DATETIME NOT NULL,
  `Language_languageId` INT NOT NULL,
  PRIMARY KEY (`bookId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `librarynewprojectcosc`.`bookcopy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`bookcopy` (
  `bookcopyId` INT(11) NOT NULL AUTO_INCREMENT,
  `bookcopyName` VARCHAR(45) NOT NULL,
  `Book_bookId` VARCHAR(8) NOT NULL,
  `bookcopyStatus` TINYINT(1) NULL,
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
-- Table `librarynewprojectcosc`.`guaranter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`guaranter` (
  `guaranterId` VARCHAR(10) NOT NULL,
  `guaranterName` VARCHAR(45) NOT NULL,
  `guaranterContactNo` INT(11) NULL DEFAULT NULL,
  `guaranterEmail` VARCHAR(20) NULL DEFAULT NULL,
  `guaranterAddress` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`guaranterId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `librarynewprojectcosc`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`member` (
  `memberId` VARCHAR(10) NOT NULL,
  `memberName` VARCHAR(45) NOT NULL,
  `memberContactNo` INT(11) NULL DEFAULT NULL,
  `memberAddress` VARCHAR(45) NOT NULL,
  `memberStatus` TINYINT(1) NOT NULL,
  `Membercol` VARCHAR(45) NULL DEFAULT NULL,
  `guaranter_guaranterId` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`memberId`),
  INDEX `fk_member_guaranter1_idx` (`guaranter_guaranterId` ASC),
  CONSTRAINT `fk_member_guaranter1`
    FOREIGN KEY (`guaranter_guaranterId`)
    REFERENCES `librarynewprojectcosc`.`guaranter` (`guaranterId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `librarynewprojectcosc`.`borrow`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`borrow` (
  `borrowId` INT(11) NOT NULL AUTO_INCREMENT,
  `borrowDate` DATETIME NOT NULL,
  `borrowExpDate` DATETIME NOT NULL,
  `Member_memberId` VARCHAR(10) NOT NULL,
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
CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`returnbook` (
  `returnBookId` INT(11) NOT NULL AUTO_INCREMENT,
  `returnBookDatel` DATETIME NOT NULL,
  `Member_memberId` VARCHAR(10) NOT NULL,
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
CREATE TABLE IF NOT EXISTS `librarynewprojectcosc`.`fine` (
  `fineId` INT(11) NOT NULL AUTO_INCREMENT,
  `overdueDays` INT(11) NOT NULL,
  `overdueFine` DOUBLE NOT NULL,
  `Member_memberId` VARCHAR(10) NOT NULL,
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `librarynewprojectcosc`.`employee`
-- -----------------------------------------------------
START TRANSACTION;
USE `librarynewprojectcosc`;
INSERT INTO `librarynewprojectcosc`.`employee` (`empId`, `empName`, `empContactNo`, `empAddress`, `empUsername`, `empPassword`, `empAccess`) VALUES (1, 'admin', '11', 'qq', '123', '123', 'admin');
INSERT INTO `librarynewprojectcosc`.`employee` (`empId`, `empName`, `empContactNo`, `empAddress`, `empUsername`, `empPassword`, `empAccess`) VALUES (2, 'user', '22', 'ww', 'q', 'q', 'user');

COMMIT;

