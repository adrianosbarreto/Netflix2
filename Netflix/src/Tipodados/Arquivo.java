/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tipodados;

/**
 *
 * @author Adriano
 */
public abstract class Arquivo{
    protected double tamanho;

    public Arquivo(double tamanho) {
        setTamanho(tamanho);
    }
    public Arquivo(){
        this.tamanho = 0;
    }
    public Arquivo(Arquivo copiado){
        this.tamanho = copiado.tamanho;
    }
    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        if(tamanho >= 0){
            this.tamanho = tamanho;
        }
        else{
            System.out.println("Tamanho Invalido");
            this.tamanho = 0;
        }
    }

    @Override
    public String toString() {
        String s = "\nTamanho: " + this.tamanho + "\n";
        return s;
    }
    
    
    public abstract boolean abrirArquivo(Arquivo arquivo);    
        
}
