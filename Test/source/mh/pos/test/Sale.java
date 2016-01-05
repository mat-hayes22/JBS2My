package mh.pos.test;

public class Sale {
    private SellOneItemTest.Catalog catalog;
    private Display display;

    public Sale(Display display, SellOneItemTest.Catalog catalog) {
        this.catalog = catalog;
        this.display = display;

    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.displayErrorMessage();
            return;
        }

        String priceAsText = catalog.findPrice(barcode);
        if (priceAsText == null) {
            display.displayProductNotFound(barcode);
        } else {
            display.displayPrice(priceAsText);
        }
    }

    public void onTotal() {
        display.displayNoSaleInProgress();
    }

}
