class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        wordChecker: 
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int shorterWord = Math.min(word1.length(), word2.length());

            for (int j = 0; j < shorterWord; j++) {
                int word1Letter = order.indexOf(word1.charAt(j));
                int word2Letter = order.indexOf(word2.charAt(j));
                if (word1Letter == word2Letter) {
                    continue;
                } else if (word1Letter > word2Letter) {
                    return false;
                } else { //word1Letter is before word2Letter
                    continue wordChecker;
                }
            }
            //if the loop completes, then the words share the same prefix
            //make sure the shorter one came first
            if (word1.length() > word2.length()) return false;
            continue wordChecker;
        }
        //if the wordChecker survives, then the dictionary is verified
        return true;
    }
}