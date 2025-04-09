/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.model;

/**
 *Date: 20/03/2025
 * @author Esteban Colorado Vargas
 * objetivo: representa la tabla record
 */
public class Record {
    private int id;
    private String date_Record;
    private String start_time;
    private String end_time;
    private Employee employeeId;
    private KeyRoom key;
    private String status;

    public Record() {
    }

    public Record(int id, String date_Record, String start_time, String end_time, Employee employeeId, KeyRoom key, String status) {
        this.id = id;
        this.date_Record = date_Record;
        this.start_time = start_time;
        this.end_time = end_time;
        this.employeeId = employeeId;
        this.key = key;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_Record() {
        return date_Record;
    }

    public void setDate_Record(String date_Record) {
        this.date_Record = date_Record;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public KeyRoom getKey() {
        return key;
    }

    public void setKey(KeyRoom key) {
        this.key = key;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    } 

    @Override
    public String toString() {
        return "" +key ;
    }

    
}
