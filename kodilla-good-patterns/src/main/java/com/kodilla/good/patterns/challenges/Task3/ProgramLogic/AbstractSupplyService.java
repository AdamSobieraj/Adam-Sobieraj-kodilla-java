package com.kodilla.good.patterns.challenges.Task3.ProgramLogic;

import com.kodilla.good.patterns.challenges.Task3.DataContainers.CompanyCointainer;

public abstract class AbstractSupplyService implements SupplyService {
    private final CompanyCointainer companyCointainer;
    private final String user;

    protected AbstractSupplyService(final CompanyCointainer companyCointainer, final String user) {
        this.companyCointainer = companyCointainer;
        this.user = user;
    }

    public CompanyCointainer getProducer() {
        return companyCointainer;
    }

    public String getUser() {
        return user;
    }


}
