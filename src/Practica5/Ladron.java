package Practica5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que representa un Ladrón, que hereda de Personaje.
 * posee la habilidad especial de robar.
 */
public class Ladron extends Personaje {
    private boolean robar;

    /**
     * Constructor por defecto que inicializa un Ladrón con la habilidad de robar desactivada.
     */

    public Ladron() {
        super();
        this.robar = false;

    }

    /**
     * Constructor que inicializa un Ladrón a partir de un archivo de texto y asigna su habilidad de robar.
     *
     * @param path  Ruta del archivo.
     * @param robar Indica si el Ladrón tiene la habilidad de robar.
     * @throws IOException Si ocurre un error de lectura del archivo.
     */
    // EJERCICIO 3:
    public Ladron(String path, boolean robar) throws IOException {
        super(path);
        File fichero = new File(path + ".txt");
        if (fichero.canRead()) {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String[] campos = new String[1];
            for (int i = 0; br.readLine().length() > 13; i++) {
                linea = br.readLine();
                campos = linea.split(": ");
                this.robar = Boolean.parseBoolean(campos[1]);
            }
        }
    }

    /**
     * Verifica y actualiza los atributos del ladrón según los datos de la ficha.
     *
     * @param nombreFicha            Nombre del personaje en la ficha.
     * @param razaFicha              Raza del personaje en la ficha.
     * @param estadoFicha            Estado del personaje en la ficha (activo/inactivo).
     * @param nivelFicha             Nivel del personaje en la ficha.
     * @param vitalidadFicha         Vitalidad del personaje en la ficha.
     * @param fuerzaFicha            Fuerza del personaje en la ficha.
     * @param agilidadFicha          Agilidad del personaje en la ficha.
     * @param fortalezaFisicaFicha   Fortaleza física del personaje en la ficha.
     * @param resistenciaMagicaFicha Resistencia mágica del personaje en la ficha.
     * @param robarFicha             Indica si el personaje en la ficha tiene la habilidad de robar.
     * @throws IOException Si ocurre un error de lectura.
     */
    // EJERCICIO 4:
    public void verificarFicha(String nombreFicha, String razaFicha, boolean estadoFicha, int nivelFicha, double vitalidadFicha, double fuerzaFicha,
                               double agilidadFicha, double fortalezaFisicaFicha, double resistenciaMagicaFicha, boolean robarFicha) throws IOException {

        super.verificarFicha(nombreFicha, razaFicha, estadoFicha, nivelFicha, vitalidadFicha, fuerzaFicha,
                agilidadFicha, fortalezaFisicaFicha, resistenciaMagicaFicha);

        if ((this.robar == robarFicha) == false) {
            this.robar = robarFicha;
        }
    }

    /**
     * Constructor que inicializa un Ladrón con todos sus atributos.
     *
     * @param nombre Nombre del Ladrón.
     * @param raza   Raza del Ladrón.
     * @param robar  Habilidad robar del Ladrón.
     */
    public Ladron(String nombre, String raza, boolean robar) {
        super(nombre, raza);
        this.robar = robar;
    }

    /**
     * Establece si el Ladrón puede robar.
     *
     * @param robar Estado de la habilidad de robo.
     */
    public void setRobar(boolean robar) {
        this.robar = robar;
    }

    /**
     * Verifica si el Ladrón puede robar.
     *
     * @return true si puede robar, false en caso contrario.
     */
    public boolean getRobar() {
        return robar;
    }

    /**
     * Habilidad de robo basada en la agilidad del Ladrón.
     *
     * @return Valor de la agilidad como referencia de la capacidad de robo.
     */
    public double robar() {
        return getAgilidad();
    }

    /**
     * Aumenta el nivel del Ladrón.
     */
    public void subirNivel() {
        setNivel(getNivel());

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 60) {
            setVitalidad(getVitalidad());
        }
        if (probabilidad >= 40) {
            setFuerza(getFuerza() + getNivel());

        }
        if (probabilidad >= 15) {
            setAgilidad(getAgilidad() + getNivel() * 2);
        }
        if (probabilidad >= 60) {
            setFortalezaFisica(getFortalezaFisica() + getNivel());
        }
        if (probabilidad >= 60) {
            setResistenciaMagica(getResistenciaMagica() + getNivel());
        }
    }

    /**
     * Representación en texto del Ladrón.
     *
     * @return Cadena con la información del Ladrón y su habilidad especial.
     */

    public String toString() {
        String resultado = "";
        if (robar == true) {
            resultado = super.toString()
                    + "\nEl ladron puede: robar";
        } else {
            resultado = super.toString()
                    + "\nEl ladron no puede: robar";
        }

        return resultado;
    }

}