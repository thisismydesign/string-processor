package com.thisismydesign.stringprocessor;

import java.util.Collection;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class supports {@link String} operations
 */
public class StringProcessor {

    /**
     * Determines if {@code line} contains any of {@code keyWords}.
     *
     * @param keyWords keywords to be searched
     * @param line line to be searched in
     * @return true if any of {@code keyWords} is found in {@code line}, false otherwise
     */
    public static boolean containsAny(String[] keyWords, String line) {
        for (String keyWord : keyWords) {
            if (line.contains(keyWord)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get a {@code line} out of {@code lines} that has any of {@code keyWords} in it.
     *
     * @param keyWords keywords to be searched
     * @param lines lines to be searched in
     * @return a {@code line} that has any of {@code keyWords} in it. If none has returns null
     */
    public static String findAny(String[] keyWords, Collection<String> lines) {
        Optional<?> found = lines.stream().filter(line -> containsAny(keyWords, (String)line)).findAny();
        return found.isPresent() ? (String) found.get() : null;
    }

    /**
     * Replaces occurrences of all {@code patterns} in {@code string} using {@code replacer}.
     *
     * <p>Creates new String object, does not modify the original.
     * Custom {@link Replacer} can be created by extending it and overriding {@link Replacer#getReplacement(String)}.
     *
     * @param string string subject to possible replacements
     * @param patterns array of patterns to look for in string
     * @param replacer {@link Replacer} object used to get replacement when a match is found
     * @return new string with {@code patterns}' occurrences replaced
     */
    public static String replaceAll(String string, Pattern[] patterns, Replacer replacer) {
        String replaced = string;

        for (Pattern pattern : patterns) {
            replaced = replace(replaced, pattern, replacer);
        }

        return replaced;
    }

    /**
     * Replaces occurrences of {@code pattern} in {@code string} using {@code replacer}.
     *
     * <p>Creates new String object, does not modify the original.
     * Custom {@link Replacer} can be created by extending it and overriding {@link Replacer#getReplacement(String)}.
     *
     * @param string string subject to possible replacements
     * @param pattern pattern to look for in string
     * @param replacer {@link Replacer} object used to get replacement when a match is found
     * @return new string with {@code pattern}'s occurrences replaced
     */
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
