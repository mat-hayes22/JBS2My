package mh.pos.test;

public class Display {

    String text;

    public String getText() {
        return text;
    }

    public void displayPrice(String priceAsText) {
        this.text = priceAsText;
    }

    public void displayProductNotFound(String barcode) {
        this.text = String.format("Product Not Found for %s", barcode);
    }

    public void displayErrorMessage() {
        this.text = "Scanning Error: Empty barcode";
    }
}