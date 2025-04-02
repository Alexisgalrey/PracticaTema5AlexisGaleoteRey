package Practica5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase abstracta que representa a un Creyente, que hereda de Personaje.
 * Posee un atributo de fe y un metodo abstracto para realizar plegarias.
 */
public abstract class Creyente extends Personaje {

    public double fe;

    /**
     * Constructor por defecto que inicializa un Creyente con fe en -1.
     */
    public Creyente() {
        super();
        this.fe = -1;
    }

    /**
     * Constructor que inicializa un Creyente con nombre, raza y un valor de fe.
     *
     * @param nombre Nombre del Creyente.
     * @param raza   Raza del Creyente.
     * @param fe     Valor de la fe del Creyente.
     */
    public Creyente(String nombre, String raza, double fe) {
        super(nombre, raza);
        this.fe = fe;
    }

    /**
     * Constructor de la clase Creyente.
     * <p>
     * Este constructor inicializa un objeto de tipo  Creyente a partir de un archivo especificado por la ruta
     * proporcionada. Llama al constructor de la clase base para realizar las inicializaciones necesarias.
     *
     * @param path Ruta del archivo desde donde se debe cargar la información.
     */
    public Creyente(String path) throws IOException {
        super(path);
    }

    // EJERCICIO 4

    /**
     * Verifica y actualiza los valores de la ficha de un personaje, incluyendo el atributo de fe.
     * <p>
     * Este metodo invoca al metodo `verificarFicha` de la clase padre para verificar y actualizar los atributos básicos del personaje.
     * Luego, verifica si el valor de la fe ha cambiado y, en caso afirmativo, lo actualiza.
     *
     * @param nombreFicha            Nombre del personaje a verificar.
     * @param razaFicha              Raza del personaje a verificar.
     * @param estadoFicha            Estado del personaje (activo/inactivo).
     * @param nivelFicha             Nivel del personaje a verificar.
     * @param vitalidadFicha         Vitalidad del personaje a verificar.
     * @param fuerzaFicha            Fuerza del personaje a verificar.
     * @param agilidadFicha          Agilidad del personaje a verificar.
     * @param fortalezaFisicaFicha   Fortaleza física del personaje a verificar.
     * @param resistenciaMagicaFicha Resistencia mágica del personaje a verificar.
     * @param feFicha                Valor de la fe del personaje a verificar.
     * @throws IOException Si ocurre un error durante la actualización de la ficha.
     */

    public void verificarFicha(String nombreFicha, String razaFicha, boolean estadoFicha, int nivelFicha, double vitalidadFicha, double fuerzaFicha,
                               double agilidadFicha, double fortalezaFisicaFicha, double resistenciaMagicaFicha, double feFicha) throws IOException {

        super.verificarFicha(nombreFicha, razaFicha, estadoFicha, nivelFicha, vitalidadFicha, fuerzaFicha,
                agilidadFicha, fortalezaFisicaFicha, resistenciaMagicaFicha);

        if ((this.fe == feFicha) == false) {
            this.fe = feFicha;
        }
    }

    /**
     * Establece el valor de la fe del Creyente.
     *
     * @param fe valor de fe.
     */

    public void setFe(double fe) {

        this.fe = fe;
    }

    /**
     * Obtiene el valor actual de la fe del Creyente.
     *
     * @return El valor de la fe del Creyente.
     */
    public double getFe() {

        return fe;
    }

    /**
     * Metodo abstracto que debe ser implentado por las subclases para realizar una plegaria.
     *
     * @param tipo     Tipo de plegaria.
     * @param objetivo El objetivo de la plegaria.
     */
    public abstract double plegaria(int tipo, String objetivo);

    /**
     * Representación en texto del Creyente.
     *
     * @return Cadena con la información del Creyente y su fe.
     */
    public String toString() {
        return super.toString() + "\n El creyente tiene una fe de: " + getFe();
    }
}


