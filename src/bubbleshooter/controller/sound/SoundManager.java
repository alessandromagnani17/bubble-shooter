package bubbleshooter.controller.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public final class SoundManager {
	
	private boolean isPaused;
	private final double volume = 0.2;
	private SoundNames soundName;
	private MediaPlayer mediaPlayer;
	
	public SoundManager() {
		this.isPaused = true;
		this.loadGameSounds();
	}

	private void loadGameSounds() {
		  try {
			  this.soundName = SoundNames.BACKGROUND;
			  this.mediaPlayer = new MediaPlayer(new Media(ClassLoader.getSystemResource(this.soundName.getPath()).toString()));
          } catch (Exception e) {
        	  	e.printStackTrace();
          }
    }
	
    public void startBackgroundSound() {
        this.mediaPlayer.setVolume(this.volume);
    	this.mediaPlayer.play();
     }

    public void stopBackgroundSound() {
    	this.mediaPlayer.stop();
    }

    public void pauseBackgroundSound() {
    	this.mediaPlayer.pause();
    }

    public void resumeSound() {
    	this.mediaPlayer.play();
    }
}