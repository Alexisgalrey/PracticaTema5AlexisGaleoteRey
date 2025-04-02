package Practica5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase Cazador que hereda de Personaje y representa un personaje con un compañero animal.
 */
public class Cazador extends Personaje {
    /**
     * Clase interna CompaAnimal que representa el compañero animal de un Cazador.
     */
    private class CompaAnimal extends Personaje {
        /**
         * Constructor por defecto de CompaAnimal.
         */
        public CompaAnimal() {
            super();
        }

        /**
         * Constructor que inicializa un compañero animal con un nombre y una raza.
         *
         * @param nombre Nombre del compañero animal.
         * @param raza   Raza del compañero animal.
         */
        public CompaAnimal(String nombre, String raza) {
            super(nombre, raza);

        }

        /**
         * Establece la raza del compañero animal, permitiendo solo ciertas razas.
         *
         * @param raza Raza a establecer.
         */
        @Override
        public void setRaza(String raza) {
            switch (raza.toLowerCase()) {
                case "cánido", "felino", "rapaz":
                    super.setRaza(raza);
                    break;
                default:
                    super.setRaza("");
            }
        }

        /**
         * Devuelve una representación en cadena del compañero animal.
         *
         * @return Representación en cadena del compañero animal.
         */

        public String toString() {
            return super.toString();
        }
    }


    private CompaAnimal animalComp;

    /**
     * Constructor por defecto de Cazador.
     */
    public Cazador() {
        super();
        this.animalComp = new CompaAnimal();
    }

    /**
     * Constructor que inicializa un Cazador con su compañero animal.
     *
     * @param nombre       Nombre del cazador.
     * @param raza         Raza del cazador.
     * @param animalNombre Nombre del compañero animal.
     * @param animalRaza   Raza del compañero animal.
     */

    public Cazador(String nombre, String raza, String animalNombre, String animalRaza) {
        super(nombre, raza);
        this.animalComp = new CompaAnimal(animalNombre, animalRaza);
        switch (this.animalComp.getRaza().toLowerCase()) {
            case "cánido":
                this.setCanido();
                break;
            case "felino":
                this.setFelino();
                break;
            case "rapaz":
                this.setRapaz();
                break;
        }
    }

    /**
     * Constructor que inicializa un Cazador a partir de un archivo de texto.
     *
     * @param path Ruta del archivo.
     * @throws IOException Si ocurre un error de lectura del archivo.
     */
    // EJERCICIO 3:
    public Cazador(String path) throws IOException {
        super(path);
        File fichero = new File(path + ".txt");
        if (fichero.canRead()) {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String[] campos = new String[1];
            for (int i = 0; br.readLine().length() > 13; i++) {
                br.readLine();
                linea = br.readLine();
                animalComp.toString();
            }
        }
    }

    /**
     * Verifica la ficha del personaje, incluyendo la del compañero animal.
     *
     * @param nombreFicha            Nombre del personaje.
     * @param razaFicha              Raza del personaje.
     * @param estadoFicha            Estado del personaje.
     * @param nivelFicha             Nivel del personaje.
     * @param vitalidadFicha         Vitalidad del personaje.
     * @param fuerzaFicha            Fuerza del personaje.
     * @param agilidadFicha          Agilidad del personaje.
     * @param fortalezaFisicaFicha   Fortaleza física del personaje.
     * @param resistenciaMagicaFicha Resistencia mágica del personaje.
     * @param compiFicha             Compañero animal del personaje.
     * @throws IOException Si ocurre un error de lectura.
     */
    // EJERCICIO 4:
    public void verificarFicha(String nombreFicha, String razaFicha, boolean estadoFicha, int nivelFicha, double vitalidadFicha, double fuerzaFicha,
                               double agilidadFicha, double fortalezaFisicaFicha, double resistenciaMagicaFicha, CompaAnimal compiFicha) throws IOException {

        super.verificarFicha(nombreFicha, razaFicha, estadoFicha, nivelFicha, vitalidadFicha, fuerzaFicha,
                agilidadFicha, fortalezaFisicaFicha, resistenciaMagicaFicha);

        if ((this.animalComp == compiFicha) == false) {
            this.animalComp = compiFicha;
        }
    }


    /**
     * Metodo para subir de nivel al Cazador y mejorar sus atributos aleatoriamente.
     */
    public void subirNivel() {
        setNivel(getNivel());

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 50) {
            setVitalidad(getVitalidad());
        }
        if (probabilidad >= 50) {
            setFuerza(getFuerza() + getNivel());

        }
        if (probabilidad >= 30) {
            setAgilidad(getAgilidad() + getNivel());
        }
        if (probabilidad >= 50) {
            setFortalezaFisica(getFortalezaFisica() + getNivel());
        }
        if (probabilidad >= 50) {
            setResistenciaMagica(getResistenciaMagica() + getNivel());
        }
    }

    /**
     * Calcula la fuerza total del Cazador considerando la fuerza de su compañero animal.
     *
     * @return Fuerza total del Cazador.
     */
    @Override
    public double luchar() {
        return this.getFuerza() + this.animalComp.getFuerza();
    }

    /**
     * Configura el compañero animal como un cánido.
     */

    public void setCanido() {
        this.animalComp.setVitalidad(0.2 * this.getVitalidad());
        this.animalComp.setFuerza(0.2 * this.getFuerza());
        this.animalComp.setFortalezaFisica(0.2 * this.getFortalezaFisica());
        this.animalComp.setResistenciaMagica(0.2 * this.getResistenciaMagica());
        this.animalComp.setAgilidad(0.2 * this.getAgilidad());
    }


    /**
     * Configura el compañero animal como un felino.
     */
    public void setFelino() {
        this.animalComp.setVitalidad(0.15 * this.getVitalidad());
        this.animalComp.setFuerza(0.3 * this.getFuerza());
        this.animalComp.setFortalezaFisica(0.15 * this.getFortalezaFisica());
        this.animalComp.setResistenciaMagica(0.15 * this.getResistenciaMagica());
        this.animalComp.setAgilidad(0.3 * this.getAgilidad());
    }

    /**
     * Configura el compañero animal como un rapaz.
     */
    public void setRapaz() {
        this.animalComp.setVitalidad(0.05 * this.getVitalidad());
        this.animalComp.setFuerza(0.15 * this.getFuerza());
        this.animalComp.setFortalezaFisica(0.05 * this.getFortalezaFisica());
        this.animalComp.setResistenciaMagica(0.25 * this.getResistenciaMagica());
        this.animalComp.setAgilidad(0.35 * this.getAgilidad());
    }

    /**
     * Devuelve una representación en cadena del Cazador y su compañero animal.
     *
     * @return Representación en cadena del Cazador.
     */

    @Override
    public String toString() {
        return super.toString() +
                "\nAdemás, tiene un compañero animal: " +
                this.animalComp.toString();
    }
}