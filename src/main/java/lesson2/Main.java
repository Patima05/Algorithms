package lesson2;

public class Main {
    public static void main(String[] args) {
        Products products = new Products();
        products.generate();
        //products.print();
        //products.sortBubble();
        products.sortSelect();
        products.print();

    }
}
 /*1. Отсортировать массив, состоящий из экземпляров класса Notebook в количестве 10000 штук.
         Условия для сортировки:
         1) по цене. От 500 до 2000 долларов с шагом в 50
         если цена равная, то
         2) по кол-ву оперативной памяти (от 4 до 24 с шагом 4)
         если памяти тоже равное количество, то 3) по производителю:
         Lenuvo > Asos > MacNote > Eser > Xamiou

         2(дополнительно). Оптимизировать сортировку выбором, добавив поиск по максимального значения

  */