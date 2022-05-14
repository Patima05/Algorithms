package lesson4;

import lesson4.deque.DoublyLinkedList;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TestMain4 {

    public static void main(String[] args) {
        testHomeWork();
    }

    private static void testHomeWork() {

        SimpleLinkedListImpl<Integer> list = new SimpleLinkedListImpl<>();

        System.out.println("Тестирование метода insert:");
        list.insert(2, 0);
        list.insert(6, 1);
        list.insert(7, 1);
        list.insert(9, 2);

        list.display();

        System.out.println("Тестирование итератора:");
        for (Integer value : list) {
            System.out.println("value: " + value);
        }
        System.out.println("Тестирование Deque:");

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertFirst(7);
        doublyLinkedList.insertFirst(12);
        doublyLinkedList.insertLast(4);
        doublyLinkedList.insertLast(9);
        doublyLinkedList.insertFirst(5);

/*        doublyLinkedList.removeFirst();
        doublyLinkedList.removeLast();
        doublyLinkedList.removeFirst();
        doublyLinkedList.removeLast();
        doublyLinkedList.displayFromHead();*/

        doublyLinkedList.displayFromHead();

        doublyLinkedList.displayFromTail();

    }

}
