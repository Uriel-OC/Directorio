/**
 * Clase para definir el celular y correo de un Contacto
 *
 * @author Cruz Barrios Luis Alberto
 * @author Flores Molina Alfredo
 * @author Fernandez Neria Montserrat
 * @author Maya Sanchez Andrea Fernanda
 * @author Ortiz Covarrubias Andres Uriel
 * @author Lopez Espindola Luis Enrique
 * @version Noviembre 2020
 * @see Contacto
 */
public class ContactoCC extends Contacto {
    private long celular;
    private String correo;

    /**
     * Constructor que recibe parametros
     *
     * @param nombre El nombre del Contacto
     * @param telefono El telefono de casa del Contacto
     * @param celular El celular del Contacto
     * @param correo El correo del Contacto
     */
    public ContactoCC(String nombre, long telefono, long celular, String correo) {
        super(nombre, telefono);
        this.celular = celular;
        this.correo = correo;
    }

    /**
     * Metodo para obtener el celular del Contacto
     *
     * @return long El celular del Contacto
     */
    public long getCelular() {
        return celular;
    }

    /**
     * Metodo para obtener el correo del Contacto
     *
     * @return String El correo del Contacto
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo para establecer el celular del Contacto
     *
     * @param celular El celular del Contacto
     */
    public void setCelular(long celular) {
        this.celular = celular;
    }

    /**
     * Metodo para establecer el correo del Contacto
     *
     * @param correo El correo del Contacto
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo para imprimir un Contacto como una cadena de caracteres
     *
     * @return String El Contacto en formato de cadena de caracter
     */
    @Override
    public String toString() {
        return super.toString() + "\nCelular: " + celular + "\nCorreo: " + correo;
    }
}
