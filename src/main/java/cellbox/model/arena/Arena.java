package cellbox.model.arena;

import cellbox.model.arena.util.Loader;
import cellbox.model.arena.util.ThreadComparator;
import cellbox.model.element.Element;
import cellbox.model.element.Movable;
import cellbox.view.ViewLink;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luca on 29.08.17.
 */
public class Arena implements ArenaLink {

    private ObservableList<MovableThread> observableThreads = FXCollections.observableArrayList();
    private List<MovableThread> threads = new SortedList<MovableThread>(observableThreads, new ThreadComparator());
    private List<Element> elements = new ArrayList<>();
    private Loader loader = new Loader();
    private int maxThreads;
    private ViewLink view;

    public Arena(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    public void tick() {
        for (MovableThread mT : threads) {
            mT.run();
        }
    }



    public void populate(int count, Class<Movable> movableClass) {

        for (int i = 0; i < maxThreads; i++) {
            observableThreads.add(new MovableThread(new ArrayList<>()));
        }

        for (int i = 0; i < count; i++) {
            try {
                addMovable(movableClass);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

    }

    private void addMovable(Class<? extends Movable> movableClass) throws IllegalAccessException, InstantiationException {
        Movable m  = movableClass.newInstance();
        elements.add(m);

        System.out.println("Movable added");
        threads.get(0).add(m);
        view.addElement(m);

    }

    @Override
    public void loadClass(File selected) {
        try {
            addMovable(loader.load(selected));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generateCellTemplate(File file) {
        try {
            loader.generateCellTemplate(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void registerView(ViewLink view) {
        this.view = view;
    }

}
