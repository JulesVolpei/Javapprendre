package javatests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class    TestGetterTaillePirate {
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

    public static void testsMethodeGetTaillePirate(List<String> list) throws Exception {
            // Test pour savoir si la méthode getTaillePirate existe bien
            try {
                Class.forName("javatests.Pirate").getDeclaredMethod("getTaillePirate");
            } catch (Exception e) {
                throw new Exception("La méthode getTaillePirate n\'existe pas. Vérifier que son nom corresponde bien à celui de l\'énoncé");
            }
            // Test pour savoir si la méthode est publique
            if (!(Class.forName("javatests.Pirate").getDeclaredMethod("getTaillePirate").getModifiers() == Modifier.PUBLIC)) {
                throw new Exception("La méthode getTaillePirate n\'est pas publique");
            }
            // Test pour savoir si la méthode renvoie bien un double
            if (!(Class.forName("javatests.Pirate").getDeclaredMethod("getTaillePirate").getReturnType().toString().equals("double"))) {
                throw new Exception("La méthode getTaillePirate ne renvoie pas un double");
            }
            // Test pour savoir si l'utilisateur renvoie le bon résultat
            try {
                list.get(1);
            } catch (Exception e) {
                throw new Exception("Il faut afficher la taille du pirate");
            }
            if (!(list.get(1).equals("1.62"))) {
                throw new Exception("La taille du pirate n\'est pas bonne");
            }
        } 

    public static void testsMethodeGetTaillePirate() throws Exception {
            // Test pour savoir si la méthode getTaillePirate existe bien
            try {
                Class.forName("javatests.Pirate").getDeclaredMethod("getTaillePirate");
            } catch (Exception e) {
                throw new Exception("La méthode getTaillePirate n\'existe pas. Vérifier que son nom corresponde bien à celui de l\'énoncé");
            }
            // Test pour savoir si la méthode est publique
            if (!(Class.forName("javatests.Pirate").getDeclaredMethod("getTaillePirate").getModifiers() == Modifier.PUBLIC)) {
                throw new Exception("La méthode getTaillePirate n\'est pas publique");
            }
            // Test pour savoir si la méthode renvoie bien un double
            if (!(Class.forName("javatests.Pirate").getDeclaredMethod("getTaillePirate").getReturnType().toString().equals("double"))) {
                throw new Exception("La méthode getTaillePirate ne renvoie pas un double");
            }
            // Test pour savoir si l'utilisateur renvoie le bon résultat
            try {
                getLine().get(1);
            } catch (Exception e) {
                throw new Exception("Il faut afficher la taille du pirate");
            }
            if (!(getLine().get(1).equals("1.62"))) {
                throw new Exception("La taille du pirate n\'est pas bonne");
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
        testsMethodeGetTaillePirate();

        System.out.println("Le test est bon");
    }
}