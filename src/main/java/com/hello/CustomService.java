package com.hello;

import com.entity.Customer;
import com.jpaRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomService implements ICustom {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getCustomerId(long id) {
        Customer obj = customerRepository.findById(id).get();
        return obj;

    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> list = new ArrayList<>();
        customerRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);

    }

    @Override
    public Customer updateCustomer(Customer newcustomer, long id) {

        return customerRepository.findById(id).map(customer -> {
            customer.setFirstName(newcustomer.getFirstName());
            customer.setLastName(newcustomer.getLastName());
            return customerRepository.save(customer);
        })
        .orElseGet(()->{newcustomer.setId(id);
        return customerRepository.save(newcustomer);});


    }

    @Override
    public void deleteAll(){customerRepository.deleteAll();}
}
