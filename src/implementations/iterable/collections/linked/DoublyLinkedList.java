package implementations.iterable.collections.linked;

import implementations.iterable.collections.AbstractCollection;
import implementations.iterable.collections.linked.nodes.DoubleNode;
import interfaces.iterable.Iterator;
import interfaces.iterable.collections.Deque;
import interfaces.iterable.collections.Queue;

public class DoublyLinkedList<E> extends AbstractCollection<E> implements Queue<E>, Deque<E> {


    private DoubleNode<E> first;
    private DoubleNode<E> last;


    @Override
    public void addLast(E element) {
        DoubleNode<E> node = new DoubleNode<>(element);
        if(super.size == 0){
            this.last = node;
            this.first = this.last;
        }else if(super.size == 1){
            this.last = node;
            this.first.setNext(this.last);
            this.last.setPrevious(this.first);
        }else {
            node.setPrevious(this.last);
            this.last.setNext(node);
            this.last = node;
        }
        this.size++;
    }

    @Override
    public void addFirst(E element) {
        DoubleNode<E> node = new DoubleNode<>(element);
        if(super.size == 0){
            this.last = node;
            this.first = this.last;
        }else if(super.size == 1){
            this.first = node;
            this.last.setPrevious(this.first);
            this.first.setNext(this.last);
        }else {
            node.setNext(this.first);
            this.first.setPrevious(node);
            this.first = node;
        }
        this.size++;
    }

    @Override
    public E getFirst() {
        ensureNotEmpty();
        return this.first.getElement();
    }

    @Override
    public E removeFirst() {
        E element = getFirst();
        this.first = this.first.getNext();
        if(this.first != null){
            this.first.setPrevious(null);
        }
        if(super.size < 2){
            this.last = this.first;
        }
        super.size--;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private DoubleNode<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.getElement();
                current = current.getNext();
                return element;
            }
        };
    }
}
