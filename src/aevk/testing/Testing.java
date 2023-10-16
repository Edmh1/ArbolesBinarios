/*

 */
package aevk.testing;

import aevk.persistencia.Serializar;
import aevk.datos.Jugador;
import aevk.datos.AevkJugadores;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Testing {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        //recuperando los datos
        Serializar persi = new Serializar();
        AevkJugadores jugadoresAevk = persi.toGet();
        
        //haciendo las pruebas
        //2
        System.out.println("Prueba 2: "+jugadoresAevk.toString());
        //3
        System.out.println("prueba 3: "+jugadoresAevk.buscar("liam"));
        //4
        jugadoresAevk.eliminar("liam");
        System.out.println("prueba 4: "+jugadoresAevk.buscar("liam"));
        //5
        System.out.println("prueba 5: "+jugadoresAevk.nDeJugadores());
        //6
        System.out.println("prueba 6: ");
        for (Jugador jugador : jugadoresAevk.hallarJugadoresPorRol("mago")) {
            System.out.println(""+ jugador.toString()+"\n");
        }
        //7
        System.out.println("prueba 7: ");
        for (Jugador jugador : jugadoresAevk.top10ConMasDinero()) {
            System.out.println(jugador+"\n");
        }
    }
}
