class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if ((i + 1) % 15 == 0) {
                answer.add(i, "FizzBuzz");
            }   else if ((i + 1) % 5 == 0) {
                answer.add(i, "Buzz");
            }   else if ((i + 1) % 3 == 0) {
                answer.add(i, "Fizz");
            }   else {
                answer.add(i, String.valueOf(i+1));
            }
        }

        return answer;
    }
}