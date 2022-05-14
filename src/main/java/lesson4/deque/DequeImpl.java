package lesson4.deque;

import lesson4.LinkedList;

public class DequeImpl<E> implements Deque<E> {

    protected Node<E> first;
    protected Node<E> last;
    protected int size;

    @Override
    public boolean insertLast(E value) {
        if (isEmpty()) {
            last = first = new Node<E>(value, null, null);
            size++;
            return true;
        }
        if (size == 1) {
            last = new Node<E>(value, first, null);
            first.left = last;
            size++;
            return true;
        }
        Node<E> temp = last;
        last = new Node<E>(value, last, null);
        temp.left = last;
        size++;
        return true;
    }

    @Override
    public boolean insertFirst(E value) {
        if (isEmpty()) {
            last = first = new Node<E>(value, null, null);
            size++;
            return true;
        }
        if (size == 1) {
            first = new Node<E>(value, null, last);
            last.right = first;
            size++;
            return true;
        }
        Node<E> temp = first;
        first = new Node<E>(value, null, first);
        temp.right = first;
        size++;
        return true;
    }

    @Override
    public E removeLast() {
        if (isEmpty()){
            return null;
        }
        E value = last.value;
        if (size == 1){
            last = null;
            first = null;
            size--;
            return value;
        }
        if (size == 2){
            last.right = null;
            first.left = null;
            last = first;
            size--;
            return value;
        }
        last = last.right;
        last.left = null;
        size--;
        return value;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()){
            return null;
        }
        E value = first.value;
        if (size == 1){
            last = null;
            first = null;
            size--;
            return value;
        }
        if (size == 2){
            last.right = null;
            first.left = null;
            first = last;
            size--;
            return value;
        }

        first = first.left;
        first.right = null;
        size--;
        return value;
    }

    @Override
    public boolean insert(E value, int pos) {
        return false;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;

        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }

            current = current.left;
        }

        if (current == null) {
            return false;
        }

        if (current == first) {
            removeFirst();
            return true;
        }
        if (current == last) {
            removeLast();
            return true;
        }

        Node<E> temp = current.right;
        current.right = current.left;
        current.left = temp;

        size--;
        return false;
    }

    @Override
    public E peekFront() {
        return null;
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
        return false;
    }

    @Override
    public String toString() {
        return first.value.toString();
    }
}
