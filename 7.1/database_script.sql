/* 
Drop previous version of teh database & make a new one to use
*/
DROP DATABASE IF EXISTS currency;
CREATE DATABASE currency;
USE currency;
/*
Make currency table
*/
CREATE TABLE CURRENCIES (
	id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(50) NOT NULL,
   abbr VARCHAR(50) NOT NULL,
   exr DECIMAL(10,2) NOT NULL,
   PRIMARY KEY (id)
);
/*
Insert into table
*/
INSERT INTO CURRENCIES (name, abbr, exr) VALUES
	('US Dollar','USD', 1.00),
	('Euro','EUR', 0.85),
   ('British Pound','GBP', 0.74),
   ('Canadian Dollar','CAD', 1.39),
   ('Japanese Yen','JPY', 148.58),
   ('Austraian Dollar','AUD', 1.52),
   ('Swiss Franc','CHF', 0.79),
   ('Iranian Rial','IRR', 42052.68);
/*
Drop and crate appuser
*/
DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';
/*
Grants perms
*/
GRANT SELECT ON currency.CURRENCIES TO 'appuser'@'localhost';

