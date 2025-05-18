package Practica5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que representa a un Clérigo, que hereda de Creyente.
 */
public class Clerigo extends Creyente {
    /**
     * Constructor por defecto que inicializa un Clérigo con valores predeterminados.
     */
    public Clerigo() {
        super();
    }

    /**
     * Constructor que inicializa un Clerigo con nombre, raza y valor de fe.
     *
     * @param nombre Nombre del Clérigo.
     * @param raza   Raza del Clérigo.
     * @param fe     Valor de la fe del Clérigo.
     */
    public Clerigo(String nombre, String raza, double fe) {

        super(nombre, raza, fe);
    }

    // EJERCICIO 3 TEMA 7             !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    /**
     * Equipa un arma si es un bastón.
     * Si el arma no es bastón, muestra un mensaje indicando que los clérigos solo pueden usar bastones.
     *
     * @param arma El arma que se quiere equipar.
     */
    public void equiparArma(Arma arma) {
        String tipoArma = arma.getTipo();
        if (tipoArma.equals("baston")) {
            super.equiparArma(arma);
        } else {
            System.out.println("Los clerigos solo pueden usar bastones");
        }
    }

    /**
     * Equipa una armadura si es de tela.
     * Si la armadura no es de tela, muestra un mensaje indicando que los clérigos solo pueden usar armaduras de tela.
     *
     * @param armadura La armadura que se quiere equipar.
     */
    public void equiparArmadura(Armadura armadura) {
        String tipoMaterial = armadura.getMaterial();
        if (tipoMaterial.equals("tela")) {
            super.equiparArmadura(armadura);
        } else {
            System.out.println("Los clerigos solo puede usar armaduras de tela");
        }
    }

    /**
     * Constructor de la clase Clerigo que inicializa los atributos del personaje
     * leyendo los datos desde un archivo de texto.
     *
     * @param path Ruta del archivo de texto que contiene los datos del Clerigo.
     * @param fe   Valor inicial del atributo de fe.
     * @throws IOException Si ocurre un error al leer el archivo de datos.
     */

    public Clerigo(String path, double fe) throws IOException {
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
     * Verifica y actualiza los atributos del Clerigo comparando los valores actuales
     * con los valores proporcionados.
     *
     * @param nombreFicha            Nombre del personaje.
     * @param razaFicha              Raza del personaje.
     * @param estadoFicha            Estado de vida del personaje.
     * @param nivelFicha             Nivel del personaje.
     * @param vitalidadFicha         Vitalidad del personaje.
     * @param fuerzaFicha            Fuerza del personaje.
     * @param agilidadFicha          Agilidad del personaje.
     * @param fortalezaFisicaFicha   Fortaleza física del personaje.
     * @param resistenciaMagicaFicha Resistencia mágica del personaje.
     * @param feFicha                Valor de fe a verificar y actualizar.
     * @throws IOException Si ocurre un error al leer el archivo de datos.
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
     * Metodo para subir el nivel del Clérigo.
     */
    public void subirNivel() {
        setNivel(getNivel());

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 80) {
            setVitalidad(getVitalidad() / 2);
        }
        if (probabilidad >= 90) {
            setFuerza(getFuerza() + getNivel() / 4);

        }
        if (probabilidad >= 80) {
            setFortalezaFisica(getFortalezaFisica() + getNivel() / 2);
        }
        if (probabilidad >= 20) {
            setFe((int) (getFe() + getNivel() * 2));
        }
        if (probabilidad >= 20) {
            setResistenciaMagica(getResistenciaMagica() + getNivel() * 2);
        }
    }

    /**
     * Metodo para realizar una plegaria, con diferentes efectos según el parámetro.
     *
     * @param tipo     El tipo de plegaria que se desea realizar (1, 2 o 3).
     * @param objetivo El objetivo de la plegaria.
     */

    public double plegaria(int tipo, String objetivo) {
        switch (tipo) {
            case 1:
                return 0.7 * this.getFe();
            case 2:
                return 0.35 * this.getFe();
            case 3:
                return 0.55 * this.getFe();
            default:
                return 0;
        }
    }

    /**
     * Metodo para luchar, utilizando el valor de hechizo.
     *
     * @param tipo     El valor del hechizo que el Clérigo usa en combate.
     * @param objetivo objetivo de la plegaria.
     */
    public double luchar(int tipo, String objetivo) {
        if (tipo == 3)
            return this.plegaria(tipo, objetivo);
        else return 0;
    }

    /**
     * Metodo para apoyar a un aliado, utilizando el valor de hechizo.
     *
     * @param tipo     El tipo de hechizo que se usa para apoyar (1 o 2).
     * @param objetivo Objetivo de la plegaria.
     */
    public double apoyo(int tipo, String objetivo) {
        if (tipo == 1 || tipo == 2)
            return this.plegaria(tipo, objetivo);
        else return 0;
    }

    /**
     * Representación en texto del Clérigo.
     *
     * @return Una cadena con la información sobre la fe del Clérigo.
     */
    public String toString() {
        return super.toString() + "La fe del clerigo es de: " + getFe();
    }

}
