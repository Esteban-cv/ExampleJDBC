/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBEmployeeType;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;

/**
 * Date: 13/03/2025
 * @author Esteban Colorado Vargas
 * OBJECTIVE: Probar consultas/transacciones en tabla employee_type.
 */
public class TestEmployeeType {
    public static void main(String[] args) {
        DBEmployeeType dBEmployeeType = new DBEmployeeType();
        // INSERTAR
        EmployeeType employeeType = new EmployeeType(6,"SUBDIRECTOR");
        //dBEmployeeType.insert(employeeType);
        // ACTUALIZAR
        //employeeType.setId(1);
        //employeeType.setDescript("COORDINADOR");
        //dBEmployeeType.update(employeeType);
        // ELIMINAR
        //dBEmployeeType.delete(5);
        // CONSULTAR TODOS
        List<EmployeeType> listEmployeeType = dBEmployeeType.findAll();
        for (EmployeeType e : listEmployeeType) {
            System.out.println("id: " + e.getId()+" / descript: " + e.getDescript());
        }
        
        // CONSULTAR POR ID
        System.out.println("****************************************************");
        EmployeeType employeeType1 = dBEmployeeType.findById(30);
        if (employeeType1 != null){
            System.out.println("id: " + employeeType1.getId() + " / Descript: " 
                +employeeType1.getDescript());
        }
        else {
            System.out.println("No existe el EmployeeType con ese id...");
        }
    }
}
