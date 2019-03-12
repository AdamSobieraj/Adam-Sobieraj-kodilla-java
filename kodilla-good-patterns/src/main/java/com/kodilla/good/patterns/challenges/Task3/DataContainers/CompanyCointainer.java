package com.kodilla.good.patterns.challenges.Task3.DataContainers;

import static com.kodilla.good.patterns.challenges.Task3.ImputDataValidation.ImputValidator.*;

public final class CompanyCointainer {

    private final String name;
    private final String address;
    private final String email;
    private final String phone;

    public CompanyCointainer(final String name, final String address, final String email, final String phone) {

        inputDataValidation();

        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    private void inputDataValidation(){

        validateString(name, "name");
        validateString(address, "address");
        validateString(email, "email");
        validateString(phone, "phone");

    }

    @Override
    public String toString() {
        return  " name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone;
    }
}
