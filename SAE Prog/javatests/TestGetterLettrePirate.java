package javatests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestGetterLettrePirate {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    public static List<String> getLine() {
        // StringBuilder pour récupérer la totalité de la ligne
        StringBuilder test = new StringBuilder();
        // Liste qui permet de stocker les différentes lignes
        List<String> listOutputs = new ArrayList<>();
        // On parcourt ce que l'utilisateur affiche
        for (char lettre : outContent.toString().toCharArray()) {
            // On ajoute la lettre si il n'y a aucun retour à la ligne
            if ((int) lettre != 13 && (int) lettre != 10) {
                test.append(lettre);
            } else { // Sinon on aoute la ligne à la liste et on efface le contenu du StringBuilder
                listOutputs.add(test.toString());
                test.setLength(0);
            }
        }
        listOutputs = corrigeListOutput(listOutputs);
        // On retourne la liste avec l'ensemble des lignes
        return listOutputs;
    }

    public static List<String> corrigeListOutput(List<String> listOutput) {
        List<String> nouvelListOutput = new ArrayList<>();
        for (String mot : listOutput) {
            if (mot.length() > 0) {
                nouvelListOutput.add(mot);
            }
        }
        return nouvelListOutput;
    }
    public static void testsMethodeGetLettrePirate(boolean lanceDepuisTestsGeneraux) throws Exception {
        if (lanceDepuisTestsGeneraux) {
            //Test pour savoir si la méthode getLettrePirate existe bien
            try {
                Class.forName("javatests.Pirate").getDeclaredMethod("getLettrePirate");
            } catch (Exception e) {
                throw new Exception("La méthode getLettrePirate n\'existe pas. Vérifier que son nom corresponde bien à celui de l\'énoncé");
            }
            // Test pour savoir si la méthode est publique
            if (!(Class.forName("javatests.Pirate").getDeclaredMethod("getLettrePirate").getModifiers() == Modifier.PUBLIC)) {
                throw new Exception("La méthode getLettrePirate n\'est pas publique");
            }
            // Test pour savoir si la méthode renvoie bien un caractère
            if (!(Class.forName("javatests.Pirate").getDeclaredMethod("getLettrePirate").getReturnType().toString().equals("char"))) {
                throw new Exception("La méthode getLettrePirate ne renvoie pas une lettre");
            }
            // Test pour savoir si ce que renvoie l'utilisateu est juste
            try {
                String test = TestPirate.getLine().get(3);
            } catch (Exception e) {
                throw new Exception("Il faut afficher la lettre du pirate");
            }
            if (!(TestPirate.getLine().get(3).equals("J"))) {
                throw new Exception("La lettre n\'est pas la bonne");
            }
        } else {
            //Test pour savoir si la méthode getLettrePirate existe bien
            try {
                Class.forName("javatests.Pirate").getDeclaredMethod("getLettrePirate");
            } catch (Exception e) {
                throw new Exception("La méthode getLettrePirate n\'existe pas. Vérifier que son nom corresponde bien à celui de l\'énoncé");
            }
            // Test pour savoir si la méthode est publique
            if (!(Class.forName("javatests.Pirate").getDeclaredMethod("getLettrePirate").getModifiers() == Modifier.PUBLIC)) {
                throw new Exception("La méthode getLettrePirate n\'est pas publique");
            }
            // Test pour savoir si la méthode renvoie bien un caractère
            if (!(Class.forName("javatests.Pirate").getDeclaredMethod("getLettrePirate").getReturnType().toString().equals("char"))) {
                throw new Exception("La méthode getLettrePirate ne renvoie pas une lettre");
            }
            // Test pour savoir si ce que renvoie l'utilisateu est juste
            try {
                String test = getLine().get(3);
            } catch (Exception e) {
                throw new Exception("Il faut afficher la lettre du pirate");
            }
            if (!(getLine().get(3).equals("J"))) {
                throw new Exception("La lettre n\'est pas la bonne");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        TestPirate.testLaClassePirateExiste();
        TestPirate.testLaMéthodeMainExisteCorrectement();

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        Pirate.main(null);
        // Faire tests sur les constructeurs
        System.setErr(originalErr);
        System.setOut(originalOut);
        testsMethodeGetLettrePirate(false);

        System.out.println("Le getter getLettrePirate est correct :D");
    }
}