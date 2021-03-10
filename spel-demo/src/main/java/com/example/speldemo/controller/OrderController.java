package com.example.speldemo.controller;


import com.example.speldemo.data.City;
import com.example.speldemo.data.Order;
import com.example.speldemo.data.Shipping;
import com.example.speldemo.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    Order order;

    @Autowired
    User user;

    @Autowired
    Shipping shipping;

    @Autowired
    City city;

    @GetMapping
    @RequestMapping(value="/customer")
    public String getCustomer(){
        return user.getName();
    }

    @GetMapping
    @RequestMapping(value="/amount")
    public double getOrderAmount(){
        return order.getAmount();
    }

    @GetMapping
    @RequestMapping(value="/discount")
    public double getDiscount(){
        return order.getDiscount();
    }

    @GetMapping
    @RequestMapping(value="/origin")
    public String getOrigin(){
        return order.getOrigin();
    }

    @GetMapping
    @RequestMapping(value="/deliver")
    public int getDaysToDeliver() {
        System.out.println(user.getCountry());
        System.out.println(user.getTimeZone());
        return order.getDaysToDeliver();
    }

    @GetMapping
    @RequestMapping(value="/amount/formatted")
    public String getFormattedOrderAmount() {
        return order.getFormattedAmount();
    }

    @GetMapping
    @RequestMapping(value="/shipping/locations")
    public List<City> getShippingLocations() {
        return order.getShippingLocations();
    }

    @GetMapping
    @RequestMapping(value="/shipping/locations/noncapital")
    public List<City> getNonCapitalShippingLocations() {
        return order.getNonCapitalShippingLocations();
    }

    @GetMapping
    @RequestMapping(value="/shipping/locations/western")
    public Map<String, List<City>> getWesternShippingLocations() {
        return order.getWesternShippingLocations();
    }

    @GetMapping
    @RequestMapping(value="/shipping/locations/noofcheaplocations")
    public Integer getNoOfCheapLocations() {
        return order.getNoOfCheapShippingLocations();
    }

    @GetMapping
    @RequestMapping(value="/orderSummary")
    public String getOrderSummary() {
        return order.getOrderSummary();
    }




}
