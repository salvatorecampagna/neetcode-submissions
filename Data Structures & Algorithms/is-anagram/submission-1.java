class Solution {

    public boolean isAnagram(String s, String t) {
        return isAnagramUsingTwoMaps(s, t);
    }

    boolean isAnagramUsingTwoMaps(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final Map<Character, Integer> sCharmap = charmap(s);
        final Map<Character, Integer> tCharmap = charmap(t);
        return sCharmap.equals(tCharmap);
    }

    boolean isAnagramBySorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        var sArray = s.toCharArray();
        Arrays.sort(sArray);
        var tArray = t.toCharArray();
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    boolean isAnagramUsingOneMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final Map<Character, Integer> charmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            charmap.merge(sChar, 1, Integer::sum);
        }
        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            int remaining = charmap.merge(tChar, -1, (oldValue, value) -> oldValue - 1);
            if (remaining < 0) {
                return false;
            }
        }
        return true;
    }

    boolean isAnagramUsingTwoCountArrays(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return Arrays.equals(charMapArray(s), charMapArray(t));
    }

    boolean isAnagramUsingOneCountArray(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final int[] charMapArray = charMapArray(s);
        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            int index = tChar - 'a';
            charMapArray[index]--;
            if (charMapArray[index] < 0) {
                return false;
            }
        }
        return true;
    }

    Map<Character, Integer> charmap(String s) {
        final Map<Character, Integer> charmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charmap.merge(c, 1, Integer::sum);
        }
        return charmap;
    }

    // Index c - 'a' holds the count of letter c. Only lowercase a–z is supported,
    // here and wherever the returned array is indexed: any other character
    // throws ArrayIndexOutOfBoundsException.
    int[] charMapArray(String s) {
        final int ALPHABET_SIZE = 26;
        int[] charMapArray = new int[ALPHABET_SIZE];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charMapArray[c - 'a']++;
        }
        return charMapArray;
    }
}