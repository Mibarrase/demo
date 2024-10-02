CREATE tiendadb
USE tiendadb
CREATE TABLE pettienda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(150),
    mascota VARCHAR(100),
    edad DECIMAL(10,2),
    raza VARCHAR (25)
);