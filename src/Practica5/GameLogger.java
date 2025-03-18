package Practica5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GameLogger {
    public static void ficha(Personaje personaje, String path, String nombre) throws IOException {

        FileWriter fw = new FileWriter(path + "/" + nombre + ".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(personaje.toString());
        bw.close();
        fw.close();
    }

public static void fichaParty (Personaje[] personajeArray, String path, String nombre) throws IOException {
    FileWriter fw = new FileWriter(path + "/" + nombre + ".txt");
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(personajeArray.toString());
    bw.close();
    fw.close();
}

    public static void main(String[] args) throws IOException {
        Guerrero pepe = new Guerrero("pepe", "Orco", true);
        GameLogger.ficha(pepe,
                "/home/tarde/Escritorio/Asignaturas DAM/Asignaturas/Programacion/Tema 6/Practica", "Ficha Guerrero" );
    }
}


