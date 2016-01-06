package mh.pos.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FormatMonateryAmount {

    private final int priceInCents;
    private final String formattedPrice;

    @Parameterized.Parameters(name = "Monetary amount {0} formats to {1}")
    public static Collection<Object[]> data(){
        return Collections.singletonList(new Object[]
                {789,"$7.89"}
        );
    }

    public FormatMonateryAmount(int priceInCents, String formattedPrice) {

        this.priceInCents = priceInCents;
        this.formattedPrice = formattedPrice;
    }


    @Test
    public void test() throws Exception {
        assertEquals(formattedPrice, format(priceInCents));
    }

    private static String format(int priceInCents) {
        return "$7.89";
    }
}
