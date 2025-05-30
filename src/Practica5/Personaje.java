package Practica5;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase abstracta que representa un personaje en un juego.
 * Contiene atributos como nombre, raza, estado (vivo o muerto), nivel, estadisticas y armas para equipar.
 */
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
    private Arma armaEquipada;
    private HashMap<String, Armadura> armaduraEquipada = new HashMap<>();
    private ArrayList<Artefacto> artefactoEquipado = new ArrayList<>(3);


    private static String rutaLectura = "/home/tarde/Escritorio/Asignaturas DAM/Asignaturas/Programacion/Tema 6/Practica/";
    private static String rutaEscritura = "/home/tarde/Escritorio/Asignaturas DAM/Asignaturas/Programacion/Tema 6/Practica/";

    /**
     * Constructor por defecto. Inicializa un personaje con valores predeterminados.
     */
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
        armaEquipada = new Arma();
        armaduraEquipada = new HashMap<>();
        artefactoEquipado = new ArrayList<>();

    }

    /**
     * Constructor con parámetros.
     *
     * @param nombre            Nombre del personaje.
     * @param raza              Raza del personaje.
     * @param estado            Estado del personaje (vivo o muerto).
     * @param nivel             Nivel del personaje.
     * @param vitalidad         Vida del personaje.
     * @param fuerza            Fuerza del personaje.
     * @param agilidad          Agilidad del personaje.
     * @param fortalezaFisica   Fortaleza física del personaje.
     * @param resistenciaMagica Resistencia mágica del personaje.
     * @param armaEquipada      Arma para equipar
     * @param armaduraEquipada  Armadura para equipar
     * @param artefactoEquipado Artefacto para equipar
     */
    public Personaje(String nombre, String raza, boolean estado, int nivel, int vitalidad, int fuerza, int agilidad, int fortalezaFisica, int resistenciaMagica,
                     String path, String nombreFichero, HashMap armaduraEquipada, Arma armaEquipada, ArrayList artefactoEquipado) throws IOException {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = 10;
        this.vitalidad = 100;
        this.fuerza = 10;
        this.agilidad = 10;
        this.fortalezaFisica = 10;
        this.resistenciaMagica = 10;
        setEstado(getEstado());
        this.armaEquipada = new Arma(armaEquipada);
        this.armaduraEquipada = new HashMap<>(armaduraEquipada);
        this.artefactoEquipado = new ArrayList<>(artefactoEquipado);
    }

    // EJERCICIO 3 TEMA 7             !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    /**
     * Equipa un arma al personaje.
     *
     * @param arma Arma a equipar.
     */
    public void equiparArma(Arma arma) {
        this.armaEquipada = new Arma(arma);
    }

    /**
     * Equipa una armadura si hay espacio y no hay otra del mismo tipo.
     *
     * @param armadura Armadura a equipar.
     */
    public void equiparArmadura(Armadura armadura) {
        if (armaduraEquipada.size() < 6 && !armaduraEquipada.containsKey(armadura.getTipo())) {
            armaduraEquipada.put(armadura.getTipo(), armadura);
        }
    }

    /**
     * Equipa un artefacto si hay espacio, cumpliendo las reglas de tipo (máx. 2 anillos y 1 amuleto).
     *
     * @param artefacto Artefacto a equipar.
     */
    public void equiparArtefacto(Artefacto artefacto) {
        if (artefactoEquipado.size() < 3) {
            int amuletos = 0;
            int anillos = 0;

            for (Artefacto a : artefactoEquipado) {
                String tipo = a.getTipo();
                if (tipo.equals("amuleto")) amuletos++;
                else if (tipo.equals("anillo")) anillos++;
            }

            String tipoArtefacto = artefacto.getTipo();
            if (tipoArtefacto.equals("amuleto") && amuletos <= 1) {
                artefactoEquipado.add(artefacto);
            } else if (tipoArtefacto.equals("anillo") && anillos <= 2) {
                artefactoEquipado.add(artefacto);
            }
        }
    }

    /**
     * Devuelve el arma equipada actualmente.
     *
     * @return Arma equipada.
     */
    public Arma getArmaEquipada() {
        return this.armaEquipada;
    }

    /**
     * Devuelve un mapa con la armadura equipada.
     *
     * @return Mapa de tipo de armadura y armadura.
     */
    public HashMap<String, Armadura> getArmaduraEquipada() {
        return new HashMap<>(this.armaduraEquipada);
    }

    /**
     * Devuelve una lista de artefactos equipados.
     *
     * @return Lista de artefactos.
     */
    public ArrayList<Artefacto> getArtefactos() {
        return new ArrayList<>(this.artefactoEquipado);
    }

