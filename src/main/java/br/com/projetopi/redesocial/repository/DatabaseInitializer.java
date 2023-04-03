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
nome varchar (50) not null,
tipo varchar (30) not null,
area varchar (30) not null,
instituicao_id integer not null,
foreign key (instituicao_id) references instituicao(id));
create table turma(
id integer primary key AUTO_INCREMENT,
id_curso integer  not null,
data_inicio date not null,
semestre binary not null,
letra char not null,
foreign key (id_curso) references curso(id));
create table foto (
id integer primary key auto_increment,
cd_foto binary (200));
create table conta (
id integer primary key auto_increment,
cpf varchar (12),
nome varchar (30) not null,
data_nascimento date not null,
sobre varchar (200),
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
""";
    }


}
