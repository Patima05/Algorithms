package lesson4.lesson3;

public class Main {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20};
        Integer i = 0;
        System.out.println("         Задание 1");
        System.out.println("Пропущенное число в массиве: " + findSkippedElement(arr));

        System.out.println("         Задание 2");
        QueueImpl<Integer> queue = new QueueImpl<>(8);

        queue.insert(5);
        queue.insert(10);
        queue.insert(1);
        queue.insert(7);
        queue.insert(6);

        queue.display();

        System.out.println("Извлечение элемента из очереди: " + queue.remove());
        System.out.println("Извлечение элемента из очереди: " + queue.remove());
        System.out.println("Извлечение элемента из очереди: " + queue.remove());
        System.out.println("Извлечение элемента из очереди: " + queue.remove());

        queue.display();

        queue.insert(55);
        queue.insert(105);
        queue.insert(15);
        queue.insert(75);
        queue.insert(35);
        queue.insert(25);
        queue.insert(65);
        queue.insert(5);
        queue.insert(85);

        queue.display();

    }

    private static int findSkippedElement(int[] arr) {
        int start = 0;
        int end = (arr.length - 1);
        int base = end / 2;

        while (start <= base){
            if (arr[base] == base + 1){
                start = base + 1;
                base = (start + end) / 2;
            } else {
                end = base - 1;
                base = (start + end) / 2;
            }
        }
        return base + 2;
    }

}
