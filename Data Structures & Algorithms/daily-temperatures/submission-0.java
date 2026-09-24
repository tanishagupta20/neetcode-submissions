class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int results[] = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            while(!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) results[s.peek()] = i - s.pop();
            s.push(i);
        }

        return results;
    }
}


