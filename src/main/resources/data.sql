-- Criando objeto pessoa para receber pessoas fisicas e juridicas
INSERT INTO pessoa (id, nome, data_Nascimento)
VALUES (1, 'Ana Costa', '1980-05-15'),
    (2, 'Bruno Oliveira', '1990-11-22'),
    (3, 'Carla Santos', '1998-12-05'),
    (4, 'Daniel Almeida', '1985-02-20'),
    (5, 'Elena Ferreira', '1979-04-13'),
    (6, 'Felipe Lima', '1992-08-30'),
    (7, 'Gabriela Rocha', '1988-03-25'),
    (8, 'Henrique Silva', '1991-06-07'),
    (9, 'Isabela Castro', '1995-12-15'),
    (10, 'João Pedro', '1987-01-12'),
    (11, 'Karine Moreira', '1993-09-05'),
    (12, 'Lucas Pereira', '1990-11-10'),
    (13, 'Mariana Costa', '1986-07-22'),
    (14, 'Natália Rodrigues', '1994-04-18'),
    (15, 'Otávio Santos', '1991-12-28'),
    (16, 'Patrícia Lima', '1982-03-19'),
    (17, 'Quiteria Almeida', '1978-11-30'),
    (18, 'Rafael Andrade', '1992-02-08'),
    (19, 'Sofia Fernandes', '1993-05-23'),
    (20, 'Getulio Germano', '1995-07-14');
-- Criando pessoas Fisicas
INSERT INTO fisica (id, cpf)
VALUES (1, '123.456.789-00'),
    (2, '234.567.890-11'),
    (3, '345.678.901-22'),
    (4, '456.789.012-33'),
    (5, '567.890.123-44'),
    (6, '678.901.234-55'),
    (7, '789.012.345-66'),
    (8, '890.123.456-77'),
    (9, '901.234.567-88'),
    (10, '012.345.678-99');
-- Criando pessoas Juridicas
INSERT INTO juridica (id, cnpj)
VALUES (11, '12.345.678/0001-90'),
    (12, '23.456.789/0001-91'),
    (13, '34.567.890/0001-92'),
    (14, '45.678.901/0001-93'),
    (15, '56.789.012/0001-94'),
    (16, '67.890.123/0001-95'),
    (17, '78.901.234/0001-96'),
    (18, '89.012.345/0001-97'),
    (19, '90.123.456/0001-98'),
    (20, '01.234.567/0001-99');
-- Criando endereços para cada pessoa fisica
INSERT INTO endereco (
        id,
        cep,
        estado,
        cidade,
        bairro,
        rua,
        numero,
        fisica_id
    )
VALUES (
        1,
        '01000-000',
        'SP',
        'São Paulo',
        'Centro',
        'Rua A',
        '123',
        1
    ),
    (
        2,
        '02000-000',
        'SP',
        'São Paulo',
        'Brás',
        'Rua B',
        '456',
        1
    ),
    (
        3,
        '03000-000',
        'SP',
        'São Paulo',
        'Liberdade',
        'Rua C',
        '789',
        2
    ),
    (
        4,
        '04000-000',
        'RJ',
        'Rio de Janeiro',
        'Centro',
        'Rua D',
        '101',
        2
    ),
    (
        5,
        '05000-000',
        'RJ',
        'Rio de Janeiro',
        'Copacabana',
        'Rua E',
        '202',
        3
    ),
    (
        6,
        '06000-000',
        'MG',
        'Belo Horizonte',
        'Centro',
        'Rua F',
        '303',
        3
    ),
    (
        7,
        '07000-000',
        'MG',
        'Belo Horizonte',
        'Savassi',
        'Rua G',
        '404',
        4
    ),
    (
        8,
        '08000-000',
        'RS',
        'Porto Alegre',
        'Centro',
        'Rua H',
        '505',
        5
    ),
    (
        9,
        '09000-000',
        'RS',
        'Porto Alegre',
        'Bom Fim',
        'Rua I',
        '606',
        6
    ),
    (
        10,
        '10000-000',
        'BA',
        'Salvador',
        'Barra',
        'Rua J',
        '707',
        7
    ),
    (
        11,
        '11000-000',
        'BA',
        'Salvador',
        'Pelourinho',
        'Rua K',
        '808',
        8
    ),
    (
        12,
        '12000-000',
        'PR',
        'Curitiba',
        'Centro',
        'Rua L',
        '909',
        8
    ),
    (
        13,
        '13000-000',
        'PR',
        'Curitiba',
        'Água Verde',
        'Rua M',
        '1010',
        9
    ),
    (
        14,
        '14000-000',
        'CE',
        'Fortaleza',
        'Centro',
        'Rua N',
        '1111',
        10
    ),
    (
        15,
        '15000-000',
        'CE',
        'Fortaleza',
        'Meireles',
        'Rua O',
        '1212',
        10
    );
-- Criando Produtos
INSERT INTO produto (id, nome, valor, juridica_id)
VALUES (1, 'Produto A', 99.99, 11),
    (2, 'Produto B', 149.49, 11),
    (3, 'Produto C', 79.89, 12),
    (4, 'Produto D', 199.99, 12),
    (5, 'Produto E', 120.00, 13),
    (6, 'Produto F', 89.90, 13),
    (7, 'Produto G', 59.99, 14),
    (8, 'Produto H', 249.99, 14),
    (9, 'Produto I', 299.99, 15),
    (10, 'Produto J', 399.99, 15),
    (11, 'Produto K', 129.50, 16),
    (12, 'Produto L', 349.00, 16),
    (13, 'Produto M', 210.00, 17),
    (14, 'Produto N', 399.00, 17),
    (15, 'Produto O', 499.99, 18);
-- Criando vendas
INSERT INTO venda (id, total, quantidade, fisica_id, produto_id)
VALUES (1, 99.99, 1, 1, 1),
    (2, 299.97, 3, 1, 2),
    (3, 79.89, 1, 2, 3),
    (4, 399.98, 2, 2, 4),
    (5, 120.00, 1, 3, 5),
    (6, 179.80, 2, 3, 6),
    (7, 59.99, 1, 4, 7),
    (8, 499.98, 2, 4, 8),
    (9, 299.99, 1, 5, 9),
    (10, 399.99, 1, 5, 10),
    (11, 129.50, 1, 6, 11),
    (12, 698.00, 2, 6, 12),
    (13, 210.00, 1, 7, 13),
    (14, 399.00, 1, 7, 14),
    (15, 499.99, 1, 8, 15);