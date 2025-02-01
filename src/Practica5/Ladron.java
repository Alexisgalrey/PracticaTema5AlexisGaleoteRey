package Practica5;

public class Ladron extends Personaje {
    private boolean robar;


    public Ladron() {
        super();
        this.robar = false;

    }

    public Ladron(String nombre, String raza, boolean estado, int nivel, int vitalidad, int fuerza, int agilidad, int fortalezaFisica, int resistenciaMagica, boolean robar) {
        super(nombre, raza, estado, nivel, vitalidad, fuerza, agilidad, fortalezaFisica, resistenciaMagica);
        this.robar = false;
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
            setAgilidad(getAgilidad() + getNivel() * (int) 2);
        }
        if (probabilidad >= 60) {
            setFortalezaFisica(getFortalezaFisica() + getNivel());
        }
        if (probabilidad >= 60) {
            setResistenciaMagica(getResistenciaMagica() + getNivel());
        }
    }


    public String toString() {
        String resultado = super.toString()
                + "\n El ladron tiene la habilidad especial robar:" + getRobar();
        return resultado;

    }
}
