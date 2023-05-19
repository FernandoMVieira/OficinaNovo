
package oficina;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class Conecta {
    
      // a conexão com o banco de dados
    private Connection connection;
    final String DRIVER = "com.mysql.jdbc.Driver";

    public Conecta(){
    this.connection = getConnection();
    }
  
    public Connection getConnection() {
    try { 
    	Class.forName(DRIVER);
        return DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/oficina", "root", "");
        } catch (SQLException | ClassNotFoundException e) {
        throw new RuntimeException(e);
        }
    }
  
    public void adicionaCliente(Cliente cliente) {
	String sql = "insert into clientes " +
	            "(Nome,CPF)" +
	            " values (?,?)";
	try {
	    // prepared statement para inserção
	    PreparedStatement stmt = connection.prepareStatement(sql);
	    // seta os valores
	    stmt.setString(1,cliente.getNome());
	    stmt.setString(2,cliente.getCpf());
	        // executa
	    stmt.execute();
	    stmt.close();
	} catch (SQLException e) {
            throw new RuntimeException(e);
	}
    }
    
    public void adicionaFuncionario(Funcionario funcionario) {
	String sql = "insert into funcionarios " +
	            "(Nome,CPF, Matricula)" +
	            " values (?,?,?)";
	try {
	    // prepared statement para inserção
	    PreparedStatement stmt = connection.prepareStatement(sql);
	    // seta os valores
	    stmt.setString(1,funcionario.getNome());
	    stmt.setString(2,funcionario.getCpf());
            stmt.setString(3,funcionario.getMatricula());
	        // executa
	    stmt.execute();
	    stmt.close();
	} catch (SQLException e) {
            throw new RuntimeException(e);
	}
    }
    
    public List<Cliente> getListaClientes() {
	try {
	    List<Cliente> Cliente = new ArrayList<Cliente>();
	    PreparedStatement stmt = this.connection.
	        prepareStatement("select * from clientes");
	    ResultSet rs = stmt.executeQuery();
	 
	    while (rs.next()) {
	        // criando o objeto Contato
	        Cliente cliente = new Cliente();
	        cliente.setIdcliente(rs.getString("idClientes"));
	        cliente.setNome(rs.getString("Nome"));
	        cliente.setCpf(rs.getString("CPF"));

	          
	        // adicionando o objeto à lista
	        Cliente.add(cliente);
	    }
	    rs.close();
	    stmt.close();
	    return Cliente;
	} catch (SQLException e) {
	        throw new RuntimeException(e);
        }
    }
    
    public List<Funcionario> getListaFuncionarios() {
	try {
	    List<Funcionario> Funcionario = new ArrayList<Funcionario>();
	    PreparedStatement stmt = this.connection.
	        prepareStatement("select * from funcionarios");
	    ResultSet rs = stmt.executeQuery();
	 
	    while (rs.next()) {
	        // criando o objeto Contato
	        Funcionario funcionario = new Funcionario();
	        funcionario.setIdfuncionario(rs.getString("idFuncionarios"));
	        funcionario.setNome(rs.getString("Nome"));
	        funcionario.setCpf(rs.getString("CPF"));
                funcionario.setMatricula(rs.getString("Matricula"));
	          
	        // adicionando o objeto à lista
	        Funcionario.add(funcionario);
	    }
	    rs.close();
	    stmt.close();
	    return Funcionario;
	} catch (SQLException e) {
	        throw new RuntimeException(e);
        }
    }
    
    public void alteraCliente(Cliente cliente) {
	String sql = "update clientes set Nome=?, CPF=? where idClientes=?";
	 
	try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getIdcliente());
                stmt.execute();
            }
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }
    
    public void alteraFuncionario(Funcionario funcionario) {
	String sql = "update funcionarios set Nome=?, CPF=?, Matricula=?"
                +" where idFuncionarios=?";
	 
	try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getCpf());
                stmt.setString(3, funcionario.getMatricula());
                stmt.setString(4, funcionario.getIdfuncionario());
                stmt.execute();
            }
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }
    
    public void removeCliente(int id) {
	try {
            PreparedStatement stmt = connection
                .prepareStatement("delete from clientes where idClientes=?");
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void removeFuncionario(int id) {
	try {
            PreparedStatement stmt = connection
                .prepareStatement("delete from funcionarios where idFuncionarios=?");
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
  
    
    
    
    
    
    
    /*
    public void alteraCliente(Cliente cliente) {
	     String sql = "update cliente set nome=?, Cpf =?"+
	             "where idCliente=?";
           
	     try {
	         PreparedStatement stmt = connection.prepareStatement(sql);
	         stmt.setString(1,cliente.getIdcliente());
	         stmt.setString(2,cliente.getNome());
	         stmt.setString(3,cliente.getCpf());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
    
    public void alteraFuncionario(Funcionario funcionario) {
	     String sql = "update funcionario set Nome=?, Cpf=?,"+
	             "matricula=? where idfuncionario=?";
	 
	     try {
	         PreparedStatement stmt = connection.prepareStatement(sql);
	         stmt.setString(1,funcionario.getIdfuncionario());
	         stmt.setString(2,funcionario.getNome());
	         stmt.setString(3,funcionario.getCpf());
                 stmt.setInt(4,funcionario.getMatricula());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
        }
*/

    void removeFuncioanrio(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
