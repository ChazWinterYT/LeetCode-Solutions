class Solution {
    char[] arr;
    int index = 0;
    
    public int calculate(String s) {
        arr = s.toCharArray();
        return dfs();
    }
    
    private int dfs() {
        int sum = 0, operator = 1;
        while (index < arr.length) {
            if (arr[index] == ')') {
                break;
            } else if (arr[index] == '(') {
                index++;
                sum += operator * dfs();
            } else if (arr[index] == '-') {
                operator = -1;
            } else if (arr[index] == '+') {
                operator = 1;
            } else if (Character.isDigit(arr[index])) {
                // Check if the number is multi-digit
                StringBuilder sb = new StringBuilder();
                while (index < arr.length && Character.isDigit(arr[index])) {
                    sb.append(arr[index]);
                    index++;
                }
                // Go back one char when you find a non-digit
                index--;
                sum += Integer.parseInt(sb.toString()) * operator;
            }
            index++;
        }
        return sum;
    }
}