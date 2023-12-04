package com.thortful.services;

import com.thortful.models.CountryAPI.CreateCountryRequestParams;
import com.thortful.models.CountryAPI.SummarizedCountryResponse;
import com.thortful.models.sql.Countries;
import org.springframework.http.ResponseEntity;


public interface CountriesService {

    SummarizedCountryResponse retrieveSummarizedCountryData(String name);

    ResponseEntity<Countries> createNewSummarizedCountryObject(CreateCountryRequestParams params);

    ResponseEntity<Countries> deleteCountryObject (String name);

    }
