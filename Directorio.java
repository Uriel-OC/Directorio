import java.util.*;
import static java.lang.System.*;

//Importando bibliotecas necesarias para la ListaOrdenada
import java.util.Iterator;

//Importando bibliotecas necesarias para algunos parametros
import java.time.*;
import java.util.regex.*;

/**
 * Clase que se encarga de modelar todas las opciones de un Directorio de
 * Contactos
 *
 * @author Cruz Barrios Luis Alberto
 * @author Flores Molina Alfredo
 * @author Fernandez Neria Montserrat
 * @author Maya Sanchez Andrea Fernanda
 * @author Ortiz Covarrubias Andres Uriel
 * @author Lopez Espindola Luis Enrique
 * @version Noviembre 2020
 */
public class Directorio {
  private ListaOrdenada<Contacto> contactos;
  private int dayOfMonth, year, month;
  private Scanner lector;
  private Scanner lector1;
  Pattern pat;
  Matcher mat;

  /**
   * Constructor por omision <br>
   * Construye una ListaOrdenada para almacenar los Contactos
   */
  public Directorio() {
    contactos = new ListaOrdenada<>(new ComparaNombre());
    lector = new Scanner(in);
    lector1 = new Scanner(in).useDelimiter("\n");
  }

  /**
   * Metodo para saber si la ListaOrdenada de Contactos esta vacia
   *
   * @return boolean true si esta vacio, false en caso contrario
   */
  public boolean estaVacio() {
    return contactos.estaVacia();
  }

  /**
   * Metodo para agregar un Contacto
   *
   * @param contacto El contacto que se va a agregar
   */
  public void agregar(Contacto c) {
    contactos.agregar(c);
  }

  /**
   * Metodo para eliminar el primer Contacto con el nombre dado
   * 
   * @param nomnre El nombre del contacto a eliminar
   */
  public void eliminarN(String nombre) {
    boolean borro = false;
    if (!estaVacio()) {
      Nodo pos = contactos.inicio;
      while (pos != null) {
        Contacto cont = (Contacto) pos.elemento;
        if (cont.getNombre().equals(nombre)) {
          contactos.eliminar(cont);
          borro = true;
          out.println("Contacto eliminado con exito!");
          break;
        }
        pos = pos.siguiente;
      }
      if (!borro)
        out.println("El Contacto con nombre: " + nombre + " no existe!\n");
    } else
      out.println("No hay articulos almacenados\n");
  }

  /**
   * Metodo que elimina todos los contactos almacenados
   */
  public void eliminarTodos() {
    if (!estaVacio()) {
      contactos.limpiar();
      out.println("Se eliminaron todos los contactos");
    } else
      out.println("No hay Contactos almacenados\n");
  }

  /**
   * Metodo que elimina todos los contactos con el mismo nombre
   * 
   * @param nombre El nombre de los contactos a eliminar
   */
  public void eliminarTodosN(String nombre) {
    boolean borro = false;
    if (!estaVacio()) {
      Iterator it = contactos.elementos();
      do {
        Contacto con = (Contacto) it.next();
        if (con.getNombre().equals(nombre)) {
          contactos.eliminar(con);
          borro = true;
          it = contactos.elementos(); // No es toy muy seguro si hay que reinciar el iterador, pero asi jala chido
          // Podemos probarlo sin reiniciar el iterador
        }
      } while (it.hasNext());
      if (borro)
        out.println("Contactos eliminado con exito!");
      else
        out.println("No existe ningun Contacto con el nombre " + nombre + "\n");
    } else
      out.println("No hay Contactos almacenados\n");
  }

  /**
   * Metodo que muestra un contacto con el nombre dado
   * 
   * @param nombre El nombre del contacto
   */
  public void mostrarN(String nombre) {// Aqui se da solo la primer coincidencia,
    // Eso es lo que hay que decidir
    String con = "";
    if (!estaVacio()) {
      Nodo pos = contactos.inicio;
      while (pos != null) {
        Contacto cont = (Contacto) pos.elemento;
        if (cont.getNombre().equals(nombre)) {
          con = cont.toString();
          out.println("\n******** Resultado de la busqueda **********\n" + con);
          break;
        }
        pos = pos.siguiente;
      }
      if (con.equals(""))
        out.println("No existe un Contacto con el nombre " + nombre + "\n");
    } else
      out.println("No hay Contactos almacenados\n");
  }

