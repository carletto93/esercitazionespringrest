CREATE TABLE contatti(id integer auto_increment,
	nome varchar(20) not null,
	cognome varchar(30) not null,
 email varchar(100) not null unique,
 	datadinascita date not null, primary key(id));