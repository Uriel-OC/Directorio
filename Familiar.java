import java.time.LocalDate;

/**
 * Clase que permite modelar un contacto de la categoria Familiar
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
public class Familiar extends Contacto {
    private String parentesco;
    private LocalDate cumpleanios;

    /**
     * Constructor que recibe parametros
     *
     * @param nombre El nombre del Familiar
     * @param telefono El telefono de casa del Familiar
     * @param parentesco El parentesco del Familiar
     * @param cumpleanios El cumpleanios del Familiar
     */
    public Familiar(String nombre, long telefono, String parentesco, LocalDate cumpleanios) {
        super(nombre, telefono);
        this.parentesco = parentesco;
        this.cumpleanios = cumpleanios;
    }

    /**
     * Metodo para obtener el parentesco del Familiar
     *
     * @return String el parentesco del Familiar
     */
    public String getParentesco() {
        return parentesco;
    }

    /**
     * Metodo para obtener el cumpleanios del Familiar
     *
     * @return String el cumpleanios del Familiar
     */
    public LocalDate getCumpleanios() {
        return cumpleanios;
    }

    /**
     * Metodo para establecer el parentesco del Familiar
     *
     * @param parentesco El parentesco del Familiar
     */
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    /**
     * Metodo para establecer el cumpleanios del Familiar
     *
     * @param cumpleanios El cumpleanios del Familiar
     */
    public void setCumpleanios(LocalDate cumpleanios) {
        this.cumpleanios = cumpleanios;
    }

    /**
     * Metodo para imprimir un contacto de la categoria Familiar como una cadena
     * de caracteres
     *
     * @return String El contacto Familar en formato de cadena de caracter
     */
    @Override
    public String toString() {
        return super.toString() + "\nParentesco: " + parentesco + "\nCumpleanios: " + cumpleanios;
    }
}
