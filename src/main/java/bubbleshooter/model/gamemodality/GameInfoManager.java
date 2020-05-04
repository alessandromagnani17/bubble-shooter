package bubbleshooter.model.gamemodality;

public class GameInfoManager {

    private double gameTime;
    private int destroyedBubbles;
    private int wrongShoots;
    private int score;

    public final void updateGameTime(final double elapsed) {
        this.gameTime += elapsed;
    }

    public final void addDestroyedBubble() {
        this.destroyedBubbles += 1;
    }

    // tiri sbagliati consecutivamente
    public final void addWrongShoots() {
        this.wrongShoots += 1;
    }

    public final void updateScore(final int score) {
        this.score = score;
    }

    public final int getGameTime() {
        return (int) gameTime;
    }

    public final int getDestroyedBubbles() {
        return destroyedBubbles;
    }

    public final int getWrongShoots() {
        return wrongShoots;
    }

    public final void clearWrongShoots() {
        this.wrongShoots = 0; 
    }

    public final int getScore() {
        return score;
    }
}
