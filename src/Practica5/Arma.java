package Practica5;

import java.util.HashMap;

/**
 * Clase que representa un arma, que es un tipo de equipamiento.
 * Cada arma tiene un tipo, una empuñadura y estadísticas asociadas.
 */
public class Arma extends Equipamiento {
    private String empuñadura;
    private String tipo;

    /**
     * Constructor principal del arma con todos los atributos necesarios.
     *
     * @param nombre   Nombre del arma.
     * @param rareza   Rareza del arma.
     * @param tipo     Tipo del arma (espada, maza, etc.).
     * @param fuerza   Valor de fuerza.
     * @param agilidad Valor de agilidad.
     * @param magia    Valor de magia.
     * @param fe       Valor de fe.
     * @param valor    Valor monetario o de poder del arma.
     */
    public Arma(String nombre, String rareza, String tipo, int fuerza, int agilidad, int magia, int fe, int valor) {
        super(nombre, new HashMap<>(), rareza, valor);
        setTipo(tipo);
        setEmpuñadura(empuñadura);
        HashMap<String, Integer> estadisticicas = new HashMap<>();
        estadisticicas.put("fuerza", fuerza);
        estadisticicas.put("agilidad", agilidad);
        estadisticicas.put("magia", magia);
        estadisticicas.put("fe", fe);
        setEstadisticas(estadisticicas);
    }

    /**
     * Constructor por defecto.
     */
    public Arma() {
        super();
        this.empuñadura = "";
        this.tipo = "";
    }

    /**
     * Constructor con todos los parámetros personalizados.
     *
     * @param nombre       Nombre del arma.
     * @param estadisticas Mapa con estadísticas (fuerza, agilidad, etc.).
     * @param rareza       Rareza del arma.
     * @param valor        Valor del arma.
     * @param empuñadura   Tipo de empuñadura (una mano o dos manos).
     * @param tipo         Tipo específico del arma.
     */
    public Arma(String nombre, HashMap<String, Integer> estadisticas, String rareza, int valor, String empuñadura, String tipo) {
        super(nombre, estadisticas, rareza, valor);
        setEmpuñadura(empuñadura);
        setTipo(tipo);
    }


    /**
     * Constructor de copia.
     *
     * @param copia Otra arma a copiar.
     */
    public Arma(Arma copia) {
        super(copia);
        this.empuñadura = copia.empuñadura;
        this.tipo = copia.tipo;
    }

    /**
     * Devuelve el tipo de empuñadura.
     *
     * @return Empuñadura del arma.
     */
    public String getEmpuñadura() {
        return empuñadura;
    }

    /**
     * Devuelve el tipo de arma.
     *
     * @return Tipo del arma.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece la empuñadura del arma. Solo admite "una mano" o "dos manos".
     *
     * @param empuñadura Tipo de empuñadura.
     */
    public void setEmpuñadura(String empuñadura) {
        if (empuñadura.equals("una mano") || empuñadura.equals("dos manos")) {
            this.empuñadura = empuñadura;
        } else {
            this.empuñadura = "";
        }
    }

    /**
     * Comprueba si el tipo de arma es válido según su empuñadura.
     *
     * @param empuñadura Tipo de empuñadura.
     * @param tipo       Tipo del arma.
     * @return true si es válido, false en caso contrario.
     */
    private boolean comprobarTipo(String empuñadura, String tipo) {

        boolean ok = false;
        if (empuñadura.equals("una mano")) {
            switch (tipo) {
                case "maza", "hacha", "espada", "cetro", "daga":
                    ok = true;
                    break;
            }
        }
        if (empuñadura.equals("dos manos")) {
            switch (tipo) {
                case "espadon", "martillo", "arco", "baston":
                    ok = true;
                    break;
            }
        }
        return false;
    }

    /**
     * Establece el tipo de arma si es válido con respecto a su empuñadura.
     *
     * @param tipo Tipo de arma.
     */
    public void setTipo(String tipo) {
        if (comprobarTipo(this.empuñadura, tipo)) {
            this.tipo = tipo;
        } else {
            this.tipo = "";
        }
    }

    /**
     * Establece las estadísticas del arma filtrando solo las válidas (fuerza, agilidad, magia, fe).
     *
     * @param estadisticas Mapa de estadísticas a establecer.
     */
    @Override
    public void setEstadisticas(HashMap<String, Integer> estadisticas) {
        HashMap<String, Integer> estadisticasValidas = new HashMap<>();

        for (String clave : estadisticas.keySet()) {

            if (clave.equals("fuerza") || clave.equals("magia") || clave.equals("fe") || clave.equals("agilidad")) {
                estadisticasValidas.put(clave, estadisticas.get(clave));
            }
        }
        super.setEstadisticas(estadisticasValidas);
    }

    /**
     * Compara si dos armas son iguales en base a su equipamiento, empuñadura y tipo.
     *
     * @param otro Otra arma para comparar.
     * @return true si son iguales, false si no lo son.
     */
    public boolean equals(Arma otro) {
        if (!super.equals(otro)) return false;
        if (!this.empuñadura.equals(otro.empuñadura)) return false;
        if (!this.tipo.equals(otro.tipo)) return false;
        return true;
    }

    /**
     * Devuelve una representación en texto del arma, incluyendo sus atributos.
     *
     * @return Cadena con la información del arma.
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n Este arma es de tipo: " + tipo +
                "\n Este arma tiene una empuñadura de: " + empuñadura;
    }
}