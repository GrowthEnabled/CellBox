package cellbox.model.arena.util;

import cellbox.model.arena.MovableThread;

import java.util.Comparator;

/**
 * Created by luca on 19.09.17.
 */
public class ThreadComparator implements Comparator<MovableThread> {
    @Override
    public int compare(MovableThread mT_1, MovableThread mT_2) {
        if (mT_1.getCount() < mT_2.getCount())
            return -1;
        else if (mT_1.getCount() == mT_2.getCount())
            return 0;
        else
            return 1;
    }
}
