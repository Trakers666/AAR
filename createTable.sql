CREATE TABLE Users(id INTEGER PRIMARY KEY auto_increment,nom VARCHAR(255),prenom VARCHAR(255),login VARCHAR(32) UNIQUE,password BLOB);

CREATE TABLE Friends
(id_from INTEGER , 
id_to INTEGER,primary key (id_from, id_to)
);

CREATE table Sessions
(id_user_key INTEGER primary key,
peremption TIMESTAMP
);