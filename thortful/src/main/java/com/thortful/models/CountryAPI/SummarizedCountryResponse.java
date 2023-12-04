package com.thortful.models.CountryAPI;

import com.thortful.models.base.Currency;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Builder
@Data
public class SummarizedCountryResponse implements Serializable {

    private String name;
    private String flag;
    private List<String> capital;
    private List<String> continents;
    private Double area;
    private Map<String, Currency> currencies;
    private Map<String, String> languages;
    private Integer population;
    private String iso;
}
