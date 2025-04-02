package Practica5;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que representa un Guerrero, que hereda de Personaje.
 * Posee la habilidad especial de furia.
 */
public class Guerrero extends Personaje {

    private boolean furia;

    /**
     * Constructor por defecto que inicializa un Guerrero con furia desactivada.
     */
    public Guerrero() {
        super();
        this.furia = false;
    }

    /**
     * Constructor que inicializa un Guerrero con todos sus atributos.
     *
     * @param nombre Nombre del Guerrero.
     * @param raza   Raza del Guerrero.
     * @param furia  Estado de furia del Guerrero.
     */
    public Guerrero(String nombre, String raza, boolean furia) {
        super(nombre, raza);
        this.furia = furia;
    }

    /**
     * Constructor de la clase Guerrero que inicializa el objeto con los datos de un archivo.
     * <p>
     * Este constructor invoca al constructor de la clase padre para inicializar el objeto. Luego, lee el archivo especificado
     * por la ruta proporcionada, buscando el valor de "furia" y asignándolo al atributo correspondiente.
     *
     * @param path  Ruta del archivo desde el que se leerán los datos del guerrero.
     * @param furia Valor booleano que indica si el guerrero está en furia.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
// EJERCICIO 3:
    public Guerrero(String path, boolean furia) throws IOException {
        super(path);
        File fichero = new File(path + ".txt");
        if (fichero.canRead()) {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String[] campos = new String[1];
            for (int i = 0; br.readLine().length() > 13; i++) {
                linea = br.readLine();
                campos = linea.split(": ");
                this.furia = Boolean.parseBoolean(campos[1]);
            }
        }
    }

    /**
     * Verifica y actualiza los valores de la ficha de un guerrero.
     * <p>
     * Este metodo invoca al metodo `verificarFicha` de la clase padre para verificar y actualizar los atributos básicos del personaje.
     * Luego, verifica si el valor de "furia" ha cambiado y, en caso afirmativo, lo actualiza y muestra un mensaje en consola.
     *
     * @param nombreFicha            Nombre del personaje a verificar.
     * @param razaFicha              Raza del personaje a verificar.
     * @param estadoFicha            Estado del personaje (activo/inactivo).
     * @param nivelFicha             Nivel del personaje a verificar.
     * @param vitalidadFicha         Vitalidad del personaje a verificar.
     * @param fuerzaFicha            Fuerza del personaje a verificar.
     * @param agilidadFicha          Agilidad del personaje a verificar.
     * @param fortalezaFisicaFicha   Fortaleza física del personaje a verificar.
     * @param resistenciaMagicaFicha Resistencia mágica del personaje a verificar.
     * @param furiaFicha             Valor booleano que indica si el guerrero está en furia.
     * @throws IOException Si ocurre un error durante la actualización de la ficha.
     */
    // EJERCICIO 4:
    public void verificarFicha(String nombreFicha, String razaFicha, boolean estadoFicha, int nivelFicha, double vitalidadFicha, double fuerzaFicha,
                               double agilidadFicha, double fortalezaFisicaFicha, double resistenciaMagicaFicha, boolean furiaFicha) throws IOException {


        super.verificarFicha(nombreFicha, razaFicha, estadoFicha, nivelFicha, vitalidadFicha, fuerzaFicha,
                agilidadFicha, fortalezaFisicaFicha, resistenciaMagicaFicha);


        if (this.furia != furiaFicha) {
            this.furia = furiaFicha;
            System.out.println("El atributo furia ha sido actualizado.");
        }
    }

    /**
     * Obtiene el estado de furia del Guerrero.
     *
     * @return true si el Guerrero está en furia, false si no.
     */
    public boolean getFuria() {
        return furia;
    }

    /**
     * Metodo para subir el nivel del Guerrero.
     */
    public void subirNivel() {
        setNivel(getNivel());

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 25) {
            setVitalidad(getVitalidad() + 10 / 100);
        }
        if (probabilidad >= 20) {
            setFuerza(getFuerza() + getNivel() * 2);

        }
        if (probabilidad >= 50) {
            setAgilidad(getAgilidad() + getNivel());
        }
        if (probabilidad >= 25) {
            setFortalezaFisica(getFortalezaFisica() + getNivel());
        }
        if (probabilidad >= 80) {
            setResistenciaMagica(getResistenciaMagica() + getNivel());
        }
    }

    /**
     * Metodo que simula la acción de luchar, teniendo en cuenta la furia del Guerrero.
     *
     * @return El valor de la fuerza del Guerrero en combate.
     */
    public double luchar() {
        if (getFuria())
            return this.getFuerza() * 2;
        else return this.getFuerza();
    }

    /**
     * meatodo para defenderse del daño recibido.
     *
     * @param ataque El daño que el Guerrero recibe.
     * @param tipo   El tipo de daño ("fisico" o "magico").
     */
    public void defender(int ataque, String tipo) {
        if (tipo.equals("físico"))
            if (getFuria())
                this.setVitalidad(this.getVitalidad() - (ataque - 0.5 * this.getFortalezaFisica()));
            else this.setVitalidad(this.getVitalidad() - (ataque - this.getFortalezaFisica()));
        else if (tipo.equals("mágico"))
            this.setVitalidad(this.getVitalidad() - (ataque - this.getResistenciaMagica()));
    }

    /**
     * Representación en texto del Guerrero.
     *
     * @return Cadena con la información del Guerrero y su estado de furia.
     */
    public String toString() {
        String resultado = "";
        if (furia == true) {
            resultado = super.toString()
                    + "\nEl guerrero está: furioso";
        } else {
            resultado = super.toString()
                    + "\nEl guerrero está; sin furia";
        }

        return resultado;
    }

}