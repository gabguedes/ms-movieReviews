INSERT INTO tb_genero (nome) VALUES('Aventura');
INSERT INTO tb_genero(nome) VALUES('Ação');
INSERT INTO tb_genero(nome) VALUES('Suspense');
INSERT INTO tb_genero(nome) VALUES('Terror');
INSERT INTO tb_genero(nome) VALUES('Comédia');
INSERT INTO tb_genero(nome) VALUES('Drana');

INSERT INTO tb_filme(titulo, ano, genero_id) VALUES('The Substance', 2024, '3');
INSERT INTO tb_filme(titulo, ano, genero_id) VALUES('Scott Pilgrim contra o mundo', 2010, '5');
INSERT INTO tb_filme(titulo, ano, genero_id) VALUES('Brilho eterno de uma mente sem lembrança', 2008, '6');

INSERT INTO tb_user(name, email, password) VALUES('Gabriel', 'gabriel@gmail.com', '123456');
INSERT INTO tb_user(name, email, password) VALUES('William', 'william@gmail.com', '123456');
INSERT INTO tb_user(name, email, password) VALUES('Vinicius', 'vinicius@gmail.com', '123456');

INSERT INTO tb_review(texto, user_id, filme_id) VALUES('Muito bom!', 1, 2);
INSERT INTO tb_review(texto, user_id, filme_id) VALUES('Muito ruim!', 2, 1);
INSERT INTO tb_review(texto, user_id, filme_id) VALUES('Maravilho!', 3, 3);
