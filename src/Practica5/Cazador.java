package Practica5;

public class Cazador extends Personaje {

    Mascota mascota;

    public Cazador() {
        super();
        this.mascota = new Mascota();
    }

    public Cazador(String nombre, String raza, boolean estado, int nivel, int vitalidad, int fuerza, int agilidad, int fortalezaFisica, int resistenciaMagica) {
        super(nombre, raza, estado, nivel, vitalidad, fuerza, agilidad, fortalezaFisica, resistenciaMagica);
        this.mascota = new Mascota();
    }

    public Cazador(String nombre, String raza, String razaAnimal) {
        super(nombre, raza);
        this.mascota = new Mascota(razaAnimal);
    }

    public int luchar() {
        return getFuerza() + mascota.getFuerza();
    }

    public void subirNivel() {
        setNivel(getNivel());

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 50) {
            setVitalidad(getVitalidad());
        }
        if (probabilidad >= 50) {
            setFuerza(getFuerza() + getNivel());

        }
        if (probabilidad >= 30) {
            setAgilidad(getAgilidad() + getNivel());
        }
        if (probabilidad >= 50) {
            setFortalezaFisica(getFortalezaFisica() + getNivel());
        }
        if (probabilidad >= 50) {
            setResistenciaMagica(getResistenciaMagica() + getNivel());
        }
    }

    public String toString() {
        String resultado = super.toString()
                + "\n El cazador tiene una mascota: " + getRaza() ;
        return resultado;

    }

}

class Mascota extends Personaje {

    public Mascota() {
        super();
    }

    public Mascota(String raza) {
        super("Mascota", raza);
    }

    public void setRaza() {
        switch (getRaza().toLowerCase()) {
            case "canido":
                getRaza();
                break;

            case "felino":
                getRaza();
                break;

            case "rapaz":
                getRaza();
                break;

        }
    }

    public void ranido(String raza){
        setVitalidad(getVitalidad());
        setFuerza(getFuerza()* (int) 0.2);
        setFortalezaFisica(getFortalezaFisica() * (int) 0.2);
        setAgilidad(getAgilidad() * (int) 0.2);
        setResistenciaMagica(getResistenciaMagica() * (int) 0.2);
    }

    public void relino(String raza){
        setVitalidad(getVitalidad());
        setFuerza(getFuerza()* (int) 0.3);
        setFortalezaFisica(getFortalezaFisica() * (int) 0.15);
        setAgilidad(getAgilidad() * (int) 0.3);
        setResistenciaMagica(getResistenciaMagica() * (int) 0.15);
    }

    public void rapaz (String raza){
        setVitalidad(getVitalidad() * (int) 0.5);
        setFuerza(getFuerza()* (int) 0.15);
        setFortalezaFisica(getFortalezaFisica() * (int) 0.5);
        setAgilidad(getAgilidad() * (int) 0.35);
        setResistenciaMagica(getResistenciaMagica() * (int) 0.25);
    }

    public String toString(){

        return super.toString() + getRaza();
    }
}
