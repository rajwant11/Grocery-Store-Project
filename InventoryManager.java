import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InventoryManager implements InventoryActions {
    private Product[] products = new Product[100];
    private int productCount = 0;
    private Scanner input = new Scanner(System.in);

    @Override
    public void addProduct(String name, String category, int quantity, double price, String expiryDate) {
        try {
            Product product;
            switch (category.toLowerCase()) {
                case "fresh":
                    product = new FreshProduct(name, quantity, price, expiryDate);
                    break;
                case "dairy":
                    product = new DairyProduct(name, quantity, price, expiryDate);
                    break;
                case "snacks":
                    product = new SnacksProduct(name, quantity, price, expiryDate);
                    break;
                case "pulses":
                    product = new PulsesProduct(name, quantity, price, expiryDate);
                    break;
                case "oils":
                    product = new OilsProduct(name, quantity, price, expiryDate);
                    break;
                case "spices":
                    product = new SpicesProduct(name, quantity, price, expiryDate);
                    break;
                case "drinks":
                    product = new DrinksProduct(name, quantity, price, expiryDate);
                    break;
                default:
                    System.out.println("Unknown product category.");
                    return;
            }

            if (productCount < products.length) {
                products[productCount++] = product;
                System.out.println("Product added to inventory successfully.");
                saveInventoryToCSV(); // Save after adding a product
            } else {
                System.out.println("Cannot add more products at the moment.");
            }
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    @Override
    public void displayInventory() {
        System.out.println("Checking for expired products...");
        for (int i = 0; i < productCount; i++) {
            if (products[i].isExpired()) {
                System.out.println("** Removing expired product: " + products[i].getName() + " **");
                removeProduct(i);
                i--; // Adjust index after removal
            }
        }

        System.out.println("Current Inventory:");
        for (int i = 0; i < productCount; i++) {
            products[i].displayProductInfo();
            if (products[i].needsRestock()) {
                System.out.println("** Low stock alert! Restock needed for " + products[i].getName() + " **");
            }
        }
    }

    @Override
    public void updatePrice(String name, double newPrice) {
        try {
            for (int i = 0; i < productCount; i++) {
                if (products[i].getName().equalsIgnoreCase(name)) {
                    products[i].updatePrice(newPrice);
                    System.out.println("Price updated for " + name + " to $" + newPrice);
                    saveInventoryToCSV(); // Save after updating the price
                    return;
                }
            }
            System.out.println("Product not found.");
        } catch (Exception e) {
            System.out.println("Error updating price: " + e.getMessage());
        }
    }

    @Override
    public void restockProduct(String name, int amount) {
        try {
            for (int i = 0; i < productCount; i++) {
                if (products[i].getName().equalsIgnoreCase(name)) {
                    products[i].addStock(amount);
                    System.out.println("Restocked " + amount + " units of " + name);
                    saveInventoryToCSV(); // Save after restocking
                    return;
                }
            }
            System.out.println("Product not found.");
        } catch (Exception e) {
            System.out.println("Error restocking product: " + e.getMessage());
        }
    }

    private void removeProduct(int index) {
        for (int i = index; i < productCount - 1; i++) {
            products[i] = products[i + 1];
        }
        products[--productCount] = null; // Clear the last element and update count
    }

    // Method to save the inventory to a CSV file
    public void saveInventoryToCSV() {
        try (FileWriter writer = new FileWriter("updated_inventory.csv")) {
            // Write CSV header
            writer.write("Name,Category,Quantity,Price,ExpiryDate\n");

            // Write each product's data to the CSV
            for (int i = 0; i < productCount; i++) {
                Product product = products[i];
                String category;
                if (product instanceof FreshProduct) {
                    category = "Fresh";
                } else if (product instanceof DairyProduct) {
                    category = "Dairy";
                } else if (product instanceof SnacksProduct) {
                    category = "Snacks";
                } else if (product instanceof PulsesProduct) {
                    category = "Pulses";
                } else if (product instanceof OilsProduct) {
                    category = "Oils";
                } else if (product instanceof SpicesProduct) {
                    category = "Spices";
                } else if (product instanceof DrinksProduct) {
                    category = "Drinks";
                } else {
                    category = "Unknown";
                }
                writer.write(product.getName() + "," + category + "," + product.getQuantity() + "," + product.getPrice() + "," + product.getExpiryDate() + "\n");
            }

            System.out.println("Inventory saved to updated_inventory.csv successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory to CSV: " + e.getMessage());
        }
    }
}
