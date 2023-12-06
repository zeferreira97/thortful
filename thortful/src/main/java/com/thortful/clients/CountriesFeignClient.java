package com.thortful.clients;

import com.thortful.models.base.BaseCountry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;

@FeignClient(name= "Countries", url ="${countries.baseUrl}")
public interface CountriesFeignClient {


    @GetMapping(value ="/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArrayList<BaseCountry> getCountry(@PathVariable String name);
}
