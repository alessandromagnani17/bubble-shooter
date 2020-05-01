package bubbleshooter.controller.sound;

import bubbleshooter.controller.engine.GameEngineDecorator;
import bubbleshooter.controller.engine.GameLoop;

/**
 * Class which Decorate the {@link BasicGameLoop} through the {@link GameEngineDecorator}
 * in order to add the Sound feature.
 */
public class SoundGameEngine extends GameEngineDecorator {

    /**
     * The {@link SoundManager2} which manage the Sound feature.
     */
    private final SoundManager soundManager;

    /**
     * @param gameLoop The {@link BasicGameLoop} to decorate.
     */
    public SoundGameEngine(final GameLoop gameLoop) {
        super(gameLoop);
        this.soundManager = new SoundManager();
    }

    /**
     * {@inheritDoc}
     * It also starts the Background music.
     */
    @Override
    public final void startLoop() {
        super.startLoop();
        this.soundManager.startBackgroundSound();
    }

    /**
     * {@inheritDoc}
     * It also stop the Background music.
     */
    @Override
    public final void stopLoop() {
        super.stopLoop();
        this.soundManager.stopBackgroundSound();
    }

    /**
     * {@inheritDoc}
     * It also pause the Background music.
     */
    @Override
    public final void pauseLoop() {
        super.pauseLoop();
        this.soundManager.pauseBackgroundSound();
   }

    /**
     * {@inheritDoc}
     * It also resume the Background music.
     */
    @Override
    public final void resumeLoop() {
        super.resumeLoop();
        this.soundManager.resumeSound();
    }

    /**
     * 
     * @return the {@link SoundManager2} which manages the Music feature.
     */
    public final SoundManager getSoundManager() {
        return this.soundManager;
    }
}
