DROP TABLE IF EXISTS EMPLOYEE;

CREATE TABLE EMPLOYEE(
    id serial primary key,
    firstName varchar(25) not null,
    lastName  varchar(25) not null,
    gender varchar(10) not null,
    address varchar(255) not null,
    dob date not null
);

insert into employee (firstName,lastName,gender,address,dob) values ('John','Smith','MALE','AUSTRALIA','1986-10-20');
insert into employee (firstName,lastName,gender,address,dob) values ('Jim','Smith','MALE','UK','1986-11-20');
insert into employee (firstName,lastName,gender,address,dob) values ('Andy','Smith','MALE','USA','1976-09-20');
insert into employee (firstName,lastName,gender,address,dob) values ('Paul','John','MALE','AUSTRIA','1988-10-20');
insert into employee (firstName,lastName,gender,address,dob) values ('Edward','Jacob','MALE','INDIA','1989-11-20');
insert into employee (firstName,lastName,gender,address,dob) values ('Kyle','Mills','MALE','SINGAPORE','1986-10-10');
insert into employee (firstName,lastName,gender,address,dob) values ('Evan','Pete','MALE','INDONESIA','1996-07-20');