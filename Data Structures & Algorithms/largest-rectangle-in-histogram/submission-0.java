class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        Stack<Integer> leftSmaller = new Stack<>();

        for(int i = 0; i < heights.length; i++){
            while(!leftSmaller.isEmpty() && heights[leftSmaller.peek()] >= heights[i]){
                leftSmaller.pop();
            }

            if(leftSmaller.isEmpty()) left[i] = -1;
            else left[i] = leftSmaller.peek();

            leftSmaller.push(i);
        }

        int[] right = new int[heights.length];
        Stack<Integer> rightSmaller = new Stack<>();

        for(int i = heights.length - 1; i >= 0; i--){
            while(!rightSmaller.isEmpty() && heights[rightSmaller.peek()] >= heights[i]){
                rightSmaller.pop();
            }

            if(rightSmaller.isEmpty()) right[i] = heights.length;
            else right[i] = rightSmaller.peek();

            rightSmaller.push(i);
        }

        int largest = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++){
            largest = Math.max(largest, heights[i] * (right[i] - left[i] - 1));
        }

        return largest;
    }
}