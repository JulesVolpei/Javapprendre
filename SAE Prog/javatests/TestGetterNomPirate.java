package javatests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestGetterNomPirate {
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
    public static void testsMethodeGetNomPirate(boolean lanceDepuisTestsGeneraux) throws Exception {
        if (lanceDepuisTestsGeneraux) {
            // Test pour savoir si la méthode getNomPirate existe
            try {
                Class.forName("javatests.Pirate").getDeclaredMethod("getNomPirate");
            } catch (Exception e) {
                throw new Exception("La méthode getNomPirate n\'existe pas. Vérifier que son nom correspond bien à celui de l\'énoncé");
            }
            // Test pour savoir si la méthode getNomPirate est publique
            if (!(Class.forName("javatests.Pirate").getDeclaredMethod("getNomPirate").getModifiers() == Modifier.PUBLIC)) {
                throw new Exception("La méthode getNomPirate n\'est pas publique");
            }
            // Test pour savoir si la méthode getNomPirate renvoie bien un objet String
            if (!(Class.forName("javatests.Pirate").getDeclaredMethod("getNomPirate").getReturnType().toString().equals("class java.lang.String"))) {
                throw new Exception("La méthode getNomPirate ne renvoie pas un objet String");
            }
            System.out.println(TestPirate.getLine().get(0));
            if (!(TestPirate.getLine().get(0).equals("Clemenceau"))) {
                throw new Exception("Le nom du pirate n\'est pas bon");
            }
        } else {
            // Test pour savoir si la méthode getNomPirate existe
            try {
                Class.forName("javatests.Pirate").getDeclaredMethod("getNomPirate");
            } catch (Exception e) {
                throw new Exception("La méthode getNomPirate n\'existe pas. Vérifier que son nom correspond bien à celui de l\'énoncé");
            }
            // Test pour savoir si la méthode getNomPirate est publique
            if (!(Class.forName("javatests.Pirate").getDeclaredMethod("getNomPirate").getModifiers() == Modifier.PUBLIC)) {
                throw new Exception("La méthode getNomPirate n\'est pas publique");
            }
            // Test pour savoir si la méthode getNomPirate renvoie bien un objet String
            if (!(Class.forName("javatests.Pirate").getDeclaredMethod("getNomPirate").getReturnType().toString().equals("class java.lang.String"))) {
                throw new Exception("La méthode getNomPirate ne renvoie pas un objet String");
            }
            System.out.println(getLine().get(0));
            if (!(getLine().get(0).equals("Clemenceau"))) {
                throw new Exception("Le nom du pirate n\'est pas bon");
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
        testsMethodeGetNomPirate(false);

        System.out.println("Le getter getNomPirate est correct :D");
    }
}
