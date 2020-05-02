package bubbleshooter.utility;

import javafx.stage.Screen;

public final class Settings {

    private static final double SCREEN_WIDTH = Screen.getPrimary().getBounds().getWidth();
    private static final double SCREEN_HEIGTH = Screen.getPrimary().getBounds().getHeight();
    private static final double GUI_HEIGTH = SCREEN_HEIGTH / 1.52;
    private static final double GUI_WIDTH = SCREEN_WIDTH / 2.72;
    private static final double NUM_BUBBLES = 19;
    private static final double NUM_ROWS = 8;

   private Settings() {
   }

    public static double getNumBubbles() {
        return NUM_BUBBLES;
    }

    public static double getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static double getScreenHeigth() {
        return SCREEN_HEIGTH;
    }

    public static double getGuiHeigth() {
        return GUI_HEIGTH;
    }

    public static double getGuiWidth() {
        return GUI_WIDTH;
    }

    public static double getNumRows() {
        return NUM_ROWS;
    }
}
