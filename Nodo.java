/**
 * Clase que implementa un Nodo como un elemento de una Lista Ligada.
 * 
 * @author Gerardo Aviles Rosas
 * @version Octubre de 2020
 */

public class Nodo<T> {
  public T elemento;
  public Nodo siguiente;

  /**
   * Constructor que recibe como parametro el valor que contendra el nuevo Nodo.
   * <br>
   * <b>siguiente<b> se inicializa en null.
   * 
   * @param valor Elemento que tendra el nuevo Nodo
   */
  public Nodo(T valor) {
    this(valor, null);
  }

  /**
   * Constructor que recibe como parametros el valor del nuevo Nodo y el siguiente
   * Nodo en la Lista que sucedera al nuevo Nodo.
   * 
   * @param valor Elemento que tendra el nuevo nodo
   * @param n     Indica el Nodo siguiente
   */
  public Nodo(T valor, Nodo n) {
    elemento = valor;
    siguiente = n;
  }
}