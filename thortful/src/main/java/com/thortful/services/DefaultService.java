package com.thortful.services;

import com.thortful.clients.CountriesFeignClient;

import com.thortful.models.CountryAPI.CreateCountryRequestParams;
import com.thortful.models.CountryAPI.SummarizedCountryResponse;
import com.thortful.models.base.BaseCountry;
import com.thortful.models.sql.Countries;
import com.thortful.models.sql.CountryRepository;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;

import static com.thortful.utils.IsoUtil.isValidISOCountry;


@Service
@RequiredArgsConstructor
@Slf4j
@Validated
public class DefaultService implements CountriesService {

    @Autowired
    private CountriesFeignClient countriesFeignClient;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public ResponseEntity<Countries> createNewSummarizedCountryObject (CreateCountryRequestParams params){

        Countries countries = new Countries();

            countries.setName(params.getName());
            countries.setFlag(params.getFlag());
            countries.setArea(params.getArea());
            countries.setPopulation(params.getPopulation());
            countries.setLanguages(params.getLanguages());
            countries.setCapital(params.getCapital());
            countries.setContinents(params.getContinents());
            countries.setCurrencies(params.getCurrencies());
            countries.setIso(params.getIso());


        if(!isValidISOCountry(countries.getIso())){
            throw new ValidationException("The inserted country is not valid!");
        }

        countryRepository.save(countries);

        return ResponseEntity.status(HttpStatus.CREATED).body(countries);
    }



    @Override
    public ResponseEntity<Countries> deleteCountryObject (String name){

        Countries countries = new Countries();

        countries.setName(name);

        countryRepository.delete(countries);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(countries);
    }


    @Override
    public SummarizedCountryResponse retrieveSummarizedCountryData (String name){

        try {
            ArrayList<BaseCountry> pais = countriesFeignClient.getCountry(name);

            return SummarizedCountryResponse.builder()
                    .name(pais.get(0).getName().getCommon())
                    .flag(pais.get(0).getFlag())
                    .area(pais.get(0).getArea())
                    .capital(pais.get(0).getCapital())
                    .continents(pais.get(0).getContinents())
                    .currencies(pais.get(0).getCurrencies())
                    .languages(pais.get(0).getLanguages())
                    .population(pais.get(0).getPopulation())
                    .iso(pais.get(0).getCca2())
                    .build();

        }catch(ValidationException e){
            throw new ValidationException();
        }
    }
}
