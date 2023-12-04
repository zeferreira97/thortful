package com.thortful.clients;

import com.thortful.models.base.BaseCountry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name= "Countries", url ="${countries.baseUrl}")
public interface CountriesFeignClient {


    @GetMapping(value ="/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArrayList<BaseCountry> getCountry(@PathVariable String name);
}
