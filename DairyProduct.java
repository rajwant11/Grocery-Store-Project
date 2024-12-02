public class DairyProduct extends Product {
    public DairyProduct(String productName, int stock, double price, String expiryDate) {
        super(productName, stock, price, expiryDate);
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Dairy Product - Name: " + getProductName() +
                ", Stock: " + getStock() +
                ", Price: $" + getPrice() +
                ", Expiry Date: " + getExpiryDate());
    }
}
