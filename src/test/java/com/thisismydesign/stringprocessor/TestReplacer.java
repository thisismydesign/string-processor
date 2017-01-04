package com.thisismydesign.stringprocessor;

class TestReplacer implements Replacer {

    private String replacement;

    TestReplacer(String replacement) {
        this.replacement = replacement;
    }

    @Override
    public String getReplacement(String string) {
        return replacement;
    }
}
