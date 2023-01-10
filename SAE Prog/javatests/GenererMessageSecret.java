package javatests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenererMessageSecret {
    private static String messageSecret;

    private static int indice;
    private String messageSecretPasStatic;


    private List<String> listeDeMessages = new ArrayList<>(List.of("Derriere toi Clemenceau",
            "Il faut aller en haut",
            "Tout est dans le tonneau",
            "Les carottes sont cuites",
            "Ils sont tous parés",
            "Bienvenue sur Javapprendre",
            "Ceci est un message secret",
            "Tango Charlie Alpha Bravo",
            "Je dois aller aux toilettes",
            "Jules Volpei est pas mal beau",
            "Il faut sauver le soldat Rayane",
            "Ma batterie est a plat",
            "Nous devons nous retrouver vers minuit",
            "Nous nous retrouverons au bar",
            "Je dois vraiment boire quelque chose",
            "Je dois aller en cours",
            "Jules est le parrain de Jules",
            "Jules est le filleul de Jules",
            "La musique est bonne ici",
            "Allumer le feu",
            "Faire danser les diables",
            "Faire danser les dieux"));

    public GenererMessageSecret() {
        if (messageSecret == null) {
            indice = new Random().nextInt(listeDeMessages.size());
            messageSecret = listeDeMessages.get(indice);
            messageSecretPasStatic = listeDeMessages.get(indice);
        } else {
            messageSecretPasStatic = listeDeMessages.get(indice);
        }
    }

    public static String getMessageSecret() {
        return messageSecret;
    }

    public String getMessageSecretPasStatic() {
        return messageSecretPasStatic;
    }

}
