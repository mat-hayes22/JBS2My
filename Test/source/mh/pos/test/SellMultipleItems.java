package mh.pos.test;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

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

        Catalog catalog = new Catalog(
                Collections.singletonMap("123456",650));

        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("123456");
        sale.onTotal();

        assertEquals("Total: $6.50", display.getText());
    }

    @Test
    public void oneItemNotFound() throws Exception {
        Catalog catalog = new Catalog(Collections.singletonMap("123456",650));
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("123457");
        sale.onTotal();
        assertEquals("No sale in progress", display.getText());


    }

    @Test
    @Ignore ("need to change to  int first..")
    public void severalItemsAllFound() throws Exception {
        Catalog catalog = new Catalog(
                new HashMap<String, Integer>()
                {{
                    put("1",850);
                    put("2",1275);
                    put("3",330);
                }}
        );

        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("1");
        sale.onBarcode("2");
        sale.onBarcode("3");
        sale.onTotal();

        assertEquals("Total: $24.55", display.getText());

    }
}
