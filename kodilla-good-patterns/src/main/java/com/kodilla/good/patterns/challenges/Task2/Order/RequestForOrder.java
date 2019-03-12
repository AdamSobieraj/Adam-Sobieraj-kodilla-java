package Task2.Order;

import Task2.ProgramData.Product;
import Task2.ProgramData.UserOfOrder;

public class RequestForOrder {

    private final UserOfOrder userOfOrder;
    private final Product product;
    private final int howMany;
    private final double amount;

    public RequestForOrder(final UserOfOrder userOfOrder, final Product product,
                        final int howMany) {
        if (userOfOrder == null || product == null || howMany <= 0) {
            throw new IllegalArgumentException();
        }

        this.userOfOrder = userOfOrder;
        this.product = product;
        this.howMany = howMany;
        this.amount = product.getPrice() * howMany;
    }

    public UserOfOrder getUserOfOrder() {
        return userOfOrder;
    }

    public Product getProduct() {
        return product;
    }

    public int getHowMany() {
        return howMany;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order request resoult : " +
                "user =" + userOfOrder +
                ", product=" + product +
                ", howMany=" + howMany +
                ", amount=" + amount;
    }

}
