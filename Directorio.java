import java.util.Scanner;
import static java.lang.System.*;

//Importando bibliotecas necesarias para algunos parametros
import java.text.SimpleDateFormat;
import java.net.*;

public class Directorio {
  private Contacto contactos[];
  private int na;
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
    int i;
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
        for (int i = 0; i < na; i++)
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
      for (int i = 0; i < na; i++)
        if (nombre.equals(contactos[i].getNombre())) {
          out.println("\nResultado de la busqueda: \n" + contactos[i].toString());// Aqui no se si sea necesario el
                                                                                  // .toString()
          break;
        }
      if (con.equals(""))
        out.println("No existe un Contacto con el nombre " + nombre + "\n");
    } else
      out.println("No hay Contactos almacenados\n");
  }

  public void mostrarNC(String nombre, char cat) {
    if (!estaVacio() && contieneN(nombre)) {
      for (int i = 0; i < na; i++)
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
      out.println("No se encontraron resultados de la busqueda\n");
    // No se si sea necesario
  }

  public void mostrarFT() {
    String ft = "";
    if (!estaVacio())
      for (int i = 0; i < na; i++) {
        if (contactos[i] instanceof Amigo)
          if (!((Amigo) contactos[i]).getFacebook().equals("") || !((Amigo) contactos[i]).getTwitter().equals(""))
            ft += ((Amigo) contactos[i]).toString();
      }
    if (ft.equals(""))
      out.println("No hay amigos con Facebook o Twitter que mostrar :(\n");
    else
      out.println("*******AMIGOS CON FACEBOOK o TWITTER*******\n" + ft);
  }

  public void mostrarCo() {
    String amigos = "";
    String clientes = "";
    int i;
    if (!estaVacio()) {
      for (i = 0; i < na; i++)
        if (contactos[i] instanceof Amigo && !((Amigo) contactos[i]).getCorreo().equals(""))
          amigos += ((Amigo) contactos[i]).toString() + "\n**************\n";
      if (contactos[i] instanceof Cliente && !((Cliente) contactos[i]).getCorreo().equals(""))
        clientes += ((Cliente) contactos[i]).toString() + "\n**************\n";
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

  public void mostrarComp(String compania) {
    String clientes = "";
    if (!estaVacio()) {
      Contacto copia[] = ordenarAsc(contactos, new ComparaNombre()); // Ordenar alfabeticamente
      for (int i = 0; i < na; i++) {
        if (copia[i] instanceof Cliente && ((Cliente) copia[i]).getCompania().equalsIgnoreCase(compania))
          clientes += ((Cliente) copia[i]).toString() + "\n***************\n";
      }
    }
    if (clientes.equals(""))
      out.println("\nNo hay clientes que mostrar :(\n");
    else
      out.println("\nClientes de la compania" + compania.toUpperCase() + ":\n" + clientes);
  }

  public void mostrarDet(char cat) {
    Contacto cont[] = ordenarAsc(contactos, new ComparaNombre());
    String[] t = { "AMIGOS", "FAMILIARES", "CLIENTES" };
    String det = "";
    if (!estaVacio()) { // Si hay contactos
      for (int i = 0; i < na; i++)
        switch (cat) {
          case 'A': // Es un Amigo
            if (cont[i] instanceof Amigo)// Lo encontro
              det += ((Amigo) cont[i]).toString() + "\n********************\n";
            break;
          case 'F': // Es un Familiar
            if (cont[i] instanceof Familiar)// Lo encontro
              det += ((Familiar) cont[i]).toString() + "\n********************\n";
            break;
          case 'C': // Es una Cliente
            if (cont[i] instanceof Cliente)// Lo encontro
              det += ((Cliente) cont[i]).toString() + "\n********************\n";
            break;
          default:
            break;
        }// Fin switch
      for (int i = 0; i < t.length; i++) {
        if (cat == (t[i].charAt(0)) && det.equals(""))
          out.println("No hay '" + t[i] + "' que mostrar\n");
        if (cat == (t[i].charAt(0)))
          out.println("******" + t[i] + "********" + det);
      }
    } // Fin if(!estaVacio)
    else
      out.println("No hay contactos que mostrar");
  }

  public void mostrarNum(long t) {
    String con = "";
    if (!estaVacio()) {
      for (int i = 0; i < na; i++)
        if (t == contactos[i].getTelefono()) {
          out.println("\nResultado de la busqueda: \n" + contactos[i].toString());// Aqui no se si sea necesario el
                                                                                  // .toString()
          break;
        }
      if (con.equals(""))
        out.println("No existe un Contacto con el telefono " + t + "\n");
    } else
      out.println("No hay Contactos almacenados\n");
  }

  @Override
  public String toString() {
    String[] tipo = { "", "", "" };
    String[] t = { "AMIGOS", "FAMILIARES", "CLIENTES" };
    String ts = "";
    if (!estaVacio()) { // Si hay Contactos
      Contacto copia[] = ordenarAsc(contactos, new ComparaNombre());
      for (int i = 0; i < na; i++) { // Los recorremos todos
        if (copia[i] instanceof Amigo)// Es cliente
          tipo[0] += ((Amigo) copia[i]).toString() + "\n********************\n";
        else if (copia[i] instanceof Familiar) // Es amigo
          tipo[1] += ((Familiar) copia[i]).toString() + "\n********************\n";
        else if (copia[i] instanceof Cliente) // Es familiar
          tipo[2] += ((Cliente) copia[i]).toString() + "\n********************\n";
      }
      for (int j = 0; j < tipo.length; j++) {
        if (tipo[j].equals("")) {// No se encontraron amigos
          tipo[j] = "No hay '" + t[j].toLowerCase() + "' que mostrar!\n********************\n";
        }
        ts += "\n" + t[j] + "\n" + tipo[j];
      }
      return ts;
    } else
      return "No hay articulos almacenados";
  }

  // Pues sí hay que usarlo así, cambie el método a privado.
  // Va
  private static <T> T[] ordenarAsc(T contactos[], java.util.Comparator<T> cmp) {
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

  public void actualizar(char cat, String nombre) {
    Contacto contacto = buscar(cat, nombre);
    if (contacto != null)
      if (contacto instanceof Amigo)
        actualizarAmigo(contacto);
      else if (contacto instanceof Familiar)
        actualizarFamiliar(contacto);
      else if (contacto instanceof Cliente)
        actualizarCliente(contacto);
      else
        out.println("\nEl contacto solicitado no existe!\n");
  }

  private Contacto buscar(char c, String n) {
    if (!estaVacio()) {
      switch (c) {
        case 'a':
          for (int i = 0; i < na; i++)
            if (contactos[i] instanceof Amigo && contactos[i].getNombre().equals(n))
              return contactos[i];
          break;
        case 'f':
          for (int i = 0; i < na; i++)
            if (contactos[i] instanceof Familiar && contactos[i].getNombre().equals(n))
              return contactos[i];
          break;
        case 'c':
          for (int i = 0; i < na; i++)
            if (contactos[i] instanceof Cliente && contactos[i].getNombre().equals(n))
              return contactos[i];
          break;
      }
      return null;
    } else
      return null;
  }

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
          a.setCorreo(au);
          break;
        case 5:
          out.println("\nEcribe el apodo de tu amigo");
          au = lector1.next().toUpperCase();
          a.setApodo(au);
          break;
        case 6:
          out.println("\nEscribe tu cumpleanios de tu amigo con el formato DD/MM/AAAA");
          au = lector1.next();
          try {
            a.setCumpleanios(new SimpleDateFormat(au));
          } catch (Exception e) {
            err.println("Escribiste mal el cumpleaños de tu amigo");
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
          out.println("\nEscribe tu cumpleanios de tu familair con el formato DD/MM/AAAA");
          au = lector1.next();
          try {
            f.setCumpleanios(new SimpleDateFormat(au));
          } catch (Exception e) {
            err.println("Escribiste mal el cumpleaños de tu familiar");
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
          out.println("\nEscribe el correo del cliente");
          au = lector1.next();
          c.setCorreo(au);
          break;
        case 5:
          out.println("\nEcribe la compania del cliente");
          au = lector1.next().toUpperCase();
          c.setCompania(au);
          break;
        case 6:
          out.println("\nEscribe la extension del cliente");
          an = lector.nextLong();
          c.setExtension((int) an);
          break;
        case 7:
          out.println("\nEcribe la pagina web del cliente");
          au = lector1.next();
          try {
            c.setWebpage(new URL(au));
          } catch (Exception e) {
            err.println("Ocurrio un error al guardar la pagina web del cliente");
          }
          break;
        case 8:
          out.println("\nSaliendo de edicion de Amigo\n");
          break;
        default:
          out.println("\nOpcion no valida\n");
      }
    } while (op != 8);
  }

  private void crecerArreglo(int n) {
    int nuevoTam = contactos.length + n;
    Contacto cont[] = new Contacto[nuevoTam];
    for (int i = 0; i < contactos.length; i++) {
      cont[i] = contactos[i];
    }
    contactos = cont;
  }

  private boolean contieneN(String nombre) {
    boolean respuesta = false;
    if (!estaVacio())
      for (int i = 0; i < na; i++)
        if (nombre.equals(contactos[i].getNombre())) {
          respuesta = true;
          break;
        }
    return respuesta;
  }
}
