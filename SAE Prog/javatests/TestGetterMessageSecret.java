package javatests;

import java.lang.reflect.Modifier;

public class TestGetterMessageSecret {
    public static void testGetterMessageSecret() throws Exception {
        try {
            Class.forName("javatests.CodeCesar").getDeclaredMethod("getMessageSecret");
        } catch (Exception e) {
            throw new Exception("L\'attribut messageSecret ne doit pas être modifié");
        }
        if (!(Class.forName("javatests.CodeCesar").getDeclaredMethod("getMessageSecret").getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("L\'attribut messageSecret doit être privé");
        }
        if (!(Class.forName("javatests.CodeCesar").getDeclaredMethod("getMessageSecret").getReturnType() == String.class)) {
            throw new Exception("L\'attribut messageSecret doit être une chaine de caractères");
        }
        CodeCesar codeCesar = new CodeCesar();
        if (!codeCesar.getMessageSecret().equals(GenererMessageSecret.getMessageSecret())) {
            throw new Exception("Le contenu du message secret ne dois pas être modifié !");
        }
    }

    public static void main(String[] args) throws Exception {
        testGetterMessageSecret();

        System.out.println("Le test est bon");
    }
}
