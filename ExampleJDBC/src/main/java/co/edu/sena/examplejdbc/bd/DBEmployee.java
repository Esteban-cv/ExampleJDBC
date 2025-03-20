/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import static co.edu.sena.examplejdbc.bd.DBConnection.connection;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.EmployeeType;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DATE: 20/03/2025
 *
 * @author Esteban Colorado Vargas Objetivo: permite consultas y transacciones
 * en la tabla employee
 */
public class DBEmployee extends DBConnection {

    public void insert(Employee employee) {
        try {
            connect();
            String sql = "INSERT INTO `employee` VALUES (?,?,?,?,?);";
            int pos = 0;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(++pos, employee.getDocument());
            preparedStatement.setString(++pos, employee.getFullName());
            preparedStatement.setString(++pos, employee.getAddress());
            preparedStatement.setString(++pos, employee.getPhone());
            preparedStatement.setInt(++pos, employee.getEmployeeType().getId()); // FK: Llave foranea
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("ERROR al insertar tipo de empleado..."
                    + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public void update(Employee employee) {
        try {
            connect();
            String sql = "UPDATE `employee` SET `fullname`= ?, `direccion`= ?, `telefono`= ?, `type_id`= ? WHERE `document`= ?";
            int pos = 0;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(++pos, employee.getFullName());
            preparedStatement.setString(++pos, employee.getAddress());
            preparedStatement.setString(++pos, employee.getPhone());
            preparedStatement.setInt(++pos, employee.getEmployeeType().getId()); // FK: Llave foranea
            preparedStatement.setLong(++pos, employee.getDocument());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("ERROR al actualizar tipo de empleado..."
                    + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public void delete(long document) {
        try {
            connect();
            String sql = "DELETE FROM `employee` WHERE `document`= ?";
            int pos = 0;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(++pos, document);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("ERROR al eliminar tipo de empleado..." + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public List<Employee> findAll() {
        List<Employee> results = new ArrayList<>();
        DBEmployeeType dBET = new DBEmployeeType();
        try {
            connect();
            String sql = "SELECT * FROM employee";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setDocument(resultSet.getLong("document"));
                employee.setFullName(resultSet.getString("fullname"));
                employee.setAddress(resultSet.getString("direccion"));
                employee.setPhone(resultSet.getString("telefono"));
                // FK - Verifica si type_id es válido
                int typeId = resultSet.getInt("type_id");
                EmployeeType employeeType = dBET.findById(typeId);
                if (employeeType != null) {
                    employee.setEmployeeType(employeeType);
                }
                results.add(employee);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("ERROR al encontrar usuarios..." + e.getMessage());
        } finally {
            disconnect();
        }
        return results;
    }

    public Employee findById(long document) {
        Employee employee = null;
        DBEmployeeType dbet = new DBEmployeeType();

        try {
            connect();
            String sql = "SELECT * FROM employee WHERE document = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, document);
            ResultSet resultSet = preparedStatement.executeQuery();

            // .next para recorrer todos los resultados
            if (resultSet.next()) {
                employee = new Employee();
                employee.setDocument(resultSet.getLong("document"));
                employee.setFullName(resultSet.getString("fullname"));
                employee.setAddress(resultSet.getString("direccion"));
                employee.setPhone(resultSet.getString("telefono"));

                //FK
                EmployeeType employeeType = dbet.findById(resultSet.getInt("type_id"));
                employee.setEmployeeType(employeeType);
            }
            resultSet.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar tipo de empleados "
                    + e.getMessage());
        } finally {
            disconnect();
        }
        return employee;
    }
}
