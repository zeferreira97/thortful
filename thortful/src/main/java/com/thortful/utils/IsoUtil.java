package com.thortful.utils;

import java.util.Locale;
import java.util.Set;

public final class IsoUtil {
    private static final Set<String> ISO_COUNTRIES = Set.of(Locale.getISOCountries());

    private IsoUtil() {}

    public static boolean isValidISOCountry(String s) {
        return ISO_COUNTRIES.contains(s);
    }
}
