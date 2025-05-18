package Practica5;

import java.util.HashMap;

/**
 * Clase que representa una armadura como tipo de equipamiento.
 * Cada armadura tiene un tipo (pieza específica del cuerpo) y un material.
 */
public class Armadura extends Equipamiento {
    private String tipo;
    private String material;


    /**
     * Constructor por defecto.
     */
    public Armadura() {
        super();
        this.tipo = "";
        this.material = "";
    }

    /**
     * Constructor con atributos específicos.
     *
     * @param nombre            Nombre de la armadura.
     * @param rareza            Rareza de la armadura.
     * @param pieza             Parte del cuerpo que cubre.
     * @param tipoMaterial      Material de fabricación.
     * @param fortalezaFisica   Valor de fortaleza física.
     * @param resistenciaMagica Valor de resistencia mágica.
     * @param vitalidad         Valor de vitalidad.
     * @param valor             Valor de la armadura.
     */
    public Armadura(String nombre, String rareza, String pieza, String tipoMaterial,
                    int fortalezaFisica, int resistenciaMagica, int vitalidad, int valor) {
        super(nombre, new HashMap<>(), rareza, valor);
        setTipo(pieza);
        setMaterial(tipoMaterial);
        HashMap<String, Integer> estadisticas = new HashMap<>();
        estadisticas.put("fortalezaFisica", fortalezaFisica);
        estadisticas.put("resistenciaMagica", resistenciaMagica);
        estadisticas.put("vitalidad", vitalidad);
        setEstadisticas(estadisticas);
    }

    /**
     * Constructor con mapa de estadísticas personalizado.
     *
     * @param nombre       Nombre de la armadura.
     * @param estadisticas Estadísticas asociadas.
     * @param rareza       Rareza de la armadura.
     * @param valor        Valor de la armadura.
     * @param tipo         Tipo de pieza.
     * @param material     Material de la armadura.
     */

    public Armadura(String nombre, HashMap<String, Integer> estadisticas, String rareza,
                    int valor, String tipo, String material) {
        super(nombre, estadisticas, rareza, valor);
        setTipo(tipo);
        setMaterial(material);
    }

    /**
     * Constructor de copia.
     *
     * @param copia Otra armadura para copiar.
     */
    public Armadura(Armadura copia) {
        super(copia);
        this.tipo = copia.tipo;
        this.material = copia.material;
    }


    /**
     * Devuelve el tipo de la armadura.
     *
     * @return Tipo de armadura.
     */

    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve el material de la armadura.
     *
     * @return Material de la armadura.
     */
    public String getMaterial() {
        return material;
    }


    /**
     * Comprueba si el tipo de armadura es válido.
     *
     * @param tipo Tipo a comprobar.
     * @return true si es válido, false en caso contrario.
     */
    private boolean comprobarTipo(String tipo) {
        boolean ok = false;
        switch (tipo) {
            case "yelmo", "pechera", "greba", "hombrera", "guantelete", "bota":
                ok = true;
                break;
        }
        return ok;
    }

    /**
     * Establece el tipo de la armadura si es válido.
     *
     * @param tipo Tipo de la armadura.
     */
    public void setTipo(String tipo) {
        if (comprobarTipo(tipo)) {
            this.tipo = tipo;
        } else {
            this.tipo = "";
        }
    }

    /**
     * Comprueba si el material es válido según el tipo de armadura.
     *
     * @param material Material a comprobar.
     * @return true si es válido, false en caso contrario.
     */
    private boolean comprobarMaterial(String material) {
        if (material.equals("tela") && tipo.equals("cuero") || tipo.equals("metal")) {
            return true;
        }
        return false;
    }

    /**
     * Establece el material de la armadura si es válido.
     *
     * @param material Material de la armadura.
     */
    public void setMaterial(String material) {
        if (comprobarMaterial(getMaterial()) == true) {
            this.material = material;
        } else {
            this.material = "";
        }
    }

    /**
     * Establece las estadísticas válidas de la armadura
     * (solo fortaleza física, resistencia mágica y vitalidad).
     *
     * @param estadisticas Mapa de estadísticas.
     */

    @Override
    public void setEstadisticas(HashMap<String, Integer> estadisticas) {
        HashMap<String, Integer> estadisticasValidas = new HashMap<>();

        for (String clave : estadisticas.keySet()) {

            if (clave.equals("resistenciaFisica") || clave.equals("resistenciaMagica") || clave.equals("vitalidad")) {
                estadisticasValidas.put(clave, estadisticas.get(clave));
            }
        }
        super.setEstadisticas(estadisticasValidas);
    }

    /**
     * Compara dos armaduras para comprobar si son iguales.
     *
     * @param otro Otra armadura a comparar.
     * @return true si son iguales, false si hay diferencias.
     */
    public boolean equals(Armadura otro) {
        if (!super.equals(otro)) return false;
        if (this.tipo.equals(otro.tipo)) return false;
        if (this.material.equals(otro.material)) return false;
        return true;
    }

    /**
     * Devuelve la representación textual de la armadura.
     *
     * @return Cadena con información detallada.
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n Es de tipo: " + tipo +
                "\n Es de Material: " + material;
    }
}