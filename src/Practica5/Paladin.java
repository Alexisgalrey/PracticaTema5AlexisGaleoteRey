package Practica5;

public class Paladin extends Creyente {

    public Paladin() {
        super();
    }

    public Paladin(String nombre, String raza, int fe) {

        super(nombre, raza, fe);
    }


    public void subirNivel() {
        setNivel(getNivel());

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 50) {
            setVitalidad(getVitalidad() + (int) (1.1 * 0.05));
        }
        if (probabilidad >= 40) {
            setFuerza(getFuerza() + getNivel());

        }
        if (probabilidad >= 85) {
            setAgilidad(getAgilidad() + getNivel() / 4);
        }
        if (probabilidad >= 30) {
            setFortalezaFisica(getFortalezaFisica() + getNivel() * 2);
        }
        if (probabilidad >= 70) {
            setFe(getFe() + getNivel());
        }
    }

    public void plegaria(int a, String objetivo) {
        switch (a) {
            case 1:
                System.out.println("Imbuir arma");
                break;

            case 2:
                System.out.println("Baluarte de fe");
                break;
        }
    }

    public String toString() {

        return "La fe del paladin es de: " + getFe();
    }
}