package javatests;

import java.lang.reflect.Method;

public class TestCalculatrice {
    public static boolean mainDansCalculatrice() {
        try {
            for (Method method : Class.forName("javatests.Calculatrice").getDeclaredMethods()) {
                if (method.getName().equals("main")) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static void erreurPourMain() throws Exception {
        if (!mainDansCalculatrice()) {
            throw new Exception("Pas de main dans le programme");
        }
    }

    public static void main(String[] args) throws Exception {
        erreurPourMain();

        TestAddition.testFonctionnementMethodeAddition();
        TestSoustraction.testFonctionnementMethodeSoustraction();
        TestMultiplication.testFonctionnementMethodeMultiplication();
        TestDivision.testFonctionnementMethodeDivision();

        System.out.println("Exercice fini :)");
    }
}