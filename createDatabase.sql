CREATE TABLE Interet
( 
nomInteret VARCHAR(64) UNIQUE NOT NULL
);

CREATE TABLE Geek
( Id INTEGER,
nom VARCHAR(32) NOT NULL,
prenom VARCHAR(32) NOT NULL,
sexe VARCHAR(32) NOT NULL,
age INTEGER,
email VARCHAR(255),
centreInteret VARCHAR(255),
gravatar VARCHAR(255),
PRIMARY KEY (Id),
FOREIGN KEY (centreInteret) REFERENCES Interet(nomInteret)
);
