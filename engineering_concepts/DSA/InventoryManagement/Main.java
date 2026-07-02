public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        inventory.addProduct(new Product(101, "Laptop", 10, 65000));

        inventory.addProduct(new Product(102, "Mouse", 25, 450));

        inventory.addProduct(new Product(103, "Keyboard", 15, 900));

        inventory.displayProducts();

        inventory.updateProduct(102, 30, 500);

        inventory.displayProducts();

        inventory.deleteProduct(103);

        inventory.displayProducts();

    }

}