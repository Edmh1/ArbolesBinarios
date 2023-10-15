/*

 */
package aevk.binaryTree;


public class Arbol<E extends Comparable> {
    private Nodo<E> raiz;  
    
    //agrega un objeto al arbol
    public void insertar(E x){
        Nodo<E> nuevo = new Nodo<>(x); 
        if(raiz == null){
            raiz = nuevo; 
        }else{
            insertar(raiz, nuevo);
        }
    }
    private void insertar(Nodo<E> r, Nodo<E> nuevo) {
        if(nuevo.dato.compareTo(r.dato)<0){ 
            if(r.izq == null){
                r.izq = nuevo; 
            }else{
                insertar(r.izq, nuevo);
            }
        }else{
            if(nuevo.dato.compareTo(r.dato)>0){  
                if(r.der == null){
                    r.der = nuevo; 
                }else{
                    insertar(r.der, nuevo);
                }
            }  
        }
    }
    
    //imprime los objetos del arbol
    @Override
    public String toString() {
        return inorden(raiz);
    }
    private String inorden(Nodo<E> r) {
        if(r == null){
            return "";
        }
        else{
            return inorden(r.izq)+"\n"+ r.dato.toString()+"\n" +inorden(r.der);
        }
    }
    
    //numero de objetos en el arbol
    public int peso(){
        return peso(raiz);
    }
    private int peso(Nodo<E> r){
        if(r == null){
            return 0;
        }
        else{
            return 1 + peso(r.izq) + peso(r.der);
        }
    }
    
    //Altura del arbol
    public int altura(){
        return altura(raiz);
    }
    private int altura(Nodo<E> r) {
        if(r == null){
            return 0;
        }
        else{
            return 1 + Integer.max(altura(r.izq),altura(r.der));
        }
    }
    
    //buscar returna el objeto
    public E buscar(E x){
        if(raiz==null){
            return null;
        }else{
            return buscar(raiz,x);
        }
    }
    private E buscar(Nodo<E> r, E x) {
        if(r.dato.compareTo(x) == 0){
            return r.dato;
        }else{
            if(x.compareTo(r.dato)<0){
                if(r.izq==null)
                    return null;
                else
                    return buscar(r.izq, x);
            }else{
                //aqui
                if(r.der==null)
                    return null;
                else
                    return buscar(r.der, x);
            }
        }
    }
    
    
    //eliminar
    public void eliminar(E x){
        if(buscar(x)!= null){
            raiz= eliminar(raiz,x);
        }
    }
    private Nodo<E> eliminar(Nodo<E> r, E x) {
        if(r.dato.compareTo(x)== 0){
            return borrar(r);
        }else{
            if(x.compareTo(r.dato)< 0){ // x< r
                r.izq=eliminar(r.izq, x);
            }else{
                r.der=eliminar(r.der, x);
            }
            return r;
        }
    }
    private E mayor(Nodo<E> r){
        if(r.der==null)
            return r.dato;
        else
            return mayor(r.der);
    }
    private Nodo<E> borrar(Nodo<E> r) {
        if(r.izq==null && r.der==null){ //hoja
            return null;
        }else{
            if(r.der==null){ //no tiene derecho
                return r.izq;
            }else{
                if(r.izq==null){ //no tiene izq
                    return r.der;
                }else{ // tiene 2 hijos
                    E may = mayor(r.izq);
                    r.dato = may;
                    r.izq = eliminar(r.izq, may);
                    return r;
                }
            }
        }
    }

    
    
   public Nodo<E> getRaiz(){
       return raiz;
   }
    
    
    
    
}
