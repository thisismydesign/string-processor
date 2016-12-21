package com.thisismydesign.stringprocessor;

import java.util.Collection;
import java.util.Optional;

public class StringProcessor {
    public static boolean containsAny(String[] keyWords, String line) {
        for (String keyWord : keyWords) {
            if (line.contains(keyWord)) {
                return true;
            }
        }
        return false;
    }

    public static String findAny(String[] keyWords, Collection<String> lines) {
        Optional<?> found = lines.stream().filter(line -> containsAny(keyWords, (String)line)).findAny();
        return found.isPresent() ? (String) found.get() : null;
    }
}
