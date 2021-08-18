package implementations.iterable.collections.linked;

import implementations.iterable.collections.AbstractCollection;
import interfaces.iterable.Iterator;

public class SinglyLinkedList<E> extends AbstractCollection<E> {

     protected static class Node<E> {
        public E element;
        public Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    protected Node<E> top;

    public void addLast(E element){
        ensureNotNull(element);
        Node<E> node = new Node<>(element);
        if (super.size != 0) {
            node.next = this.top;
        }
        this.top = node;
        super.size++;
    }

    public E getLast(){
        ensureNotEmpty();
        return top.element;
    }

    public E removeLast(){
        E element = getLast();
        this.top = this.top.next;
        super.size--;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }





}
