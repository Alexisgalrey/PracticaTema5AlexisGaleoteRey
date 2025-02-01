package Practica5;

public abstract class Creyente extends Personaje {

    public int fe;

    public Creyente() {
        super();
        this.fe = -1;
    }

    public Creyente(String nombre, String raza, int fe) {
        super(nombre, raza);
        this.fe = fe;
    }

    public void setFe(int fe) {

        this.fe = fe;
    }

    public int getFe() {

        return fe;
    }

    public abstract void plegaria(int a, String objetivo);

    public String toString() {
        return super.toString() + "\n El creyente tiene una fe de: " + getFe();
    }
}


