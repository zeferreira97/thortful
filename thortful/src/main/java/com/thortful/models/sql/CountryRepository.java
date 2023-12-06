package com.thortful.models.sql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Countries, String> {


    Countries findByName(String name);
}
