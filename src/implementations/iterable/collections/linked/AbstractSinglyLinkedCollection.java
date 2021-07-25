package implementations.iterable.collections.linked;

import implementations.iterable.collections.AbstractCollection;

public abstract class AbstractSinglyLinkedCollection<E> extends AbstractCollection<E> {

    protected static class Node<E> {
        public E element;
        public Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

}
