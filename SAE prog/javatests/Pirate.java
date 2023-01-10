package javatests;
public class Pirate {
    private String nomPirate;
		private double taillePirate;

    public String getNomPirate() {
        return nomPirate;
    }
		public double getTaillePirate(){
			return taillePirate;
		}
		public Pirate(String nomPirate, double taillePirate)
		{
			this.nomPirate = nomPirate;
			this.taillePirate = taillePirate;
		}
    public static void main(String[] args) {
        Pirate p = new Pirate("Clemenceau", 1.62);
				/* Afficher le nom du pirate */
				System.out.println(p.getNomPirate());
        /* Afficher la taille du pirate */
				System.out.println(p.getTaillePirate());
        /* Afficher la pointure du pirate */

        /* Afficher la lettre du pirate */

    }
}