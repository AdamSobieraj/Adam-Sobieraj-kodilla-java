package com.kodilla.good.patterns.challenges.Task3.RepositoryContainer;

import com.kodilla.good.patterns.challenges.Task3.DataContainers.CompanyCointainer;
import com.kodilla.good.patterns.challenges.Task3.DataContainers.ProductContainer;
import com.kodilla.good.patterns.challenges.Task3.ExternalShopsContainer.GlutenFreeShop.GFSClient;
import com.kodilla.good.patterns.challenges.Task3.ExternalShopsContainer.HealthyShop.HSClient;
import com.kodilla.good.patterns.challenges.Task3.ProgramLogic.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public final class HSSupplyService extends AbstractSupplyService implements SupplyService {

    private static final int OFFER_PRODUCT_NAME = 3;
    private static final int OFFER_MEASURE = 3;
    private static final int OFFER_QUANTITY = 3;
    private static final int OFFER_PRICE = 2;

    private final HSClient client = new HSClient();

    public HSSupplyService(final CompanyCointainer companyCointainer, final String user) {
        super(companyCointainer, user);
    }

    @Override
    public OrderResult process(Order order) {
        String[] efsOrder = convertToGFSOrder(order);
            String id = client.sendOrder(efsOrder);
            if (id != null) {
                return new OrderResult(id, order);
            }
        return null;
    }

    @Override
    public List<ProductOffer> getOffers() {
            String[][] gfsOffers = client.getOffers();
            if (gfsOffers != null) {
                List<ProductOffer> productOffers = Arrays.asList(gfsOffers).stream()
                        .map(gfsOffer -> convertFromGFSOffer(gfsOffer))
                        .collect(toList());
                return new ArrayList<>(productOffers);
            }

        return null;
    }

    private String[] convertToGFSOrder(Order o) {
        ProductContainer p = o.getProduct();
        return new String[] {o.getDate().toString(), p.getName(), p.getMeasure(), Double.toString(o.getAmount()),
                Double.toString(o.getPrice())};
    }

    private ProductOffer convertFromGFSOffer(String[] o) {
        try {
            ProductContainer p = new ProductContainer(getProducer(), o[OFFER_PRODUCT_NAME], o[OFFER_MEASURE]);
            return new ProductOffer(p, Double.parseDouble(o[OFFER_PRICE]), Double.parseDouble(o[OFFER_QUANTITY]));
        } catch (IllegalArgumentException  | NullPointerException exc) {
        }
        return null;
    }
}
