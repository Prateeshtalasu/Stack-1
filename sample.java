// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> monostack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int currnum = nums[i % n];
            while (!monostack.isEmpty() && currnum > nums[monostack.peek()]) {
                int previndex = monostack.pop();
                result[previndex] = currnum;
            }
            // We only need to push indices from the first round.
            if (i < n) {
                monostack.push(i % n);
            }
        }
        return result;
    }
}

//
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int n = temperatures.length;

        int[] result = new int[n];
        Stack<Integer> monostack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int currtemp = temperatures[i];
            while (!monostack.isEmpty() && currtemp > temperatures[monostack.peek()]) {
                int previndex = monostack.pop();
                result[previndex] = i - previndex;
            }
            monostack.push(i);
        }
        return result;
    }
}