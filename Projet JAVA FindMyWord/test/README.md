# Tests - FindMyWord

Tests des classes du jeu FindMyWord
Chaque classe possede son propre fichier de test dans le dossier `test`.

## Comment lancer les tests

1. Aller dans le dossier du projet depuis le terminal :

```
cd chemin_vers_notre_dossier/Abou-Elela_Hamou-Yahia
```

2. Compiler les classes du jeu et les tests en une seule commande :

```
javac -cp "wordset.jar;." findmyword\*.java test\*.java
```

3.  Lancer les test un par un :


```
java -cp "wordset.jar;." test.TestWord
java -cp "wordset.jar;." test.TestGame
java -cp "wordset.jar;." test.TestWordRepository
java -cp "wordset.jar;." test.TestFixedWordRepository
java -cp "wordset.jar;." test.TestJsonWordRepository
```

Chaque verification affiche une ligne qui commence par `[OK]` si elle passe,
ou `[FAIL]` sinon.

## Ce que verifie chaque test

- **wordTest** : validite d'un mot (longueur, lettres repetees), mise en minuscules, egalite
- **wordRepoTest** : la classe abstraite WordRepository testee via une de ses filles (polymorphisme)
- **wordRepoFixedTest** : FixedWordRepository retourne bien le mot impose
- **wordRepoJsonTest** : JsonWordRepository tire un mot non vide depuis mots.json
- **gameTest** : analyse OK / PRESENT / ABSENT, detection de la victoire et calcul du score

## Structure

```
Abou-Elela_Hamou-Yahia/
├── findmyword/
│   ├── Word.java
│   ├── WordRepository.java
│   ├── JsonWordRepository.java
│   ├── FixedWordRepository.java
│   ├── Game.java
│   └── Main.java
│
├── test/
│   ├── TestWord.java
│   ├── TestWordRepository.java
│   ├── TestFixedWordRepository.java
│   ├── TestJsonWordRepository.java
│   ├── TestGame.java
│
│
├── wordset.jar
├── mots.json
└── README.md
```
