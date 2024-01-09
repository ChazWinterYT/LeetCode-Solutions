class Solution {
    public int[] plusOne(int[] digits) {
        //if the last element of the array is < 9, 
        //just add 1 and return the array
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        //check for 9s in each element starting from the back
        //if they are 9s, make them 0 until you don't find a 9
        //then increment that element by one and return the array
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
            digits[i] = 0;
            continue;
            }
            digits[i]++;
            return digits;
        }   //future challenge: can these two blocks above be combined?
        //if the loop survives until the end, then you have an array of all 0
        //create a new array with 1 extra element. make the first element 1
        //and the rest zero, and return it (so 9999 would become 10000)
        int[] extra = new int[digits.length + 1];
        extra[0] = 1;
        return extra;
    }
}