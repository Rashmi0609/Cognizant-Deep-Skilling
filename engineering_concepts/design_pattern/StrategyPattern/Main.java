public class Main {
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();


        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876"));
        context.payAmount(500);
        context.setPaymentStrategy(new PayPalPayment("user@gmail.com"));
        context.payAmount(1200);
        context.setPaymentStrategy(new CreditCardPayment("9999-8888-7777"));
        context.payAmount(300);
    }
}