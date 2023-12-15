/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Consulta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felip
 */
public class ConsultaDAO {
 
    public void create(Consulta c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO consulta (nome_medico,nome_paciente,data_consulta,horario,cpf_paciente)VALUES(?,?,?,?,?)");
            stmt.setString(1, c.getNome_medico());
            stmt.setString(2, c.getNome_paciente());
            stmt.setString(3, c.getData_consulta());
            stmt.setString(4, c.getHorario());
            stmt.setString(5, c.getCpf_paciente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
         
    }
    
    public List<Consulta> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Consulta> consultas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM consulta");
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Consulta consulta = new Consulta();
                
                consulta.setId_consulta(rs.getInt("id_consulta"));
                consulta.setNome_medico(rs.getString("nome_medico"));
                consulta.setNome_paciente(rs.getString("nome_paciente"));
                consulta.setData_consulta(rs.getString("data_consulta"));
                consulta.setHorario(rs.getString("horario"));
                consulta.setCpf_paciente(rs.getString("cpf_paciente"));
                consultas.add(consulta);
                
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return consultas;
        
    }
    
    
}
