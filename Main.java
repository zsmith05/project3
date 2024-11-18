
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:\\Users\\zions\\IdeaProjects\\project3\\amazon_product_data_cleaned.csv");
        Scanner reader = new Scanner(input);
        btree Tree = new btree(2);
        int i = 0;
        while (reader.hasNextLine()) {
            String product = reader.nextLine();
            String[] parts = product.split(",");

            String id = parts[0].trim();
            String name = parts[1].trim();
            String cat = parts[2].trim();
            String price;
            if (parts.length > 3 && !parts[3].trim().isEmpty()) {
                price = parts[3].trim();
            } else {
                price = "No listed price";
            }

            btree.Product p = new btree.Product(id, name, cat, price);
            Tree.insert(p);
            i++;


        }
        // Edge case, product id already exists
        btree.Product copy = new btree.Product("bc178f33a04dbccefa95b165f8b56830", "Barbie house", "Toys", "$20.99");
        Tree.insert(copy);

        btree.Product item = new btree.Product("fjeiualj3724jnwT423rjmie8443jfre", "Purple Playset", "Toys", "$19.99");
        Tree.insert(item);


        System.out.println("Finished inserting");
        Scanner scan = new Scanner(System.in);

        boolean query = true;
        do {
            System.out.println("Enter product id to search: ");
            String search = scan.nextLine();
            btree.Product found = Tree.search(search);


            if (found != null) {
                System.out.println("Found product: " + found);
            } else {
                System.out.println("Product not found.");
            }
            System.out.println("Would you like to make another search? Type y for yes and n for no.");
            String ask = scan.nextLine();
            if(ask.equals("n")){
                query = false;

            }

        }while(query);



    }
}