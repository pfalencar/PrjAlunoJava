create database db_alunos;
use db_alunos;

create table alunos (
  id int auto_increment not null,
  nome varchar(50) not null,
  endereco varchar(50),
  bairro varchar(30),
  primary key(id)
);


insert into alunos (nome, endereco, bairro) values ('Fernanda','Rua A','Jd. Flores');
insert into alunos (nome, endereco, bairro) values ('Patricia','Av. 2 2600','Jd.Nicolau');
insert into alunos (nome, endereco, bairro) values ('Patri','Av. 3, 260','Jd. Vitoria');

insert into aluno (nome, endereco, bairro) values ('Vitória','Av. Montana, 2210','Jd. Camargo');
select * from alunos;
RENAME TABLE alunos TO aluno;
select * from aluno;
SELECT * FROM aluno WHERE nome = 'Vitória';
UPDATE aluno SET bairro = 'chacara flora' WHERE id = 5;
UPDATE aluno SET nome = 'Dona Florinda', endereco = 'Rua Maracatu, 484', bairro = 'Cidade do México' WHERE id = 5