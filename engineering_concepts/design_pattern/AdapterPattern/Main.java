public class Main {

    public static void main(String[] args) {

        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processPayment(500);

        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(1000);

    }

} 