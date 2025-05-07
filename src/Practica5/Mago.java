package Practica5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que representa un Mago, que hereda de Personaje.
 * Posee habilidades magicas y puede lanzar conjuros.
 */
public class Mago extends Personaje {
    private double magia;

    /**
     * constructor por defecto que inicializa un Mago con un valor base de magia.
     */
    public Mago() {
        super();
        this.magia = -1;
    }

    /**
     * Constructor que inicializa un Mago con todos sus atributos.
     *
     * @param nombre Nombre del Mago.
     * @param raza   Raza del Mago.
     * @param magia  Puntos de magia del Mago.
     */
    public Mago(String nombre, String raza, int magia) {
        super(nombre, raza);
        setMagia(10);
    }

    // EJERCICIO 3 TEMA 7             !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    @Override
    public void equiparArma(Arma arma) {
        String tipoArma = arma.getTipo();
        if (tipoArma.equals("cetro") || tipoArma.equals("baston")) {
            super.equiparArma(arma);
        } else {
            System.out.println("Los magos solo pueden usar cetros o bastones.");
        }
    }

    @Override
    public void equiparArmadura(Armadura armadura) {
           String material = armadura.getMaterial();
        if (material.equals("tela")) {
            super.equiparArmadura(armadura);
        } else {
            System.out.println("La armadura de los magos debe ser de tela.");
        }
    }


    /**
     * Constructor que inicializa un Mago a partir de un archivo de texto y asigna su magia.
     *
     * @param path  Ruta del archivo.
     * @param magia Valor de la magia del Mago.
     * @throws IOException Si ocurre un error de lectura del archivo.
     */

    public Mago(String path, double magia) throws IOException {
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
                this.magia = Double.parseDouble(campos[1]);
            }
        }
    }

    /**
     * Verifica y actualiza los atributos del mago según los datos de la ficha.
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
     * @param magiaFicha             Valor de la magia del mago en la ficha.
     * @throws IOException Si ocurre un error de lectura.
     */

    public void verificarFicha(String nombreFicha, String razaFicha, boolean estadoFicha, int nivelFicha, double vitalidadFicha, double fuerzaFicha,
                               double agilidadFicha, double fortalezaFisicaFicha, double resistenciaMagicaFicha, double magiaFicha) throws IOException {

        super.verificarFicha(nombreFicha, razaFicha, estadoFicha, nivelFicha, vitalidadFicha, fuerzaFicha,
                agilidadFicha, fortalezaFisicaFicha, resistenciaMagicaFicha);

        if ((this.magia == magiaFicha) == false) {
            this.magia = magiaFicha;
        }
    }

    /**
     * Establece los puntos de magia del Mago.
     *
     * @param magia cantidad de puntos de magia.
     */
    public void setMagia(int magia) {
        this.magia = magia;
    }

    /**
     * Obtiene los puntos de magia del Mago.
     *
     * @return Puntos de magia.
     */
    public double getMagia() {
        return magia;
    }

    /**
     * Aumenta el nivel del Mago.
     */
    public void subirNivel() {   //PREGUNTAR PROFESOR LO DE RECIBEN MITAD Y UN CUARTO
        setNivel(getNivel());

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 65) {
            setVitalidad(getVitalidad() * (int) 1.05);
        }
        if (probabilidad >= 85) {
            setFuerza(getFuerza() + getNivel() * (int) 0.25);

        }
        if (probabilidad >= 35) {
            setAgilidad(getAgilidad() + getNivel());
        }
        if (probabilidad >= 65) {
            setFortalezaFisica(getFortalezaFisica() + getNivel() * (int) 0.5);
        }
        if (probabilidad >= 20) {
            setResistenciaMagica(getResistenciaMagica() + getNivel());
        }

        if (probabilidad >= 10) {
            magia += getNivel();

        }

    }

    /**
     * Permite al Mago lanzar un conjuro sobre un objetivo.
     *
     * @param hechizo  tipo de hechizo.
     * @param objetivo Objetivo del conjuro.
     */
    public double lanzarConjuro(int hechizo, String objetivo) {
        switch (hechizo) {
            case 1:
                return 0.7 * this.getMagia();
            case 2:
                return 0.5 * this.getMagia();
            case 3:
                return 0.3 * this.getMagia();
            case 4:
                return this.getMagia();
            default:
                System.err.println("ERROR. NO EXISTE EL CONJURO.");
                return 0;
        }
    }

    /**
     * Metodo que define la acción de lucha del Mago.
     *
     * @param hechizo Hechizo utilizado en la lucha.
     * @return Valor del hechizo utilizado.
     */
    public double luchar(int hechizo, String objetivo) {
        if (hechizo == 1 || hechizo == 3)
            return this.lanzarConjuro(hechizo, objetivo);
        else {
            System.err.println("El hechizo no hace daño");
            return 0;
        }
    }

    /**
     * Metoodo que permite al Mago apoyar a un aliado.
     *
     * @param conjuro  Tipo de apoyo.
     * @param objetivo Aliado beneficiado.
     */
    public double apoyo(int conjuro, String objetivo) {
        if (conjuro == 2 || conjuro == 4)
            return this.lanzarConjuro(conjuro, objetivo);
        else return 0;
    }

    /**
     * Representación en texto del Mago.
     *
     * @return Cadena con la información del Mago y sus atributos.
     */
    public String toString() {
        String resultado = "";
        resultado =
                super.toString()
                        + "\nLos puntos de magia del mago son: " + magia;
        return resultado;

    }

}

