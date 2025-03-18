package Practica5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Paladin extends Creyente {

    public Paladin() {
        super();
    }

    public Paladin(String nombre, String raza, double fe) {

        super(nombre, raza, fe);
    }

    public Paladin(String path) throws IOException {
        FileReader fr = new FileReader(path + ".txt");
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
        fr.close();
    }


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

    public String toString() {

        return super.toString() + "La fe del paladin es de: " + getFe();
    }
}