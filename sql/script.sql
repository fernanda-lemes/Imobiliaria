-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS imobiliaria;
USE imobiliaria;

-- Tabela Cliente
CREATE TABLE IF NOT EXISTS Cliente (
                                       id INT PRIMARY KEY AUTO_INCREMENT,
                                       nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    telefone VARCHAR(15)
    );

-- Tabela Imovel
CREATE TABLE IF NOT EXISTS Imovel (
                                      id INT PRIMARY KEY AUTO_INCREMENT,
                                      endereco VARCHAR(150) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    valorAluguel DECIMAL(10,2) NOT NULL,
    disponivel BOOLEAN DEFAULT TRUE
    );

-- Tabela Contrato
CREATE TABLE IF NOT EXISTS Contrato (
                                        id INT PRIMARY KEY AUTO_INCREMENT,
                                        idCliente INT NOT NULL,
                                        idImovel INT NOT NULL,
                                        dataInicio DATE NOT NULL,
                                        dataFim DATE NOT NULL,
                                        valor DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Cliente(id),
    FOREIGN KEY (idImovel) REFERENCES Imovel(id)
    );

-- Inserção de clientes de exemplo
INSERT INTO Cliente (nome, cpf, telefone) VALUES
                                              ('João Silva', '123.456.789-00', '(47)99999-0000'),
                                              ('Maria Souza', '987.654.321-00', '(47)98888-1111');

-- Inserção de imóveis de exemplo
INSERT INTO Imovel (endereco, tipo, valorAluguel, disponivel) VALUES
                                                                  ('Rua A, 100', 'Apartamento', 1200.00, TRUE),
                                                                  ('Rua B, 200', 'Casa', 2500.00, TRUE),
                                                                  ('Rua C, 300', 'Apartamento', 1500.00, TRUE);

-- Inserção de contratos de exemplo
INSERT INTO Contrato (idCliente, idImovel, dataInicio, dataFim, valor) VALUES
                                                                           (1, 1, '2025-09-01', '2026-09-01', 1200.00),
                                                                           (2, 2, '2025-08-15', '2026-08-15', 2500.00);
