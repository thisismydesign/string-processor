package com.thisismydesign.stringprocessor;

import java.util.Collection;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String replaceAll(String string, Pattern[] patterns, Replacer replacer) {
        String escaped = string;

        for (Pattern pattern : patterns) {
            escaped = replace(escaped, pattern, replacer);
        }

        return escaped;
    }

    public static String replace(String string, Pattern pattern, Replacer replacer) {
        Matcher matcher = pattern.matcher(string);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, replacer.getReplacement(matcher.group(0)));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
