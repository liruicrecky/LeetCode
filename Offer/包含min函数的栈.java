import java.util.Stack;

public class Solution {

    Stack<Integer> s = new Stack<>();
    int min = 0;
    
    public void push(int node) {
        if (s.isEmpty()) {
            s.push(node);
            min = node;
        } else {
            if (node < min) {
                s.push(min);
                min = node;
            } 
            s.push(node);
        }
    }
    
    public void pop() {
        int t = s.pop();
        if (t == min) {
            min = s.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int min() {
        return min;
    }
}