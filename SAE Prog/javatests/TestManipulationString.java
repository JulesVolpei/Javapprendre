package javatests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TestManipulationString {
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

    public static void testPremierPrintEstLeMot() throws Exception {
        if (!(getLine().get(0).equals(GenererMot.getMot()))) {
            throw new Exception("Il faut afficher le mot en tout premier. \n Attendu : System.out.println(exercice.mot);");
        }
    }

    public static void main(String[] args) throws Exception {

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        ManipulationString.main(null);
        // Faire tests sur les constructeurs
        System.setErr(originalErr);
        System.setOut(originalOut);

        if (!errContent.toString().isEmpty()) {
            throw new Exception(errContent.toString());
        }
        testPremierPrintEstLeMot();

        TestAttributMot.testAttributMot();
        TestAfficherLeMotALEnvers.testAffichageMotAEnvers(getLine());
        TestAfficherLettreParLettre.testAffichageLettreParLettre(getLine());
        TestAfficherLeMotEnMinuscule.testAffichageMotEnMinuscule(getLine());
        TestAfficherLeMotAvecUneLettreSurDeuxEnMinuscule.testAffichageDuMotAvecUneLettreSurDeuxEnMinuscule(getLine());

        System.out.println("Exercice fini :)");
    }
}
