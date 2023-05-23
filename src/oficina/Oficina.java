
package oficina;

import java.util.List;

import javax.swing.JOptionPane;

public class Oficina {

    static Conecta con;
    
    public static void ConectaBD(){
        con = new Conecta();
    }
    
    public static void inserirCliente(){

        String nome = JOptionPane.showInputDialog("Digite o nome:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF:");
		
        Cliente c1 = new Cliente();
               
        c1.setNome(nome);
        c1.setCpf(cpf);
                
        con.adicionaCliente(c1);
        
	System.out.println("Cliente adicionado!");
    }
    
    public static void inserirFuncionario(){

        String nome = JOptionPane.showInputDialog("Digite o nome:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF:");
        String matricula = JOptionPane.showInputDialog("Digite a Matricula:");
		
        Funcionario f1 = new Funcionario();
               
        f1.setNome(nome);
        f1.setCpf(cpf);
        f1.setMatricula(matricula);
                
        con.adicionaFuncionario(f1);
        
	System.out.println("Funcionario adicionado!");
    }
    
    
    public static void listarClientes(){
        List<Cliente> contatos = con.getListaClientes();

	for (Cliente c : contatos) {
            System.out.println("ID: " + c.getIdcliente());
            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCpf() + "\n");
	}
    }
    
    
    public static void listarFuncionarios(){
        List<Funcionario> funcionarios = con.getListaFuncionarios();

	for (Funcionario f : funcionarios) {
            System.out.println("ID: " + f.getIdfuncionario());
            System.out.println("Nome: " + f.getNome());
            System.out.println("CPF: " + f.getCpf() + "\n");
            System.out.println("Matricula: " + f.getMatricula() + "\n");
	}
    }
    
    public static void alterarCliente(){
		
        String id = JOptionPane.showInputDialog("Digite o ID do cliente:");
	String nome = JOptionPane.showInputDialog("Digite o Nome:");
	String cpf = JOptionPane.showInputDialog("Digite o CPF:");
		
	Cliente cliente = new Cliente();
        cliente.setIdcliente(id);
	cliente.setNome(nome);
	cliente.setCpf(cpf);

	con.alteraCliente(cliente);

        System.out.println("Cliente alterado!");
    }
    
    public static void alterarFuncionario(){
		
        String id = JOptionPane.showInputDialog("Digite o ID do funcionario:");
	String nome = JOptionPane.showInputDialog("Digite o Nome:");
	String cpf = JOptionPane.showInputDialog("Digite o CPF:");
        String matricula = JOptionPane.showInputDialog("Digite a Matricula:");
		
	Funcionario funcionario = new Funcionario();
        funcionario.setIdfuncionario(id);
	funcionario.setNome(nome);
	funcionario.setCpf(cpf);
        funcionario.setMatricula(matricula);

	con.alteraFuncionario(funcionario);

        System.out.println("Funcionario alterado!");
    }
    
    public static void removerCliente(){

	String entrada = JOptionPane.showInputDialog("Digite o id do cliente:");
	int id = Integer.parseInt(entrada);
			
	
	con.removeCliente(id);

	System.out.println("Cliente Removido!");
    }
    
    public static void removerFuncionario(){

	String entrada = JOptionPane.showInputDialog("Digite o id do funcionario:");
	int id = Integer.parseInt(entrada);
			
	
	con.removeFuncionario(id);

	System.out.println("Funcionario Removido!");
    }
    
    
    
    public static void main(String[] args) {
        
        ConectaBD();
        
        //inserirCliente();
        //inserirFuncionario();
        //listarClientes();
        //listarFuncionarios();
        //alterarCliente();
        //alterarFuncionario();
        //removerCliente();
        //removerFuncionario();
        int x = con.getTotalClientes();
        int y = con.getTotalFuncionarios();
        
        System.out.println(x);
        System.out.println(y);
    }
    
}
