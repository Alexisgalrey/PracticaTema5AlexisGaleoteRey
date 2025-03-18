package Practica5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ladron extends Personaje {
    private boolean robar;


    public Ladron() {
        super();
        this.robar = false;

    }

    public Ladron(String nombre, String raza) {
        super(nombre, raza);
        this.robar = false;
    }

    public Ladron(String path) throws IOException {
        FileReader fr = new FileReader(path + ".txt");
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
        fr.close();
    }

    public void setRobar(boolean robar) {
        this.robar = robar;
    }

    public boolean getRobar() {
        return robar;
    }

    public double robar() {
        return getAgilidad();
    }

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


    public String toString() {
        String resultado = "";
        resultado = super.toString()
                + "\n El ladron tiene la habilidad especial robar:" + getRobar();
        return resultado;

    }
}
