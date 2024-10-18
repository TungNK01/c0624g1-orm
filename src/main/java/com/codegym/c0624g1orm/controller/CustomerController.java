package com.codegym.c0624g1orm.controller;

import com.codegym.c0624g1orm.model.Customer;
import com.codegym.c0624g1orm.service.HibernateCustomerService;
import com.codegym.c0624g1orm.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private ICustomerService customerService = new HibernateCustomerService();

    @GetMapping("")
    public String getAllCustomers(Model model) {
        // Call service to retrieve all customers
        // Pass retrieved data to view
        List<Customer> customers = customerService.findAll();
        // Set data to model attribute
        model.addAttribute("customers", customers);

        // Return view name

        return "/index";
    }

}
