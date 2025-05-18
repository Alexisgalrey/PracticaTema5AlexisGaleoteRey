package Practica5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que representa un Monstruo, que hereda de Personaje.
 */
public class Monstruo extends Personaje {

    private int nivelMonstruo;


    /**
     * Constructor por defecto que inicializa un Monstruo con valores base.
     */
    public Monstruo() {
        super();
        nivelMonstruo = 0;

    }

    /**
     * Constructor que inicializa un Monstruo con nombre y raza.
     *
     * @param nombre Nombre del Monstruo.
     * @param raza   Raza del Monstruo.
     */
    public Monstruo(String nombre, String raza, int nivelMonstruo) {
        super(nombre, raza);
        this.nivelMonstruo = nivelMonstruo;
    }

//EJERCICIO 3                                                       !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    /**
     * equipa un arma al personaje según su raza.
     * Solo los "No-muertos" pueden usar armas.
     *
     * @param arma Arma a intentar equipar.
     */
    public void puedeEquiparArma(Arma arma) {
        switch (getRaza()) {
            case "No-muertos":
                super.equiparArma(arma);
                break;
            case "bestias":
                System.out.println("Las bestias no pueden llevar arma");
                break;
            case "gigantes":
                System.out.println("Los gigantes no pueden llevar arma");
                break;
            default:
                System.out.println("Solo los no muertos pueden usar armas.");
                ;
        }
    }

    /**
     * equipa una armadura al personaje según su raza y el material.
     * Solo los "Gigantes" pueden usar armaduras de cuero.
     *
     * @param tipoMaterial Material de la armadura (tela, cuero, metal).
     * @param armadura     Armadura a intentar equipar.
     */
    public void puedeEquiparArmadura(String tipoMaterial, Armadura armadura) {
        switch (getRaza()) {
            case "Gigantes":
                if (tipoMaterial.equals("cuero")) {
                    super.equiparArmadura(armadura);
                }
                break;
            case "no-muertos":
                System.out.println("Los no muertos no llevan armadura");
                break;
            case "bestias":
                System.out.println("Las bestias no pueden llevar armadura");
                break;
            default:
                System.out.println("Solo los gigantes pueden usar armadura");
        }
    }

    /**
     * equipa un artefacto al personaje según su raza y tipo.
     * Solo las "Bestias" pueden equipar artefactos, y solo si son "amuleto".
     *
     * @param tipoArtefacto Tipo de artefacto (amuleto o anillo).
     * @param artefacto     Artefacto a intentar equipar.
     */
    public void puedeEquiparArtefacto(String tipoArtefacto, Artefacto artefacto) {
        switch (getRaza()) {
            case "bestias":
                if (tipoArtefacto.equals("amuleto")) {
                    super.equiparArtefacto(artefacto);
                }
                break;
            case "Gigantes":
                System.out.println("Los gigantes no pueden equipar artefactos.");
                break;
            case "no-muertos":
                System.out.println("Los no muertos no pueden equipar artefactos.");
                break;

            default:
                System.out.println("Solo las bestias pueden usar artefactos");
        }
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


    public int getNivelMonstruo() {
        return nivelMonstruo;
    }

    public void setNivelMonstruo(int nivelMonstruo) {
        this.nivelMonstruo = nivelMonstruo;
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