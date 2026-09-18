package test;

import findmyword.Word;

public class TestWord {

    public static void main(String[] args) {
        System.out.println("=== Word ===");
        check("'chien' est valide", new Word("chien").isValid());

        check("'chat' (4 lettres) invalide", !new Word("chat").isValid());

        check("'appel' (lettre repetee) invalide", !new Word("appel").isValid());

        check("'CHIEN' mis en minuscules", new Word("CHIEN").getValue().equals("chien"));

        check("equals insensible a la casse", new Word("chien").equals(new Word("CHIEN")));
        
        check("'chien' different de 'table'", !new Word("chien").equals(new Word("table")));
    }

    static void check(String nom, boolean ok) {
        System.out.println((ok ? "[OK]   " : "[FAIL] ") + nom);
    }
}
