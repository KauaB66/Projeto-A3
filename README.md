Sistema de Gerenciamento de Livraria e Biblioteca
📋 Descrição do Projeto
Este projeto foi desenvolvido com o objetivo de testar meus conhecimentos em programação e automatizar tarefas em pequenas livrarias e bibliotecas, proporcionando otimização do tempo e organização.

🚀 Funcionalidades
O sistema permite realizar operações essenciais de gerenciamento:

Incluir um novo registro de livros.
Consultar livros existentes.
Alterar informações de livros.
Excluir registros do banco de dados.

🛠️ Conceitos e Tecnologias Utilizadas
Programação Orientada a Objetos (POO):

Encapsulamento de classes e objetos para garantir organização e segurança dos dados.
Interface Gráfica:

Implementação de um menu interativo com JOptionPane, possibilitando uma navegação intuitiva para o usuário.
Banco de Dados:

Integração com MySQL para armazenamento e gerenciamento das informações.

💻 Estrutura do Projeto
O projeto está dividido em 3 etapas principais:

Encapsulamento das Classes e Objetos:

Modelagem das classes com atributos privados e métodos de acesso (getters e setters).
Menu Interativo com JOptionPane:

Permite ao usuário escolher facilmente as opções de incluir, consultar, alterar e excluir registros.
Interface e Conexão com Banco de Dados:

Criação de uma interface amigável e conexão com o banco de dados MySQL para manipulação eficiente dos dados.

🖥️ Pré-requisitos
Para rodar o projeto, certifique-se de ter:

Java JDK instalado.
MySQL configurado.
Uma IDE como Eclipse, IntelliJ ou NetBeans para execução do código.

Clone o repositório:
bash
Copie o código
git clone https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git
Configure o banco de dados MySQL com as tabelas necessárias 
tabela do banco de dados:

CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE livro (
    codigo_isbn VARCHAR(30) PRIMARY KEY, -- ISBN como chave primária
    autor VARCHAR(30),
    genero VARCHAR(30),
    ano_lancamento DATE,
    quantidade_copias INT,
    valor DECIMAL(10,2),
    nome VARCHAR(30),
    prateleira VARCHAR(20),
    quantidade_paginas INT,
    edicao INT
);

Compile e execute o projeto na sua IDE preferida.
Interaja com o menu para gerenciar os registros.

📝 Possíveis Melhorias Futuras

Implementação de relatórios.
Criação de filtros avançados para pesquisa de livros.
Adição de autenticação de usuários.

🧑‍💻 Autor
Desenvolvido por 
Kauã Barbosa Santos Oliveira 
Renan Lucchetti de Lima Custódio
Enzo Yukio Yoshida
Matheus Fraga Gagliardi
João Victtor ferreira dos Santos
Estudantes de Análise e Desenvolvimento de Sistemas.
