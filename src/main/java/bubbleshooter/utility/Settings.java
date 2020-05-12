package bubbleshooter.utility;

import java.awt.Toolkit;

public final class Settings {

    private static final double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final double GUI_HEIGHT = SCREEN_HEIGHT / 1.60;
    private static final double GUI_WIDTH = SCREEN_WIDTH / 2.72;

    private Settings() {
    }

    public static double getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static double getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public static double getGuiHeight() {
        return GUI_HEIGHT;
    }

    public static double getGuiWidth() {
        return GUI_WIDTH;
    }
}
