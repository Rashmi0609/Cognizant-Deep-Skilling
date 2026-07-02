import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Product[] products = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Electronics"),
                new Product(103, "Keyboard", "Electronics"),
                new Product(104, "Shoes", "Fashion"),
                new Product(105, "Watch", "Accessories")

        };

        System.out.println("Linear Search");

        Product result1 = SearchService.linearSearch(products, "Shoes");

        if (result1 != null)
            System.out.println(result1);
        else
            System.out.println("Product Not Found");


        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        System.out.println("\nBinary Search");

        Product result2 = SearchService.binarySearch(products, "Shoes");

        if (result2 != null)
            System.out.println(result2);
        else
            System.out.println("Product Not Found");

    }
}