  /**
   * Metodo que muestra a un contacto dado su nombre y categoria
   * 
   * @param nombre El nombre del ontacto
   * @param cat    La categoria del contacto
   */
  public void mostrarNC(String nombre, char cat) {// Aqui creo que habría un error porque no mostraria solo la primer
                                                  // coincidencia, si hay dos amigos/clientes/Fam con el mismo nombre
                                                  // creo que haria pero luego checo si solo debe dar la primer
                                                  // coincidencia
                                                  // mueck
    // Despues lo checho
    if (!estaVacio() && contieneN(nombre)) {
      String con = "";
      Iterator it = contactos.elementos();
      while (it.hasNext()) {
        Contacto cont = (Contacto) it.next();
        switch (cat) {
          case 'a':
            if (cont instanceof Amigo && cont.getNombre().equals(nombre))
              con += ((Amigo) cont).toString() + "**********\n";
            break;
          case 'f':
            if (cont instanceof Familiar && cont.getNombre().equals(nombre))
              con += ((Familiar) cont).toString() + "**********\n";
            break;
          case 'c':
            if (cont instanceof Cliente && cont.getNombre().equals(nombre))
              con += ((Cliente) cont).toString() + "**********\n";
            break;
          default:
            break;
        }
      }
      out.println("\n****** Resulatado de Busqueda********\n" + con);
    } else
      out.println("No se encontraron resultados de la busqueda\n");
    // No se si sea necesario
  }

  /**
   * Metodo que muestra a todos los contactos con Facebook y/o Twitter
   */
  public void mostrarFT() {
    String ft = "";
    if (!estaVacio()) {
      Iterator it = contactos.elementos();
      while (it.hasNext()) {
        Contacto cont = (Contacto) it.next();
        if (cont instanceof Amigo)
          if (!((Amigo) cont).getFacebook().equals("") || !((Amigo) cont).getTwitter().equals(""))
            ft += ((Amigo) cont).toString();
      }
    }
    if (ft.equals(""))
      out.println("No hay amigos con Facebook o Twitter que mostrar :(\n");
    else
      out.println("\n*******AMIGOS CON FACEBOOK o TWITTER*******\n" + ft);
  }

  /**
   * Metodo que muestra todos los contactos con correo
   */
  public void mostrarCo() {
    String amigos = "";
    String clientes = "";
    if (!estaVacio()) {
      Iterator it = contactos.elementos();
      while (it.hasNext()) {
        Contacto cont = (Contacto) it.next();
        if (cont instanceof Amigo && !((Amigo) cont).getCorreo().equals(""))
          amigos += ((Amigo) cont).toString() + "\n**************\n";
        if (cont instanceof Cliente && !((Cliente) cont).getCorreo().equals(""))
          clientes += ((Cliente) cont).toString() + "\n**************\n";
      }
    }
    if (amigos.equals(""))
      out.println("No hay amigos que mostrar :(\n");
    else {
      out.println("*******AMIGOS********\n" + amigos);
    }
    if (clientes.equals(""))
      out.println("No hay clientes que mostrar :(\n");
    else {
      out.println("********CLIENTES*******\n" + clientes);
    }
  }

  /**
   * Metodo que muestra todos los clientes de una compania
   * 
   * @param compania La compania de los clientes
   */
  public void mostrarComp(String compania) {
    String clientes = "";
    if (!estaVacio()) {
      Nodo pos = contactos.inicio;
      while (pos != null) {
        Contacto cont = (Contacto) pos.elemento;
        if (cont instanceof Cliente && ((Cliente) cont).getCompania().equalsIgnoreCase(compania))
          clientes += ((Cliente) cont).toString() + "\n***************\n";
        pos = pos.siguiente;
      }
    }
    if (clientes.equals(""))
      out.println("\nNo hay clientes que mostrar :(\n");
    else
      out.println("\nClientes de la compania: " + compania.toUpperCase() + ":\n" + clientes);
  }

