public class PulsesProduct extends Product {
    public PulsesProduct(String name, int quantity, double price, String expiryDate) {
        super(name, quantity, price, expiryDate);
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Pulses Product - Name: " + getName() +
                ", Quantity: " + getQuantity() +
                ", Price: $" + getPrice() +
                ", Expiry Date: " + getExpiryDate());
    }
}
