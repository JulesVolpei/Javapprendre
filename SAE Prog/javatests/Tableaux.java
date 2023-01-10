package javatests;
import java.util.*;

public class Tableaux {

    private List<Integer> tableauEntiers = new ArrayList<>();

    public Tableaux() {
        this.tableauEntiers = new CreeTableau().getTableauPasStatic();
    }

    public Tableaux(List<Integer> tableauEntiers) {
        this.tableauEntiers = tableauEntiers;
    }

    public List<Integer> getTableauEntiers() {
        return tableauEntiers;
    }

    public void triTableauCroissant() {
            this.tableauEntiers.sort(null);
    }

    public double moyenneTableau() {
        return 0;
    }


    public int entierMax() {
        return 0;
    }

    public int entierMin() {
        return 0;
    }

    public static void main(String[] args) {
        Tableaux tab1 = new Tableaux();
        /* Ne pas supprimer */ System.out.println(tab1.getTableauEntiers()); /* Ne pas supprimer */
    }

}