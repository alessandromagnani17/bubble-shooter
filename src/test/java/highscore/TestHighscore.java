package highscore;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import bubbleshooter.model.game.GameType;
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
        this.highscoreStore.getFile().delete();
        this.highscoreStore = new HighscoreStoreImpl();

        ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
        ObservableList<HighscoreStructure> scoreList1 = FXCollections.observableArrayList();

        this.highscoreStore.addScore(new HighscoreStructure("Player", POINTS, GameType.BASICMODE));
        scoreList1.addAll(this.highscoreStore.getHighscoresForModality(GameType.BASICMODE));

        rightList.add(new HighscoreStructure("Player", POINTS, GameType.BASICMODE));

        assertTrue(rightList.get(0).getName().equals(scoreList1.get(0).getName()));
        assertTrue(rightList.get(0).getScore().equals(scoreList1.get(0).getScore()));
     }

    /**
     * Method to test if a {@link HighscoreStore} add a new {@link HighscoreStructure}
     * to the survival mode highscores.
     */
    @Test
    public final void testAddASurvivalModeScore() {
        this.highscoreStore.getFile().delete();
        this.highscoreStore = new HighscoreStoreImpl();

        ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
        ObservableList<HighscoreStructure> scoreList1 = FXCollections.observableArrayList();

        this.highscoreStore.addScore(new HighscoreStructure("Player", POINTS, GameType.SURVIVALMODE));
        scoreList1.addAll(this.highscoreStore.getHighscoresForModality(GameType.SURVIVALMODE));

        rightList.add(new HighscoreStructure("Player", POINTS, GameType.SURVIVALMODE));

        assertTrue(rightList.get(0).getName().equals(scoreList1.get(0).getName()));
        assertTrue(rightList.get(0).getScore().equals(scoreList1.get(0).getScore()));
     }

    /**
     * Method to test if a {@link HighscoreStore} add some new {@link HighscoreStructure}
     * to the basic mode highscores in the correct order.
     */
    @Test
    public final void testOrderBasicModeScore() {
        this.highscoreStore.getFile().delete();
        this.highscoreStore = new HighscoreStoreImpl();

        ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
        ObservableList<HighscoreStructure> scoreList1 = FXCollections.observableArrayList();

        this.highscoreStore.addScore(new HighscoreStructure("Player", POINTS * 2, GameType.BASICMODE));
        this.highscoreStore.addScore(new HighscoreStructure("Player1", POINTS, GameType.BASICMODE));
        this.highscoreStore.addScore(new HighscoreStructure("Player2", POINTS * 3, GameType.BASICMODE));

        scoreList1.addAll(this.highscoreStore.getHighscoresForModality(GameType.BASICMODE));

        rightList.add(new HighscoreStructure("Player2", POINTS * 3, GameType.BASICMODE));
        rightList.add(new HighscoreStructure("Player", POINTS * 2, GameType.BASICMODE));
        rightList.add(new HighscoreStructure("Player1", POINTS, GameType.BASICMODE));

        for (int i = 0; i < rightList.size(); i++) {
            assertTrue(rightList.get(i).getName().equals(scoreList1.get(i).getName()));
            assertTrue(rightList.get(i).getScore().equals(scoreList1.get(i).getScore()));
        }
     }

    /**
     * Method to test if a {@link HighscoreStore} add some new {@link HighscoreStructure}
     * to the survival mode highscores in the correct order.
     */
    @Test
    public final void testOrderSurvivalModeScore() {
        this.highscoreStore.getFile().delete();
        this.highscoreStore = new HighscoreStoreImpl();

        ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
        ObservableList<HighscoreStructure> scoreList1 = FXCollections.observableArrayList();

        this.highscoreStore.addScore(new HighscoreStructure("Player", POINTS * 2, GameType.SURVIVALMODE));
        this.highscoreStore.addScore(new HighscoreStructure("Player1", POINTS, GameType.SURVIVALMODE));
        this.highscoreStore.addScore(new HighscoreStructure("Player2", POINTS * 3, GameType.SURVIVALMODE));

        scoreList1.addAll(this.highscoreStore.getHighscoresForModality(GameType.SURVIVALMODE));

        rightList.add(new HighscoreStructure("Player2", POINTS * 3, GameType.SURVIVALMODE));
        rightList.add(new HighscoreStructure("Player", POINTS * 2, GameType.SURVIVALMODE));
        rightList.add(new HighscoreStructure("Player1", POINTS, GameType.SURVIVALMODE));

        for (int i = 0; i < rightList.size(); i++) {
            assertTrue(rightList.get(i).getName().equals(scoreList1.get(i).getName()));
            assertTrue(rightList.get(i).getScore().equals(scoreList1.get(i).getScore()));
        }
     }

    /**
     * Method to test if a {@link HighscoreStore} remove elements from the basic mode list
     * if there are over than 10 items.
     */
    @Test
    public final void testLimitForBasicMode() {
        this.highscoreStore.getFile().delete();
        this.highscoreStore = new HighscoreStoreImpl();

        ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
        ObservableList<HighscoreStructure> scoreList1 = FXCollections.observableArrayList();

        for (int i = 0; i < LIMIT * 2; i++) {
            this.highscoreStore.addScore(new HighscoreStructure("Player" + i, POINTS + i, GameType.BASICMODE));
        }
        scoreList1.addAll(this.highscoreStore.getHighscoresForModality(GameType.BASICMODE));

        for (int j = 0; j < LIMIT; j++) {
            rightList.add(new HighscoreStructure("Player" + j, POINTS + j, GameType.BASICMODE));
        }

        assertTrue(rightList.size() == scoreList1.size());
     }

    /**
     * Method to test if a {@link HighscoreStore} remove elements from the survival mode list
     * if there are over than 10 items.
     */
    @Test
    public final void testLimitForSurvivalMode() {
        this.highscoreStore.getFile().delete();
        this.highscoreStore = new HighscoreStoreImpl();

        ObservableList<HighscoreStructure> rightList = FXCollections.observableArrayList();
        ObservableList<HighscoreStructure> scoreList1 = FXCollections.observableArrayList();

        for (int i = 0; i < LIMIT * 2; i++) {
            this.highscoreStore.addScore(new HighscoreStructure("Player" + i, POINTS + i, GameType.SURVIVALMODE));
        }
        scoreList1.addAll(this.highscoreStore.getHighscoresForModality(GameType.SURVIVALMODE));

        for (int j = 0; j < LIMIT; j++) {
            rightList.add(new HighscoreStructure("Player" + j, POINTS + j, GameType.SURVIVALMODE));
        }

        assertTrue(rightList.size() == scoreList1.size());
     }

}
