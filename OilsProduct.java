public class OilsProduct extends Product {
    public OilsProduct(String productName, int stock, double price, String expiryDate) {
        super(productName, stock, price, expiryDate);
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Oils Product - Name: " + getProductName() +
                ", Stock: " + getStock() +
                ", Price: $" + getPrice() +
                ", Expiry Date: " + getExpiryDate());
    }
}
