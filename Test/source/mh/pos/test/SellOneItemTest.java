package mh.pos.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mat on 04/01/2016.
 */
public class SellOneItemTest {

    Display display;
    Sale sale;

    @Before
    public void setup() throws Exception {
        display = new Display();
        sale = new Sale(display);
    }


    @Test
    public void productFound() throws Exception {
        setup();
        sale.onBarcode("123456");
        assertEquals("7.95", display.getText());
    }

    @Test
    public void anoterProductFound() throws Exception {
        setup();
        sale.onBarcode("123458");
        assertEquals("12.95", display.getText());
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

    private static class Sale {
        private Display display;

        public Sale(Display display) {
            this.display = display;
        }

        public void onBarcode(String barcode) {
            if ("123456".equals(barcode ))
                display.setText("7.95");
            else if ("123458".equals(barcode))
                display.setText("12.95");
            else if ("".equals(barcode)){
                display.setText("Scanning Error: Empty barcode");
            }
            else
                display.setText( String.format("Product Not Found for %s", barcode));

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
