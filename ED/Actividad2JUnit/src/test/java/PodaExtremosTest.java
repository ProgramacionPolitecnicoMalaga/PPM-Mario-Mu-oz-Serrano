import com.politecnicomalaga.PodaExtremos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class PodaExtremosTest {

    private PodaExtremos podaExtremos;
    private ArrayList<Integer> listaNumeros;
    private int resultadoEsperado;
    private int resultadoObtenido;

    @Before
    public void setUp() {
        podaExtremos = new PodaExtremos();
        listaNumeros = new ArrayList<>();
        Collections.addAll(listaNumeros, 1,21,55,1,5,8,13,3,2,34);
    }

    public void obtenerResultados(int esperado, int obtenido) {
        resultadoEsperado = esperado;
        resultadoObtenido = obtenido;
    }

    @After
    public void tearDown() {
        listaNumeros.clear();
    }

    @Test
    public void podarMasProximo() {
        obtenerResultados(8, podaExtremos.podarMasProximo(9, listaNumeros));
        assertEquals(resultadoEsperado, resultadoObtenido);

        obtenerResultados(55, podaExtremos.podarMasProximo(49, listaNumeros));
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void podarMasLejano() {
        obtenerResultados(55, podaExtremos.podarMasLejano(10, listaNumeros));
        assertEquals(resultadoEsperado, resultadoObtenido);

        obtenerResultados(1, podaExtremos.podarMasLejano(30, listaNumeros));
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
}