import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class MiMain {

    public static void main(String[] args) {
        String[] palabras = new String[0];
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("sample_text.txt"));
            String line = br.readLine();
            while (null != line) {
                palabras = line.split(" ");


                line = br.readLine();
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }


        System.out.println("Listado de palabras:");
        for (int i=0;i<palabras.length;i++) {
            palabras[i]=palabras[i].replace(",","");
            palabras[i]=palabras[i].replace(".","");
            palabras[i]=palabras[i].replace("(","");
            palabras[i]=palabras[i].replace(")","");
            palabras[i]=palabras[i].replace(" ","");
            System.out.println(palabras[i]);
        }

        HashSet<String> hashPalabras = new HashSet<>(Arrays.asList(palabras));

        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("Listado de palabras sin las repetidas:");
        Iterator<String> it = hashPalabras.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}


