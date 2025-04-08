/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.model.Record;
import java.util.List;

/**
 *
 * @author Esteban Colorado Vargas
 */
public class TestRecord {
    public static void main(String[] args) {
        DBRecord dBRecord = new DBRecord();
        DBEmployee dBEmployee = new DBEmployee();
        DBKey dBKey = new DBKey();
        Employee employee = dBEmployee.findById(1115);
        Key key = dBKey.findById(1);
        
        // INSERTAR
        Record record = new Record(9, "2025-01-26", "10:00:00", null, employee, key, "PENDIENTE");
        //dBRecord.insert(record);
        
        //Actualizar
        record = dBRecord.findById(23);
        record.setStart_time("22:00:00");
        record.setEnd_time("13:00:00");
        key = dBKey.findById(19);
        record.setKey(key);
        dBRecord.update(record);

        //ELIMINAR
        //dBRecord.delete(9);
        
        //Encontrar todos
//        List<Record> records = dBRecord.findAll();
//        for (Record e : records) {
//            System.out.println("id: " + e.getId()+ 
//                                " / Fecha Registro: " + e.getDate_Record()+ 
//                                " / Hora inicio: " + e.getStart_time() + 
//                                " / Hora final: " + e.getEnd_time() + 
//                                " / Id Empleado: " + e.getEmployeeId().getDocument() +
//                                " / Id Llave: " + e.getKey().getId() + 
//                                " / Estado: " + e.getStatus());
//        }
//        
//        System.out.println("*******************************************************");
//        
//        //Encontrar por id
//        Record record2 = dBRecord.findById(8);
//        System.out.println( "id: " + record2.getId()+ 
//                            " / Fecha Registro: " + record2.getDate_Record()+ 
//                            " / Hora inicio: " + record2.getStart_time() + 
//                            " / Hora final: " + record2.getEnd_time() + 
//                            " / Id Empleado: " + record2.getEmployeeId().getDocument() +
//                            " / Id Llave: " + record2.getKey().getId() + 
//                            " / Estado: " + record2.getStatus());
//        
    }
}
