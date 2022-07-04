package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    //Crear instancia clase Connection
    Connection connection;
    //Atributos
    String driver = "com.mysql.cj.jdbc.Driver";
    String cadenaConexion = "jdbc:mysql://localhost:3306/reto1_ar";
    String usuario = "root";
    String contrasena ="";
    //Añadir el constructor sin argumentos de la clase
    public Conexion(){
        //Intentar conectar con la base de datos
        try{
            Class.forName(driver);
            connection=DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            //Verificar si la conexion devuelve algo
            if(connection!= null){
                System.out.println("Conexión exitosa con la base de datos");
            }
        }
        catch(ClassNotFoundException|SQLException e){
            System.out.println("No se pudo establecer conexión con la base de datos");
        }
    }
    //Crear funcion que retorna la clase Connection
    public Connection getConnection(){
        return connection;
    }
}
