package iterable.collection;

import java.util.Iterator;

public interface CustomCollection<E> extends Iterator<E> {

    /**
     * @return size of collection
     */
    int size();

}