// EJERCICIO 5 TEMA 7                                               !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    /**
     * Calcula la fuerza total del personaje sumando arma y artefactos.
     *
     * @return Fuerza total.
     */
    public double getFuerza() {
        double fuerzaTotal = this.fuerza;

        if (armaEquipada != null) {
            fuerzaTotal += armaEquipada.recuperaEstadistica("fuerza");
        }

        for (Artefacto artefacto : artefactoEquipado) {
            fuerzaTotal += artefacto.recuperaEstadistica("fuerza");
        }
        return fuerzaTotal;
    }

    /**
     * Calcula la agilidad total del personaje sumando arma y artefactos.
     *
     * @return Agilidad total.
     */
    public double getAgilidad() {
        double agilidadTotal = this.agilidad;

        if (armaEquipada != null) {
            agilidadTotal += armaEquipada.recuperaEstadistica("agilidad");
        }
        for (Artefacto artefacto : artefactoEquipado) {
            agilidadTotal += artefacto.recuperaEstadistica("agilidad");
        }
        return agilidadTotal;
    }

    /**
     * Calcula la fortaleza física total incluyendo armaduras y artefactos.
     *
     * @return Fortaleza física total.
     */
    public double getFortalezaFisica() {
        double fortalezaTotal = this.fortalezaFisica;

        for (Armadura armadura : armaduraEquipada.values()) {
            fortalezaTotal += armadura.recuperaEstadistica("fortalezaFisica");
        }

        for (Artefacto artefacto : artefactoEquipado) {
            fortalezaTotal += artefacto.recuperaEstadistica("fortalezaFisica");
        }
        return fortalezaTotal;
    }

    /**
     * Calcula la resistencia mágica total incluyendo armaduras y artefactos.
     *
     * @return Resistencia mágica total.
     */
    public double getResistenciaMagica() {
        double resistenciaTotal = this.resistenciaMagica;

        for (Armadura armadura : armaduraEquipada.values()) {
            resistenciaTotal += armadura.recuperaEstadistica("resistenciaMagica");
        }

        for (Artefacto artefacto : artefactoEquipado) {
            resistenciaTotal += artefacto.recuperaEstadistica("resistenciaMagica");
        }
        return resistenciaTotal;
    }

    /**
     * Calcula la vitalidad total del personaje incluyendo armaduras y artefactos.
     *
     * @return Vitalidad total.
     */
    public double getVitalidad() {
        double vitalidadTotal = this.vitalidad;

        for (Armadura armadura : armaduraEquipada.values()) {
            vitalidadTotal += armadura.recuperaEstadistica("vitalidad");
        }

        for (Artefacto artefacto : artefactoEquipado) {
            vitalidadTotal += artefacto.recuperaEstadistica("vitalidad");
        }

        return vitalidadTotal;
    }

    /**
     * Devuelve la fuerza total del personaje como daño de ataque.
     *
     * @return Daño causado.
     */
    public double luchar() {

        return this.getFuerza();
    }

    /**
     * Reduce la vitalidad del personaje según el tipo de ataque recibido.
     *
     * @param ataque Cantidad de daño recibido.
     * @param tipo   Tipo de ataque (fisico, magico, fe).
     */
    public void defender(double ataque, String tipo) {
        double defensa = 0;

        if (tipo.equals("fisico")) {
            defensa = this.getFortalezaFisica();
        } else if (tipo.equals("magico") || tipo.equals("fe")) {
            defensa = this.getResistenciaMagica();
        }

        double dañofinal = fuerza - vitalidad;
        this.setVitalidad(this.getVitalidad() - dañofinal);
    }


    /**
     * Constructor que inicializa un Personaje a partir de un archivo de texto.
     *
     * @param path Ruta del archivo.
     * @throws IOException Si ocurre un error de lectura del archivo.
     */
    public Personaje(String path) throws IOException {
        File fichero = new File(path + ".txt");
        if (fichero.canRead()) {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String[] campos = new String[1];

            br.readLine();
            br.readLine();
            linea = br.readLine();
            campos = linea.split(": ");
            String nombreFicha = campos[1];
            this.nombre = nombreFicha;

            br.readLine();
            linea = br.readLine();
            campos = linea.split(": ");
            String razaFicha = campos[1];
            this.raza = razaFicha;


            br.readLine();
            linea = br.readLine();
            campos = linea.split(": ");
            int nivelFicha = Integer.parseInt(campos[1]);
            this.nivel = nivelFicha;


            linea = br.readLine();
            campos = linea.split(": ");
            double vitalidadFicha = Double.parseDouble(campos[1]);
            this.vitalidad = vitalidadFicha;


            linea = br.readLine();
            campos = linea.split(": ");
            double fuerzaFicha = Double.parseDouble(campos[1]);
            this.fuerza = fuerzaFicha;


            linea = br.readLine();
            campos = linea.split(": ");
            double agilidadFicha = Double.parseDouble(campos[1]);
            this.agilidad = agilidadFicha;


            linea = br.readLine();
            campos = linea.split(": ");
            double fortalezaFisicaFicha = Double.parseDouble(campos[1]);
            this.fortalezaFisica = fortalezaFisicaFicha;


            linea = br.readLine();
            campos = linea.split(": ");
            double resistenciaMagicaFicha = Double.parseDouble(campos[1]);
            this.resistenciaMagica = resistenciaMagicaFicha;


            linea = br.readLine();
            campos = linea.split(": ");
            boolean estadoFicha = Boolean.parseBoolean(campos[1]);
            this.estado = estadoFicha;


            br.close();
            fr.close();
        }
    }

    /**
     * Verifica y actualiza los atributos del personaje según los datos de la ficha.
     *
     * @param nombreFicha            Nombre del personaje en la ficha.
     * @param razaFicha              Raza del personaje en la ficha.
     * @param estadoFicha            Estado del personaje en la ficha (activo/inactivo).
     * @param nivelFicha             Nivel del personaje en la ficha.
     * @param vitalidadFicha         Vitalidad del personaje en la ficha.
     * @param fuerzaFicha            Fuerza del personaje en la ficha.
     * @param agilidadFicha          Agilidad del personaje en la ficha.
     * @param fortalezaFisicaFicha   Fortaleza física del personaje en la ficha.
     * @param resistenciaMagicaFicha Resistencia mágica del personaje en la ficha.
     * @throws IOException Si ocurre un error de lectura.
     */

    public void verificarFicha(String nombreFicha, String razaFicha, boolean estadoFicha, int nivelFicha, double vitalidadFicha, double fuerzaFicha,
                               double agilidadFicha, double fortalezaFisicaFicha, double resistenciaMagicaFicha) throws IOException {

        if (this.nombre.equals(nombreFicha) && this.raza.equals(razaFicha) && this.estado == estadoFicha && this.nivel == nivelFicha &&
                this.vitalidad == vitalidadFicha && this.fuerza == fuerzaFicha && this.agilidad == agilidadFicha &&
                this.fortalezaFisica == fortalezaFisicaFicha && this.resistenciaMagica == resistenciaMagicaFicha) {
            System.out.println("El personaje está actualizado.");
        } else {
            if (this.nombre.equals(nombreFicha) == false) {
                this.nombre = nombreFicha;
            }
            if (this.raza.equals(razaFicha) == false) {
                this.raza = razaFicha;
            }
            if ((this.estado == estadoFicha) == false) {
                this.estado = estadoFicha;
            }
            if ((this.nivel == nivelFicha) == false) {
                this.nivel = nivelFicha;
            }
            if ((this.vitalidad == vitalidadFicha) == false) {
                this.vitalidad = vitalidadFicha;
            }
            if ((this.fuerza == fuerzaFicha) == false) {
                this.fuerza = fuerzaFicha;
            }
            if ((this.agilidad == agilidadFicha) == false) {
                this.agilidad = agilidadFicha;
            }
            if ((this.fortalezaFisica == fortalezaFisicaFicha) == false) {
                this.fortalezaFisica = fortalezaFisicaFicha;
            }
            if ((this.resistenciaMagica == resistenciaMagicaFicha) == false) {
                this.resistenciaMagica = resistenciaMagicaFicha;
            }

            System.out.println("El personaje ha sido actualizado con los datos de la ficha.");
        }
    }

    /**
     * Constructor de copia.
     *
     * @param copia, copia un objeto personaje.
     */
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
        armaEquipada = copia.armaEquipada;
        armaduraEquipada = new HashMap<>(copia.armaduraEquipada);
        artefactoEquipado = new ArrayList<>(copia.artefactoEquipado);

    }

    /**
     * Constructor con nombre y raza.
     *
     * @param nombre Nombre del personaje.
     * @param raza   Raza del personaje.
     */
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

    /**
     * Obtiene el nombre del personaje.
     *
     * @return Nombre del personaje.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la raza del personaje.
     *
     * @return Raza del personaje.
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Verifica si el personaje está vivo.
     *
     * @return true si está vivo, false si esta muerto.
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * Establece el estado del personaje.
     *
     * @param estado Estado del personaje (vivo o muerto).
     */
    public void setEstado(boolean estado) {

        if (this.vitalidad == 0) {
            this.estado = false;
        }
        this.estado = estado;
    }

    /**
     * Obtiene el nivel del personaje.
     *
     * @return Nivel del personaje.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel del personaje.
     *
     * @param nivel Nuevo nivel del personaje.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


    /**
     * Establece la vitalidad del personaje.
     *
     * @param vitalidad vitalidad del personaje.
     */
    public void setVitalidad(double vitalidad) {
        this.vitalidad = vitalidad;
    }


    /**
     * Establece la fuerza del personaje.
     *
     * @param fuerza fuerza del personaje.
     */
    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }


    /**
     * Establece la agilidad del personaje.
     *
     * @param agilidad agilidad del personaje.
     */
    public void setAgilidad(double agilidad) {
        this.agilidad = agilidad;
    }


    /**
     * Establece la fortaleza física del personaje.
     *
     * @param fortalezaFisica fortaleza física del personaje.
     */
    public void setFortalezaFisica(double fortalezaFisica) {
        this.fortalezaFisica = fortalezaFisica;
    }


    /**
     * Establece la resistencia mágica del personaje.
     *
     * @param resistenciaMagica resistencia mágica del personaje.
     */
    public void setResistenciaMagica(double resistenciaMagica) {
        this.resistenciaMagica = resistenciaMagica;
    }

    /**
     * Establece el nombre del personaje.
     *
     * @param nombre Nombre del personaje.
     */
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

    /**
     * Establece la raza del personaje.
     *
     * @param raza Raza del personaje.
     */
    public void setRaza(String raza) {
        if (raza.contains("angel") || raza.contains("demonio")) {
            System.out.println("La raza no puede ser ni angel ni demonio");
            this.raza = "";
        } else {
            this.raza = raza;
        }
    }

    /**
     * Sube de nivel al personaje.
     */
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


    public String nombreClase() {
        return this.getClass().getSimpleName();
    }

    /**
     * Devuelve la representación en texto del personaje con sus atributos.
     *
     * @return Cadena con la información del personaje.
     */

    public String toString() {
        String resultado = "Ficha del personaje " + "\n" +
                "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Clase: " + nombreClase() + "\n" +
                "Raza: " + getRaza() + "\n" + "\n" +
                "Nivel: " + getNivel() + "\n" +
                "Vida: " + getVitalidad() + "\n" +
                "Ataque: " + getFuerza() + "\n" +
                "Velocidad: " + getAgilidad() + "\n" +
                "Armadura: " + getFortalezaFisica() + "\n" +
                "Resistencia mágica: " + getResistenciaMagica() + "\n" +
                "Tiene un arma que es: " + armaEquipada.toString() + "\n" +
                "Tiene un armadura que es: " + armaduraEquipada.toString() + "\n" +
                "Tiene un artefacto que es: " + artefactoEquipado.toString() + "\n";


        if (estado = true) {
            resultado += "Esta actualmente: vivo";
        } else {
            resultado += "Esta actualmente: muerto";
        }
        return resultado;
    }
}
