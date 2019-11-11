# CSGOcase-simulation
练习作，没有实际作用
J2EE大作业
本次使用MVC和mysql，是相当适合javaweb初学者的一次项目。目前前端设计并未完成。注意mysqlconnec的版本。

create database CSGOCase;
use CSGOCase;
show tables;

create table product(
CSID int,
PTID int,
PTNAME varchar(25),
RAGE int,
WearRAGE int,
Probability double
);
create table caseNUm1(
CSID int,
NAME varchar(25)
);
create table user(
userid long,
username varchar(25),
password varchar(25),
isVip boolean
);
create table history(
userid long,
caseid int,
PTID int
);
