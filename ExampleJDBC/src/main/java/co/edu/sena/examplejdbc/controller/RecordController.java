/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controller;

import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.model.Record;
import java.util.List;

/**
 * date: 25/03/2025
 *
 * @author Esteban Colorado Vargas objetivo:implementar la interface para
 * controlar el modelo record
 */
public class RecordController implements IRecordController {

    private DBRecord dBR = new DBRecord();

    @Override
    public void insert(Record record) throws Exception {
        if ("".equals(record.getDate_Record())) {
            throw new Exception("La fecha de registro es obligatoria");
        }
        if ("".equals(record.getStart_time())) {
            throw new Exception("La fecha de inicio de registro es obligatoria");
        }
        //FK
        if (record.getEmployeeId() == null) {
            throw new Exception("El id del empleado es obligatorio");
        }
        //FK
        if (record.getKey() == null) {
            throw new Exception("El id de la llave es obligatorio");
        }
        if ("".equals(record.getStatus())) {
            throw new Exception("El estado es obligatorio...");
        }
        Record recordExists = dBR.findById(record.getId());
        if (recordExists != null) {
            throw new Exception("El id del registro ya existe");
        }
        dBR.insert(record);
    }

    @Override
    public void update(Record record) throws Exception {
        if (record == null) {
            throw new Exception("El registro es nulo.");
        }
        if (record.getId() == 0) {
            throw new Exception("El ID no puede ser 0.");
        }
        if ("".equals(record.getDate_Record())) {
            throw new Exception("La fecha de registro es obligatoria.");
        }
        if ("".equals(record.getStart_time())) {
            throw new Exception("La hora de inicio es obligatoria.");
        }
        // FK
        if (record.getEmployeeId() == null) {
            throw new Exception("El ID del empleado es obligatorio.");
        }
        // FK
        if (record.getKey() == null) {
            throw new Exception("El ID de la llave es obligatorio.");
        }
        if ("".equals(record.getStatus())) {
            throw new Exception("El estado es obligatorio.");
        }
        Record recordExists = dBR.findById(record.getId());
        if (recordExists != null) {
            throw new Exception("Ya existe un registro con ese id");
        }
        dBR.update(record);
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El id a eliminar no debe ser 0...");
        }
        Record recordExists = dBR.findById(id);
        if (recordExists == null) {
            throw new Exception("no existe un registro con ese id");
        }
        dBR.delete(id);
    }

    @Override
    public List<Record> findAll() throws Exception {
        return dBR.findAll();
    }

    @Override
    public Record findById(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El id a buscar no puede ser 0");
        }
        return dBR.findById(id);
    }
}
