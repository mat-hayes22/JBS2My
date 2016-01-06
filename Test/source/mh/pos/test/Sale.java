package mh.pos.test;

public class Sale {
    private Catalog catalog;
    private Display display;
    private String priceAsText;

    public Sale(Display display, Catalog catalog) {
        this.catalog = catalog;
        this.display = display;

    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.displayErrorMessage();
            return;
        }

        priceAsText = catalog.findPrice(barcode);

        if (priceAsText == null) {
            display.displayProductNotFound(barcode);
        } else {
            display.displayPrice(priceAsText);
        }
    }

    public void onTotal() {

        boolean saleInProgress = (priceAsText != null);
        if (saleInProgress) {
            display.displayPurchaseTotal(priceAsText);
        } else {
            display.displayNoSaleInProgress();
        }
    }

}
