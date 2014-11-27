/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import Tipodados.Videos;
import Usuario.Autenticavel;
import Usuario.Usuario;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Adriano
 */
public class Youtube extends Servico implements Streaming{
    private boolean status;
    private static ArrayList<Autenticavel> usuarios = new ArrayList<>();
    private static ArrayList<Videos> listaVideos = new ArrayList<>();
    Usuario usuarioLogado;

    public Youtube(Usuario userlogado, boolean status, double preco) {
        super(preco);
        this.usuarioLogado = userlogado;
        this.status = status;
    }
    public Youtube(){
        super(0);
        this.usuarioLogado = new Usuario();
        this.status = false;
    }
    public static ArrayList<Videos> getListaVideos() {
        return listaVideos;
    }
    public static void mostrarListaVideos(){
        for(Videos i : listaVideos){   
            System.out.println(i);
            System.out.println("");
        }
    }
    
    public static void adicionarFilme(Videos video){
        listaVideos.add(video);
    }

    public final int pesquisarVideos(String nome){
        for( int i = 0; i < listaVideos.size(); i++ ){
            if( listaVideos.get(i).getNome().equals(nome) ){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean logarServico() {
        if( status == false ){
            status = true;
            System.out.println(this.usuarioLogado);
        }
        else{
            System.out.println("Usuario já está Logado!");
            System.out.println(this.usuarioLogado);
        }
        
        return true;
    }
    
    @Override
    public void mensagemBoasVindas() {
        super.mensagemBoasVindas();
        System.out.println(" ao YouTube!");
    }

    @Override 
    public boolean reproduzirMidia(Videos video) {            
        if (video.getClassificacao() <= usuarioLogado.getIdade()){
            System.out.println("Carregando Video...");
            System.out.println("Video " + video.getNome() + "em reprodução");
            System.out.println("Fim do video!");
            return true;
        }
        else{
            System.out.println("Fora da classificação Indicativa");
            return false;
        }        
    }

    @Override
    public String toString() {
        String novo =   "YOUTUBE" + super.toString()+
                        this.usuarioLogado.toString();
        return novo;
    }
    
    public final int menuYoutube(){
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("1 - Mostrar Lista Videos");
        System.out.println("2 - Procurar Video");
        System.out.print("Digite numero da opcao Desejada: ");
        opcao = sc.nextInt();
        
        return opcao;
    }
    
    public final int submenu(){
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("1 - Reproduzir Filme");
        opcao = sc.nextInt();
        
        return opcao;
    }
    public void reproduzirAleatorio( ArrayList<Videos> lista){
        Random aleatorio = new Random();
        ArrayList<Integer> vetor = new ArrayList<>();
        Integer numero;
        
        
        for (Videos lista1 : lista) {
            do{
                numero = aleatorio.nextInt(lista.size());
                vetor.contains(numero);
            }while(vetor.contains(numero));
            vetor.add(numero);
        }
        for (int i = 0; i < lista.size(); i++) {
            reproduzirMidia(lista.get(vetor.get(i)));
        }  
    }
    
    public static void adicionarUsuario(Usuario user){
        usuarios.add(user);
    }
    
}

