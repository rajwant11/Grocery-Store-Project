import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Product {
    private String productName; // Changed from 'name'
    private int stock; // Changed from 'quantity'
    private double price;
    private LocalDate expiryDate;

    public Product(String productName, int stock, double price, String expiryDate) {
        this.productName = productName;
        this.stock = stock;
        this.price = price;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.expiryDate = LocalDate.parse(expiryDate, formatter);
    }

    // Getters
    public String getProductName() {
        return productName;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // Methods to update stock and price
    public void addStock(int amount) {
        this.stock += amount;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public boolean needsRestock() {
        return stock < 5; // Example threshold
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    // Abstract method for displaying product info
    public abstract void displayProductInfo();
}
