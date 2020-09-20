/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.


Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false

Example 5:

Input: "{[]}"
Output: true


 */
import java.util.HashMap;
import java.util.Stack;
public class ValidParentheses {
    private HashMap<Character, Character> mappings;

    public ValidParentheses(){
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');

    }

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>(); //initialize stack

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            //if the current character is a closing bracket.
            if(this.mappings.containsKey(c)){
                // retrieve element at top of stack
                // if the stack is empty set value to '#'
                char top_element = stack.empty() ? '#' : stack.pop();

                // if the mapping for this bracket does NOT match the stack's
                // top element, then return false
                if(top_element != this.mappings.get(c)){
                    return false;
                }
            }
            else{
                // if it was an opening bracket, push to the stack
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
