package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Yahtzee {
//    public Cup myCup = new Cup();
    public Player player;
    public List<Player> players = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final int ROUND = 3;
    private final int MAX_PLAYERS = 6;
    private final int MIN_PLAYERS = 1;

    public Yahtzee() {
        System.out.println("How many players?");
        int numberOfPlayers;
        do {
            numberOfPlayers = scanner.nextInt();
            scanner.nextLine();
        } while (numberOfPlayers < MIN_PLAYERS || numberOfPlayers > MAX_PLAYERS);

        while (players.size() < numberOfPlayers) {
            System.out.println("What is your name?");
            players.add(new Player((scanner.nextLine()).trim()));
        }

//        System.out.println("What is your name?");
//        player = new Player((scanner.nextLine()).trim());
    }

    private void round() {
        for (Player activePlayer : players) {
            turn(activePlayer);
        }
    }

    private void displayResults() {
        Player currentWinner = players.get(0);
//        for(int i = 1; i < players.size(); i++) {
//            if (currentWinner.score < players.get(i).score) {
//                currentWinner = players.get(i);
//            }
//        }
        for (Player player : players) {
            if (currentWinner.score < player.score) {
                currentWinner = player;
            }
            System.out.printf("%s scored: %d\n", player.name, player.score);
        }
        System.out.printf(
                "%s is the Winner with %d points!!!",
                currentWinner.name,
                currentWinner.score
        );
    }

    public void play() {
        for (int count = 0; count < ROUND; count++) {
            round();
        }
        displayResults();

    }

    public void getSelections(Player activePlayer) {
        System.out.println("select dice you want to re-roll (1-5)");
        String input = scanner.nextLine(); // "1 2 5"
        if (input.equals("")) return;
        activePlayer.cup.roll(activePlayer.cup.parseSelections(input));
    }

    public void turn(Player activePlayer) {
        System.out.println(activePlayer.name + "'s turn, press enter to begin");
        scanner.nextLine();
        activePlayer.cup.roll();

        for (int i = 0; i < 2; i++) {
            System.out.println(activePlayer.cup.displayCup());
            getSelections(activePlayer);
        }

        System.out.println(activePlayer.cup.displayCup());
        System.out.printf("%s scored ", activePlayer.name);
        System.out.println(activePlayer.updateScore());
    }

}
