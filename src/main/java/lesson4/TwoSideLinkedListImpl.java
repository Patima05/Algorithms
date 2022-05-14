package lesson4;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E>{

    protected Node<E> last;

    @Override
    public boolean insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            last = first;
        }
        return false;
    }

    @Override
    public boolean insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return true;
        }
        last.next = last = new Node<>(value, null);
        return true;
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();

        if (isEmpty()) {
            last = null;
        }

        return removedValue;
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
        if (current == last) {
            last = prev;
            last.next = null;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public E getLast() {
        return last.value;
    }
}
