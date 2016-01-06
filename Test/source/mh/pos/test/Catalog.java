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

    public static String format(int priceInCents) {
        return String.format("$%,.2f" , priceInCents / 100.0d);
    }

    public String findPriceThenFormatPrice(String barcode) {
        Integer pricesInCents = pricesInCentsByBarcode.get(barcode);
        if (pricesInCents != null)
            return format(pricesInCents);
        else
            return null;
    }
}
