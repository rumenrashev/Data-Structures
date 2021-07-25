package implementations.iterable.collections.array;

import interfaces.iterable.Iterator;
import interfaces.iterable.collections.Stack;

import java.util.NoSuchElementException;

public class ArrayStack<E> extends AbstractArrayCollection<E> implements Stack<E> {

    @Override
    public void push(E element) {
        ensureNotNull(element);
        grow();
        arr[size++] = element;
    }

    @Override
    public E peek() {
        ensureNotEmpty();
        return arr[size - 1];
    }

    @Override
    public E pop() {
        E element = this.peek();
        arr[--size] = null;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int current = size - 1;

            @Override
            public boolean hasNext() {
                return current >= 0;
            }

            @Override
            public E next() {
                if (current < 0) {
                    throw new NoSuchElementException("Stack does not have next.");
                }
                return arr[current--];
            }
        };
    }
}
