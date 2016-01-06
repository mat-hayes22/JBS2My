package mh.pos.test;

public class Sale {
    private Catalog catalog;
    private Display display;
    private String scannedPrice;


    public Sale(Display display, Catalog catalog) {
        this.catalog = catalog;
        this.display = display;

    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.displayErrorMessage();
            return;
        }

        scannedPrice = catalog.findPriceThenFormatPrice(barcode);
        if (scannedPrice == null) {
            display.displayProductNotFound(barcode);
        } else {
            display.displayPrice(scannedPrice);
        }
    }


    public void onTotal() {

        boolean saleInProgress = (scannedPrice != null);
        if (saleInProgress)
            display.displayPurchaseTotal(scannedPrice);
         else
            display.displayNoSaleInProgress();

    }

}
