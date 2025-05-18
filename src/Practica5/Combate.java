package Practica5;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Representa un combate entre dos personajes, manejando los turnos, ataques y registros de combate.
 */
public final class Combate {
    private static Personaje personaje1;
    private static Personaje personaje2;
    private static String resultado;
    private static ArrayList<Arma> armas = new ArrayList<>();
    private static ArrayList<Armadura> armaduras = new ArrayList<>();
    private static ArrayList<Artefacto> artefactos = new ArrayList<>();

    /**
     * Constructor de la clase Combate.
     * Carga automáticamente armas, armaduras y artefactos desde archivos CSV.
     * @throws IOException Si ocurre un error al leer los ficheros.
     */
    public Combate() throws IOException {
        cargarArmas();
        cargarArmaduras();
        cargarArtefactos();
    }

    // EJERCICIO 4   TEMA 7                 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    /**
     * Carga la lista de armas desde un archivo CSV.
     * El archivo debe contener nombre, rareza, tipo, estadísticas y valor.
     * @throws IOException Si hay un problema al acceder al archivo.
     */
    private void cargarArmas() throws IOException {
        File fichero = new File("/home/tarde/Escritorio/Asignaturas DAM/Asignaturas/Programacion/Tema7/FicherosTema7/Tesoros/armas.csv");
        FileReader fr = new FileReader(fichero);
        BufferedReader br = new BufferedReader(fr);
        br.readLine();

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(",");
            String nombre = campos[0];
            String rareza = campos[1];
            String tipo = campos[2];
            String[] estadisticasArma = campos[3].split("-");
            int fuerza = Integer.parseInt(estadisticasArma[0]);
            int agilidad = Integer.parseInt(estadisticasArma[1]);
            int magia = Integer.parseInt(estadisticasArma[2]);
            int fe = Integer.parseInt(estadisticasArma[3]);
            int valor = Integer.parseInt(campos[4]);

            String empuñadura; // pongo esto aqui ya que no consigo llarmalo desde la clase arma
            switch (tipo) {
                case "maza":
                case "hacha":
                case "espada":
                case "cetro":
                case "daga":
                    empuñadura = "una mano";
                    break;
                case "espadon":
                case "martillo":
                case "arco":
                case "baston":
                    empuñadura = "dos manos";
                    break;
                default:
                    empuñadura = "";
            }

            HashMap<String, Integer> estadisticas = new HashMap<>();
            estadisticas.put("fuerza", fuerza);
            estadisticas.put("agilidad", agilidad);
            estadisticas.put("magia", magia);
            estadisticas.put("fe", fe);

            armas.add(new Arma(nombre, estadisticas, rareza, valor, empuñadura, tipo));
        }
        br.close();
        fr.close();
    }
    /**
     * Carga la lista de armaduras desde un archivo CSV.
     * Cada línea representa una armadura con sus estadísticas.
     * @throws IOException Si ocurre un error de lectura.
     */
    private void cargarArmaduras() throws IOException {
        File fichero = new File("/home/tarde/Escritorio/Asignaturas DAM/Asignaturas/Programacion/Tema7/FicherosTema7/Tesoros/armadura.csv");
        FileReader fr = new FileReader(fichero);
        BufferedReader br = new BufferedReader(fr);
        br.readLine();

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(",");
            String nombre = campos[0];
            String rareza = campos[1];
            String pieza = campos[2];
            String tipoMaterial = campos[3];
            String[] estadisticasArmadura = campos[4].split("-");
            int fortalezaFisica = Integer.parseInt(estadisticasArmadura[0]);
            int resistenciaMagica = Integer.parseInt(estadisticasArmadura[1]);
            int vitalidad = Integer.parseInt(estadisticasArmadura[2]);
            int valor = Integer.parseInt(campos[5]);

            HashMap<String, Integer> estadisticas = new HashMap<>();
            estadisticas.put("resistenciaFisica", fortalezaFisica);
            estadisticas.put("resistenciaMagica", resistenciaMagica);
            estadisticas.put("vitalidad", vitalidad);

            armaduras.add(new Armadura(nombre, rareza, pieza, tipoMaterial, fortalezaFisica, resistenciaMagica, vitalidad, valor));
        }
        br.close();
        fr.close();
    }
    /**
     * Carga la lista de artefactos desde un archivo CSV.
     * Incluye estadísticas físicas y mágicas.
     * @throws IOException Si ocurre un problema al abrir o leer el archivo.
     */
    private void cargarArtefactos() throws IOException {
        File fichero = new File("/home/tarde/Escritorio/Asignaturas DAM/Asignaturas/Programacion/Tema7/FicherosTema7/Tesoros/artefactos.csv");
        FileReader fr = new FileReader(fichero);
        BufferedReader br = new BufferedReader(fr);
        br.readLine();

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(",");
            String nombre = campos[0];
            String rareza = campos[1];
            String tipo = campos[2];
            String[] estadisticasArtefacto = campos[3].split("-");
            int fuerza = Integer.parseInt(estadisticasArtefacto[0]);
            int agilidad = Integer.parseInt(estadisticasArtefacto[1]);
            int magia = Integer.parseInt(estadisticasArtefacto[2]);
            int fe = Integer.parseInt(estadisticasArtefacto[3]);
            int fortalezaFisica = Integer.parseInt(estadisticasArtefacto[4]);
            int resistenciaMagica = Integer.parseInt(estadisticasArtefacto[5]);
            int vitalidad = Integer.parseInt(estadisticasArtefacto[6]);
            int valor = Integer.parseInt(campos[4]);

            HashMap<String, Integer> estadisticas = new HashMap<>();
            estadisticas.put("fuerza", fuerza);
            estadisticas.put("agilidad", agilidad);
            estadisticas.put("magia", magia);
            estadisticas.put("fe", fe);
            estadisticas.put("fortalezaFisica", fortalezaFisica);
            estadisticas.put("fortalezaMagica", resistenciaMagica);
            estadisticas.put("vitalidad", vitalidad);

            artefactos.add(new Artefacto(nombre, rareza, tipo, estadisticas, valor));
        }
        br.close();
        fr.close();
    }

