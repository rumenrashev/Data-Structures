package interfaces.iterable.collection.list;

import interfaces.iterable.collection.CustomCollection;

public interface CustomList<E> extends CustomCollection<E> {

    /**
     * @param element
     * add element in the last place of collection
     * @return true if adding is successful
     */
    boolean add(E element);

    /**
     * @param index
     * @param element
     * @return true if adding is successful
     * @throws IllegalStateException
     * if the index is lower than zero or bigger than size.
     */
    boolean add(int index, E element) throws IllegalStateException;


}
