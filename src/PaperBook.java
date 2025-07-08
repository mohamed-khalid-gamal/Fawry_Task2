public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int publishedYear, double price, int stock) {
        super(isbn, title, author, publishedYear, price);
        this.stock = stock;
    }

    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }

    @Override
    public boolean isPurchasable() {
        return stock > 0;
    }

    @Override
    public PurchaseResult purchase(int quantity, String email, String address) {
        if (quantity <= 0) {
            return new PurchaseResult(false, 0, "Quantum book store: Invalid quantity");
        }

        if (stock < quantity) {
            return new PurchaseResult(false, 0,
                String.format("Quantum book store: Insufficient stock. Available: %d, Requested: %d", stock, quantity));
        }

        stock -= quantity;
        double totalAmount = price * quantity;

        ShippingService.ship(this, quantity, address);

        return new PurchaseResult(true, totalAmount,
            String.format("Quantum book store: Paper book shipped to %s", address));
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Stock: %d", stock);
    }
}
