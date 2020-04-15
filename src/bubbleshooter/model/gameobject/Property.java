package bubbleshooter.model.gameobject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Property {
    
    RED, GREEN, BLUE, YELLOW, LIGHTBLUE, PURPLE; 
    
    private static final List<Property> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    
    public static Property getRandomColor() {
        return VALUES.get(RANDOM.nextInt(SIZE));  
    }

}
