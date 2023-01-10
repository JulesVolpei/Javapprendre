package javatests;

import java.lang.reflect.Modifier;
import java.util.Random;

public class TestMultiplication {
    public static void testFonctionnementMethodeMultiplication() throws Exception {
        try {
            Class.forName("javatests.Calculatrice").getMethod("multiplication", int.class, int.class);
        } catch (Exception e) {
            throw new Exception("La méthode multiplication doit être correctement écrite. \n Attendu : public double multiplication(int <nomVariable>, int <nomVariable>) { ... }");
        }

        if (!(Class.forName("javatests.Calculatrice").getMethod("multiplication", int.class, int.class).getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("La méthode multiplication doit être public");
        }

        if (!(Class.forName("javatests.Calculatrice").getMethod("multiplication", int.class, int.class).getReturnType().toString().equals("double"))) {
            throw new Exception("La méthode multiplication doit renvoyer un double");
        }

        int valeurUne = new Random().nextInt(50);
        int valeurDeux = new Random().nextInt(50);
        if (!((valeurUne * valeurDeux) == new Calculatrice().multiplication(valeurUne, valeurDeux))) {
            throw new Exception("Le fonctionnement de la méthode multiplication n\'est pas bon");
        }
    }

    public static void main(String[] args) throws Exception {
        TestCalculatrice.erreurPourMain();
        testFonctionnementMethodeMultiplication();

        System.out.println("La méthode mutliplication fonctionne correctement");
    }
}
