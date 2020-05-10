package bubbleshooter.model.highscore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bubbleshooter.model.game.GameType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class used for save and read all the scores from a file.
 * Implements the {@link HighscoreStore} interface.
 *
 */
public class HighscoreStoreImpl implements HighscoreStore {

    private static final String SEP = System.getProperty("file.separator");
    private static final String DIR_PATH = System.getProperty("user.home") + SEP + ".Bubbleshooter";
    private static final String FILE_PATH = SEP + "Highscores.txt";
    private static final int CAPACITY = 10;
    private final File file;
    private Map<GameType, List<HighscoreStructure>> mapOfItems;
    private boolean flag;

    /**
     * Constructor of the {@link HighscoreStore} used for create the file if necessary and
     * for allocate the HashMap.
     */
    public HighscoreStoreImpl() {
        this.file = new File(DIR_PATH + FILE_PATH);
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                this.file.createNewFile();
                flag = true;
            } else {
                flag = false;
            }
            if (flag) {
                final FileWriter fw = new FileWriter(this.file);
                final BufferedWriter bw = new BufferedWriter(fw);

                bw.write("HIGHSCORES!!\n\n");
                bw.write("END_OF_HIGH_END_OF_HIGH\n\n");
                bw.write("SURVIVAL_MODE_HIGHSCORES...\n");
                bw.write("END_OF_HIGH_END_OF_HIGH\n\n");
                bw.write("END_OF_FILE_END_OF_FILE");

                bw.flush();
                bw.close();
            }

        } catch (IOException e) {
            System.out.println("ERROR !!! Can't create file...");
            e.printStackTrace();
        }
        this.mapOfItems = new HashMap<>();
    }

    /**
     * Method for get the file where scores are saved.
     * 
     * @return the file where the scores are saved.
     */
    @Override
    public final File getFile() {
        return this.file;
    }

    /**
     * Method for add a score for a game modality.
     * 
     * @param score the current {@link HighscoreStructure} to save.
     */
    @Override
    public final void addScore(final HighscoreStructure score) {

        this.mapOfItems = readFile();

        this.mapOfItems.get(score.getGameMode()).add(score);

        sort(this.mapOfItems.get(score.getGameMode()));

        clean(this.mapOfItems.get(score.getGameMode()));

        reWriteFile();
    }

    /**
     * Private method used for put in map every the type of scores saved.
     * 
     * @return the map contains the different scores.
     */
    private Map<GameType, List<HighscoreStructure>> readFile() {
        final Map<GameType, List<HighscoreStructure>> map = new HashMap<>();
        for (final GameType tipo : GameType.values()) {
            map.put(tipo, readFromFile(tipo));
        }
        return map;
    }

    /**
     * Private method used for read from file a list of scores for a specific game modality.
     * 
     * @param gameMode the game modality.
     * 
     * @return the list of scores for the specific game modality.
     */
    private List<HighscoreStructure> readFromFile(final GameType gameMode) {

        final List<HighscoreStructure> itemsSet = new ArrayList<>();
        final String modality = whichMod(gameMode);
        String readString;

        try {
            final FileReader fr = new FileReader(file);
            final BufferedReader br = new BufferedReader(fr);

            readString = br.readLine();
            while (!readString.equals("END_OF_FILE_END_OF_FILE")) {
                readString = br.readLine();
                if (readString.equals(modality)) {
                    readString = br.readLine();
                    while (!readString.equals("END_OF_HIGH_END_OF_HIGH")) {
                        itemsSet.add(generateHighscore(readString, gameMode));
                        readString = br.readLine();
                    }
                }

            }

            br.close();

        } catch (IOException e) {
            System.out.println("ERROR !!! Can't create file...");
            e.printStackTrace();
        }

        return itemsSet;
    }

    /**
     * Private method used for convert the @param gameMode to a String.
     * 
     * @param gameMode the game modality we want to convert.
     * 
     * @return the String for the game modality.
     */
    private String whichMod(final GameType gameMode) {
        switch (gameMode) {
        case BASICMODE:
            return "BASIC_MODE_HIGHSCORES...";
        case SURVIVALMODE:
            return "SURVIVAL_MODE_HIGHSCORES...";
        default:
            return null;
        }
    }

    /**
     * Private method used for generate a {@link HighscoreStructure} for add into a list.
     * 
     * @param stringa line read from file.
     * @param gameMode the game modality.
     * 
     * @return the {@link HighscoreStructure}.
     */
    private HighscoreStructure generateHighscore(final String readString, final GameType gameMode) {
        String name = "", score = "";
        final char space = ' ';
        boolean flag = true;

        for (int i = 0; i < readString.length(); i++) {

            if (!flag) {
                score += readString.charAt(i);
            }

            if (readString.charAt(i) != space && flag) {
                name += readString.charAt(i);
            } else {
                flag = false;
            }
        }

        return new HighscoreStructure(name, Integer.parseInt(score), gameMode);
    }

    /**
     * Private method used for sort a list of {@link HighscoreStructure}.
     * 
     * @param itemsSet a list of {@link HighscoreStructure}.
     */
    private void sort(final List<HighscoreStructure> itemsSet) {
        final Comparator<HighscoreStructure> comp = new Comparator<>() {
            @Override
            public int compare(final HighscoreStructure o1, final HighscoreStructure o2) {
                return o2.getScore() - o1.getScore();
            }
        };
        Collections.sort(itemsSet, comp);
    }

    /**
     * Private method used for clean a list if necessary.
     * 
     * @param itemsSet the list to clean.
     */
    private void clean(final List<HighscoreStructure> itemsSet) {
        for (int i = 0; i < itemsSet.size(); i++) {
            if (i >= CAPACITY) {
                itemsSet.remove(i);
            }
        }
    }

    /**
     * Private method used for re-writing the file with the new modify.
     */
    private void reWriteFile() {
        String stringToWrite;
        try {
            this.file.delete();
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                this.file.createNewFile();
            }

            final FileWriter fw = new FileWriter(this.file);
            final BufferedWriter bw = new BufferedWriter(fw);

            bw.write("HIGHSCORES!!\n\n");
            bw.write("BASIC_MODE_HIGHSCORES...\n");
            for (final HighscoreStructure o : this.mapOfItems.get(GameType.BASICMODE)) {
                stringToWrite = o.getName() + " " + o.getScore() + "\n";
                bw.write(stringToWrite);
            }
            bw.write("END_OF_HIGH_END_OF_HIGH\n\n");
            bw.write("SURVIVAL_MODE_HIGHSCORES...\n");
            for (final HighscoreStructure o : this.mapOfItems.get(GameType.SURVIVALMODE)) {
                stringToWrite = o.getName() + " " + o.getScore() + "\n";
                bw.write(stringToWrite);
            }
            bw.write("END_OF_HIGH_END_OF_HIGH\n\n");
            bw.write("END_OF_FILE_END_OF_FILE");

            bw.flush();
            bw.close();

        } catch (IOException e) {
            System.out.println("Error in re-writing of the file !!!");
            e.printStackTrace();
        }
    }

    /**
     * Method to have a list of scores for a specific game modality.
     * 
     * @param gameMode game modality which we want the scores.
     * @return the scores for a game modality.
     */
    @Override
    public final ObservableList<HighscoreStructure> getHighscoresForModality(final GameType gameMode) {
        final ObservableList<HighscoreStructure> result = FXCollections.observableArrayList();
        this.mapOfItems = readFile();
        if (this.mapOfItems.containsKey(gameMode)) {
            result.addAll(this.mapOfItems.get(gameMode));
        }
        return result;
    }
}
