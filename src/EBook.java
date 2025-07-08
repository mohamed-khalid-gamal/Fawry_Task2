public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, String author, int publishedYear, double price, String fileType) {
        super(isbn, title, author, publishedYear, price);
        this.fileType = fileType;
    }

    public String getFileType() { return fileType; }

    @Override
    public boolean isPurchasable() {
        return true;
    }

    @Override
    public PurchaseResult purchase(int quantity, String email, String address) {
        if (quantity <= 0) {
            return new PurchaseResult(false, 0, "Quantum book store: Invalid quantity");
        }

        double totalAmount = price * quantity;

        MailService.sendEBook(this, quantity, email);

        return new PurchaseResult(true, totalAmount,
            String.format("Quantum book store: EBook sent to %s", email));
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", File Type: %s", fileType);
    }
}
