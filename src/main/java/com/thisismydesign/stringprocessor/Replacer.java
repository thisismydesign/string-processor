package com.thisismydesign.stringprocessor;

public class Replacer {
    private String replacement;

    public Replacer(){}

    public Replacer(String replacement) {
        this.replacement = replacement;
    }

    public String getReplacement(String string) {
        return replacement;
    }
}
