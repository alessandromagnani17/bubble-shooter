package bubbleshooter.model.gameobject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum BubbleColor {
	
	RED, YELLOW, GREEN, LIGHT_BLUE, BLUE, PURPLE; 
	
	
	private static final List<BubbleColor> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    
    public static BubbleColor getRandomColor() {
        return VALUES.get(RANDOM.nextInt(SIZE));  
    }
	
}
