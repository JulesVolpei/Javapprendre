package javatests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestAfficherLettreParLettre {
    // C'est ce qui permet de récupérer les sorties terminales
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

    public static void testAffichageLettreParLettre(List<String> liste) throws Exception {
        try {
            Class.forName("javatests.ManipulationString").getMethod("afficherLettreParLettre", String.class);
        } catch (Exception e) {
            throw new Exception("Il ne faut pas modifier la méthode afficherLettreParLettre(String mot)");
        }
        if (!(Class.forName("javatests.ManipulationString").getMethod("afficherLettreParLettre", String.class).getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("Il faut que la méthode afficherLettreParLettre soit public");
        }
        if (!(Class.forName("javatests.ManipulationString").getMethod("afficherLettreParLettre", String.class).getReturnType().toString().equals("void"))) {
            throw new Exception("La méthode afficherLettreParLettre ne doit rien renvoyer");
        }

        for (int i = 2; i < liste.get(0).length(); i += 1) {
            char test = GenererMot.getMot().charAt(i - 2);
            try {
                char testLettre = liste.get(i).charAt(0);
            } catch (Exception e) {
                throw new Exception("Le mot lettre par lettre doit être correctement affiché pour que la méthode fonctionne.");
            }
            if (test != liste.get(i).charAt(0)) {
                throw new Exception("La lettre affichée n\'est pas la bonne. \n Attendu : " + test + "\n Reçu : " + liste.get(i).charAt(0));
            }
        }
    }

    public static void testAffichageLettreParLettre() throws Exception {
        try {
            Class.forName("javatests.ManipulationString").getMethod("afficherLettreParLettre", String.class);
        } catch (Exception e) {
            throw new Exception("Il ne faut pas modifier la méthode afficherLettreParLettre(String mot)");
        }
        if (!(Class.forName("javatests.ManipulationString").getMethod("afficherLettreParLettre", String.class).getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("Il faut que la méthode afficherLettreParLettre soit public");
        }
        if (!(Class.forName("javatests.ManipulationString").getMethod("afficherLettreParLettre", String.class).getReturnType().toString().equals("void"))) {
            throw new Exception("La méthode afficherLettreParLettre ne doit rien renvoyer");
        }

        for (int i = 2; i < getLine().get(0).length(); i += 1) {
            char test = GenererMot.getMot().charAt(i - 2);
            try {
                char testLettre = getLine().get(i).charAt(0);
            } catch (Exception e) {
                throw new Exception("Le mot lettre par lettre doit être correctement affiché pour que la méthode fonctionne.");
            }
            if (test != getLine().get(i).charAt(0)) {
                throw new Exception("La lettre affichée n\'est pas la bonne. \n Attendu : " + test + "\n Reçu : " + getLine().get(i).charAt(0));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        ManipulationString.main(null);
        System.setErr(originalErr);
        System.setOut(originalOut);

        if (!errContent.toString().isEmpty()) {
            throw new Exception(errContent.toString());
        }

        testAffichageLettreParLettre();
    }
}
