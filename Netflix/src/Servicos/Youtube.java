/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import Tipodados.Videos;
import Usuario.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adriano
 */
public class Youtube extends Servico implements Streaming{
    private boolean status;
    private Usuario usuario;
    private static ArrayList<Videos> listaVideos = new ArrayList<>();

    public Youtube(boolean status, Usuario usuario, double preco) {
        super(preco);
        this.status = status;
        this.usuario = usuario;
    }
    public Youtube(){
        super(0);
        usuario = new Usuario();
        this.status = true;
    }
    public static void mostrarListaVideos(){
        for(Videos sim : listaVideos){
          sim.aboutVideo();
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
            usuario.aboutUser();
        }
        else{
            System.out.println("Usuario já está Logado!");
            usuario.aboutUser();
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
        if (video.getClassificacao() <= usuario.getIdade()){
            System.out.println("Carregando Video...");
            System.out.println("Video " + video.getNome() + "em reprodução");
            return true;
        }
        else{
            System.out.println("Fora da classificação Indicativa");
            return false;
        }        
    } 
    public final void aboutYouTube(){
        usuario.aboutUser();
        if(status == true){
            System.out.println("Status: Logado");
        }
        else{
            System.out.println("Status: off");
        }
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

    public static ArrayList<Videos> getListaVideos() {
        return listaVideos;
    }
    
    
    public final int submenu(){
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("1 - Reproduzir Filme");
        opcao = sc.nextInt();
        
        return opcao;
    }
    
}

