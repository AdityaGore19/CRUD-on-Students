use postman for testing the CRUD operations (GET, POST, PUT, DELETE) on students database.

use the following sql script in your mysql workbench:

CREATE DATABASE IF NOT EXISTS `student_directory`;
USE `student_directory`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `standard` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `student`
--

INSERT INTO `student` VALUES 
    (1,'John','Doe','10th'),
    (2,'Alice','Johnson','11th'),
    (3,'Bob','Smith','9th'),
    (4,'Emily','Williams','12th'),
    (5,'Daniel','Miller','10th'),
    (6,'Sophia','Brown','11th'),
    (7,'Ethan','Jones','9th'),
    (8,'Olivia','Davis','12th');

in postman use the select GET/POST/PUT/DELETE / students/ {studentId} to get respective results and confirm the changes in the database

