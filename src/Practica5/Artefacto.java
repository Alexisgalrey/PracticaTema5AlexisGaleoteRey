
package Practica5;

import java.util.HashMap;

/**
 * Clase que representa un artefacto, un tipo de equipamiento que puede mejorar distintas estadísticas.
 * Los artefactos pueden ser de tipo "amuleto" o "anillo".
 */
public class Artefacto extends Equipamiento {
    private String tipo;

    public Artefacto() {
        super();
        this.tipo = "";
    }

    /**
     * Constructor que recibe atributos detallados para crear el artefacto.
     *
     * @param nombre            Nombre del artefacto.
     * @param rareza            Rareza del artefacto.
     * @param tipo              Tipo del artefacto (amuleto o anillo).
     * @param fuerza            Valor de fuerza.
     * @param agilidad          Valor de agilidad.
     * @param magia             Valor de magia.
     * @param fe                Valor de fe.
     * @param fortalezaFisica   Valor de fortaleza física.
     * @param resistenciaMagica Valor de resistencia mágica.
     * @param vitalidad         Valor de vitalidad.
     * @param valor             Valor total del artefacto.
     */
    public Artefacto(String nombre, String rareza, String tipo, int fuerza, int agilidad, int magia, int fe,
                     int fortalezaFisica, int resistenciaMagica, int vitalidad, int valor) {
        super(nombre, new HashMap<>(), rareza, valor);
        setTipo(tipo);
        HashMap<String, Integer> estadisticas = new HashMap<>();
        estadisticas.put("fuerza", fuerza);
        estadisticas.put("agilidad", agilidad);
        estadisticas.put("magia", magia);
        estadisticas.put("fe", fe);
        estadisticas.put("fortalezaFisica", fortalezaFisica);
        estadisticas.put("resistenciaMagica", resistenciaMagica);
        estadisticas.put("vitalidad", vitalidad);
        setEstadisticas(estadisticas);
    }

    /**
     * Constructor que recibe estadísticas agrupadas en un mapa.
     *
     * @param nombre       Nombre del artefacto.
     * @param rareza       Rareza del artefacto.
     * @param tipo         Tipo del artefacto.
     * @param estadisticas Mapa con estadísticas del artefacto.
     * @param valor        Valor total del artefacto.
     */
    public Artefacto(String nombre, String rareza, String tipo, HashMap<String, Integer> estadisticas, int valor) {
        super(nombre, estadisticas, rareza, valor);
        setTipo(tipo);
    }

    /**
     * Constructor de copia.
     *
     * @param copia Artefacto a copiar.
     */

    public Artefacto(Artefacto copia) {
        super(copia);
        this.tipo = copia.tipo;
    }

    /**
     * Devuelve el tipo de artefacto.
     *
     * @return Tipo del artefacto.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del artefacto si es válido (solo "amuleto" o "anillo").
     *
     * @param tipo Tipo del artefacto.
     */
    public void setTipo(String tipo) {
        if (tipo.equals("amuleto") || tipo.equals("anillo")) {
            this.tipo = tipo;
        } else {
            this.tipo = "";
        }
    }

    /**
     * Establece las estadísticas válidas del artefacto.
     * Se filtran solo aquellas que correspondan a atributos reconocidos.
     *
     * @param estadisticas Mapa de estadísticas.
     */
    public void setEstadisticas(HashMap<String, Integer> estadisticas) {
        HashMap<String, Integer> estadisticasValidas = new HashMap<>();

        for (String clave : estadisticas.keySet()) {

            if (clave.equals("fuerza") || clave.equals("magia") || clave.equals("fe") || clave.equals("agilidad")
                    || clave.equals("vitalidad") || clave.equals("fortalezaFisica") || clave.equals("fortalezaMagica")) {
                estadisticasValidas.put(clave, estadisticas.get(clave));
            }
        }
        super.setEstadisticas(estadisticasValidas);
    }

    /**
     * Compara si dos artefactos son iguales en base a sus atributos y tipo.
     *
     * @param otro Artefacto a comparar.
     * @return true si son iguales, false si hay diferencias.
     */
    public boolean equals(Artefacto otro) {
        if (!super.equals(otro)) return false;
        if (!this.tipo.equals(otro.tipo)) return false;
        return true;
    }

    /**
     * Devuelve una representación textual del artefacto.
     *
     * @return Cadena con los detalles del artefacto.
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n Es de tipo: " + tipo;
    }
}
