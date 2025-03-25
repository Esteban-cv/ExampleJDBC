/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejdbc.controller;

import co.edu.sena.examplejdbc.model.Employee;
import java.util.List;

/**
 *date: 25/03/2025
 * @author Esteban Colorado Vargasç
 * objetivo: interface para el modelo employee
 */
public interface IEmployeeController {
    public void insert(Employee employee) throws Exception;
    public void update(Employee employee) throws Exception;
    public void delete(int id) throws Exception;
    public List<Employee> findAll() throws Exception;
    public Employee findById(long document) throws Exception;
}
