/**
 *
 * @author Adriano
 */

import Servicos.Netflix;
import Servicos.Servico;
import Servicos.Youtube;
import Tipodados.Videos;
import Usuario.Usuario;
import java.util.Scanner;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opcao, flag;
        //Criando e Adicionando Usuarios ao ArraysList de Youtube e Netflix//
        //---------------------------------------------------------------//
        Usuario n1 = new Usuario("Peter","Terra do Nunca", 18, "ppan", "4321" );
        Usuario n2 = new Usuario("Maria","Casa de Doces", 12, "mariazinha", "4321" );
        Usuario n3 = new Usuario("Joao","Casa de Doces", 13, "joaozinho", "4321" );
        
        Netflix.adicionarUsuario(n1);
        Netflix.adicionarUsuario(n2);
        Netflix.adicionarUsuario(n3);
       
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
        //----------------------------------------------------------------//
        do{
            
            Usuario user = Usuario.novoUser();

            System.out.println("1 - Deseja Adquirir Servicos");
            System.out.println("2 - Fazer Logon em Servico");
            System.out.print("Digite numero da opcao Desejada: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    int opcao1;
                    System.out.println("1 - Adquirir Youtube");
                    System.out.println("2 - Adquirir Netflix");
                    System.out.print("Digite numero da opcao Desejada: ");
                    opcao1 = sc.nextInt();

                    switch (opcao1) {
                        case 1:
                            Youtube youtube = new Youtube(user, false, 0);
                            break;

                        case 2:
                            Netflix netflix;
                            if(Netflix.getNumeroAtualAparelhos() < Netflix.getNUM_MAX_APARELHOS_ONLINE()){
                                netflix = new Netflix(user, Netflix.FormaPagamento.BOLETO, true, 19.90);
                            }
                            else{
                                System.out.println("Limite de Aparelhos online");
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    int opcao2;
                    System.out.println("1 - Fazer Logon Youtube");
                    System.out.println("2 - Fazer Logon Netflix");
                    System.out.print("Digite numero da opcao Desejada: ");
                    opcao2 = sc.nextInt();

                    switch (opcao2) {
                        case 1:
                            Servico servico1 = new Youtube(user, false, 0);
                            servico1.logarServico();
                            servico1.mensagemBoasVindas();
                            switch( ((Youtube) servico1 ).menuYoutube()){
                                case 1:
                                    Youtube.mostrarListaVideos();
                                    break;
                                case 2:
                                    String nome;
                                    int numero;
                                    System.out.println("Digite nome do Filme");
                                    sc.nextLine();
                                    nome = sc.nextLine();
                                    numero = ((Youtube) servico1 ).pesquisarVideos(nome);
                                    switch( ((Youtube) servico1).submenu()){
                                        case 1:
                                            ((Youtube) servico1 ).reproduzirMidia(Youtube.getListaVideos().get(numero));
                                            break;

                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;

                        case 2:
                            Servico servico2 = new Netflix(user, Netflix.FormaPagamento.CREDITO, false, 19.90);
                            servico2.logarServico();
                            servico2.mensagemBoasVindas();
                            switch( ((Netflix) servico2).menuNetflix() ){
                                case 1:
                                    Netflix.mostrarFilmesDisponiveis();
                                    break;
                                case 2:
                                    ((Netflix) servico2).mostrarFilmesAssistidos();
                                    break;
                                case 3:
                                    String nome;
                                    int numero;
                                    System.out.println("Digite nome do Filme");
                                    sc.nextLine();
                                    nome = sc.nextLine();
                                    numero = ((Netflix) servico2).procurarFilme(nome);
                                    switch( ((Netflix) servico2).subMenu() ){
                                        case 1:
                                            ((Netflix) servico2).adicionarAMinhaLista(Netflix.getFilmesDisponiveis().get(numero));
                                            break;
                                        case 2:                                    
                                            ((Netflix) servico2).reproduzirMidia(Netflix.getFilmesDisponiveis().get(numero));
                                            break;
                                        default:
                                    }
                                    break;
                                case 4:
                                    ((Netflix) servico2).conectarAparelho();
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                    }

                default:
                    break;
            }
            System.out.println("Deseja continuar(1:sim ou 0:nao)");
            flag = sc.nextInt();
        }while(flag == 1);
    }
}
