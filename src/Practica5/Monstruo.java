package Practica5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que representa un Monstruo, que hereda de Personaje.
 */
public class Monstruo extends Personaje {
    /**
     * Constructor por defecto que inicializa un Monstruo con valores base.
     */
    public Monstruo() {
        super();

    }

    /**
     * Constructor que inicializa un Monstruo con nombre y raza.
     *
     * @param nombre Nombre del Monstruo.
     * @param raza   Raza del Monstruo.
     */
    public Monstruo(String nombre, String raza) {
        super(nombre, raza);
    }

    /**
     * Constructor que inicializa un Monstruo a partir de un archivo de texto.
     *
     * @param path Ruta del archivo.
     * @throws IOException Si ocurre un error de lectura del archivo.
     */
    public Monstruo(String path) throws IOException {
        super(path);
        File fichero = new File(path + ".txt");
        if (fichero.canRead()) {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
        }
    }

    /**
     * Establece los atributos del Monstruo según su raza.
     */
    public void setRaza() {
        switch (getRaza()) {
            case "Bestia":
                setFortalezaFisica(getNivel() + 0.5);
                setResistenciaMagica(getNivel() + 0.5);
                setFuerza(getNivel() * 2);
                setAgilidad(getNivel() * 2);
                setVitalidad(getNivel());
                break;

            case "No-muerto":
                setFortalezaFisica(getNivel() + 0.5);
                setResistenciaMagica(getNivel() * 4);
                setFuerza(getNivel());
                setAgilidad(getNivel() + 0.25);
                setVitalidad(getNivel() + 0.5);
                break;

            case "Gigante":
                setFortalezaFisica(getNivel());
                setResistenciaMagica(getNivel() + 0.25);
                setFuerza(getNivel() * 4);
                setAgilidad(getNivel() + 0.25);
                setVitalidad(getNivel() * 4);
                break;
        }
    }

    /**
     * representacion en texto del Monstruo.
     *
     * @return Cadena con la información del Monstruo.
     */
    public String toString() {
        return "Este monstruo es: " + getRaza();
    }
}