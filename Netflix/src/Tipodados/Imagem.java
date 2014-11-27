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
public class Imagem extends Arquivo implements Editavel{
    
    public int largura;
    public int altura;
    public String nome;

    public Imagem(int largura, int altura, double tamanho, String nome) {
        super(tamanho);
        setAltura(altura);
        setLargura(largura);
        setNome(nome);
    }

    public Imagem() {
        super(0);
        this.largura = 0;
        this.altura = 0;
        this.nome = "SEM NOME";
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        if (largura >= 0){
            this.largura = largura;
        }
        else{
            System.out.println("Largura Invalida");
            this.largura = 0;
        }
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        if (altura >= 0){
            this.altura = altura;
        }
        else{
            System.out.println("Altura Invalida");
            this.altura = 0;
        }
    }

    public void setNome(String nome) {
        if(nome.length() <= 25){
            this.nome = nome;
        }
        else{
            System.out.println("Nome Grande demais! Padronizando...");
            this.nome = "PADRAO";
        }
    }
    public String getNome() {
        return nome;
    }
    
    
    
    @Override
    public boolean abrirArquivo(Arquivo arquivo) {
        System.out.println( "Visualizando imagem " + ((Imagem) arquivo).nome + "..." );
        return true;
    }

    @Override
    public void editar() {
    Scanner sc = new Scanner(System.in);
    
    String nome1;

    System.out.println("Digite o Novo nome da imagem: ");
    nome1 = sc.next();
    setNome(nome1);
    }
    
    @Override
    public String toString() {
        super.toString();
        String s =  "\nNome da imagem: " + this.nome +
                    "\nDimencoes da imagem: " + this.largura + "X" + this.altura +
                    "\n";
        return s;
    }
    
    
    
}
