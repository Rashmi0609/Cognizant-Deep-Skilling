import java.util.ArrayList;
import java.util.List;

class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(stockName, price);
        }
    }

    // method to change stock data
    public void setStockData(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyObservers();
    }
}