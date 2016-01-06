package mh.pos.test;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SellMultipleItems {

    @Test
    public void zeroItems() throws Exception {
        Display display = new Display();
        Sale sale = new Sale( display, null);
        sale.onTotal();
        assertEquals("No sale in progress", display.getText());
        }

    @Test
    public void oneItemFound() throws Exception {
        Catalog catalog = new Catalog(Collections.singletonMap("123456","$6.50"));
        Display display = new Display();
        Sale sale = new Sale(display, catalog);
        sale.onBarcode("123456");
        sale.onTotal();
        assertEquals("Total: $6.50", display.getText());
    }
}
