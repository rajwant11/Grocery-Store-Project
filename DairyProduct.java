public class DairyProduct extends Product {
    public DairyProduct(String name, int quantity, double price, String expiryDate) {
        super(name, quantity, price, expiryDate);
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Dairy Product - Name: " + getName() +
                ", Quantity: " + getQuantity() +
                ", Price: $" + getPrice() +
                ", Expiry Date: " + getExpiryDate());
    }
}
