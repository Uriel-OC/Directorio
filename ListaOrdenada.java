import java.util.Comparator;

/**
 * Clase que permite crear listas simplemente ligadas ordenadas. <br>
 * Se extienden las capacidades de la clase Lista
 * 
 * @author Gerardo Aviles Rosas
 * @version Octubre de 2020
 * @see Lista
 */

public class ListaOrdenada<T> extends Lista<T> {
  protected final Comparator prueba;

  /**
   * Constructor por parametros. <br>
   * Inicio apunta a null, lo cual significa que la Lista esta vacia
   * 
   * @param c El comparador que permite hacer el ordenamiento
   */
  public ListaOrdenada(Comparator<T> c) {
    inicio = null;
    prueba = c;
  }

  /**
   * Inserta el primer elemento de la lista. Se sobreescribe la implementaci�n de
   * Lista
   * 
   * @param valor El valor que tendra el nuevo Nodo.
   */
  @Override
  public void agregar(T dato) {
    if (estaVacia())
      inicio = new Nodo<T>(dato, inicio);
    else if (prueba.compare(dato, inicio.elemento) <= 0) // Si el elemento que llega es menor
      inicio = new Nodo<T>(dato, inicio);
    else {
      Nodo pos = inicio.siguiente;
      Nodo ant = inicio;
      while (pos != null && prueba.compare(pos.elemento, dato) <= 0) {
        ant = pos;
        pos = pos.siguiente;
      }
      ant.siguiente = new Nodo<T>(dato, pos);
    }
  }
}