package com.thortful.clients;

import com.thortful.models.pokemonApi.Pokemon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "Pokemon", url ="${pokemon.baseUrl}")
public interface PokemonFeignClient {


    @GetMapping(value ="/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    Pokemon getPokemon(@PathVariable Integer number);
}
