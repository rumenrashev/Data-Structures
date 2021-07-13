package implementations;

import interfaces.Iterator;
import interfaces.Stack;

import java.util.function.Consumer;

public class ArrayStack<E> implements Stack<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final int DEFAULT_RESIZE_COEFFICIENT = 2;
    private static final int DEFAULT_INITIAL_SIZE = 0;

    private E[] arr;
    private int size;

    public ArrayStack() {
        this.arr = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        this.size = DEFAULT_INITIAL_SIZE;
    }

    @Override
    public void push(E element) {
        ensuresNotNull(element);
        grow();
        this.arr[this.size++] = element;
    }

    @Override
    public E peek() {
        ensuresStackNotEmpty();
        return this.arr[size - 1];
    }

    @Override
    public E pop() {
        E element = this.peek();
        this.arr[--this.size] = null;
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
        for(int i = 0; i < this.size; i++){
            if(this.arr[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arrToReturn = new Object[this.size];
        for(int i = 0; i < this.size; i++){
            arrToReturn[i] = this.arr[i];
        }
        return arrToReturn;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int current = size - 1;

            @Override
            public boolean hasNext() {
                return current > 0;
            }

            @Override
            public E next() {
                if(current < 0 ){
                    throw new IllegalStateException("No elements remaining");
                }
                return arr[current--];
            }
        };
    }

    @Override
    public void forEach(Consumer<E> action) {
        for(int i = 0; i < this.size; i++){
            action.accept(this.arr[i]);
        }
    }

    private void grow(){
        if(this.size == this.arr.length - 1) {
            E[] newArr = (E[]) new Object[this.arr.length * DEFAULT_RESIZE_COEFFICIENT];
            for (int i = 0; i < this.size; i++) {
                newArr[i] = arr[i];
            }
            this.arr = newArr;
        }
    }

    private void ensuresNotNull(E element){
        if(element == null){
            throw new NullPointerException("Element cannot be null.");
        }
    }

    private void ensuresStackNotEmpty(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty!");
        }
    }
}
