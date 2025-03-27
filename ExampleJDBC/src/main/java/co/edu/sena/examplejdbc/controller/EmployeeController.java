/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controller;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.model.Employee;
import java.util.List;

/**
 * date: 25/03/2025
 * @author Esteban Colorado Vargas objetivo: implementar la interface para
 * controlar el modelo employee
 */
public class EmployeeController implements IEmployeeController {

    private DBEmployee dBE = new DBEmployee();

    @Override
    public void insert(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("El empleado es nulo...");
        }
        if (employee.getDocument() == 0) {
            throw new Exception("El documento del empleado no puede ser 0...");
        }
        if ("".equals(employee.getFullName())) {
            throw new Exception("el nombre es obligatorio...");
        }
        if ("".equals(employee.getAddress())) {
            throw new Exception("la direccion es obligatoria...");
        }
        if ("".equals(employee.getPhone())) {
            throw new Exception("El telefono es obligatorio...");
        }
        //FK
        if (employee.getEmployeeType() == null) {
            throw new Exception("El tipo de empleado es obligatorio");
        }
        //FK
        Employee employeeExists = dBE.findById(employee.getDocument());
        if (employeeExists != null) {
            throw new Exception("ya existe un empleado con ese documento...");
        }
        dBE.insert(employee);
    }

    @Override
    public void update(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("El empleado es nulo...");
        }
        if (employee.getDocument() == 0) {
            throw new Exception("El documento del empleado no puede ser 0...");
        }
        if ("".equals(employee.getFullName())) {
            throw new Exception("el nombre es obligatorio...");
        }
//        if ("".equals(employee.getAddress())) {
//            throw new Exception("la direccion es obligatoria...");
//        }
//        if ("".equals(employee.getPhone())) {
//            throw new Exception("El telefono es obligatorio...");
//        }
        //FK
        if (employee.getEmployeeType() == null) {
            throw new Exception("El tipo de empleado es obligatorio");
        }
        //FK
        Employee employeeExists = dBE.findById(employee.getDocument());
        if (employeeExists == null) {
            throw new Exception("no existe el empleado...");
        }

        dBE.update(employee);
    }

    @Override
    public void delete(Long document) throws Exception {
        if (document == 0) {
            throw new Exception("El documento es obligatorio...");
        }
        Employee employeeExists = dBE.findById(document);
        if (employeeExists == null) {
            throw new Exception("no existe el empleado...");
        }
        dBE.delete(document);
    }

    @Override
    public List<Employee> findAll() throws Exception {
        return dBE.findAll();
    }

    @Override
    public Employee findById(long document) throws Exception {
        if (document == 0) {
            throw new Exception("el documento es obligatorio...");
        }
        return dBE.findById(document);
    }
}
