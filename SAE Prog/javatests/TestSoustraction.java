package javatests;

import java.lang.reflect.Modifier;
import java.util.Random;

public class TestSoustraction {
    public static void testFonctionnementMethodeSoustraction() throws Exception {
        try {
            Class.forName("javatests.Calculatrice").getMethod("soustraction", int.class, int.class);
        } catch (Exception e) {
            throw new Exception("La méthode soustraction doit être correctement écrite. \n Attendu : public double soustraction(int <nomVariable>, int <nomVariable>) { ... }");
        }

        if (!(Class.forName("javatests.Calculatrice").getMethod("soustraction", int.class, int.class).getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("La méthode soustraction doit être public");
        }

        if (!(Class.forName("javatests.Calculatrice").getMethod("soustraction", int.class, int.class).getReturnType().toString().equals("double"))) {
            throw new Exception("La méthode soustraction doit renvoyer un double");
        }

        int valeurUne = new Random().nextInt(50);
        int valeurDeux = new Random().nextInt(50);
        if (!((valeurUne - valeurDeux) == new Calculatrice().soustraction(valeurUne, valeurDeux))) {
            throw new Exception("Le fonctionnement de la méthode soustraction n\'est pas bon");
        }
    }

    public static void main(String[] args) throws Exception {
        TestCalculatrice.erreurPourMain();
        testFonctionnementMethodeSoustraction();

        System.out.println("La méthode soustraction fonctionne correctement");
    }
}
