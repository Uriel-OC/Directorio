/**
 * Clase para definir un Contacto
 *
 * @author Flores Molina Alfredo
 * @author Cruz Barrios Luis Alberto
 * @author Fernandez Neria Montserrat
 * @author Maya Sanchez Andrea Fernanda
 * @author Ortiz Covarrubias Andres Uriel
 * @author Lopez Espindola Luis Enrique
 * @version Septiembre 2020
 */

class Contacto {
    private String nombre;
    private long telefono;

    public Contacto(String nombre, long telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nTelefono: " + telefono;
    }
}
