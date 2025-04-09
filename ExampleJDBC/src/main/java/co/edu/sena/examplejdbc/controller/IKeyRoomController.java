/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejdbc.controller;

import co.edu.sena.examplejdbc.model.KeyRoom;
import java.util.List;

/**
 * date : 25/03/2025
 * @author Esteban Colorado Vargas
 * objetivo:interface para el modelo key
 */
public interface IKeyRoomController {
    public void insert(KeyRoom key) throws Exception;
    public void update(KeyRoom key) throws Exception;
    public void delete(int id) throws Exception;
    public List<KeyRoom> findAll() throws Exception;
    public KeyRoom findById(int id) throws Exception;
}
