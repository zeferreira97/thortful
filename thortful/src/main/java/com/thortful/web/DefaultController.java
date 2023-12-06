package com.thortful.web;


import com.thortful.Exceptions.ResourceNotFoundException;
import com.thortful.clients.CountriesFeignClient;
import com.thortful.clients.CountryTimeFeignClient;
import com.thortful.models.CountryAPI.CreateCountryRequestParams;
import com.thortful.models.CountryAPI.SummarizedCountryResponse;
import com.thortful.models.CountryAPI.Time;
import com.thortful.models.CountryAPI.UpdateCountryRequestParams;
import com.thortful.models.base.BaseCountry;
import com.thortful.models.sql.Countries;
import com.thortful.models.sql.CountryRepository;
import com.thortful.services.CountriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;

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

    @Autowired
    private CountryRepository countryRepository;


    @GetMapping(value ="/allData/{country}")
    @Operation(summary = "Add new Country to db")
    public ArrayList<BaseCountry> retrieveCountryData(@PathVariable @Parameter(name ="countryName", example = "Portugal", required = true) String country){

        return countriesFeignClient.getCountry(country);
    }


    @GetMapping(value ="/summarizedData/{country}")
    @Operation(summary = "Add new Country to db")
    public SummarizedCountryResponse retrieveSummarizedCountryData(@PathVariable @Parameter(name ="countryName", example = "Portugal", required = true) String country){

        return countriesService.retrieveSummarizedCountryData(country);
    }

    @PostMapping(value ="/create")
    @Operation(summary = "Add new Country to db")
    public ResponseEntity<Countries> createCountry(@RequestBody @Valid CreateCountryRequestParams params){

        return countriesService.createNewSummarizedCountryObject(params);
    }


    @DeleteMapping(value ="/delete/{country}")
    @Operation(summary = "Add new Country to db")
    public ResponseEntity<Countries> deleteCountry(@PathVariable @Parameter(name ="countryName", example = "Portugal", required = true) String country){

        if(!isNull(countryRepository.findByName(country))){
            return countriesService.deleteCountryObject(country);
        }else{
            throw new ValidationException("Country doesn't exist!");
        }
    }

    @GetMapping(value ="/time/{country}")
    @Operation(summary = "Get the current time from a choosen country")
    public Time getCityTime(@PathVariable @Parameter(name ="country", example= "Lisbon", required = true) String country){
        return countryTimeFeignClient.getTime(country);
    }

    @GetMapping(value ="/dbCountry/{country}")
    @Operation(summary = "Get the current time from a choosen country")
    public Countries getCountryFromDB(@PathVariable @Parameter(name ="country", example= "Lisbon", required = true) String country){

        if(!isNull(countryRepository.findByName(country))){
           return countryRepository.findByName(country);
        }else{
            throw new ValidationException("Country wasn't created yet!");
        }
    }


    @GetMapping(value ="/dbCountry/all")
    @Operation(summary = "Get the current time from a choosen country")
    public List<Countries> getAllCountries() throws ResourceNotFoundException {

        return countriesService.getAllCountries();
    }


    @PostMapping(value ="/update/{country}")
    @Operation(summary = "Update existing Country")
    public ResponseEntity<Countries> updateCountry(@RequestBody @Valid UpdateCountryRequestParams params, @PathVariable @Parameter(name ="countryName", example = "Portugal", required = true) String country){

        return countriesService.updateCountry(params,country);
    }
}
