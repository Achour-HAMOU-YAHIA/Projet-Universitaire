package findmyword;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("       FIND MY WORD - BUT1");
        System.out.println("=====================================");

        System.out.print("Entrez votre nom : ");
        String playerName = scanner.nextLine();
        System.out.println("Bonjour " + playerName + " !");

        System.out.print("Mode test ? (o/n) : ");
        boolean modeTest = scanner.nextLine().trim().equalsIgnoreCase("o");

        int scoreTotal = 0;
        boolean continuer = true;

        while (continuer) {                                                                   // Nous avons ici decider de commencer une nouvelle manche si le joueur gagnes et souhaite continuer

            // Création d'une nouvelle partie
            Game game = null;
            try {
                WordRepository repo;
                if (modeTest) {
                    repo = new FixedWordRepository(demanderMotSecret(scanner));
                } else {
                    repo = new JsonWordRepository("mots.json");
                }
                game = new Game(playerName, repo);
            } catch (Exception e) {
                System.out.println("Erreur : impossible de charger le fichier de mots.");
                return;
            }

            // Boucle de jeu
            while (!game.isOver()) {
                afficherGrille(game);
                System.out.print("Tentative " + (game.getNbAttempts() + 1) + " : ");
                String input = scanner.nextLine();
                Word attempt = new Word(input);

                if (input.length() != 5) {
                    System.out.println("Erreur : le mot doit contenir exactement 5 lettres.");
                } else if (!attempt.isValid()) {
                    System.out.println("Erreur : le mot contient des lettres répétées ou des caractères invalides.");
                } else {
                    game.addAttempt(attempt);
                    System.out.println("-------------");
                }
            }

            // Affichage final de la manche
            afficherGrille(game);

            if (game.isWon()) {
                scoreTotal += game.getScore();
                System.out.println("Bravo " + playerName + " !");
                System.out.println("Vous avez trouvé le mot en " + game.getNbAttempts() + " essais.");
                System.out.println("Score cette manche : " + game.getScore() + " points");
                System.out.println("Score total : " + scoreTotal + " points");
                System.out.println("Voulez-vous continuer ? (o/n) : ");
                String reponse = scanner.nextLine();
                if (!reponse.equalsIgnoreCase("o")) {
                    System.out.println("=====================================");
                    System.out.println("Score final : " + scoreTotal + " points");
                    System.out.println("Merci d'avoir joué " + playerName + " !");
                    continuer = false;
                }
            } else {
                System.out.println("Vous avez utilisé tous vos essais.");
                System.out.println("Partie perdue.");
                System.out.println("Mot secret : " + game.getSecretWord());
                System.out.println("=====================================");
                System.out.println("Score final : " + scoreTotal + " points");
                System.out.println("Merci d'avoir joué " + playerName + " !");
                continuer = false;
            }
        }

        scanner.close();
    }

    private static String demanderMotSecret(Scanner scanner) {
        String mot = null;
        boolean motValide = false;
        while (!motValide) {
            System.out.print("Entrez le mot secret : ");
            mot = scanner.nextLine().trim();

            if (mot.length() != 5) {
                System.out.println("Erreur : le mot doit contenir exactement 5 lettres.");
            } else if (!new Word(mot).isValid()) {
                System.out.println("Erreur : le mot contient des lettres répétées ou des caractères invalides.");
            } else {
                motValide = true;
            }
        }
        return mot;
    }

    private static void afficherGrille(Game game) {
        ArrayList<Word> attempts = game.getAttempts();
        ArrayList<ArrayList<String>> results = game.getResults();

        for (int i = 0; i < attempts.size(); i++) {
            System.out.println(formaterMot(attempts.get(i)) + " → " + formaterResultat(results.get(i)));
        }

        for (int i = attempts.size(); i < 6; i++) {
            System.out.println("[ ][ ][ ][ ][ ] → ****** ****** ****** ****** ******");
        }
    }

    private static String formaterMot(Word word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append("[ ").append(word.getLetterAt(i).toUpperCase()).append(" ]");
        }
        return sb.toString();
    }

    private static String formaterResultat(ArrayList<String> result) {
        StringBuilder sb = new StringBuilder();
        for (String r : result) {
            sb.append(r).append(" ");
        }
        return sb.toString().trim();
    }
}