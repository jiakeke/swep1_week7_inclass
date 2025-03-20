import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {

    public static void main(String[] args) {
        System.out.println("Please select a language: ");
        System.out.println("1. English");
        System.out.println("2. Swedish");
        System.out.println("3. Finish");
        System.out.println("4. Japanese");

        Locale locale;
        Scanner scanner = new Scanner(System.in);
        int language = scanner.nextInt();
        locale = switch (language) {
            case 1 -> new Locale("en", "US");
            case 2 -> new Locale("sv", "SE");
            case 3 -> new Locale("fi", "FI");
            case 4 -> new Locale("ja", "JP");
            default -> new Locale("en", "US");
        };

        ResourceBundle msg;
        try {
            msg = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("Invalid language selection. Defaulting to English.");
            msg = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        }

        System.out.println(msg.getString("items_number"));
        int itemsNumber = scanner.nextInt();
        double totalPrice = 0;
        for (int i = 0; i < itemsNumber; i++) {
            System.out.println(msg.getString("item_price") + (i + 1) + ": ");
            double itemPrice = scanner.nextDouble();
            System.out.println(msg.getString("item_quantity") + (i + 1) + ": ");
            int itemQuantity = scanner.nextInt();
            totalPrice += calculatePrice(itemPrice, itemQuantity);
        }
        System.out.println(msg.getString("total_price") + totalPrice);
    }

    public static double calculatePrice(double itemPrice, int itemQuantity) {
        return itemPrice * itemQuantity;
    }
}
