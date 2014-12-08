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
public class ServicoNuvem extends Servico{

    public enum Franquia{
            PESSOAL(5),
            EMPRESARIAL(100);
            
            int espacoArmazenamento;
            
            Franquia(int espaco){
                this.espacoArmazenamento = espaco;
            }   
    }
    
    protected Franquia armazenamento;

    public ServicoNuvem(Franquia armazenamento, double preco) {
        super(preco);
        this.armazenamento = armazenamento;
    }
    
    public ServicoNuvem() {
        super(0);
        this.armazenamento = Franquia.PESSOAL;
    }
    
     public Franquia getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(Franquia armazenamento) {
        this.armazenamento = armazenamento;
    }
    
    @Override
    public boolean logarServico() {
        System.out.println("Logando na Nuvem...");
        return true;
    }

    @Override
    public String toString() {
        
        String novo =   super.toString() +
                        "Armazenamento: " +
                        this.armazenamento.espacoArmazenamento + "GB" ;
        
        return novo;
    }
     
}
