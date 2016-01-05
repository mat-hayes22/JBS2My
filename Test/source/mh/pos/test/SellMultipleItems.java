package mh.pos.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SellMultipleItems {

    @Test
    public void zeroItems() throws Exception {
        Display display = new Display();
        Sale sale = new Sale( display, null);
        sale.onTotal();
        assertEquals("No sale in progress", display.getText());
        }

}
