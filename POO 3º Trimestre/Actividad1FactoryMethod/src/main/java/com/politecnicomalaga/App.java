package com.politecnicomalaga;

import com.politecnicomalaga.factory_method.ViewerFactory;
import com.politecnicomalaga.factory_method.ViewerFactoryHTML;
import com.politecnicomalaga.factory_method.ViewerFactoryText;
import com.politecnicomalaga.viewer.DataViewer;
import io.github.cdimascio.dotenv.Dotenv;

public class App {

    private static Dotenv dotenv = Dotenv.configure().load();
    private static String tipoDataViewer = dotenv.get("viewer");
    private static ViewerFactory tipoDeVisualizador;

    public static void main(String[] args) {
        inicializar();
        DataViewer dataViewer = tipoDeVisualizador.crearViewer();
        dataViewer.mostrarContenido();
    }

    public static void inicializar(){
        if (tipoDataViewer.equals(DataViewer.TEXT))
        tipoDeVisualizador = new ViewerFactoryText();
        else if (tipoDataViewer.equals(DataViewer.HTML))
            tipoDeVisualizador = new ViewerFactoryHTML();
        else
            throw new IllegalArgumentException("No existe ese tipo de visualizador");
    }
}
