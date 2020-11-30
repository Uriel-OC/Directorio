import static java.lang.System.*;
import java.util.*;

//Bibliotecas en caso de que haya problemas con la lectura/escritura de Archivos
import java.io.FileNotFoundException;
import java.io.IOException;

//Importando bibliotecas para algunos parametros
import java.time.*;
import java.util.regex.*;

public class MiDirectorio {

    public static void main(String[] args) throws IOException {
        Scanner lector = new Scanner(in);
        Scanner lector1 = new Scanner(in).useDelimiter("\n");
        Directorio direct = null;
        int dayOfMonth, month, year;
        String cad1, cad2, cad3, nombre, correo, archivo;
        char opcion, op;
        archivo = null;
        long telefono, celular;
        boolean cond = true, guardado = false;
        Pattern pat;
        Matcher mat;
        LocalDate cumpleanios;
        out.println("\n***** INICIO *****");
        do {
            out.println("a. Cargar un archivo");
            out.println("b. Agregar contactos directamente");
            out.print("Opcion seleccionada: ");
            opcion = lector1.next().toLowerCase().charAt(0);
            switch (opcion) {
                case 'a': // Crear directorio mediante un archivo
                    direct = new Directorio();
                    out.print("Escribe el nombre del archivo con su extension correspondiente: ");
                    archivo = lector.next();
                    direct.archivoAArreglo(archivo);
                    out.println("Archivo cargado correctamente");
                    cond = false;
                    break;
                case 'b'://Agregar contactos directamnete
                    direct = new Directorio();
                    cond = false;
                    out.println("Directorio virtual creado");
                    break;
                default:
                    out.println("Opcion invalida");
            }
        } while (cond);
        do {
            out.println("\n******* MENU PRINCIPAL *******");
            out.println("a. Agregar contacto");
            out.println("b. Eliminar contacto");
            out.println("c. Buscar contacto");
            out.println("d. Actualizar contacto");
            out.println("e. Mostrar contactos");
            out.println("f. Guardar Directorio");
            out.println("g. Salir");
            out.print("Opcion seleccionada: ");
            opcion = lector1.next().toLowerCase().charAt(0);
            switch (opcion) {
                case 'a':
                    do {
                        out.println("\n******* MENU AGREGAR *******");
                        out.println("a. Agregar un amigo");
                        out.println("b. Agregar un familiar");
                        out.println("c. Agregar un cliente");
                        out.println("d. Regresar al menu principal\n");
                        out.print("Opcion seleccionada: ");
                        op = lector1.next().toLowerCase().charAt(0);
                        switch (op) {
                            case 'a':
                                out.println("Perfecto! Agreguemos un Amigo");
                                try {
                                    out.println("A continuacion ingrese los siguientes datos: ");
                                    // nombre
                                    out.println("Ingrese el nombre de tu amigo (Omita los acentos)");
                                    nombre = lector1.next().toUpperCase();
                                    // telefono
                                    out.println("Ingrese el telefono de tu amigo");
                                    telefono = lector.nextLong();
                                    // celular
                                    out.println("Ingrese el celular de tu amigo");
                                    celular = lector.nextLong();
                                    // correo
                                    out.println("Ingresa el correo de tu amigo");
                                    correo = lector1.next();
                                    pat = Pattern.compile(
                                            "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                                    mat = pat.matcher(correo);
                                    if (!mat.find()) {
                                        throw new InputMismatchException();
                                    }
                                    // apodo
                                    out.println("Ingresa el apodo de tu amigo");
                                    cad1 = lector1.next().toUpperCase();
                                    // cumpleanios
                                    out.println("Ingresa la fecha del cumpleanios de tu amigo"
                                            + " (Utilice solo valores enteros)");
                                    out.print("Ingrese el dia: ");
                                    dayOfMonth = lector.nextInt();
                                    out.print("Ingrese el mes: ");
                                    month = lector.nextInt();
                                    out.print("Ingrese el anio: ");
                                    year = lector.nextInt();
                                    cumpleanios = LocalDate.of(year, month, dayOfMonth);
                                    // facebook
                                    out.println("Ingresa el facebook de tu amigo");
                                    cad2 = lector1.next();
                                    // twitter
                                    out.println("Ingresa el twitter de tu amigo(Recuerda incluir el @)");
                                    cad3 = lector1.next();
                                    pat = Pattern.compile("^@.*");
                                    mat = pat.matcher(cad3);
                                    if (!mat.find()) {
                                        throw new InputMismatchException();
                                    }
                                    direct.agregar(new Amigo(nombre, telefono, celular, correo, cad1, cumpleanios, cad2,
                                            cad3));
                                    out.println("Amigo agregado con exito");
                                    break;
                                } catch (InputMismatchException iException) {
                                    lector.nextLine();
                                    lector1.nextLine();
                                    err.println("Has escrito un valor incompatible");
                                    break;
                                } catch (DateTimeException dtDateTimeException) {
                                    err.println("Ingresaste una fecha incorrecta");
                                    break;
                                }
                            case 'b':
                                out.println("Perfecto! Agreguemos un Familiar");
                                try {
                                    out.println("A continuacion ingrese los siguientes datos: ");
                                    // nombre
                                    out.println("Ingrese el nombre de tu familiar");
                                    nombre = lector1.next().toUpperCase();
                                    // telefono
                                    out.println("Ingrese el telefono de tu familiar");
                                    telefono = lector.nextLong();
                                    // parentesco
                                    out.println("Ingrese el parentesco de tu familiar");
                                    cad1 = lector1.next().toUpperCase();
                                    // cumpleanios
                                    out.println("Ingresa la fecha del cumpleanios de tu amigo"
                                            + " (Utilice solo valores enteros)");
                                    out.print("Ingrese el dia: ");
                                    dayOfMonth = lector.nextInt();
                                    out.print("Ingrese el mes: ");
                                    month = lector.nextInt();
                                    out.print("Ingrese el anio: ");
                                    year = lector.nextInt();
                                    cumpleanios = LocalDate.of(year, month, dayOfMonth);
                                    direct.agregar(new Familiar(nombre, telefono, cad1, cumpleanios));
                                    out.println("Familiar agregado con exito");
                                    break;
                                } catch (InputMismatchException iException) {
                                    lector.nextLine();
                                    lector1.nextLine();
                                    err.println("Has escrito un valor incompatible");
                                    continue;
                                } catch (DateTimeException dtTimeException) {
                                    err.println("Ingresaste una fecha incorrecta");
                                    break;
                                }
                            case 'c':
                                out.println("Perfecto! Agreguemos un Cliente");
                                try {
                                    out.println("A continuacion ingrese los siguientes datos:");
                                    // nombre
                                    out.println("Ingrese el nombre del cliente");
                                    nombre = lector1.next().toUpperCase();
                                    // telefono
                                    out.println("Ingrese el telefono del cliente");
                                    telefono = lector.nextLong();
                                    // celular
                                    out.println("Ingrese el celular del cliente");
                                    celular = lector.nextLong();
                                    // correo
                                    out.println("Ingresa el correo del cliente");
                                    correo = lector1.next();
                                    pat = Pattern.compile(
                                            "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                                    mat = pat.matcher(correo);
                                    if (!mat.find()) {
                                        throw new InputMismatchException();
                                    }
                                    // compania
                                    out.println("Ingresa la compania del cliente");
                                    cad1 = lector1.next().toUpperCase();
                                    // extension
                                    out.println("Ingresa la extension del cliente");
                                    cad2 = lector.next();
                                    // webpage
                                    out.println("Ingresa la pagina web del cliente");
                                    cad3 = lector1.next();
                                    pat = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))"
                                            + "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)"
                                            + "([).!';/?:,][[:blank:]])?$");
                                    mat = pat.matcher(cad3);
                                    if (!mat.find()) {
                                        throw new InputMismatchException();
                                    }
                                    direct.agregar(new Cliente(nombre, telefono, celular, correo, cad1, cad2, cad3));
                                    out.println("Cliente agregado con exito");
                                    break;
                                } catch (InputMismatchException e) {
                                    lector.nextLine();
                                    lector1.nextLine();
                                    err.println("Has ingresado un valor incompatible");
                                    break;
                                }
                            case 'd':
                                out.println("Regresando al menu principal...");
                                break;
                            default:
                                out.println("Opcion invalida!");
                                break;
                        }
                    } while (op != 'd');
                    break;
                case 'b':// eliminar
                    do {
                        out.println("\n******* MENU ELIMINAR *******");
                        out.println("a. Eliminar un contacto a partir del nombre");
                        out.println("b. Eliminar todos los contactos con el mismo nombre");
                        out.println("c. Eliminar todos los contactos del directorio");
                        out.println("d. Regresar al menu principal");
                        out.print("Opcion seeccionada: ");
                        op = lector1.next().toLowerCase().charAt(0);
                        switch (op) {
                            case 'a':
                                out.println("Cual es el nombre del contacto que quieres eliminar?");
                                nombre = lector1.next().toUpperCase();
                                direct.eliminarN(nombre);
                                break;
                            case 'b':
                                out.println("Cual es el nombre de los contactos que quieres eliminar?");
                                nombre = lector1.next().toUpperCase();
                                direct.eliminarTodosN(nombre);
                                break;
                            case 'c':
                                direct.eliminarTodos();
                                out.println("Todos los contactos han ");
                                break;
                            case 'd':
                                out.println("Regresando al menu principal...");
                                break;
                            default:
                                out.println("Opcion invalida!");
                                break;
                        }
                    } while (op != 'd');
                    break;
                case 'c':// buscar
                    do {
                        out.println("\n******* MENU BUSCAR *******");
                        out.println("a. Buscar un contacto a partir del nombre");
                        out.println("b. Buscar un contacto a partir del nombre y categoria");
                        out.println("c. Buscar todos los contactos que tengan twitter y/o facebook");
                        out.println("d. Buscar todos los contactos que tengan correo");
                        out.println("e. Buscar todos los clientes de una compania determinada");
                        out.println("f. Buscar un contacto a partir del telefono");
                        out.println("g. Regresar al menu principal");
                        out.print("Opcion seeccionada: ");
                        op = lector1.next().toLowerCase().charAt(0);
                        switch (op) {
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
                                switch (cad1.charAt(0)) {
                                    case 'a':
                                        direct.mostrarNC(nombre, cad1.charAt(0));
                                        break;
                                    case 'f':
                                        direct.mostrarNC(nombre, cad1.charAt(0));
                                        break;
                                    case 'c':
                                        direct.mostrarNC(nombre, cad1.charAt(0));
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
                                break;
                            default:
                                out.println("Opcion invalida!");
                                break;
                        }
                    } while (op != 'g');
                    break;
                case 'd':// actualizar
                    do {
                        out.println("\n******* MENU ACTUALIZAR *******");
                        out.println("a. Actualizar un amigo");
                        out.println("b. Actualizar un familiar");
                        out.println("c. Actualizar un cliente");
                        out.println("d. Regresar al menu principal");
                        out.print("Opcion seleccionada: ");
                        op = lector1.next().toLowerCase().charAt(0);
                        switch (op) {
                            case 'a':
                                out.println("Cual es el nombre del amigo que quieres actualizar?");
                                nombre = lector1.next().toUpperCase();
                                direct.actualizar('A', nombre);
                                break;
                            case 'b':
                                out.println("Cual es el nombre del familiar que quieres actualizar?");
                                nombre = lector1.next().toUpperCase();
                                direct.actualizar('F', nombre);
                                break;
                            case 'c':
                                out.println("Cual es el nombre del cliente que quieres actualizar?");
                                nombre = lector1.next().toUpperCase();
                                direct.actualizar('C', nombre);
                                break;
                            case 'd':
                                out.println("Regresando al menu principal...");
                                break;
                            default:
                                out.println("Opcion invalida!");
                                break;
                        }
                    } while (op != 'd');
                    break;
                case 'e':// mostrar
                    do {
                        out.println("\n******* MENU MOSTRAR *******");
                        out.println("a. Todos los contactos");
                        out.println("b. Solo amigos");
                        out.println("c. Solo familiares");
                        out.println("d. Solo clientes");
                        out.println("e. Regresar al menu principal");
                        out.print("Opcion seleccionada: ");
                        op = lector1.next().toLowerCase().charAt(0);
                        switch (op) {
                            case 'a':
                                out.println(direct);
                                break;
                            case 'b':
                                direct.mostrarDet('A');
                                break;
                            case 'c':
                                direct.mostrarDet('F');
                                break;
                            case 'd':
                                direct.mostrarDet('C');
                                break;
                            case 'e':
                                out.println("Regresando al menu principal");
                                break;
                            default:
                                out.println("Opcion invalida!");
                                break;
                        }
                    } while (op != 'e');
                    break;
                case 'f'://Guardar Directorio
                    if (archivo.equals("")) {
                        out.print("Como quieres llamar el archivo donde se guardaran los articulos? ");
                        out.println("(sin incluir la extension del archivo)");
                        archivo = lector1.next().toLowerCase() + ".txt";
                    }
                    try {
                        direct.guardarArchivo(archivo);
                        out.println("\nArticulos guardados con exito!\n");
                        guardado = true;
                        } catch (IOException e) {
                            out.println("\nEl archivo no ha podido ser guardado\n");
                        }
                    break;
                case 'g'://Salir
                    if (!direct.estaVacio())
                        if (!guardado)
                            do {
                                out.println("Seguro que quieres irte sin guardar? (s/n)");
                                op = lector1.next().toLowerCase().charAt(0);
                                switch (op) {
                                    case 'n':
                                        if (archivo.equals("")) {
                                            out.print("Como quieres llamar el archivo donde se guardaran los articulos? ");
                                            out.println("(sin incluir la extension del archivo)");
                                            archivo = lector1.next().toLowerCase() + ".txt";
                                            try {
                                               direct.guardarArchivo(archivo);
                                            } catch (IOException e) {
                                               out.println("\nEl archivo no ha podido ser guardado\n");
                                            }
                                        } else {
                                            out.println("\nGuardando...");
                                            try {
                                                direct.guardarArchivo(archivo);
                                                out.println("\nArticulos guardados con exito!\n");
                                            } catch (IOException e) {
                                                out.println("\nEl archivo no ha podido ser guardado\n");
                                            }
                                        }
                                        break;
                                    case 's':
                                        out.println("Bueno, es tu decision");
                                        break;
                                    default:
                                        out.println("Opcion invalida!");
                                        break;
                                }
                            } while (op != 's' && op != 'n');
                    out.println("Aioooooos");
                    break;
            }
        } while (opcion != 'g');
    }// Fin main
}// Fin MiDirectorio.java
