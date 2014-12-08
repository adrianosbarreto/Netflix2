/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

/**
 *
 * @author Adriano
 */
import Tipodados.Videos;
import Usuario.Autenticavel;
import Usuario.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adriano
 */
public class Netflix extends ServicoStreaming implements Reproducao {

    public enum FormaPagamento{
        CREDITO,
        DEBITO,
        BOLETO;
    }
    
    private static final int NUM_MAX_APARELHOS_ONLINE = 4;
    private static int numeroAtualAparelhos = 0;
    private static ArrayList <Videos> filmesDisponiveis = new ArrayList<>();
    private static ArrayList <Autenticavel> usuarios = new ArrayList<>();
    private ArrayList <Videos> filmesAssistidos = new ArrayList<>();
    private ArrayList <Videos> minhaLista = new ArrayList<>();
    private Usuario usuarioAtual;
    private FormaPagamento formaPagamento;
    private boolean status;

    public Netflix(Usuario cliente, FormaPagamento forma, boolean status, double preco) {
        super(preco, 1024);
        this.usuarioAtual = cliente;
        this.status = status;
        this.setNumeroAtualAparelhos();
        formaPagamento = forma;
    }

    public Netflix() {
        super(19.90, 1024);
        this.usuarioAtual = new Usuario();
        this.formaPagamento = FormaPagamento.BOLETO;
        this.setNumeroAtualAparelhos();
        this.status = false;
        
    }

    public static ArrayList<Autenticavel> getUsuarios() {
        return usuarios;
    }
    
    
    public static int getNumeroAtualAparelhos() {
        return numeroAtualAparelhos;
    }

    public final void setNumeroAtualAparelhos() {
        if (numeroAtualAparelhos < Netflix.NUM_MAX_APARELHOS_ONLINE){
            numeroAtualAparelhos++;
        }
    }
 
    public ArrayList<Videos> getFilmesAssistidos() {
        return filmesAssistidos;
    }

    public ArrayList<Videos> getMinhaLista() {
        return minhaLista;
    }

    public Usuario getCliente() {
        return usuarioAtual;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
            this.formaPagamento = formaPagamento;
    }
    
    public boolean adicionarAMinhaLista(Videos video){
        if(!this.minhaLista.contains(video)){
            this.minhaLista.add(video);
            return true;
        }
        else{
            System.out.println("Minha Lista já contem esse Video");
            return false;
        }  
    }

    public static int getNUM_MAX_APARELHOS_ONLINE() {
        return NUM_MAX_APARELHOS_ONLINE;
    }
    
    public static void adicionarUsuario(Usuario user){
        usuarios.add(user);
    }
    
    public static void adicionarVideos(Videos video){
        filmesDisponiveis.add(video);
    }

    public void setUsuarioAtual(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }
    
    
    public static void mostrarFilmesDisponiveis(){
        for(Videos i : filmesDisponiveis){
            System.out.println(i);
            System.out.println("");
        }
    }

    public static ArrayList<Videos> getFilmesDisponiveis() {
        return filmesDisponiveis;
    }
    
    
    public void mostrarFilmesAssistidos(){
        for(Videos i : this.filmesAssistidos ){
            System.out.println(i);
            System.out.println("");
        }
    }
    public final int procurarFilme(String nomeFilme){
        for( int i = 0; i < filmesDisponiveis.size(); i++ ){
            if (filmesDisponiveis.get(i).getNome().equals(nomeFilme)){
                return i;
            }
        }
        return -1;
    }
    public boolean conectarAparelho(){
        if(numeroAtualAparelhos < Netflix.NUM_MAX_APARELHOS_ONLINE){
            numeroAtualAparelhos++;
            System.out.println("Aparelho Conetado");
            return true;
        }
        else{
            return false;  
        }
    }
    
    @Override
    public boolean logarServico() {
        if( status == false ){
            status = true;
            System.out.println(usuarioAtual);
        }
        else{
            System.out.println("Usuario já está Logado!");
           System.out.println(usuarioAtual);
        }
        
        return true;
    }
    
    @Override
    public void mensagemBoasVindas() {
        super.mensagemBoasVindas();
        System.out.println(" à Netflix");
    }

    @Override 
    public boolean reproduzirMidia( Videos video ) {            
        if (video.getClassificacao() <= usuarioAtual.getIdade()){
            System.out.println("Carregando Video...");
            System.out.println("Video " + video.getNome() + " em reprodução");
            this.filmesAssistidos.add(video);
            return true;
        }
        else{
            System.out.println("Fora da classificação Indicativa");
            return false;
        }        
    }
    public static int menuNetflix(){
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("\n1 - Mostrar Filmes Disponiveis");
        System.out.println("2 - Mostrar Filmes Assistidos");
        System.out.println("3 - Procurar Filme");
        System.out.println("4 - Conectar Aparelho");
        
        System.out.print("Digite numero da opcao Desejada: ");
        opcao = sc.nextInt();
        
        return opcao;
    }
    public final int subMenu(){
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("\n1 - Adicionar à Minha Lista");
        System.out.println("2 - Reproduzir Filme");
        opcao = sc.nextInt();
        
        return opcao;
    }
    @Override
    public String toString() {
        String novo =   "NETFLIX\n" + super.toString() +
                        this.usuarioAtual.toString();
        
        return novo;
    }
    
    
}
