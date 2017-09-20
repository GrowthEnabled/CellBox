package cellbox.controller;

import java.io.File;

/**
 * Created by luca on 29.08.17.
 */
public interface ConLink {
    void start();
    void stop();
    void setTimerSpeed(long speed);
    void importClass(File file);
    void generateTemplate(File file);
}
