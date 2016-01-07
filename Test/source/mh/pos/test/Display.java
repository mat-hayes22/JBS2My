package mh.pos.test;

public class Display {

    private String priceAsText;

    public static String formatMonateryAmount(int priceInCents) {
        return String.format("$%,.2f" , priceInCents / 100.0d);
    }

    public String getPriceAsText() {
        return priceAsText;
    }

    public void displayProductNotFound(String barcode) {
        this.priceAsText = String.format("Product Not Found for %s", barcode);
    }

    public void displayErrorMessage() {
        this.priceAsText = "Scanning Error: Empty barcode";
    }

    public void displayNoSaleInProgress() {
        this.priceAsText = "No sale in progress";
    }

    public void displayPurchaseTotal(Integer price) {
        this.priceAsText = ("Total: " + formatMonateryAmount(price));
    }

    public void displayPrice(Integer priceInCents) {
        this.priceAsText = formatMonateryAmount(priceInCents);
    }
}
