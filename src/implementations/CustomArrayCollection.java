package implementations;

import interfaces.iterable.collection.list.CustomList;

import java.util.Iterator;
import java.util.function.Consumer;

public class CustomArrayCollection<E> implements CustomList<E> {

    private Object[] array;
    private int size = 0;

    public CustomArrayCollection() {
        this.array = new Object[10];
    }

    public CustomArrayCollection(int capacity){
        this.array = new Object[capacity];
    }

    @Override
    public boolean add(E element) {
        grow();
        this.array[size++] = element;
        return true;
    }

    @Override
    public boolean add(int index, E element) throws IllegalStateException {
        if(index < 0){
            throw new IllegalStateException("Negative index not allowed!");
        }
        if(index > this.size){
            throw new IllegalStateException(String.format("Invalid index.Index %d, size : %d",index,this.size));
        }
        grow();
        this.size++;
        for(int i = this.size; i > index;i--){
            this.array[i] = this.array[i - 1];
        }
        this.array[index] = element;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<E> action) {

    }

    private void grow(){
        if(this.size == this.array.length){
            Object[] newArray = new Object[size * 2];
            for(int i = 0; i < this.size;i++){
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }
    }

    private void validateIndex(int index){
    }
}
