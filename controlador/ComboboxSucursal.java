package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.*;


public class ComboboxSucursal {

    public static void addItem(Sucursal sucursal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;

    public ComboboxSucursal() {
        
    }
    
    public ArrayList getListasSucursales(){
        System.out.println("Funcion getListasSucursales()");
        ArrayList mListaSucursales = new ArrayList();
        Sucursal sucursal = null;
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT idSucursal, nombreSucursal FROM sucursal;");
            while(rs.next()){
                sucursal = new Sucursal();
                sucursal.setIdSucursal(rs.getInt("idSucursal"));
                sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
                mListaSucursales.add(sucursal);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return mListaSucursales;
    }
}
    

