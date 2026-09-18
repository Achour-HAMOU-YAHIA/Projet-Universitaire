package test;

import findmyword.JsonWordRepository;

public class TestJsonWordRepository {

    public static void main(String[] args) {
        System.out.println("=== JsonWordRepository ===");

        // A lancer DEPUIS la racine du projet (pour trouver mots.json)
        try {
            JsonWordRepository repo = new JsonWordRepository("mots.json");
            check("getWord() ne retourne pas null", repo.getWord() != null);
            check("le mot tire n'est pas vide", repo.getWord().getValue().length() > 0);
        } catch (Exception e) {
            System.out.println("[FAIL] mots.json introuvable (lance le test depuis la racine)");
        }
    }

    static void check(String nom, boolean ok) {
        System.out.println((ok ? "[OK]   " : "[FAIL] ") + nom);
    }
}
