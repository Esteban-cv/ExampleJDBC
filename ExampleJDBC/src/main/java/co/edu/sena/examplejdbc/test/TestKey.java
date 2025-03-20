/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;

/**
 * date : 13/03/2025
 * @author Esteban Colorado Vargas
 * objective: Probar consultas/transacciones en tabla key.
 */
public class TestKey {
    public static void main(String[] args) {
        DBKey dBKey = new DBKey();
        // INSERTAR 
        Key key = new Key(5, "BICENTENARIO", "Sala 203", 2, "llavero con dos llaves blancas");
        //dBKey.insert(key); CORRECTO
        // ACTUALIZAR
        //key.setId(5);
        //key.setName("sis sisisisisis");
        //key.setRoom("si");
        //key.setCount(2);
        //key.setObservation("si");
        //dBKey.update(key);
        // ELIMINAR
        //dBKey.delete(5);
        //List<Key> listKey = dBKey.findAll();
        //for (Key e : listKey) {
        //    System.out.println("id: " + e.getId() 
        //            + " / Nombre: " + e.getName()
        //            + " / Sala: " + e.getRoom()
        //            + " / Conteo: " + e.getCount()
        //            + " / Observación: " + e.getObservation());
        //}
        
        //System.out.println("*********************************************");
        
        //Key key1 = dBKey.findById(4);
        //if (key1 != null){
        //    System.out.println("id: " + key1.getId() 
        //            + " / Nombre: " + key1.getName()
        //            + " / Sala: " + key1.getRoom()
        //          + " / Conteo: " + key1.getCount()
        //          + " / Observación: " + key1.getObservation());
        //}
    }
}
