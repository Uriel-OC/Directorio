import java.util.Iterator;
import java.util.NoSuchElementException;
/**
  * Clase que implementa una lista simplemente ligada.
  * <br>Se implementa la interfaz Listable
  * @author Gerardo Aviles Rosas
  * @version Octubre de 2020
  */

public class Lista<T> implements Listable<T>{

 /** Nodo que representa el inicio de la Lista */
 protected Nodo inicio;

 /**
   * Constructor por omisi�n. 
   * <br>Inicio apunta a null, lo cual significa que la Lista esta vacia
   */
 public Lista(){
  inicio = null;
 }

 /** 
  * Metodo que determina si la Lista esta o no vacia.
  * @return boolean true si esta vacia, false en otro caso.
  */
 public boolean estaVacia() {
  return inicio == null;
 }

 /**
   * Metodo que vacia la Lista en tiempo constante
   */
 public void limpiar() {
   inicio = null;
 }

 /**
   * Metodo que devuelve el primer Nodo de la Lista
   * @return Nodo El primer Nodo de la Lista
   */
 public Nodo primero() {
   if(!estaVacia())
     return inicio;
   throw new NoSuchElementException("La lista no tiene elementos");
 }

  /*
   * Metodo que se encarga de buscar el Nodo que contenga el elemento 
   * <br>pasado como par�metro. 
   * @param valor El elemento a buscar.
   * @return Nodo El nodo que lo contiene, null en caso contrario
   */
 public Nodo buscar(T valor) {
   Nodo pos = inicio;
   while(pos != null && !pos.elemento.equals(valor))
     pos = pos.siguiente;
   return pos;
 }
 
 /**
   * Metodo que se encarga de determinar si el elemento pasado como parametro se
   * <br>encuentra o no en la Lista.
   * @param valor El elemento a buscar.
   * @return boolean true si encuentra el elemento, false en otro caso
   */
 public boolean contiene(T valor){
   return buscar(valor) != null;
 }

 /**
   * Sustituye el valor actual de un Nodo por otro nuevo. 
   * <br>Se usa el m�todo buscar para
   * <br>determinar cual es el Nodo que contiene el valor buscado.
   * @param original El valor original del Nodo.
   * @param nuevo El nuevo valor del Nodo.
   */
 public void sustituir(T original, T nuevo) {
  Nodo n = buscar(original);
  if (n != null)
   n = new Nodo<T>(nuevo,n.siguiente);
  else
   throw new NoSuchElementException("No se puede sustituir el objeto " +
                                                     nuevo);
 }

 /**
   * Inserta el primer elemento de la lista.
   * @param valor El valor que tendra el nuevo Nodo.
   */
 public void agregar(T valor) {
   inicio = new Nodo<T>(valor,inicio);
 }

 /**
   * Elimina la primera ocurrencia de un elemento.
   * @param valor El dato a eliminar.
   */
 public void eliminar(T valor) {
   Nodo pos,anterior = null;
   pos = inicio;
   anterior = null;
   while(pos != null && !pos.elemento.equals(valor)) {
     anterior = pos;
     pos = pos.siguiente;
   }
   if (pos == null) return; // No lo encontr�
   if(pos == inicio) // Es el inicio de la lista
     inicio = inicio.siguiente;
   else
     anterior.siguiente = pos.siguiente;
 }

 /**
   * Metodo que devuelve un Iterador con todos los elementos de la Lista.
   * @return Iterador con todos los elementos de la Lista.
   */
 public Iterator elementos() {
   return new MiIterador();
 }

 private class MiIterador implements Iterator {
   private Nodo posicion;
   public MiIterador(){
     posicion = inicio;
   }
   public boolean hasNext() { 
     return posicion != null;
   }
   public T next() throws NoSuchElementException {
     if (hasNext()) {
       @SuppressWarnings("unchecked") T o = (T)posicion.elemento;
       posicion = posicion.siguiente;
       return o;
     }
     throw new NoSuchElementException();
   }
   
   public void remove() {
     throw new IllegalStateException();
   }
 }
}