# FindMyWord

Jeu de devinette de mots en Java - SAE 201 BUT1 Informatique

## Comment lancer le programme

1.Aller dans le dossier findMyWord depuis le terminal :

```
cd chemin_vers_notre_dossier/Abou-Elela_Hamou-Yahia
```

Compiler :

```
javac -cp wordset.jar findmyword\*.java
```

Lancer :

```
java -cp "wordset.jar;." findmyword.Main
```

## Fichiers necessaires

- wordset.jar doit etre a la racine du projet
- mots.json doit etre a la racine du projet

## Regles du jeu

- deviner un mot de 5 lettres en 6 essais
- apres chaque essai les lettres sont noter OK / PRESENT / ABSENT
- un mot invalide ne compte pas comme un essai
- score : 6 points au 1er essai, 5 au 2eme, ..., 1 au 6eme

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
├── wordset.jar
└── mots.json
```
