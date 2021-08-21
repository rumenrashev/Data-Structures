package interfaces.iterable.collections;

import interfaces.iterable.collections.Collection;

public interface Stack<E> extends Collection<E> {

    /**
     * Adds an item onto the top of this stack.
     * @param   element the item to be pushed onto this stack.
     */
    void addLast(E element);

    /**
     * @return element top element of the Stack
     * @throws  IllegalStateException  if this stack is empty.
     */
    E getLast();

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     * @return element top element of the Stack
     * @throws  IllegalStateException  if this stack is empty.
     */
    E removeLast();

}
