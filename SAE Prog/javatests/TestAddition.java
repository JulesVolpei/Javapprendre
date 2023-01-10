package javatests;

import java.lang.reflect.Modifier;
import java.util.Random;

public class TestAddition {
    public static void testFonctionnementMethodeAddition() throws Exception {
        try {
            Class.forName("javatests.Calculatrice").getMethod("addition", int.class, int.class);
        } catch (Exception e) {
            throw new Exception("La méthode addition doit être correctement écrite. \n Attendu : public double addition(int <nomVariable>, int <nomVariable>) { ... }");
        }

        if (!(Class.forName("javatests.Calculatrice").getMethod("addition", int.class, int.class).getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("La méthode addition doit être public");
        }

        if (!(Class.forName("javatests.Calculatrice").getMethod("addition", int.class, int.class).getReturnType().toString().equals("double"))) {
            throw new Exception("La méthode addition doit renvoyer un double");
        }

        int valeurUne = new Random().nextInt(50);
        int valeurDeux = new Random().nextInt(50);
        if (!((valeurUne + valeurDeux) == new Calculatrice().addition(valeurUne, valeurDeux))) {
            throw new Exception("Le fonctionnement de la méthode addition n\'est pas bon");
        }
    }

    public static void main(String[] args) throws Exception {
        TestCalculatrice.erreurPourMain();
        testFonctionnementMethodeAddition();

        System.out.println("La méthode addition fonctionne correctement");
    }
}
