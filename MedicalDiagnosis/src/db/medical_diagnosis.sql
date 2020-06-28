/*
Navicat MySQL Data Transfer

Source Server         : toma
Source Server Version : 100410
Source Host           : localhost:3306
Source Database       : medical_diagnosis

Target Server Type    : MYSQL
Target Server Version : 100410
File Encoding         : 65001

Date: 2020-06-28 23:20:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for diagnosis
-- ----------------------------
DROP TABLE IF EXISTS `diagnosis`;
CREATE TABLE `diagnosis` (
  `diagnosisID` int(11) NOT NULL AUTO_INCREMENT,
  `patientID` int(11) NOT NULL,
  `symptomDiseaseID` int(11) NOT NULL,
  PRIMARY KEY (`diagnosisID`),
  KEY `fk_symptomDisease` (`symptomDiseaseID`),
  KEY `fk_patient` (`patientID`),
  CONSTRAINT `fk_patient` FOREIGN KEY (`patientID`) REFERENCES `patients` (`patientID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_symptomDisease` FOREIGN KEY (`symptomDiseaseID`) REFERENCES `symptoms_diseases` (`symptomDiseaseID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diagnosis
-- ----------------------------
INSERT INTO `diagnosis` VALUES ('1', '1', '1');
INSERT INTO `diagnosis` VALUES ('2', '3', '2');
INSERT INTO `diagnosis` VALUES ('3', '4', '5');
INSERT INTO `diagnosis` VALUES ('4', '2', '3');
INSERT INTO `diagnosis` VALUES ('5', '3', '4');

-- ----------------------------
-- Table structure for diseases
-- ----------------------------
DROP TABLE IF EXISTS `diseases`;
CREATE TABLE `diseases` (
  `diseaseID` int(11) NOT NULL AUTO_INCREMENT,
  `diseaseName` varchar(30) NOT NULL,
  `diseaseType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`diseaseID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diseases
-- ----------------------------
INSERT INTO `diseases` VALUES ('1', 'Prehlada', 'Gripno');
INSERT INTO `diseases` VALUES ('2', 'Upala pluca', 'Plucno');
INSERT INTO `diseases` VALUES ('3', 'Stomacni virus', 'Stomacno');

-- ----------------------------
-- Table structure for medicaments
-- ----------------------------
DROP TABLE IF EXISTS `medicaments`;
CREATE TABLE `medicaments` (
  `medicamentID` int(11) NOT NULL AUTO_INCREMENT,
  `medicamentName` varchar(40) NOT NULL,
  `medicamentDescription` varchar(255) NOT NULL,
  `dose` varchar(20) NOT NULL,
  `restriction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`medicamentID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicaments
-- ----------------------------
INSERT INTO `medicaments` VALUES ('1', 'Kafetin', 'Deluje protiv bola u glavi', '1*250mg na dan', 'Ne mesati sa alkoholom');
INSERT INTO `medicaments` VALUES ('2', 'Probiotik', 'Deluje protiv bola u stomaku', '3*kapsula na dan', 'Ne konzumirati na prazan stomak');
INSERT INTO `medicaments` VALUES ('3', 'Strepsils', 'Ublazava bol u grlu', '2 tablete na dan', 'Ne kozumirati na prazan stomak');
INSERT INTO `medicaments` VALUES ('4', 'Caj od zalfije', 'Za upalu grla, groznicu, stomacne tegobe', '4-5 solji na dan', 'Ne konzumirati pred spavanje');
INSERT INTO `medicaments` VALUES ('5', 'Hemomicin', 'Za virusne infkecije', '1*500mg na dan*6', 'Ne konzumirati na prazan stomak i sa alkoholom');

-- ----------------------------
-- Table structure for patients
-- ----------------------------
DROP TABLE IF EXISTS `patients`;
CREATE TABLE `patients` (
  `patientID` int(11) NOT NULL AUTO_INCREMENT,
  `patientName` varchar(20) NOT NULL,
  `patientSurname` varchar(30) NOT NULL,
  `birthDate` date DEFAULT NULL,
  `gender` varchar(1) NOT NULL,
  `weight` double(5,2) NOT NULL,
  `height` double(5,2) NOT NULL,
  PRIMARY KEY (`patientID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patients
-- ----------------------------
INSERT INTO `patients` VALUES ('1', 'Toma', 'Joksimovic', '1997-09-13', 'M', '90.00', '186.00');
INSERT INTO `patients` VALUES ('2', 'Mirko', 'Mirkovic', '1995-10-23', 'M', '84.00', '187.00');
INSERT INTO `patients` VALUES ('3', 'Ana', 'Dinkic', '1999-03-12', 'F', '69.00', '174.00');
INSERT INTO `patients` VALUES ('4', 'Marija', 'Stankovic', '1983-08-30', 'F', '71.00', '180.00');

-- ----------------------------
-- Table structure for symptoms
-- ----------------------------
DROP TABLE IF EXISTS `symptoms`;
CREATE TABLE `symptoms` (
  `symptomID` int(11) NOT NULL AUTO_INCREMENT,
  `symptomName` char(255) NOT NULL,
  `cause` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`symptomID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of symptoms
-- ----------------------------
INSERT INTO `symptoms` VALUES ('1', 'Kijavica', 'Oslabljen imunitet');
INSERT INTO `symptoms` VALUES ('2', 'Bol u glavi', 'Preveliko izlaganje suncu');
INSERT INTO `symptoms` VALUES ('3', 'Bol u grlu', 'Konzumacija hladne hrane i pica');
INSERT INTO `symptoms` VALUES ('4', 'Groznica', 'Virusna infekcija, trovanje hranom');

-- ----------------------------
-- Table structure for symptoms_diseases
-- ----------------------------
DROP TABLE IF EXISTS `symptoms_diseases`;
CREATE TABLE `symptoms_diseases` (
  `symptomDiseaseID` int(11) NOT NULL AUTO_INCREMENT,
  `symptomID` int(11) NOT NULL,
  `diseaseID` int(11) NOT NULL,
  PRIMARY KEY (`symptomDiseaseID`),
  KEY `fk_symptom` (`symptomID`),
  KEY `fk_disease` (`diseaseID`),
  CONSTRAINT `fk_disease` FOREIGN KEY (`diseaseID`) REFERENCES `diseases` (`diseaseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_symptom` FOREIGN KEY (`symptomID`) REFERENCES `symptoms` (`symptomID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of symptoms_diseases
-- ----------------------------
INSERT INTO `symptoms_diseases` VALUES ('1', '1', '1');
INSERT INTO `symptoms_diseases` VALUES ('2', '2', '1');
INSERT INTO `symptoms_diseases` VALUES ('3', '3', '1');
INSERT INTO `symptoms_diseases` VALUES ('4', '4', '2');
INSERT INTO `symptoms_diseases` VALUES ('5', '4', '1');

-- ----------------------------
-- Table structure for therapies
-- ----------------------------
DROP TABLE IF EXISTS `therapies`;
CREATE TABLE `therapies` (
  `therapyID` int(11) NOT NULL AUTO_INCREMENT,
  `therapyType` varchar(50) NOT NULL,
  `therapyName` varchar(40) NOT NULL,
  `therapyStartDate` date DEFAULT NULL,
  `therapyEndDate` date DEFAULT NULL,
  `diagnosisID` int(11) NOT NULL,
  `pharmacyAddr` varchar(50) DEFAULT NULL,
  `examinationDate` datetime DEFAULT NULL,
  `sector` varchar(20) DEFAULT NULL,
  `room` int(5) DEFAULT NULL,
  `bed` int(2) DEFAULT NULL,
  PRIMARY KEY (`therapyID`),
  KEY `fk_diagnosis` (`diagnosisID`),
  CONSTRAINT `fk_diagnosis` FOREIGN KEY (`diagnosisID`) REFERENCES `diagnosis` (`diagnosisID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of therapies
-- ----------------------------
INSERT INTO `therapies` VALUES ('1', 'Home', 'Lecenje prehlade', '2020-06-11', '2020-06-26', '1', 'Masarikova 10', '2020-06-24 15:57:31', '', null, null);
INSERT INTO `therapies` VALUES ('2', 'Hospital', 'Inhalacija', '2020-06-20', '2020-06-29', '5', null, null, '5', '2', '9');

-- ----------------------------
-- Table structure for therapies_medicaments
-- ----------------------------
DROP TABLE IF EXISTS `therapies_medicaments`;
CREATE TABLE `therapies_medicaments` (
  `therapyMedicamentID` int(11) NOT NULL AUTO_INCREMENT,
  `therapyID` int(11) NOT NULL,
  `medicamentID` int(11) NOT NULL,
  PRIMARY KEY (`therapyMedicamentID`),
  KEY `fk_therapy` (`therapyID`),
  KEY `fk_medicament` (`medicamentID`),
  CONSTRAINT `fk_medicament` FOREIGN KEY (`medicamentID`) REFERENCES `medicaments` (`medicamentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_therapy` FOREIGN KEY (`therapyID`) REFERENCES `therapies` (`therapyID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of therapies_medicaments
-- ----------------------------
INSERT INTO `therapies_medicaments` VALUES ('1', '1', '1');
INSERT INTO `therapies_medicaments` VALUES ('2', '2', '5');
