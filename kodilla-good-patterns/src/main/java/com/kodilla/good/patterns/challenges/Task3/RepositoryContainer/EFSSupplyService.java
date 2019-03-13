package com.kodilla.good.patterns.challenges.Task3.RepositoryContainer;

import com.kodilla.good.patterns.challenges.Task3.DataContainers.CompanyCointainer;
import com.kodilla.good.patterns.challenges.Task3.DataContainers.ProductContainer;
import com.kodilla.good.patterns.challenges.Task3.ExternalShopsContainer.ExtraFoodShop.EFSClient;
import com.kodilla.good.patterns.challenges.Task3.ExternalShopsContainer.ExtraFoodShop.EFSOffer;
import com.kodilla.good.patterns.challenges.Task3.ExternalShopsContainer.ExtraFoodShop.EFSOrder;
import com.kodilla.good.patterns.challenges.Task3.ProgramLogic.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public final class EFSSupplyService extends AbstractSupplyService implements SupplyService {

    private final EFSClient client = new EFSClient();

    public EFSSupplyService(final CompanyCointainer companyCointainer, final String user) {
        super(companyCointainer, user);
    }

    @Override
    public OrderResult process(Order order) {
        EFSOrder efsOrder = convertEFSOrder(order);

            String id = client.send(efsOrder);
            if (id != null) {
                return new OrderResult(id, order);
            }
        return null;
    }

    @Override
    public List<ProductOffer> getOffers() {
            List<EFSOffer> efsOffers = client.fetch();

            if (efsOffers != null) {
                List<ProductOffer> productOffers = efsOffers.stream()
                        .map(efsOffer -> convertFromEFSOffer(efsOffer))
                        .collect(toList());
                return new ArrayList<>(productOffers);
            }

        return null;
    }

    private EFSOrder convertEFSOrder(Order o) {
        ProductContainer p = o.getProduct();
        return new EFSOrder(o.getDate(), p.getName(), p.getMeasure(), o.getAmount(), o.getPrice());
    }

    private ProductOffer convertFromEFSOffer(EFSOffer o) {
        ProductContainer p = new ProductContainer(getProducer(), o.getProductName(), o.getMeasure());
        return new ProductOffer(p, o.getQuantity(), o.getPrice());
    }
}
