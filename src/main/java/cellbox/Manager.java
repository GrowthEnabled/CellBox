package cellbox;

/**
 * Manager of all settings.
 */

public class Manager {

    private static final int EAT_DURATION = 100;
    private static final int LAYING_EGGS_DURATION = 100;
    private static final long TIMER_SPEED = 10;
    private static final long SCREEN_WIDTH = 900;
    private static final long SCREEN_HEIGHT = 600;
    private static final long SHOWGROUND_WIDTH = 900;
    private static final long SHOWGROUND_HEIGHT = 500;
    private static final double CELL_MAX_SPEED = 1.0;
    private static final double CELL_MAX_ACCELLERATION = 0.2;
    private static final double NUT_DECAY_ON_IMPULSE = 0.8;
    private static final double NUT_DECAY_OVER_TIME = 0.1;

    private static Manager ourInstance = new Manager();
    public static Manager getInstance() {
        return ourInstance;
    }

    public static int getEatDuration() {
        return EAT_DURATION;
    }

    public static int getLayingEggsDuration() {
        return LAYING_EGGS_DURATION;
    }

    public static long getTimerSpeed() {
        return TIMER_SPEED;
    }

    public static long getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static long getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public static long getShowgroundWidth() {
        return SHOWGROUND_WIDTH;
    }

    public static long getShowgroundHeight() {
        return SHOWGROUND_HEIGHT;
    }

    public static double getCellMaxSpeed() {
        return CELL_MAX_SPEED;
    }

    public static double getCellMaxAccelleration() {
        return CELL_MAX_ACCELLERATION;
    }

    public static double getNutDecayOnImpulse() {
        return NUT_DECAY_ON_IMPULSE;
    }

    public static double getNutDecayOverTime() {
        return NUT_DECAY_OVER_TIME;
    }

    public static Manager getOurInstance() {
        return ourInstance;
    }
}
