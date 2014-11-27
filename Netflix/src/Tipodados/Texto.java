/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tipodados;

import Servicos.Editavel;
import java.util.Scanner;

/**
 *
 * @author Adriano
 */
public class Texto extends Arquivo implements Editavel{
    
    String titulo;
    int numeroLinhas;

    public Texto(String titulo, int numeroLinhas, double tamanho) {
        super(tamanho);
        setNumeroLinhas(numeroLinhas);
        setTamanho(tamanho);
    }

    public Texto() {
        super(0);
        this.titulo = "sem titulo";
        this.numeroLinhas = 0;
    }

    public void setTitulo(String titulo) {
        if(titulo.length() <= 30){
            this.titulo = titulo;
        }
        else{
            System.out.println("Titulo Invalido!");
            this.titulo = "Sem Titulo";
        }
    }

    public void setNumeroLinhas(int numeroLinhas) {
        if(numeroLinhas >= 0){
            this.numeroLinhas = numeroLinhas;
        }
        else{
            System.out.println("Numero Invalido(nao pode ser negativo)");
            this.numeroLinhas = 0;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNumeroLinhas() {
        return numeroLinhas;
    }
    
    public boolean ler(){
        System.out.println("Lendo " + this.titulo);
        return true;
    }
    
    @Override
    public boolean abrirArquivo(Arquivo arquivo) {
        System.out.println( "Visualizando Texto " + ((Texto) arquivo).titulo + "..." );
        return true;
    }

    @Override
    public void editar() {
    Scanner sc = new Scanner(System.in);
    
    String nome1;
    int linhas;

    System.out.println("Digite o Novo nome da imagem: ");
    nome1 = sc.next();
    setTitulo(nome1);
    System.out.println("Digite o numero de linhas do documento: ");
    linhas = sc.nextInt();
    setNumeroLinhas(linhas);
    
    }
    @Override
    public String toString() {
        super.toString();
        String s =  "Titulo: " + this.titulo+
                    "\nNumero de Linhas: " + this.numeroLinhas +
                    "\n";
        return s;
    }
    
}
