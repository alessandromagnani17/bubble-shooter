package bubbleshooter.view.images;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Color {

    /**
     * Ball color blue.
     */
    BLUE("/view/bubbles/blue.png"),
    /**
     * Ball color red.
     */
    RED("/view/bubbles/red.png"),
    /**
     * Ball color green.
     */
    GREEN("/view/bubbles/green.png"),
    /**
     * Ball color yellow.
     */
    //YELLOW("/view/bubbles/yellow.png"),
    /**
     * Ball color bordeaux.
     */
    //BORDEAUX("/view/bubbles/bordeaux.png"),
    /**
     * Ball color light blue.
     */
    //LIGHTBLUE("/view/bubbles/lightblue.png"),
    /**
     * Ball color purple.
     */
    //PURPLE("/view/bubbles/purple.png"),
    /**
     * Ball color orange.
     */
    ORANGE("/view/bubbles/orange.png");

    private static final List<Color> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    private final String bubblePath;

    Color(final String bubblePath) {
        this.bubblePath = bubblePath;
       }

    /**
     * 
     * @return A random {@link BallColors} color.
     */
    
    public static Color getRandomColor() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    /**
     * 
     * @return the ball image path.
     */
    public String getBallPath() {
        return this.bubblePath;
    }
    
}
