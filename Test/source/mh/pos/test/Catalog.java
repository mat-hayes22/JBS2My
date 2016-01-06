package mh.pos.test;

import java.util.Map;

/**
 * Created by mat on 06/01/2016.
 */
public class Catalog {
    private final Map<String, String> pricesByBarcode;

    Catalog(Map<String, String> pricesByBarcode) {
        this.pricesByBarcode = pricesByBarcode;
    }

    public String findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }
}
