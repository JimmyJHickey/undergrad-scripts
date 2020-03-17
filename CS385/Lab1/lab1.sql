create database if not exists `lab1`;
use `lab1`;

Drop table if exists `timeslot`;
create table `timeslot`(
	`time_slot_id` varchar(4) NOT NULL,
	`day` varchar(1) NOT NULL,
	`start_time` time NOT NULL,
	`end_time` time DEFAULT NULL,
	primary key (`time_slot_id`,`day`,`start_time`)
); 

Drop table if exists `instructor`;
create table `instructor`(
	`ID` char(5),
    `name` varchar(20) not null,
    `dept_name` varchar(20),
    `salary` numeric(8,2),
    primary key (`ID`)
    #foreign key (`dept_name`) references `department`
    );

Lock tables `timeslot` write;
Insert into `timeslot` Values ('A', 'F', '08:00:00', '08:50:00'),('A', 'M', '08:00:00', '08:50:00');

Lock tables `instructor` write;
Insert into `instructor` values ('10211', 'Smith', 'Biology', 66000);
Insert into `instructor` values ('10212', 'Paul Boelter', 'Biology', 66000); #bad!

Unlock tables;