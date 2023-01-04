import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestTableaux {
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
            if (lettre != '\n') {
                test.append(lettre);
            } else { // Sinon on aoute la ligne à la liste et on efface le contenu du StringBuilder
                listOutputs.add(test.toString());
                test.setLength(0);
            }
        }
        // On retourne la liste avec l'ensemble des lignes
        return listOutputs;
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

    public static void testTriCroissantTableau(Tableaux tab) throws Exception{
        try { // Si la classe ne comporte pas une méthode déclarée qui s'appelle : triTableauCroissant
            Class.forName("Tableaux").getDeclaredMethod("triTableauCroissant");
        } catch (Exception e) {
            // Message d'erreur
            throw new Exception("La méthode triTableauCroissant est mal orthographiée");
        }
        // On teste le tri fait par l'utilisateur
        tab.triTableauCroissant();
        // On fait le tri déjà présent dans Collections
        Collections.sort(CreeTableau.getTableauStatic());
        for (int i = 0; i < CreeTableau.getTableauStatic().size(); i += 1) {
            // On regarde chaque élément des deux listes pour savoir si les éléments sont les mêmes
            if (CreeTableau.getTableauStatic().get(i) != tab.getTableauEntiers().get(i)) {
                // Sinon message d'erreur
                throw new Exception("Le trie n\'est pas bon");
            }
        }
    }

    public static void testTableauRenvoieMoyenne(Tableaux tab) throws Exception {
        try { // Si la classe Tableau ne comporte pas de méthode déclarée qui s'apelle : moyenneTableau
            Class.forName("Tableaux").getDeclaredMethod("moyenneTableau");
        } catch (Exception e) {
            // Message d'erreur
            throw new Exception("La méthode moyenneTableau est mal orthographiée");
        }
        // On regarde si la méthode moyenneTableau est publique
        if (!(Class.forName("Tableaux").getDeclaredMethod("moyenneTableau").getModifiers() == Modifier.PUBLIC)) {
            // Message d'erreur
            throw new Exception("La méthode n\'est pas publique");
        }
        // On regarde si la méthode moyenneTableau renvoie bien un double
        if (!(Class.forName("Tableaux").getDeclaredMethod("moyenneTableau").getReturnType().toString().equals("double"))) {
            // Message d'erreur
            throw new Exception("La méthode moyenneTableau doit renvoyer un double");
        }
        // On met le résultat de la méthode moyenneTableau fait par l'utilisateur dans une variable et on fait la moyenne des éléments de la liste static
        double resutalt = tab.moyenneTableau();
        double moyenneTableauStatic = CreeTableau.getTableauStatic().stream().mapToDouble(entier -> entier).sum() / CreeTableau.getTableauStatic().size();
        // Si les deux moyennes sont différentes
        if (!(resutalt == moyenneTableauStatic)) {
            // Message d'erreur
            throw new Exception("Le calcul de moyenne n\'est pas bon.");
        }
    }

    public static void testIndiceMinTableau(Tableaux tab) throws Exception {
        try { // Si la classe Tableaux ne comporte pas de méthode entierMin()
            Class.forName("Tableaux").getDeclaredMethod("entierMin");
        } catch (Exception e) {
            // Message d'erreur
            throw new Exception("La méthode entierMin est mal orthographiée");
        }
        // On regarde si la méthode entierMin est publique
        if (!(Class.forName("Tableaux").getDeclaredMethod("entierMin").getModifiers() == Modifier.PUBLIC)) {
            // Message d'erreur
            throw new Exception("La méthode entierMin n\'est pas publique");
        }
        // On regarde si la méthode entierMin retourne bien un entier
        if (!(Class.forName("Tableaux").getDeclaredMethod("entierMin").getReturnType().toString().equals("int"))) {
            // Message d'erreur
            throw new Exception("La méthode entierMin doit renvoyer un entier");
        }
        // On teste la méthode entierMin fait par l'utilisateur
        int entierMinStatic = Collections.min(CreeTableau.getTableauStatic());
        int entierMinTest = tab.entierMin();
        // Si les deux résultats sont différents
        if (!(entierMinTest == entierMinStatic)) {
            // Message d'erreur
            throw new Exception("La méthode entierMin ne fonctionne pas. \n Expected : " + entierMinStatic);
        }
    }

    public static void testIndiceMaxTableau(Tableaux tab) throws Exception {
        try { // Si la classe Tableaux ne comporte pas de méthode entierMax
            Class.forName("Tableaux").getDeclaredMethod("entierMax");
        } catch (Exception e) {
            // Message d'erreur
            throw new Exception("La méthode entierMax est mal orthographiée");
        }
        // On regarde si la méthode entierMax est publique
        if (!(Class.forName("Tableaux").getDeclaredMethod("entierMax").getModifiers() == Modifier.PUBLIC)) {
            // Message d'erreur
            throw new Exception("La méthode entierMax n\'est pas publique");
        }
        // On regarde si la méthode entierMax renvoie bien un entier
        if (!(Class.forName("Tableaux").getDeclaredMethod("entierMax").getReturnType().toString().equals("int"))) {
            throw new Exception("La méthode entierMax doit renvoyer un entier");
        }
        // On teste la méthode entierMax fait par l'utilisateur
        int entierMaxStatic = Collections.max(CreeTableau.getTableauStatic());
        int entierMaxTest = tab.entierMax();
        // Si les deux résultats sont différents
        if (!(entierMaxTest == entierMaxStatic)) {
            // Message d'erreur
            throw new Exception("La méthode entierMin ne fonctionne pas. \n Expected : " + entierMaxStatic);
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
        premierGetLineEstLeTableau();
        List<Integer> listeTest = convertiLaSortieEnTableau();
        Tableaux tableauTest = new Tableaux(listeTest);
        testTriCroissantTableau(tableauTest);
        testTableauRenvoieMoyenne(tableauTest);
        testIndiceMinTableau(tableauTest);
    }
}