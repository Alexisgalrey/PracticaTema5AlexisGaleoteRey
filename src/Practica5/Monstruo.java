package Practica5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Monstruo extends Personaje {

    public Monstruo() {
        super();

    }

    public Monstruo(String nombre, String raza) {
        super(nombre, raza);
    }

    public Monstruo(String path) throws IOException {
        FileReader fr = new FileReader(path + ".txt");
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
        fr.close();
    }

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

    public String toString() {
        return "Este monstruo es: " + getRaza();
    }
}