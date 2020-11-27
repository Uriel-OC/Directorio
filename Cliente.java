/**
 * Clase que permite modelar un contacto de la categoria Cliente
 *
 * @author Cruz Barrios Luis Alberto
 * @author Flores Molina Alfredo
 * @author Fernandez Neria Montserrat
 * @author Maya Sanchez Andrea Fernanda
 * @author Ortiz Covarrubias Andres Uriel
 * @author Lopez Espindola Luis Enrique
 * @version Noviembre 2020
 * @see ContactoCC
 */
public class Cliente extends ContactoCC {
    private String compania;
    private String extension;
    private String webpage;
    
    /**
     * Constructor que recibe parametros
     *
     * @param nombre El nombre del Cliente
     * @param telefono El telefono de casa del Cliente
     * @param celular El celular del Cliente
     * @param correo El correo del Cliente
     * @param compania La compania del Cliente
     * @param extension La extension del Cliente
     * @param webpage La pagina web del Cliente
     */
    public Cliente(String nombre, long telefono, long celular, String correo, String compania, String extension,
            String webpage) {
        super(nombre, telefono, celular, correo);
        this.compania = compania;
        this.extension = extension;
        this.webpage = webpage;
    }

    /**
     * Metodo para obtener la compania del Cliente
     *
     * @return String La compania del Cliente
     */
    public String getCompania() {
        return compania;
    }

    /**
     * Metodo para obtener la extension del Cliente
     *
     * @return long La extension del Cliente
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Metodo para obtener la pagina web del Cliente
     *
     * @return String La pagina web del Cliente
     */
    public String getWebpage() {
        return webpage;
    }

    /**
     * Metodo para establecer la compania del Cliente
     *
     * @param compania La compania del Cliente
     */
    public void setCompania(String compania) {
        this.compania = compania;
    }

    /**
     * Metodo para establecer la extension del Cliente
     *
     * @param extension La extension del Cliente
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Metodo para establecer la pagina web del Cliente
     *
     * @param webpage La pagina web del Cliente
     */
    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    /**
     * Metodo para imprimir un contacto Cliente como una cadena de caracteres
     *
     * @return String El contacto Cliente en formato de cadena de caracter
     */
    @Override
    public String toString() {
        return super.toString() + "\nCompania: " + compania + "\nExtension: " + extension + "\nPagina web: " + webpage;
    }
}
