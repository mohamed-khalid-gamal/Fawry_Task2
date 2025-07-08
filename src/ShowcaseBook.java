public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, String author, int publishedYear, double price) {
        super(isbn, title, author, publishedYear, price);
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }
    @Override
    public PurchaseResult purchase(int quantity, String email, String address) {
        return new PurchaseResult(false, 0,
            "Quantum book store: This is a showcase book and is not available for purchase");
    }

    @Override
    public String toString() {
        return super.toString() + " [SHOWCASE - NOT FOR SALE]";
    }
}
