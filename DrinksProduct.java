public class DrinksProduct extends Product {
    public DrinksProduct(String name, int quantity, double price, String expiryDate) {
        super(name, quantity, price, expiryDate);
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Drinks Product - Name: " + getName() + ", Quantity: " + getQuantity() + ", Price: $" + getPrice() + ", Expiry Date: " + getExpiryDate());
    }
}
