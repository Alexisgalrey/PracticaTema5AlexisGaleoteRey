package Practica5;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Guerrero extends Personaje {

    private boolean furia;

    public Guerrero() {
        super();
        this.furia = false;
    }

    public Guerrero(String nombre, String raza, boolean furia) {
        super(nombre, raza);
        this.furia = furia;
    }

   /* public Guerrero(String path) throws IOException {
        FileReader fr = new FileReader(path + ".txt");
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
        fr.close();

    }

*/
    public boolean getFuria() {
        return furia;
    }

    public void subirNivel() {
        setNivel(getNivel());

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 25) {
            setVitalidad(getVitalidad() + 10 / 100);
        }
        if (probabilidad >= 20) {
            setFuerza(getFuerza() + getNivel() * 2);

        }
        if (probabilidad >= 50) {
            setAgilidad(getAgilidad() + getNivel());
        }
        if (probabilidad >= 25) {
            setFortalezaFisica(getFortalezaFisica() + getNivel());
        }
        if (probabilidad >= 80) {
            setResistenciaMagica(getResistenciaMagica() + getNivel());
        }
    }

    public double luchar() {
        if (getFuria())
            return this.getFuerza() * 2;
        else return this.getFuerza();
    }

    public void defender(int ataque, String tipo) {
        if (tipo.equals("físico"))
            if (getFuria())
                this.setVitalidad(this.getVitalidad() - (ataque - 0.5 * this.getFortalezaFisica()));
            else this.setVitalidad(this.getVitalidad() - (ataque - this.getFortalezaFisica()));
        else if (tipo.equals("mágico"))
            this.setVitalidad(this.getVitalidad() - (ataque - this.getResistenciaMagica()));
    }

    public String toString() {
        String resultado = "";
        if (furia == true) {
            resultado = super.toString()
                    + "\nEl guerrero está furioso.";
        } else {
            resultado = super.toString()
                    + "\nEl guerrero no está furioso.";
        }

        return resultado;
    }

}