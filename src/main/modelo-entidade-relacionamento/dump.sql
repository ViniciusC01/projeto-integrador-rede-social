create database rede_social; 

use social_network; 

creata table usuario (
    id integer primary key; 
    email varchar (30) not null; 
    senha varchar (100) not null; 
);

create table conta (
    id integer primary key; 
    cpf varchar (12);
    nome varchar (30) not null;
    data_nascimento date not null; 
    instituicao_id integer foreign key;
    curso_id integer foreign key; 
    foto_id integer foreign key; 
);

create table foto (
    id integer primary key; 
    cd_foto binary (200);
);

create table postagem (
    id integer primary key; 
    conteudo varchar (500);
    id_foto binary foreign key; 
    check(id_foto is not null or conteudo is not null);
);

create table curtida_postagem(
    id_postagem integer foreign key; 
    id_conta integer foreign key; 
);

create table comentario_postagem (
    id integer primary key; 
    conteudo varchar (200) not null;
    id_usuario integer foreign key; 
    id_postagem integer foreign key;
);

create table curtida_comentario (
    id integer primary key;
    id_comentario integer foreign key;
    id_conta integer foreign key; 
);

create table mensagem(
    id integer primary key;
    id_conta_remente integer foreign key;
    id_conta_destinatario integer foreign key;
    conteudo varchar (100);
    data_ date not null;
);