  /**
   * Metodo que muestra a todos los clientes de una categoria
   * 
   * @param cat La categoria de los clientes
   */
  public void mostrarDet(char cat) {
    String[] t = { "AMIGOS", "FAMILIARES", "CLIENTES" };
    String det = "";
    if (!estaVacio()) { // Si hay contactos
      Nodo pos = contactos.inicio;
      while (pos != null) {
        Contacto cont = (Contacto) pos.elemento;
        switch (cat) {
          case 'A': // Es un Amigo
            if (cont instanceof Amigo)// Lo encontro
              det += ((Amigo) cont).toString() + "\n********************\n";
            break;
          case 'F': // Es un Familiar
            if (cont instanceof Familiar)// Lo encontro
              det += ((Familiar) cont).toString() + "\n********************\n";
            break;
          case 'C': // Es un Cliente
            if (cont instanceof Cliente)// Lo encontro
              det += ((Cliente) cont).toString() + "\n********************\n";
            break;
          default:
            break;
        }// Fin switch
        pos = pos.siguiente;
      }
      for (int i = 0; i < t.length; i++) {
        if (cat == (t[i].charAt(0)) && det.equals(""))
          out.println("No hay '" + t[i] + "' que mostrar\n");
        if (cat == (t[i].charAt(0)))
          out.println("******" + t[i] + "********\n" + det);
      }
    } // Fin if(!estaVacio)
    else
      out.println("No hay contactos que mostrar");
  }

  /**
   * Metodo que muestra un contacto dado su telefono
   * 
   * @param t El telefono del contacto
   */
  public void mostrarNum(long t) {
    String con = "";
    if (!estaVacio()) {
      Nodo pos = contactos.inicio;
      while (pos != null) {
        Contacto cont = (Contacto) pos.elemento;
        if (t == cont.getTelefono()) {
          con = cont.toString();
          out.println("\nResultado de la busqueda: \n" + con);
          break;
        }
      }
      if (con.equals(""))
        out.println("No existe un Contacto con el telefono " + t + "\n");
    } else
      out.println("No hay Contactos almacenados\n");
  }

  /**
   * Metodo que muestra toda la informacion almacenada
   * 
   * @return String Todos los Contactos almacenados
   */
  @Override
  public String toString() {
    String[] tipo = { "", "", "" };
    String[] t = { "AMIGOS", "FAMILIARES", "CLIENTES" };
    String ts = "";
    if (!estaVacio()) { // Si hay Contactos
      Nodo pos = contactos.inicio;
      while (pos != null) { // Los recorremos todos
        Contacto cont = (Contacto) pos.elemento;
        if (cont instanceof Amigo)// Es cliente
          tipo[0] += ((Amigo) cont).toString() + "\n********************\n";
        else if (cont instanceof Familiar) // Es amigo
          tipo[1] += ((Familiar) cont).toString() + "\n********************\n";
        else if (cont instanceof Cliente) // Es familiar
          tipo[2] += ((Cliente) cont).toString() + "\n********************\n";
        pos = pos.siguiente;
      }
      for (int j = 0; j < tipo.length; j++) {
        if (tipo[j].equals("")) {// No se encontraron amigos
          tipo[j] = "No hay '" + t[j].toLowerCase() + "' que mostrar!\n********************\n";
        }
        ts += "\n********" + t[j] + "********\n" + tipo[j];
      }
      return ts;
    } else
      return "\nNo hay contactos almacenados";
  }

  /**
   * Metodo que actualiza la informacion de un contacto dada su categoria y nombre
   * 
   * @param cat    La categoria del contacto
   * @param nombre El nombre del contacto
   */
  public void actualizar(char cat, String nombre) {
    Contacto contacto = buscar(cat, nombre);
    if (contacto != null) {
      if (contacto instanceof Amigo)
        actualizarAmigo(contacto);
      else if (contacto instanceof Familiar)
        actualizarFamiliar(contacto);
      else if (contacto instanceof Cliente)
        actualizarCliente(contacto);
    } else
      out.println("\nEl contacto solicitado no existe!\n");
  }

