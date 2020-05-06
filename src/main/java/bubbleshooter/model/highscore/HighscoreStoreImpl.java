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
import bubbleshooter.model.gamemodality.LevelTypes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class used for save and read all the scores from a file.
 * Implements the {@link HighscoreStore} interface.
 *
 */
public class HighscoreStoreImpl implements HighscoreStore {

    private static final long serialVersionUID = -3738961252432967724L;
    private static final String SEP = System.getProperty("file.separator");
    private static final String DIR_PATH = System.getProperty("user.home") + SEP + ".Bubbleshooter";
    private static final String FILE_PATH = SEP + "Highscores.txt";
    private final File file;
    private Map<LevelTypes, List<HighscoreStructure>> mapOfItems;
    private static final int CAPACITY = 10;
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
				System.out.println("-------->File creato");
				flag = true;
			} else {
				System.out.println("-------->File già esistente");
				flag = false;
			}
			if (flag) {
				FileWriter fw = new FileWriter(this.file);
				BufferedWriter bw = new BufferedWriter(fw);

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
     * Method for add a score for a game modality
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
	private Map<LevelTypes, List<HighscoreStructure>> readFile() {
		Map<LevelTypes, List<HighscoreStructure>> map = new HashMap<>();
		for (LevelTypes tipo : LevelTypes.values()) {
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
	private List<HighscoreStructure> readFromFile(final LevelTypes gameMode) {

		List<HighscoreStructure> itemsSet = new ArrayList<>();
		String modality = whichMod(gameMode);
		String stringaLetta;

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			stringaLetta = br.readLine();
			while (!stringaLetta.equals("END_OF_FILE_END_OF_FILE")) {
				stringaLetta = br.readLine();
				if (stringaLetta.equals(modality)) {
					stringaLetta = br.readLine();
					while (!stringaLetta.equals("END_OF_HIGH_END_OF_HIGH")) {
						itemsSet.add(generateHighscore(stringaLetta, gameMode));
						stringaLetta = br.readLine();
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
	private String whichMod(final LevelTypes gameMode) {
		switch (gameMode) {
		case BASICMODE:
			return "BASIC_MODE_HIGHSCORES...";
		case SURVIVALMODE:
			return "SURVIVAL_MODE_HIGHSCORES...";
		default:
			break;
		}
		return null;
	}

    /**
     * Private method used for generate a {@link HighscoreStructure} for add into a list.
     * 
     * @param stringa line read from file.
     * @param gameMode the game modality.
     * 
     * @return the {@link HighscoreStructure}.
     */
	private HighscoreStructure generateHighscore(final String stringa, final LevelTypes gameMode) {
		String name = "", score = "";
		char spazio = ' ';
		boolean flag = true;

		for (int i = 0; i < stringa.length(); i++) {

			if (!flag) {
				score = score + stringa.charAt(i);
			}

			if (!(stringa.charAt(i) == spazio) && flag) {
				name = name + stringa.charAt(i);
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
		Comparator<HighscoreStructure> comp = new Comparator<>() {
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
		String appoggio;
		try {
			this.file.delete();
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			if (!file.exists()) {
				this.file.createNewFile();
			}

			FileWriter fw = new FileWriter(this.file);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("HIGHSCORES!!\n\n");
			bw.write("BASIC_MODE_HIGHSCORES...\n");
			for (HighscoreStructure o : this.mapOfItems.get(LevelTypes.BASICMODE)) {
				appoggio = o.getName() + " " + String.valueOf(o.getScore()) + "\n";
				bw.write(appoggio);
			}
			bw.write("END_OF_HIGH_END_OF_HIGH\n\n");
			bw.write("SURVIVAL_MODE_HIGHSCORES...\n");
			for (HighscoreStructure o : this.mapOfItems.get(LevelTypes.SURVIVALMODE)) {
				appoggio = o.getName() + " " + String.valueOf(o.getScore()) + "\n";
				bw.write(appoggio);
			}
			bw.write("END_OF_HIGH_END_OF_HIGH\n\n");
			bw.write("END_OF_FILE_END_OF_FILE");

			bw.flush();
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	public final ObservableList<HighscoreStructure> getHighscoresForModality(final LevelTypes gameMode) {
		ObservableList<HighscoreStructure> result = FXCollections.observableArrayList();
		this.mapOfItems = readFile();
		if (this.mapOfItems.containsKey(gameMode)) {
			result.addAll(this.mapOfItems.get(gameMode));
		}
		return result;
	}
}
