/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author usuario
 */
public class usuário {
    
    public enum tipoacesso{
        aluno,
        professor,
        bibliotecario,
        admin
    };
    
    private int id_usuário;
    private tipoacesso tipo;
    private String nome_completo;
    private String email;
    private int cpf;
    private int celular;
    private int celular_reserva;
    private String endereco;
    private String complemento;
    private int cep;
    private String senha;

    public int getId_usuário() {
        return id_usuário;
    }

    public void setId_usuário(int id_usuário) {
        this.id_usuário = id_usuário;
    }

    public tipoacesso getTipo() {
        return tipo;
    }

    public void setTipo(tipoacesso tipo) {
        this.tipo = tipo;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getCelular_reserva() {
        return celular_reserva;
    }

    public void setCelular_reserva(int celular_reserva) {
        this.celular_reserva = celular_reserva;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
           
}
