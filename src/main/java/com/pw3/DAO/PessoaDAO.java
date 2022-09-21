package com.pw3.DAO;

import com.pw3.model.Pessoa;
import com.pw3.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    public List<Pessoa> getPessoas() {
        try (Connection connection = ConnectionFactory.connection()) {
            String sql = "select * from pessoas";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Pessoa> pessoas = new ArrayList<>();
            while (rs.next()) {
                Pessoa client = new Pessoa(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                pessoas.add(client);
            }
            return pessoas;
        } catch (SQLException throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public void addPessoa(Pessoa p) {
        try (Connection connection = ConnectionFactory.connection()) {
            String sql = "insert into pessoas (nome, email, telefone)" +
                    " values (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p.getNome());
            statement.setString(2, p.getEmail());
            statement.setString(3, p.getTelefone());
            statement.executeUpdate();
        } catch (SQLException throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public void atualizaPessoa(Pessoa pessoa) {
        try (Connection connection = ConnectionFactory.connection()) {
            String sql = "update pessoas set nome = ?, email = ?," +
                    "telefone = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getEmail());
            statement.setString(3, pessoa.getTelefone());
            statement.setInt(4, pessoa.getId());
            statement.executeUpdate();
        } catch (SQLException throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public void deletaPessoa(int id) {
        try (Connection connection = ConnectionFactory.connection()) {
            String sql = "delete from pessoas where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
