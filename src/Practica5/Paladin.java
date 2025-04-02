package Practica5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que representa un Paladín, que hereda de Creyente.
 * Posee habilidades de combate y fe.
 */
public class Paladin extends Creyente {
    /**
     * Constructor por defecto que inicializa un Paladín con valores base.
     */
    public Paladin() {
        super();
    }

    /**
     * Constructor que inicializa un Paladín con nombre, raza y fe.
     *
     * @param nombre Nombre del Paladín.
     * @param raza   Raza del Paladín.
     * @param fe     Nivel de fe del Paladín.
     */
    public Paladin(String nombre, String raza, double fe) {

        super(nombre, raza, fe);
    }

    /**
     * Constructor que inicializa un Paladín a partir de un archivo de texto y asigna su fe.
     *
     * @param path Ruta del archivo.
     * @param fe   Valor de la fe del Paladín.
     * @throws IOException Si ocurre un error de lectura del archivo.
     */
    // EJERCICIO 3:
    public Paladin(String path, double fe) throws IOException {
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
                this.fe = Double.parseDouble(campos[1]);
            }
        }
    }

    /**
     * Verifica y actualiza los atributos del paladín según los datos de la ficha.
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
     * @param feFicha                Valor de la fe del paladín en la ficha.
     * @throws IOException Si ocurre un error de lectura.
     */
    // EJERCICIO 4:
    public void verificarFicha(String nombreFicha, String razaFicha, boolean estadoFicha, int nivelFicha, double vitalidadFicha, double fuerzaFicha,
                               double agilidadFicha, double fortalezaFisicaFicha, double resistenciaMagicaFicha, double feFicha) throws IOException {

        super.verificarFicha(nombreFicha, razaFicha, estadoFicha, nivelFicha, vitalidadFicha, fuerzaFicha,
                agilidadFicha, fortalezaFisicaFicha, resistenciaMagicaFicha);

        if ((this.fe == feFicha) == false) {
            this.fe = feFicha;
        }
    }

    /**
     * Metodo para subir de nivel al Paladín.
     */

    public void subirNivel() {
        setNivel(getNivel());

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 50) {
            setVitalidad(getVitalidad() + ((1.1 * 0.05)));
        }
        if (probabilidad >= 40) {
            setFuerza(getFuerza() + getNivel());

        }
        if (probabilidad >= 85) {
            setAgilidad(getAgilidad() + getNivel() + 0.25);
        }
        if (probabilidad >= 30) {
            setFortalezaFisica(getFortalezaFisica() + getNivel() * 2);
        }
        if (probabilidad >= 70) {
            setFe(getFe() + getNivel());
        }
    }

    /**
     * Metodo que permite al Paladín realizar una plegaria especial.
     *
     * @param tipo     Tipo de plegaria a ejecutar.
     * @param objetivo Objetivo de la plegaria.
     */
    public double plegaria(int tipo, String objetivo) {
        switch (tipo) {
            case 1:
                System.out.println("Imbuir arma");
                return 0.8 + this.getFe();
            case 2:
                System.out.println("Baluarte de fe");
                return 0.3 + this.getFe();
        }
        return 0;
    }

    /**
     * Representación en texto del Paladín.
     *
     * @return Cadena con la información de la fe del Paladín.
     */
    public String toString() {

        return super.toString() + "La fe del paladin es de: " + getFe();
    }
}