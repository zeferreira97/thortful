package com.thortful.models.pokemonApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Builder
@AllArgsConstructor
@Data
@Validated
public class Pokemon {


    @JsonProperty("name")
    private String name;

    @JsonProperty("order")
    private Integer order;
}
