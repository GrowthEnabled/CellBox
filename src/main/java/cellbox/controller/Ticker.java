package cellbox.controller;

import cellbox.model.arena.Arena;
import cellbox.model.arena.ArenaLink;

import java.util.TimerTask;

/**
 * Timer task runs with every timer tick.
 */
public class Ticker extends TimerTask {

    private ArenaLink arena;
    long numTicks = 0;
    Thread arenaThread;
    Thread viewThread;

    public Ticker(Arena arena) {
        this.arena = arena;
    }

    @Override
    public void run() {
        arena.tick();
    }

}
