package lesson4.deque;

import lesson4.LinkedList;

public interface Deque<E> extends Queue<E> {

    boolean insertLast(E value);
    boolean insertFirst(E value);

    E removeLast();
    E removeFirst();

    class Node<E> {
        protected E value;
        protected Node<E> right;
        protected Node<E> left;

        public Node(E value, Node<E> right, Node<E> left) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}