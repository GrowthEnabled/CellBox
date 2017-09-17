package cellbox.controller;

import cellbox.model.arena.Arena;
import cellbox.model.element.Movable;
import cellbox.view.ViewLink;

import java.util.Timer;

/**
 * Created by luca on 13.08.17.
 */
public class Controller implements ConLink {

    private Timer time;
    private Arena arena;
    private ViewLink view;

    public Controller(Arena arena) {
        this.arena = arena;
    }

    public void start() {
        arena.populate(1, Movable.class);
        //arena.init();
        //view.show();
        init();
    }

    private void init() {
        time = new Timer();
        time.scheduleAtFixedRate(new Ticker(arena), 0, 10);
    }

    public void registerView(ViewLink view) {
        this.view = view;
        arena.registerView(view);
    }

    public void setTimerSpeed(long speed) {
        time.scheduleAtFixedRate(new Ticker(arena), 0, speed);
    }
}
