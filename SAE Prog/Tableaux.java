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
            Collections.sort(tableauEntiers);
    }

    public double moyenneTableau() {
        return 0;
    }


    public int entierMax() {
        return 0;
    }

    public String entierMin() {
        System.out.println("caca");    
		}

    public static void main(String[] args) {
        Tableaux tab1 = new Tableaux();
       
    }

}