DROP DATABASE IF EXISTS test;

CREATE DATABASE test;

USE test;

CREATE TABLE emp(
    id int PRIMARY KEY auto_increment,
    name varchar(50),
    salary decimal(10, 2),
    age int,
    email varchar(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO emp VALUES(null, "tom", 6000, 20, "tom@163.com");