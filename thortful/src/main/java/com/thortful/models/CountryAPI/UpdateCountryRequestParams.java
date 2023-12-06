package com.thortful.models.CountryAPI;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
@Validated
public class UpdateCountryRequestParams {

    private List<String> capital;

    private List<String> currencies;

    private List<String> languages;

    private Integer population;
}
