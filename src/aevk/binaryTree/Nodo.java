/*

 */
package aevk.binaryTree;
import java.io.Serializable;

public class Nodo<E> implements Serializable{
    public E dato; 
    public Nodo<E> izq; 
    public Nodo<E> der; 
      
    //constructor que solo tiene el dato
    public Nodo(E dato) {
        this.dato = dato;
    }
 
}
