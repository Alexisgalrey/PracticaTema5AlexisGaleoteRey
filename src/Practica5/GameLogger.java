package Practica5;

import java.io.*;

/**
 * Clase GameLogger para gestionar la creación y búsqueda de fichas de personajes en un juego de RPG.
 * Proporciona métodos para escribir fichas individuales y grupales, así como para buscar personajes en archivos.
 */
public class GameLogger {
    /**
     * Ruta de lectura y escritura de archivos.
     */
    private static String rutaLectura = "C:/Users/Propietario/Pictures/1 DAM CURSO FP/Programacion/Ficheros/";
    private static String rutaEscritura = "C:/Users/Propietario/Pictures/1 DAM CURSO FP/Programacion/Ficheros/";

    /**
     * Crea un archivo de ficha para un personaje.
     *
     * @param personaje Objeto de tipo Personaje.
     * @param nombre    Nombre del archivo de salida.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    // EJERCICIO 1:
    public static void ficha(Personaje personaje, String nombre) throws IOException {
        File fichero = new File(rutaEscritura + nombre + ".txt");
        FileWriter fw = new FileWriter(fichero);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(personaje.toString());
        bw.close();
        fw.close();
    }

    /**
     * Crea un archivo de ficha para un grupo de personajes ordenados por agilidad y nombre.
     *
     * @param personajeArray Array de personajes.
     * @param nombre         Nombre del archivo de salida.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    // EJERCICIO 2:
    public static void fichaParty(Personaje[] personajeArray, String nombre) throws IOException {
        File fichero = new File(rutaEscritura + nombre + ".txt");
        FileWriter fw = new FileWriter(fichero);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < personajeArray.length; i++) {
            bw.write(personajeArray[i].toString());
            bw.newLine();
            bw.newLine();
        }
        bw.close();
        fw.close();

    }

    /**
     * Busca un personaje por su nombre en una lista de archivos.
     *
     * @param pathsFicheros   Rutas de los archivos a buscar.
     * @param nombrePersonaje Nombre del personaje a buscar.
     * @return true si el personaje es encontrado, false en caso contrario.
     * @throws IOException Si ocurre un error al leer los archivos.
     */
    // EJERCICIO 5:
    public static boolean buscarPersonaje(String[] pathsFicheros, String nombrePersonaje) throws IOException {
        int i = 0;
        while (i < pathsFicheros.length) {
            File fichero = new File(pathsFicheros[i]);
            if (fichero.exists()) {
                FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                br.readLine();
                String linea = br.readLine();
                String[] campos = linea.split(": ");
                String nombreEncontrado = campos[1];
                if (nombrePersonaje.length() == nombreEncontrado.length()) {
                    if (nombrePersonaje.equals(nombreEncontrado)) {
                        br.close();
                        fr.close();
                        return true;
                    }
                }
            }
            i++;
        }
        return false;
    }

    /**
     * Verifica si hay personajes con la misma clase en los archivos especificados.
     *
     * @param pathsFicheros Rutas de los archivos a buscar.
     * @return true si hay clases repetidas, false en caso contrario.
     * @throws IOException Si ocurre un error al leer los archivos.
     */
    //EJERCICIO 6:
    public static boolean buscarClaseRepetida(String[] pathsFicheros) throws IOException {
        String primeraClase = "";
        boolean primeraVez = true;
        int i = 0;

        while (i < pathsFicheros.length) {
            File fichero = new File(pathsFicheros[i]);
            if (fichero.exists()) {
                FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                br.readLine();
                br.readLine();
                String linea;
                linea = br.readLine();
                String[] campos = linea.split(": ");
                String claseActual = campos[1];
                if (primeraVez) {
                    primeraClase = claseActual;
                    primeraVez = false;
                } else if (primeraClase.equals(claseActual)) {
                    br.close();
                    fr.close();
                    return true;
                }
            }
            i++;
        }

        return false;
    }

    /**
     * Main para hacer pruebas y crear los archivos
     *
     * @throws IOException Si ocurre un error en la ejecución.
     */
    public static void main(String[] args) throws IOException {
        //Ejercicio 1
        Ladron pepePersonaje = new Ladron("PepeMontana", "Orco", true);
        Ladron thief = new Ladron("Yitan", "Picaro", false);
        Guerrero darius = new Guerrero("Darius", "Humano", true);
        Ladron lupin = new Ladron("Lupin", "sucubo", true);
        ficha(darius, "Darius");
        ficha(pepePersonaje, "Pepe");
        ficha(thief, "Yitan");
        ficha(lupin, "Lupin");


        //Ejercicio 2
        Personaje[] party = new Personaje[3];
        Guerrero olaf = new Guerrero("Olaf", "Humano", true);
        Mago juan = new Mago("Juan", "Elfo", 10);
        Mago luis = new Mago("Luis", "Elfo", 10);
        party[0] = olaf;
        party[1] = juan;
        party[2] = luis;
        System.out.println(party[0].toString());
        fichaParty(party, "party");


        //Ejercicio 5
        String[] paths = {"C:/Users/Propietario/Pictures/1 DAM CURSO FP/Programacion/Ficheros/Pepe.txt", "C:/Users/Propietario/Pictures/1 DAM CURSO FP/Programacion/Ficheros/Lupin.txt"};
        String nombreBuscado = "PepeMontana";
        boolean encontrado = buscarPersonaje(paths, nombreBuscado);
        if (encontrado) {
            System.out.println("El personaje " + nombreBuscado + " ha sido encontrado.");
        } else {
            System.out.println("El personaje " + nombreBuscado + " no está en los registros.");
        }

        nombreBuscado = "Wargarurumon";
        encontrado = buscarPersonaje(paths, nombreBuscado);
        if (encontrado) {
            System.out.println("El personaje " + nombreBuscado + " ha sido encontrado.");
        } else {
            System.out.println("El personaje " + nombreBuscado + " no está en los registros.");
        }

        //Ejercicio 6
        boolean claseEncontrada = buscarClaseRepetida(paths);
        if (claseEncontrada) {
            System.out.println("La clase esta repetida.");
        } else {
            System.out.println("La clase no está repetida.");

        }
    }
}

