package com.hello;

import com.entity.Customer;

import java.util.List;

public interface ICustom {

    Customer getCustomerId(long id);

    List<Customer> getAllCustomer();

    Customer addCustomer(Customer customer);

    void deleteCustomer(long id);

    Customer updateCustomer(Customer customer, long id);

    void deleteAll();
}
