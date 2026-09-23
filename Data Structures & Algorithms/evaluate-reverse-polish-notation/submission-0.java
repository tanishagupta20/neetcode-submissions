class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String op : tokens){
            if(op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*")){
                int ele1 = s.pop();
                int ele2 = s.pop();
                int result = 0;
                switch(op){
                    case "+":
                    result = ele1 + ele2;
                    break;
                    case "-":
                    result = ele2 - ele1;
                    break;
                    case "*":
                    result = ele1 * ele2;
                    break;
                    case "/":
                    result = ele2 / ele1;
                    break;
                }
                s.push(result);
            }
            else{
                s.push(Integer.parseInt(op));
            }
        }
        return s.pop();
    }
}