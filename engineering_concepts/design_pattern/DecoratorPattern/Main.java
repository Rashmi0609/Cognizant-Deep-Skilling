public class Main {

    public static void main(String[] args) {

        Notifier notifier = new EmailNotifier();

        System.out.println("Email Notification");
        notifier.send("Meeting at 10 AM");

        System.out.println();

        System.out.println("Email + SMS Notification");
        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send("Meeting at 10 AM");

        System.out.println();

        System.out.println("Email + SMS + Slack Notification");
        Notifier allNotifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        allNotifier.send("Meeting at 10 AM");
    }
}