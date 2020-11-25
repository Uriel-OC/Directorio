/**
  * Interfaz que define las operaciones para implementar una Lista
  * @author 
  * @version Marzo de 2015
  */
interface Listable<T>{
 /**
   * Elimina la primera ocurrencia de un elemento.
   * @param e El elemento a eliminar.
   */
 void eliminar(T e);
 /**
   * Metodo que se encarga de buscar el Nodo que contenga el elemento 
   * <br>pasado como parametro. 
   * @param e El elemento a buscar.
   * @return Nodo El nodo que lo contiene, null en caso contrario
   */
 public Nodo buscar(T x);
 /**
   * Metodo que se encarga de determinar si el elemento pasado como par�metro se
   * <br>encuentra o no en la Lista.
   * @param T El elemento a buscar.
   * @return boolean true si encuentra el elemento, false en otro caso
   */
 public boolean contiene(T e);
 /**
   * Metodo que devuelve un Iterador con todos los elementos de la Lista.
   * @return Iterador con todos los elementos de la Lista.
   */
 public java.util.Iterator elementos();
 /** Metodo que determina si la Lista esta o no vacia.
   * @return boolean true si esta vacia, false en otro caso.
   */
 public boolean estaVacia();
 /**
   * Inserta un elemento al inicio de la lista.
   * @param e El elemento que se almacenar� en el nuevo Nodo.
   */
 public void agregar(T e);
 /**
   * Metodo que vacia la Lista en tiempo constante
   */
 public void limpiar();
 /**
   * Metodo que devuelve el primer Nodo de la Lista
   * @return Nodo El primer Nodo de la Lista
   */
 public Nodo primero();
 /**
   * Sustituye el valor actual de un Nodo por otro nuevo. 
   * <br>Se usa el metodo buscar para
   * <br>determinar cual es el Nodo que contiene el valor buscado.
   * @param original El valor original del Nodo.
   * @param nuevo El nuevo valor del Nodo.
   */
 public void sustituir(T orig,T nuevo);
}