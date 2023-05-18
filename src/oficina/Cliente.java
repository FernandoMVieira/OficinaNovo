/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oficina;

/**
 *
 * @author aluno
 */
public class Cliente extends Pessoa {
    
    private String idcliente;
    
    public void setIdcliente(String idcliente){
        this.idcliente = idcliente;
    }
    
    public String getIdcliente (){
        return idcliente;
    }
}
