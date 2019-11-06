package ejercicioNominas;

public class Nominas {

    public static void main(String[] ars) {

        Empleados[] empleados=new Empleados[6];

        empleados[0] = new Comisionados("Mario Muñoz Serrano", "25786431N", 500, 12);
        empleados[1] = new Comisionados("Fran Perez Muniain", "25755458J", 500, 8);
        empleados[2] = new PorHoras("Julio Sanchez Palomo", "34728347L", 11.50, 180);
        empleados[3] = new PorHoras("Manuel Perez Serrano", "34723437L", 12.50, 140);
        empleados[4] = new Asalariados("Juan Muñoz Vera", "48569751L", 900);
        empleados[5] = new Asalariados("Alejandro Martinez Ceballos", "48564751L", 1300);

        System.out.println("Las nominas de las empresas son:");

        for (int i=0; i < empleados.length; i++) {
            System.out.println(empleados[i]);
        }
    }
}