/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejdbc.controller;

import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.model.Record;
import java.util.List;

/**
 * date:25/03/2025
 *
 * @author Esteban Colorado Vargas objetivo: interface para el modelo record
 */
public interface IRecordController {

    public void insert(Record record) throws Exception;

    public void update(Record record) throws Exception;

    public void delete(int id) throws Exception;

    public List<Record> findAll() throws Exception;

    public Record findById(int id) throws Exception;
}
