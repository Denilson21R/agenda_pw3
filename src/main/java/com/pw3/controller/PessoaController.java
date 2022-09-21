package com.pw3.controller;

import com.pw3.DAO.PessoaDAO;
import com.pw3.model.Pessoa;

import java.util.ArrayList;

public class PessoaController {
    public static ArrayList<Pessoa> getPessoas() {
        PessoaDAO DAO = new PessoaDAO();
        return (ArrayList<Pessoa>) DAO.getPessoas();
    }

    public static void addPessoa(Pessoa p) {
        PessoaDAO DAO = new PessoaDAO();
        DAO.addPessoa(p);
    }

    public static void atualizaPessoa(Pessoa p){
        PessoaDAO DAO = new PessoaDAO();
        DAO.atualizaPessoa(p);
    }

    public static void deletaPessoa(int id){
        PessoaDAO DAO = new PessoaDAO();
        DAO.deletaPessoa(id);
    }
}
