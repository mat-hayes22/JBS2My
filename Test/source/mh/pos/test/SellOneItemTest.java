package mh.pos.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mat on 04/01/2016.
 */
public class SellOneItemTest {

    @Test
    public void productFound() throws Exception {

        Sale sale = new Sale();
        sale.onBarcode("123456");
        Display display = new Display();
        assertEquals("7.95", display.getText());
    }

    private static class Sale {
        public void onBarcode(String barcode) {
        }
    }

    private static class Display {
        public String getText() {
            return "7.95";
        }
    }
}
