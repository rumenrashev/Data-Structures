package implementations;

import interfaces.Iterator;
import interfaces.Stack;

import java.util.function.Consumer;

public class LinkedStack<E> implements Stack<E> {

    private Node<E> head;
    private int size;

    @Override
    public void push(E element) {
        ensuresNotNull(element);
        Node<E> node = new Node<E>().setElement(element);
        if (this.head != null) {
            node.setNext(this.head);
        }
        this.head = node;
        this.size++;
    }

    @Override
    public E peek() {
        ensuresStackNotEmpty();
        return this.head.getElement();
    }

    @Override
    public E pop() {
        E element = this.peek();
        this.head = this.head.getNext();
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

            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if(current == null ){
                    throw new IllegalStateException("No elements remaining");
                }
                E element = this.current.getElement();
                this.current = this.current.getNext();
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

    private void ensuresNotNull(E element){
        if(element == null){
            throw new NullPointerException("Element cannot be null.");
        }
    }

    private void ensuresStackNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
    }
}
