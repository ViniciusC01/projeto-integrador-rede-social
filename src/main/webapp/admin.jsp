<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./style/admin.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="./js/admin.js" defer></script>
</head>
<body>

<div class="row">
<div class="col-2 container-menu">
    <nav class="navbar navbar-expand-lg bg-dark side-nav d-flex align-items-start">
        <div class="d-flex flex-column w-100">
            <div class="d-flex w-100 bg-danger justify-content-center">
                <a class="navbar-brand" href="#">UNIHUB</a>
            </div>
            <div class="collapse navbar-collapse menu" id="navbarNav">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex flex-column w-100">
                    <li class="nav-item menu-item d-flex justify-content-center">
                        <a class="nav-link" aria-current="page" href="#">
                            Home
                        </a>
                    </li>
                    <li class="nav-item menu-item d-flex justify-content-center">
                        <a class="nav-link" href="#">
                            Contas
                        </a>
                    </li>
                    <li class="nav-item menu-item d-flex justify-content-center">
                        <a class="nav-link" href="#">
                            Cursos
                        </a>
                    </li>
                    <li class="nav-item menu-item d-flex justify-content-center">
                        <a class="nav-link" href="#">
                            Instituicoes
                        </a>
                    </li>
                    <li class="nav-item menu-item d-flex justify-content-center">
                        <a class="nav-link" href="#">
                            Turma
                        </a>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
</div>
<div class="col-10">
<table class="table table-dark table-striped mt-5">
    <thead>
        <tr>
            <th>CPF</th>
            <th>NOME</th>
            <th>NASCIMENTO</th>
            <th> GENERO </th>
            <th> MAIS DETALHES </th>
            <th> EDITAR </th>
            <th> EXCLUIR </th>

        </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${contas}" var="conta">
            <td>${conta.cpf }</td>
            <td>${conta.nome }</td>
            <td>${conta.data_nascimento }</td>
            <td>${conta.genero}</td>
            <td>
                <!-- Button trigger modal -->
                <span class="material-icons">
                    more
                </span>

            </td>
            <td>
            <span class="material-icons" data-bs-toggle="modal" data-bs-target="#exampleModal" data-id="${conta.id}" id="editar">
                edit
            </span>
            </td>
            <td>
                <a href="/excluir_conta?id=${conta.id}">
                <span class="material-icons">
                    delete_forever
                </span>
                </a>
            </td>
        </c:forEach>
    </tr>
    </tbody>
</table>
</div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">

            EDITAR

        </h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">

        <div class="row">
            <div class="col-4">
                <label for="f_cpf" class="form-label"> CPF </label>
                <input type="email" class="form-control" id="f_cpf" placeholder="">
            </div>
            <div class="col-4">
                <label for="f_nome" class="form-label"> Nome </label>
                <input type="email" class="form-control" id="f_nome" placeholder="name@example.com">
            </div>
             <div class="col-4">
                <label for="f_nascimento" class="form-label">Data de Nascimento </label>
                <input type="date" class="form-control" id="f_nascimento" placeholder="">
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-4">
                <label for="f_genero" class="form-label"> Genero </label>
                <select class="form-select" aria-label="Default select example" id="f_genero">
                  <option selected>  </option>
                </select>
            </div>

             <div class="col-8">
                <label for="f_instituicoes" class="form-label"> Instituicao </label>
                <select class="form-select" aria-label="Default select example" id="f_instituicoes">
                  <option selected>  </option>
                </select>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-4">
                <label for="f_curso" class="form-label"> Curso </label>
                <select class="form-select" aria-label="Default select example" id="f_curso">
                </select>
            </div>

            <div class="col-4">
                <label for="f_ano_inicio" class="form-label"> Ano inicio </label>
                <select class="form-select" aria-label="Default select example" id="f_ano_inicio">

                </select>
            </div>

            <div class="col-4">
                <label for="f_semestre" class="form-label"> Semestre  </label>
                <select class="form-select" aria-label="Default select example" id="f_semestre">
                </select>
            </div>

        </div>

      <div class="row mt-3">
          <div class="col-4">
              <label for="f_turno" class="form-label"> Turno </label>
              <select class="form-select" aria-label="Default select example" id="f_turno">
              </select>
          </div>

          <div class="col-4">
              <label for="f_turma" class="form-label"> Turma </label>
              <select class="form-select" aria-label="Default select example" id="f_turma">
              </select>
          </div>

      </div>


      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"> Fechar </button>
        <button type="button" class="btn btn-primary"> Salvar </button>
      </div>
    </div>
  </div>
</div>

</body>
<script src="./js/admin.js" defer></script>

</html>