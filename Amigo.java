import java.text.SimpleDateFormat;

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
public class Amigo extends ContactoCC {
    private String apodo;
    private SimpleDateFormat cumpleanios;
    private String facebook;
    private String twitter;

    public Amigo(String nombre, Long telefono, Long celular, String correo, String apodo, SimpleDateFormat cumpleanios,
            String facebook, String twitter) {
        super(nombre, telefono, celular, correo);
        this.apodo = apodo;
        this.cumpleanios = cumpleanios;
        this.facebook = facebook;
        this.twitter = twitter;
    }

    public String getApodo() {
        return apodo;
    }

    public SimpleDateFormat getCumpleanios() {
        return cumpleanios;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setCumpleanios(SimpleDateFormat cumpleanios) {
        this.cumpleanios = cumpleanios;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return super.toString() + "\nApodo: " + apodo + "\nCumpleanios: " + cumpleanios + "\nFacebook: " + facebook
                + "\nTwitter:" + twitter;
    }
}
