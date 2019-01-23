package stream.world;

import org.junit.Assert;
import org.junit.Test;
import streamNew.world.Continent;
import streamNew.world.Country;
import streamNew.world.World;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        //Create users
        World world = new World();

        Continent europa = new Continent("europa");
        Continent northAmerica = new Continent("North America");
        Continent africa = new Continent("Africa");

        Country poland = new Country(BigDecimal.valueOf(50),"Poland");
        Country hungary = new Country(BigDecimal.valueOf(50),"Hungary");
        Country montenegro = new Country(BigDecimal.valueOf(50),"Montenegro");

        Country mexico = new Country(BigDecimal.valueOf(500),"Mexico");
        Country haiti = new Country(BigDecimal.valueOf(500),"Haiti");
        Country canada = new Country(BigDecimal.valueOf(500),"Canada");

        Country gabon = new Country(BigDecimal.valueOf(50),"Gabon");
        Country algeria = new Country(BigDecimal.valueOf(50),"Algeria");
        Country rwanda = new Country(BigDecimal.valueOf(50),"Rwanda");

        //When
        europa.addContinents(poland);
        europa.addContinents(hungary);
        europa.addContinents(montenegro);

        northAmerica.addContinents(mexico);
        northAmerica.addContinents(haiti);
        northAmerica.addContinents(canada);

        africa.addContinents(gabon);
        africa.addContinents(algeria);
        africa.addContinents(rwanda);

        world.addContinents(europa);
        world.addContinents(northAmerica);
        world.addContinents(africa);

        //Then
        Assert.assertEquals(BigDecimal.valueOf(1800), world.getPeolpeQuantity());

    }
}
