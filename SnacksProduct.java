public class SnacksProduct extends Product {
    public SnacksProduct(String name, int quantity, double price, String expiryDate) {
        super(name, quantity, price, expiryDate);
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Snacks Product - Name: " + getName() +
                ", Quantity: " + getQuantity() +
                ", Price: $" + getPrice() +
                ", Expiry Date: " + getExpiryDate());
    }
}
