class Solution {

    private static final int NUM_STRINGS_CHARS = 2;
    private static final int LEN_STRINGS_CHAR = 3;

    public String encode(List<String> strs) {
        final StringBuilder sb = new StringBuilder();
        int n = strs.size();
        sb.append(toFixedWidthDigits(n, NUM_STRINGS_CHARS));
        for (String str: strs) {
            int len = str.length();
            sb.append(toFixedWidthDigits(len, LEN_STRINGS_CHAR));
            for (int i = 0 ; i < str.length(); i++) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        final List<String> strs = new ArrayList<>();
        char a = str.charAt(0);
        char b = str.charAt(1);
        int n = fromFixedWidthDigits(new char[] {a, b}, NUM_STRINGS_CHARS);
        int at = 2;
        for (int i = 0; i < n; i++) {
            final StringBuilder sb =  new StringBuilder();
            char x = str.charAt(at++);
            char y = str.charAt(at++);
            char z = str.charAt(at++);
            int m = fromFixedWidthDigits(new char[] {x, y, z}, LEN_STRINGS_CHAR);
            strs.add(str.substring(at, at + m));
            at += m;
        }
        return strs;
    }

    char[] toFixedWidthDigits(int n, int size) {
        if (n < 0) {
            throw new IllegalArgumentException("invalid value");
        }
        char[] value = new char[size];
        for (int i = size - 1; i >= 0; i--) {
            value[i] = (char) ('0' + n % 10);
            n /= 10;
        }
        if (n > 0) {
            throw new IllegalArgumentException("invalid value");
        }
        return value;
    }

    int fromFixedWidthDigits(char[] chars, int size) {
        int n = 0;
        for (int i = 0; i < size; i++) {
            n *= 10;
            n += chars[i] - '0';
        }
        return n;
    }
}
