import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestPirate {
    // C'est ce qui permet de récupérer les sorties terminales
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    public static List<String> getLine() {
        StringBuilder test = new StringBuilder();
        List<String> listOutputs = new ArrayList<>();
        for (char lettre : outContent.toString().toCharArray()) {
            if (lettre != '\n') {
                test.append(lettre);
            } else {
                listOutputs.add(test.toString());
                test.setLength(0);
            }
        }
        return listOutputs;
    }

    public static void testsMethodeGetNomPirate() throws Exception {
        // Premier test pour savoir si la méthode getNomPirate existe bien
        try {
            Class.forName("Pirate").getDeclaredMethod("getNomPirate");
        } catch (Exception e) {
            throw new Exception("La méthode getNomPirate n\'existe pas. Vérifier que son nom corresponde bien à celui de l\'énoncé");
        }
        // Second test pour savoir si la méthode getNomPirate est publique
        if (!(Class.forName("Pirate").getDeclaredMethod("getNomPirate").getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("La méthode getNomPirate n\'est pas publique");
        }
        // Troisième test pour savoir si la méthode getNomPirate renvoie bien un objet String
        if (!(Class.forName("Pirate").getDeclaredMethod("getNomPirate").getReturnType().toString().equals("class java.lang.String")))  {
            throw new Exception("La méthode getNomPirate ne renvoie pas un objet String");
        }
        if (!(getLine().get(0).equals("Barnabe"))) {
            throw new Exception("Le nom du pirate n\'est pas bon");
        }
    }

    public static void testsMethodeGetTaillePirate() throws Exception {
        // Premier test pour savoir si la méthode getTaillePirate existe bien
        try {
            Class.forName("Pirate").getDeclaredMethod("getTaillePirate");
        } catch (Exception e) {
            throw new Exception("La méthode getTaillePirate n\'existe pas. Vérifier que son nom corresponde bien à celui de l\'énoncé");
        }
        // Deuxième test pour savoir si la méthode est publique
        if (!(Class.forName("Pirate").getDeclaredMethod("getTaillePirate").getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("La méthode getTaillePirate n\'est pas publique");
        }
        // Troisième test pour savoir si la méthode renvoie bien un double
        if (!(Class.forName("Pirate").getDeclaredMethod("getTaillePirate").getReturnType().toString().equals("double"))) {
            throw new Exception("La méthode getTaillePirate ne renvoie pas un double");
        }
    }

    public static void testsMethodeGetPointurePirate() throws Exception {
        // Premier test pour savoir si la méthode getPointurePirate existe
        try {
            Class.forName("Pirate").getDeclaredMethod("getPointurePirate");
        } catch (Exception e) {
            throw new Exception("La méthode getPointurePirate n\'existe pas. Vérifier que son nom corresponde bien à celui de l\'énoncé");
        }
        // Deuxième test pour savoir si la méthode est publique
        if (!(Class.forName("Pirate").getDeclaredMethod("getPointurePirate").getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("La méthode getPointurePirate n\'est pas publique");
        }
        // Troisième test pour savoir si la méthode renvoie bien un int
        if (!(Class.forName("Pirate").getDeclaredMethod("getPointurePirate").getReturnType().toString().equals("int"))) {
            throw new Exception("La méthode getPointurePirate ne renvoie pas un entier");
        }
    }

    public static void testsMethodeGetLettrePirate() throws Exception {
        // Premier test pour savoir si la méthode getLettrePirate existe bien
        try {
            Class.forName("Pirate").getDeclaredMethod("getLettrePirate");
        } catch (Exception e) {
            throw new Exception("La méthode getLettrePirate n\'existe pas. Vérifier que son nom corresponde bien à celui de l\'énoncé");
        }
        // Deuxième test pour savoir si la méthode est publique
        if (!(Class.forName("Pirate").getDeclaredMethod("getLettrePirate").getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("La méthode getLettrePirate n\'est pas publique");
        }
        // Troisième test pour savoir si la méthode renvoie bien un caractère
        if (!(Class.forName("Pirate").getDeclaredMethod("getLettrePirate").getReturnType().toString().equals("char"))) {
            throw new Exception("La méthode getLettrePirate ne renvoie pas une lettre");
        }
    }
     public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        Pirate.main(null);
        System.setErr(originalErr);
        System.setOut(originalOut);


        if (!errContent.toString().isEmpty()) {
            throw new Exception(errContent.toString());
        }

        testsMethodeGetNomPirate();
        testsMethodeGetTaillePirate();
        testsMethodeGetPointurePirate();
        testsMethodeGetLettrePirate();


        System.out.println("Exercice fini :)");
    }
}
