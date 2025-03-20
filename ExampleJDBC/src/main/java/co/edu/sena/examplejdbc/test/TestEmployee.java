/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBEmployeeType;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;

/**
 * Date: 20/03/2025
 * @author  Esteban Colorado Vargas
 * objetivo: Probar consultas y tranferencias de la tabla employee
 */
public class TestEmployee {
    public static void main(String[] args) {
        DBEmployee dBE = new DBEmployee();
        DBEmployeeType dBEmployeeType = new DBEmployeeType();
        // insertar
        EmployeeType employeeType = dBEmployeeType.findById(1);
        Employee employee = new Employee(1116070669, "Esteban Colorado Vargas",
                                        "Calle 28a #33-47", "3185551301", employeeType);
        //dBE.insert(employee);
        
        //MODIFICAR
        employee.setFullName("ELTON TITTO");
        employeeType = dBEmployeeType.findById(2);
        employee.setEmployeeType(employeeType);
        //dBE.update(employee);
        
        //ELIMINAR POR ID
        //dBE.delete(1116070669);
        
        //CONSULTAR TODOS
        List<Employee> employees = dBE.findAll();
        for (Employee e : employees) {
            System.out.println("Document: " + e.getDocument() + 
                                " / fullname: " + e.getFullName() + 
                                " / address: " + e.getAddress() + 
                                " / phone: " + e.getPhone() + 
                                " / type: " + e.getEmployeeType().getDescript());
        }
        
        //CONSULTAR POR ID
        System.out.println("*************************************************");
        Employee employee2 = dBE.findById(1000000012);
        System.out.println("Document: " + employee2.getDocument() + 
                                " / fullname: " + employee2.getFullName() + 
                                " / address: " + employee2.getAddress() + 
                                " / phone: " + employee2.getPhone() + 
                                "  type: " + employee2.getEmployeeType().getDescript());
    }
}
