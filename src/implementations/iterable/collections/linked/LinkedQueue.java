package implementations.iterable.collections.linked;

import interfaces.iterable.Iterator;
import interfaces.iterable.collections.Queue;

import java.util.NoSuchElementException;

public class LinkedQueue<E> extends AbstractSinglyLinkedCollection<E> implements Queue<E> {

    public Node<E> first;
    private Node<E> last;

    @Override
    public void push(E element) {
        ensureNotNull(element);
        Node<E> node = new Node<E>(element);
        if (size == 0) {
            first = node;
        } else if (size == 1) {
            last = node;
            first.next = last;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public E peek() {
        ensureNotEmpty();
        return first.element;
    }

    @Override
    public E poll() {
        ensureNotEmpty();
        E element = this.peek();
        first = first.next;
        size--;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if(!hasNext())
                    throw new NoSuchElementException("Iterator does not have next");
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
