package javatests;

import java.lang.reflect.Modifier;

public class TestNomPirate {
    public static void testsAttributNomPirate() throws Exception {
        // Tests pour savoir si l'attribut nomPirate existe
        try {
            Class.forName("javatests.Pirate").getDeclaredField("nomPirate");
        } catch (Exception e) {
            throw new Exception("L\'attribut nomPirate n\'existe pas. Vérifier que son nom correspond bien à celui de l\'énoncé");
        }
        // Test pour savoir si l'attribut est bien une chaine de caractères
        if (!(Class.forName("javatests.Pirate").getDeclaredField("nomPirate").getType().toString().equals("class java.lang.String"))) {
            throw new Exception("L\'attribut nomPirate doit être une chaine de caractères");
        }
        // Test pour savoir si l'attribut nomPirate est privé
        if (!(Class.forName("javatests.Pirate").getDeclaredField("nomPirate").getModifiers() == Modifier.PRIVATE)) {
            throw new Exception("L\'attribut nomPirate doit être privé.");
        }
    }

    public static void main(String[] args) throws Exception {
        testsAttributNomPirate();
        System.out.println("L\'attribut nomPirate est correct :D");
    }
}
