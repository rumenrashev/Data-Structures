package implementations.iterable.collections.linked;

import implementations.iterable.collections.AbstractCollection;
import implementations.iterable.collections.linked.nodes.SingleNode;
import interfaces.iterable.Iterator;
import interfaces.iterable.collections.Stack;

public class SinglyLinkedList<E> extends AbstractCollection<E> implements Stack<E> {

    private SingleNode<E> last;

    @Override
    public void addLast(E element) {
        SingleNode<E> node = new SingleNode<>(element);
        if(super.size != 0){
            node.setPrevious(this.last);
        }
        this.last = node;
        super.size++;
    }

    @Override
    public E getLast() {
        ensureNotEmpty();
        return this.last.getElement();
    }

    @Override
    public E removeLast() {
        E element = getLast();
        this.last = last.getPrevious();
        super.size--;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private SingleNode<E> current = last;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.getElement();
                current = current.getPrevious();
                return element;
            }
        };
    }
}
