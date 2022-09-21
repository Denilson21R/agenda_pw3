package com.pw3.model;

public class Pessoa {
    private static int ID = 0;
    private Integer id;
    private String nome;
    private String email;
    private String telefone;

    public Pessoa() {
        id=-1;
        nome = "";
        email = "";
        telefone = "";

    }
    public Pessoa(String nome, String email, String telefone) {
        ID++;
        this.id = ID;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    public Pessoa(Integer id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
}
