public class FreshProduct extends Product {
    public FreshProduct(String name, int quantity, double price, String expiryDate) {
        super(name, quantity, price, expiryDate);
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Fresh Product - Name: " + getName() + ", Quantity: " + getQuantity() + ", Price: $" + getPrice() + ", Expiry Date: " + getExpiryDate());
    }
}
