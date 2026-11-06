class Solution {
    public static final int ALPHABET_SIZE = 26;

    static class Key {
        private final short[] charMap;

        public Key(short[] charMap) {
            this.charMap = charMap;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.deepEquals(charMap, key.charMap);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(charMap);
        }
    }

    // Groups by letter counts, without sorting; see the README for complexity.
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Key, List<String>> groups = new HashMap<>();
        for(var str: strs) {
            short[] charMap = charMap(str);
            final Key key = new Key(charMap);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        final List<List<String>> result = new ArrayList<>();
        for (var entry: groups.entrySet()) {
            var value = entry.getValue();
            result.add(value);
        }
        return result;
    }

    private short[] charMap(String s) {
        short[] charMap = new short[ALPHABET_SIZE];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            charMap[index]++;
        }
        return charMap;
    }
}
