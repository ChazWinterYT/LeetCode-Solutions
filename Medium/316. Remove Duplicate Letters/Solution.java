class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> count = new HashMap<>();
        Set<Character> set = new HashSet<>();

        // first pass through the string, to gather frequency count
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }

        // second pass to do other stuff
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.get(s.charAt(i)) - 1);
            if (set.contains(s.charAt(i))) continue;

            while (!stack.isEmpty() && s.charAt(i) < stack.peek()
                    && count.get(stack.peek()) > 0) {
                set.remove(stack.pop());
            }
            stack.push(s.charAt(i));
            set.add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}