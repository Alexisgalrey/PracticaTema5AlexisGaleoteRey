package Practica5;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que simula un combate entre un grupo de personajes y monstruos generados aleatoriamente.
 */
public class Simulador {
    private ArrayList<Personaje> grupo;
    private ArrayList<Personaje> monstruosDisponibles;

    /**
     * Constructor de la clase Simulador. Inicializa el grupo y los monstruos disponibles.
     *
     * @param grupo Lista de personajes del jugador.
     */
    public Simulador(ArrayList<Personaje> grupo) {
        this.grupo = new ArrayList<>(grupo);
        this.monstruosDisponibles = new ArrayList<>();
        inicializarMonstruos();
    }

    /**
     * Inicializa la lista de monstruos disponibles para los combates.
     */
    private void inicializarMonstruos() {
        monstruosDisponibles.add(new Monstruo("Goblin", "Bestia", 1));
        monstruosDisponibles.add(new Monstruo("Troll", "Gigante", 1));
        monstruosDisponibles.add(new Monstruo("Esqueleto", "No-muerto", 1));

    }

    /**
     * Ejecuta una simulación de combate entre el grupo del jugador y monstruos aleatorios.
     *
     * @return true si quedan personajes vivos tras el combate, false si el grupo ha sido eliminado..
     */
    public boolean simular() throws IOException {  //uso el throws ioexception porque sino da error el combate


        ArrayList<Personaje> monstruos = generarMonstruos();
        Combate combate = new Combate();

        ArrayList<Equipamiento> botin = combate.combatirGrupos(grupo, monstruos);

        equiparObjetos(botin);
        eliminarMuertos();

        if (grupo.isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     * Genera una lista aleatoria de monstruos a partir de los disponibles.
     *
     * @return Lista de personajes enemigos.
     */
    private ArrayList<Personaje> generarMonstruos() {
        ArrayList<Personaje> monstruos = new ArrayList<>();
        int cantidad = (int) (Math.random() * 3) + 1;

        for (int i = 0; i < cantidad; i++) {
            int indice = (int) (Math.random() * monstruosDisponibles.size());
            Personaje m = monstruosDisponibles.get(indice);
            m.setEstado(true);
            monstruos.add(m);
        }
        return monstruos;
    }

    /**
     * Equipa al grupo con los objetos obtenidos del botín.
     *
     * @param botin Lista de objetos obtenidos tras el combate.
     */
    private void equiparObjetos(ArrayList<Equipamiento> botin) {
        for (Equipamiento equipo : botin) {
            boolean equipado = false;

            for (Personaje p : new ArrayList<>(grupo)) {
                if (p.getEstado() && !equipado) {

                    p.equiparArma((Arma) equipo);
                    p.equiparArmadura((Armadura) equipo);
                    p.equiparArtefacto((Artefacto) equipo);

                    equipado = true;
                }
            }
        }
    }

    /**
     * Elimina del grupo a los personajes que están muertos.
     */
    private void eliminarMuertos() {
        ArrayList<Personaje> vivos = new ArrayList<>();
        for (Personaje p : grupo) {
            if (p.getEstado()) {
                vivos.add(p);
            }
        }
        grupo = vivos;
    }

}