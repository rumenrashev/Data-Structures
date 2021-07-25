package interfaces.iterable.collections;

import interfaces.iterable.Iterable;

public interface Collection<E> extends Iterable<E> {

    /**
     * Returns the number of elements in this collection.  If this collection
     * contains more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this collection
     */
    int size();

    /**
     * @return {@code true} if collection does not have elements.
     */
    boolean isEmpty();

    /**
     * @return {@code true} if this collection contains at least one element.
     */
    boolean isNotEmpty();

    /**
     * @return an {@code true} if this collection contains element
     */
    boolean contains(E element);

    /**
     * @return  an array containing all of the elements in this collection;
     */
    E[] toArray();
}
