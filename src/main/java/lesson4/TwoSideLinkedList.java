package lesson4;

public interface TwoSideLinkedList<E>  extends LinkedList<E> {

    boolean insertLast(E value);

    E getLast();
}
