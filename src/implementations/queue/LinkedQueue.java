package implementations.queue;

import interfaces.Iterator;
import interfaces.Queue;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedQueue<E> implements Queue<E> {

    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public void push(E element) {
        Node<E> node = new Node<E>(element);
        if(size == 0){
            this.first = node;
        }else if(size == 1){
            this.last = node;
            this.first.next = this.last;
        }else {
            this.last.next = node;
            this.last = node;
        }
        this.size++;
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
        this.size--;
        return element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(E element) {
        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext()){
            E next = iterator.next();
            if(next.equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int ind = 0;
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()){
            arr[ind++] = iterator.next();
        }
        return arr;
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
                try {
                    E element = current.element;
                    current = current.next;
                    return element;
                }catch (NullPointerException e){
                    throw new NoSuchElementException("Iterator does not have next");
                }
            }
        };
    }

    @Override
    public void forEach(Consumer<E> action) {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()){
            action.accept(iterator.next());
        }
    }

    private void ensureNotEmpty(){
        if(this.size == 0){
            throw new IllegalArgumentException("Queue is empty");
        }
    }
}
