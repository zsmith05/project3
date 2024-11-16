//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {
    static class Product {
        String id;
        String name;
        String cat;
        String price;

        public Product(String id, String name, String cat, String price) {
            this.id = id;
            this.name = name;
            this.cat = cat;
            this.price = price;
        }

        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", cat='" + cat + '\'' +
                    ", price=" + price +
                    '}';
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("amazon-product-data.csv");
        Scanner reader = new Scanner(input);
        btree Tree = new btree(10);
        while (reader.hasNextLine()) {
            String product = reader.nextLine();
            String[] parts = product.split(",");

            String id = parts[0].trim();
            String name = parts[1].trim();
            String cat = parts[2].trim();
            String price = parts[3].trim();

            Product p = new Product(id, name, cat, price);
            System.out.println(p);


        }



    }
}