package bubbleshooter.controller.sound;

import java.io.BufferedInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public final class SoundManager {
	
	private Clip clip;
	private AudioInputStream audioInputStream;
	private int clipFrame;
	private boolean isPaused;
	
	public SoundManager() {
		this.clipFrame = 0;
		this.isPaused = true;
	}

	public void loadBackgroundSound(final String soundTypePath) {
		  try {
              this.audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream(soundTypePath)));
              this.clip = AudioSystem.getClip();
              this.clip.open(this.audioInputStream);
          } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        	  	e.printStackTrace();
          }
    }
	
    public void startSound() {
    	if (this.isPaused) {
    	   this.isPaused = false;
    	   this.clip.setFramePosition(0);
    	   this.clip.start(); 
    	  }
        }
    public void stopSound() {
    	this.clip.stop();
    	this.isPaused = true;
    }

    public void pauseSound() {
    	this.isPaused = true;
    	this.clipFrame = this.clip.getFramePosition();
    	this.clip.stop();
    }

    public void resumeSound() {
    	if (this.isPaused) {
    		this.isPaused = false;
    	    this.clip.setFramePosition(this.clipFrame);
    	    this.clip.start();
    	}
    }

    public boolean isPaused() {
    	return this.isPaused;
    }
}