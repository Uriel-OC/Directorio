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
public class ContactoCC extends Contacto {
    private Long celular;
    private String correo;

    public ContactoCC(String nombre, Long telefono, Long celular, String correo) {
        super(nombre, telefono);
        this.celular = celular;
        this.correo = correo;
    }

    public Long getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCelular: " + celular + "\nCorreo: " + correo;
    }
}
