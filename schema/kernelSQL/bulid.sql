
drop table if exists Rehia.NXUser;

create table Rehia.NXUser (
	id varchar(60) not null,
	entityId varchar(255),   
	userId varchar(50) not null,
	account varchar(50) not null,
	pwd varchar(255),
	firstName varchar(100),
	lastName varchar(100),
	remarks varchar(500),
    title varchar(255),
    mail varchar(100) not null,
    mobile varchar(255),
    tel varchar(255),
    site int default 'N',
    status varchar(1) default 'P',
    createDate datetime default CURRENT_TIMESTAMP,
    modifyDate datetime,
    obseleteDate datetime,
	creator varchar(255),
    deleteFlag varchar(255) not null default 'N',
    primary key (id)
    );




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