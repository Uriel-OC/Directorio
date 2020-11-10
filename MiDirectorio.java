import static java.lang.System.*;
import java.util.Scanner;

//Importando bibliotecas para algunos parametros
import java.text.SimpleDateFormat;
import java.net.URL;

public class MiDirectorio {
  public static void main(String[] args) {
    Scanner lector = new Scanner(in);
    Scanner lector1 = new Scanner(in).useDelimiter("\n");
    Directorio direct;
    int entero;
    String cad1, cad2, cad3, nombre, correo;
    char opcion, op;
    long telefono, celular;
    SimpleDateFormat cumpleanios;
    URL webpage;
    out.println("\n***** INICIO *****");
    out.print("\nIngresa el numero inicial de comtactos a almacenar: ");
    entero = lector.nextInt();
    direct = new Directorio(entero);
    out.println("'Directorio' virtual creado");
    do{
      out.println("\n******* MENU PRINCIPAL *******");
      out.println("a. Agregar contacto");
      out.println("b. Eliminar contacto");
      out.println("c. Buscar contacto");
      out.println("d. Actualizar contacto");
      out.println("e. Mostrar contactos");
      out.println("f. Salir");
      out.print("Opcion seleccionada: ");
      opcion = lector1.next().toLowerCase().charAt(0);
      switch(opcion){
	case 'a':
	  do{
	    out.println("\n******* MENU AGREGAR *******");
	    out.println("a. Agregar un amigo");
	    out.println("b. Agregar un familiar");
	    out.println("c. Agregar un cliente");
	    out.println("d. Regresar al menu principal\n");
	    out.print("Opcion seleccionada: ");
	    op = lector1.next().toLowerCase().charAt(0);
	    switch(op){
	      case 'a':
		out.println("Perfecto! Agreguemos un Amigo");
                out.println("A continuacion ingrese los siguientes datos: ");
		//nombre
		out.println("Ingrese el nombre de tu amigo");
		nombre = lector1.next().toUpperCase();
		//telefono
		out.println("Ingrese el telefono de tu amigo");
		telefono = lector.nextLong();
		//celular
		out.println("Ingrese el celular de tu amigo");
		celular = lector.nextLong();
		//correo
		out.println("Ingresa el correo de tu amigo");
		correo = lector1.next();
		//apodo
		out.println("Ingresa el apodo de tu amigo");
		cad1 = lector1.next().toUpperCase();
		//cumpleanios
		out.println("Ingresa la fecha del cumpleanios de tu amigo con el formato DD/MM/AAAA");
		cad2 = lector1.next();
		try{
		cumpleanios = new SimpleDateFormat(cad2);
		}
		catch(Exception e){
		  err.println("Escribiste mal la fecha");
		  break; 
		}
		//facebook
		out.println("Ingresa el facebook de tu amigo");
		cad2 = lector1.next();
		//twitter
		out.println("Ingresa el twitter de tu amigo");
		cad3 = lector1.next();
		direct.agregar(new Amigo(nombre,telefono,celular,correo,cad1,cumpleanios,cad2,cad3));
		out.println("Amigo agregado con exito");
		break;
	      case 'b':
		out.println("Perfecto! Agreguemos un Familiar");
                out.println("A continuacion ingrese los siguientes datos: ");
		//nombre
		out.println("Ingrese el nombre de tu familiar");
		nombre = lector1.next().toUpperCase();
		//telefono
		out.println("Ingrese el telefono de tu familiar");
		telefono = lector.nextLong();
		//parentesco
		out.println("Ingrese el parentesco de tu familiar");
		cad1 = lector1.next().toUpperCase();
		//cumpleanios
		out.println("Ingresa la fecha del cumpleanios de tu familiar con el formato DD/MM/AAAA");
		cad2 = lector1.next();
		try{
		cumpleanios = new SimpleDateFormat(cad2);
		}
		catch(Exception e){
		  err.println("Escribiste mal la fecha");
		  break; 
		}
		direct.agregar(new Familiar(nombre, telefono, cad1, cumpleanios));
		out.println("Familiar agregado con exito");
		break;
	      case 'c':
		out.println("Perfecto! Agreguemos un Cliente");
                out.println("A continuacion ingrese los siguientes datos: ");
		//nombre
		out.println("Ingrese el nombre del cliente");
		nombre = lector1.next().toUpperCase();
		//telefono
		out.println("Ingrese el telefono del cliente");
		telefono = lector.nextLong();
		//celular
		out.println("Ingrese el celular del cliente");
		celular = lector.nextLong();
		//correo
		out.println("Ingresa el correo del cliente");
		correo = lector1.next();
		//compania
		out.println("Ingresa la compania del cliente");
		cad1 = lector1.next().toUpperCase();
		//extension
		out.println("Ingresa la extension del cliente");
		entero = lector.nextInt();
		//webpage
		out.println("Ingresa la pagina web del cliente");
		cad2 = lector1.next();
		try{
		  webpage = new URL(cad2);
		}
		catch(Exception e){
		  err.println("Ocurrio un error guardando la pagina web");
		  break;
		}
		direct.agregar(new Cliente(nombre, telefono, celular, correo, cad1, entero, webpage));
		out.println("Cliente agregado con exito");
		break;
	      case 'd':
		out.println("Regresando al menu principal...");
		break;
	      default:
		out.println("Opcion invalida!");
	        break;
	    }
	  }while(op != 'd');
	  break;
	case 'b'://eliminar
	  do{  
	    out.println("\n******* MENU ELIMINAR *******");
	    out.println("a. Eliminar un contacto a partir del nombre");
	    out.println("b. Eliminar todos los contactos con el mismo nombre");
	    out.println("c. Regresar al menu principal");
	    out.print("Opcion seeccionada: ");
	    op = lector1.next().toLowerCase().charAt(0);
	    switch(op){
	      case 'a':
		out.println("Cual es el nombre del contacto que quieres eliminar?");
		nombre = lector1.next().toUpperCase();
		direct.eliminarN(nombre);
		break;
	      case 'b':
		out.println("Cual es el nombre de los contactos que quieres eliminar?");
		nombre = lector1.next().toUpperCase();
		direct.eliminarTodos(nombre);
		break;
	      case 'c':
		out.println("Regresando al menu principal...");
		break;
	      default:
		out.println("Opcion invalida!");
		break;
	    }
	  }while(op != 'c');
	  break;
	case 'c'://buscar
	  do{  
	    out.println("\n******* MENU BUSCAR *******");
	    out.println("a. Buscar un contacto a partir del nombre");
	    out.println("b. Buscar un contacto a partir del nombre y categoria");
	    out.println("c. Buscar todos los contactos que tengan twitter y/o facebook");
	    out.println("d. Buscar todos los contactos que tengan correo");
	    out.println("e. Buscar todos los clientes de una compania determinada");
	    out.println("f. Buscar un contacto a partir del telefono");
	    out.println("g. Regresar al menu principal");
	    op = lector1.next().toLowerCase().charAt(0);
	    switch(op){
	      case 'a':
		out.println("Cual es el nombre del contacto a buscar?");
		nombre = lector1.next().toUpperCase();
		direct.mostrarN(nombre);
		break;
	      case 'b':
		out.println("Cual es el nombre del contacto a buscar?");
		nombre = lector1.next().toUpperCase();
		out.println("Cual es la categoria del contacto?");
		cad1 = lector1.next().toLowerCase();
		switch(cad1.charAt(0)){
		  case 'a':
		    direct.mostrarNC(nombre,cad1.charAt(0));
		    break;
		  case 'f':
		    direct.mostrarNC(nombre,cad1.charAt(0));
		    break;
		  case 'c':
		    direct.mostrarNC(nombre,cad1.charAt(0));
		    break;
		  default:
		    out.println("No existe esa categoria");
		    break;
		}
		break;
	      case 'c':
		direct.mostrarFT();
		break;
	      case 'd':
		direct.mostrarCo();
		break;
	      case 'e':
		out.println("Cual es la compania del cliente a buscar?");
		cad1 = lector1.next().toUpperCase();
		direct.mostrarComp(cad1);
		break;
	      case 'f':
		out.println("Cual es el telefono del contacto a buscar?");
		telefono = lector.nextLong();
		direct.mostrarNum(telefono);
		break;
	      case 'g':
		out.println("Regresando al menu principal...");
	      default:
		out.println("Opcion invalida!");
	    }
	  }while(op != 'g');
	  break;
	case 'd'://actualizar
	  do{
	    out.println("\n******* MENU ACTUALIZAR *******");
            out.println("a. Actualizar un amigo");
            out.println("b. Actualizar un familiar");
            out.println("c. Actualizar un cliente");
            out.println("d. Regresar al menu principal");
            out.print("Opcion seleccionada: ");
            op = lector1.next().toLowerCase().charAt(0);
	    switch(op){
	      case 'a':
		out.println("Cual es el nombre del amigo que quieres actualizar?");
                nombre = lector1.next().toUpperCase();
                direct.actualizar('a', nombre);
		break;
	      case 'b':
		out.println("Cual es el nombre del familiar que quieres actualizar?");
                nombre = lector1.next().toUpperCase();
                direct.actualizar('f', nombre);
		break;
	      case 'c':
		out.println("Cual es el nombre del cliente que quieres actualizar?");
                nombre = lector1.next().toUpperCase();
                direct.actualizar('c', nombre);
		break;
	      case 'd':
		out.println("Regresando al menu principal...");
		break;
	      default:
		out.println("Opcion invalida!");
		break;
	    }
	  }while(op != 'd');
	  break;
	case 'e'://mostrar
	  do{
	    out.println("\n******* MENU MOSTRAR *******");
	    out.println("a. Todos los contactos");
            out.println("b. Solo amigos");
            out.println("c. Solo familiares");
            out.println("d. Solo clientes");
            out.println("e. Regresar al menu principal");
            out.print("Opcion seleccionada: ");
            op = lector1.next().toLowerCase().charAt(0);
	    switch(op){
	      case 'a':
		out.println(direct);
		break;
	      case 'b':
		direct.mostrarDet('a');
		break;
	      case 'c':
		direct.mostrarDet('f');
		break;
	      case 'd':
		direct.mostrarDet('c');
		break;
	      case 'e':
		out.println("Regresando al menu principal");
		break;
	      default:
		out.println("Opcion invalida!");
		break;
	    }
	  }while(op != 'e');
	  break;
	case 'f':
	  out.println("Aioooooos");
	  break;
	default:
	  out.println("Opcion invalida!");
	  break;
      }
    }while(opcion != 'f');
  }//Fin main
}//Fin MiDirectorio.java
