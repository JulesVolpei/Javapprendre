package javatests;
public class Pirate {
    private String nomPirate;
    private double taillePirate;
    private int pointurePirate;
    private char lettrePirate;

    Pirate(String nomPirate, double taillePirate, int pointurePirate, char lettrePirate)
    {
        this.nomPirate = nomPirate;
        this.taillePirate = taillePirate;
        this.pointurePirate = pointurePirate;
        this.lettrePirate = lettrePirate;
    }

    public String getNomPirate() {
        return nomPirate;
    }

    public double getTaillePirate() {
        return taillePirate;
    }

    public int getPointurePirate()
    {
        return pointurePirate;
    }

    public char getLettrePirate()
    {
        return lettrePirate;
    }

    public static void main(String[] args) {
        Pirate p = new Pirate("Clemenceau", 1.62, 48, 'J');
        /* Afficher le nom du pirate */
        System.out.println(p.getNomPirate());
        // Afficher la taille du pirate /
        System.out.println(p.getTaillePirate());
        // Afficher la pointure du pirate /
        System.out.println(p.getPointurePirate());
        // Afficher la lettre du pirate */
        System.out.println(p.getLettrePirate());
    }
}