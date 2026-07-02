public class Main {

    public static void main(String[] args) {

        Order[] orders = {
                new Order(101, "Rahul", 4500),
                new Order(102, "Aman", 1500),
                new Order(103, "Priya", 7000),
                new Order(104, "Neha", 3000)
        };

        System.out.println("Bubble Sort:");

        SortService.bubbleSort(orders);

        for (Order order : orders) {
            System.out.println(order);
        }

        Order[] orders2 = {
                new Order(101, "Rahul", 4500),
                new Order(102, "Aman", 1500),
                new Order(103, "Priya", 7000),
                new Order(104, "Neha", 3000)
        };

        System.out.println("\nQuick Sort:");

        SortService.quickSort(orders2, 0, orders2.length - 1);

        for (Order order : orders2) {
            System.out.println(order);
        }
    }
}