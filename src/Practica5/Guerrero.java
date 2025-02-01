package Practica5;

public class Guerrero extends Personaje {

    private boolean furia;

    public Guerrero() {
        super();
        this.furia = false;
    }

    public Guerrero(String nombre, String raza, boolean estado, int nivel, int vitalidad, int fuerza, int agilidad, int fortalezaFisica, int resistenciaMagica, boolean furia) {
        super(nombre, raza, estado, nivel, vitalidad, fuerza, agilidad, fortalezaFisica, resistenciaMagica);
        this.furia = furia;
    }

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
        if (probabilidad >=   80) {
            setResistenciaMagica(getResistenciaMagica() + getNivel());
        }
    }

    public int luchar() {
        int luchar;
        luchar = getFuerza();
        if (furia == true) {
            setFuerza(getFuerza() * 2);
            setFortalezaFisica(getFortalezaFisica() / 2);
        } else {
            getFuerza();
        }
        return luchar;
    }

    public void defender(int luchar, String tipoDaño) {
        switch (tipoDaño) {
            case "fisico":
                if (furia == true) {

                }
                luchar = luchar - getFortalezaFisica();
                luchar -= getVitalidad();
                break;
            case "magico":
                luchar -= getResistenciaMagica();
                luchar -= getVitalidad();
                break;
        }
    }

    public String toString() {
        String resultado = "";
        if (furia) {
            resultado = super.toString()
                    + "\nEl guerrero está furioso.";
        } else {
            resultado = super.toString()
                    + "\nEl guerrero no está furioso.";
        }

        return resultado;
    }
}
