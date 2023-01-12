package javatests;

import java.lang.reflect.Modifier;
import java.util.Random;

public class TestDivision {
    public static void testFonctionnementMethodeDivision() throws Exception {
        try {
            Class.forName("javatests.Calculatrice").getMethod("division", int.class, int.class);
        } catch (Exception e) {
            throw new Exception("La méthode division doit être correctement écrite. \n Attendu : public double division(int <nomVariable>, int <nomVariable>) { ... }");
        }

        if (!(Class.forName("javatests.Calculatrice").getMethod("division", int.class, int.class).getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("La méthode division doit être public");
        }

        if (!(Class.forName("javatests.Calculatrice").getMethod("division", int.class, int.class).getReturnType().toString().equals("double"))) {
            throw new Exception("La méthode division doit renvoyer un double");
        }

        int valeurUne = new Random().nextInt(50);
        int valeurDeux = new Random().nextInt(50);
        if (!((valeurUne / valeurDeux) == new Calculatrice().division(valeurUne, valeurDeux))) {
            throw new Exception("Le fonctionnement de la méthode division n\'est pas bon");
        }
    }

    public static void main(String[] args) throws Exception {
        TestCalculatrice.erreurPourMain();
        testFonctionnementMethodeDivision();

        System.out.println("Le test est bon");
    }
}