package bubbleshooter.model.highscore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import com.google.common.collect.ImmutableSortedSet;
import bubbleshooter.model.gamemodality.GameModality;

public class HighscoreStoreImpl implements HighscoreStore {

    private static final long serialVersionUID = -3738961252432967724L;
    private static final String FILE_NAME = "Highscores";
    private static final File FILE = new File(System.getProperty("user.home"), "BubbleShooter");
    private final File file;
    private final Map<GameModality, SortedSet<HighscoreStructure>> mapOfItems;

    public HighscoreStoreImpl() {
        this(new File(FILE, FILE_NAME));
    }

    public HighscoreStoreImpl(final File file) {
        this.file = file;
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
        saveModify();
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
    public ImmutableSortedSet<HighscoreStructure> getHighscoresForModality(final GameModality gameMode) {
        ImmutableSortedSet<HighscoreStructure> result;

        if (this.mapOfItems.containsKey(gameMode)) {
            result = ImmutableSortedSet.copyOf(this.mapOfItems.get(gameMode));
        } else {
            result = ImmutableSortedSet.of();
        }

        return result;
    }
}
