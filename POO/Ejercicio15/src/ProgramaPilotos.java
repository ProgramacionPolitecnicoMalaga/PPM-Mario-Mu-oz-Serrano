public class ProgramaPilotos {

    public static void main(String[] args) {
        RankingPilotos rankingPilotos = new RankingPilotos();

        System.out.println("\nPARRILLA DE SALIDA INICIAL:\n");
        rankingPilotos.AnadirPilotos();
        rankingPilotos.informePilotos();

        System.out.println("\n<====================================================================>");
        System.out.println("Pilotos ordenados por nombre:\n");
        rankingPilotos.ordenarPilotosPorNombre();
        rankingPilotos.ordenarPilotosPorPosicionDeSalida();

        System.out.println("\n<====================================================================>");
        System.out.println("El piloto Hamilton L. adelanta hasta la tercera posición y Magnussen K. hasta la novena:\n");

        rankingPilotos.adelantarPiloto(rankingPilotos.getPiloto(4), 4,2);
        rankingPilotos.adelantarPiloto(rankingPilotos.getPiloto(11), 11,8);
        rankingPilotos.informePilotos();

        System.out.println("\n<====================================================================>");
        System.out.println("Los pilotos Albon A. y Grosjean R. son descalificados:\n");

        rankingPilotos.getPiloto(5).setDescalificado();
        rankingPilotos.getPiloto(14).setDescalificado();
        rankingPilotos.eliminarPilotosDescalificados();
        rankingPilotos.informePilotos();

        System.out.println("\n<====================================================================>");
        System.out.println("Se vuelve a ordenar por posición de salida teniendo en cuenta las descalificaciones:\n");
        rankingPilotos.ordenarPilotosPorPosicionDeSalida();
        rankingPilotos.informePilotos();

    }
}
