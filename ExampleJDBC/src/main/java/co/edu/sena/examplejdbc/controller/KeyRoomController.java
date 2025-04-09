/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controller;

import co.edu.sena.examplejdbc.bd.DBKeyRoom;
import co.edu.sena.examplejdbc.model.KeyRoom;
import java.util.List;

/**
 * date: 25/03/2025
 * @author Esteban Colorado Vargas
 * objetivo: implementar la interface para controlar el modelo key
 */
public class KeyRoomController implements IKeyRoomController{
    
    private DBKeyRoom dBK = new DBKeyRoom();

    @Override
    public void insert(KeyRoom keyRoom) throws Exception {
        if("".equals(keyRoom.getName())) {
            throw new Exception("El nombre es obligatorio...");
        }
        if("".equals(keyRoom.getRoom())) {
            throw new Exception("La sala es obligatoria...");
        }
        if(keyRoom.getCount() < 1) {
            throw new Exception("La cantidad no puede ser 0...");
        }
        // insertar
        dBK.insert(keyRoom);
    }

    @Override
    public void update(KeyRoom keyRoom) throws Exception {
        if(keyRoom == null) {
            throw new Exception("La llave es nula...");
        }
        if(keyRoom.getId() == 0) {
            throw new Exception("El id de la llave no puede ser 0...");
        }
        if("".equals(keyRoom.getName())) {
            throw new Exception("El nombre no puede estar vacio...");
        }
        if("".equals(keyRoom.getRoom())) {
            throw new Exception("La sala no puede estar vacia...");
        }
        if(keyRoom.getCount() < 1) {
            throw new Exception("La cantidad de llaves debe ser mayor a 0...");
        }
        KeyRoom keyExists = dBK.findById(keyRoom.getId());
        if (keyExists == null) {
            throw new Exception("no existe la llave...");
        }
        //actualizar
        dBK.update(keyRoom);
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El documento es obligatorio...");
        }
        KeyRoom keyExists = dBK.findById(id);
        if (keyExists == null) {
            throw new Exception("no existe la llave...");
        }
        //eliminar
        dBK.delete(id);
    }

    @Override
    public List<KeyRoom> findAll() throws Exception {
        return dBK.findAll();
    }

    @Override
    public KeyRoom findById(int id) throws Exception {
        if(id == 0) {
            throw new Exception("El id es obligatorio");
        }
        return dBK.findById(id);
    }
    
}
