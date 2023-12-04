package com.thortful.models.sql;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Countries, String> {
}
