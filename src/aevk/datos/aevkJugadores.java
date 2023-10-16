/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aevk.datos;

import aevk.binaryTree.Arbol;
import aevk.binaryTree.Nodo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AevkJugadores implements Serializable{
    
    Arbol<Jugador> arbol = new Arbol<>();
    
    //1.añade un jugador
    public void add(Jugador jugador){
        arbol.insertar(jugador);
    }

    //2.Listar todos los jugadores
    @Override
    public String toString() {
        return "aevkJugadores{" + "arbol=" + arbol.toString() + '}';
    }
    
    //3.hallar el numero de jugadores
    public int nDeJugadores(){
        return arbol.peso();
    }
    
    //4.buscar un jugador por usuario
    public Jugador buscar(String usuario){
        return arbol.buscar(new Jugador(usuario));
    }
    
    //5.eliminar un jugador por usuario
    public void eliminar(String usuario){
        arbol.eliminar(new Jugador(usuario));
    }
     
    //6.hallar jugadores por rol
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
   
    //7.Listar los 10 jugadores con más dinero
    public ArrayList<Jugador> top10ConMasDinero() {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        recopilarJugadores(arbol.getRaiz(), listaJugadores);

        // Ordenar la lista de jugadores por dinero de manera descendente
        Collections.sort(listaJugadores, new ArxComparator());

        // Tomar los primeros 10 jugadores con más dinero o todos si hay menos de 10
        int top = Math.min(10, listaJugadores.size());
        ArrayList<Jugador> top10 = new ArrayList<>(top);
        for (int i = 0; i < top; i++) {
            top10.add(listaJugadores.get(i));
        }
        return top10;
    }
    private void recopilarJugadores(Nodo<Jugador> r, List<Jugador> listaJugadores) {
        if (r != null) {
            listaJugadores.add(r.dato);
            recopilarJugadores(r.izq, listaJugadores);
            recopilarJugadores(r.der, listaJugadores);
        }
    }

    
    
    
}
