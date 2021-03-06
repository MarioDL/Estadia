/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RecepcionCuero;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author EQUIPO-PC
 */
public class PartidaDetalleCommands {
    static Statement stmt = null;
    static ResultSet rs = null;
    static ConexionBD c = new ConexionBD();
    
    
    //Método que se llama para obtener la idRecepcionCuero a eliminar
    public static int obtenerRecepcionCueroEliminar(RecepcionCuero rc) throws Exception {
        String query= "execute sp_obtRecCueroEli "+rc.getIdRecepcionCuero();
        
        int datos = 0;

        c.conectar();
        stmt = c.getConexion().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stmt.executeQuery(query);
        System.out.println(query);
        
        if (rs.last()) 
        {
            rs.beforeFirst();
            
            //Recorremos el ResultSet registro a registro
            while (rs.next()) 
            {
                datos = rs.getInt("idRecepcionCuero");
            }
        }
        
        rs.close();
        stmt.close();
        c.desconectar();
        return datos;
    }
}
