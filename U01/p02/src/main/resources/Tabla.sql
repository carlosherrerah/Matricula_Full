CREATE TABLE clientes (
    id_cliente INT auto_increment PRIMARY KEY,
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    nacimiento date,
    genero VARCHAR(1) CHECK (genero IN ('H', 'M', 'X')),
    edo_civil int check (edo_civil between 0 and 2), 
    estatus boolean,
    creado_en date
);

