package lesson4;

public interface LinkedList<E>  {

    boolean insertFirst(E value);

    E removeFirst();

    boolean insert(E value, int pos);

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    class Node<E> {
        protected E value;
        protected Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

}
