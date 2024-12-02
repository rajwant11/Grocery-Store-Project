public class PulsesProduct extends Product {
    public PulsesProduct(String productName, int stock, double price, String expiryDate) {
        super(productName, stock, price, expiryDate);
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Pulses Product - Name: " + getProductName() +
                ", Stock: " + getStock() +
                ", Price: $" + getPrice() +
                ", Expiry Date: " + getExpiryDate());
    }
}