  /**
   * Metodo privado que busca a un contacto dada su categoria y nombre
   * 
   * @param cat La categoria del contacto
   * 
   * @param n   El nombre del contacto
   */
  private Contacto buscar(char c, String n) {
    if (!estaVacio() && contieneN(n)) {
      Nodo pos = contactos.inicio;
      Contacto cont = null;
      while (pos != null) {
        Contacto con = (Contacto) pos.elemento;
        switch (c) {
          case 'a':
            if (con instanceof Amigo && con.getNombre().equals(n)) {
              cont = (Contacto) contactos.buscar(con).elemento;
              // Creo que esta linea se puede hacer mejorar, pero ya no tengo cabeza para ella
              // ahorita. Aunque sin pedos la linea funciona
            }
            break;
          case 'f':
            if (con instanceof Familiar && con.getNombre().equals(n)) {
              cont = (Contacto) contactos.buscar(con).elemento;
            }
            break;
          case 'c':
            if (con instanceof Cliente && con.getNombre().equals(n)) {
              cont = (Contacto) contactos.buscar(con).elemento;
            }
            break;
          default:
            return null;
        }
        pos = pos.siguiente;
      }
      return cont;
    } else
      return null;
  }

  // Supongo que para estos quieren que utlizemos el sustituir y esos pedos de la
  // lista pero pues vemos JAJA
  // El metodo sustituir es para cambiar objetos de lugar pero como estamos usando
  // ListasOrdenadas no queremos desordenar la lista asi que no lo utilizamos

  /**
   * Metodo privado que actualiza la informacion de un amigo
   * 
   * @param c El amigo a actualizar
   */
  private void actualizarAmigo(Contacto c) {
    int op;
    long an;
    String au;
    Amigo a = (Amigo) c;
    do {
      out.println("\nSelecciona el atributo que deseas modificar:");
      out.println("1. Nombre");
      out.println("2. Telefono");
      out.println("3. Celular");
      out.println("4. Correo");
      out.println("5. Apodo");
      out.println("6. Cumpleanios");
      out.println("7. Facebook");
      out.println("8. Twitter");
      out.println("9. Salir");
      out.println("Escribe una opcion:");
      op = lector.nextInt();
      switch (op) {
        case 1:
          out.println("\nEscribe el nombre de tu amigo");
          au = lector1.next().toUpperCase();
          a.setNombre(au);
          break;
        case 2:
          out.println("\nEscribe el telefono de tu amigo");
          an = lector.nextLong();
          a.setTelefono(an);
          break;
        case 3:
          out.println("\nEscribe el celular de tu amigo");
          an = lector.nextLong();
          a.setCelular(an);
          break;
        case 4:
          out.println("\nEscribe el correo de tu amigo");
          au = lector1.next();
          pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
          mat = pat.matcher(au);
          if (!mat.find()) {
            err.println("Correo invalido");
            break;
          }
          a.setCorreo(au);
          break;
        case 5:
          out.println("\nEcribe el apodo de tu amigo");
          au = lector1.next().toUpperCase();
          a.setApodo(au);
          break;
        case 6:
          out.println(
              "\nEscribe la nueva fecha" + "Ingresa los datos comforme se te pide" + "(Utilice solo valores enteros)");
          out.print("Ingrese el dia:");
          dayOfMonth = lector.nextInt();
          out.print("Ingrese el mes:");
          month = lector.nextInt();
          out.print("Ingrese el anio:");
          year = lector.nextInt();
          try {
            LocalDate cum = LocalDate.of(year, month, dayOfMonth);
            a.setCumpleanios(cum);
            out.println("Validacion Exitosa");
          } catch (DateTimeException dtTimeException) {
            err.println("\nFecha Invalida!!!");
          }
          break;
        case 7:
          out.println("\nEcribe el facebook de tu amigo");
          au = lector1.next();
          a.setFacebook(au);
          break;
        case 8:
          out.println("\nEcribe el twitter de tu amigo");
          au = lector1.next();
          pat = Pattern.compile("^@.*");
          mat = pat.matcher(au);
          if (!mat.find()) {
            err.println("Usuario de twitter invalido");
            break;
          }
          a.setTwitter(au);
          break;
        case 9:
          out.println("\nSaliendo de edicion de Amigo\n");
          break;
        default:
          out.println("\nOpcion no valida\n");
      }
    } while (op != 9);
  }

