/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Date: 13/03/2025
 * @author Esteban Colorado Vargas
 * objective: permite consultas y transacciones en la tabla employee_type
 */
public class DBKey extends DBConnection{
    public void insert(Key key){
        try {
            connect();
            String sql = "insert into key (name,room, count, observation) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1,key.getName());
            preparedStatement.setString(2,key.getRoom());
            preparedStatement.setInt(3, 0);
            preparedStatement.setString(4,key.getObservation());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("ERROR al insertar llave..." + e.getMessage());
        }
        finally{
            disconnect();
        }
    }
    public void update (Key key) {
        try {
            connect();
            String sql = "UPDATE `key` SET name = ? WHERE id = ? AND room = ? AND count = ? AND observation = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, key.getName());
            stmt.setInt(2, key.getId());
            stmt.setString(3, key.getRoom());
            stmt.setInt(4, key.getCount());
            stmt.setString(5, key.getObservation());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("ERROR al actualizar llave..." + e.getMessage());
        }
        finally{
            disconnect();
        }
    }
}
