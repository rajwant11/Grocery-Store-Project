public class SpicesProduct extends Product {
    public SpicesProduct(String name, int quantity, double price, String expiryDate) {
        super(name, quantity, price, expiryDate);
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Spices Product - Name: " + getName() +
                ", Quantity: " + getQuantity() +
                ", Price: $" + getPrice() +
                ", Expiry Date: " + getExpiryDate());
    }
}
