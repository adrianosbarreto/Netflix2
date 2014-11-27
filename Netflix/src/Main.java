
import Usuario.Autenticavel;
import Usuario.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Adriano
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Sim");
        Autenticavel novo = new Usuario("Adriano","endereco", 18, "adbarreto", "4321" ); 
        //Usuario user = new Usuario("Adriano","endereco", 18, "ADBARRETO", "4321" );
        //Usuario user1 = new Usuario("Adriano","endereco", 18, "ADBARRETO", "4321" );
        
        System.out.println( (Usuario) novo );
    }
    
}
