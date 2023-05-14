package bowling.alley;

public class Spare {
    Player player;
    int bonus;
    int roundNumber;

    public Spare(Player player, int roundNumber) {
        this.player = player;
        this.roundNumber = roundNumber;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
