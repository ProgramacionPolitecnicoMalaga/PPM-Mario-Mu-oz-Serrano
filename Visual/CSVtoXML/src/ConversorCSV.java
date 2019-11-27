import java.io.*;

public class ConversorCSV {

    public ConversorCSV() {

    }

    public String[][] convertirCSV(String nombreArchivo, int numeroSeparadores, int numeroLineas) {
        String[] linea;
        int lineaPosicion = 0;
        BufferedReader br = null;
        String[][] arrayCSV = new String[numeroLineas][numeroSeparadores+1];

        try {
            br = new BufferedReader(new FileReader(nombreArchivo));
            String line = br.readLine();
            while (null != line) {
                linea = line.split(",");
                for (int i = 0; i < linea.length-1; i++) {
                    arrayCSV[lineaPosicion][i] = linea[i];
                }
                lineaPosicion++;
                line = br.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arrayCSV;
    }
}
