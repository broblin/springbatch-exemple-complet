drop table if exists livre;
drop table if exists auteur;

create table auteur
(
  id int not null auto_increment,
  nom character varying(20),
  prenom character varying(20),
  nationalite character varying(20),
  age int,
  categorie character varying(20),
  constraint auteur_pkey primary key (id)
);

create table livre
(
  id int not null auto_increment,
  titre character varying(50),
  auteur_id int not null,
  edition character varying(20),
  prix float,
  foreign key(auteur_id) references auteur(id),
  constraint livre_pkey primary key (id)
);

create table lignes_en_erreur
(
numero_de_ligne int,
ligne character varying(256),
fichier character varying(256),
erreur_date date
);