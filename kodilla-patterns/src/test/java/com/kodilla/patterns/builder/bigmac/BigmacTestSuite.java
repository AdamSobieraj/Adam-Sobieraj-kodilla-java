package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

        @Test
        public void testPizzaNew() {
            //Given
            Bigmac bigMac = new Bigmac.BigmacBuilder()
                    .ingredient("Onion")
                    .bun("Thin")
                    .burgers("2")
                    .sauce("Spicy")
                    .ingredient("Ham")
                    .ingredient("Mushrooms")
                    .build();
            System.out.println(bigMac);
            //When
            int howManyIngredients = bigMac.getIngredients().size();
            //Then
            Assert.assertEquals(3, howManyIngredients);
        }


}
