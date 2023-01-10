package javatests;

import java.util.*;

public class Tableaux {

    private List<Integer> tableauEntiers;

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
        Collections.sort(tableauEntiers);
    }

    public double moyenneTableau() {
        double moy = 0;
        for (int i = 0; i < tableauEntiers.size(); ++i){
            moy += tableauEntiers.get(i);
        }
        moy /= tableauEntiers.size();
        return moy;
    }


    public int entierMax() {
        return Collections.max(tableauEntiers);
    }

    public int entierMin() {
        this.triTableauCroissant();
        return tableauEntiers.get(0);
    }

    public static void main(String[] args) {
        Tableaux tab1 = new Tableaux();
        /* Ne pas supprimer */ System.out.println(tab1.getTableauEntiers()); /* Ne pas supprimer */
    }

}