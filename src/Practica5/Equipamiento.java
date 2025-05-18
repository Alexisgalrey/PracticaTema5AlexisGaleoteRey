package Practica5;

import java.util.HashMap;

/**
 * Clase abstracta que representa un objeto de equipamiento.
 * Contiene propiedades comunes como nombre, estadísticas, rareza y valor.
 */
public abstract class Equipamiento {
    private String nombre;
    private HashMap<String, Integer> estadisticas;
    private String rareza;
    private int valor;

    /**
     * Constructor por defecto. Inicializa valores básicos.
     */
    public Equipamiento() {
        this.nombre = "";
        this.estadisticas = new HashMap<>();
        this.rareza = "comun";
        this.valor = 1;
    }

    /**
     * Constructor con parámetros.
     *
     * @param nombre       Nombre del equipamiento.
     * @param estadisticas Estadísticas del objeto.
     * @param rareza       Rareza del objeto.
     * @param valor        Valor numérico del objeto.
     */
    public Equipamiento(String nombre, HashMap<String, Integer> estadisticas, String rareza, int valor) {
        setNombre(nombre);
        this.estadisticas = new HashMap<>(estadisticas);
        setRareza(rareza);
        setValor(valor);
    }

    /**
     * Constructor de copia.
     *
     * @param copia Otro objeto Equipamiento a copiar.
     */
    public Equipamiento(Equipamiento copia) {
        this.nombre = copia.nombre;
        this.estadisticas = new HashMap<>(copia.estadisticas);
        this.rareza = copia.rareza;
        this.valor = copia.valor;
    }

    /**
     * Devuelve el nombre del equipamiento.
     *
     * @return Nombre del objeto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del equipamiento.
     * Máximo 20 caracteres. Si no cumple, se guarda como vacío.
     *
     * @param nombre Nombre a establecer.
     */
    public void setNombre(String nombre) {
        if (nombre == null) {
            this.nombre = "";
        }

        if (nombre.length() <= 20) {
            this.nombre = nombre;
        } else {
            this.nombre = "";
        }
    }

    /**
     * Devuelve las estadísticas del equipamiento.
     *
     * @return Mapa de estadísticas.
     */
    public HashMap<String, Integer> getEstadisticas() {
        return new HashMap<>(estadisticas);
    }

    /**
     * Establece las estadísticas del equipamiento.
     *
     * @param estadisticas Mapa de estadísticas.
     */
    public void setEstadisticas(HashMap<String, Integer> estadisticas) {
        this.estadisticas = new HashMap<>(estadisticas);
    }

    /**
     * Devuelve la rareza del objeto.
     *
     * @return Rareza (común, raro, épico, legendario).
     */
    public String getRareza() {
        return rareza;
    }

    /**
     * Establece la rareza del objeto si es válida. Si no, se establece como "comun".
     *
     * @param rareza Rareza a establecer.
     */
    public void setRareza(String rareza) {
        switch (rareza.toLowerCase()) {
            case "comun":
            case "raro":
            case "épico":
            case "legendario":
                this.rareza = rareza.toLowerCase();
                break;
            default:
                this.rareza = "comun";
        }
    }

    /**
     * Devuelve el valor del equipamiento.
     *
     * @return Valor numérico.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Establece el valor del equipamiento. Mínimo 1.
     *
     * @param valor Valor numérico.
     */
    public void setValor(int valor) {
        if (valor < 1) {
            this.valor = 1;
        } else {
            this.valor = valor;
        }
    }

    /**
     * Devuelve el valor de una estadística concreta.
     *
     * @param clave Nombre de la estadística.
     * @return Valor de la estadística, o 0 si no existe.
     */
    public int recuperaEstadistica(String clave) {
        if (estadisticas.containsKey(clave)) {
            return estadisticas.get(clave);
        } else {
            return 0;
        }
    }


    /**
     * Compara este objeto con otro para saber si son iguales.
     * Se comparan nombre, estadísticas, rareza y valor.
     *
     * @param otro Otro objeto Equipamiento.
     * @return true si son iguales, false si hay diferencias.
     */
    public boolean equals(Equipamiento otro) {
        if (!this.nombre.equals(otro.nombre))
            return false;
        if (!this.estadisticas.equals(otro.estadisticas))
            return false;
        if (!this.rareza.equals(otro.rareza))
            return false;
        if (this.valor != otro.valor)
            return false;

        return true;
    }

    /**
     * Devuelve una cadena descriptiva del equipamiento.
     *
     * @return Información del objeto.
     */
    @Override
    public String toString() {
        String resultado;
        resultado = "El nombre del equipamiento es: " + nombre +
                "\n Su rareza es: " + rareza +
                "\n Su valor es de: " + valor + "de oro";
        return resultado;
    }
}


