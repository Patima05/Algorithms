package lesson2;

import com.sun.jdi.Value;

import java.security.KeyStore;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class NoteBook implements Comparable<NoteBook> {
    private int cost;
    private int ram;
    private String product;
    private static HashMap<Integer, String> productList = new HashMap<>();

    public static HashMap<Integer, String> getProductList() {
        return productList;
    }

    public NoteBook(int cost, int ram, String product) {
        this.cost = cost;
        this.ram = ram;
        this.product = product;
        productList.put(0,"Lenuvo");
        productList.put(1,"Asos");
        productList.put(2,"Eser");
        productList.put(3,"Bruen");
        productList.put(4,"Xamiou");
    }

    public int getCost() {
        return cost;
    }

    public String getProduct() {
        return product;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRam() {
        return ram;
    }

    public int getProductId() {
        for (Map.Entry<Integer, String> entry : productList.entrySet()) {
            if (entry.getValue()==product){
                return entry.getKey();
            }
        }
        return 0;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }



    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public int compareTo(NoteBook nBook) {
        if (this.getCost() > nBook.getCost()) {
            return 1;
        } else {
            if (this.getCost() < nBook.getCost()) {
                return -1;
            }
        }
        // если цены равны
        if (this.getRam() > nBook.getRam()) {
            return 1;
        } else {
            if (this.getRam() < nBook.getRam()) {
                return -1;
            }
        }
        // если ОЗУ равны
        if (this.getProductId() > nBook.getProductId()) {
            return 1;
        } else {
            if (this.getProductId() < nBook.getProductId()) {
                return -1;
            }
        }
        return 0;
    }
}
