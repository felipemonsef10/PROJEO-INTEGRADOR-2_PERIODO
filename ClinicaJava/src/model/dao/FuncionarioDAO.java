/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Funcionario;

/**
 *
 * @author felip
 */
public class FuncionarioDAO {
 
    public void create(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO funcionario (nome,nascimento,cpf,funcao,sexo,telefone,celular,email)VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getNascimento());
            stmt.setString(3, f.getCpf());
            stmt.setString(4, f.getCargo());
            stmt.setString(5, f.getSexo());
            stmt.setString(6, f.getTelefone());
            stmt.setString(7, f.getCelular());
            stmt.setString(8, f.getEmail());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
         
    }
    
    
}
