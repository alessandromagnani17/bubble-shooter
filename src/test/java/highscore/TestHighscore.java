package highscore;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import bubbleshooter.model.game.level.LevelType;
import bubbleshooter.model.highscore.HighscoreStore;
import bubbleshooter.model.highscore.HighscoreStoreImpl;
import bubbleshooter.model.highscore.HighscoreStructure;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * JUnit Test class to test the {@link HighscoreStoreImpl} of the Game.
 */
public class TestHighscore {

    private final HighscoreStore highscoreStore = new HighscoreStoreImpl();
    private static final int POINTS = 500;
    private static final int LIMIT = 10;
    private static final String PLAYER = "Player";

    /**
     * Method to test if a {@link HighscoreStore} add a new {@link HighscoreStructure}
     * to the basic mode highscores.
     */
    @Test
    public final void testAddABasicModeScore() {
        final Integer score1, score2;
        this.highscoreStore.cleanFile();

        final ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
        final ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();

        this.highscoreStore.addScore(new HighscoreStructure(PLAYER, POINTS, LevelType.BASICMODE));
        scoreList.addAll(this.highscoreStore.getHighscoresForModality(LevelType.BASICMODE));

        rightList.add(new HighscoreStructure(PLAYER, POINTS, LevelType.BASICMODE));

        assertTrue(rightList.get(0).getName().equals(scoreList.get(0).getName()));
        score1 = rightList.get(0).getScore();
        score2 = scoreList.get(0).getScore();
        assertTrue(score1.equals(score2));

     }

    /**
     * Method to test if a {@link HighscoreStore} add a new {@link HighscoreStructure}
     * to the survival mode highscores.
     */
    @Test
    public final void testAddASurvivalModeScore() {
    	final Integer score1, score2;
        this.highscoreStore.cleanFile();

        final ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
        final ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();

        this.highscoreStore.addScore(new HighscoreStructure(PLAYER, POINTS, LevelType.SURVIVALMODE));
        scoreList.addAll(this.highscoreStore.getHighscoresForModality(LevelType.SURVIVALMODE));

        rightList.add(new HighscoreStructure(PLAYER, POINTS, LevelType.SURVIVALMODE));

        assertTrue(rightList.get(0).getName().equals(scoreList.get(0).getName()));
        score1 = rightList.get(0).getScore();
        score2 = scoreList.get(0).getScore();
        assertTrue(score1.equals(score2));

     }

    /**
     * Method to test if a {@link HighscoreStore} add some new {@link HighscoreStructure}
     * to the basic mode highscores in the correct order.
     */
    @Test
    public final void testOrderBasicModeScore() {
    	Integer score1, score2;
        this.highscoreStore.cleanFile();

        final ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
        final ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();

        this.highscoreStore.addScore(new HighscoreStructure(PLAYER, POINTS * 2, LevelType.BASICMODE));
        this.highscoreStore.addScore(new HighscoreStructure(PLAYER + 1, POINTS, LevelType.BASICMODE));
        this.highscoreStore.addScore(new HighscoreStructure(PLAYER + 2, POINTS * 3, LevelType.BASICMODE));

        scoreList.addAll(this.highscoreStore.getHighscoresForModality(LevelType.BASICMODE));

        rightList.add(new HighscoreStructure(PLAYER + 2, POINTS * 3, LevelType.BASICMODE));
        rightList.add(new HighscoreStructure(PLAYER, POINTS * 2, LevelType.BASICMODE));
        rightList.add(new HighscoreStructure(PLAYER + 1, POINTS, LevelType.BASICMODE));

        for (int i = 0; i < rightList.size(); i++) {
            assertTrue(rightList.get(i).getName().equals(scoreList.get(i).getName()));
            score1 = rightList.get(i).getScore();
            score2 = scoreList.get(i).getScore();
            assertTrue(score1.equals(score2));
        }
     }

    /**
     * Method to test if a {@link HighscoreStore} add some new {@link HighscoreStructure}
     * to the survival mode highscores in the correct order.
     */
    @Test
    public final void testOrderSurvivalModeScore() {
    	Integer score1, score2;
        this.highscoreStore.cleanFile();

        final ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
        final ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();

        this.highscoreStore.addScore(new HighscoreStructure(PLAYER, POINTS * 2, LevelType.SURVIVALMODE));
        this.highscoreStore.addScore(new HighscoreStructure(PLAYER + 1, POINTS, LevelType.SURVIVALMODE));
        this.highscoreStore.addScore(new HighscoreStructure(PLAYER + 2, POINTS * 3, LevelType.SURVIVALMODE));

        scoreList.addAll(this.highscoreStore.getHighscoresForModality(LevelType.SURVIVALMODE));

        rightList.add(new HighscoreStructure(PLAYER + 2, POINTS * 3, LevelType.SURVIVALMODE));
        rightList.add(new HighscoreStructure(PLAYER, POINTS * 2, LevelType.SURVIVALMODE));
        rightList.add(new HighscoreStructure(PLAYER + 1, POINTS, LevelType.SURVIVALMODE));

        for (int i = 0; i < rightList.size(); i++) {
            assertTrue(rightList.get(i).getName().equals(scoreList.get(i).getName()));
            score1 = rightList.get(i).getScore();
            score2 = scoreList.get(i).getScore();
            assertTrue(score1.equals(score2));
        }
     }

    /**
     * Method to test if a {@link HighscoreStore} remove {@link HighscoreStructure} 
     * from the basic mode list if there are over than 10 items.
     */
    @Test
    public final void testLimitForBasicMode() {
        final Integer size1, size2;
        this.highscoreStore.cleanFile();

        final ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
        final ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();

        for (int i = 0; i < LIMIT * 2; i++) {
            this.highscoreStore.addScore(new HighscoreStructure(PLAYER + i, POINTS + i, LevelType.BASICMODE));
        }
        scoreList.addAll(this.highscoreStore.getHighscoresForModality(LevelType.BASICMODE));

        for (int j = 0; j < LIMIT; j++) {
            rightList.add(new HighscoreStructure(PLAYER + j, POINTS + j, LevelType.BASICMODE));
        }

        size1 = rightList.size();
        size2 = scoreList.size();
        assertFalse(scoreList.size() > LIMIT);
        assertTrue(size1.equals(size2));

     }

    /**
     * Method to test if a {@link HighscoreStore} remove {@link HighscoreStructure} 
     * from the survival mode list if there are over than 10 items.
     */
    @Test
    public final void testLimitForSurvivalMode() {
        final Integer size1, size2;
        this.highscoreStore.cleanFile();

        final ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
        final ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();

        for (int i = 0; i < LIMIT * 2; i++) {
            this.highscoreStore.addScore(new HighscoreStructure(PLAYER + i, POINTS + i, LevelType.SURVIVALMODE));
        }
        scoreList.addAll(this.highscoreStore.getHighscoresForModality(LevelType.SURVIVALMODE));

        for (int j = 0; j < LIMIT; j++) {
            rightList.add(new HighscoreStructure(PLAYER + j, POINTS + j, LevelType.SURVIVALMODE));
        }

        size1 = rightList.size();
        size2 = scoreList.size();
        assertFalse(scoreList.size() > LIMIT);
        assertTrue(size1.equals(size2));

     }
}
