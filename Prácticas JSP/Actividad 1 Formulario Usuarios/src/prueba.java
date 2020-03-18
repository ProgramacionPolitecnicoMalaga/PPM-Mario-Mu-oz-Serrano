import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class prueba {

    public static void main(String[] args) {
        File file = new File("imagen.jpg");
        FileInputStream inputImagen = null;
        try {
            inputImagen = new FileInputStream(file);
        byte[] imageBytes = new byte[(int)file.length()];
        inputImagen.read(imageBytes, 0, imageBytes.length);
        inputImagen.close();
        String imageStr = Base64.getEncoder().encodeToString(imageBytes);
        System.out.println(imageStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
