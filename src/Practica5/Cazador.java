package Practica5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cazador extends Personaje {

    private class CompaAnimal extends Personaje {

        public CompaAnimal() {
            super();
        }


        public CompaAnimal(String nombre, String raza) {
            super(nombre, raza);

        }


        @Override
        public void setRaza(String raza) {
            switch (raza.toLowerCase()) {
                case "cánido", "felino", "rapaz":
                    super.setRaza(raza);
                    break;
                default:
                    super.setRaza("");
            }
        }


        public String toString() {
            return super.toString();
        }
    }


    private CompaAnimal animalComp;


    public Cazador() {
        super();
        this.animalComp = new CompaAnimal();
    }


    public Cazador(String nombre, String raza, String animalNombre, String animalRaza) {
        super(nombre, raza);
        this.animalComp = new CompaAnimal(animalNombre, animalRaza);
        switch (this.animalComp.getRaza().toLowerCase()) {
            case "cánido":
                this.setCanido();
                break;
            case "felino":
                this.setFelino();
                break;
            case "rapaz":
                this.setRapaz();
                break;
        }
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


    @Override
    public double luchar() {
        return this.getFuerza() + this.animalComp.getFuerza();
    }


    public void setCanido() {
        this.animalComp.setVitalidad(0.2 * this.getVitalidad());
        this.animalComp.setFuerza(0.2 * this.getFuerza());
        this.animalComp.setFortalezaFisica(0.2 * this.getFortalezaFisica());
        this.animalComp.setResistenciaMagica(0.2 * this.getResistenciaMagica());
        this.animalComp.setAgilidad(0.2 * this.getAgilidad());
    }


    public void setFelino() {
        this.animalComp.setVitalidad(0.15 * this.getVitalidad());
        this.animalComp.setFuerza(0.3 * this.getFuerza());
        this.animalComp.setFortalezaFisica(0.15 * this.getFortalezaFisica());
        this.animalComp.setResistenciaMagica(0.15 * this.getResistenciaMagica());
        this.animalComp.setAgilidad(0.3 * this.getAgilidad());
    }


    public void setRapaz() {
        this.animalComp.setVitalidad(0.05 * this.getVitalidad());
        this.animalComp.setFuerza(0.15 * this.getFuerza());
        this.animalComp.setFortalezaFisica(0.05 * this.getFortalezaFisica());
        this.animalComp.setResistenciaMagica(0.25 * this.getResistenciaMagica());
        this.animalComp.setAgilidad(0.35 * this.getAgilidad());
    }


    @Override
    public String toString() {
        return super.toString() +
                "\nAdemás, tiene un compañero animal: " +
                this.animalComp.toString();
    }
}