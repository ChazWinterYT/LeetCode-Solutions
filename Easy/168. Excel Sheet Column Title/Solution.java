class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // Decrement columnNumber first to make it 0-indexed
            sb.append((char)('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        // Reverse the string at the end because we've been appending characters in reverse order
        return sb.reverse().toString(); 
    }
}