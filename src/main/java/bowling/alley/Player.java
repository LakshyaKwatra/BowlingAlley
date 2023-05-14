package bowling.alley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {
    private String name;
    private int score;
    private int strikeBonusTurns;
    private int spareBonusTurns;
    private List<Strike> strikes;
    private List<Spare> spares;
    private HashMap<Integer,List<Integer>> scores;

    public int getStrikeBonusTurns() {
        return strikeBonusTurns;
    }

    public void setStrikeBonusTurns(int strikeBonusTurns) {
        this.strikeBonusTurns = strikeBonusTurns;
    }

    public int getSpareBonusTurns() {
        return spareBonusTurns;
    }

    public void setSpareBonusTurns(int spareBonusTurns) {
        this.spareBonusTurns = spareBonusTurns;
    }

    public Player(String name) {
        this.name = name;
        this.strikes = new ArrayList<>();
        this.spares = new ArrayList<>();
        this.score = 0;
        this.scores = new HashMap<>();
    }

    public HashMap<Integer, List<Integer>> getScores() {
        return scores;
    }

    public void setScores(HashMap<Integer, List<Integer>> scores) {
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Strike> getStrikes() {
        return strikes;
    }

    public void setStrikes(List<Strike> strikes) {
        this.strikes = strikes;
    }

    public List<Spare> getSpares() {
        return spares;
    }

    public void setSpares(List<Spare> spares) {
        this.spares = spares;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void addStrikeBonusTurns(int turns){
        this.strikeBonusTurns += turns;
    }

    public void addSpareBonusTurns(int turns){
        this.spareBonusTurns += turns;
    }

    public void decreaseStrikeBonusTurns(int turns) {
        this.strikeBonusTurns -= turns;
    }

    public void decreaseSpareBonusTurns(int turns) {
        this.spareBonusTurns -= turns;
    }
}
