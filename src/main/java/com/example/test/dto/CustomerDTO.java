package com.example.test.dto;

import java.util.List;

/**
 * CustomerDTO object for Customer entity
 */
public class CustomerDTO {

    private int customerid;
    private String customername;
    private String country;
    private List<OrdersDTO> orders;

    public List<OrdersDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersDTO> orders) {
        this.orders = orders;
    }


    public CustomerDTO() {
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
