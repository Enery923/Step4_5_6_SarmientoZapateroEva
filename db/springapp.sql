CREATE DATABASE springapp;

GRANT ALL ON springapp.* TO springapp2user@'%' IDENTIFIED BY 'pspringapp2user';
GRANT ALL ON springapp.* TO springapp2user@localhost IDENTIFIED BY 'pspringapp2user';

USE springapp;

CREATE TABLE investmentFunds (
	id char(30) PRIMARY KEY,
	amount INTEGER ,
	profitability DECIMAL(5,2),
	date DATE
);