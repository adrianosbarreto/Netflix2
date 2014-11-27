/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Servicos.Editavel;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adriano
 */
public class Usuario extends Pessoa implements Autenticavel, Editavel{
    
    private String nomeUsuario;
    private String senha;
    
    public Usuario() {
        super();
        this.nomeUsuario = "Sem Nome";
        this.senha = "1234";
    }
    
    public Usuario(String nome, String endereco, int idade, String nomeUsuario, String senha) {
        super(nome, endereco, idade);
        //this.nomeUsuario = nomeUsuario;
        setNomeUsuario(nomeUsuario);
        setSenha(senha);
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        if(nomeUsuario.length() <= 15){
            this.nomeUsuario = nomeUsuario;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha.length() >= 4 ){
            this.senha = senha;
        }
        else{
            System.out.println("Senha invalida");
            this.senha = "1234";
        }
    }

    public static Usuario novoUser(){
        Scanner sc = new Scanner(System.in);
        String nome1;
        String endereco1;
        String nomeUser1;
        String senha1;
        int idade1;

        System.out.println("Digite seu nome: ");
        nome1 = sc.next();
        System.out.println("Digite sua Idade: ");
        idade1 = sc.nextInt();
        sc.nextLine(); //Limpa o Buffer.
        System.out.println("Digite seu Endereço: ");
        endereco1 = sc.nextLine();
        System.out.println("Digite seu Nome de Usuario: ");
        nomeUser1 = sc.next();
        System.out.println("Digite sua Senha");
        senha1 = sc.next();
        
        
        
        return new Usuario(nome1, endereco1, idade1, nomeUser1, senha1);     
    }
    
    @Override
    public String toString() {
        
        String novo =   super.toString() + "\nNome Usuario: " + this.nomeUsuario;
        
        return novo;
    }
    
    
    
    
    
    
    @Override
    public boolean autenticar(ArrayList <Autenticavel> vetor) {
        for (Autenticavel vetor1 : vetor) {
            if (this.equals((Usuario) vetor1)) {
                return true;
            }
        } 
        return false;
    }

    @Override
    public boolean equals(Object objeto) {

        if( objeto instanceof Usuario ){
            Usuario user = (Usuario) objeto;
    
            return ( (this.senha.equals(user.senha))
                    && (this.nomeUsuario.equals(user.nomeUsuario)) );
        }
        else{
            return false;
        }
    }

    @Override
    public void editar() {
    Scanner sc = new Scanner(System.in);
        String nome1;
        String endereco1;
        String nomeUser1;
        String senha1;
        int idade1;

        System.out.println("Digite seu nome: ");
        nome1 = sc.next();
        setNome(nome1);
        
        System.out.println("Digite sua Idade: ");
        setIdade(idade);

        sc.nextLine(); //Limpa o Buffer.
        System.out.println("Digite seu Endereço: ");
        endereco1 = sc.nextLine();
        setEndereco(endereco1);

        System.out.println("Digite seu Nome de Usuario: ");
        nomeUser1 = sc.nextLine();
        setNomeUsuario(nomeUser1);

        System.out.println("Digite sua Senha");
        senha1 = sc.next();
        setSenha(senha1);
    }


    
    
}

