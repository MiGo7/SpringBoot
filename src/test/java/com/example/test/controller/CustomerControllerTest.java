package com.example.test.controller;

import com.example.test.dto.CustomerDTO;
import com.example.test.model.Customers;
import com.example.test.model.Orders;
import com.example.test.repository.CustomersRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Mock
    private CustomersRepository customersRepository;

    @InjectMocks
    private CustomerController undertest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetAllCustomerData() {

        when(customersRepository.findAll()).thenReturn(expectedCustomers());

        List<CustomerDTO> allCustomerData = undertest.getAllCustomerData();
        assertEquals(allCustomerData.get(0).getCountry(), "COUNTRY");
        assertEquals(allCustomerData.get(0).getCustomername(), "NAME");
        assertEquals(allCustomerData.get(0).getCustomerid(), 101);
        assertEquals(allCustomerData.get(0).getOrders().get(0).getDescription(), "ORDER1");
        assertEquals(allCustomerData.get(0).getOrders().get(0).getOrderid(), 1);
    }

    @Test
    public void testGetCustomer() {

        when(customersRepository.findByCustomerid(101)).thenReturn(expectedCustomer());

        CustomerDTO customer = undertest.getCustomer(101);
        assertEquals(customer.getCustomerid(), 101);
        assertEquals(customer.getCustomername(), "NAME");
        assertEquals(customer.getCountry(), "COUNTRY");
        assertEquals(customer.getOrders().get(0).getOrderid(), 1);
        assertEquals(customer.getOrders().get(0).getDescription(), "ORDER1");
    }

    private List<Customers> expectedCustomers() {

        List<Customers> customersList = new ArrayList<>();
        Customers customer = new Customers(101, "NAME", "COUNTRY", getOrders());
        customersList.add(customer);

        return customersList;
    }

    private List<Orders> getOrders() {
        List<Orders> orders = new ArrayList<>();
        Orders order = new Orders(1, "ORDER1");
        orders.add(order);
        return orders;
    }

    private Customers expectedCustomer() {
        return new Customers(101, "NAME", "COUNTRY", getOrders());
    }
}
