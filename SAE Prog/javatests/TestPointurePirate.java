package javatests;

import java.lang.reflect.Modifier;

public class TestPointurePirate {
    public static void testsAttributPointurePirate() throws Exception {
        // Test pour savoir si l'attribut pointurePirate existe
        try {
            Class.forName("javatests.Pirate").getDeclaredField("pointurePirate");
        } catch (Exception e) {
            throw new Exception("L\'attribut pointurePirate n\'existe pas. Vérifier que son nom corresponde bien à celui de l\'énoncé");
        }
        // Test pour savoir si l'attribut est privé
        if (!(Class.forName("javatests.Pirate").getDeclaredField("pointurePirate").getModifiers() == Modifier.PRIVATE)) {
            throw new Exception("L\'attribut pointurePirate doit être privé");
        }
        // Test pour savoir si l'attribut est bien un entier
        if (!(Class.forName("javatests.Pirate").getDeclaredField("pointurePirate").getType().toString().equals("int"))) {
            throw new Exception("L\'attribut pointurePirate doit être un entier");
        }
    }

    public static void main(String[] args) throws Exception {
        testsAttributPointurePirate();

        System.out.println("L\'attribut pointurePirate est correct");
    }
}
