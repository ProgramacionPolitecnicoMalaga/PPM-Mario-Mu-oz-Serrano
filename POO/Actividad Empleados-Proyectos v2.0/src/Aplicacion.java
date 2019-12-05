public class Aplicacion {

    public static void main(String[] args) {
        GestorEmpleados gestorEmpleados = new GestorEmpleados();
        gestorEmpleados.añadirEmpleados();
        gestorEmpleados.listarProyectos();

        //Crear actividad
        Actividad actividad1 = new Actividad(gestorEmpleados.getEmpleado("26479512L"),gestorEmpleados.getProyecto("Alphasec"),"Avance fase beta1",1);
        Actividad actividad2 = new Actividad(gestorEmpleados.getEmpleado("26479512L"),gestorEmpleados.getProyecto("Alphasec"),"Avance fase beta2",2);
        Actividad actividad3 = new Actividad(gestorEmpleados.getEmpleado("26479512L"),gestorEmpleados.getProyecto("Alphasec"),"Avance fase beta3",3);
        Actividad actividad4 = new Actividad(gestorEmpleados.getEmpleado("26479512L"),gestorEmpleados.getProyecto("Alphasec"),"Avance fase beta4",4);

        //Listado de actividades de un empleado
        gestorEmpleados.listadoDeActividadesEmpleado("26479512L");

        //Listado de actividades relacionadas con el proyecto
        gestorEmpleados.listadoDeActividadesProyecto("Alphasec");

        //Listado de nóminas de todos los empleados
        gestorEmpleados.listadoDeNominas();
    }
}
