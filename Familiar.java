import java.time.LocalDate;

/**
 * Clase para definir un Contacto
 *
 * @author Cruz Barrios Luis Alberto, Flores Molina Alfredo, Fernandez Neria
 *         Montserrat, Maya Sanchez Andrea Fernanda, Ortiz Covarrubias Andres
 *         Uriel, Lopez Espindola Luis Enrique
 * @version Septiembre 2020
 */
public class Familiar extends Contacto {
    private String parentesco;
    private LocalDate cumpleanios;

    public Familiar(String nombre, long telefono, String parentesco, LocalDate cumpleanios) {
        super(nombre, telefono);
        this.parentesco = parentesco;
        this.cumpleanios = cumpleanios;
    }

    public String getParentesco() {
        return parentesco;
    }

    public LocalDate getCumpleanios() {
        return cumpleanios;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public void setCumpleanios(LocalDate cumpleanios) {
        this.cumpleanios = cumpleanios;
    }

    @Override
    public String toString() {
        return super.toString() + "\nParentesco: " + parentesco + "\nCumpleanios: " + cumpleanios;
    }
}
