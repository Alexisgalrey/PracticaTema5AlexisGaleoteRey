package Practica5;

public abstract class Personaje {
    private String nombre;
    private String raza;
    private Boolean estado;
    private int nivel;
    private int vitalidad;
    private int fuerza;
    private int agilidad;
    private int fortalezaFisica;
    private int resistenciaMagica;


    public Personaje() {
        nombre = "";
        raza = "";
        estado = true;
        nivel = 1;
        vitalidad = 100;
        fuerza = 10;
        agilidad = 10;
        fortalezaFisica = 10;
        resistenciaMagica = 10;
    }

    public Personaje(String nombre, String raza, boolean estado, int nivel, int vitalidad, int fuerza, int agilidad, int fortalezaFisica, int resistenciaMagica) {
        this.nombre = nombre;
        this.raza = raza;
        this.estado = estado;
        this.nivel = 10;
        this.vitalidad = 100;
        this.fuerza = 10;
        this.agilidad = 10;
        this.fortalezaFisica = 10;
        this.resistenciaMagica = 10;
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
        this.estado = true;
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

    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getFortalezaFisica() {
        return fortalezaFisica;
    }

    public void setFortalezaFisica(int fortalezaFisica) {
        this.fortalezaFisica = fortalezaFisica;
    }

    public int getResistenciaMagica() {
        return resistenciaMagica;
    }

    public void setResistenciaMagica(int resistenciaMagica) {
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
        int probabilidad = (int) (Math.random() * 100 ) + 1;
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

    //DARLE VUELTAS PORQUE CREO QUE ESTA MAL
    public int luchar() {
        int luchar;
        luchar = fuerza;
        return luchar;
    }

    //DARLE VUELTAS EL SWITCH EN STRING
    public void defender(int luchar, String tipoDaño) {
        switch (tipoDaño) {
            case "fisico":
                luchar = luchar - fortalezaFisica;
                luchar -= vitalidad;
                break;
            case "magico":
                luchar -= resistenciaMagica;
                luchar -= vitalidad;
                break;
        }
    }

    public String toString() {
        String resultado = "Este Personaje se llama: /n" + getNombre() +
                "De raza: /n" + getRaza() +
                "Es de nivel: /n" + getNivel() +
                "Su vitalidad es: /n" + getVitalidad() +
                "Su fuerza es: /n" + getFuerza() +
                "Su agilidad es: /n" + getAgilidad() +
                "Su fortaleza fisica es: /n" + getFortalezaFisica() +
                "Y su resistencia magica es: /n" + getResistenciaMagica();
        if (estado = true) {
            System.out.println("El personaje esta vivo:");
        } else {
            System.out.println("El personaje esta muerto");
        }
        return resultado;
    }
}