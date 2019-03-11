package Task2.Order;

import Task2.Order.OrderInterfaces.InformationService;
import Task2.ProgramData.UserOfOrder;

public class UserInfoService  implements InformationService {

    @Override
    public boolean inform(Order order) {
        UserOfOrder userOfOrder = order.getUser();

        // return info to user
        // dummy
        return true;
    }
}
