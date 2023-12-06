package com.thortful.models.sql;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Table(name = "Countries")
public class Countries {

    @Id
    @Column(name= "name", nullable = false, columnDefinition = "varchar(255) default 'Teste'")
    private String name;

    @Column(name = "flag", nullable = false, columnDefinition = "varchar(255) default 'Teste'")
    private String flag;

    @ElementCollection(targetClass = String.class)
    @Column(name = "capital", nullable = false, columnDefinition = "varchar(255) default 'Teste'")
    private List<String> capital= new ArrayList<>();

    @ElementCollection(targetClass = String.class)
    @Column(name = "continents", nullable = false)
    private List<String> continents= new ArrayList<>();

    @Column(name = "area", nullable = false, columnDefinition = "double default 00.00")
    private Double area;

    @ElementCollection(targetClass = String.class)
    @Column(name = "currencies", nullable = false, columnDefinition = "varchar(255) default 'Teste'")
    private List<String> currencies= new ArrayList<>();

    @ElementCollection(targetClass = String.class)
    @Column(name = "languages", nullable = false, columnDefinition = "varchar(255) default 'Teste'")
    private List<String> languages= new ArrayList<>();

    @Column(name = "population", nullable = false, columnDefinition = "int default 0")
    private Integer population;

    @Column(name = "iso", nullable = false, columnDefinition = "varchar(255) default 'Teste'")
    private String iso;

    @Column(name = "pokemon", columnDefinition = "varchar(255) default 'Teste'")
    private String pokemon;
}
