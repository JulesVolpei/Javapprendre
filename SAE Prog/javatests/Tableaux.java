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
        double sum = 0;
        for(Integer element : this.tableauEntiers)
        {
            sum += element;
        }

        double moy = sum / this.tableauEntiers.size();
        return moy;
    }


    public int entierMax() {
        return Collections.max(this.tableauEntiers);
    }

    public int entierMin() {
        return Collections.min(this.tableauEntiers);
    }

    public static void main(String[] args) {
        Tableaux tab1 = new Tableaux();
        /* Ne pas supprimer */ System.out.println(tab1.getTableauEntiers()); /* Ne pas supprimer */
        tab1.triTableauCroissant();
        System.out.println(tab1.getTableauEntiers());
    }

}