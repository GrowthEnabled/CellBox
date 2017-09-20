package cellbox.controller;

import cellbox.Manager;
import cellbox.model.arena.Arena;
import cellbox.model.element.Movable;
import cellbox.view.ViewLink;

import java.io.File;
import java.util.Timer;

/**
 * Created by luca on 13.08.17.
 */
public class Controller implements ConLink {

    private Timer time = new Timer();
    private Arena arena;
    private ViewLink view;

    public Controller(Arena arena) {
        this.arena = arena;
    }

    public void init() {
        arena.populate(1, Movable.class);
        //arena.init();
        //view.show();
    }

    public void start() {
        time = new Timer();
        time.scheduleAtFixedRate(new Ticker(arena), 0, Manager.getTimerSpeed());
    }

    public void stop() {
        time.cancel();
    }

    public void registerView(ViewLink view) {
        this.view = view;
        arena.registerView(view);
    }

    public void setTimerSpeed(long speed) {
        time.scheduleAtFixedRate(new Ticker(arena), 0, speed);
    }

    @Override
    public void importClass(File file) {
        arena.loadClass(file);
    }

    @Override
    public void generateTemplate(File file) {
        arena.generateCellTemplate(file);
    }


}
