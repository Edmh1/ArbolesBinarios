/*

 */
package aevk.binaryTree;


public class Nodo<E> {
    E dato; 
    Nodo<E> izq; 
    Nodo<E> der; 
      
    //constructor que solo tiene el dato
    public Nodo(E dato) {
        this.dato = dato;
    }
 
}
