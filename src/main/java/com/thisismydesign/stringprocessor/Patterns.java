package com.thisismydesign.stringprocessor;

import java.util.regex.Pattern;

/**
 * This class contains useful regular expressions.
 */
public final class Patterns {
    private Patterns(){}

    public final static Pattern pipe = Pattern.compile("\\|");
    public final static Pattern snortSpecial = Pattern.compile("[\";\\\\]");
    public final static Pattern nonASCII = Pattern.compile("[^\\p{InBasic_Latin}]");
    public final static Pattern controlOrWhiteSpaceExceptSpace = Pattern.compile("[\\p{C}\\p{Z}&&[^ ]]");
}
