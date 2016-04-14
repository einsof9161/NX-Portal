SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE NXENTITYMDOEL;
DROP TABLE NXENTITYMASTER;
DROP TABLE NXLOCALE;


alter table Rehia.NXENTITYMDOEL ;
drop  foreign key FK1E739E32FF78A539;
alter table Rehia.NXLOCALE ;
drop foreign key FK5BE90CA4FF78A539;
drop table if exists Rehia.NXENTITYMASTER;
drop table if exists Rehia.NXENTITYMDOEL;
drop table if exists Rehia.NXLOCALE;


/* Create Tables */
create table NXENTITYMASTER (
        entityId varchar(35) not null,
        name varchar(128) not null,
        description varchar(255),
        entityKey varchar(45) not null,
        entityGroupKey varchar(255),       
        masterEntity boolean not null,
        deleted boolean not null,
        disabled boolean not null,
        extendsEntity boolean not null,
        subEntity boolean not null,
        subIndex integer not null,
        createdDate datetime,
        modifiedDate datetime,
        releasedDate datetime,
        primary key (entityId)
);

create table NXENTITYMDOEL (
        entityModelId varchar(100) not null,
        modelName varchar(128) not null,
        description varchar(255),
        modelIndex integer not null,
        entityMasterId varchar(35),
        entityGroupKey varchar(255),
        isDeleted boolean not null,
        isDisabled boolean not null,
        createdDate datetime,
        releasedDate datetime,
        modifiedDate datetime,
        primary key (id)
);

create table NXLOCALE (
        nxLocaleId varchar(255) not null,
        localeType varchar(255),
        localeDisplayName varchar(255),
        entityMasterId varchar(35),
        createDate varchar(255),
        primary key (nxLocaleId)
)





