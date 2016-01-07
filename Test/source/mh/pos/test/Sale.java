package mh.pos.test;

import java.util.ArrayList;
import java.util.Collection;

public class Sale {
    private Catalog catalog;
    private Display display;
    private Collection<Integer> pendingPurchaseItemPrices = new ArrayList<>();


    public Sale(Display display, Catalog catalog) {
        this.catalog = catalog;
        this.display = display;

    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.displayErrorMessage();
            return;
        }

        Integer priceInCents = catalog.findPrice(barcode);
        if (priceInCents == null) {
            display.displayProductNotFound(barcode);
        } else {
            pendingPurchaseItemPrices.add(priceInCents);
            display.displayPrice(priceInCents);
        }
    }


    public void onTotal() {

        boolean saleInProgress = (!pendingPurchaseItemPrices.isEmpty());
        if (saleInProgress)
            display.displayPurchaseTotal(pendingPurchaseTotal());
         else
            display.displayNoSaleInProgress();

    }

    private Integer pendingPurchaseTotal() {
        return pendingPurchaseItemPrices.iterator().next();
    }

}
