import java.util.Scanner;
import static java.lang.System.*;

public class Directorio{
  private Contacto contactos[];
  private int na;
  private Scanner lector;
  private Scanner lector1;

  public Directorio(){
    this(20);
  }

  public Directorio(int n){
    contactos = new Contacto[(n < 0) ? 20 : n];
    na = 0;
    lector = new Scanner(in);
    lector1 = new Scanner(in).useDelimiter("\n");
  }

  public boolean estaVacio(){
    return na == 0;
  }

  public boolean estaLleno(){
    return na == contactos.length;
  }

  public void agregar(Contacto c){
    if(estaLleno())
      crecerArreglo(1);
    contactos[na++] = c;
  }
  
  public void eliminarPrimero(String nombre){
    int i;
    boolean borro = false;
    if(!estaVacio()){
      for(i = 0; i < na; i++){
	if(nombre.equals(contactos[i].getNombre())){
	  if(i == (na-1))
	    na--;
	  else
	    contactos[i] = contactos[--na];
	  borro = true;
	  out.println("Contacto eliminado con exito!");
	  break;
	  
	}
      }
      if(i == na && !borro)
	out.println("El Contacto con nombre: " + nombre + " no existe!\n");
    } else
      out.println("No hay articulos almacenados\n");
  }
  
  public void eliminarTodos(String nombre){
    int i;
    boolean borro = false;
    if(!estaVacio()){
      do{
	for(i = 0; i < na; i++)
	  if(nombre.equals(contactos[i].getNombre())){
	    if(i == (na-1))
	      na--;
	    else
	      contactos[i] = contactos[--na];
	    borro = true;
	    break;
	  }
      } while(contiene(nombre));
      if(borro)
	out.println("Se elimino al menos un Contacto");
      else
	out.println("No existe ningun Contacto con el nombre " + nombre + "\n");
    } else
      out.println("No hay Contactos almacenados\n");
  }
  
  public void mostrar(String nombre){
    String con = "";
    if(!estaVacio()){
      for(int i = 0; i < na; i++)
	if(nombre.equals(contactos[i].getNombre())){
	  out.println(contactos[i]);
	  break;
	}
      if(con.equals(""))
	out.println("No existe un Contacto con el nombre " + nombre + "\n");
    } else
      out.println("No hay Contactos almacenados\n");
  }

  public void mostrarNC(String nombre,char cat){
    String con = "";
    if(!estaVacio()){
      for(int i = 0; i < na; i++)
	if(nombre.equals(contactos[i].getNombre()))
	  switch(cat){
	    case 'a':
	      if(contactos[i] instanceof Amigo)
		out.println((Amigo)contactos[i]);
	      break;
	    case 'f':
	      if(contactos[i] instanceof Familiar)
		out.println((Familiar)contactos[i]);
	      break;
	    case 'c':
	      if(contactos[i] instanceof Cliente)
	        out.println((Cliente)contactos[i]);
	      break;
	    default:
	      break;
	}
    }
  }

  private void crecerArreglo(int n){
    int nuevoTam = contactos.length + n;
    Contacto cont[] = new Contacto[nuevoTam];
    for(int i = 0; i < contactos.length; i++){
      cont[i] = contactos[i];
    }
    contactos = cont;
  }

  private boolean contiene(String nombre){
    boolean respuesta = false;
    if(!estaVacio())
      for(int i = 0; i < na; i++)
	if(nombre.equals(contactos[i].getNombre())){
	  respuesta = true;
	  break;
	}
    return respuesta;
  }
}
