/*

 */
package aevk.binaryTree;


public class Nodo<E> {
    public E dato; 
    public Nodo<E> izq; 
    public Nodo<E> der; 
      
    //constructor que solo tiene el dato
    public Nodo(E dato) {
        this.dato = dato;
    }
 
}