  /*
   * Metodo privado que actualiza la informacion de un fammiliar
   * 
   * @param c El familiar a actualizar
   */
  private void actualizarFamiliar(Contacto c) {
    int op;
    long an;
    String au;
    Familiar f = (Familiar) c;
    do {
      out.println("\nSelecciona el atributo que deseas modificar:");
      out.println("1. Nombre");
      out.println("2. Telefono");
      out.println("3. Parentesco");
      out.println("4. Cumpleanios");
      out.println("5. Salir");
      out.println("Escribe una opcion:");
      op = lector.nextInt();
      switch (op) {
        case 1:
          out.println("\nEscribe el nombre de tu familiar");
          au = lector1.next().toUpperCase();
          f.setNombre(au);
          break;
        case 2:
          out.println("\nEscribe el telefono de tu familiar");
          an = lector.nextLong();
          f.setTelefono(an);
          break;
        case 3:
          out.println("\nEscribe el parentesco de tu familar");
          au = lector1.next().toUpperCase();
          f.setParentesco(au);
          break;
        case 4:
          out.println(
              "\nEscribe la nueva fecha" + "Ingresa los datos comforme se te pide" + "(Utilice solo valores enteros)");
          out.print("Ingrese el dia:");
          dayOfMonth = lector.nextInt();
          out.print("Ingrese el mes:");
          month = lector.nextInt();
          out.print("Ingrese el anio:");
          year = lector.nextInt();
          try {
            LocalDate cum = LocalDate.of(year, month, dayOfMonth);
            f.setCumpleanios(cum);
            out.println("Validacion Exitosa");
          } catch (DateTimeException dTimeException) {
            err.println("\nFecha Invalida!!!");
          }
          break;
        case 5:
          out.println("\nSaliendo de edicion de Familar");
          break;
        default:
          out.println("\nOpcion no valida\n");
      }
    } while (op != 5);
  }

  /*
   * Metodo privado que actualiza la informacion de un cliente
   * 
   * @param c El cliente a actualizar
   */
  private void actualizarCliente(Contacto d) {
    int op;
    long an;
    String au;
    Cliente c = (Cliente) d;
    do {
      out.println("\nSelecciona el atributo que deseas modificar:");
      out.println("1. Nombre");
      out.println("2. Telefono");
      out.println("3. Celular");
      out.println("4. Correo");
      out.println("5. Compania");
      out.println("6. Extension");
      out.println("7. Pagina web");
      out.println("8. Salir");
      out.println("Escribe una opcion:");
      op = lector.nextInt();
      switch (op) {
        case 1:
          out.println("\nEscribe el nombre del cliente");
          au = lector1.next().toUpperCase();
          c.setNombre(au);
          break;
        case 2:
          out.println("\nEscribe el telefono del cliente");
          an = lector.nextLong();
          c.setTelefono(an);
          break;
        case 3:
          out.println("\nEscribe el celular del cliente");
          an = lector.nextLong();
          c.setCelular(an);
          break;
        case 4:
          out.println("\nEscribe el correo de tu cliente");
          au = lector1.next();
          pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
          mat = pat.matcher(au);
          if (!mat.find()) {
            err.println("Correo invalido");
            break;
          }
          c.setCorreo(au);
          break;
        case 5:
          out.println("\nEcribe la compania del cliente");
          au = lector1.next().toUpperCase();
          c.setCompania(au);
          break;
        case 6:
          out.println("\nEscribe la extension del cliente");
          au = lector.next();
          c.setExtension(au);
          break;
        case 7:
          out.println("\nEcribe la pagina web del cliente");
          au = lector1.next();
          pat = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))"
              + "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" + "([).!';/?:,][[:blank:]])?$");
          mat = pat.matcher(au);
          if (!mat.find()) {
            err.println("Sitio web invalido");
            break;
          }
          c.setCorreo(au);
          break;
        case 8:
          out.println("\nSaliendo de edicion de Amigo\n");
          break;
        default:
          out.println("\nOpcion no valida\n");
      }
    } while (op != 8);
  }

  /**
   * Metodo privado que busca a un contacto dado su nombre y lo devuelve
   * 
   * @param nombre El nombre del contacto
   * 
   * @return boolean true si la lista contiene al contacto con el nombre, false en
   * el caso contrario
   */
  private boolean contieneN(String nombre) {
    boolean respuesta = false;
    if (!estaVacio()) {
      Nodo pos = contactos.inicio;
      while (pos != null) {
        Contacto cont = (Contacto) pos.elemento;
        if (cont.getNombre().equals(nombre)) {
          respuesta = true;
          break;
        }
        pos = pos.siguiente;
      }
    }
    return respuesta;
  }
}
