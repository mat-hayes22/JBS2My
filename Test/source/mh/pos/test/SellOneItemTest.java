package mh.pos.test;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SellOneItemTest {

    Display display;
    Sale sale;

    @Before
    public void setup() throws Exception {
        display = new Display();
        sale = new Sale(display, new Catalog(new HashMap<String, String>() {{
            put("123456", "$7.95");
            put("123458", "$12.95");
        }}));
    }

    @Test
    public void productFound() throws Exception {
        setup();
        sale.onBarcode("123456");
        assertEquals("$7.95", display.getText());
    }

    @Test
    public void anotherProductFound() throws Exception {
        setup();
        sale.onBarcode("123458");
        assertEquals("$12.95", display.getText());
    }

    @Test
    public void productNotFound() throws Exception {
        setup();
        sale.onBarcode("99999");
        assertEquals("Product Not Found for 99999", display.getText());

    }

    @Test
    public void emptyBarCode() throws Exception {
        setup();
        sale.onBarcode("");
        assertEquals("Scanning Error: Empty barcode", display.getText());

    }

    public static class Catalog {
        private final Map<String, String> pricesByBarcode;

        private Catalog(Map<String, String> pricesByBarcode) {
            this.pricesByBarcode = pricesByBarcode;
        }

        public String findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }
    }
}
