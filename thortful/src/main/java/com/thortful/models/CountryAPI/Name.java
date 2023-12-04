package com.thortful.models.CountryAPI;

import com.thortful.models.CountryAPI.NativeName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Name {

    private String common;
    private String official;
    private NativeName nativeName;
}
