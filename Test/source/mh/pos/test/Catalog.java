package mh.pos.test;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Map<String, String> pricesByBarcode;
    private Map<String, Integer> pricesInCentsByBarcode;

    public Catalog(Map<String, String> pricesAsTextByBarcode, Map<String, Integer> pricesInCentsByBarcode) {
        this.pricesByBarcode = pricesAsTextByBarcode;
        this.pricesInCentsByBarcode = pricesInCentsByBarcode;
    }

    public String findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }
}
