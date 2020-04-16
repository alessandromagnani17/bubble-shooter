package bubbleshooter.model.highscore;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import com.google.common.collect.ImmutableSortedSet;
import bubbleshooter.model.gamemodality.GameModality;
import bubbleshooter.model.gamemodality.LevelTypes;

public class HighscoreStoreImpl implements HighscoreStore {

    private static final long serialVersionUID = -3738961252432967724L;
    private static final String FILE_PATH = System.getProperty("user.home") + "/Highscores.txt";
    private final File file;
    private final Map<GameModality, SortedSet<HighscoreStructure>> mapOfItems;
    private final static int CAPACITY = 10;
    
    public HighscoreStoreImpl() {
    	this.file =  new File(FILE_PATH);
        try {
            System.out.println("!!! ---> Creating file ...");
            file.createNewFile();
            
            System.out.println("!!! ---> Writing BASIC and SURVIVAL ...");
            FileWriter fw = new FileWriter(this.file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("HIGHSCORES!!\n\n");
            bw.write("END_OF_HIGH_END_OF_HIGH\n\n");
            bw.write("SURVIVAL_MODE_HIGHSCORES...\n");
            bw.write("END_OF_HIGH_END_OF_HIGH\n\n");
            bw.write("END_OF_FILE_END_OF_FILE");
            
            bw.flush();
            bw.close();
            
        } catch (IOException e) {
            System.out.println("ERROR !!! Can't create file...");
            e.printStackTrace();
        }
        this.mapOfItems = new HashMap<>();
    }

    @Override
    public File getFile() {
        return this.file;
    }

    @Override
    public void addScore(final GameModality gameMode, final HighscoreStructure score) {
        SortedSet<HighscoreStructure> itemsSet = this.mapOfItems.get(gameMode);

        if (itemsSet == null) {
            itemsSet = new TreeSet<>();
            this.mapOfItems.put(gameMode, itemsSet);
        } 

        itemsSet.add(score);
        clean(itemsSet);
        saveModify();
    }

    private void clean(SortedSet<HighscoreStructure> itemsSet) {
        while(itemsSet.size() > CAPACITY) {
            itemsSet.remove(itemsSet.last());
        }
        
    }

    @Override
    public void clear() {
        this.mapOfItems.clear();

        if (this.file.exists()) this.file.delete();
    }

    @Override
    public void saveModify() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            output.writeObject(this);
        } catch (IOException e) {
            System.out.println("ERROR ( can't write on file )");
        }
    }

    @Override
    public void read() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
            Object object = input.readObject();

            if (HighscoreStoreImpl.class.isInstance(object)) {
                HighscoreStoreImpl highscore = HighscoreStoreImpl.class.cast(object);
                this.mapOfItems.putAll(highscore.mapOfItems);
            } else {
                System.out.println("ERROR ( Object is not expected type )");
            }
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("ERROR ( can't read from the file )");
        }
    }

    @Override
    public ImmutableSortedSet<HighscoreStructure> getHighscoresForModality(final LevelTypes gameMode) {
        ImmutableSortedSet<HighscoreStructure> result;

        if (this.mapOfItems.containsKey(gameMode)) {
            result = ImmutableSortedSet.copyOf(this.mapOfItems.get(gameMode));
        } else {
            result = ImmutableSortedSet.of();
        }

        return result;
    }
}
