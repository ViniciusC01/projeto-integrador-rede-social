package br.com.projetopi.redesocial.repository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebListener
public class DatabaseInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try(Connection con = ConnectionFactory.getConnectionH2()){
            try (Statement st = con.createStatement()){
                st.execute(getInitQuery());
                System.out.println("Banco de dados iniciado com sucesso!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("conexão encerrada");
    }

    public String getInitQuery(){
        return """         
                create table usuario (\s
                id integer primary key AUTO_INCREMENT,
                email varchar (30) not null,
                senha varchar (100) not null,
                papel varchar (100) DEFAULT  ('aluno') not null
                );                
                create table instituicao(
                id integer primary key AUTO_INCREMENT,
                nome varchar (30) not null);             
                create table curso(
                id integer primary key AUTO_INCREMENT,
                nome varchar (100) not null,
                tipo varchar (100) not null,
                area varchar (100) not null,
                instituicao_id integer not null,
                foreign key (instituicao_id) references instituicao(id));
                create table turma(
                id integer primary key AUTO_INCREMENT,
                id_curso integer  not null,
                data_inicio date not null,
                turno varchar(30) not null,
                semestre varchar(30) not null,
                letra char not null,
                foreign key (id_curso) references curso(id));
                create table foto (
                id integer primary key auto_increment,
                cd_foto binary (200));
                create table conta (
                id integer primary key auto_increment,
                cpf varchar (12),
                ic_ativo integer,
                nome varchar (30) not null,
                data_nascimento date not null,
                sobre varchar (200),
                genero varchar(100),
                usuario_id integer not null,
                instituicao_id integer not null,
                curso_id integer not null,
                foto_id integer not null,
                turma_id integer not null,
                foreign key (instituicao_id) references instituicao(id),
                foreign key (usuario_id) references usuario(id),
                foreign key (curso_id) references curso(id),
                foreign key (instituicao_id) references instituicao(id),
                foreign key (turma_id) references turma(id),
                foreign key (foto_id) references foto(id));      
                create table postagem (
                id integer primary key auto_increment,
                conteudo varchar (500),
                foto_id integer,
                check(foto_id is not null or conteudo is not null),
                foreign key (foto_id) references foto(id));      
                create table curtida_postagem(
                id integer primary key auto_increment,
                postagem_id integer not null,
                conta_id integer not null,
                foreign key (postagem_id) references postagem(id));     
                create table comentario_postagem (
                id integer primary key auto_increment,
                conteudo varchar (200) not null,
                usuario_id integer not null,
                postagem_id integer not null,
                foreign key (usuario_id) references usuario(id),
                foreign key (postagem_id) references postagem(id));      
                create table curtida_comentario (
                id integer primary key auto_increment,
                comentario_id integer not null,
                conta_id integer not null,
                foreign key (comentario_id) references comentario_postagem(id),
                foreign key (conta_id) references conta(id));
                create table mensagem(
                id integer primary key auto_increment,
                conteudo varchar (400),
                data_mensagem date not null,
                conta_remente_id integer not null,
                conta_destinatario_id integer not null,
                foreign key (conta_remente_id) references conta(id),
                foreign key (conta_destinatario_id) references conta(id));   
                INSERT INTO INSTITUICAO (ID, NOME) VALUES (1, 'CENTRO UNIVERSITARIO SENAC');
                INSERT INTO FOTO (ID, CD_FOTO) VALUES (1, 'TESTE FOTO');
                INSERT INTO CURSO (ID, NOME, TIPO, AREA, INSTITUICAO_ID) VALUES (1, 'ANALISE E DESENVOLVIMENTO DE SISTEMAS', 'TECNOLOGO', 'TECNOLOGIA DA INFORMACAO', 1);
                INSERT INTO TURMA (ID, ID_CURSO, DATA_INICIO, SEMESTRE, LETRA, TURNO) VALUES (1, 1, '2022-01-01', 'SEGUNDO', 'D', 'NOTURNO');
                INSERT INTO USUARIO (ID, EMAIL, SENHA, PAPEL) VALUES (1, 'ALUNO_EXEMPLO@EMAIL.COM', '123', 'ALUNO');
                INSERT INTO CONTA (ID, CPF,IC_ATIVO, NOME, DATA_NASCIMENTO, SOBRE, USUARIO_ID, INSTITUICAO_ID, CURSO_ID, FOTO_ID, TURMA_ID, GENERO) VALUES (1, '45194845804', 1, 'ALUNO EXEMPLO', '1994-04-04', 'APRESENTACAO PESSOAL', 1, 1, 1, 1, 1, 'MASCULINO'); 
                INSERT INTO CONTA (ID, CPF,IC_ATIVO, NOME, DATA_NASCIMENTO, SOBRE, USUARIO_ID, INSTITUICAO_ID, CURSO_ID, FOTO_ID, TURMA_ID, GENERO) VALUES (2, '45194845805', 1, 'ALUNA EXEMPLO', '1994-06-04', 'APRESENTACAO PESSOAL2', 1, 1, 1, 1, 1, 'FEMININO');       
                """;
    }


}
