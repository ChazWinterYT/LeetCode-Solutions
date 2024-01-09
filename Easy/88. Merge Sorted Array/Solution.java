class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //if nums2 is empty, do nothing
        if (n == 0) return;
        //if m starts out as 0, copy nums2 into nums1 and end the method
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        //start at the end of nums1
        int currentValue = nums1.length - 1;
        //compare the last value of nums2 with the last of nums1.
        //whichever is bigger, put it in the currentValue, then move to the next value in that array
        //do this until you reach the start of the nums1 array
        while (currentValue >= 0) {
            if (m > 0 && (n <= 0 || nums1[m-1] >= nums2[n-1])) { //minus 1 so the index is correct
                nums1[currentValue] = nums1[m-1];
                m--;
            } else if (n > 0 && (m <= 0 || nums1[m-1] < nums2[n-1])) {
                nums1[currentValue] = nums2[n-1];
                n--;
            }
            currentValue--;
        }
    }
}