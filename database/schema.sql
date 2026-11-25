
CREATE DATABASE IF NOT EXISTS sistema_biblioteca;

USE sistema_biblioteca;

CREATE TABLE IF NOT EXISTS autor (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     nome VARCHAR(150) NOT NULL,
    nacionalidade VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS livro (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     titulo VARCHAR(200) NOT NULL,
    isbn VARCHAR(20),
    ano_publicacao INT,
    autor_id INT NOT NULL,

    CONSTRAINT fk_livro_autor
    FOREIGN KEY (autor_id)
    REFERENCES autor(id)
    );
