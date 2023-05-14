package bowling.alley;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberOfRounds = 5;
        int strikeBonus = 10;
        int spareBonus = 5;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Enter number of players: ");
            int numberOfPlayers = Integer.parseInt(scanner.nextLine());
            List<Player> players = new ArrayList<>();
            for(int i = 1; i <= numberOfPlayers; i++) {
                players.add(new Player("Player"+ i));
            }
            for(int i = 0; i < numberOfRounds - 1; i++) {
                int roundNumber = i+1;
                System.out.println("Round - "+ roundNumber);
                for(int j = 0; j < numberOfPlayers; j++) {
                    Player player = players.get(j);
                    int score1 = playTurn(player, roundNumber, scanner, 1);
                    if(score1 == 10) {
                        strike(player, roundNumber);
                        continue;
                    }
                    int score2 = playTurn(player, roundNumber, scanner, 2);
                    if(score1 + score2 == 10) {
                        spare(player, roundNumber);
                    }
                }
                printScores(players, roundNumber);
            }
            //last round
            System.out.println("Round - "+ (numberOfRounds - 1));
            for(int j = 0; j < numberOfPlayers; j++) {
                Player player = players.get(j);
                int roundNumber = numberOfRounds - 1;
                int score1 = playTurn(player, roundNumber, scanner, 1);
                if(score1 == 10) {
                    strike(player, roundNumber);
                    int score2 = playTurn(player, roundNumber, scanner, 2);
                    if(score2 == 10) {
                        strike(player, roundNumber);
                    }
                    int score3 = playTurn(player, roundNumber, scanner, 2);
                    if(score3 == 10) {
                        strike(player, roundNumber);
                    }
                }
                int score2 = playTurn(player, roundNumber, scanner, 2);
                if(score2 == 10) {
                    strike(player, roundNumber);
                } else if(score1+score2 == 10) {
                    spare(player, roundNumber);
                }
                int score3 = playTurn(player, roundNumber, scanner, 2);
                if(score3 == 10) {
                    strike(player, roundNumber);
                } else if(score2 + score3 == 10) {
                    spare(player, roundNumber);
                }
                player.addScore(5*player.getSpareBonusTurns() + 5*player.getStrikeBonusTurns()*5);
            }
            printScoreBoard(players);
        }
    }

    private static int playTurn(Player player, int roundNumber, Scanner scanner, int chanceNumber) {
        System.out.print("Enter Score for "+ player.getName() +" Chance"+ chanceNumber +": ");
        int scoreForChance = Integer.parseInt(scanner.nextLine());
        player.getScores().computeIfAbsent(roundNumber, k -> new ArrayList<>()).add(scoreForChance);
        player.addScore(scoreForChance);
        if(player.getSpareBonusTurns() > 0) {
            player.addScore(scoreForChance);
            player.decreaseSpareBonusTurns(1);
        }
        if(player.getStrikeBonusTurns() > 0) {
            player.addScore(scoreForChance);
            player.decreaseStrikeBonusTurns(1);
        }
        return scoreForChance;
    }

    private static void strike(Player player, int roundNumber) {
        Strike strike = new Strike(player, roundNumber);
        player.getStrikes().add(strike);
        player.addStrikeBonusTurns(2);
    }

    private static void spare(Player player, int roundNumber) {
        Spare spare = new Spare(player, roundNumber);
        player.getSpares().add(spare);
        player.addSpareBonusTurns(1);
    }

    private static void printScores(List<Player> players, int roundNumber) {
        for(Player player: players) {
            List<Integer> scores = player.getScores().get(roundNumber);
            System.out.print(player.getName()+": ");
            for(int i = 1; i <= scores.size(); i++) {
                System.out.print(scores.get(i-1));
                if(i != scores.size()) {
                    System.out.print(",");
                }
            }
            System.out.println(" Score: " + player.getScore());
        }
    }

    private static void printScoreBoard(List<Player> players) {
        for(Player player: players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
}