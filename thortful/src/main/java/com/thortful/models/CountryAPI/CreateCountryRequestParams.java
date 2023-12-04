package com.thortful.models.CountryAPI;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
@Validated
public class CreateCountryRequestParams{


    @NotNull(message = "Field name can't be null") @NotEmpty
    private String name;

    @NotNull(message = "Field flag can't be null") @NotEmpty
    private String flag;

    @NotNull(message = "Field capital can't be null") @NotEmpty
    private List<String> capital;

    @NotNull(message = "Field continents can't be null") @NotEmpty
    private List<String> continents;

    @NotNull(message = "Field area can't be null")
    private Double area;

    @NotNull(message = "Field currencies can't be null") @NotEmpty
    private List<String> currencies;

    @NotNull(message = "Field languages can't be null") @NotEmpty
    private List<String> languages;

    @NotNull(message = "Field population can't be null")
    private Integer population;

    @NotNull(message = "Field iso can't be null") @NotEmpty
    private String iso;
}
