package com.kinopoisk.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<String, String> queryToMap(String query) {
        if (query == null || query.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            }
        }

        return result;
    }

    public static String convertAddressLineQueryWhitespace(String addressLineQuery) {
        return addressLineQuery == null ? "" : addressLineQuery.replaceAll("%20", " ");
    }
}

