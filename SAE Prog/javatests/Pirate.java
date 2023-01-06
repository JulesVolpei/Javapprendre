package javatests;

import javax.print.DocFlavor;

public class Pirate {
    private String nomPirate;
    private double taillePirate;
    private int pointurePirate;
    private char lettrePirate;

    public Pirate(String nomPirate, double taillePirate, int pointurePirate, char lettrePirate) {
        this.nomPirate = nomPirate;
        this.taillePirate = taillePirate;
        this.pointurePirate = pointurePirate;
        this.lettrePirate = lettrePirate;
    }

    public String getNomPirate() {
        return nomPirate;
    }

    public static void main(String[] args) {
        Pirate pirate = new Pirate("Clemenceau", 1.68, 48, 'J');
        System.out.println(pirate.getNomPirate());
    }
}
