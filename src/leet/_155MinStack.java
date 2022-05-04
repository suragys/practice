package leet;

import java.util.ArrayList;
import java.util.List;

/***
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 */
public class _155MinStack {

    private List<Integer> minStack;
    private List<Integer> stack;
    // constructor
    public _155MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    private void push(int val) {
        if(stack.size() == 0) {
            minStack.add(val);
        } else {
            minStack.add(minStack.get(minStack.size()-1), val);
        }
        stack.add(val);
    }

    private void pop() {
        stack.remove(stack.size()-1);
        minStack.remove(minStack.size()-1);
    }

    private int top() {
        int val = -1;
        if(!stack.isEmpty()) {
            val = stack.get(stack.size()-1);
        }
        return val;
    }

    private int getMin() {
        int val = -1;
        if(!minStack.isEmpty()) {
            val = minStack.get(minStack.size()-1);
        }
        return val;
    }
}
