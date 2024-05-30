CREATE TABLE clientes (
    id_cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    nacimiento date,
    genero VARCHAR(1),
    edo_civil int,
    estatus boolean,
    creado_en date, 
    CONSTRAINT CHK_genero CHECK (genero IN ('H', 'M', 'X')),
    CONSTRAINT CHK_EdoCivil CHECK (edo_civil between 0 and 2)
);


