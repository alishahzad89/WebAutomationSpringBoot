package com.cucumber.springboot.utils;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class FakeData {

    public Map<String,String> setOwnerDetails(){
        Faker faker = new Faker();
        Map<String,String> inputData = new HashMap<>();
        inputData.put("firstname",faker.name().firstName());
        inputData.put("lastname",faker.name().lastName());
        inputData.put("address",faker.address().streetName());
        inputData.put("city",faker.address().city());
        inputData.put("telephone","123456789");
        return inputData;
    }

    public Map<String,String> setPetDetails(String petType){
        Faker faker = new Faker();
        Map<String,String> inputData = new HashMap<>();
        inputData.put("petname",faker.name().firstName());
        inputData.put("petbirth","26/03/2022");
        inputData.put("pettype",petType);
        return inputData;
    }
}
