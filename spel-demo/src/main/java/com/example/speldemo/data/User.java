package com.example.speldemo.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTimeZone() {
        return timeZone;
    }
    @Value("#{systemProperties['user.timezone']}")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Value("#{'Jonn Doe'}")
    private String name;
    @Value("#{30}")
    private int age;
    @Value("#{systemProperties['user.country']}")
    private String country;
    private String language;

    private String timeZone;

    public User(@Value("#{systemProperties['user.country']}") String country,
                @Value("#{systemProperties['user.language]}") String language) {
        this.country = country;
        this.language = language;
        System.out.println("in the user constructor with argument");
    }

    public User() {
        System.out.println("in no-arg user constructor");
    }
}
