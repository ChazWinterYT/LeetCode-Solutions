class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        //generate each row of pascals triangle in place
        for (int i = 0; i <= rowIndex; i++) {
            result.add(1); //first number is always 1
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j-1));
                //(1, 2, 1) becomes (1, 3, 3, 1) by appending a 1 to the end
                //(1, 2, 1, 1), and then setting index j to (sum of index j and j-1)
            }
        }
        return result;
    }
}