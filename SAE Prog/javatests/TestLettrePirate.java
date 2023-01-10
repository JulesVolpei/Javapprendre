package javatests;

import java.lang.reflect.Modifier;

public class TestLettrePirate {
    public static void testsAttributLettrePirate() throws Exception {
        // Test pour savoir si l'attribut lettrePirate existe
        try {
            Class.forName("javatests.Pirate").getDeclaredField("lettrePirate");
        } catch (Exception e) {
            throw new Exception("L\'attribut lettrePirate n\'existe pas. Vérifier que son nom corresponde bien à celui de l\'énoncé");
        }
        // Test pour savoir si l'attribut est privé
        if (!(Class.forName("javatests.Pirate").getDeclaredField("lettrePirate").getModifiers() == Modifier.PRIVATE)) {
            throw new Exception("L\'attribut lettrePirate doit être privé");
        }
        // Test pour savoir si l'attribut est bien un caractère
        if (!(Class.forName("javatests.Pirate").getDeclaredField("lettrePirate").getType().toString().equals("char"))) {
            throw new Exception("L\'attribut lettrePirate doit être un caractère");
        }
    }

    public static void main(String[] args) throws Exception {
        testsAttributLettrePirate();
        System.out.println("L\'attribut lettrePirate est correct");
    }
}