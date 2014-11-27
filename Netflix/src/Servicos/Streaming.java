/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import Tipodados.Videos;

/**
 *
 * @author Adriano
 */
public interface Streaming {
    public static int TAXA_MAX_TRANFERECIA_DADOS = 4098; //em MegaBytes.
    
    public abstract boolean reproduzirMidia(Videos video);
}
