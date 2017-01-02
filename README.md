# StringProcessor

### Utility that supports common String operations

### API

#### public static boolean containsAny(String[] keyWords, String line)

Returns if any 'keyWords' is present in 'line'.

#### public static String findAny(String[] keyWords, Collection<String> lines)

Returns 'line' that has any of 'keyWords' in it. Otherwise returns null.

#### public static String replace(String string, Pattern pattern, Replacer replacer)

Replaces occurrences of 'pattern' in 'string' using 'replacer'. Creates new String object, does not modify the original. Custom Replacer can be crated by extending and overriding 'String getReplacement(String string)'.

#### public static String replaceAll(String string, Pattern[] patterns, Replacer replacer)

Replaces occurrences of all 'patterns' in 'string' using 'replacer'. Creates new String object, does not modify the original. Custom Replacer can be crated by extending and overriding 'String getReplacement(String string)'.

#### public final class Patterns

Contains useful regular expressions.
