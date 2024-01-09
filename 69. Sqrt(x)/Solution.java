class Solution {
    public int mySqrt(int x) {
        //edge case, if x is 0, just return 0
        if (x == 0) return 0;
        //create two pointers for a binary search from 1 to x
        int left = 1; int right = x;
        //find the midpoint, and use that as the test value
        int middle = (left + right) / 2;
        while (left != right) {
            //if the test value passes, return it
            if (middle * middle == x) {
                return middle;
            //if you get a value too large, move the right pointer to where 
            //the middle was, and try again
            } else if (middle > x/middle) {
                right = middle - 1;
            } else { //middle squared is less than x
                //if middle + 1 is too large, then we found our number
                if ((middle + 1) > x/(middle+1)) return middle;
                //otherwise, set the left pointer to the middle and try again
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return left;
    }
}