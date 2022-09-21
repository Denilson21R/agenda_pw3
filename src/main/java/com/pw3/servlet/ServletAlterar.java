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

@WebServlet(name="servletAlterar",value="/alterar")
public class ServletAlterar extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArrayList<Pessoa> lista = PessoaController.getPessoas();

        Integer id = Integer.parseInt(req.getParameter("id"));

        Pessoa p = new Pessoa(id,req.getParameter("nome"),req.getParameter("email"),
                              req.getParameter("telefone"));

        PessoaController.atualizaPessoa(p);
        for (int i = 0; i < lista.size(); i++){
            if( lista.get(i).getId() == p.getId()){
                lista.set(i, p);
            }
        }

        session.setAttribute("lista", lista);

        resp.sendRedirect(".");
    }
    
}
