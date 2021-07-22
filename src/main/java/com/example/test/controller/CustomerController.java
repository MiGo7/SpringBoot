package com.example.test.controller;

import com.example.test.dto.CustomerDTO;
import com.example.test.model.Customers;
import com.example.test.repository.CustomersRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * CustomerController for customers operation
 */
@RestController
public class CustomerController {


    @Autowired
    private CustomersRepository customersRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/customers")
    public List<CustomerDTO> getAllCustomerData() {

        List<Customers> customersList = customersRepository.findAll();

        List<CustomerDTO> customers = customersList.stream().map(customer -> {
            CustomerDTO customerDTO = new CustomerDTO();
            modelMapper.map(customer, customerDTO);
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return customerDTO;
        }).collect(Collectors.toList());

        return customers;
    }

    @GetMapping("/customer/{customerid}")
    public CustomerDTO getCustomer(@PathVariable int customerid) {

        Customers customer = customersRepository.findByCustomerid(customerid);

        CustomerDTO customerDTO = new CustomerDTO();
        modelMapper.map(customer, customerDTO);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return customerDTO;
    }


}