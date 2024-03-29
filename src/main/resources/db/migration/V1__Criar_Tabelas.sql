CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(255)
);

CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    categoria VARCHAR(50) NOT NULL
);


CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);

CREATE TABLE pedido_produto (
    pedido INT NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);

CREATE TABLE fila (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido INT NOT NULL,
    status VARCHAR(255) NOT NULL,
);