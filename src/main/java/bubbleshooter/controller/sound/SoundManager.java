package bubbleshooter.controller.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

/**
 * The Class which manage the Sound feature of the Game.
 */
public class SoundManager {

    private static final double VOLUME = 0.2;
    private MediaPlayer mediaPlayer;

    /**
     * In the constructor are loaded the resources of the sounds.
     */
    public SoundManager() {
        this.loadGameSounds();
    }

    /**
     * Method used to load the resources and to initialize the MediaPlayer.
     */
    private void loadGameSounds() {
        try {
            this.mediaPlayer = new MediaPlayer(new Media(ClassLoader.getSystemResource(SoundNames.BACKGROUND.getPath()).toString()));
          } catch (MediaException e) {
              e.printStackTrace();
          }
    }

    /**
     * Method used to start the Background music in the game.
     */
    public final void startBackgroundSound() {
        this.mediaPlayer.setVolume(VOLUME);
        this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        this.mediaPlayer.play();
     }

    /**
     * Method used to stop the Background music in the game.
     */
    public final void stopBackgroundSound() {
        this.mediaPlayer.stop();
    }

    /**
     * Method used to pause the Background music in the game.
     */
    public final void pauseBackgroundSound() {
        this.mediaPlayer.pause();
    }

    /**
     * Method used to resume the Background music in the game.
     */
    public final void resumeSound() {
        this.mediaPlayer.play();
    }
}
