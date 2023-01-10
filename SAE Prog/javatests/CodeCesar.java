package javatests;

public class CodeCesar {
    /*
        Clémenceau doit communiquer avec son compagnon de manière sécurisée sans que les gardes les attrapent.
        Pour ce faire, il va modifier son message à l'aide du chiffrement de César.
     */
    private String messageSecret = new GenererMessageSecret().getMessageSecretPasStatic(); /* Truc qui génère une phrase aléatoirement */



    public String getMessageSecret() {
        return messageSecret;
    }

    public String chiffrement(String message) {
        StringBuilder test = new StringBuilder();

        for (int i = 0; i < message.length(); i += 1) {
            if (message.charAt(i) != ' ') {
                char lettre = (char) (message.charAt(i) + 2);
                test.append(lettre);
            } else {
                test.append(message.charAt(i));
            }
        }
        return test.toString();
    }

    public static void main(String[] args) {
        CodeCesar codeCesar = new CodeCesar();
        String messageCommunique = codeCesar.chiffrement(codeCesar.messageSecret);
        
    }
}
