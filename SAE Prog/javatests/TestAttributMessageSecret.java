package javatests;

import java.lang.reflect.Modifier;

public class TestAttributMessageSecret {
    public static void testAttributMessageSecret() throws Exception {
        try {
            Class.forName("javatests.CodeCesar").getDeclaredField("messageSecret");
        } catch (Exception e) {
            throw new Exception("L\'attribut messageSecret ne doit pas être modifié");
        }
        if (!(Class.forName("javatests.CodeCesar").getDeclaredField("messageSecret").getModifiers() == Modifier.PRIVATE)) {
            throw new Exception("L\'attribut messageSecret doit être privé");
        }
        if (!(Class.forName("javatests.CodeCesar").getDeclaredField("messageSecret").getType() == String.class)) {
            throw new Exception("L\'attribut messageSecret doit être une chaine de caractères");
        }
    }

    public static void main(String[] args) throws Exception {
        testAttributMessageSecret();

        System.out.println("Le test est bon");
    }
}