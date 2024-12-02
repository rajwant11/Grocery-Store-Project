public class SpicesProduct extends Product {
    public SpicesProduct(String productName, int stock, double price, String expiryDate) {
        super(productName, stock, price, expiryDate);
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Spices Product - Name: " + getProductName() +
                ", Stock: " + getStock() +
                ", Price: $" + getPrice() +
                ", Expiry Date: " + getExpiryDate());
    }
}
