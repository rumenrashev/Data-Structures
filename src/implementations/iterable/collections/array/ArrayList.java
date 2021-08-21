package implementations.iterable.collections.array;

import implementations.iterable.collections.AbstractCollection;
import interfaces.iterable.Iterator;
import interfaces.iterable.collections.List;
import interfaces.iterable.collections.Stack;

public class ArrayList<E> extends AbstractCollection<E> implements List<E>, Stack<E> {


    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final int DEFAULT_RESIZE_COEFFICIENT = 2;

    private E[] arr;

    public ArrayList() {
        this.arr = createArray(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int capacity) {
        this.arr = createArray(capacity);
    }

    @Override
    public void add(E element) {
        grow();
        arr[size++] = element;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        grow();
        size++;
        for(int i = size -1; i > index; i--){
            this.arr[i] = this.arr[i - 1];
        }
        this.arr[index] = element;
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);
        this.arr[index] = element;
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if(index == -1){
            return false;
        }
        removeAt(index);
        return true;
    }

    @Override
    public E removeAt(int index) {
        checkIndex(index);
        E element = arr[index];
        for(int i = index; i < size -1; i++){
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public int indexOf(E element) {
        for(int i = 0; i < size; i++){
            if(arr[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if(arr[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addLast(E element) {
        add(element);
    }

    @Override
    public E getLast() {
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return arr[size - 1];
    }

    @Override
    public E removeLast() {
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return removeAt(size - 1);
    }

    @Override
    public Iterator<E> iterator() {
        System.out.println(this instanceof Stack);
        return new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                return arr[currentIndex++];
            }
        };
    }

    private void grow() {
        if (this.size == this.arr.length - 1) {
            E[] newArr = createArray(this.arr.length * DEFAULT_RESIZE_COEFFICIENT);
            for(int i = 0; i < size; i++){
                newArr[i] = this.arr[i];
            }
            this.arr = newArr;
        }
    }

    private E[] createArray(int capacity){
        return (E[]) new Object[capacity];
    }

    private void checkIndex(int index){
        if(index < 0 || index == this.size){
            throw new IndexOutOfBoundsException(
                    String.format("Index %d , size : %d",index,size));
        }
    }

}
