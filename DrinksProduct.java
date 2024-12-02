public class DrinksProduct extends Product {
    public DrinksProduct(String productName, int stock, double price, String expiryDate) {
        super(productName, stock, price, expiryDate);
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Drinks Product - Name: " + getProductName() +
                ", Stock: " + getStock() +
                ", Price: $" + getPrice() +
                ", Expiry Date: " + getExpiryDate());
    }
}
