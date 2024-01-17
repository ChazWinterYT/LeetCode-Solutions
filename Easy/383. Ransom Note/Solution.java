class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        ArrayList<Character> magArray = new ArrayList<>();
        ArrayList<Character> ransomArray = new ArrayList<>();
        for (int i = 0; i < magazine.length(); i++) {
            magArray.add(magazine.charAt(i));
        }

        for (int i = 0; i < ransomNote.length(); i++){
            ransomArray.add(ransomNote.charAt(i));
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (magArray.contains(ransomNote.charAt(i))) {
                magArray.remove(ransomArray.get(i));
            }   else {
                return false;
            }
        }
        return true;
    }
}