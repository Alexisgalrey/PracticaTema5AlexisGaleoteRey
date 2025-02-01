package Practica5;

public class Clerigo extends Creyente {

    public Clerigo() {
        super();
    }

    public Clerigo(String nombre, String raza, int fe) {

        super(nombre, raza, fe);
    }

    public double luchar(double hechizo) {
        return hechizo;
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
            setFe(getFe() + getNivel() * 2);
        }
        if (probabilidad >= 20) {
            setResistenciaMagica(getResistenciaMagica() + getNivel() * 2);
        }
    }

    public void plegaria(int a , String objetivo) {
        switch (a) {
            case 1:
                System.out.println("Sana el 70% de sus puntos de fe como vida a un aliado.");
                break;

            case 2:
                System.out.println(" sana el 35% de sus puntos de fe como vida a todo el grupo.");
                break;

            case 3:
                System.out.println("Causa el 55% de sus puntos de fe como daño sagrado a un objetivo.");
                break;
        }
    }

    public void apoyar(int hechizo, String b) {
        if (hechizo == 1) {
            setVitalidad(getFe() * (int) 0.7);
        }
        if (hechizo == 2) {
            setVitalidad(getFe() * (int) 0.7);
        }
    }

    public String toString() {
        return "La fe del clerigo es de: " + getFe();
    }

}
