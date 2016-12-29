# StringProcessor

### Utility that supports common String operations

### API

#### public static boolean containsAny(String[] keyWords, String line)

Returns if any 'keyWords' is present in 'line'.

#### public static String findAny(String[] keyWords, Collection<String> lines)

Returns 'line' that has any of 'keyWords' in it. Otherwise returns null.
