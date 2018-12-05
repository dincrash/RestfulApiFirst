package com.hello;

import com.entity.Customer;
import com.jpaRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomService customService;

    @RequestMapping("/hello/{id}")
    public Customer one(@PathVariable long id) {
        return customService.getCustomerId(id);

    }

    @RequestMapping("/hello")
    public List<Customer> all() {
        return customService.getAllCustomer();

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        customService.deleteCustomer(id);
    }

    @PostMapping("/hello")
    public Customer newOne(@RequestBody Customer customer) {
        return customService.addCustomer(customer);

    }

    @PutMapping("/update/{id}")
    public Customer updateCustomer(@RequestBody Customer customer,@PathVariable long id){
        return customService.updateCustomer(customer,id);

    }
    @DeleteMapping("/delete")
    public void deleteAll(){customService.deleteAll();}
}