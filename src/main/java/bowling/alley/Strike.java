package bowling.alley;

public class Strike {
    private Player player;
    private static int bonus;
    private int roundNumber;

    public Strike(Player player, int roundNumber) {
        this.player = player;
        this.roundNumber = roundNumber;
        this.bonus = 5;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public static int getBonus() {
        return bonus;
    }

}
