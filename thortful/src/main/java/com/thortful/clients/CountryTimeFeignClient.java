package com.thortful.clients;

import com.thortful.models.CountryAPI.Time;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "CountriesTime", url ="${country.time}")
public interface CountryTimeFeignClient {


    @GetMapping(value ="/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    Time getTime(@PathVariable String country);
}
