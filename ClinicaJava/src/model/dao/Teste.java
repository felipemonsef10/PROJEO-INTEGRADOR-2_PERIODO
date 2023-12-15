/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author felip
 */
public class Teste {
    
    public static void main(String[] args){
        UsuarioDAO dao = new UsuarioDAO();
        
        String teste = dao.checkAcesso("123123132", "asdasdas");
        
        System.out.print(teste);
        
    }
    
    
    
}
