package Practica5;

public final class Combate {

    public static void EmpezarCombate(Personaje p1, Personaje p2) {
        if (p1.getVitalidad() > 0 && p2.getVitalidad() > 0) {
            System.out.println(p1.toString());
            System.out.println(p2.toString());

            do {
                if (p1.getAgilidad() >= p2.getAgilidad() * 2) {
                    System.out.println(p1.getNombre() + " Este persona ataca 2 veces. ");
                    p2.setVitalidad(p2.getVitalidad() - (p1.luchar()) * 2);
                    System.out.println(p1.getNombre() + " Inflige un daño de " + p1.luchar() * 2);
                    p1.setVitalidad(p1.getVitalidad() - p2.luchar());
                    System.out.println(p2.getNombre() + " Inflige un daño de " + p2.luchar());

                } else if (p2.getAgilidad() >= p1.getAgilidad() * 2) {
                    System.out.println(p1.getNombre() + " Este persona ataca 2 veces. ");
                    p1.setVitalidad(p1.getVitalidad() - (p2.luchar()) * 2);
                    System.out.println(p1.getNombre() + " Inflige un daño de " + p2.luchar() * 2);
                    p2.setVitalidad(p2.getVitalidad() - p1.luchar());
                    System.out.println(p1.getNombre() + " Inflige un daño de " + p1.luchar());

                } else if (p1.getAgilidad() > p2.getAgilidad()) {
                    System.out.println(p1.getNombre() + " Es quien ataca primero");
                    p2.setVitalidad(p2.getVitalidad() - p1.luchar());
                    System.out.println(p1.getNombre() + " Inflige un daño de " + p1.luchar());
                    p1.setVitalidad(p1.getVitalidad() - p2.luchar());
                    System.out.println(p2.getNombre() + " Inflige un daño de " + p2.luchar());

                } else {
                    System.out.println(p2.getNombre() + " Es quien ataca primero");
                    p1.setVitalidad(p1.getVitalidad() - p2.luchar());
                    System.out.println(p2.getNombre() + " Inflige un daño de " + p2.luchar());
                    p2.setVitalidad(p2.getVitalidad() - p1.luchar());
                    System.out.println(p1.getNombre() + " Inflige un daño de " + p1.luchar());
                }
            } while (p1.getVitalidad() > 0 && p2.getVitalidad() > 0);

            if (p1.getVitalidad() > 0) {
                System.out.println(p1.getNombre() + " Ha ganado el combate");
            } else {
                System.out.println(p2.getNombre() + " Ha ganado el combate");
            }


        }
    }
}

