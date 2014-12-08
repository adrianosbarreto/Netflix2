/**
 *
 * @author Adriano
 */

import Servicos.Dropbox;
import Servicos.HBOstream;
import Servicos.Netflix;
import Servicos.Servico;
import Servicos.ServicoNuvem;
import Servicos.Youtube;
import Tipodados.Arquivo;
import Tipodados.Imagem;
import Tipodados.Texto;
import Tipodados.Videos;
import Usuario.Usuario;
import static Usuario.Usuario.novoUser;
import java.util.Scanner;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         
        
        Scanner sc = new Scanner(System.in);
        int opcao, flag;
        
        //.......Criando e Arquivos para adicionar ao Dropbox............//
        //---------------------------------------------------------------//
        Arquivo a1 = new Videos("Video",  2.1, Videos.Classificacao.LIVRE, 3);
        Arquivo a2 = new Imagem(2, 3, 2.1, "Imagem");
        Arquivo a3 = new Texto("Livro", 10, 0.1);
        //---------------------------------------------------------------//
        
        //Criando e Adicionando Usuarios ao ArraysList de Youtube e Netflix//
        //---------------------------------------------------------------//
        Usuario n1 = new Usuario("Peter","Terra do Nunca", 18, "ppan", "4321" );
        Usuario n2 = new Usuario("Maria","Casa de Doces", 12, "mariazinha", "4321" );
        Usuario n3 = new Usuario("Joao","Casa de Doces", 13, "joaozinho", "4321" );
        
        Netflix.adicionarUsuario(n1);
        Netflix.adicionarUsuario(n2);
        Netflix.adicionarUsuario(n3);
        
        Youtube.adicionarUsuario(n1);
        Youtube.adicionarUsuario(n2);
        Youtube.adicionarUsuario(n3);
        
        Dropbox.adicionarUsuario(n1);
        Dropbox.adicionarUsuario(n2);
        Dropbox.adicionarUsuario(n3);
        
        HBOstream.adicionarUsuario(n1);
        HBOstream.adicionarUsuario(n2);
        HBOstream.adicionarUsuario(n3);
       
        //---------------------------------------------------------------//
       
        //Criando e Adicionando Filmes ao ArraysList de Youtube e Netflix//
        //---------------------------------------------------------------//
        Videos novo1 = new Videos("As Aventuras de Pi",1.45, Videos.Classificacao.LIVRE, 2);
        Videos novo2 = new Videos("O Senhor dos Aneis", 3.20, Videos.Classificacao.MENOR12, 1.5);
        Videos novo3 = new Videos("Harry Potter", 2.15, Videos.Classificacao.MENOR16, 0.5);
        Videos novo4 = new Videos("O Robbit", 3.12, Videos.Classificacao.MENOR18, 3);

        Youtube.adicionarFilme(novo1);
        Youtube.adicionarFilme(novo2);
        Youtube.adicionarFilme(novo3);
        Youtube.adicionarFilme(novo4);
        
        Netflix.adicionarVideos(novo1);
        Netflix.adicionarVideos(novo2);
        Netflix.adicionarVideos(novo3);
        Netflix.adicionarVideos(novo4);
        
        HBOstream.adicionarFilmeHBO(novo1);
        HBOstream.adicionarFilmeHBO(novo2);
        HBOstream.adicionarFilmeHBO(novo3);
        HBOstream.adicionarFilmeHBO(novo4);
        
        //----------------------------------------------------------------//
        
        Usuario novo = novoUser();
        Servico novoservico;

        do{
            //.........................MENU............................//
            System.out.println("O que voce deseja fazer?");
            System.out.println("1-Entrar em Netflix");
            System.out.println("2-Criar conta em Netflix");
            System.out.println("3-Entrar em Youtube");
            System.out.println("4-Criar conta em Youtube");
            System.out.println("5-Entrar em Dropbox");
            System.out.println("6-Criar conta em Dropbox");
            System.out.println("7-Entrar em HBOstream");
            System.out.println("8-Criar conta em HBOstream");
            System.out.println("9-Editar Informações");
            //..........................................................//

            opcao = sc.nextInt();
            switch(opcao){
                //.........................NETFLIX............................//
                case 1: 
                    if( novo.autenticar(Netflix.getUsuarios()) ){
                        novoservico = new Netflix(novo, Netflix.FormaPagamento.DEBITO, true, 19.90);
                        ((Netflix) novoservico).setUsuarioAtual(novo);
                        System.out.println((Netflix)novoservico);
                        do{
                            switch(Netflix.menuNetflix()){
                                case 1:
                                    Netflix.mostrarFilmesDisponiveis();
                                    break;
                                case 2:
                                    ((Netflix) novoservico).mostrarFilmesAssistidos();
                                    break;
                                case 3:
                                        String nome;
                                        int numero;
                                        System.out.println("Digite nome do Filme");
                                        sc.nextLine();
                                        nome = sc.nextLine();
                                        numero = ((Netflix) novoservico).procurarFilme(nome);
                                        switch( ((Netflix) novoservico).subMenu() ){
                                            case 1:
                                                ((Netflix) novoservico).adicionarAMinhaLista(Netflix.getFilmesDisponiveis().get(numero));
                                                break;
                                            case 2:                                    
                                                ((Netflix) novoservico).reproduzirMidia(Netflix.getFilmesDisponiveis().get(numero));
                                                break;
                                            default:
                                        }
                                    break;
                                case 4:
                                    ((Netflix) novoservico).conectarAparelho();
                                    break;
                            }
                            System.out.println("Deseja continuar(1:sim ou 0:nao)");
                            flag = sc.nextInt();
                        }while(flag == 1);
                    }
                    else{
                        System.out.println("Usuario Invalido");  
                    }
                    break;
                case 2:
                    Netflix.adicionarUsuario(novo);
                    break;
                case 3:
                //.........................YOUTUBE............................//
                    if( novo.autenticar(Youtube.getUsuarios()) ){
                        novoservico = new Youtube(novo, true, 0);
                        ((Youtube) novoservico).setUsuarioLogado(novo);
                        System.out.println((Youtube)novoservico);
                        do{
                            switch( ((Youtube) novoservico ).menuYoutube()){
                                    case 1:
                                        Youtube.mostrarListaVideos();
                                        break;
                                    case 2:
                                        String nome;
                                        int numero;
                                        System.out.println("Digite nome do Filme");
                                        sc.nextLine();
                                        nome = sc.nextLine();
                                        numero = ((Youtube) novoservico ).pesquisarVideos(nome);
                                        switch( ((Youtube) novoservico).submenu()){
                                            case 1:
                                                ((Youtube) novoservico ).reproduzirMidia(Youtube.getListaVideos().get(numero));
                                                break;
                                             
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            System.out.println("Deseja continuar(1:sim ou 0:nao)");
                            flag = sc.nextInt();
                        }while(flag == 1);
                    }
                    else{

                    }

                    break;    
                case 4:
                    Youtube.adicionarUsuario(novo);
                    break;
                case 5:
                    //.........................DROPBOX............................//
                    if( novo.autenticar(Dropbox.getUsers()) ){
                        novoservico = new Dropbox(novo, ServicoNuvem.Franquia.PESSOAL, 0);
                        ((Dropbox) novoservico).setUserlogado(novo);
                        System.out.println((Dropbox)novoservico);
                        do{
                            System.out.println("1-Adicionar Arquivo");
                            System.out.println("2-Sair");
                            System.out.println("Digite a Opcao");
                            int q = sc.nextInt();
                            switch(q){
                                case 1:
                                    System.out.println("Arquivo: (Arquivo1:1, Arquivo2:2, Arquivo3:3)");
                                    System.out.println("Digite o numeo");
                                    int numero = sc.nextInt();
                                    Arquivo add = new Texto("sim", 10, 0.1);
                                    switch(numero){
                                        case 1:
                                            add = a1;
                                            break;
                                        case 2:
                                            add = a2;
                                            break;
                                        case 3:
                                            add = a3;
                                            break;    
                                    }
                                    if(add instanceof Videos){
                                        System.out.println("Adicionando Video");
                                        ((Dropbox) novoservico).adicionarArquivo(add);
                                    }
                                    else if(add instanceof Imagem){
                                        System.out.println("Adicionando Imagem");
                                        ((Dropbox) novoservico).adicionarArquivo(add);
                                    }
                                    else if(add instanceof Texto){
                                        System.out.println("Adicionando Texto");
                                        ((Dropbox) novoservico).adicionarArquivo(add);
                                    }
                                case 2:
                                    break;
                            }
                            System.out.println("Deseja continuar(1:sim ou 0:nao)");
                            flag = sc.nextInt();
                        }while(flag == 1);  
                    }
                    else{
                        System.out.println("Usuario Invalido");
                    }
                    break;
                case 6:
                    Dropbox.adicionarUsuario(novo);
                    break;
                    
                case 7:
                    //............................HBO..............................//
                    if( novo.autenticar( HBOstream.getUsuarios() ) ){
                        novoservico = new HBOstream(novo, 19, 2048);
                        ((HBOstream) novoservico).setUsuarioLogado(novo);
                        System.out.println((HBOstream)novoservico);
                        do{
                            
                            switch( ((HBOstream)novoservico).menuHBO() ){
                                case 1:
                                    HBOstream.mostrarFilmesDisponiveis();
                                    break;
                                case 2:
                                    String nome;
                                        int numero;
                                        System.out.println("Digite nome do Filme");
                                        sc.nextLine();
                                        nome = sc.nextLine();
                                        numero = ((HBOstream) novoservico ).pesquisarVideosHBO(nome);
                                        switch(((HBOstream) novoservico ).submenuHBO()){
                                            case 1:
                                                ((HBOstream) novoservico ).reproduzirMidia(HBOstream.getListaVideos().get(numero));    
                                                break;
                                            default:
                                                break;
                                        }
                                            
                                    break;
                                
                            }
                            System.out.println("Deseja continuar(1:sim ou 0:nao)");
                            flag = sc.nextInt();
                        }while(flag == 1);  
                    }
                    else{
                        System.out.println("Usuario Invalido");
                    }
                    break;
                case 8:
                    HBOstream.adicionarUsuario(novo);
                    break;
                    
                case 9:
                    System.out.println("Oque voce deseja editar?");
                    System.out.println("1-Video");
                    System.out.println("2-Usuario Atual");
                    System.out.println("Digite opcao desejada: ");
                    int opc = sc.nextInt();
                    switch (opc){
                        case 1:
                            novo1.editar();
                            Youtube.adicionarFilme(novo1);
                            Netflix.adicionarVideos(novo1);
                            HBOstream.adicionarFilmeHBO(novo1);
                            break;   
                        case 2:
                            novo.editar();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Deseja continuar(1:sim ou 0:nao)");
            flag = sc.nextInt();
        }while(flag == 1);
        
    }
}