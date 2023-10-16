/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aevk.datos;

import java.util.Comparator;

/**
 *
 * @author edavi
 */
public class ArxComparator implements Comparator<Jugador> {

    @Override
    public int compare(Jugador o1, Jugador o2) {
        //para ordenar de mayor a menor
        return (int) (o2.getArx()-o1.getArx());
    }

}
