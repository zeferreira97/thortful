package com.thortful.web;


import com.thortful.clients.CountriesFeignClient;
import com.thortful.clients.CountryTimeFeignClient;
import com.thortful.models.CountryAPI.CreateCountryRequestParams;
import com.thortful.models.CountryAPI.SummarizedCountryResponse;
import com.thortful.models.CountryAPI.Time;
import com.thortful.models.base.BaseCountry;
import com.thortful.models.sql.Countries;
import com.thortful.services.CountriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Validated
@RestController
@RequestMapping("/country")
public class DefaultController {

    @Autowired
    private CountriesFeignClient countriesFeignClient;

    @Autowired
    private CountryTimeFeignClient countryTimeFeignClient;

    @Autowired
    private CountriesService countriesService;


    @GetMapping(value ="/getAllData/{name}")
    @Operation(summary = "Add new Country to db")
    public ArrayList<BaseCountry> retrieveCountryData(@PathVariable @Parameter(name ="countryName", example = "Portugal", required = true) String name){

        return countriesFeignClient.getCountry(name);
    }


    @GetMapping(value ="/getSummarizedData/{name}")
    @Operation(summary = "Add new Country to db")
    public SummarizedCountryResponse retrieveSummarizedCountryData(@PathVariable @Parameter(name ="countryName", example = "Portugal", required = true) String name){

        return countriesService.retrieveSummarizedCountryData(name);
    }

    @PostMapping(value ="/create")
    @Operation(summary = "Add new Country to db")
    public ResponseEntity<Countries> createCountry(@RequestBody @Valid CreateCountryRequestParams params){

        return countriesService.createNewSummarizedCountryObject(params);
    }


    @DeleteMapping(value ="/delete/{name}")
    @Operation(summary = "Add new Country to db")
    public ResponseEntity<Countries> deleteCountry(@PathVariable @Parameter(name ="countryName", example = "Portugal", required = true) String name){

        return countriesService.deleteCountryObject(name);
    }


    @GetMapping(value ="/time/{country}")
    @Operation(summary = "Get the current time from a choosen country")
    public Time getCityTime(@PathVariable @Parameter(name ="country", example= "Lisbon", required = true) String country){
        return countryTimeFeignClient.getTime(country);
    }
}
