
public class Aplicación {

    public static void main(String[] args) {
        GestorEmpleados gestorEmpleados = new GestorEmpleados();
        GestorEmpleados.listarProyectos();
        GestorEmpleados.añadirEmpleados();

        //Introducir datos de los trabajos realizados durante el día:
        gestorEmpleados.getEmpleado("Javier Gonzalez").setProductividad("Alphasec",6);
        gestorEmpleados.getEmpleado("Javier Gonzalez").setProductividad("Gforce",2);
        gestorEmpleados.getEmpleado("Federico Gutierrez").setProductividad("Lunar",4);
        gestorEmpleados.getEmpleado("Federico Gutierrez").setProductividad("Stratos",4);
        gestorEmpleados.getEmpleado("Alonso Gallardo").setProductividad("Leonard",5);
        gestorEmpleados.getEmpleado("Alonso Gallardo").setProductividad("Alphasec",3);
        gestorEmpleados.getEmpleado("Manuel Dominguez").setProductividad("Gforce",7);
        gestorEmpleados.getEmpleado("Manuel Dominguez").setProductividad("Lunar",1);
        gestorEmpleados.getEmpleado("Antonio Perez").setProductividad("Stratos",5);
        gestorEmpleados.getEmpleado("Antonio Perez").setProductividad("Leonard",3);

        //Listado de tareas realizadas por cada empleado:
        gestorEmpleados.getEmpleado("Javier Gonzalez").listarTareas();
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        gestorEmpleados.getEmpleado("Federico Gutierrez").listarTareas();
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        gestorEmpleados.getEmpleado("Alonso Gallardo").listarTareas();
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        gestorEmpleados.getEmpleado("Manuel Dominguez").listarTareas();
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        gestorEmpleados.getEmpleado("Antonio Perez").listarTareas();
        System.out.println("-----------------------");
        System.out.println("-----------------------");

        //Listado de tareas relacionadas con un proyecto:
        gestorEmpleados.getProyecto("Leonard").listarTareas();

        //Listado de nóminas:
        gestorEmpleados.listadoDeNominas();
    }
}
