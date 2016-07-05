
----------------------------------------------------------------------
--
-- Table structure for table `NxEmployee`
--

DROP TABLE IF EXISTS `NxEmployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NxEmployee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `realname` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `firstName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `degree` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL,
  `school` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `visible` tinyint(1) NOT NULL default 1,
  `createDate` datetime default CURRENT_TIMESTAMP,
  `modifyDate` datetime,
  `obseleteDate` datetime,
  `department_id` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3971CAB88D963580` (`department_id`),
  KEY `FK3971CAB82F37FF2D` (`image_id`),
  CONSTRAINT `FK3971CAB82F37FF2D` FOREIGN KEY (`image_id`) REFERENCES `NxImageFile` (`id`),
  CONSTRAINT `FK3971CAB88D963580` FOREIGN KEY (`department_id`) REFERENCES `NxDepartment` (`departmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



drop table `NX_MENU`;
CREATE TABLE `NX_MENU` (
`UID` varchar(30 ) COLLATE utf8_bin NOT NULL ,
`FRAME_CODE` varchar(30 ) COLLATE utf8_bin NOT NULL ,
`REF_URL` varchar(500 ) COLLATE utf8_bin  NULL ,
`FUNCTION` varchar(10 ) COLLATE utf8_bin  NULL  DEFAULT 'N'   ,
`FRAME_HEIGHT` varchar(30 ) COLLATE utf8_bin  NULL ,
`NAME` varchar(200 ) COLLATE utf8_bin  NULL ,
`NXDEPTID` varchar(512 )  COLLATE utf8_bin  NULL ,
`NXROLEID` varchar(512 )  COLLATE utf8_bin  NULL ,
`NXUSERID` varchar(512 )  COLLATE utf8_bin  NULL ,
`STATUS` varchar(30 ) DEFAULT 'P'   COLLATE utf8_bin  NULL ,
`CREATION_DATE` datetime,
`MODIFY_DATE` datetime,
`DELETE_DATE` datetime,
`SEQ` int  COLLATE utf8_bin  NULL 
) ;




drop table `NX_MENU`;
CREATE TABLE `NX_MENU` (
`UID` varchar(30 ) COLLATE utf8_bin NOT NULL ,
`FRAME_CODE` varchar(30 ) COLLATE utf8_bin NOT NULL ,
`REF_URL` varchar(500 ) COLLATE utf8_bin  NULL ,
`FUNCTION` varchar(10 ) COLLATE utf8_bin  NULL  DEFAULT 'N'   ,
`FRAME_HEIGHT` varchar(30 ) COLLATE utf8_bin  NULL ,
`NAME` varchar(200 ) COLLATE utf8_bin  NULL ,
`NXDEPTID` varchar(512 )  COLLATE utf8_bin  NULL ,
`NXROLEID` varchar(512 )  COLLATE utf8_bin  NULL ,
`NXUSERID` varchar(512 )  COLLATE utf8_bin  NULL ,
`STATUS` varchar(30 ) DEFAULT 'P'   COLLATE utf8_bin  NULL ,
`CREATION_DATE` datetime,
`MODIFY_DATE` datetime,
`DELETE_DATE` datetime,
`SEQ` int  COLLATE utf8_bin  NULL 
) ;







-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: Rehia
-- ------------------------------------------------------
-- Server version	5.7.9

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `NXSYSMENU`
--

DROP TABLE IF EXISTS `NxSysMenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NxSysMenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hyperlink` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entityclass` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `menu_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `seq` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKA57B7082A960B793` (`parent_ID`),
  CONSTRAINT `FKA57B7082A960B793` FOREIGN KEY (`parent_ID`) REFERENCES `NXSYSMENU` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NXUSER`
--

DROP TABLE IF EXISTS `NXUSER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NXUSER` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sso_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `state` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sso_id` (`sso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NXUSERPROFILE`
--

DROP TABLE IF EXISTS `NXUSERPROFILE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NXUSERPROFILE` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NXUSERPROFILEREL`
--

DROP TABLE IF EXISTS `NXUSERPROFILEREL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NXUSERPROFILEREL` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`user_profile_id`),
  KEY `FK_USER_PROFILE` (`user_profile_id`),
  CONSTRAINT `FK_NXUSER` FOREIGN KEY (`user_id`) REFERENCES `NXUSER` (`id`),
  CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `NXUSERPROFILE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NxDepartment`
--

DROP TABLE IF EXISTS `NxDepartment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NxDepartment` (
  `departmentid` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `NxGroup`
--

DROP TABLE IF EXISTS `NxGroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NxGroup` (
  `id` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `creator` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `deleteFlag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entityId` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `obseleteDate` datetime DEFAULT NULL,
  `remarks` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `site` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NxGroupPrivileges`
--

DROP TABLE IF EXISTS `NxGroupPrivileges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NxGroupPrivileges` (
  `group_id` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `module` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `privilege` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`group_id`,`module`,`privilege`),
  KEY `FKF8043C779D681D19` (`module`,`privilege`),
  KEY `FKF8043C77765D772F` (`group_id`),
  CONSTRAINT `FKF8043C77765D772F` FOREIGN KEY (`group_id`) REFERENCES `NxPrivilegeGroup` (`groupid`),
  CONSTRAINT `FKF8043C779D681D19` FOREIGN KEY (`module`, `privilege`) REFERENCES `NxSystemPrivilege` (`module`, `privilege`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NxGroupRel`
--

DROP TABLE IF EXISTS `NxGroupRel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NxGroupRel` (
  `username` int(11) NOT NULL,
  `group_id` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`username`,`group_id`),
  KEY `FK107D29A4765D772F` (`group_id`),
  KEY `FK107D29A41095CF12` (`username`),
  CONSTRAINT `FK107D29A41095CF12` FOREIGN KEY (`username`) REFERENCES `NxEmployee` (`id`),
  CONSTRAINT `FK107D29A4765D772F` FOREIGN KEY (`group_id`) REFERENCES `NxPrivilegeGroup` (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NxImageFile`
--

DROP TABLE IF EXISTS `NxImageFile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NxImageFile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `filename` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `content` longblob,
  `content_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NxPrivilegeGroup`
--

DROP TABLE IF EXISTS `NxPrivilegeGroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NxPrivilegeGroup` (
  `groupid` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NxSystemPrivilege`
--

DROP TABLE IF EXISTS `NxSystemPrivilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NxSystemPrivilege` (
  `module` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `privilege` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`module`,`privilege`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role_resource`
--

DROP TABLE IF EXISTS `role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_resource` (
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`resource_id`),
  KEY `FKAEE599B751827FA1` (`role_id`),
  KEY `FKAEE599B7EFD18D21` (`resource_id`),
  CONSTRAINT `FKAEE599B751827FA1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKAEE599B7EFD18D21` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `disabled` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK143BF46AF6AD4381` (`user_id`),
  KEY `FK143BF46A51827FA1` (`role_id`),
  CONSTRAINT `FK143BF46A51827FA1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK143BF46AF6AD4381` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-05  1:07:52
