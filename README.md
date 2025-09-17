Precisa incluir a database no mysql: (jdbc:mysql://localhost:3306/loja1)


Abre na porta http://localhost:8080/

(No linux):
    Permissão: chmod +x mvnw
    Para compilar: ./mvnw clean install
    Para executar: ./mvnw spring-boot:run

Testes POST, PATCH:
usuarios:
{
	"nome": "ex",
	"email": "ex",
	"senha": "ex",
	"data_nascimento": null,
	"pontuacao": 0
}

produtos:
{
	"nome": "ex",
	"preco": 0
}

BD:
CREATE DATABASE loja1;
USE loja1;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    preco DECIMAL
);

CREATE TABLE usuarios (
   id INT AUTO_INCREMENT PRIMARY KEY,
   nome VARCHAR(50) NOT NULL,
   email VARCHAR(50) UNIQUE NOT NULL,
   senha VARCHAR(255) NOT NULL,
   data_nascimento DATE,
   pontuacao INT DEFAULT 0
);
