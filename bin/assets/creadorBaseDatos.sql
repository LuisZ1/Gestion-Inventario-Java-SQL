/*
USE master
DROP DATABASE GestionInventario

CREATE DATABASE GestionInventario

USE master
CREATE LOGIN pepito with password='qq', DEFAULT_DATABASE=GestionInventario

USE GestionInventario
CREATE USER pepito FOR LOGIN pepito
GRANT EXECUTE, INSERT, UPDATE, DELETE, SELECT TO pepito
*/

CREATE TABLE Lugares (
	ID tinyint IDENTITY
	,nombre varchar(50)

	CONSTRAINT PK_Lugares PRIMARY KEY(ID)
)

CREATE TABLE Materiales (
	ID tinyint IDENTITY
	,nombre varchar(50)
	,ID_Lugar tinyint

	,CONSTRAINT PK_Materiales PRIMARY KEY (ID)
	,CONSTRAINT FK_Materiales_Lugares FOREIGN KEY (ID_Lugar) REFERENCES Lugares
)

CREATE TABLE Herramientas (
	ID tinyint IDENTITY
	,tipo varchar(50)
	,tamañoCm int
	,ID_Material tinyint

	,CONSTRAINT PK_Herramientas PRIMARY KEY (ID)
	,CONSTRAINT FK_Herramientas_Materiales FOREIGN KEY (ID_Material) REFERENCES Materiales

	,CONSTRAINT CK_dimensionesFerreteriaPositivas CHECK (tamañoCm > 0)
)

CREATE TABLE Ferreteria (
	ID tinyint IDENTITY
	,tipo varchar(50)
	,dimensiones varchar(50)
	,ID_Material tinyint

	,CONSTRAINT PK_Ferreteria PRIMARY KEY (ID)
	,CONSTRAINT FK_Ferreteria_Materiales FOREIGN KEY (ID_Material) REFERENCES Materiales
)

CREATE TABLE Electricidad (
	ID tinyint IDENTITY
	,color varchar(50)
	,dimensiones varchar(50)
	,ID_Material tinyint

	,CONSTRAINT PK_Electricidad PRIMARY KEY (ID)
	,CONSTRAINT FK_Electricidad_Materiales FOREIGN KEY (ID_Material) REFERENCES Materiales
)