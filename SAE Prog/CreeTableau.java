import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreeTableau {
    private static List<Integer> tableauStatic = new ArrayList<>();
    private List<Integer> tableauPasStatic = new ArrayList<>();

    public CreeTableau() {
        // Si la tableau static n'a pas encore était rempli
        if (tableauStatic.isEmpty()) {
            Random generateurTaille = new Random(); // Taille de la liste
            Random generateurEntiers = new Random(); // Entier dans la liste
            for (int i = 0; i < generateurTaille.nextInt(15); i += 1) {
                // On ajoute un entier entre 1 et 99
                tableauStatic.add(generateurEntiers.nextInt(99));
            }
        }
        // On parcourt le tableau static
        for (int i = 0; i < tableauStatic.size(); i += 1) {
            // On ajoute dans la liste les valeurs de la liste static
            int valeur = tableauStatic.get(i);
            this.tableauPasStatic.add(valeur);
        }
    }

    public List<Integer> getTableauPasStatic() {
        return tableauPasStatic;
    }

    public static List<Integer> getTableauStatic() {
        return tableauStatic;
    }
}