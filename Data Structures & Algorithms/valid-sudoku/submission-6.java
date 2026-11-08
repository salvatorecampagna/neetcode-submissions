class Solution {

    class Charset {
        private boolean[] seen;
        
        public Charset() {
            this.seen = new boolean[10];
        }

        public boolean add(char digit) {
            if (digit == '.') {
                return false;
            }

            if (digit < '1' || digit > '9') {
                throw new IllegalArgumentException("invalid digit [" + digit + "]");
            }

            int index = digit - '0';
            boolean seen = this.seen[index];
            this.seen[index] = true;
            return seen;
        }

        public void clear() {
            Arrays.fill(this.seen, false);
        }
    }

    public boolean isValidSudoku(char[][] board) {
        final Charset seen = new Charset();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (seen.add(board[row][col])) {
                    return false;
                }
            }
            seen.clear();
        }

        for (int col = 0; col < 9; col++) {
            for (int row =0 ; row < 9; row++) {
                if (seen.add(board[row][col])) {
                    return false;
                }
            }
            seen.clear();
        }

        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                for (int row = 3 * boxRow; row < 3 * boxRow + 3; row++) {
                    for (int col = 3 * boxCol; col < 3 * boxCol + 3; col++) {
                        if (seen.add(board[row][col])) {
                            return false;
                        }
                    }
                }
                seen.clear();
            }
        }
        
        return true;
    }
}
