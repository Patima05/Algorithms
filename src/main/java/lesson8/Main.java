package lesson8;

public class Main {

    public static void main(String[] args) {

            LinkedHashTable<Product, Integer> hashTable;
            hashTable = new LinkedHashTableImpl<>();//16 (0-15) по дефолтному конструктору

            hashTable.put(new Product(1, "Orange"), 150);//1
            hashTable.put(new Product(77, "Banana"), 100);//13
            hashTable.put(new Product(67, "Carrot"), 228);//3
            hashTable.put(new Product(60, "Lemon"), 250);//12
            hashTable.put(new Product(51, "Milk"), 120);//3
            hashTable.put(new Product(21, "Potato"), 67);//5

            System.out.println("Size is = " + hashTable.size());
            hashTable.display();

            System.out.println("Cost of potato is " + hashTable.get(new Product(21,"Potato")));//Cost of potato is 67
            System.out.println("Cost of banana is " + hashTable.get(new Product(77,"Banana")));//Cost of banana is 100
            System.out.println("Cost of carrot is " + hashTable.get(new Product(67,"Carrot")));//Cost of carrot is 228

            hashTable.remove(new Product(21, "Potato"));
            hashTable.remove(new Product(77, "Banana"));
            hashTable.display();

            System.out.println("Cost of potato is " + hashTable.get(new Product(21,"Potato")));//Cost of potato is null
            System.out.println("Cost of banana is " + hashTable.get(new Product(77,"Banana")));//Cost of banana is null
            System.out.println("Cost of carrot is " + hashTable.get(new Product(67,"Carrot")));//Cost of carrot is 228

            hashTable.put(new Product(1, "Pineapple"), 500);//1

            System.out.println("Size is = " + hashTable.size());
            hashTable.display();
    }
}
