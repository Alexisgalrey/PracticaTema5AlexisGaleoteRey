package Practica5;

public class Monstruo extends Personaje {

    public Monstruo() {
        super();

    }

    public Monstruo(String nombre, String raza) {
        super(nombre, raza);
    }

    public void setRaza() {
        switch (getRaza()) {
            case "Bestia":
                setFortalezaFisica(getNivel() /  2);
                setResistenciaMagica(getNivel() / 2);
                setFuerza(getNivel() * 2);
                setAgilidad(getNivel() * 2);
                setVitalidad(getNivel());
                break;

            case "No-muerto":
                setFortalezaFisica(getNivel() / 2);
                setResistenciaMagica(getNivel() * 4);
                setFuerza(getNivel());
                setAgilidad(getNivel() / 4);
                setVitalidad(getNivel() / 2);
                break;

            case "Gigante":
                setFortalezaFisica(getNivel());
                setResistenciaMagica(getNivel() / 4);
                setFuerza(getNivel() * 4);
                setAgilidad(getNivel() / 4);
                setVitalidad(getNivel() * 4);
                break;
        }
    }

    public String toString() {
        return "Este monstruo es: " + getRaza()
                + "\n" + super.toString();
    }
}