package javatests;

import java.lang.reflect.Modifier;

public class TestAttributMot {
    public static void testAttributMot() throws Exception {
        try {
            Class.forName("javatests.ManipulationString").getDeclaredField("mot");
        } catch (Exception e) {
            throw new Exception("Il faut ne faut pas modifier l\'attribut");
        }
        if (!(Class.forName("javatests.ManipulationString").getDeclaredField("mot").getModifiers() == Modifier.PRIVATE)) {
            throw new Exception("Il faut que l\'attribut mot soit private");
        }
        if (!(Class.forName("javatests.ManipulationString").getDeclaredField("mot").getType() == String.class)) {
            throw new Exception("Il faut que l\'attribut soit un String");
        }
    }

    public static void main(String[] args) throws Exception {
        testAttributMot();

        System.out.println("L\'attribut est correct");
    }
}
