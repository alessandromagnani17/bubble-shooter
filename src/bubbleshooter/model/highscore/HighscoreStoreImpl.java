package bubbleshooter.model.highscore;

import java.io.File;
import bubbleshooter.model.gamemodality.GameModality;

public class HighscoreStoreImpl implements HighscoreStore{
    
    private static final long serialVersionUID = -3738961252432967724L;
    private static final String FILE_NAME = "Highscores";
    private static final File FILE = new File(System.getProperty("user.home"), "BubbleShooter");
    private final File file;
    
    public HighscoreStoreImpl() {
        this(new File(FILE, FILE_NAME));
    }
    
    public HighscoreStoreImpl(File file) {
        this.file = file;
    }

    @Override
    public File getFile() {
        return this.file;
    }

    @Override
    public void addScore(GameModality gameMode, Score score) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void read() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public HighscoreStore getHighscoresForModality(GameModality gameMode) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
