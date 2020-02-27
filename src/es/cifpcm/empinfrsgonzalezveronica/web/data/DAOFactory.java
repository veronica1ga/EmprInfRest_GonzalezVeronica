/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.empinfrsgonzalezveronica.web.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Veronica Gonzalez
 */
public class DAOFactory {
	private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private Connection connection;

    public DAOFactory() {
    }

    public Connection getConexion() {
        try {
            dbUrl = "jdbc:mysql://localhost:3306/empresasinformaticas?profileSQL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            dbUser = "2daw";
            dbPassword = "2daw2019";
            String driverClassName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverClassName);

            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
