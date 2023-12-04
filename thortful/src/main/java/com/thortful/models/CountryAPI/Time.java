package com.thortful.models.CountryAPI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Builder
@AllArgsConstructor
@Data
@Validated
public class Time {

    @JsonProperty("abbreviation")
    private String abbreviation;

    @JsonProperty("datetime")
    private String datetime;

    @JsonProperty("day_of_week")
    private String day_of_week;

    @JsonProperty("week_number")
    private String week_number;

    @JsonProperty("day_of_year")
    private String day_of_year;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("utc_offset")
    private String utc_offset;

}
