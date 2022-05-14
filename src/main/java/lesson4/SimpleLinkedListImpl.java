package lesson4;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected Node<E> first;
    protected int size;

    public boolean insertFirst(E value) {
        if (size == 0) {
            first = new Node<>(value, null);
            size++;
            return true;
        }
        return false;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;

        return removedNode.value;
    }

    @Override
    public boolean insert(E value, int pos) {

        if (pos > size) {
            return false;
        }

        Node<E> current = first;
        Node<E> prev = null;

        if (pos == 0) {
            insertFirst(value);
            return true;
        }

        if (pos == 1) {

            Node<E> newNode = new Node<>(value, current.next);
            current.next = newNode;
            size++;
            return true;
        }

        int i = 1;
            while (current.next != null && pos != i) {
                prev = current;
                current = current.next;
                i++;
            }

            Node<E> newNode = new Node<>(value, current.next);
            current.next = newNode;
            size++;

            return true;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != null;
    }

    private Node<E> indexOf(E value) {
        Node<E> current = first;

        while (current != null) {
            if (current.value.equals(value)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    @Override
    public boolean remove(E value) {

        Node<E> prev = null;
        Node<E> current = first;

        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == first) {
            removeFirst();
            return true;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
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
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node<E> current = first;

        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();

    }

    @Override
    public E getFirst() {
        return first.value;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iter = new Iterator<E>() {

            private Node<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value;
                value = current.value;
                current = current.next;
                return value;
            }
        };

        //reset()
        return iter;
    }
}
