import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Predicate;

public class RankingPilotos {

    private ArrayList<Piloto> rankingPilotos = new ArrayList<>();

    public RankingPilotos() {

    }

    public void AnadirPilotos() {
        String[] linea;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("pilotos.csv"));
            String line = br.readLine();
            while (null != line) {

                linea = line.split(";");

                rankingPilotos.add(new Piloto(linea[1], linea[2], Integer.parseInt(linea[0])));

                line = br.readLine();
            }

        } catch (Exception e) {
            System.err.println("Error! " + e.getMessage());
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Error closing file !! " + e.getMessage());
                }
            }
        }
    }

    public void anadirPiloto(Piloto piloto, int posicionDeSalida) {
        rankingPilotos.add(posicionDeSalida, piloto);
    }

    public void adelantarPiloto(Piloto piloto, int posicionOrigen, int posicionAdelantar) {
        rankingPilotos.add(posicionAdelantar, piloto);
        rankingPilotos.remove(posicionOrigen +1);
    }

    public void retrasarPiloto(Piloto piloto, int posicionOrigen) {
        rankingPilotos.add(posicionOrigen +2, piloto);
        rankingPilotos.remove(posicionOrigen);
    }

    public void eliminarPilotosDescalificados() {
        Predicate<Piloto> condicion = piloto -> piloto.getDescalificado();
        rankingPilotos.removeIf(condicion);
    }

    public void ordenarPilotosPorPosicionDeSalida() {
        Collections.sort(rankingPilotos);
        for (Piloto aux : rankingPilotos) {
        }
    }

    public void ordenarPilotosPorNombre() {
        Collections.sort(rankingPilotos, new ComparadorAlfabetico());
        for (Piloto aux : rankingPilotos) {
            System.out.println(aux);
        }
    }

    public Piloto getPiloto(int posicion){
        return rankingPilotos.get(posicion);
    }

    public void informePilotos(){
        Iterator<Piloto> it = rankingPilotos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
