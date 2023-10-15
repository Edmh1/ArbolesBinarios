/*

 */
package aevk.testing;

import aevk.datos.Jugador;
import aevk.datos.aevkJugadores;


public class Testing {
    public static void main(String[] args) {
         
        aevkJugadores jugadoresAevk = new aevkJugadores();
        
        jugadoresAevk.add(new Jugador("eddie", "mago", 15, 2000, 100, 200));
        jugadoresAevk.add(new Jugador("andres", "ladron", 1, -10, 1, 200));
        jugadoresAevk.add(new Jugador("vladimir", "luchador", 25, 100, 100, 200));
        jugadoresAevk.add(new Jugador("kevin", "mago", 15, 500, 100, 200));
        
        System.out.println(""+jugadoresAevk.toString());
        
        System.out.println(""+jugadoresAevk.buscar("andres"));
        jugadoresAevk.eliminar("andres");
        System.out.println("aqioooooooooo"+jugadoresAevk.toString());
        System.out.println(""+jugadoresAevk.nDeJugadores());
        
        jugadoresAevk.hallarJugadoresPorRol("mago");
        System.out.println("\njugadores por rol: " + jugadoresAevk.retornarListaJugadoresPorRol());
        
    }
}
