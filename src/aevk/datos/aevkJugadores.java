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
    
    public void add(Jugador jugador){
        arbol.insertar(jugador);
    }

    @Override
    public String toString() {
        return "aevkJugadores{" + "arbol=" + arbol.toString() + '}';
    }
    
    public int nDeJugadores(){
        return arbol.peso();
    }
    
    public Jugador buscar(String usuario){
        return arbol.buscar(new Jugador(usuario));
    }
    
    public void eliminar(String usuario){
        arbol.eliminar(new Jugador(usuario));
    }
     
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
    
    public void hallarJugadoresPorRol(String rol){
        hallarJugadoresPorRol(arbol.getRaiz(), rol);
    }
    
    public ArrayList<Jugador> retornarListaJugadoresPorRol(){
        return jugadoresPorRol;
    }
    
}
