package lesson4.deque;

public interface Queue<E> {

    boolean insert(E value, int pos);

    boolean remove(E value);

    E peekFront();

    int size();

    boolean isEmpty();

    boolean isFull();
}
