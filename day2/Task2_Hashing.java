import java.util.*;

public class Task2_Hashing {

    static class HashTable {

        LinkedList<String>[] table;
        int size;

        @SuppressWarnings("unchecked")
        HashTable(int size) {

            this.size = size;
            table = new LinkedList[size];

            for (int i = 0; i < size; i++) {
                table[i] = new LinkedList<>();
            }
        }

        int hash(String key) {
            return Math.floorMod(key.hashCode(), size);
        }

        void insert(String key) {

            int index = hash(key);

            if (!table[index].contains(key)) {
                table[index].add(key);
            }
        }

        boolean search(String key) {

            int index = hash(key);

            return table[index].contains(key);
        }

        void display(int index) {
            System.out.println("Bucket " + index + ": "
                    + table[index]);
        }
    }

    public static void main(String[] args) {

        System.out.println("HASH TABLE WITH CHAINING");

        HashTable ht = new HashTable(5);

        ht.insert("SKU100");
        ht.insert("SKU105");

        int index1 = ht.hash("SKU100");
        int index2 = ht.hash("SKU105");

        System.out.println("SKU100 index: " + index1);
        System.out.println("SKU105 index: " + index2);

        if (index1 == index2) {
            System.out.println("Collision occurred!");
        }

        ht.display(index1);

        System.out.println("Search SKU100: "
                + ht.search("SKU100"));


        // HashMap comparison
        System.out.println("\nHASHMAP COMPARISON");

        int n = 100000;

        HashTable custom = new HashTable(100003);

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String sku = "SKU" + i;

            custom.insert(sku);
            map.put(sku, i);
        }

        long start1 = System.nanoTime();

        for (int i = 0; i < n; i++) {
            custom.search("SKU" + i);
        }

        long end1 = System.nanoTime();

        long start2 = System.nanoTime();

        for (int i = 0; i < n; i++) {
            map.get("SKU" + i);
        }

        long end2 = System.nanoTime();

        System.out.println("Total SKUs: " + n);

        System.out.println("Custom Hash Table: "
                + (end1 - start1) / 1000000.0 + " ms");

        System.out.println("Built-in HashMap: "
                + (end2 - start2) / 1000000.0 + " ms");
    }
}