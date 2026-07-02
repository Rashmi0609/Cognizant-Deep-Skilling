import java.util.HashMap;

public class Inventory {

    private HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {

        products.put(product.getProductId(), product);

        System.out.println(product.getProductName() + " added successfully.");
    }

    public void updateProduct(int id, int quantity, double price) {

        Product product = products.get(id);

        if (product != null) {

            product.setQuantity(quantity);
            product.setPrice(price);

            System.out.println("Product updated successfully.");

        } else {

            System.out.println("Product not found.");

        }
    }

    public void deleteProduct(int id) {

        if (products.remove(id) != null) {

            System.out.println("Product deleted successfully.");

        } else {

            System.out.println("Product not found.");

        }

    }

    public void displayProducts() {

        System.out.println("\nInventory");

        System.out.println("--------------------------");

        for (Product product : products.values()) {

            System.out.println(product);

            System.out.println("--------------------------");

        }

    }

}