/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.model;

/**
 *date: 20/03/2025
 * @author Esteban
 * objetivo: representa la tabla employee
 */
public class Employee {
    private long document;
    private String fullName;
    private String address;
    private String phone;
    private EmployeeType employeeType;

    public Employee() {
    }

    public Employee(long document, String fullName, String address, String phone, EmployeeType employeeType) {
        this.document = document;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.employeeType = employeeType;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return fullName ;
    }
    
    
}
