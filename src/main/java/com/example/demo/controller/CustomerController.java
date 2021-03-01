package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/data")
    public @ResponseBody Iterable<CustomerDTO> getDataCustomers() {
        List<CustomerDTO> customersList = new ArrayList<>();

        customerRepository.findAll().forEach(customer -> {
            CustomerDTO customerDTO = new CustomerDTO();

            customerDTO.setCustomerId(customer.getCustomer_id());
            customerDTO.setFullname(customer.getFirst_name() + " " + customer.getLast_name());
            customerDTO.setEmail(customer.getEmail());

            customersList.add(customerDTO);
        });

        return customersList;
    }
}
