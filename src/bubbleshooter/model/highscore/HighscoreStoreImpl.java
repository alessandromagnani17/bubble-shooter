package bubbleshooter.model.highscore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import com.google.common.collect.ImmutableSortedSet;

import application.HighscoreStructure;
import bubbleshooter.model.gamemodality.GameModality;
import bubbleshooter.model.gamemodality.LevelTypes;

public class HighscoreStoreImpl implements HighscoreStore {

    private static final long serialVersionUID = -3738961252432967724L;
    private static final String FILE_PATH = System.getProperty("user.home") + "/Highscores.txt";
    private final File file;
    private Map<LevelTypes, List<HighscoreStructure>> mapOfItems;
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
    public void addScore(final LevelTypes gameMode, final HighscoreStructure score) {
    	
    	this.mapOfItems = readFile();
    	
    	this.mapOfItems.get(gameMode).add(score);
    	
    	sort(this.mapOfItems.get(gameMode));
    	
    	clean(this.mapOfItems.get(gameMode));
    }
    
    private Map<LevelTypes, List<HighscoreStructure>> readFile() {
        Map<LevelTypes, List<HighscoreStructure>> map = new HashMap<>();
        for(LevelTypes tipo: LevelTypes.values()) {
            map.put(tipo, readFromFile(tipo));
        }
        return map;
    }
    
    private List<HighscoreStructure> readFromFile(LevelTypes gameMode) {
        
        List<HighscoreStructure> itemsSet = new ArrayList<>();
        String modality = whichMod(gameMode);
        String stringaLetta;
        
        try {
            System.out.println("!!! ---> Reading from file ...");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            stringaLetta = br.readLine();
            while(!stringaLetta.equals("END_OF_FILE_END_OF_FILE")) {
                stringaLetta = br.readLine();
                //System.out.println("Stringa letta --> " + stringaLetta);
                if(stringaLetta.equals(modality)) {
                    stringaLetta = br.readLine();
                    while(!stringaLetta.equals("END_OF_HIGH_END_OF_HIGH")) {
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
        switch(gameMode) {
            case BASICMODE: return "BASIC_MODE_HIGHSCORES...";
            case SURVIVALMODE: return "SURVIVAL_MODE_HIGHSCORES...";
        }
        return null;
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
        for(int i = 0; i < itemsSet.size(); i++) {
            if(i >= CAPACITY) itemsSet.remove(i);
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
