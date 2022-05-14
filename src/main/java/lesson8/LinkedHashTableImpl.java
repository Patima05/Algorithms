package lesson8;

import java.util.LinkedList;

public class LinkedHashTableImpl<K, V> implements LinkedHashTable<K, V> {
        private final LinkedList<ItemLink<K, V>>[] data;//дз
        private int size;

        static class ItemLink <K, V> implements Entry<K, V> {
            private final K key;
            private V value;

            public ItemLink(K key, V value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public K getKey() {
                return key;
            }

            @Override
            public V getValue() {
                return value;
            }

            @Override
            public void setValue(V value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return String.format("key: %s -> value: %s", key, value);
            }
        }

        public LinkedHashTableImpl() {
            this(16);
        }

        public LinkedHashTableImpl(int initialCapacity) {
            this.data = new LinkedList[initialCapacity]; //создаем связный список
        }


        @Override
        public boolean put(K key, V value) {
            if(size() == data.length) {
                return false;
            }
            int indexAfterHashFunc = hashFunc(key);

            if(data[indexAfterHashFunc] == null){
                LinkedList <ItemLink<K, V>> linkedList = new LinkedList<>();
                data [indexAfterHashFunc] = linkedList;
            }

            int indexInList = containsKey(data[indexAfterHashFunc], key);
            if(data[indexAfterHashFunc].isEmpty() || indexInList == -1) {
                data[indexAfterHashFunc].add(new ItemLink<>(key, value));

            } else if(indexInList >= 0) {
                data[indexAfterHashFunc].get(indexInList).setValue(value);
            }
            size++;
            return true;
        }

        private int hashFunc(K key){
            return key.hashCode() % data.length;
        }

        private int containsKey (LinkedList <ItemLink<K, V>> list, K key){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getKey().equals(key)){
                    return hashFunc(key);
                }
            }
            return -1;
        }

        @Override
        public V get(K key) {
            int index = hashFunc(key);
            LinkedList<ItemLink<K, V>> currentList = data[index];
            for (int i = 0; i < currentList.size(); i++) {
                if(currentList.get(i).getKey().equals(key)){
                    V value = (V)currentList.get(i).getValue();
                    return value;
                }
            }
            return null;
        }

        @Override
        public V remove(K key) {
            int index = hashFunc(key);
            LinkedList<ItemLink<K, V>> currentList = data[index];
            for (int i = 0; i < currentList.size(); i++) {
                if(currentList.get(i).getKey().equals(key)){
                    V value = (V)currentList.get(i).getValue();
                    currentList.remove(i);
                    size--;
                    return value;
                }
            }
            return null;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public void display() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                sb.append(String.format("%s = [%s]%n", i, data[i]));
            }
            return sb.toString();

    }
}
