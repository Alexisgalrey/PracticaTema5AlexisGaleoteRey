package Practica5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Clase que representa una mazmorra en la que habitan monstruos.
 * Contiene información sobre su nombre, nivel y los monstruos que contiene.
 */
public class Mazmorra {

    private String nombreMazmorra;
    private HashMap<Monstruo, Integer> monstruos;
    private int nivelMazmorra;

    /**
     * Constructor por defecto. Inicializa valores por defecto.
     */
    public Mazmorra() {
        this.nombreMazmorra = "";
        this.nivelMazmorra = -1;
        this.monstruos = new HashMap<>();
    }

    /**
     * Constructor con parámetros.
     *
     * @param nombreMazmorra Nombre de la mazmorra.
     * @param monstruos      Mapa con los monstruos de la mazmorra.
     * @param nivelMazmorra  Nivel de la mazmorra.
     */
    public Mazmorra(String nombreMazmorra, HashMap<Monstruo, Integer> monstruos, int nivelMazmorra) {
        this.nombreMazmorra = nombreMazmorra;
        this.monstruos = new HashMap<>(monstruos);
        this.nivelMazmorra = nivelMazmorra;
    }

    /**
     * Constructor de copia.
     *
     * @param copia Objeto Mazmorra del que se copia la información.
     */
    public Mazmorra(Mazmorra copia) {
        this.nombreMazmorra = copia.nombreMazmorra;
        this.monstruos = new HashMap<>(copia.monstruos);
        this.nivelMazmorra = copia.nivelMazmorra;
    }

    /**
     * Constructor que carga la mazmorra desde un archivo CSV.
     *
     * @param path Ruta al archivo CSV.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public Mazmorra(String path) throws IOException {
        path = "/home/tarde/Escritorio/Asignaturas DAM/Asignaturas/Programacion/Tema7/FicherosTema7/Mazmosrras/hogarDelHacedor.csv";
        this.monstruos = new HashMap<>();
        File fichero = new File(path);
        FileReader fr = new FileReader(fichero);
        BufferedReader br = new BufferedReader(fr);


        String primeraLinea = br.readLine();
        String[] datosMazmorra = primeraLinea.split(", ");
        this.nombreMazmorra = datosMazmorra[0];
        this.nivelMazmorra = Integer.parseInt(datosMazmorra[1]);

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(",");
            String tipo = campos[0].trim();
            String nombre = campos[1].trim();


            Monstruo m = new Monstruo(tipo, nombre, this.nivelMazmorra);
            this.monstruos.put(m, 1);
        }

        br.close();
        fr.close();
    }

    /**
     * Devuelve una copia del mapa de monstruos de la mazmorra.
     *
     * @return HashMap con los monstruos.
     */
    public HashMap<Monstruo, Integer> getMonstruos() {
        return new HashMap<>(monstruos);
    }

    /**
     * Añade un monstruo a la mazmorra si su nivel está dentro de un rango aceptable.
     *
     * @param monstruo Monstruo a añadir.
     */
    public void setMonstruos(Monstruo monstruo) {
        if (monstruo.getNivelMonstruo() <= this.nivelMazmorra + 3
                && monstruo.getNivelMonstruo() >= this.nivelMazmorra - 3) {
            monstruos.put(monstruo, 1);
        }
    }

    /**
     * Devuelve el nivel de la mazmorra.
     *
     * @return Nivel de la mazmorra.
     */
    public int getNivelMazmorra() {
        return nivelMazmorra;
    }

    /**
     * Establece el nivel de la mazmorra.
     *
     * @param nivelMazmorra Nuevo nivel de la mazmorra.
     */
    public void setNivelMazmorra(int nivelMazmorra) {
        this.nivelMazmorra = nivelMazmorra;
    }

    /**
     * Devuelve el nombre de la mazmorra.
     *
     * @return Nombre de la mazmorra.
     */
    public String getNombreMazmorra() {
        return nombreMazmorra;
    }

    /**
     * Establece el nombre de la mazmorra.
     *
     * @param nombreMazmorra Nombre nuevo para la mazmorra.
     */
    public void setNombreMazmorra(String nombreMazmorra) {
        this.nombreMazmorra = nombreMazmorra;
    }

    /**
     * Selecciona aleatoriamente un monstruo de la mazmorra.
     *
     * @return Monstruo aleatorio o null si no hay monstruos.
     */
    public Monstruo combateAleatorio() {
        if (monstruos.isEmpty()) {
            return null;
        }

        int tamaño = monstruos.size();
        int indice = (int) (Math.random() * tamaño);

        int contador = 0;
        for (Monstruo m : monstruos.keySet()) {
            if (contador == indice) {
                return m;
            }
            contador++;
        }

        return null;
    }

    /**
     * Devuelve la información de la mazmorra como cadena.
     *
     * @return Cadena con nombre, nivel y monstruos.
     */
    @Override
    public String toString() {
        String resultado = "El nombre de la mazmorra es: " + nombreMazmorra + "\n" +
                "El nivel de la mazmorra es: " + nivelMazmorra + "\n" +
                "Monstruos en la mazmorra:\n";

        for (Monstruo m : monstruos.keySet()) {
            resultado += "- " + m.toString() + "\n";
        }

        return resultado;
    }


}