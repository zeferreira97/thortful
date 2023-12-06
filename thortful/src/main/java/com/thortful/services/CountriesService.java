package com.thortful.services;

import com.thortful.Exceptions.ResourceNotFoundException;
import com.thortful.models.CountryAPI.CreateCountryRequestParams;
import com.thortful.models.CountryAPI.SummarizedCountryResponse;
import com.thortful.models.CountryAPI.UpdateCountryRequestParams;
import com.thortful.models.sql.Countries;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CountriesService {

    SummarizedCountryResponse retrieveSummarizedCountryData(String name);

    ResponseEntity<Countries> createNewSummarizedCountryObject(CreateCountryRequestParams params);

    ResponseEntity<Countries> updateCountry(UpdateCountryRequestParams params, String name);


    ResponseEntity<Countries> deleteCountryObject (String name);

    List<Countries> getAllCountries()throws ResourceNotFoundException;


    }
