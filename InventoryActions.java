public interface InventoryActions {
    void addProduct(String name, String category, int quantity, double price, String expiryDate);
    void displayInventory();
    void updatePrice(String name, double newPrice);
    void restockProduct(String name, int amount);
}
