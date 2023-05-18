/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oficina;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aluno
 */
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
	String sql = "insert into cliente " +
	            "(idCliente,Nome,Cpf)" +
	            " values (?,?,?)";
	try {
	    // prepared statement para inserção
	    PreparedStatement stmt = connection.prepareStatement(sql);
	    // seta os valores
	    stmt.setString(1,cliente.getIdcliente());
	    stmt.setString(2,cliente.getNome());
	    stmt.setString(3,cliente.getCpf());
	        // executa
	    stmt.execute();
	    stmt.close();
	} catch (SQLException e) {
            throw new RuntimeException(e);
	}
    }
    
    public void adicionaFuncionario(Funcionario funcionario) {
	String sql = "insert into funcionario " +
	            "(idFuncionario,Nome,Cpf, matricula)" +
	            " values (?,?,?,?)";
	try {
	    // prepared statement para inserção
	    PreparedStatement stmt = connection.prepareStatement(sql);
	    // seta os valores
	    stmt.setString(1,funcionario.getIdfuncionario());
	    stmt.setString(2,funcionario.getNome());
	    stmt.setString(3,funcionario.getCpf());
            stmt.setInt(4,funcionario.getMatricula());
	        // executa
	    stmt.execute();
	    stmt.close();
	} catch (SQLException e) {
            throw new RuntimeException(e);
	}
    }
    
    
    
}