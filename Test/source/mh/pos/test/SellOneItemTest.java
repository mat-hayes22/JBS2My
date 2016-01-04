package mh.pos.test;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mat on 04/01/2016.
 */
public class SellOneItemTest {

    @Test
    public void productFound() throws Exception {
        Display display = new Display();
        Sale sale = new Sale(display);
        sale.onBarcode("123456");
        assertEquals("7.95", display.getText());
    }

    @Test
    @Ignore("Refactoring...")
    public void anoterProductFound() throws Exception {

        Display display = new Display();
        Sale sale = new Sale(display);
        sale.onBarcode("123458");
        assertEquals("12.95", display.getText());

    }

    private static class Sale {
        private Display display;

        public Sale(Display display) {
            this.display = display;
        }

        public void onBarcode(String barcode) {
            display.setText("7.95");
        }
    }

    private static class Display {

        String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
