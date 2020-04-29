package bubbleshooter.controller.sound;

public enum SoundNames {

	BACKGROUND("sound/Background.wav"),
	
	GEOMETRY("sound/Geometry.wav"),
	
	COFFIN("sound/Coffin.wav"),
	
	SHOT("sound/shot.wav"),
	
	POP("sound/pop.wav"),
	
	SNAP("sound/snap.wav"),
	
	BOMB("sound/bomb.wav");
	
	private final String path;

    SoundNames(final String path) {
    	this.path = path;
	}

    public String getPath() {
    	return this.path;
    }
}
