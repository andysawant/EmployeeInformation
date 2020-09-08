DROP TABLE IF EXISTS EMPLOYEE;

CREATE TABLE EMPLOYEE(
    id serial primary key,
    firstName varchar(25) not null,
    lastName  varchar(25) not null,
    gender varchar(10) not null,
    address varchar(255) not null,
    dob date not null
);