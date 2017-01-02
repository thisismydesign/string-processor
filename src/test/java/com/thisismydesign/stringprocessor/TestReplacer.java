package com.thisismydesign.stringprocessor;

class TestReplacer extends Replacer {

    @Override
    public String getReplacement(String string) {
        return string.toUpperCase();
    }
}
