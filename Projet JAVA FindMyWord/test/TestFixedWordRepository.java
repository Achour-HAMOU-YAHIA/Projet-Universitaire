package test;

import findmyword.FixedWordRepository;

public class TestFixedWordRepository {

    public static void main(String[] args) {
        System.out.println("=== FixedWordRepository ===");

        FixedWordRepository repo = new FixedWordRepository("table");
        check("retourne le mot fixe", repo.getWord().getValue().equals("table"));
        check("met le mot en minuscules",
                new FixedWordRepository("MAGIE").getWord().getValue().equals("magie"));
    }

    static void check(String nom, boolean ok) {
        System.out.println((ok ? "[OK]   " : "[FAIL] ") + nom);
    }
}
