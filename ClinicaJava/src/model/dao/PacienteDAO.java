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
import model.bean.Paciente;

/**
 *
 * @author felip
 */
public class PacienteDAO {
 
    public void create(Paciente p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO paciente (nome,nascimento,cpf,sexo,telefone,celular,email)VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getNascimento());
            stmt.setString(3, p.getCpf());
            stmt.setString(4, p.getSexo());
            stmt.setString(5, p.getTelefone());
            stmt.setString(6, p.getCelular());
            stmt.setString(7, p.getEmail());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
         
    }
    
    
}
