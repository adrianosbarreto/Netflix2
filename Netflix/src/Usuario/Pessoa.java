/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Servicos.Servico;
import java.util.List;

/**
 *
 * @author Adriano
 */
public class Pessoa {
    protected String nome;
    protected String endereco;
    protected int idade;
    protected List <Servico> listaServicos;

    public Pessoa() {
        this.nome = "Sem Nome";
        this.endereco = "Sem Endereço";
        this.idade = 0;
    }
    

    public Pessoa(String nome, String endereco, int idade) {
        this.nome = nome;
        this.endereco = endereco;
        setIdade(idade);
    }
    
    protected boolean adquirirServico( Servico servico ){
        
        for ( Servico listaServico : listaServicos ) {
            if (servico == listaServico) {
                return false;
            }
        }
        listaServicos.add(servico);
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        if ( nome.length() <= 25 ){
            this.nome = nome;
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if ( endereco.length() <= 40 ){
            this.endereco = endereco;
        }
        else {
            System.out.println("Endereço Invalido!");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if( idade > 0 && idade <= 130 ){
            this.idade = idade;
        }
    }

    @Override
    public String toString() {
        String novo =   "\nNome: " + this.nome +
                        "\nIdade: " + this.idade +
                        "\nEndereco: " + this.endereco;
        return novo;
    }
    
    
}
