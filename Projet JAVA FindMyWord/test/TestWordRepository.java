package test;

import findmyword.WordRepository;
import findmyword.FixedWordRepository;

public class TestWordRepository {

    public static void main(String[] args) {
        System.out.println("=== WordRepository ===");

        // Classe abstraite : on la teste via une sous-classe (polymorphisme)
        WordRepository repo = new FixedWordRepository("table");
        check("getWord() ne retourne pas null", repo.getWord() != null);
        check("getWord() retourne le bon mot", repo.getWord().getValue().equals("table"));
    }

    static void check(String nom, boolean ok) {
        System.out.println((ok ? "[OK]   " : "[FAIL] ") + nom);
    }
}
