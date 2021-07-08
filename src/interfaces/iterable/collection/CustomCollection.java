package interfaces.iterable.collection;

import interfaces.iterable.CustomIterable;

public interface CustomCollection<E> extends CustomIterable<E> {

    /**
     * @return size of collection
     */
    int size();

}
