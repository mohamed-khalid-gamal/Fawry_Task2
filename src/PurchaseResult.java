public class PurchaseResult {
    private boolean success;
    private double amountPaid;
    private String message;

    public PurchaseResult(boolean success, double amountPaid, String message) {
        this.success = success;
        this.amountPaid = amountPaid;
        this.message = message;
    }

    public boolean isSuccess() { return success; }
    public double getAmountPaid() { return amountPaid; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return String.format("Purchase %s - Amount: $%.2f - %s",
                           success ? "Successful" : "Failed", amountPaid, message);
    }
}
