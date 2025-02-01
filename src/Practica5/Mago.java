package Practica5;

public class Mago extends Personaje {
    private int magia;

    public Mago(int magia) {
        super();
        this.magia = 10;
    }

    public Mago(String nombre, String raza, boolean estado, int nivel, int vitalidad, int fuerza, int agilidad, int fortalezaFisica, int resistenciaMagica, int magia) {
        super(nombre, raza, estado, nivel, vitalidad, fuerza, agilidad, fortalezaFisica, resistenciaMagica);
        setMagia(10);
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public int getMagia() {
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

    public void lanzarConjuro(int hechizo, String objetivo) {
        switch (hechizo) {
            case (1):
                hechizo = getVitalidad() - magia * (int) 0.75;
                break;
            case (2):
                hechizo = getFortalezaFisica() + magia * (int) 0.5;
                hechizo = getResistenciaMagica() + magia * (int) 0.5;
                break;
            case (3):
                hechizo = getVitalidad() + magia * (int) 0.3;
                break;
            case (4):
                hechizo = getAgilidad() + magia;
                break;

        }
    }

    public int luchar(int hechizo, String Personaje) {
        return hechizo;
    }

    public void apoyar(int hechizo, String b) {
        if (hechizo == 2) {
            setFortalezaFisica(getMagia() * (int) 0.5);
            setResistenciaMagica(getMagia() * (int) 0.5);
        }
        if (hechizo == 4) {
            setAgilidad(getMagia() * 2);
        }
    }


    public String toString() {
        String resultado = super.toString()
                + "\n El mago tiene " + magia + " Puntos de magia. ";
        return resultado;

    }

}

