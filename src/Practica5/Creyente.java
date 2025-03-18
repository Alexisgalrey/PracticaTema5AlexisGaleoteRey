package Practica5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Creyente extends Personaje {

    public double fe;

    public Creyente() {
        super();
        this.fe = -1;
    }

    public Creyente(String nombre, String raza, double fe) {
        super(nombre,  raza);
        this.fe = fe;
    }

    public Creyente (String path) throws IOException {
        FileReader fr = new FileReader(path + ".txt");
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
        fr.close();
    }


    public void setFe(double fe) {

        this.fe = fe;
    }

    public double getFe() {

        return fe;
    }

    public abstract double plegaria(int tipo, String objetivo);

    public String toString() {
        return super.toString() + "\n El creyente tiene una fe de: " + getFe();
    }
}


