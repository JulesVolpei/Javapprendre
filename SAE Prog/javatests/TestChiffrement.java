package javatests;

import java.lang.reflect.Modifier;

public class TestChiffrement {
    public static void testFonctionnementChiffrement() throws Exception {
        try {
            Class.forName("javatests.CodeCesar").getDeclaredMethod("chiffrement", String.class);
        } catch (Exception e) {
            throw new Exception("La méthode chiffrement(String messageSecret) ne doit pas être modifié");
        }
        if (!(Class.forName("javatests.CodeCesar").getDeclaredMethod("chiffrement", String.class).getModifiers() == Modifier.PUBLIC)) {
            throw new Exception("La méthode chiffrement doit être positive");
        }
        if (!(Class.forName("javatests.CodeCesar").getDeclaredMethod("chiffrement", String.class).getReturnType() == String.class)) {
            throw new Exception("La méthode chiffrement doit retourner une chaine de caractères");
        }
        String messageEncode = new CodeCesar().chiffrement(GenererMessageSecret.getMessageSecret());
        StringBuilder messageJuste = new StringBuilder();
        for (int i = 0; i < GenererMessageSecret.getMessageSecret().length(); i += 1) {
            if (GenererMessageSecret.getMessageSecret().charAt(i) != ' ') {
                char lettre = (char) (GenererMessageSecret.getMessageSecret().charAt(i) + 2);
                messageJuste.append(lettre);
            } else {
                messageJuste.append(GenererMessageSecret.getMessageSecret().charAt(i));
            }
        }
        String test = messageJuste.toString();
        if (!test.equals(messageEncode)) {
            throw new Exception("Le chiffrement ne fonctionne pas. \n Attendu : " + test + "\n Reçu : " + messageEncode);
        }
    }

    public static void main(String[] args) throws Exception {
        testFonctionnementChiffrement();

        System.out.println("Le test est bon");
    }
}