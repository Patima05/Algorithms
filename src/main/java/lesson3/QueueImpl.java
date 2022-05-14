package lesson3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class QueueImpl<E> implements Queue2<E> {
    private final E[] data;
    private int size;
    private int head;
    private int tail;

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        tail = -1;
        head = 0;
        size = 0;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()){
            return false;
        }

        if (tail == data.length - 1){
            tail = 0;
        } else {
            tail++;
        }
        data[tail] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        E value = data[head];
        data[head] = null;
        if (head == data.length - 1) {
            head = 0;
        }else {
            head++;
        }
        size--;
        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        int k = 0;
        while (k < size){
            if (k + head < data.length) {
                sb.append(data[k + head]);
            }else{
                sb.append(data[k + head - data.length]);
            }

            if (k != size - 1) {
                sb.append(", ");
            }
            k++;
        }

        return sb.append("]").toString();
    }

}