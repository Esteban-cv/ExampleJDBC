/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Date: 13/03/2025
 *
 * @author Esteban Colorado Vargas objective: Clase principal para conexion a
 * base de datos.
 */
public class DBConnection {
    public static Connection connection;
    public static Statement statement;
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB = "bdkeys";
    private final String USER = "developer";
    private final String PASSWORD = "developer";

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB, USER, PASSWORD);
            statement = connection.createStatement();
            System.out.println("Concetado");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            MessageUtils.showErrorMessage("Erro de conexion a la base de datos...");
        }
    }

    public void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            System.out.println("Desconectado");
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("ERROR desconectandose de la base de datos...");
        }
    }
}
