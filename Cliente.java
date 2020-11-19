import java.net.URL;

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
public class Cliente extends ContactoCC {
    private String compania;
    private String extension;
    private URL webpage;

    public Cliente(String nombre, long telefono, long celular, String correo, String compania, String extension,
            URL webpage) {
        super(nombre, telefono, celular, correo);
        this.compania = compania;
        this.extension = extension;
        this.webpage = webpage;
    }

    public String getCompania() {
        return compania;
    }

    public String getExtension() {
        return extension;
    }

    public URL getWebpage() {
        return webpage;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setWebpage(URL webpage) {
        this.webpage = webpage;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCompania: " + compania + "\nExtension: " + extension + "\nPagina web: " + webpage;
    }
}
