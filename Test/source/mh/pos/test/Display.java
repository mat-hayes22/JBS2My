package mh.pos.test;

public class Display {

    String text;

    public static String format(int priceInCents) {
        return String.format("$%,.2f" , priceInCents / 100.0d);
    }

    public String getText() {
        return text;
    }

    public void displayText(String priceAsText) {
        this.text = priceAsText;
    }

    public void displayProductNotFound(String barcode) {
        this.text = String.format("Product Not Found for %s", barcode);
    }

    public void displayErrorMessage() {
        this.text = "Scanning Error: Empty barcode";
    }

    public void displayNoSaleInProgress() {
        this.text = "No sale in progress";
    }

    public void displayPurchaseTotal(String priceAsText) {
        this.text = ("Total: " + priceAsText);
    }
}
