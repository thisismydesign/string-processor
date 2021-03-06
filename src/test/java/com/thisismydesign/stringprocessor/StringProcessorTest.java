package com.thisismydesign.stringprocessor;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class StringProcessorTest {

    private static final String str = "Contains some keyword";
    private static final String keyword = "keyword";
    private static String[] keyWords;
    private static List<String> lines;

    @Before
    public void init() {
        lines = new ArrayList<>();
    }

    @Test
    public void containsAny_WhenContainsOne_ShouldReturnTrue() throws Exception {
        keyWords = new String[] {keyword};
        assertTrue(StringProcessor.containsAny(keyWords, str));
    }

    @Test
    public void containsAny_WhenContainsMany_ShouldReturnTrue() throws Exception {
        keyWords = new String[] {"some", keyword};
        assertTrue(StringProcessor.containsAny(keyWords, str));
    }

    @Test
    public void containsAny_WhenDoesNotContain_ShouldReturnFalse() throws Exception {
        keyWords = new String[] {"does not contain"};
        assertFalse(StringProcessor.containsAny(keyWords, str));
    }

    @Test
    public void containsAny_WhenContainsOneAndDoesNotContainAnother_ShouldReturnTrue() throws Exception {
        keyWords = new String[] {"does not contain", keyword};
        assertTrue(StringProcessor.containsAny(keyWords, str));
    }


    @Test
    public void findAny_WhenContainsKeyword_ShouldReturnContainingLine() throws Exception {
        String[] keyWords = new String[] {keyword};
        lines.add("some other line");
        lines.add(str);
        assertEquals(str, StringProcessor.findAny(keyWords, lines));
    }

    @Test
    public void findAny_WhenDoesNotContainKeyword_ShouldReturnNull() throws Exception {
        String[] keyWords = new String[] {keyword};
        lines.add("some other line");
        assertNull(StringProcessor.findAny(keyWords, lines));
    }

    @Test
    public void replace_WithCustomReplacer_ShouldReplaceMatchingPattern() throws Exception {
        assertEquals("!!!", StringProcessor.replace("aaa", Pattern.compile("a"), new TestReplacer("!")));
    }

    @Test
    public void replaceAll_WithCustomReplacer_ShouldReplaceAllMatchingPatterns() throws Exception {
        Pattern[] patterns = new Pattern[] {Pattern.compile("a"), Pattern.compile("b")};
        assertEquals("!!!!!!", StringProcessor.replaceAll("aaabbb", patterns, new TestReplacer("!")));
    }

    @Test
    public void replace_WithCustomReplacer_ShouldNotReplaceNonMatchingPattern() throws Exception {
        assertEquals("aaa", StringProcessor.replace("aaa", Pattern.compile("b"), new TestReplacer("!")));
    }

    @Test
    public void replace_OriginalObject_ShouldNotBeModified() throws Exception {
        String str = "aaa";
        StringProcessor.replace(str, Pattern.compile("a"), new TestReplacer("!"));
        assertEquals("aaa", str);
    }

}
