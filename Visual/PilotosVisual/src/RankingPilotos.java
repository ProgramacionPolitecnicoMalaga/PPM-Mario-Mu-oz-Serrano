import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RankingPilotos extends PilotosVisual{

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
                rankingPilotos.add(new Piloto(linea[1], linea[2], Integer.parseInt(linea[0]), Integer.parseInt(linea[0])));

                line = br.readLine();
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void generarCSV (String nombreArchivo) {
        try {
            BufferedWriter bw = new BufferedWriter (new FileWriter(nombreArchivo + ".csv"));
            for (int i=0;i<rankingPilotos.size();i++) {
                Piloto piloto = rankingPilotos.get(i);
                bw.write(piloto.getNombre() + ";" + piloto.getEscuderia() +";"+ piloto.getPosicionActual());
                bw.newLine();
            }
            bw.close();
        } catch (Throwable t) {}
    }

     public void generarCarrera() {

         int numeroDePilotosAMover = (int) (Math.random() * (rankingPilotos.size() +1));
         String[] pilotosMovidos = new String[numeroDePilotosAMover];

        for (int i=0;i<numeroDePilotosAMover;i++){
            int posicionOrigen = (int) (Math.random() * rankingPilotos.size());
            int nPosiciones = (int) (Math.random() * 2 + 1);

            for (int x=0;x<pilotosMovidos.length;x++) {
                if (rankingPilotos.get(posicionOrigen).getNombre().equals(pilotosMovidos[x])){
                    posicionOrigen = (int) (Math.random() * rankingPilotos.size());
                    x=0;
                    }
                }
            if (!(posicionOrigen<=1)) {
                int posicionAdelantar = posicionOrigen - nPosiciones;
                rankingPilotos.add(posicionAdelantar, rankingPilotos.get(posicionOrigen));
                rankingPilotos.remove(posicionOrigen + 1);
            }
            if (posicionOrigen==1){
                int posicionAdelantar = posicionOrigen - 1;
                rankingPilotos.add(posicionAdelantar, rankingPilotos.get(posicionOrigen));
                rankingPilotos.remove(posicionOrigen + 1);
            }
            pilotosMovidos[i] = rankingPilotos.get(posicionOrigen).getNombre();
        }
         for (int i=0;i<rankingPilotos.size();i++){
             rankingPilotos.get(i).setPosicionActual(i+1);
         }
    }


    public ArrayList obtenerRanking(){
        return rankingPilotos;
    }

}
