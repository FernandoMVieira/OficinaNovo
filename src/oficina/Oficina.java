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
public class Oficina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conecta con = new Conecta();
        Funcionario f1 = new Funcionario();
        Cliente c1 = new Cliente();
        
        f1.setIdfuncionario("1001");
        f1.setNome("Dani");
        f1.setCpf("157.157.157.157");
        f1.setMatricula(1001);
        
        con.adicionaFuncionario(f1);
        
        System.out.println("Funcionario novo adicionado");
        
        c1.setIdcliente("5005");
        c1.setNome("Fabi");
        c1.setCpf("999.999.999.999");
        
        con.adicionaCliente(c1);
        
        // mudei alguma coisa 
        System.out.println("Cliente novo adicionado");
  
    }
    
}
