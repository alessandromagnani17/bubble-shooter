package level;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import bubbleshooter.model.game.GameStatus;
import bubbleshooter.model.game.level.BasicLevel;
import bubbleshooter.model.game.level.Level;
import bubbleshooter.model.game.level.SurvivalLevel;

/**
 * JUnit Test class to test the {@link Level} of the Game.
 */
public class TestLevel {

    private static final double ELAPSED = 1;
    private static final double LONG_ELAPSED = 20_000;

    /**
     * Tests the status of the game before and after start the {@link BasicLevel}.
     */
    @Test
    public final void testStartBasicLevel() {
        final Level level = new BasicLevel();
        assertTrue(level.getGameStatus().equals(GameStatus.PAUSE));
        level.start();
        level.update(ELAPSED);
        assertTrue(level.getGameStatus().equals(GameStatus.RUNNING));
    }

    /**
     * Tests the status of the game before and after start the
     * {@link SurvivalLevel}.
     */
    @Test
    public final void testStartSurvivalLevel() {
        final Level level = new SurvivalLevel();
        assertTrue(level.getGameStatus().equals(GameStatus.PAUSE));
        level.start();
        level.update(ELAPSED);
        assertTrue(level.getGameStatus().equals(GameStatus.RUNNING));
    }

    /**
     * Tests the correct loading of {@link ShootingBubble}.
     */
    @Test
    public final void testLoadShootingBubble() {
        final Level level = new BasicLevel();
        assertTrue(level.getBubblesManager().getShootingBubble().equals(Optional.empty()));
        level.start();
        level.update(ELAPSED);
        assertFalse(level.getBubblesManager().getShootingBubble().equals(Optional.empty()));
    }

    /**
     * Tests the creation of new row in {@link SurvivalLevel}.
     */
    @Test
    public final void testNewRowSurvivalLevel() {
        final SurvivalLevel level = new SurvivalLevel();
        level.start();
        level.update(ELAPSED);
        assertSame(level.getGridManager().getCreatedRows(), Level.NUM_ROWS);
        level.update(LONG_ELAPSED);
        assertNotSame(level.getGridManager().getCreatedRows(), Level.NUM_ROWS);
    }

    /**
     * Tests the creation of new row in {@link BasicLevel}.
     */
    @Test
    public final void testNewRowBasicLevel() {
        final BasicLevel level = new BasicLevel();
        level.start();
        level.update(ELAPSED);
        assertSame(level.getGridManager().getCreatedRows(), Level.NUM_ROWS);
        level.getGameData().addWrongShoot();
        level.getGameData().addWrongShoot();
        level.getGameData().addWrongShoot();
        level.getGameData().addWrongShoot();
        level.getGameData().addWrongShoot();
        level.update(ELAPSED);
        assertNotSame(level.getGridManager().getCreatedRows(), Level.NUM_ROWS);
    }
}
