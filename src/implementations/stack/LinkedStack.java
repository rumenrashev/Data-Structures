package implementations.stack;

import interfaces.Iterator;
import interfaces.Stack;

import java.util.function.Consumer;

public class LinkedStack<E> implements Stack<E> {

    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node<E> last;
    private int size;

    @Override
    public void push(E element) {
        if(element == null){
            throw new NullPointerException("Element cannot be null.");
        }
        Node<E> node = new Node<>(element);
        if (this.last != null) {
            node.next = this.last;
        }
        this.last = node;
        this.size++;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return this.last.element;
    }

    @Override
    public E pop() {
        E element = this.peek();
        this.last = this.last.next;
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
            if(iterator.next().equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arrToReturn = new Object[size];
        Iterator<E> iterator = this.iterator();
        int count = 0;
        while (iterator.hasNext()){
            arrToReturn[count++] = iterator.next();
        }
        return arrToReturn;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = last;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if(current == null ){
                    throw new IllegalStateException("No elements remaining");
                }
                E element = this.current.element;
                this.current = this.current.next;
                return element;
            }
        };
    }

    @Override
    public void forEach(Consumer<E> action) {
        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext()){
            action.accept(iterator.next());
        }
    }
}
