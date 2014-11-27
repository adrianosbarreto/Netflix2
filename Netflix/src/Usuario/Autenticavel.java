/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.ArrayList;

/**
 *
 * @author Adriano
 */
public interface Autenticavel {
    public abstract boolean autenticar(ArrayList <Autenticavel> vetor);
    
}
