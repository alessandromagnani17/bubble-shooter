package bubbleshooter.utility;

import javafx.geometry.Point2D;

public class Utility {

    private static final double ROWS = 8;

    private static final double ROW_BUBBLE = 19;

    private static final double RADIUS = 17;

    private static final double BUBBLE_WIDTH = 36;

    private static final double GUI_WIDTH = 705;

    private static final double GUI_HEIGTH = 700;

    private static final double BUBBLE_SPEED = 0.55;

    private static final double OFFSET = 5;

    private static double COLLISIONDISTANCE = BUBBLE_WIDTH - OFFSET;

    private static double DIAGONALDISTANCE = BUBBLE_WIDTH + OFFSET;

    private static final int FPS = 60;

    private static final int SECONDS = 1000;

    private static final double GAMEOVER_LINE = 600;

    private static final Point2D SHOOTINGBUBBLEPOS = new Point2D(GUI_WIDTH / 2, GAMEOVER_LINE);
    
    private static final Point2D CANNONPOS = new Point2D(GUI_WIDTH / 2, GAMEOVER_LINE);
    
    public static Point2D getShootingBubblePos() {
		return SHOOTINGBUBBLEPOS;
	}

	public static Point2D getCannonpos() {
		return CANNONPOS;
	}

	public static double getCollisionDistance() {
        return COLLISIONDISTANCE;
    }

	public static double getDiagonalDistance() {
		return DIAGONALDISTANCE;
	}

	public static double getRows() {
		return ROWS;
	}

	public static double getRowBubble() {
		return ROW_BUBBLE;
	}

	public static double getRadius() {
		return RADIUS;
	}

	public static double getBubbleWidth() {
		return BUBBLE_WIDTH;
	}

	public static double getGuiWidth() {
		return GUI_WIDTH;
	}

	public static double getGuiHeigth() {
		return GUI_HEIGTH;
	}

	public static double getBubbleSpeed() {
		return BUBBLE_SPEED;
	}

	public static double getOffset() {
		return OFFSET;
	}

	public static int getFPS() {
		return FPS;
	}

	public static int getSeconds() {
		return SECONDS;
	}

	public static double getGameoverLine() {
		return GAMEOVER_LINE;
	}

}
