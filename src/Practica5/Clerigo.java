package Practica5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Clerigo extends Creyente {

    public Clerigo() {
        super();
    }

    public Clerigo(String nombre, String raza, double fe) {

        super(nombre, raza, fe);
    }
    public Clerigo (String path) throws IOException {
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

    public double plegaria(int tipo , String objetivo) {
        switch (tipo) {
            case 1:
                return 0.7*this.getFe();
            case 2:
                return 0.35*this.getFe();
            case 3:
                return 0.55*this.getFe();
            default:
                return 0;
        }
    }

    public double luchar(int tipo, String objetivo){
        if(tipo == 3)
            return this.plegaria(tipo, objetivo);
        else return 0;
    }
    public double apoyo(int tipo, String objetivo){
        if (tipo == 1 || tipo == 2)
            return this.plegaria(tipo, objetivo);
        else return 0;
    }

    public String toString() {
        return super.toString() + "La fe del clerigo es de: " + getFe();
    }

}
