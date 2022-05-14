package lesson2;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Products {

    private static final int SIZE = 10000;
    private ArrayList<NoteBook> noteBooks;

    public Products() {
        noteBooks = new ArrayList<>(SIZE);
    }

    public void generate(){
        for (int i = 0; i < SIZE; i++) {
            int cost = from50to2000();
            int ram = randRam();
            String product = randProduct();
            NoteBook nBook = new NoteBook(cost, ram, product);
            noteBooks.add(nBook);
        }
    }

    String randProduct() {
        Random r = new Random();
        HashMap<Integer, String> prList = new HashMap<>();
        prList = NoteBook.getProductList();
        int randIdx = r.nextInt(5);
        return prList.get(randIdx);
    }

    private int randRam() {
        Random r = new Random();
        return r.nextInt(6) * 4 + 4;
    }

    private int from50to2000() {
        Random r = new Random();
        return r.nextInt(31) * 50 + 500;
    }

    public void sortBubble() {
        boolean isChange;
        int limit = noteBooks.size();

        do {
            limit --;
            isChange = false;
            for (int i = 0; i < limit; i++) {
                if (noteBooks.get(i).compareTo(noteBooks.get(i+1)) == 1) {
                    swap(i, i+1);
                    isChange = true;
                }
            }
        } while (isChange);
    }

    public void sortSelect(){
        int out, in, mark;
        for(out=0;out<noteBooks.size();out++){
            mark = out;
            for(in = out+1;in<noteBooks.size();in++){
                if (noteBooks.get(in).compareTo(noteBooks.get(mark)) == -1) {
                    mark = in;
                }
            }
            swap(out, mark);
        }
    }

    public void swap(int left, int right) {
        if (left != right) {
            NoteBook temp = noteBooks.get(left);
            noteBooks.set(left, noteBooks.get(right));
            noteBooks.set(right, temp);
        }
    }

    public void print(){
        int i = 0;
        for (NoteBook x : noteBooks) {
            i++;
            System.out.println(i + ") цена: " + x.getCost() + ", ОЗУ: " + x.getRam() + ", производитель: " + x.getProduct());
        }
    }
}
