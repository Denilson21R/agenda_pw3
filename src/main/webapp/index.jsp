<%@page contentType="text/html;charSet=utf-8"%>
<%@page import="com.pw3.model.Pessoa, java.util.*"%>
<%@ page import="com.pw3.controller.PessoaController" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Agenda de Contatos</title>

    <!--Bootstrap-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <!-- open-iconic-bootstrap (icon set for bootstrap) -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic-bootstrap.min.css" integrity="sha256-BJ/G+e+y7bQdrYkS2RBTyNfBHpA9IuGaPmf9htub5MQ=" crossorigin="anonymous" />

    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
     ArrayList<Pessoa> lista = PessoaController.getPessoas();
%>
    <h1>Agenda de Contatos Funfando Legal</h1>
    <a class="btn btn-primary btn-md" role="button" href="cadastro.jsp">
        <span class="oi oi-plus" title="Cadastro" aria-hidden="true">Cadastrar Pessoas</span>
       
    </a>
    <div class="table-responsive">
        <table class="table table-striped table-hover table-sm">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>e-mail</th>
                    <th>Telefone</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>

                <%
                   for(Pessoa p : lista ) {
                %>
                <tr>
                    <th><%= p.getId() %></th>
                    <th><%= p.getNome() %></th>
                    <th><%= p.getEmail() %></th>
                    <th><%= p.getTelefone() %></th>
                    <th>
                       <a class="btn btn-info btn-sm" role="button" 
                       href="cadastrar?op=alterar&id=<%= p.getId() %>">
                       <span class="oi oi-brush" title="Editar" aria-hidden="true"></span>
                       </a>
                       <a class="btn btn-danger btn-sm" role="button"
                       href="cadastrar?op=excluir&id=<%= p.getId() %>">
                        <span class="oi oi-circle-x" title="Excluir" aria-hidden="true"></span>
                       </a>
                    </th>                  
                </tr>

                <%
                   }
                %>

            </tbody>
        </table>
    </div>
</body>
</html>