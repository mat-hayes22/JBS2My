package mh.pos.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FormatMonateryAmount {

    private final int priceInCents;
    private final String formattedPrice;

    @Parameterized.Parameters(name = "Monetary amount {0} formats to {1}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {789, "$7.89"},
                {520, "$5.20"},
                {400, "$4.00"},
                {0, "$0.00"},
                {2, "$0.02"},
                {30, "$0.30"},
                {47, "$0.47"},
                {418996, "$4,189.96"},
                {210832281, "$2,108,322.81"}
        });
    }

    public FormatMonateryAmount(int priceInCents, String formattedPrice) {

        this.priceInCents = priceInCents;
        this.formattedPrice = formattedPrice;
    }


    @Test
    public void test() throws Exception {
        assertEquals(formattedPrice, Display.format(priceInCents));
    }

}
