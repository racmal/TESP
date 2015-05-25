-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212')

insert into TB_PESSOA (ID, CPF, NOME) values (0, 11111111111, 'Paulo Jose')
insert into TB_PESSOA (ID, CPF, NOME) values (0, 22222222222, 'Maria Jose')
insert into TB_PESSOA (ID, CPF, NOME) values (0, 33333333333, 'Joao Jose')

insert into TB_ALUNO (DATA_ANIVERSARIO, MATRICULA, ID) values ('2015-04-01', '54321', '1')
insert into TB_ALUNO (DATA_ANIVERSARIO, MATRICULA, ID) values ('1990-01-10', '222222', '2')
insert into TB_ALUNO (DATA_ANIVERSARIO, MATRICULA, ID) values ('1980-12-24', '333333', '3')

insert into TB_PROFESSOR (SALARIO, ID) values ('5000', '1')
insert into TB_PROFESSOR (SALARIO, ID) values ('6000', '2')
insert into TB_PROFESSOR (SALARIO, ID) values ('7000', '3')