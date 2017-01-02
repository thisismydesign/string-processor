package com.thisismydesign.stringprocessor;

import org.junit.Test;

import static org.junit.Assert.*;

public class PatternsTest {

    @Test
    public void pipe() throws Exception {
        assertEquals(".", StringProcessor.replace("|", Patterns.pipe, new Replacer(".")));
    }

    @Test
    public void pipe_Multiple() throws Exception {
        assertEquals("..", StringProcessor.replace("||", Patterns.pipe, new Replacer(".")));
    }

    @Test
    public void pipe_MultipleWithText() throws Exception {
        assertEquals(".ab.c", StringProcessor.replace("|ab|c", Patterns.pipe, new Replacer(".")));
    }

    @Test
    public void special() throws Exception {
        assertEquals("...", StringProcessor.replace(";\"\\", Patterns.special, new Replacer(".")));
    }

    @Test
    public void nonASCII() throws Exception {
        assertEquals("hi.there", StringProcessor.replace("hiáthere", Patterns.nonASCII, new Replacer(".")));
    }

    @Test
    public void specialOrWhiteSpaceExceptSpace() throws Exception {
        assertEquals(".", StringProcessor.replace(Character.toString((char) 0), Patterns.specialOrWhiteSpaceExceptSpace, new Replacer(".")));
    }

    @Test
    public void specialOrWhiteSpaceExceptSpace_ShouldNotReplaceSpace() throws Exception {
        assertEquals("hi there", StringProcessor.replace("hi there", Patterns.specialOrWhiteSpaceExceptSpace, new Replacer(".")));
    }
}
