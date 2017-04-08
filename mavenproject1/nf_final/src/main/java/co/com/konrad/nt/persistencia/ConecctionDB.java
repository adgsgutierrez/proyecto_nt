/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.persistencia;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ADGS
 */
public class ConecctionDB {

    private final static String URL = "jdbc:mysql://localhost:3306/trimage?autoReconnect=true&useSSL=false";
    private final static String USUARIO = "root";
    private final static String CLAVE = "root2016";
    private Connection conexionBD = null;
    
    public ConecctionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al instanciar la conexion con el JDBC");
            e.printStackTrace();
        }

        try {
            this.conexionBD = null;
            this.conexionBD = (Connection) DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (SQLException e) {
            System.out.println("No se pudo generar conexion con la base de datos");
            e.printStackTrace();
        }

    }

    public ResultSet search(String Consulta) {
        ResultSet resultado = null;
        Statement st;
        try {
            System.out.println(Consulta);
            st = (Statement) this.conexionBD.createStatement();
            resultado = st.executeQuery(Consulta);
        } catch (SQLException e) {
            System.out.println("Error SQL presentado en " + e.toString());
        }
        return resultado;
    }
    
    public Boolean insert(String Consulta) {
        Boolean resultado = Boolean.FALSE;
        Statement st;
        try {
            st = (Statement) this.conexionBD.createStatement();
            resultado = st.execute(Consulta);
        } catch (SQLException e) {
            System.out.println("Error SQL presentado en " + e.toString());
        }
        return resultado;
    }

    public Connection getConexionBD() {
        return conexionBD;
    }
}