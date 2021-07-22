package com.example.test.repository;

import com.example.test.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

    Customers findByCustomerid(int customerid);
}
