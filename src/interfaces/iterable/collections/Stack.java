package interfaces.iterable.collections;

import interfaces.iterable.collections.Collection;

public interface Stack<E> extends Collection<E> {

    /**
     * Pushes an item onto the top of this stack.
     * @param   element the item to be pushed onto this stack.
     */
    void push(E element);

    /**
     * @return element top element of the Stack
     * @throws  IllegalStateException  if this stack is empty.
     */
    E peek();

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     * @return element top element of the Stack
     * @throws  IllegalStateException  if this stack is empty.
     */
    E pop();

}
