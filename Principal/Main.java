package Principal;
import Vistas.*;
import modelo.*;

public class Main {

    
    public static void main(String[] args) {
        //Se crea la instanacia de la VISTA Login
        Login login= new Login();
        // El metodo setVisible hace visible la ventana
        login.setVisible(true);
        
        //Crear instancia de la clase Conexion
        Conexion conexion = new Conexion();
        conexion.getConnection();
    }
    
}
