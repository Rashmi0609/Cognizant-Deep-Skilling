public class Main {
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp("Zomato Stocks");
        Observer web = new WebApp("MoneyControl");

        // Register observers
        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        // Stock updates
        stockMarket.setStockData("TATA", 3200.50);
        stockMarket.setStockData("INFY", 1450.75);

        // Remove one observer
        stockMarket.deregisterObserver(mobile);

        System.out.println("\nAfter MobileApp removed:\n");

        stockMarket.setStockData("RELIANCE", 2800.00);
    }
} 