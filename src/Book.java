public abstract class Book {
    protected String isbn;
    protected String title;
    protected String author;
    protected int publishedYear;
    protected double price;

    public Book(String isbn, String title, String author, int publishedYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
    }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublishedYear() { return publishedYear; }
    public double getPrice() { return price; }

    public abstract PurchaseResult purchase(int quantity, String email, String address);

    public abstract boolean isPurchasable();

    public boolean isOutdated(int currentYear, int yearsThreshold) {
        return (currentYear - publishedYear) > yearsThreshold;
    }

    @Override
    public String toString() {
        return String.format("ISBN: %s, Title: %s, Author: %s, Year: %d, Price: $%.2f",
                           isbn, title, author, publishedYear, price);
    }
}
