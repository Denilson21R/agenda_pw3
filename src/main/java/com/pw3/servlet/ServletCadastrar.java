package com.pw3.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pw3.controller.PessoaController;
import com.pw3.model.Pessoa;

@WebServlet(name="servletCadastrar",value="/cadastrar")
public class ServletCadastrar extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        ArrayList<Pessoa> lista = PessoaController.getPessoas();

        Pessoa p = new Pessoa(req.getParameter("nome"),req.getParameter("email"),
                              req.getParameter("telefone"));
        
        PessoaController.addPessoa(p);
        lista.add(p);

        session.setAttribute("lista", lista);

        resp.sendRedirect(".");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        Integer id;
        Pessoa pessoa=new Pessoa();
        HttpSession session = req.getSession();
        String local = ".";
        ArrayList<Pessoa> lista = PessoaController.getPessoas();
        System.out.println("Operação "+op);
        if (op!=null){
            id = Integer.parseInt(req.getParameter("id"));

            if (op.equals("excluir")){
                for (Pessoa x:lista) {
                    System.out.println(pessoa);
                    if(x.getId() == id){
                        PessoaController.deletaPessoa(id);
                        lista.remove(x);
                        break;
                    }
                }

            } else if (op.equals("alterar")){
                for( Pessoa p : lista){
                    if (p.getId()==id){
                        pessoa=p;
                        break;
                    }
                }
                session.setAttribute("pessoa", pessoa);
                session.setAttribute("op", "alterar");
                local = "cadastro.jsp";
            }

        }
        resp.sendRedirect(local);
    }
    
    
}
