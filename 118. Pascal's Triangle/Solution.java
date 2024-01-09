class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        //not technically needed, but deals with case where there is no triangle
        if (numRows == 0) return triangle;  

        //first row of Pascal's triangle is always just a 1
        firstRow.add(1);
        triangle.add(firstRow);

        //outer loop to build the triangle, inner loop to build the values in each row
        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = triangle.get(i-1);
            List<Integer> currentRow = new ArrayList<>();
            //first value of the row is always 1
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j-1) + previousRow.get(j));
            }
            //this stops one value short, but that's okay, because the last value is always 1
            currentRow.add(1);
            triangle.add(currentRow);
        }
        return triangle;
    }
}