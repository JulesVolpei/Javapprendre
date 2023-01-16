package javatests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestAfficherLeMotAvecUneLettreSurDeuxEnMinuscule {
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

    public static void testAffichageDuMotAvecUneLettreSurDeuxEnMinuscule() throws Exception {
        try {
            Class.forName("javatests.ManipulationString").getMethod("afficherLeMotAvecUneLettreSurDeuxEnMinuscule", String.class);
        } catch (Exception e) {
            throw new Exception("Il ne faut pas modifier la méthode afficherLeMotAvecUneLettreSurDeuxEnMinuscule(String mot)");
        }
        if (!(Class.forName("javatests.ManipulationString").getMethod("afficherLeMotAvecUneLettreSurDeuxEnMinuscule", String.class).getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("Il faut que la méthode afficherLeMotAvecUneLettreSurDeuxEnMinuscule soit public");
        }
        if (!(Class.forName("javatests.ManipulationString").getMethod("afficherLeMotAvecUneLettreSurDeuxEnMinuscule", String.class).getReturnType().toString().equals("void"))) {
            throw new Exception("La méthode afficherLeMotAvecUneLettreSurDeuxEnMinuscule ne doit rien renvoyer");
        }
        StringBuilder test = new StringBuilder();
        boolean minuscule = true;
        for (char lettre : GenererMot.getMot().toCharArray()) {
            if (minuscule) {
                test.append(Character.toLowerCase(lettre));
                minuscule = false;
            } else {
                test.append(lettre);
                minuscule = true;
            }
        }
        String motEnDemiMinuscule = test.toString();
        try {
            String testMot = getLine().get(8);
        } catch (Exception e) {
            throw new Exception("Il faut afficher le mot avec  une lettre sur deux en minuscule pour que la méthode fonctionne.");
        }
        if (!getLine().get(8).equals(motEnDemiMinuscule)) {
            throw new Exception("Le mot affiché n\'est pas bon. \n Attendu : " + motEnDemiMinuscule + "\n Reçu : " + getLine().get(8));
        }
    }

    public static void testAffichageDuMotAvecUneLettreSurDeuxEnMinuscule(List<String> liste) throws Exception {
        try {
            Class.forName("javatests.ManipulationString").getMethod("afficherLeMotAvecUneLettreSurDeuxEnMinuscule", String.class);
        } catch (Exception e) {
            throw new Exception("Il ne faut pas modifier la méthode afficherLeMotAvecUneLettreSurDeuxEnMinuscule(String mot)");
        }
        if (!(Class.forName("javatests.ManipulationString").getMethod("afficherLeMotAvecUneLettreSurDeuxEnMinuscule", String.class).getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("Il faut que la méthode afficherLeMotAvecUneLettreSurDeuxEnMinuscule soit public");
        }
        if (!(Class.forName("javatests.ManipulationString").getMethod("afficherLeMotAvecUneLettreSurDeuxEnMinuscule", String.class).getReturnType().toString().equals("void"))) {
            throw new Exception("La méthode afficherLeMotAvecUneLettreSurDeuxEnMinuscule ne doit rien renvoyer");
        }
        StringBuilder test = new StringBuilder();
        boolean minuscule = true;
        for (char lettre : GenererMot.getMot().toCharArray()) {
            if (minuscule) {
                test.append(Character.toLowerCase(lettre));
                minuscule = false;
            } else {
                test.append(lettre);
                minuscule = true;
            }
        }
        try {
            String testMot = liste.get(8);
        } catch (Exception e) {
            throw new Exception("Il faut afficher le mot avec  une lettre sur deux en minuscule pour que la méthode fonctionne.");
        }
        String motEnDemiMinuscule = test.toString();
        if (!liste.get(8).equals(motEnDemiMinuscule)) {
            throw new Exception("Le mot affiché n\'est pas bon. \n Attendu : " + motEnDemiMinuscule + "\n Reçu : " + liste.get(8));
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

        testAffichageDuMotAvecUneLettreSurDeuxEnMinuscule();
        System.out.println("Le test est bon");
    }
}
