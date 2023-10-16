/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aevk.persistencia;

import aevk.datos.AevkJugadores;
import aevk.datos.Jugador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author edavi
 */
public class DatosDefault {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        AevkJugadores jugadoresAevk = new AevkJugadores();
        
        //agregando 15 jugadores por default 
        //prueba 1:
//        jugadoresAevk.add(new Jugador("Alex", "mago", 12, 2300.5, 15, 65));
//        jugadoresAevk.add(new Jugador("Emily", "ladron", 8, 980.7, 4, 29));
//        jugadoresAevk.add(new Jugador("Liam", "luchador", 19, 3345.2, 27, 92));
//        jugadoresAevk.add(new Jugador("Chloe", "mago", 3, 610.1, 8, 41));
//        jugadoresAevk.add(new Jugador("Mason", "ladron", 5, 745.9, 10, 54));
//        jugadoresAevk.add(new Jugador("Olivia", "luchador", 18, 4025.3, 24, 87));
//        jugadoresAevk.add(new Jugador("Ethan", "mago", 14, 2731.8, 20, 76));
//        jugadoresAevk.add(new Jugador("Ava", "ladron", 7, 856.4, 13, 61));
//        jugadoresAevk.add(new Jugador("Noah", "luchador", 16, 3702.6, 22, 79));
//        jugadoresAevk.add(new Jugador("Ella", "mago", 10, 1548.9, 16, 72));
//        jugadoresAevk.add(new Jugador("James", "ladron", 11, 1876.2, 19, 68));
//        jugadoresAevk.add(new Jugador("Mia", "luchador", 20, 4923.7, 28, 97));
//        jugadoresAevk.add(new Jugador("Jacob", "mago", 6, 701.4, 11, 50));
//        jugadoresAevk.add(new Jugador("Lily", "ladron", 1, 512.8, 3, 22));
//        jugadoresAevk.add(new Jugador("Benjamin", "luchador", 17, 3479.5, 25, 88));
        
         // Serializar y guardar los jugadores
        Serializar persi = new Serializar();
        persi.save(jugadoresAevk);

//        // Recuperar y mostrar los jugadores
//        if(new File("jugadores.data").exists()){
//            AevkJugadores recuperar = persi.toGet();
//            System.out.println(" " + recuperar.toString());
//        }
        
    }
}
