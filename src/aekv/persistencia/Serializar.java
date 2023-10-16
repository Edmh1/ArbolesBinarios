/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aekv.persistencia;

import aevk.datos.AevkJugadores;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author ESTUDIANTE
 */
public class Serializar {
    
    public void save(AevkJugadores jugadores) throws FileNotFoundException, IOException{
        FileOutputStream file = new FileOutputStream("jugadores.data");
        ObjectOutputStream output = new ObjectOutputStream(file);
        output.writeObject(jugadores);
        output.close();
        file.close();
    }
    
    public AevkJugadores toGet() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream file = new FileInputStream("jugadores.data");
        ObjectInputStream input = new ObjectInputStream(file);
        AevkJugadores ob = (AevkJugadores) input.readObject();
        
        input.close();
        file.close();
        return ob;
    }
    
}

