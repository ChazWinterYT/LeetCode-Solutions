class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visitedWords = new HashSet<>();
        Queue<Word> words = new LinkedList<>();
        words.offer(new Word(beginWord, 1));
        visitedWords.add(beginWord);
        
        while (!words.isEmpty()) {
            Word currentWord = words.poll();

            for (String nextWord : wordList) {
                if (!visitedWords.contains(nextWord) && isAdjacent(currentWord.getWord(), nextWord)) {
                    /* If you actually find the target word, stop. */
                    if (nextWord.equals(endWord)) {
                        return currentWord.getLevel() + 1;
                    }
                    words.offer(new Word(nextWord, currentWord.getLevel() + 1));
                    visitedWords.add(nextWord);
                }
            }
        }
        return 0;   // No such sequence exists.
    }
    
    private boolean isAdjacent(String word1, String word2) {
        int differentLetters = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                differentLetters++;
            }
            if (differentLetters > 1) {
                return false; // Short circuit if two letters are different.
            }
        }
        return differentLetters == 1;
    }
}

class Word {
    private String word;
    private int level;
    
    public Word(String word, int level) {
        this.word = word;
        this.level = level;
    }
    
    public String getWord() {
        return this.word;
    }
    
    public int getLevel() {
        return this.level;
    }
}