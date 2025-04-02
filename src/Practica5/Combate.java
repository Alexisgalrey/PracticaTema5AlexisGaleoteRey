package Practica5;

import javax.imageio.IIOException;
import java.io.*;

/**
 * Representa un combate entre dos personajes, manejando los turnos, ataques y registros de combate.
 */
public final class Combate {
    private static Personaje personaje1;
    private static Personaje personaje2;
    private static String resultado;

    /**
     * Simula un combate entre los dos personajes, alternando turnos y calculando el daño.
     * El combate continúa hasta que uno de los personajes pierde toda su vitalidad.
     * Durante el combate, se registra la cantidad de daño infligido y los eventos en consola.
     */
    public void combatir() {

        boolean turno = false, inicio = false;

        while (personaje1.getEstado() && personaje2.getEstado()) {
            if (!inicio) {
                inicio = true;
                if (personaje1.getAgilidad() >= personaje2.getAgilidad()) {
                    turno = true;
                    if (personaje1.getAgilidad() == 2 * personaje2.getAgilidad()) {
                        personaje2.defender(personaje1.luchar(), "físico");
                        personaje2.defender(personaje1.luchar(), "físico");
                        System.out.println("¡" + personaje2.getNombre() + " ha infligido a " +
                                personaje1.getNombre() + " " + 2 * personaje2.luchar() +
                                " de daño!");
                    } else {
                        personaje2.defender(personaje1.luchar(), "físico");
                        System.out.println(personaje2.getNombre() + " ha infligido a " +
                                personaje1.getNombre() + " " + personaje2.luchar() +
                                " de daño");
                    }
                } else if (personaje2.getAgilidad() >= personaje1.getAgilidad()) {
                    turno = false;
                    if (personaje2.getAgilidad() == 2 * personaje1.getAgilidad()) {
                        personaje1.defender(personaje2.luchar(), "físico");
                        personaje1.defender(personaje2.luchar(), "físico");
                        System.out.println("¡" + personaje1.getNombre() + " ha infligido a " +
                                personaje2.getNombre() + " " + 2 * personaje1.luchar() +
                                " de daño!");
                    } else {
                        personaje1.defender(personaje2.luchar(), "físico");
                        System.out.println(personaje1.getNombre() + " ha infligido a " +
                                personaje2.getNombre() + " " + personaje1.luchar() +
                                " de daño");
                    }
                } else {
                    if (Math.random() > 0.5) {
                        turno = true;
                        personaje2.defender(personaje1.luchar(), "físico");
                        System.out.println(personaje2.getNombre() + " ha infligido a " +
                                personaje1.getNombre() + " " + personaje2.luchar() +
                                " de daño");
                    } else if (Math.random() < 0.5) {
                        turno = false;
                        personaje1.defender(personaje2.luchar(), "físico");
                        System.out.println(personaje1.getNombre() + " ha infligido a " +
                                personaje2.getNombre() + " " + personaje1.luchar() +
                                " de daño");
                    }
                }
            } else if (turno) {
                turno = false;
                personaje1.defender(personaje2.luchar(), "físico");
                System.out.println(personaje1.getNombre() + " ha infligido a " +
                        personaje2.getNombre() + " " + personaje1.luchar() +
                        " de daño");
            } else {
                turno = true;
                personaje2.defender(personaje1.luchar(), "físico");
                System.out.println(personaje2.getNombre() + " ha infligido a " +
                        personaje1.getNombre() + " " + personaje2.luchar() +
                        " de daño");
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

    }

    /**
     * Registra el combate entre dos personajes en un archivo especificado.
     * El archivo almacenará los detalles del combate, como el daño infligido y los personajes derrotados.
     *
     * @param path Ruta del archivo donde se almacenará el registro del combate.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    //EJERCICIO 7
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
                        personaje2.defender(personaje1.luchar(), "físico");
                        personaje2.defender(personaje1.luchar(), "físico");
                        bw.write("¡" + personaje2.getNombre() + " ha infligido a " +
                                personaje1.getNombre() + " " + 2 * personaje2.luchar() +
                                " de daño!");
                        bw.newLine();
                    } else {
                        personaje2.defender(personaje1.luchar(), "físico");
                        bw.write(personaje2.getNombre() + " ha infligido a " +
                                personaje1.getNombre() + " " + personaje2.luchar() +
                                " de daño");
                        bw.newLine();
                    }
                } else if (personaje2.getAgilidad() >= personaje1.getAgilidad()) {
                    turno = false;
                    if (personaje2.getAgilidad() == 2 * personaje1.getAgilidad()) {
                        personaje1.defender(personaje2.luchar(), "físico");
                        personaje1.defender(personaje2.luchar(), "físico");
                        bw.write("¡" + personaje1.getNombre() + " ha infligido a " +
                                personaje2.getNombre() + " " + 2 * personaje1.luchar() +
                                " de daño!");
                        bw.newLine();
                    } else {
                        personaje1.defender(personaje2.luchar(), "físico");
                        bw.write(personaje1.getNombre() + " ha infligido a " +
                                personaje2.getNombre() + " " + personaje1.luchar() +
                                " de daño");
                        bw.newLine();
                    }
                } else {
                    if (Math.random() > 0.5) {
                        turno = true;
                        personaje2.defender(personaje1.luchar(), "físico");
                        bw.write(personaje2.getNombre() + " ha infligido a " +
                                personaje1.getNombre() + " " + personaje2.luchar() +
                                " de daño");
                        bw.newLine();
                    } else {
                        turno = false;
                        personaje1.defender(personaje2.luchar(), "físico");
                        bw.write(personaje1.getNombre() + " ha infligido a " +
                                personaje2.getNombre() + " " + personaje1.luchar() +
                                " de daño");
                        bw.newLine();
                    }
                }
            } else if (turno) {
                turno = false;
                personaje1.defender(personaje2.luchar(), "físico");
                bw.write(personaje1.getNombre() + " ha infligido a " +
                        personaje2.getNombre() + " " + personaje1.luchar() +
                        " de daño");
                bw.newLine();
            } else {
                turno = true;
                personaje2.defender(personaje1.luchar(), "físico");
                bw.write(personaje2.getNombre() + " ha infligido a " +
                        personaje1.getNombre() + " " + personaje2.luchar() +
                        " de daño");
                bw.newLine();
            }

            if (personaje1.getVitalidad() <= 0) {
                personaje1.setEstado(false);
                bw.write("¡" + personaje1.getNombre() + " ha sido derrotado!");
                bw.newLine();
                resultado = "Derrota";
            } else if (personaje2.getVitalidad() <= 0) {
                personaje2.setEstado(false);
                bw.write("¡" + personaje2.getNombre() + " ha sido derrotado!");
                bw.newLine();
                resultado = "Victoria";
            }
        }
        bw.flush();
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

        personaje1 = new Guerrero("Pepe", "Orco", true);
        personaje2 = new Mago("Ismael", "Bruja", 100);
        registroCombate("C:/Users/Propietario/Pictures/1 DAM CURSO FP/Programacion/Ficheros/Registro.txt");

        personaje1 = new Guerrero("Pepe", "Ladron", true);
        personaje2 = new Mago("Ismael", "Bruja", 100);
        combate.combatir();
        Personaje[] personajes = new Personaje[2];
        personajes[0] = personaje1;
        personajes [1] =personaje2;
        personaje1 = new Guerrero("Pepe", "Ladron", true);
        personaje2 = new Mago("Ismael", "Bruja", 100);
        ganadorCombate(personajes, "C:/Users/Propietario/Pictures/1 DAM CURSO FP/Programacion/Ficheros/Registro.txt");

    }
}