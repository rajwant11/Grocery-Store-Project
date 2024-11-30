import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Product {
    private String name;
    private int quantity;
    private double price;
    private LocalDate expiryDate;

    public Product(String name, int quantity, double price, String expiryDate) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.expiryDate = LocalDate.parse(expiryDate, formatter);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void addStock(int amount) {
        this.quantity += amount;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public boolean needsRestock() {
        return quantity < 5;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public abstract void displayProductInfo();
}
