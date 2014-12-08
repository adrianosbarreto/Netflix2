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
public abstract class ServicoStreaming extends Servico{
    
    protected int taxaMaxTranferencia;

    public ServicoStreaming(double preco, int taxaMaxTranferencia) {
        super(preco);
        setTaxaMaxTranferencia(taxaMaxTranferencia);
    }

    public ServicoStreaming() {
        super(0);
        this.taxaMaxTranferencia = 0;
    }
    

    public int getTaxaMaxTranferencia() {
        return taxaMaxTranferencia;
    }

    public void setTaxaMaxTranferencia(int taxaMaxTranferencia) {
        if(taxaMaxTranferencia >= 0){
            this.taxaMaxTranferencia = taxaMaxTranferencia;
        }
        else{
            System.out.println("Invalido, configurando valor para default!");
            this.taxaMaxTranferencia = 0;
        }
    }
    
    
}
