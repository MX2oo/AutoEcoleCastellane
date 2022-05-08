drop database if exists auto_ecole_castellane; 
create database auto_ecole_castellane; 
use auto_ecole_castellane; 

create table candidat (
	idcandidat int(3) not null auto_increment, 
	nom varchar(50) not null, 
	prenom varchar(50) not null,
	adresse varchar(100) ,
	forfait int(7), 
	bip varchar(20), 
	primary key (idcandidat)
); 

create table voiture (
	idvoiture int(3) not null auto_increment, 
	designation varchar(50) not null, 
	constructeur varchar(50) not null,
	nbplaces int(3), 
	primary key (idvoiture)
); 


Create table if not exists cours (
	idcours int(3) not null auto_increment,
	designation varchar(50) not null,
	datecours date,
	heurecours time,
	idcandidat1 int(3) not null,
	idcandidat2 int(3) not null,
	idvoiture int(3) not null,
	primary key (idcours),
	foreign key (idcandidat1) references candidat (idcandidat)
	on update cascade
	on delete cascade,
	foreign key (idcandidat2) references candidat (idcandidat)
	on update cascade
	on delete cascade,
	foreign key (idvoiture) references voiture (idvoiture)
	on update cascade
	on delete cascade
);

Create or replace view pav as (
	select c.nom, c.prenom, v.designation as voiture, r.designation as cours, r.datecours, r.heurecours
	from candidat c, voiture v, cours r
	where c.idcandidat = r.idcandidat1
	and v.idvoiture = r.idcours
);
	
create table user (
	iduser int(3) not null auto_increment, 
	nom varchar(50), 
	prenom varchar(50), 
	email varchar(50), 
	mdp varchar(255), 
	role enum("admin", "user"),
	primary key(iduser)
);

insert into user values (null, "Maxime", "Kerbrat", "maxime@gmail.com", 
"123", "admin"), 
(null, "Valerie", "Dupond", "valerie@gmail.com", 
"456", "user");

 























