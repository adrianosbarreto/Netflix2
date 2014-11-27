/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import Tipodados.Arquivo;
import Usuario.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Adriano
 */
public class Dropbox extends ServicoNuvem{
    
    private static ArrayList<Usuario> users = new ArrayList<>();
    private ArrayList<Arquivo> arquivos = new ArrayList<>();
    Usuario userlogado;
    
     public Dropbox(Usuario userlogado, Franquia armazenamento, double preco) {
        super(armazenamento, preco);
        this.userlogado = userlogado;
    }

    public Dropbox() {
        super(Franquia.PESSOAL, 0);
        this.userlogado = new Usuario() ;
    }

    public static ArrayList<Usuario> getUsers() {
        return users;
    }

    public ArrayList<Arquivo> getArquivos() {
        return arquivos;
    }
    
    public Usuario getUserlogado() {
        return userlogado;
    }

    @Override
    public boolean logarServico() {
        super.logarServico();
        System.out.println("Voce esta em Dropbox");
        return true;
    }

    @Override
    public String toString() {
        String novo =   "DROPBOX" + super.toString() +
                        this.userlogado.toString();
        
        return novo;
    }
    
}
