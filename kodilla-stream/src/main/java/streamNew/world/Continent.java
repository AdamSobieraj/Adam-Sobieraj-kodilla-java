package streamNew.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

    private final List<Country> countries = new ArrayList<>();
    private final String countryName;

    public Continent(String countryName) {
        this.countryName = countryName;
    }

    public void addContinents(Country countri) {
        countries.add(countri);
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public String getCountryName() {
        return countryName;
    }
}
