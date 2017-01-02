package com.thisismydesign.stringprocessor;

import java.util.regex.Pattern;

public final class Patterns {
    private Patterns(){}

    public final static Pattern pipe = Pattern.compile("\\|");
    public final static Pattern special = Pattern.compile("[\";\\\\]");
    public final static Pattern nonASCII = Pattern.compile("[^\\p{InBasic_Latin}]");
    public final static Pattern specialOrWhiteSpaceExceptSpace = Pattern.compile("[\\p{C}\\p{Z}&&[^ ]]");
}
