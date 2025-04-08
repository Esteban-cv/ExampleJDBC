/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controller;

import co.edu.sena.examplejdbc.bd.DBEmployeeType;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;

/**
 * Date: 25/03/2025
 *
 * @author Esteban Colorado Vargas objective: implementar la interface para
 * controlar el modelo employeetype
 */
public class EmployeeTypeController implements IEmployeeTypeController {

    private DBEmployeeType dBE = new DBEmployeeType();

    @Override
    public void insert(EmployeeType employeeType) throws Exception {
        if (employeeType == null) {
            throw new Exception("el tipo de empleado es nulo...");
        }
        if ("".equals(employeeType.getDescript())) {
            throw new Exception("La descripcion es obligatoria...");
        }
        //INSERTAR
        dBE.insert(employeeType);
    }

    @Override
    public void update(EmployeeType employeeType) throws Exception {
        if (employeeType == null) {
            throw new Exception("el tipo de empleado es nulo...");
        }
        if(employeeType.getId() == 0) {
            throw new Exception("El id es obligatorio...");
        }
        if("".equals(employeeType.getDescript())) {
            throw new Exception("La descripcion es obligatoria...");
        }

        //consultar si el employeetype existe en la base de datos...
        EmployeeType employeeTypeExists = dBE.findById(employeeType.getId());
        if (employeeTypeExists == null) {
            throw new Exception("El tipo de empleado no existe...");
        }

        //ACTUALIZAR
        dBE.update(employeeType);
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        // CONSULTAR SI EL ID EXISTE EN LA BASE DE DATOS...
        EmployeeType employeeTypeExists = dBE.findById(id);
        if (employeeTypeExists == null) {
            throw new Exception("El tipo de empleado no existe...");
        }

        //ELIMINAR
        dBE.delete(id);
    }

    @Override
    public List<EmployeeType> findAll() throws Exception {
        return dBE.findAll();
    }

    @Override
    public EmployeeType findById(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        return dBE.findById(id);
    }
}
