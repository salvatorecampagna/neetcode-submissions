class Solution {
    public static final int ALPHABET_SIZE = 26;

    static class Key {
        private final short[] counts;
        private final int hash;

        public Key(short[] counts) {
            this.counts = counts;
            this.hash = Arrays.hashCode(counts);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return hash == key.hash && Arrays.equals(counts, key.counts);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(hash);
        }
    }

    // Groups by letter counts, without sorting; see the README for complexity.
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Key, List<String>> groups = new HashMap<>();
        for(var str: strs) {
            short[] charMap = counts(str);
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

    private short[] counts(String s) {
        short[] counts = new short[ALPHABET_SIZE];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            counts[index]++;
        }
        return counts;
    }
}
