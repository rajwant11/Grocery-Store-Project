import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner input = new Scanner(System.in);

        System.out.println("Grocery Store ");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a Product");
            System.out.println("2. Display Inventory");
            System.out.println("3. Update Product Price");
            System.out.println("4. Restock Product");
            System.out.println("0. Exit");

            try {
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        addProduct(manager, input);
                        break;
                    case 2:
                        manager.displayInventory();
                        break;
                    case 3:
                        updatePrice(manager, input);
                        break;
                    case 4:
                        restock(manager, input);
                        break;
                    case 0:
                        System.out.println("Exiting system. Goodbye!");
                        input.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                input.nextLine(); // Clear invalid input
            }
        }
    }

    private static void addProduct(InventoryManager manager, Scanner input) {
        System.out.print("Enter product name: ");
        String productName = input.nextLine(); // Updated variable name

        System.out.print("Enter category (Fresh, Dairy, Snacks, Pulses, Oils, Spices, Drinks): ");
        String category = input.nextLine();

        System.out.print("Enter stock: "); // Updated prompt
        int stock = input.nextInt();

        System.out.print("Enter price: ");
        double price = input.nextDouble();
        input.nextLine(); // Clear newline

        System.out.print("Enter expiry date (yyyy-MM-dd): ");
        String expiryDate = input.nextLine();

        manager.addProduct(productName, category, stock, price, expiryDate);
    }

    private static void updatePrice(InventoryManager manager, Scanner input) {
        System.out.print("Enter the product name to update price: ");
        String productName = input.nextLine(); // Updated variable name

        System.out.print("Enter the new price: ");
        double newPrice = input.nextDouble();
        input.nextLine(); // Clear newline

        manager.updatePrice(productName, newPrice);
    }

    private static void restock(InventoryManager manager, Scanner input) {
        System.out.print("Enter the product name to restock: ");
        String productName = input.nextLine(); // Updated variable name

        System.out.print("Enter the quantity to add: ");
        int amount = input.nextInt();
        input.nextLine(); // Clear newline

        manager.restockProduct(productName, amount);
    }
}
