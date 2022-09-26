package com.test.blaze.tests;

import org.testng.annotations.DataProvider;

public class CustomerDataProvider {

    @DataProvider(name = "validationCustomer")
    public Object[][] provideCustomerInfo(){

        return new Object[][]{
                {"MacBook Pro", "Ion", "Romania", "Cro", "99328872", "09", "2025","Thank you for your purchase!"},
                {"MacBook Pro", "Ahmet", "Turkey", "Cro", "4534543", "10", "2022","Thank you for your purchase!"},
                {"MacBook Pro", "Aisha", "England", "Cro", "7686778", "12", "2026","Thank you for your purchase!"}
        };
    }


}
