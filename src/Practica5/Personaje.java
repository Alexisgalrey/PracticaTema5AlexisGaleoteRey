package Practica5;

public abstract class Personaje {
    private String nombre;
    private String raza;
    private Boolean estado;
    private int nivel;
    private double vitalidad;
    private double fuerza;
    private double agilidad;
    private double fortalezaFisica;
    private double resistenciaMagica;


    public Personaje() {
        nombre = "";
        raza = "";
        nivel = 1;
        vitalidad = 100;
        fuerza = 10;
        agilidad = 10;
        fortalezaFisica = 10;
        resistenciaMagica = 10;
        estado = true;
    }

    public Personaje(String nombre, String raza, boolean estado, int nivel, int vitalidad, int fuerza, int agilidad, int fortalezaFisica, int resistenciaMagica) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = 10;
        this.vitalidad = 100;
        this.fuerza = 10;
        this.agilidad = 10;
        this.fortalezaFisica = 10;
        this.resistenciaMagica = 10;
        this.estado = true;
    }

    public Personaje(Personaje copia) {
        this.nombre = copia.nombre;
        this.raza = copia.raza;
        this.estado = copia.estado;
        this.nivel = copia.nivel;
        this.vitalidad = copia.vitalidad;
        this.fuerza = copia.fuerza;
        this.agilidad = copia.agilidad;
        this.fortalezaFisica = copia.fortalezaFisica;
        this.resistenciaMagica = copia.resistenciaMagica;

    }

    public Personaje(String nombre, String raza) {
        setNombre(nombre);
        setRaza(raza);
        this.nivel = 1;
        this.vitalidad = 100;
        this.fuerza = 10;
        this.agilidad = 10;
        this.fortalezaFisica = 10;
        this.resistenciaMagica = 10;
        this.estado = true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(double vitalidad) {
        this.vitalidad = vitalidad;
    }

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    public double getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(double agilidad) {
        this.agilidad = agilidad;
    }

    public double getFortalezaFisica() {
        return fortalezaFisica;
    }

    public void setFortalezaFisica(double fortalezaFisica) {
        this.fortalezaFisica = fortalezaFisica;
    }

    public double getResistenciaMagica() {
        return resistenciaMagica;
    }

    public void setResistenciaMagica(double resistenciaMagica) {
        this.resistenciaMagica = resistenciaMagica;
    }

    public void setNombre(String nombre) {
        if (nombre.length() >= 4) {
            if (nombre.contains(" ")) {
                this.nombre = nombre.replace(" ", "");
            }
            this.nombre = nombre;
        } else {
            this.nombre = "";
        }
    }

    public void setRaza(String raza) {
        if (raza.contains("angel") || raza.contains("demonio")) {
            System.out.println("La raza no puede ser ni angel ni demonio");
            this.raza = "";
        }
    }

    public void subirNivel() {
        nivel++;
        vitalidad = vitalidad + 10 / 100;
        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 50) {
            fuerza += nivel;
        }
        if (probabilidad >= 50) {
            agilidad = +nivel;
        }
        if (probabilidad >= 50) {
            fortalezaFisica = +nivel;
        }
        if (probabilidad >= 50) {
            resistenciaMagica = +nivel;
        }
    }


    public double luchar() {
        return getFuerza();
    }


    public void defender(double ataque, String tipo) {
        if (tipo.equals("físico"))
            this.setVitalidad(this.getVitalidad() - (ataque - this.getFortalezaFisica()));
        else if (tipo.equals("mágico"))
            this.setVitalidad(this.getVitalidad() - (ataque - this.getResistenciaMagica()));
    }

    public String nombreClase() {
        return this.getClass().getSimpleName();
    }


    public String toString() {
        String resultado = "Ficha del personaje " + getNombre() + "\n" +
                "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Clase: " + nombreClase() + "\n" +
                "Raza: " + getRaza() + "\n" + "\n" +
                "Nivel: " + getNivel() + "\n" +
                "Vida: " + getVitalidad() + "\n" +
                "Ataque: " + getFuerza() + "\n" +
                "Velocidad: " + getAgilidad() + "\n" +
                "Armadura: " + getFortalezaFisica() + "\n" +
                "Resistencia mágica: " + getResistenciaMagica() + "\n";
        if (estado = true) {
            resultado += "Esta actualmente: vivo";
        } else {
            resultado += "Esta actualmente: muerto";
        }
        return resultado;
    }
}
