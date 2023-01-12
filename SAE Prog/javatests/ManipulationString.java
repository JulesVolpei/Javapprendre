package javatests;

public class ManipulationString {
    private String mot = new GenererMot().getMotPasStatic();


    // Clemenceau le pirate doit montrer un mot secret pour un autre bateau pour qu'il se fasse reconnaitre
    /* Pour ça il doit faire une série d'épreuves :

        - Mettre la chaine à l'envers

        - Afficher lettre par lettre

        - Mettre le mot en minuscule

        - Mettre une lettre sur deux en minuscule
     */

    public void afficherMotALEnvers(String mot) {
        StringBuilder test = new StringBuilder();
        test.append(mot);
        String motReversed = test.reverse().toString();
        System.out.println(motReversed);
    }

    public void afficherLettreParLettre(String mot) {
        for (char lettre : mot.toCharArray()) {
            System.out.println(lettre);
        }
    }

    public void afficherLeMotEnMinuscule(String mot) {
        System.out.println(mot.toLowerCase());
    }

    public void afficherLeMotAvecUneLettreSurDeuxEnMinuscule(String mot) {
        StringBuilder motFinal = new StringBuilder();
        boolean minuscule = true;
        for (char lettre : mot.toCharArray()) {
            if (minuscule) {
                motFinal.append(Character.toLowerCase(lettre));
                minuscule = false;
            } else {
                motFinal.append(lettre);
                minuscule = true;
            }
        }
        System.out.println(motFinal.toString());
    }




    public static void main(String[] args) {
        ManipulationString exercice = new ManipulationString();
        /* Ne pas supprimer */ System.out.println(exercice.mot); /* Ne pas supprimer */
        exercice.afficherMotALEnvers(exercice.mot);
        exercice.afficherLettreParLettre(exercice.mot);
        exercice.afficherLeMotEnMinuscule(exercice.mot);
        exercice.afficherLeMotAvecUneLettreSurDeuxEnMinuscule(exercice.mot);
    }

}