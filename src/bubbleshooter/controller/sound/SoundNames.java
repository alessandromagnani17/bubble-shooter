package bubbleshooter.controller.engine;

public enum SoundNames {

	BACKGROUND("/sound/background.wav"),
	
	SHOT("/sound/shot.wav"),
	
	POP("/sound/pop.wav"),
	
	SNAP("/sound/snap.wav"),
	
	BOMB("/sound/bomb.wav");
	
	private final String path;

    SoundNames(final String path) {
    	this.path = path;
	}

    public String getPath() {
    	return this.path;
    }
}