//Ejercicio 6 TEMA7                                             !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    /**
     * Ordena una lista de personajes de forma descendente según su nivel.
     * @param grupo Lista de personajes a ordenar.
     */
    private void ordenarPorNivel(ArrayList<Personaje> grupo) {
        Collections.sort(grupo, new Comparator<Personaje>() {
            public int compare(Personaje p1, Personaje p2) {
                return Integer.compare(p2.getNivel(), p1.getNivel());
            }
        }
        );
    }
    /**
     * Simula combates entre dos grupos de personajes. El combate continúa hasta que un grupo es eliminado.
     * El grupo ganador recibe un botín aleatorio de armas, armaduras y artefactos.
     *
     * @param grupo1 Primer grupo de personajes.
     * @param grupo2 Segundo grupo de personajes (enemigos).
     * @return Lista de objetos de tipo Equipamiento obtenidos como recompensa.
     * @throws IOException Si falla la carga de objetos desde ficheros.
     */
    public ArrayList<Equipamiento> combatirGrupos(ArrayList<Personaje> grupo1, ArrayList<Personaje> grupo2) throws IOException {

        ordenarPorNivel(grupo1);
        ordenarPorNivel(grupo2);

        int cantidadOriginalGrupo1 = grupo1.size();
        int cantidadOriginalGrupo2 = grupo2.size();

        cargarArmas();
        cargarArmaduras();
        cargarArtefactos();


        while (!grupo1.isEmpty() && !grupo2.isEmpty()) {
            Personaje p1 = grupo1.get(0);
            Personaje p2 = grupo2.get(0);

            Combate.personaje1 = p1;
            Combate.personaje2 = p2;

            this.combatir();

            if (!p1.getEstado()) grupo1.remove(0);
            if (!p2.getEstado()) grupo2.remove(0);
        }

        ArrayList<Equipamiento> recompensa = new ArrayList<>();

        int cantidadTesoros;
        if (grupo1.isEmpty()) {
            cantidadTesoros = cantidadOriginalGrupo1;
        } else {
            cantidadTesoros = cantidadOriginalGrupo2;
        }
        for (int i = 0; i < cantidadTesoros; i++) {
            int tipo = (int) (Math.random() * 3);

            if (tipo == 0 && !armas.isEmpty()) {
                recompensa.add(armas.remove((int)(Math.random() * armas.size())));
            } else if (tipo == 1 && !armaduras.isEmpty()) {
                recompensa.add(armaduras.remove((int)(Math.random() * armaduras.size())));
            } else if (!artefactos.isEmpty()) {
                recompensa.add(artefactos.remove((int)(Math.random() * artefactos.size())));
            }
        }

        return recompensa;
    }

    /**
     * Simula un combate entre los dos personajes, alternando turnos y calculando el daño.
     * El combate continúa hasta que uno de los personajes pierde toda su vitalidad.
     * Durante el combate, se registra la cantidad de daño infligido y los eventos en consola.
     */
    public Equipamiento combatir() {

        Equipamiento premio = null; //recordar crear un objeto de equipamiento para poder devolverlo despues!!!!

        boolean turno = false, inicio = false;
//Ejercicio 5 TEMA 7                                                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        while (personaje1.getEstado() && personaje2.getEstado()) {
            if (!inicio) {
                inicio = true;
                if (personaje1.getAgilidad() >= personaje2.getAgilidad()) {
                    turno = true;
                    if (personaje1.getAgilidad() == 2 * personaje2.getAgilidad()) {
                        double daño1 = personaje1.luchar() - personaje2.getFortalezaFisica();
                        personaje2.defender(personaje1.luchar(), "físico");
                        double daño2 = personaje1.luchar() - personaje2.getFortalezaFisica();
                        personaje2.defender(personaje1.luchar(), "físico");
                        System.out.println("¡" + personaje1.getNombre() + " ha infligido " + (daño1 + daño2) + " de daño!");
                    } else {
                        double daño = personaje1.luchar() - personaje2.getFortalezaFisica();
                        personaje2.defender(personaje1.luchar(), "físico");
                        System.out.println(personaje1.getNombre() + " ha infligido " + daño + " de daño");
                    }
                } else if (personaje2.getAgilidad() >= personaje1.getAgilidad()) {
                    turno = false;
                    if (personaje2.getAgilidad() == 2 * personaje1.getAgilidad()) {
                        double daño1 = personaje2.luchar() - personaje1.getFortalezaFisica();
                        personaje1.defender(personaje2.luchar(), "físico");
                        double daño2 = personaje2.luchar() - personaje1.getFortalezaFisica();
                        personaje1.defender(personaje2.luchar(), "físico");
                        System.out.println("¡" + personaje2.getNombre() + " ha infligido " + (daño1 + daño2) + " de daño!");
                    } else {
                        double daño = personaje2.luchar() - personaje1.getFortalezaFisica();
                        personaje1.defender(personaje2.luchar(), "físico");
                        System.out.println(personaje2.getNombre() + " ha infligido " + daño + " de daño");
                    }
                } else {
                    if (turno) {
                        turno = true;
                        double daño = personaje1.luchar() - personaje2.getFortalezaFisica();
                        personaje2.defender(personaje1.luchar(), "físico");
                        System.out.println(personaje1.getNombre() + " ha infligido " + daño + " de daño");
                    } else {
                        turno = false;
                        double daño = personaje2.luchar() - personaje1.getFortalezaFisica();
                        personaje1.defender(personaje2.luchar(), "físico");
                        System.out.println(personaje2.getNombre() + " ha infligido " + daño + " de daño");
                    }
                }
            } else if (turno) {
                turno = false;
                double daño = personaje1.luchar() - personaje2.getFortalezaFisica();
                personaje2.defender(personaje1.luchar(), "físico");
                System.out.println(personaje1.getNombre() + " ha infligido " + daño + " de daño");
            } else {
                turno = true;
                double daño = personaje2.luchar() - personaje1.getFortalezaFisica();
                personaje1.defender(personaje2.luchar(), "físico");
                System.out.println(personaje2.getNombre() + " ha infligido " + daño + " de daño");
            }

            if (personaje1.getVitalidad() <= 0) {
                personaje1.setEstado(false);
                System.out.println("¡" + personaje1.getNombre() + " ha sido derrotado!");
                resultado = "Derrota";
            } else if (personaje2.getVitalidad() <= 0) {
                personaje2.setEstado(false);
                System.out.println("¡" + personaje2.getNombre() + " ha sido derrotado!");
                resultado = "Victoria";
            }

            // EJERCICIO 4 TEMA 7                                                  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            if (resultado.equals("Victoria")) {
                int premioS = (int) (Math.random() * 3) + 1;


                switch (premioS) {
                    case 1:
                        int indiceArma = (int) (Math.random() * armas.size());
                        premio = armas.remove(indiceArma);
                        break;

                    case 2:
                        int indiceArmadura = (int) (Math.random() * armaduras.size());
                        premio = armaduras.remove(indiceArmadura);
                        break;

                    case 3:
                        int indiceArtefactos = (int) (Math.random() * artefactos.size());
                        premio = artefactos.remove(indiceArtefactos);
                        break;
                }
            }
        }
        return premio;
    }

    /**
     * Registra el combate entre dos personajes en un archivo especificado.
     * El archivo almacenará los detalles del combate, como el daño infligido y los personajes derrotados.
     *
     * @param path Ruta del archivo donde se almacenará el registro del combate.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */

    public static void registroCombate(String path) throws IOException {
        File fichero = new File(path);
        FileWriter fw = new FileWriter(fichero, true); //Pongo append true para que añada mas contenido y no lo sobreescriba
        BufferedWriter bw = new BufferedWriter(fw);

        boolean turno = false, inicio = false;

        while (personaje1.getEstado() && personaje2.getEstado()) {
            if (!inicio) {
                inicio = true;
                if (personaje1.getAgilidad() >= personaje2.getAgilidad()) {
                    turno = true;
                    if (personaje1.getAgilidad() == 2 * personaje2.getAgilidad()) {
                        double daño1 = personaje1.luchar() - personaje2.getFortalezaFisica();
                        personaje2.defender(personaje1.luchar(), "físico");
                        double daño2 = personaje1.luchar() - personaje2.getFortalezaFisica();
                        personaje2.defender(personaje1.luchar(), "físico");
                        System.out.println("¡" + personaje1.getNombre() + " ha infligido " + (daño1 + daño2) + " de daño!");
                    } else {
                        double daño = personaje1.luchar() - personaje2.getFortalezaFisica();
                        personaje2.defender(personaje1.luchar(), "físico");
                        System.out.println(personaje1.getNombre() + " ha infligido " + daño + " de daño");
                    }
                } else if (personaje2.getAgilidad() >= personaje1.getAgilidad()) {
                    turno = false;
                    if (personaje2.getAgilidad() == 2 * personaje1.getAgilidad()) {
                        double daño1 = personaje2.luchar() - personaje1.getFortalezaFisica();
                        personaje1.defender(personaje2.luchar(), "físico");
                        double daño2 = personaje2.luchar() - personaje1.getFortalezaFisica();
                        personaje1.defender(personaje2.luchar(), "físico");
                        System.out.println("¡" + personaje2.getNombre() + " ha infligido " + (daño1 + daño2) + " de daño!");
                    } else {
                        double daño = personaje2.luchar() - personaje1.getFortalezaFisica();
                        personaje1.defender(personaje2.luchar(), "físico");
                        System.out.println(personaje2.getNombre() + " ha infligido " + daño + " de daño");
                    }
                } else {
                    if (turno) {
                        turno = true;
                        double daño = personaje1.luchar() - personaje2.getFortalezaFisica();
                        personaje2.defender(personaje1.luchar(), "físico");
                        System.out.println(personaje1.getNombre() + " ha infligido " + daño + " de daño");
                    } else {
                        turno = false;
                        double daño = personaje2.luchar() - personaje1.getFortalezaFisica();
                        personaje1.defender(personaje2.luchar(), "físico");
                        System.out.println(personaje2.getNombre() + " ha infligido " + daño + " de daño");
                    }
                }
            } else if (turno) {
                turno = false;
                double daño = personaje1.luchar() - personaje2.getFortalezaFisica();
                personaje2.defender(personaje1.luchar(), "físico");
                System.out.println(personaje1.getNombre() + " ha infligido " + daño + " de daño");
            } else {
                turno = true;
                double daño = personaje2.luchar() - personaje1.getFortalezaFisica();
                personaje1.defender(personaje2.luchar(), "físico");
                System.out.println(personaje2.getNombre() + " ha infligido " + daño + " de daño");
            }

            if (personaje1.getVitalidad() <= 0) {
                personaje1.setEstado(false);
                System.out.println("¡" + personaje1.getNombre() + " ha sido derrotado!");
                resultado = "Derrota";
            } else if (personaje2.getVitalidad() <= 0) {
                personaje2.setEstado(false);
                System.out.println("¡" + personaje2.getNombre() + " ha sido derrotado!");
                resultado = "Victoria";

            }
        }
        bw.close();
        fw.close();
    }

    /**
     * Verifica si un personaje ha ganado y, en caso afirmativo, aumenta su nivel.
     * Revisa los registros de combate almacenados en un archivo para determinar si un personaje ha ganado.
     *
     * @param personaje personajes que se verifican para ver si han ganado.
     * @param path      Ruta del archivo que contiene los registros del combate.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    // EJERCICIO 8
    public static void ganadorCombate(Personaje[] personaje, String path) throws IOException {
        for (int i = 0; i < personaje.length; i++) {
            File lectura = new File(path);
            if (lectura.canRead()) {
                FileReader fr = new FileReader(lectura);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.startsWith("Ha ganado" + personaje[i].getNombre())) {
                        personaje[i].subirNivel();
                    }
                }
                br.close();
                fr.close();
            }
        }
    }

    /**
     * Representación en texto del Creyente.
     *
     * @return Cadena con la información del Creyente y su fe.
     */
    public String toString() {
        if (resultado.equals("Victoria"))
            return "Has ganado a" + personaje2.getNombre();
        else
            return "Te ha derrotado " + personaje1.getNombre();
    }

    public static void main(String[] args) throws IOException {
        Combate combate = new Combate();


        personaje1 = new Ladron("jaimito", "goblin", false);
        personaje2 = new Ladron("jaimite", "groublin", false);
    }
}