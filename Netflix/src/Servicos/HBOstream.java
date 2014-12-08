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
import java.util.Scanner;

/**
 *
 * @author Adriano
 */
public class HBOstream extends ServicoStreaming implements Reproducao{
    
    
    private static ArrayList <Videos> filmesHBO = new ArrayList<>();
    private static ArrayList <Autenticavel> usuariosHBO = new ArrayList<>();
    private Usuario usuarioLogado;
    private boolean statusUsuario;

    public HBOstream(Usuario usuarioLogado, double preco, int taxaMaxTranferencia) {
        super(preco, taxaMaxTranferencia);
        this.usuarioLogado = usuarioLogado;
    }

    public HBOstream(Usuario usuarioLogado) {
        super(20.0, 0);
        this.usuarioLogado = usuarioLogado;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    public static ArrayList<Videos> getListaVideos() {
        return filmesHBO;
    }
    public static void mostrarListaVideos(){
        for(Videos i : filmesHBO){   
            System.out.println(i);
            //System.out.println("");
        }
    }

    public static ArrayList<Autenticavel> getUsuarios() {
        return usuariosHBO;
    }
    
    
    public static void adicionarFilmeHBO(Videos video){
        filmesHBO.add(video);
    }
    
    public final int pesquisarVideos(String nome){
        for( int i = 0; i < filmesHBO.size(); i++ ){
            if( filmesHBO.get(i).getNome().equals(nome) ){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean logarServico() {
        if( statusUsuario == false ){
            statusUsuario = true;
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
        System.out.println(" a HBO!");
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
        String novo =   "HBOSTREAM" + super.toString()+
                        this.usuarioLogado.toString();
        return novo;
    }
    
    public final int menuHBO(){
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("1 - Mostrar Lista Videos");
        System.out.println("2 - Procurar Video");
        System.out.print("Digite numero da opcao Desejada: ");
        opcao = sc.nextInt();
        
        return opcao;
    }
    
    public final int submenuHBO(){
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("1 - Reproduzir Filme");
        opcao = sc.nextInt();
        
        return opcao;
    }
    
}
