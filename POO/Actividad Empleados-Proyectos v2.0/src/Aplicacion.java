public class Aplicacion {

    public static void main(String[] args) {
        GestorEmpleados gestorEmpleados = new GestorEmpleados();
        gestorEmpleados.añadirEmpleados();
        gestorEmpleados.listarProyectos();

        //Crear actividad
        Actividad actividad1 = new Actividad(gestorEmpleados.getEmpleado("26479512L"),gestorEmpleados.getProyecto("Alphasec"),"Avance fase beta1",1);
        Actividad actividad2 = new Actividad(gestorEmpleados.getEmpleado("26479512L"),gestorEmpleados.getProyecto("Gforce"),"Avance fase beta2",2);
        Actividad actividad3 = new Actividad(gestorEmpleados.getEmpleado("24624135M"),gestorEmpleados.getProyecto("Leonard"),"Avance fase beta3",3);
        Actividad actividad4 = new Actividad(gestorEmpleados.getEmpleado("24624135M"),gestorEmpleados.getProyecto("Stratos"),"Avance fase beta4",4);
        Actividad actividad5 = new Actividad(gestorEmpleados.getEmpleado("63424671N"),gestorEmpleados.getProyecto("Alphasec"),"Avance fase beta1",1);
        Actividad actividad6 = new Actividad(gestorEmpleados.getEmpleado("63424671N"),gestorEmpleados.getProyecto("Gforce"),"Avance fase beta2",2);
        Actividad actividad7 = new Actividad(gestorEmpleados.getEmpleado("48395713A"),gestorEmpleados.getProyecto("Leonard"),"Avance fase beta3",3);
        Actividad actividad8 = new Actividad(gestorEmpleados.getEmpleado("48395713A"),gestorEmpleados.getProyecto("Stratos"),"Avance fase beta4",4);

        //Listado de actividades de un empleado
        gestorEmpleados.listadoDeActividadesEmpleado("48395713A");

        //Listado de actividades relacionadas con el proyecto
        gestorEmpleados.listadoDeActividadesProyecto("Leonard");

        //Listado de nóminas de todos los empleados
        gestorEmpleados.listadoDeNominas();
    }
}
