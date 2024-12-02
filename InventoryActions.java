public interface InventoryActions {
    void addProduct(String productName, String category, int stock, double price, String expiryDate);
    void displayInventory();
    void updatePrice(String productName, double newPrice);
    void restockProduct(String productName, int amount);
}
