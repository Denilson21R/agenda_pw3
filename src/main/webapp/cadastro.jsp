<%@page contentType="text/html;charSet=utf-8"%>
<%@page import="com.pw3.model.Pessoa, java.util.*"%><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Pessoas</title>
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
     int op=0; //0-inserir; 1-alterar
     Pessoa pessoa = new Pessoa();
     String action="cadastrar";
     if (session.getAttribute("op")!=null){
        op=1;
        session.removeAttribute("op");
        pessoa = (Pessoa)session.getAttribute("pessoa");
        session.removeAttribute("pesssoa");
        action="alterar";
     }
%>
    <h1>Agenda de Contatos</h1>
    <section class="layout-content">
        <div class="container" id="cadastro">
            <form method="post" action="<%=action %>">
                <label for="nome">Nome</label>
                <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome Completo"
                   value="<%=pessoa.getNome() %>">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="email@exemplo.com"
                value="<%=pessoa.getEmail() %>">
                <label for="telefone">Telefone</label>
                <input type="text" class="form-control" id="telefone" name="telefone" placeholder="(16)12345-6789"
                 value="<%=pessoa.getTelefone() %>">
                <input type="hidden" id="id" name="id" value="<%=pessoa.getId() %>">
                <button type="submit" class="btn btn-primary btn-sm">Salvar</button>
            </form>
        </div>
    </section>
    
</body>
</html>