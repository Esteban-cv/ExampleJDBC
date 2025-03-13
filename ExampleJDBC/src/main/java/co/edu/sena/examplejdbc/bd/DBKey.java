/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import static co.edu.sena.examplejdbc.bd.DBConnection.statement;
import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 13/03/2025
 * @author Esteban Colorado Vargas
 * objective: permite consultas y transacciones en la tabla employee_type
 */
public class DBKey extends DBConnection{
    public void insert(Key key){
        try {
            connect();
            String sql = "insert into `key` (name,room, count, observation) values(?,?,?,?)";
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
            String sql = "UPDATE `key` SET name = ?, room = ?, count = ?, observation = ? WHERE id = ?"; // la clave primaria por lo general va en el where
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, key.getName());
            stmt.setString(2, key.getRoom());
            stmt.setInt(3, key.getCount());
            stmt.setString(4, key.getObservation());
            stmt.setInt(5, key.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("ERROR al actualizar llave..." + e.getMessage());
        }
        finally{
            disconnect();
        }
    }
    
    public void delete (int id) {
        try {
            connect();
            String sql = "delete from `key` where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("ERROR al intentar eliminar a un usuario..."
                    + e.getMessage());
        }
        finally {
            disconnect();
        }
    } 
    
    public List<Key> findAll () {
        List<Key> results = new ArrayList<>();
        try {
            connect();
            String sql = "select * from `key`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                Key key = new Key();
                key.setId(resultSet.getInt("id"));
                key.setName(resultSet.getString("name"));
                key.setRoom(resultSet.getString("room"));
                key.setCount(resultSet.getInt("count"));
                key.setObservation(resultSet.getString("observation"));
                results.add(key);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("ERROR al realizar la consulta..." 
                    + e.getMessage());
        }
        finally {
            disconnect();
        }
        return results;
    }
    
    public Key findById (int id) {
        Key key = null;
        try {
            connect();
            String sql = "select * from `key` where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            
            if (resultSet.next()){
                key = new Key();
                key.setId(resultSet.getInt("id"));
                key.setName(resultSet.getString("name"));
                key.setRoom(resultSet.getString("room"));
                key.setCount(resultSet.getInt("count"));
                key.setObservation(resultSet.getString("observation"));
            }
            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("ERROR al realizar la consulta por id..." 
                    + e.getMessage());
        }
        finally {
            disconnect();
        }
        return key;
    
    }
}
