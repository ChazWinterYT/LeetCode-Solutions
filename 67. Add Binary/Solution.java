class Solution {
    public String addBinary(String a, String b) {
        //create a StringBuilder object to store the answer
        StringBuilder sb = new StringBuilder();

        //create pointers for each string, and a carry bit variable
        int aPointer = a.length() - 1; 
        int bPointer = b.length() - 1; 
        int carry = 0;
        
        //perform a loop while either string still has values to assess
        while (aPointer >= 0 || bPointer >= 0) {
            int sum = carry;
            //add the current bit of each string, as long as the string still has values to assess
            //subtract '0' from each charAt so that we get the actual int value, not the ASCII value
            if (aPointer >= 0) sum += a.charAt(aPointer) - '0';
            if (bPointer >= 0) sum += b.charAt(bPointer) - '0';
            
            //decrement the pointers so they can evaluate the next bit
            aPointer--; bPointer--;
            
            //append the sum (mod 2, so 2 becomes 0) to the StringBuilder
            sb.append(sum % 2);
            //set the carry bit to 1 (2 divided by 2) if the previous sum was 2
            carry = sum / 2;
        }
        //if there is still a carry bit when the loop is complete, append an extra 1
        if (carry == 1) sb.append(carry);
        //reverse the StringBuilder object and return it as a String!
        return sb.reverse().toString();
    }
}