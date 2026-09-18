package test;

import java.util.ArrayList;
import findmyword.Game;
import findmyword.Word;
import findmyword.FixedWordRepository;

public class TestGame {

    public static void main(String[] args) {
        System.out.println("=== Game ===");

        // Mot secret impose = "chien" (grace a FixedWordRepository)
        Game game = new Game("Zyad", new FixedWordRepository("chien"));

        // Tentative "carte" : c=OK, a/r/t=ABSENT, e=PRESENT
        ArrayList<String> res = game.addAttempt(new Word("carte"));
        check("lettre bien placee = OK", res.get(0).equals("OK"));
        check("lettre absente = ABSENT", res.get(1).equals("ABSENT"));
        check("lettre mal placee = PRESENT", res.get(4).equals("PRESENT"));

        // 2e tentative = le bon mot = victoire
        game.addAttempt(new Word("chien"));
        check("victoire detectee", game.isWon());
        check("partie terminee", game.isOver());
        check("score = 5 (trouve au 2e essai)", game.getScore() == 5);
    }

    static void check(String nom, boolean ok) {
        System.out.println((ok ? "[OK]   " : "[FAIL] ") + nom);
    }
}
