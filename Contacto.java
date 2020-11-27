/**
 * Clase para definir un Contacto
 *
 * @author Cruz Barrios Luis Alberto
 * @author Flores Molina Alfredo
 * @author Fernandez Neria Montserrat
 * @author Maya Sanchez Andrea Fernanda
 * @author Ortiz Covarrubias Andres Uriel
 * @author Lopez Espindola Luis Enrique
 * @version Noviembre 2020
 */
class Contacto {
    private String nombre;
    private long telefono;

    /**
     * Constructor que recibe parametros
     *
     * @param nombre El nombre del Contacto
     * @param telefono El telefono casa del Contacto
     */
    public Contacto(String nombre, long telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    /**
     * Metodo para obtener el nombre del Contacto
     *
     * @return String El nombre del Contacto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para obtener el telefono casa del Contacto
     *
     * @return long El telefono del Contacto
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * Metodo para establecer el nombre del Contacto
     *
     * @param nombre El nombre del Contato
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para establecer el telefono casa del Contacto
     *
     * @param telefono El telefono del Contacto
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo para imprimir un Contacto como una cadena de caracteres
     *
     * @return String El Contacto en formato de cadena de caracter
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nTelefono: " + telefono;
    }
}
