package Practica5;

public final class Combate {
    private Personaje personaje1;
    private Personaje personaje2;
    private String resultado;

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
    public String toString(){
        if (resultado.equals("Victoria"))
            return "Has ganado a" + personaje2.getNombre() ;
        else
            return "Te ha derrotado " + personaje1.getNombre() ;
    }
}
