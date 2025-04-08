/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controller;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 * date: 25/03/2025
 * @author Esteban Colorado Vargas
 * objetivo: implementar la interface para controlar el modelo key
 */
public class KeyController implements IKeyController{
    
    private DBKey dBK = new DBKey();

    @Override
    public void insert(Key key) throws Exception {
        if("".equals(key.getName())) {
            throw new Exception("El nombre es obligatorio...");
        }
        if("".equals(key.getRoom())) {
            throw new Exception("La sala es obligatoria...");
        }
        if(key.getCount() < 1) {
            throw new Exception("La cantidad no puede ser 0...");
        }
        // insertar
        dBK.insert(key);
    }

    @Override
    public void update(Key key) throws Exception {
        if(key == null) {
            throw new Exception("La llave es nula...");
        }
        if(key.getId() == 0) {
            throw new Exception("El id de la llave no puede ser 0...");
        }
        if("".equals(key.getName())) {
            throw new Exception("El nombre no puede estar vacio...");
        }
        if("".equals(key.getRoom())) {
            throw new Exception("La sala no puede estar vacia...");
        }
        if(key.getCount() < 1) {
            throw new Exception("La cantidad de llaves debe ser mayor a 0...");
        }
        Key keyExists = dBK.findById(key.getId());
        if (keyExists == null) {
            throw new Exception("no existe la llave...");
        }
        //actualizar
        dBK.update(key);
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El documento es obligatorio...");
        }
        Key keyExists = dBK.findById(id);
        if (keyExists == null) {
            throw new Exception("no existe la llave...");
        }
        //eliminar
        dBK.delete(id);
    }

    @Override
    public List<Key> findAll() throws Exception {
        return dBK.findAll();
    }

    @Override
    public Key findById(int id) throws Exception {
        if(id == 0) {
            throw new Exception("El id es obligatorio");
        }
        return dBK.findById(id);
    }
    
}
