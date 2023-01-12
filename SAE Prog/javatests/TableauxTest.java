package javatests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TableauxTest {
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

    public static void premierGetLineEstLeTableau() throws Exception {
        // Si l'utilisateur n'affiche pas le contenu de la liste de son tableau
        if (!getLine().get(0).equals(CreeTableau.getTableauStatic().toString())) {
            // Message d'erreur
            throw new Exception("Pour le bon fonctionnement de l\'exercice, veuillez d\'abord afficher le tableau. \n Essayer : System.out.println(<Votre Tableau>.getTableauEntier()");
        }
    }

    public static List<Integer> convertiLaSortieEnTableau() {
        // On crée deux listes : une liste qui va contenir les entiers de la list et une autre avec ces mêmes entiers mais en chaine de caractères
        List<Integer> listeDesEntiers = new ArrayList<>();
        List<String> listeDesEntiersEnString = new ArrayList<>();
        // On crée également un StringBuilder qui va permettre de récupérer un entier de la liste que l'utilisateur affiche
        StringBuilder entierEnString = new StringBuilder();
        // On parcourt la première ligne affichée par l'utilisateur
        for (int i = 0; i < getLine().get(0).length(); i += 1) {
            // Si le caractère est contenu entre '0' et '9'
            if (getLine().get(0).charAt(i) >= 48 && getLine().get(0).charAt(i) <= 57) {
                // On ajoute le caractère au StringBuilder
                entierEnString.append(getLine().get(0).charAt(i));
            }
            // Si le caractère et soit : ',' ou ']'
            if (getLine().get(0).charAt(i) == 93 || getLine().get(0).charAt(i) == 44) {
                // On ajoute l'entier sous forme de chaine de caractères dans la liste appropriée
                listeDesEntiersEnString.add(entierEnString.toString());
                // On efface le contenu du StringBuilder
                entierEnString.setLength(0);
            }
        }
        // Boucle forEach dans laquelle on ajoute dans notre liste d'entier les éléments de la liste des entiers sous forme de caractères que l'on traduit en entier
        listeDesEntiersEnString.forEach(entier -> listeDesEntiers.add(Integer.parseInt(entier)));
        return listeDesEntiers;
    }

    public static void testAttributTableauEntiers() throws Exception {
        // Test pour voir si le la liste existe dans la classe
        try {
            Class.forName("javatests.Tableaux").getDeclaredField("tableauEntiers");
        } catch (Exception e) {
            throw new Exception("L\'attribut tableauEntier n\'existe pas. Vérifier si le nom correspond à celui de l\'énoncé");
        }
        // Test pour savoir si l'attribut tableauEntier est privé
        if (!(Class.forName("javatests.Tableaux").getDeclaredField("tableauEntiers").getModifiers() == Modifier.PRIVATE)) {
            throw new Exception("L\'attribut tableauEntier doit être privé");
        }
        if (!(Class.forName("javatests.Tableaux").getDeclaredField("tableauEntiers").getType().toString().equals("interface java.util.List"))) {
            throw new Exception("L\'attribut tableauEntiers doit être une liste d\'entier (List<Integer>)");
        }
    }

    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        Tableaux.main(null);
        System.setErr(originalErr);
        System.setOut(originalOut);

        if (!errContent.toString().isEmpty()) {
            throw new Exception(errContent.toString());
        }

        testAttributTableauEntiers();
        premierGetLineEstLeTableau();
        List<Integer> listeTest = convertiLaSortieEnTableau();
        Tableaux tableauTest = new Tableaux(listeTest);
        TestTriCroissant.testTriCroissantTableau(tableauTest);
        TestMoyenne.testTableauRenvoieMoyenne(tableauTest);
        TestEntierMin.testIndiceMinTableau(tableauTest);
        TestEntierMax.testIndiceMaxTableau(tableauTest);

        System.out.println("Exercice fini :)");
    }
}
