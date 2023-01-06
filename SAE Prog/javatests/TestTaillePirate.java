package javatests;

import java.lang.reflect.Modifier;

public class TestTaillePirate {
    public static void testsAttributTaillePirate() throws Exception {
        // Test pour savoir si l'attribut taillePirate existe
        try {
            Class.forName("javatests.Pirate").getDeclaredField("taillePirate");
        } catch (Exception e) {
            throw new Exception("L\'attribut taillePirate n\'existe pas. Vérifier que son nom corresponde bien à celui de l\'énoncé");
        }
        // Test pour savoir si l'attribut taillePirate est privé
        if (!(Class.forName("javatests.Pirate").getDeclaredField("taillePirate").getModifiers() == Modifier.PRIVATE)) {
            throw new Exception("L\'attribut taillePirate doit être privé");
        }
        // Test pour savoir si l'attribut est bien un double
        if (!(Class.forName("javatests.Pirate").getDeclaredField("taillePirate").getType().toString().equals("double"))) {
            throw new Exception("L\'attribut taillePirate doit être un double");
        }
    }

    public static void main(String[] args) throws Exception {
        testsAttributTaillePirate();
        System.out.println("L\'attribut taillePirate est correct");
    }
}
