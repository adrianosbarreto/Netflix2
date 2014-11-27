/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

public abstract class Servico {
    protected double preco;

    public Servico() {
       this.preco = 0;
    }
    public Servico(final double preco) {
        setPreco(preco);
    }
    
    public abstract boolean logarServico();
    
    public void mensagemBoasVindas() {
        System.out.print("Seja Bem Vindo");
    }

    public double getPreco() {
        return preco;
    }

    public final void setPreco(double preco) {
        if ( this.preco >= 0 ) {
            this.preco = preco;
        }
        else{
            this.preco = 0;
        }
    }   
}
