import java.util.Scanner;
import static java.lang.System.*;

public class Directorio {
  private Contacto contactos[];
  private int na, i;
  private Scanner lector;
  private Scanner lector1;

  public Directorio() {
    this(20);
  }

  public Directorio(int n) {
    contactos = new Contacto[(n < 0) ? 20 : n];// Me mamo ese seguro aqui
    na = 0;
    lector = new Scanner(in);
    lector1 = new Scanner(in).useDelimiter("\n");
  }

  public boolean estaVacio() {
    return na == 0;
  }

  public boolean estaLleno() {
    return na == contactos.length;
  }

  public void agregar(Contacto c) {
    if (estaLleno())
      crecerArreglo(1);
    contactos[na++] = c;
  }

  public void eliminarN(String nombre) {
    boolean borro = false;
    if (!estaVacio()) {
      for (i = 0; i < na; i++) {
        if (nombre.equals(contactos[i].getNombre())) {
          if (i == (na - 1))
            na--;
          else
            contactos[i] = contactos[--na];
          borro = true;
          out.println("Contacto eliminado con exito!");
          break;

        }
      }
      if (i == na && !borro)
        out.println("El Contacto con nombre: " + nombre + " no existe!\n");
    } else
      out.println("No hay articulos almacenados\n");
  }

  public void eliminarTodos(String nombre) {
    boolean borro = false;
    if (!estaVacio()) {
      do {
        for (i = 0; i < na; i++)
          if (nombre.equals(contactos[i].getNombre())) {
            if (i == (na - 1))
              na--;
            else
              contactos[i] = contactos[--na];
            borro = true;
            break;
          }
      } while (contieneN(nombre));
      if (borro)
        out.println("Se elimino al menos un Contacto");
      else
        out.println("No existe ningun Contacto con el nombre " + nombre + "\n");
    } else
      out.println("No hay Contactos almacenados\n");
  }

  public void mostrarN(String nombre) {
    String con = "";
    if (!estaVacio()) {
      for (i = 0; i < na; i++)
        if (nombre.equals(contactos[i].getNombre())) {
          out.println(contactos[i]);
          break;
        }
      if (con.equals(""))
        out.println("No existe un Contacto con el nombre " + nombre + "\n");
    } else
      out.println("No hay Contactos almacenados\n");
  }

  public void mostrarNC(String nombre, char cat) {
    if (!estaVacio() && contieneN(nombre)) {
      for (i = 0; i < na; i++)
        if (nombre.equals(contactos[i].getNombre()))
          switch (cat) {
            case 'a':
              if (contactos[i] instanceof Amigo)
                out.println(((Amigo) contactos[i]).toString());
              break;
            case 'f':
              if (contactos[i] instanceof Familiar)
                out.println(((Familiar) contactos[i]).toString());
              break;
            case 'c':
              if (contactos[i] instanceof Cliente)
                out.println(((Cliente) contactos[i]).toString());
              break;
            default:
              break;
          }
    } else
      out.println("\nNo se encontraron resultados de la busqueda\n"); // No se si sea necesario
  }

  public void mostrarFT() {
    String ft = "";
    if (!estaVacio())
      for (i = 0; i < na; i++) {
        if (contactos[i] instanceof Amigo)
          if (!((Amigo) contactos[i]).getFacebook().equals("") || !((Amigo) contactos[i]).getTwitter().equals(""))
            ft += ((Amigo) contactos[i]).toString();
      }
    if (ft.equals(""))
      out.println("\nNo hay amigos con Facebook o Twitter que mostrar :(\n");
    else
      out.println("\n*******AMIGOS CON FACEBOOK o TWITTER*******\n" + ft);
  }

  public void mostrarCo() {
    String amigos = "";
    String clientes = "";
    if (!estaVacio()) {
      for (int i = 0; i < na; i++) {
        if (contactos[i] instanceof Amigo && !((Amigo) contactos[i]).getCorreo().equals(""))
          amigos += ((Amigo) contactos[i]).toString();
        if (contactos[i] instanceof Cliente && !((Cliente) contactos[i]).getCorreo().equals(""))
          clientes += ((Cliente) contactos[i]).toString();
      }
    }
    if (amigos.equals(""))
      out.println("\nNo hay amigos que mostrar :(\n");
    else {
      out.println("\n*******AMIGOS********\n");
      out.println(amigos);
    }
    if (clientes.equals(""))
      out.println("\nNo hay clientes que mostrar :(\n");
    else {
      out.println("\n********CLIENTES*******\n" + clientes);
    }
  }

  public void mostrarComp(String compania) {
    String clientes = "";
    if (!estaVacio()) {
      Contacto copia[] = ordenarAsc(contactos, new ComparaNombre()); // Ordenar alfabeticamente
      for (int i = 0; i < na; i++) {
        if (copia[i] instanceof Cliente && ((Cliente) copia[i]).getCompania().equalsIgnoreCase(compania)) {
          clientes += ((Cliente) copia[i]).toString();
        }
      }
    }
    if (clientes.equals(""))
      out.println("\nNo hay clientes que mostrar :(\n");
    else
      out.println("\nClientes de la compania" + compania + ":\n" + clientes);
  }

  //Al chile este se me hace una mamada pero segun me acuerdo hay que usar el comparator
  public static <T> T[] ordenarAsc(T contactos[], java.util.Comparator<T> cmp) {
    T orden[] = contactos;
    for (int i = 0; i < orden.length; i++)
      for (int j = i + 1; j < orden.length; j++)
        if (cmp.compare(contactos[i], contactos[j]) > 0) { // Los datos estan desordenados
          T temp = orden[i]; // por tanto los intercambia
          orden[i] = orden[j];
          orden[j] = temp;
        }
    return orden;
  }

  private void crecerArreglo(int n) {
    int nuevoTam = contactos.length + n;
    Contacto cont[] = new Contacto[nuevoTam];
    for (i = 0; i < contactos.length; i++) {
      cont[i] = contactos[i];
    }
    contactos = cont;
  }

  private boolean contieneN(String nombre) {
    boolean respuesta = false;
    if (!estaVacio())
      for (i = 0; i < na; i++)
        if (nombre.equals(contactos[i].getNombre())) {
          respuesta = true;
          break;
        }
    return respuesta;
  }

}
