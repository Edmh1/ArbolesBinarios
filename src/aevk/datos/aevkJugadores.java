/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aevk.datos;

import aevk.binaryTree.Arbol;
import aevk.binaryTree.Nodo;
import java.util.ArrayList;


public class aevkJugadores {
    
    Arbol<Jugador> arbol = new Arbol<>();
    
    //añade un jugador
    public void add(Jugador jugador){
        arbol.insertar(jugador);
    }

    //Listar todos los jugadores
    @Override
    public String toString() {
        return "aevkJugadores{" + "arbol=" + arbol.toString() + '}';
    }
    
    //hallar el numero de jugadores
    public int nDeJugadores(){
        return arbol.peso();
    }
    
    //buscar un jugador por usuario
    public Jugador buscar(String usuario){
        return arbol.buscar(new Jugador(usuario));
    }
    
    //eliminar un jugador por usuario
    public void eliminar(String usuario){
        arbol.eliminar(new Jugador(usuario));
    }
     
    //hallar jugadores por rol
    ArrayList<Jugador> jugadoresPorRol = new ArrayList<>();
    private void hallarJugadoresPorRol(Nodo<Jugador> r, String rol){
        if(r != null){
            if(r.dato.getRol().equals(rol)){
                jugadoresPorRol.add(r.dato);
            }
            hallarJugadoresPorRol(r.izq, rol);
            hallarJugadoresPorRol(r.der, rol);
        }
    }
    public ArrayList<Jugador> hallarJugadoresPorRol(String rol){
        hallarJugadoresPorRol(arbol.getRaiz(), rol);
        return jugadoresPorRol;
    }
   
    
}
