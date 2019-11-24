import java.util.HashSet;
import java.util.Iterator;

public class IssueGenerator {

    public IssueGenerator() {

    }

    public static void main(String[] args) {

        HashSet<Issue> gestorIncidencias = new HashSet<>();

        for (int i=0; i<100; i++) {
            gestorIncidencias.add(new Issue(1, "incidencia grave", "CPU"));
        }

        Iterator<Issue> it = gestorIncidencias.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
