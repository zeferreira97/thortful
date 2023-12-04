package com.thortful.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thortful.models.CountryAPI.CreateCountryRequestParams;
import com.thortful.models.CountryAPI.SummarizedCountryResponse;
import com.thortful.models.base.BaseCountry;
import com.thortful.models.sql.Countries;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface CountriesService {

    SummarizedCountryResponse retrieveSummarizedCountryData(String name);

    ResponseEntity<Countries> createNewSummarizedCountryObject(CreateCountryRequestParams params);

    ResponseEntity<Countries> deleteCountryObject (String name);


    }
