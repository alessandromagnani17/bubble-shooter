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

public class TestHighscore {

    private HighscoreStore highscoreStore = new HighscoreStoreImpl();
    private static final int POINTS = 500;
    private static final int LIMIT = 10;

    /**
     * Method to test if a {@link HighscoreStore} add a new {@link HighscoreStructure}
     * to the basic mode highscores.
     */
    @Test
    public final void testAddABasicModeScore() {
        boolean flag = this.highscoreStore.getFile().delete();
        if (flag) {
            this.highscoreStore = new HighscoreStoreImpl();

            ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
            ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();
            this.highscoreStore.addScore(new HighscoreStructure("Player", POINTS, LevelType.BASICMODE));
            scoreList.addAll(this.highscoreStore.getHighscoresForModality(LevelType.BASICMODE));
            rightList.add(new HighscoreStructure("Player", POINTS, LevelType.BASICMODE));
            assertTrue(rightList.get(0).getName().equals(scoreList.get(0).getName()));
            assertTrue(rightList.get(0).getScore().equals(scoreList.get(0).getScore()));
        }
     }

    /**
     * Method to test if a {@link HighscoreStore} add a new {@link HighscoreStructure}
     * to the survival mode highscores.
     */
    @Test
    public final void testAddASurvivalModeScore() {
        boolean flag = this.highscoreStore.getFile().delete();
        if (flag) {
            this.highscoreStore = new HighscoreStoreImpl();

            ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
            ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();

            this.highscoreStore.addScore(new HighscoreStructure("Player", POINTS, LevelType.SURVIVALMODE));
            scoreList.addAll(this.highscoreStore.getHighscoresForModality(LevelType.SURVIVALMODE));

            rightList.add(new HighscoreStructure("Player", POINTS, LevelType.SURVIVALMODE));

            assertTrue(rightList.get(0).getName().equals(scoreList.get(0).getName()));
            assertTrue(rightList.get(0).getScore().equals(scoreList.get(0).getScore()));
        }
     }

    /**
     * Method to test if a {@link HighscoreStore} add some new {@link HighscoreStructure}
     * to the basic mode highscores in the correct order.
     */
    @Test
    public final void testOrderBasicModeScore() {
        boolean flag = this.highscoreStore.getFile().delete();
        if (flag) {
            this.highscoreStore = new HighscoreStoreImpl();

            ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
            ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();
        this.highscoreStore.addScore(new HighscoreStructure("Player", POINTS * 2, LevelType.BASICMODE));
        this.highscoreStore.addScore(new HighscoreStructure("Player1", POINTS, LevelType.BASICMODE));
        this.highscoreStore.addScore(new HighscoreStructure("Player2", POINTS * 3, LevelType.BASICMODE));

        scoreList.addAll(this.highscoreStore.getHighscoresForModality(LevelType.BASICMODE));

        rightList.add(new HighscoreStructure("Player2", POINTS * 3, LevelType.BASICMODE));
        rightList.add(new HighscoreStructure("Player", POINTS * 2, LevelType.BASICMODE));
        rightList.add(new HighscoreStructure("Player1", POINTS, LevelType.BASICMODE));

            for (int i = 0; i < rightList.size(); i++) {
                assertTrue(rightList.get(i).getName().equals(scoreList.get(i).getName()));
                assertTrue(rightList.get(i).getScore().equals(scoreList.get(i).getScore()));
            }
        }
     }

    /**
     * Method to test if a {@link HighscoreStore} add some new {@link HighscoreStructure}
     * to the survival mode highscores in the correct order.
     */
    @Test
    public final void testOrderSurvivalModeScore() {
        boolean flag = this.highscoreStore.getFile().delete();
        if (flag) {
            this.highscoreStore = new HighscoreStoreImpl();

            ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
            ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();
        this.highscoreStore.addScore(new HighscoreStructure("Player", POINTS * 2, LevelType.SURVIVALMODE));
        this.highscoreStore.addScore(new HighscoreStructure("Player1", POINTS, LevelType.SURVIVALMODE));
        this.highscoreStore.addScore(new HighscoreStructure("Player2", POINTS * 3, LevelType.SURVIVALMODE));

        scoreList.addAll(this.highscoreStore.getHighscoresForModality(LevelType.SURVIVALMODE));

        rightList.add(new HighscoreStructure("Player2", POINTS * 3, LevelType.SURVIVALMODE));
        rightList.add(new HighscoreStructure("Player", POINTS * 2, LevelType.SURVIVALMODE));
        rightList.add(new HighscoreStructure("Player1", POINTS, LevelType.SURVIVALMODE));

            for (int i = 0; i < rightList.size(); i++) {
                assertTrue(rightList.get(i).getName().equals(scoreList.get(i).getName()));
                assertTrue(rightList.get(i).getScore().equals(scoreList.get(i).getScore()));
            }
        }
     }

    /**
     * Method to test if a {@link HighscoreStore} remove {@link HighscoreStructure} 
     * from the basic mode list if there are over than 10 items.
     */
    @Test
    public final void testLimitForBasicMode() {
        boolean flag = this.highscoreStore.getFile().delete();
        if (flag) {
            this.highscoreStore = new HighscoreStoreImpl();

            ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
            ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();
        for (int i = 0; i < LIMIT * 2; i++) {
            this.highscoreStore.addScore(new HighscoreStructure("Player" + i, POINTS + i, LevelType.BASICMODE));
        }
        scoreList.addAll(this.highscoreStore.getHighscoresForModality(LevelType.BASICMODE));

        for (int j = 0; j < LIMIT; j++) {
            rightList.add(new HighscoreStructure("Player" + j, POINTS + j, LevelType.BASICMODE));
        }

        assertFalse(scoreList.size() > LIMIT);
        assertTrue(rightList.size() == scoreList.size());
        }
     }

    /**
     * Method to test if a {@link HighscoreStore} remove {@link HighscoreStructure} 
     * from the survival mode list if there are over than 10 items.
     */
    @Test
    public final void testLimitForSurvivalMode() {
        boolean flag = this.highscoreStore.getFile().delete();
        if (flag) {
            this.highscoreStore = new HighscoreStoreImpl();

            ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
            ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();
        for (int i = 0; i < LIMIT * 2; i++) {
            this.highscoreStore.addScore(new HighscoreStructure("Player" + i, POINTS + i, LevelType.SURVIVALMODE));
        }
        scoreList.addAll(this.highscoreStore.getHighscoresForModality(LevelType.SURVIVALMODE));

        for (int j = 0; j < LIMIT; j++) {
            rightList.add(new HighscoreStructure("Player" + j, POINTS + j, LevelType.SURVIVALMODE));
        }
        assertFalse(scoreList.size() > LIMIT);
        assertTrue(rightList.size() == scoreList.size());
     }

    }
}
