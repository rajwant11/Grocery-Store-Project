public class OilsProduct extends Product {
    public OilsProduct(String name, int quantity, double price, String expiryDate) {
        super(name, quantity, price, expiryDate);
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Oils Product - Name: " + getName() + ", Quantity: " + getQuantity() + ", Price: $" + getPrice() + ", Expiry Date: " + getExpiryDate());
    }
}

