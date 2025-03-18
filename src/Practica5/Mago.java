package Practica5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mago extends Personaje {
    private double magia;

    public Mago() {
        super();
        this.magia = -1;
    }

    public Mago(String nombre, String raza, int magia) {
        super(nombre, raza);
        setMagia(10);
    }

    public Mago(String path) throws IOException {
        FileReader fr = new FileReader(path + ".txt");
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
        fr.close();
    }


    public void setMagia(int magia) {
        this.magia = magia;
    }

    public double getMagia() {
        return magia;
    }

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

    public double lanzarConjuro(int hechizo, String objetivo){
        switch (hechizo){
            case 1:
                return 0.7*this.getMagia();
            case 2:
                return 0.5*this.getMagia();
            case 3:
                return 0.3*this.getMagia();
            case 4:
                return this.getMagia();
            default:
                System.err.println("ERROR. NO EXISTE EL CONJURO.");
                return 0;
        }
    }

        public double luchar ( int hechizo, String objetivo){
            if (hechizo == 1 || hechizo == 3)
                return this.lanzarConjuro(hechizo, objetivo);
            else {
                System.err.println("El hechizo no hace daño");
                return 0;
            }
        }

    public double apoyo(int conjuro, String objetivo){
        if (conjuro == 2 || conjuro == 4)
            return this.lanzarConjuro(conjuro, objetivo);
        else return 0;
    }


        public String toString () {
            String resultado = "";
            resultado =
             super.toString()
                    + "\n El mago tiene " + magia + " Puntos de magia. ";
            return resultado;

        }

    }

