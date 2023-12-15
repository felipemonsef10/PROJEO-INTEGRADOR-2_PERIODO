/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author felip
 */
public class UsuarioDAO {
 
    public void create(Usuario u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuario (cpf,login,senha,acesso)VALUES(?,?,?,?)");
            stmt.setString(1, u.getCpf());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getAcesso());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
         
    }
    
    
    public boolean checkLogin(String login, String senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean check = false;
        int acesso = 0;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();

            if(rs.next()) {
              
                check = true;
                
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return check;
    }
    
    public String checkAcesso(String login, String senha){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String acesso = null;
        
        try {
            stmt = con.prepareStatement("SELECT acesso FROM usuario WHERE login = ?");
            stmt.setString(1, login);
            
            rs = stmt.executeQuery();

            if(rs.next()) {
              
                acesso = rs.getString("acesso");
                
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return acesso;
        
    }
}
