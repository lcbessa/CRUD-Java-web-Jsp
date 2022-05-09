create database ESTOQUE;
use ESTOQUE;
create table PRODUTO (
codigoProduto int auto_increment primary key not null,
nomeProduto varchar (40),
valorProduto numeric (10,2),
descricaoProduto varchar (100),
descontoProduto int,
valorAposDescontoProduto  numeric (10,2)
);