package lesson4.deque;

public class DoublyLinkedList<E>{

    protected DequeImpl<E> data;

    public DoublyLinkedList() {
        data = new DequeImpl<>();
    }

    public boolean insertFirst(E value) {
        return data.insertFirst(value);
    }


    public boolean insertLast(E value) {
        return data.insertLast(value);
    }

    public E removeFirst() {
        return data.removeFirst();
    }

    public E removeLast() {
        return data.removeLast();
    }

    public int size() {
        return data.size();
    }

    public boolean remove(E value){
        return data.remove(value);
    }

    public void displayFromHead() {
        StringBuilder sb = new StringBuilder("[");

        Deque.Node<E> current = data.first;

        while (current != null) {
            sb.append(current.value);
            if (current.left != null) {
                sb.append(" -> ");
            }
            current = current.left;
        }
        sb.append("]").toString();

        System.out.println(sb);
    }

    public void displayFromTail() {
        StringBuilder sb = new StringBuilder("[");

        Deque.Node<E> current = data.last;

        while (current != null) {
            sb.append(current.value);
            if (current.right != null) {
                sb.append(" -> ");
            }
            current = current.right;
        }
        sb.append("]").toString();

        System.out.println(sb);
    }

}
