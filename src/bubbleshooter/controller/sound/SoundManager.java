package bubbleshooter.controller.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public final class Sound {
	
	private Sound() {
	}
	
    public static synchronized void playSound(final String soundType) {

        new Thread(new Runnable() { 
            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(soundType));
                    clip.open(inputStream);
                    clip.start(); 
                } catch (Exception e) {
                    System.out.println("EXCEPTION: " + e.getMessage() + "IN :" + soundType);
                }
            }
        }).start();
    }
}