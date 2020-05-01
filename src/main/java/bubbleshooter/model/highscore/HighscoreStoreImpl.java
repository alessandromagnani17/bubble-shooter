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

public class HighscoreStoreImpl implements HighscoreStore {

	private static final long serialVersionUID = -3738961252432967724L;
	private static final String SEP = System.getProperty("file.separator");
	private static final String DIR_PATH = System.getProperty("user.home") + SEP + ".Bubbleshooter";
	private static final String FILE_PATH = SEP + "Highscores.txt";
	private final File file;
	private Map<LevelTypes, List<HighscoreStructure>> mapOfItems;
	private final static int CAPACITY = 10;
	private boolean flag;

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

	@Override
	public File getFile() {
		return this.file;
	}

	@Override
	public void addScore(final HighscoreStructure score) {

		this.mapOfItems = readFile();

		this.mapOfItems.get(score.getGameMode()).add(score);

		sort(this.mapOfItems.get(score.getGameMode()));

		clean(this.mapOfItems.get(score.getGameMode()));

		reWriteFile();
	}

	private Map<LevelTypes, List<HighscoreStructure>> readFile() {
		Map<LevelTypes, List<HighscoreStructure>> map = new HashMap<>();
		for (LevelTypes tipo : LevelTypes.values()) {
			map.put(tipo, readFromFile(tipo));
		}
		return map;
	}

	private List<HighscoreStructure> readFromFile(LevelTypes gameMode) {

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

	private String whichMod(LevelTypes gameMode) {
		switch (gameMode) {
		case BASICMODE:
			return "BASIC_MODE_HIGHSCORES...";
		case SURVIVALMODE:
			return "SURVIVAL_MODE_HIGHSCORES...";
		}
		return null;
	}

	private HighscoreStructure generateHighscore(String stringa, LevelTypes gameMode) {
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

	private void sort(List<HighscoreStructure> itemsSet) {
		Comparator<HighscoreStructure> comp = new Comparator<>() {
			@Override
			public int compare(HighscoreStructure o1, HighscoreStructure o2) {
				return o2.getScore() - o1.getScore();
			}
		};
		Collections.sort(itemsSet, comp);
	}

	private void clean(List<HighscoreStructure> itemsSet) {
		for (int i = 0; i < itemsSet.size(); i++) {
			if (i >= CAPACITY)
				itemsSet.remove(i);
		}
	}

	private void reWriteFile() {
		String appoggio;
		try {
			this.file.delete();
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			if (!file.exists())
				this.file.createNewFile();

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

	@Override
	public ObservableList<HighscoreStructure> getHighscoresForModality(final LevelTypes gameMode) {
		ObservableList<HighscoreStructure> result = FXCollections.observableArrayList();
		this.mapOfItems = readFile();
		if (this.mapOfItems.containsKey(gameMode)) {
			result.addAll(this.mapOfItems.get(gameMode));
		}
		return result;
	}
}
