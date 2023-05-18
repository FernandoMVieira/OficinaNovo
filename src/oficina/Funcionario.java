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
public class Funcionario extends Pessoa {
    
    private String idfuncionario;
    private int matricula;

    public void setIdfuncionario(String idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getIdfuncionario() {
        return idfuncionario;
    }

    public int getMatricula() {
        return matricula;
    }
}
